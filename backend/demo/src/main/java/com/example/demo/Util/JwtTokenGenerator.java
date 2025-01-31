package com.example.demo.Util;


import com.example.demo.Exception.CustomException;
import com.example.demo.Service.UserService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenGenerator {
    private static final String iss = "kl22965331";
    private static final String secretKey = "48810318725bc28d0b980c8abc6d4aa985951df11ff96883ac17bfc4d4cf9a2d6de810a3cadeb0b8c956dcba352cd0c91662f7d44429c7df40e6bdf1415db44a872ec140a060753ff946741dabf175731a22e57e6f5b1d7faa813899a425e8c5c23a74941e0ed661ad912fcfa43ab2aba65300c0e5faf256f0f40a9c3a191e012c91cbdba9ca8951d0f40ac50ca2e08c13daf671262d7c5b0d30287b95714cae7d02a7e27d7739379b841b5406d312d54d3f67b9bd021382f289e11b248f9d33d04e069927de0e905b71996a9dddeb1e32251bb14a85af6d8cc5b69bbfbe5ffa906373ac76a408b7c9c9108daa0509341b90bffcbe38c93beea5d5053850b57a";

    private UserService userService;
    private UserDetailsService userDetailsService;

    public JwtTokenGenerator() {
    }

    @Autowired
    public JwtTokenGenerator(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    public static String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }


    private static String createToken(Map<String, Object> claims, String username) {
        long expirationTimeInMillis = 1000 * 60 * 60 * 1;
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + expirationTimeInMillis);
        return Jwts.builder().setClaims(claims).setIssuedAt(now).setIssuer(iss).setSubject(username).setExpiration(expirationDate).signWith(Keys.hmacShaKeyFor(secretKey.getBytes())).compact();
    }
    public static String extractUsername(String token) {
        if(token.startsWith("Bearer ")){
            token=token.substring(7);
        }
        Claims claims = (Claims) Jwts.parserBuilder().setSigningKey(secretKey.getBytes()).build().parse(token).getBody();
        System.out.println("subject is:"+claims.getSubject());
        return claims.getSubject();
    }
    public static Boolean isTokenExpired(String token) {
        if(token.startsWith("Bearer ")){
            token=token.substring(7);
        }
        Date date = extractExpiration(token);
        return !date.before(new Date());
    }


    private static Date extractExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }
    public  Boolean isTokenValid(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        final String tempToken=token;
        final String username = extractUsername(new String(tempToken));
        if(isTokenExpired(new String(tempToken))){
            throw new CustomException(401,"登入已過期");
        }
        return (!username.equals(null) && userService.isUsernamePresent(username)  && isIssuerValid(extractIssuer(new String(tempToken))));
    }


    public  Boolean isTokenValid(String token) {
        final String tempToken=token;
        final String username = extractUsername(new String(tempToken));
        return (!username.equals(null) && userService.isUsernamePresent(username) && isTokenExpired(new String(tempToken)) && isIssuerValid(extractIssuer(new String(tempToken))));
    }
    private String extractIssuer(String token){
        Claims claims = (Claims) Jwts.parserBuilder().setSigningKey(secretKey.getBytes()).build().parse(token).getBody();
        return claims.getIssuer();
    }
    private boolean isIssuerValid(String issuer){
        return iss.equals(issuer);
    }

    /**
     *
     * @param request
     * @return jwtToken without Bearer
     */
    public static String  resolveToken(HttpServletRequest request) {
        //取得jwt token,
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {

            return bearerToken.substring(7);
        }
        return null;
    }
    public Authentication getAuthentication(String token) {
        String username = extractUsername(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(userDetails);
        return authentication;

    }
}

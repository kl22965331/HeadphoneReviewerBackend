package com.example.demo.Configuration;

import com.example.demo.Util.JwtTokenFilter;
import com.example.demo.Util.JwtTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {
    private final JwtTokenGenerator jwtTokenGenerator;
    private final JwtTokenFilter jwtFilter;
    private UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfiguration(JwtTokenGenerator jwtTokenGenerator, JwtTokenFilter jwtFilter, UserDetailsService userDetailsService) {
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.jwtFilter = jwtFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                //.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> request.requestMatchers("/user/**").permitAll()
                        .requestMatchers("/test/**").hasAuthority("user")
                        .requestMatchers(HttpMethod.GET).permitAll()
                        .anyRequest().authenticated())

                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }





}

package com.example.demo.ServiceImpl;

import com.example.demo.DAO.RoleRepository;
import com.example.demo.Entity.Role;
import com.example.demo.Service.RoleService;
import com.example.demo.Util.JwtTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    private JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, JwtTokenGenerator jwtTokenGenerator) {
        this.roleRepository = roleRepository;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @Override
    public boolean hasManagerRole(String jwtToken) {

        String username = JwtTokenGenerator.extractUsername(jwtToken);
        HashSet<Role> roles = roleRepository.findDistinctRolesByUsername(username);
        boolean flag=false;
        Iterator<Role> roleIterator = roles.iterator();
        while (roleIterator.hasNext()){
            Role currentRole = roleIterator.next();
            if(currentRole.getAuthority().equals("manager")){
                flag=true;
                break;
            }
        }
        return flag;
    }
}

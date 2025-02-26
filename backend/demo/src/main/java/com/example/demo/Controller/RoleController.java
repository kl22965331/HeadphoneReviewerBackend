package com.example.demo.Controller;

import com.example.demo.Service.RoleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/isManager")
    public boolean managerRoleCheck(HttpServletRequest request){
        return roleService.hasManagerRole(request.getHeader(HttpHeaders.AUTHORIZATION));

    }
}

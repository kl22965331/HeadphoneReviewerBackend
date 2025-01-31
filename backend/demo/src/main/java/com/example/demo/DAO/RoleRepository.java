package com.example.demo.DAO;

import com.example.demo.Entity.Role;
import org.hibernate.mapping.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query("SELECT r FROM Role r WHERE r.username= :username")
    public HashSet<Role> findDistinctRolesByUsername(@Param("username") String username);
}

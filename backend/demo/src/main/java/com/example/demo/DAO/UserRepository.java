package com.example.demo.DAO;

import com.example.demo.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("Select u from User u where u.username= :username")
    User findByUsername(@Param("username") String username);
    @Query("delete from User u where u.username= :username")
    @Modifying
    @Transactional
    void deleteUserByUsername(String username);

}

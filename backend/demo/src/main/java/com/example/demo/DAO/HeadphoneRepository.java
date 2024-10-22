package com.example.demo.DAO;

import com.example.demo.Entity.Headphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadphoneRepository extends JpaRepository<Headphone, Integer> {

}


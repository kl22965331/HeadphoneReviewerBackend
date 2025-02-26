package com.example.demo.DAO;

import com.example.demo.Entity.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query("SELECT r FROM Review r WHERE r.user.id = :id")
    public List<Review> getReviewsByUserId(@Param("id") int id);
    @Query("SELECT r FROM Review r WHERE r.headphone.id = :id")
    public List<Review> getReviewsByHeadphone(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Review r SET r.viewsCount=r.viewsCount+1 WHERE r.id= :id")
    public void viewsCountPlusOne(@Param("id") int id);
}

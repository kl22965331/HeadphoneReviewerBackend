package com.example.demo.DAO;

import com.example.demo.Entity.Headphone;
import com.example.demo.Service.util.HeadphoneNameAndBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface HeadphoneRepository extends JpaRepository<Headphone, Integer> {
    @Query("SELECT h.id AS id,h.name AS name,h.brand AS brand,image AS image FROM Headphone h")
    List<HeadphoneNameAndBrand> getNameAndBrand();

    @Query("SELECT DISTINCT h.brand AS brand FROM Headphone h")
    List<String> getListOfBrand();


    @Query("SELECT h FROM Headphone h WHERE h.brand = :brand")
    List<Headphone> getHeadphoneListByBrand(@Param("brand") String brand);


}


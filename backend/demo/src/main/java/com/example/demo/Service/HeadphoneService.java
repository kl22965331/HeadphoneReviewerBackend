package com.example.demo.Service;

import com.example.demo.Entity.Headphone;
import com.example.demo.Service.util.HeadphoneNameAndBrand;

import java.util.List;

public interface HeadphoneService {
    Headphone getHeadPhoneById(int id);
    void addNewHeadPhone(Headphone headphone);
    void updateHeadPhone(Headphone headphone);

    void deleteHeadPhoneById(int id);
    List<HeadphoneNameAndBrand> getListOfNameAndBrand();
    List<String> getListOfBrand();
    List<Headphone> getHeadphoneListByBrand(String brand);
    List<Headphone> getHeadphones();
}

package com.example.demo.ServiceImpl;

import com.example.demo.DAO.HeadphoneRepository;
import com.example.demo.Entity.Headphone;
import com.example.demo.Exception.CustomException;
import com.example.demo.Service.HeadphoneService;
import com.example.demo.Service.util.HeadphoneNameAndBrand;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HeadphoneServiceImpl implements HeadphoneService {
    private HeadphoneRepository headphoneRepository;

    @Autowired
    public HeadphoneServiceImpl(HeadphoneRepository headphoneRepository) {
        this.headphoneRepository = headphoneRepository;
    }




    public Headphone getHeadPhoneById(int id) {
        return headphoneRepository.getReferenceById(id);
    }


    @Transactional
    public void addNewHeadPhone(Headphone headphone) {
        if(isHeadPhoneNamePresent(headphone)){
            throw new CustomException(409,"該HeadPhone已存在");
        }
        headphone.setCreateDateTime(LocalDateTime.now());
        headphoneRepository.save(headphone);
    }


    @Transactional
    public void updateHeadPhone(Headphone headphone) {
        if(isHeadPhoneNameOrIdPresent(headphone)){
            headphoneRepository.save(headphone);
        }else{
            throw new CustomException("該HeadPhone不存在");
        }
    }


    @Transactional
    public void deleteHeadPhoneById(int id) {
        if(headphoneRepository.existsById(id)){
            headphoneRepository.deleteById(id);
        }else{
            throw new CustomException("該HeadPhone已被刪除(不存在)");
        }
    }

    @Override
    public List<HeadphoneNameAndBrand> getListOfNameAndBrand() {
        return headphoneRepository.getNameAndBrand();
    }

    @Override
    public List<String> getListOfBrand() {
        return headphoneRepository.getListOfBrand();
    }

    @Override
    public List<Headphone> getHeadphoneListByBrand(String brand) {
        if(brand==null){
            throw new CustomException(400,"Bad request");
        }
        return headphoneRepository.getHeadphoneListByBrand(brand);
    }

    @Override
    public List<Headphone> getHeadphones() {
        return headphoneRepository.findAll();
    }


    public boolean isHeadPhoneNameOrIdPresent(Headphone headphone){
        ExampleMatcher nameAndIdMatcher = ExampleMatcher.matching()
                .withIgnoreCase("name")
                .withIgnorePaths("brand", "price", "createDateTime","image")
                .withIgnoreNullValues();
        Example<Headphone> headphoneExample = Example.of(headphone, nameAndIdMatcher);
        return headphoneRepository.exists(headphoneExample);
    }
    public boolean isHeadPhoneNamePresent(Headphone headphone){
        ExampleMatcher nameAndIdMatcher = ExampleMatcher.matching()
                .withIgnoreCase("name")
                .withIgnorePaths("id","brand", "price", "createDateTime","image")
                .withIgnoreNullValues();
        Example<Headphone> headphoneExample = Example.of(headphone, nameAndIdMatcher);
        return headphoneRepository.exists(headphoneExample);
    }


}

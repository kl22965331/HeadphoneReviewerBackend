package com.example.demo.Controller;

import com.example.demo.Entity.Headphone;
import com.example.demo.Service.HeadphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/headphone/brand")
public class BrandController {
    private HeadphoneService headphoneService;

    @Autowired
    public BrandController(HeadphoneService headphoneService) {
        this.headphoneService = headphoneService;
    }

    @GetMapping("/brandList")
    public List<String> getListOfBrand(){
        return headphoneService.getListOfBrand();
    }

    @GetMapping("/{brand}")
    public List<Headphone> getHeadphonesByBrand(@PathVariable String brand) {

        return headphoneService.getHeadphoneListByBrand(brand);
    }

}

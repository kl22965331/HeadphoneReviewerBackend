package com.example.demo.Controller;
import com.example.demo.Entity.Headphone;
import com.example.demo.Service.HeadphoneService;
import com.example.demo.Service.util.HeadphoneNameAndBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/headphone")
public class HeadphoneController {
    private HeadphoneService headphoneService;

    @Autowired
    public HeadphoneController(HeadphoneService headphoneService) {
        this.headphoneService = headphoneService;
    }


    @GetMapping("/get/{id}")
    public Headphone getHeadPhone(@PathVariable int id){

        return headphoneService.getHeadPhoneById(id);
    }

    @PostMapping("/add")
    public void addNewHeadPhone(@RequestParam("name") String name, @RequestParam("brand") String brand, @RequestParam("price") int price, @RequestPart("image") MultipartFile imageFile) {
        Headphone headphone = new Headphone();
        headphone.setName(name);
        headphone.setBrand(brand);
        headphone.setPrice(price);
        try {
            byte[] imageBytes = imageFile.getBytes();

            headphone.setImage(imageBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        headphoneService.addNewHeadPhone(headphone);
    }

    @PutMapping("/update")
    public void  updateHeadPhone(@RequestBody Headphone headphone){

        headphoneService.updateHeadPhone(headphone);
    }
    @DeleteMapping("/delete")
    public void deleteHeadphone(@RequestParam int id){
        headphoneService.deleteHeadPhoneById(id);

    }


    @GetMapping("/list")
    public List<HeadphoneNameAndBrand> getListOfHeadphoneNameAndBrand(){

        return headphoneService.getListOfNameAndBrand();
    }

    @GetMapping("/listall")
    public List<Headphone> getHeadphones(){

        List<Headphone> headphones = headphoneService.getHeadphones();
        headphones.stream().forEach(headphone -> headphone.setReviews(null));
        return headphones;
    }




}

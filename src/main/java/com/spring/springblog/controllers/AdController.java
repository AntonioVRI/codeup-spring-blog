package com.spring.springblog.controllers;

import com.spring.springblog.models.Ad;
import com.spring.springblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdController {

    private final AdRepository adsDao;


    public AdController(AdRepository adsDao) {
        this.adsDao = adsDao;
    }

    @GetMapping("/ads/jpa")
    @ResponseBody
    public List<Ad> jpaIndex(){
        return adsDao.findAll();
    }

    @GetMapping("/ads/jpa/{id}")
    @ResponseBody
    public String viewJpaAd(@PathVariable long id){
        return adsDao.getOne(id).toString();
    }

    @GetMapping("ads/{id}")
    public String viewAd(@PathVariable long id, Model model){
        Ad myAd = adsDao.getOne(id);
        model.addAttribute("ad", myAd);

        return "ads/show";
    }

    @GetMapping("/ads/jpa/create")
    public void createAd(){
        Ad ad = new Ad();
//        ad.setTitle("title");
//        ad.setDescription("description");

        adsDao.save(ad);
    }
}

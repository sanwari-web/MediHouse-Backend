package com.bit.mediHouse.Controller;

import com.bit.mediHouse.Models.Pricing;
import com.bit.mediHouse.Models.User;
import com.bit.mediHouse.Services.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class PricingController {
    @Autowired
    private PricingService pricingService;

    public PricingController(PricingService pricingService){
        this.pricingService = pricingService;
    }

    @GetMapping("/pricing/find")
    public ResponseEntity<List<Pricing>> getAllPricing() {
        List<Pricing> pricing = pricingService.findAllPricing();
        return new ResponseEntity <>(pricing, HttpStatus.OK);
    }

//    @GetMapping("/pricing/find/{pricing_id}")
//    public ResponseEntity <Pricing> findPricingBypricing_id(@PathVariable("pricing_id") Integer pricing_id){
//        Pricing pricing = pricingService.findPricingBypricing_id(pricing_id);
//        return new ResponseEntity <>(pricing, HttpStatus.OK);
//    }

    @PostMapping("/pricing/add")
    public ResponseEntity <Pricing> addPricing(@RequestBody Pricing pricing){
        Pricing newPricing = pricingService.addPricing(pricing);
        return new ResponseEntity <>(newPricing, HttpStatus.CREATED);
    }

}

package com.bit.mediHouse.Services;

import com.bit.mediHouse.Models.Pricing;
import com.bit.mediHouse.Models.Session;
import com.bit.mediHouse.Models.User;
import com.bit.mediHouse.Repository.PricingRepository;
import com.bit.mediHouse.Repository.UserRepository;
import com.bit.mediHouse.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {

    private final PricingRepository pricingRepository;

    @Autowired
    public PricingService(PricingRepository pricingRepository) {
        this.pricingRepository = pricingRepository;
    }

    public Pricing addPricing(Pricing pricing) {
        return pricingRepository.save(pricing);
    }

    public List<Pricing> findAllPricing() {
        return pricingRepository.findAll();
    }

//    public Pricing findPricingBypricing_id(Integer pricing_id) {
//        return pricingRepository.findPricingBypricing_id(pricing_id).orElseThrow(() -> new UserNotFoundException("User by id " + pricing_id + " was not found"));
//
//    }
}

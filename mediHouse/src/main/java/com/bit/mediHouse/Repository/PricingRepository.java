package com.bit.mediHouse.Repository;

import com.bit.mediHouse.Models.Patient;
import com.bit.mediHouse.Models.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PricingRepository extends JpaRepository<Pricing,Integer> {

    Pricing getById(Integer pricingId);

//    //void deletePricingById(Integer id);
//
//    Optional<Pricing> findPricingBypricing_id(Integer pricing_id);

}

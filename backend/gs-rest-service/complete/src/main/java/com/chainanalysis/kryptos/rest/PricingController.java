package com.chainanalysis.kryptos.rest;

import com.chainanalysis.kryptos.model.CryptoPrice;
import com.chainanalysis.kryptos.service.PricingService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingController {

    @Autowired
    PricingService pricingService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/pricing")
    public ResponseEntity<Object> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        List<CryptoPrice> cryptoPrices = new ArrayList<>(2);
        try {
            cryptoPrices.add(pricingService.getCryptoPriceNomics());
            cryptoPrices.add(pricingService.getCryptoPriceCoinGecko());
        } catch (IOException | URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(cryptoPrices);
    }

    public static void main(String[] args) {
        PricingController pricingController = new PricingController();
        System.out.println(pricingController.greeting("abc"));
    }
}

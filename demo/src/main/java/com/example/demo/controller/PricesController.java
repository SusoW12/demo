package com.example.demo.controller;


import com.example.demo.dto.PricesDto;
import com.example.demo.service.PricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/prices")
public class PricesController {

    private final PricesService pricesService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<PricesDto> prueba(@RequestParam @DateTimeFormat(pattern="dd/MM/yyyy HH:mm") Date date, @RequestParam Long productId, @RequestParam Long brandId){
        PricesDto price = pricesService.getPriceByDateAndBrand(date, productId, brandId);
        if(price!=null) {
            return new ResponseEntity<PricesDto>(price, HttpStatus.OK);
        }else{
            return new ResponseEntity<PricesDto>(HttpStatus.NO_CONTENT);
        }
    }


}

package com.example.demo.service;

import com.example.demo.dto.PricesDto;

import java.util.Date;

public interface PricesService {
    PricesDto getPriceByDateAndBrand(Date date, Long productId, Long brandId);
}

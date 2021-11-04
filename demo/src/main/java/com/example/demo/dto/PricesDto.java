package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PricesDto {

    public PricesDto(Long productId,Long brand,Long priceList,Date startDate,Date endDate,double price){
        this.productId=productId;
        this.brand=brand;
        this.priceList=priceList;
        this.startDate=startDate;
        this.endDate=endDate;
        this.price=price;
    }

    private Long productId;
    private Long brand;
    private Date startDate;
    private Date endDate;
    private Long priceList;
    private double price;
}

package com.example.demo.service;

import com.example.demo.dto.PricesDto;
import com.example.demo.repository.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService {


    private final PricesRepository pricesRepository;

    @Override
    public PricesDto getPriceByDateAndBrand(Date date,Long productId, Long brandId){
        List<PricesDto> price = pricesRepository.getPriceByDateAndPorductAndBrand(date,productId,brandId, PageRequest.of(0,1));
        if(!price.isEmpty()){
            return price.get(0);
        }else{
            return null;
        }
    }

}

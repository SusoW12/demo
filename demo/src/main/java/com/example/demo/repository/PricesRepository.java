package com.example.demo.repository;

import com.example.demo.dto.PricesDto;
import com.example.demo.entity.PricesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PricesRepository extends JpaRepository<PricesEntity, Long> {

    @Query ("SELECT new com.example.demo.dto.PricesDto"+
            "(p.productId, p.brand, p.priceList, p.startDate, p.endDate, p.price) "+
            "FROM PricesEntity p "+
            "WHERE brand=:brandId and productId=:productId and startDate<:date and endDate>:date order by priority desc")
    List<PricesDto> getPriceByDateAndPorductAndBrand(Date date, Long productId, Long brandId, Pageable pageable);
}



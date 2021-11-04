package com.example.demo;

import com.example.demo.dto.PricesDto;
import com.example.demo.entity.PricesEntity;
import com.example.demo.repository.PricesRepository;
import com.example.demo.service.PricesService;
import com.example.demo.service.PricesServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class )
@SpringBootTest
public class PricesTest {


    @Autowired
    private PricesRepository pricesRepository;

   @Before
   public void loadTestData(){
       PricesEntity e1 = new PricesEntity(
               new Long(1),new Long(1), createDate("14/06/2020 00:00"), createDate("31/12/2020 23:59"), new Long(1), new Long(35455), new Long(0), 35.50,"EUR"
       );
       PricesEntity e2 = new PricesEntity(
               new Long(2),new Long(1), createDate("14/06/2020 15:00"), createDate("14/06/2020 18:30"), new Long(1), new Long(35455), new Long(1), 25.45,"EUR"
       );
       PricesEntity e3 = new PricesEntity(
               new Long(3),new Long(1), createDate("15/06/2020 00:00"), createDate("15/06/2020 11:00"), new Long(1), new Long(35455), new Long(1), 30.50,"EUR"
       );
       PricesEntity e4 = new PricesEntity(
               new Long(4),new Long(1), createDate("15/06/2020 16:00"), createDate("31/12/2020 23:59"), new Long(1), new Long(35455), new Long(1), 38.95,"EUR"
       );

       List<PricesEntity> list = Arrays.asList(e1,e2,e3,e4);
       pricesRepository.saveAll(list);

   }

    @Test
    public void pricesTest1(){
        Date date = createDate("14/06/2020 10:00");
        double validPrice=35.5;
        genericPriceTest(date,new Long(35455), new Long(1),validPrice);
    }

    @Test
    public void pricesTest2(){
        Date date = createDate("14/06/2020 16:00");
        double validPrice=25.45;
        genericPriceTest(date,new Long(35455), new Long(1),validPrice);
    }


    @Test
    public void pricesTest3(){
        Date date = createDate("14/06/2020 21:00");
        double validPrice=35.5;
        genericPriceTest(date,new Long(35455), new Long(1),validPrice);
    }


    @Test
    public void pricesTest4(){
        Date date = createDate("15/06/2020 10:00");
        double validPrice=30.5;
        genericPriceTest(date,new Long(35455), new Long(1),validPrice);
    }


    @Test
    public void pricesTest5(){
        Date date = createDate("16/06/2020 21:00");
        double validPrice=38.95;
        genericPriceTest(date,new Long(35455), new Long(1),validPrice);
    }

    private void genericPriceTest(Date date,Long productId, Long brandId, double validPrice){
        PricesService pricesService = new PricesServiceImpl(pricesRepository);
        PricesDto pricesDto=pricesService.getPriceByDateAndBrand(date,productId, brandId);
        Assert.isTrue(validPrice==pricesDto.getPrice(),"El precio obtenido es "+pricesDto.getPrice()+" pero debiera ser "+validPrice);
    }

    private Date createDate(String strDate){
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date date = dateformat.parse(strDate);
            return date;
        } catch (Exception e) {
            return null;
        }

    }
}
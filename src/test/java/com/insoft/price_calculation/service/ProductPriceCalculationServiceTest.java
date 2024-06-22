package com.insoft.price_calculation.service;

import com.insoft.price_calculation.model.Product;
import com.insoft.price_calculation.model.dto.OrderInfo;
import com.insoft.price_calculation.repository.ProductRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductPriceCalculationServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private TaxService taxService;
    @Mock
    private CouponService couponService;

    @InjectMocks
    private ProductPriceCalculationService priceCalculationService;

    @Test
    public void givenProduct_whenCalculatePrice_thenReturnTotalPriceExpectedValue() {

        // given
        var product = new Product();
        product.setName("Iphone");
        product.setPrice(10000L);

        var orderInfo = new OrderInfo();
        orderInfo.setProduct(1L);
        orderInfo.setTaxNumber("DE1234567");
        orderInfo.setCouponCode("D10");

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(couponService.apply(anyString(), anyLong())).thenReturn(9000L);
        when(taxService.apply(anyString(), anyLong())).thenReturn(11160L);

        // when
        var result = priceCalculationService.calculatePrice(orderInfo);

        // then
        Assertions.assertEquals(11160, result.getTotalPrice());
        Assertions.assertEquals("Iphone", result.getName());
    }

}
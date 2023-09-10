package com.tuxpoli.inditexpriceselection.price.infrastructure.configuration;

import com.tuxpoli.inditexpriceselection.InditexPriceSelectionApplication;
import com.tuxpoli.inditexpriceselection.price.domain.usecase.GetFinalPrice;
import com.tuxpoli.inditexpriceselection.price.domain.service.GetFinalPriceService;
import com.tuxpoli.inditexpriceselection.price.domain.repository.PriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = InditexPriceSelectionApplication.class)
public class WiringGetFinalPriceBeanConfiguration {

    @Bean
    GetFinalPrice getFinalPrice(final PriceRepository priceRepository) {
        return new GetFinalPriceService(priceRepository);
    }
}

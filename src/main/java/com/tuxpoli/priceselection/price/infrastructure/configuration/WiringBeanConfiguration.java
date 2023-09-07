package com.tuxpoli.priceselection.price.infrastructure.configuration;

import com.tuxpoli.priceselection.PriceSelectionApplication;
import com.tuxpoli.priceselection.price.domain.usecase.GetFinalPrice;
import com.tuxpoli.priceselection.price.domain.service.GetFinalPriceService;
import com.tuxpoli.priceselection.price.domain.repository.PriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = PriceSelectionApplication.class)
public class WiringBeanConfiguration {

    @Bean
    GetFinalPrice getSpecificPrice(final PriceRepository priceRepository) {
        return new GetFinalPriceService(priceRepository);
    }
}

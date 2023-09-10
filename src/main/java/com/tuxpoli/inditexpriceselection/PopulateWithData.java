package com.tuxpoli.inditexpriceselection;

import com.tuxpoli.inditexpriceselection.brand.domain.entity.Brand;
import com.tuxpoli.inditexpriceselection.brand.domain.repository.BrandRepository;
import com.tuxpoli.inditexpriceselection.price.domain.entity.Price;
import com.tuxpoli.inditexpriceselection.price.domain.repository.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Configuration
public class PopulateWithData {

    private final PriceRepository priceRepository;
    private final BrandRepository brandRepository;

    public PopulateWithData(PriceRepository priceRepository,
                            BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
        this.priceRepository = priceRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Brand zara = this.brandRepository.createBrand(new Brand(
                    "ZARA"
            ));
            this.priceRepository.createPrice(new Price(
                    zara.getId(),
                    LocalDateTime.of(2020, 6, 14, 0, 0, 0),
                    LocalDateTime.of(2020, 12, 31, 23, 59, 59),
                    1L,
                    35455L,
                    0,
                    BigDecimal.valueOf(35.50),
                    "EUR"
            ));
            this.priceRepository.createPrice(new Price(
                    zara.getId(),
                    LocalDateTime.of(2020, 6, 14, 15, 0, 0),
                    LocalDateTime.of(2020, 6, 14, 18, 30, 0),
                    2L,
                    35455L,
                    1,
                    BigDecimal.valueOf(25.45),
                    "EUR"
            ));
            this.priceRepository.createPrice(new Price(
                    zara.getId(),
                    LocalDateTime.of(2020, 6, 15, 0, 0, 0),
                    LocalDateTime.of(2020, 6, 15, 11, 0, 0),
                    3L,
                    35455L,
                    1,
                    BigDecimal.valueOf(30.50),
                    "EUR"
            ));
            this.priceRepository.createPrice(new Price(
                    zara.getId(),
                    LocalDateTime.of(2020, 6, 15, 16, 0, 0),
                    LocalDateTime.of(2020, 12, 31, 23, 59, 59),
                    4L,
                    35455L,
                    1,
                    BigDecimal.valueOf(38.95),
                    "EUR"
            ));
            // this.brandRepository.deleteBrandById(zara.getId());
        };
    }
}

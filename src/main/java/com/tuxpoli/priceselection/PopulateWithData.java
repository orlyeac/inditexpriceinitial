package com.tuxpoli.priceselection;

import com.tuxpoli.priceselection.price.domain.Price;
import com.tuxpoli.priceselection.price.domain.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Configuration
public class PopulateWithData {

    private final PriceRepository priceRepository;

    public PopulateWithData(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            this.priceRepository.createPrice(new Price(
                    1L,
                    LocalDateTime.of(2020, 6, 14, 0, 0, 0),
                    LocalDateTime.of(2020, 12, 31, 23, 59, 59),
                    1L,
                    35455L,
                    0,
                    BigDecimal.valueOf(35.50),
                    "EUR"
            ));
            this.priceRepository.createPrice(new Price(
                    1L,
                    LocalDateTime.of(2020, 6, 14, 15, 0, 0),
                    LocalDateTime.of(2020, 6, 14, 18, 30, 0),
                    2L,
                    35455L,
                    1,
                    BigDecimal.valueOf(25.45),
                    "EUR"
            ));
            this.priceRepository.createPrice(new Price(
                    1L,
                    LocalDateTime.of(2020, 6, 15, 0, 0, 0),
                    LocalDateTime.of(2020, 6, 15, 11, 0, 0),
                    3L,
                    35455L,
                    1,
                    BigDecimal.valueOf(30.50),
                    "EUR"
            ));
            this.priceRepository.createPrice(new Price(
                    1L,
                    LocalDateTime.of(2020, 6, 15, 16, 0, 0),
                    LocalDateTime.of(2020, 12, 31, 23, 59, 59),
                    4L,
                    35455L,
                    1,
                    BigDecimal.valueOf(38.95),
                    "EUR"
            ));
        };
    }
}

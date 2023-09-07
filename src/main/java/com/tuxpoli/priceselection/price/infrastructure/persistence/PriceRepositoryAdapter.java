package com.tuxpoli.priceselection.price.infrastructure.persistence;

import com.tuxpoli.priceselection.price.domain.entity.Price;
import com.tuxpoli.priceselection.price.domain.repository.PriceRepository;
import com.tuxpoli.priceselection.price.infrastructure.mapper.PriceEntityToPriceMapper;
import com.tuxpoli.priceselection.price.infrastructure.mapper.PriceToPriceEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PriceRepositoryAdapter implements PriceRepository {
    private final PriceSpringRepository priceSpringRepository;
    private final PriceToPriceEntityMapper priceToPriceEntityMapper;
    private final PriceEntityToPriceMapper priceEntityToPriceMapper;

    public void createPrice(Price price) {
        this.priceSpringRepository.save(this.priceToPriceEntityMapper.apply(price));
    }

    public List<Price> findPricesByApplicationDateAndProduct(LocalDateTime applicationDate,
                                                             Long productId,
                                                             Long brandId) {
        List<PriceEntity> applicablePriceEntities = this.priceSpringRepository.findPricesByApplicationDateAndProduct(
                applicationDate,
                productId,
                brandId
        );
        return applicablePriceEntities
                .stream()
                .map(priceEntityToPriceMapper)
                .collect(Collectors.toList());
    }
}

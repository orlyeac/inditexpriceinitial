package com.tuxpoli.inditexpriceselection.price.infrastructure.persistence;

import com.tuxpoli.inditexpriceselection.price.domain.entity.Price;
import com.tuxpoli.inditexpriceselection.price.domain.repository.PriceRepository;
import com.tuxpoli.inditexpriceselection.price.infrastructure.mapper.PriceEntityToPriceMapper;
import com.tuxpoli.inditexpriceselection.price.infrastructure.mapper.PriceToPriceEntityMapper;
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

    public Price createPrice(Price price) {
        PriceEntity newPrice = this.priceSpringRepository.save(this.priceToPriceEntityMapper.apply(price));
        return this.priceEntityToPriceMapper.apply(newPrice);
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

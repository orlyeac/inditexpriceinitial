package com.tuxpoli.inditexpriceselection.brand.infrastructure.persistence;

import com.tuxpoli.inditexpriceselection.brand.domain.entity.Brand;
import com.tuxpoli.inditexpriceselection.brand.domain.repository.BrandRepository;
import com.tuxpoli.inditexpriceselection.brand.infrastructure.mapper.BrandEntityToBrandMapper;
import com.tuxpoli.inditexpriceselection.brand.infrastructure.mapper.BrandToBrandEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BrandRepositoryAdapter implements BrandRepository {

    private final BrandSpringRepository brandSpringRepository;
    private final BrandToBrandEntityMapper brandToBrandEntityMapper;
    private final BrandEntityToBrandMapper brandEntityToBrandMapper;

    public Brand createBrand(Brand brand) {
        BrandEntity newBrand = this.brandSpringRepository.save(this.brandToBrandEntityMapper.apply(brand));
        return this.brandEntityToBrandMapper.apply(newBrand);
    }

    public void deleteBrandById(Long id) {
        this.brandSpringRepository.deleteById(id);
    }
}

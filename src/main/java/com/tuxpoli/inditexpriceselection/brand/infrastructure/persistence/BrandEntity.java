package com.tuxpoli.inditexpriceselection.brand.infrastructure.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tuxpoli.inditexpriceselection.price.infrastructure.persistence.PriceEntity;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity(name = "BrandEntity")
@Table(name = "brands")
public class BrandEntity {

    @Id
    @SequenceGenerator(
            name = "brand_sequence",
            sequenceName = "brand_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "brand_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "brandId",
            orphanRemoval = true
    )
    private List<PriceEntity> priceIds = new ArrayList<>();

    public BrandEntity(String name) {
        this.name = name;
    }

}

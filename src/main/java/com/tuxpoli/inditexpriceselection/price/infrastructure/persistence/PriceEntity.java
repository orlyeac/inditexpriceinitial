package com.tuxpoli.inditexpriceselection.price.infrastructure.persistence;

import com.tuxpoli.inditexpriceselection.brand.infrastructure.persistence.BrandEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity(name = "PriceEntity")
@Table(name = "prices")
public class PriceEntity {

    @Id
    @SequenceGenerator(
            name = "price_sequence",
            sequenceName = "price_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "price_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(
            name = "brand_id",
            nullable = false
    )
    private Long brandId;

    @Setter
    @Column(
            name = "start_date",
            nullable = false,
            columnDefinition = "TIMESTAMP"
    )
    private LocalDateTime startDate;

    @Setter
    @Column(
            name = "end_date",
            nullable = false,
            columnDefinition = "TIMESTAMP"
    )
    private LocalDateTime endDate;

    @Setter
    @Column(
            name = "price_list",
            nullable = false
    )
    private Long priceList;

    @Setter
    @Column(
            name = "product_id",
            nullable = false
    )
    private Long productId;

    @Setter
    @Column(
            name = "priority",
            nullable = false
    )
    private Integer priority;

    @Setter
    @Column(
            name = "price",
            nullable = false
    )
    private BigDecimal price;

    @Setter
    @Column(
            name = "currency",
            nullable = false
    )
    private String currency;

    @ManyToOne
    @MapsId("brandId")
    @JoinColumn(
            name = "brand_id",
            foreignKey = @ForeignKey(
                    name = "fk_price_brand_id"
            )
    )
    private BrandEntity brand;

    public PriceEntity(Long brandId,
                       LocalDateTime startDate,
                       LocalDateTime endDate,
                       Long priceList,
                       Long productId,
                       Integer priority,
                       BigDecimal price,
                       String currency) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

}

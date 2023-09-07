package com.tuxpoli.priceselection.price.infrastructure.persistence;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "PriceEntity")
@Table(name = "prices")
public class PriceEntity {

    @Getter
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
    @Getter
    @Column(
            name = "brand_id",
            nullable = false
    )
    private Long brandId;

    @Setter
    @Getter
    @Column(
            name = "start_date",
            nullable = false,
            columnDefinition = "TIMESTAMP"
    )
    private LocalDateTime startDate;

    @Setter
    @Getter
    @Column(
            name = "end_date",
            nullable = false,
            columnDefinition = "TIMESTAMP"
    )
    private LocalDateTime endDate;

    @Setter
    @Getter
    @Column(
            name = "price_list",
            nullable = false
    )
    private Long priceList;

    @Setter
    @Getter
    @Column(
            name = "product_id",
            nullable = false
    )
    private Long productId;

    @Setter
    @Getter
    @Column(
            name = "priority",
            nullable = false
    )
    private Integer priority;

    @Setter
    @Getter
    @Column(
            name = "price",
            nullable = false
    )
    private BigDecimal price;

    @Setter
    @Getter
    @Column(
            name = "currency",
            nullable = false
    )
    private String currency;

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

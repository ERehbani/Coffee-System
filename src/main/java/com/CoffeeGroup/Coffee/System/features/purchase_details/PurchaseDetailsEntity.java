package com.CoffeeGroup.Coffee.System.features.purchase_details;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "purchase_details")
@Entity
public class PurchaseDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column
    private Integer amount;

    @Column
    private BigDecimal priceUnit;

    @Column
    private Integer pointsGenerated;

}

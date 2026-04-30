package com.CoffeeGroup.Coffee.System.features.benefit;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "benefits")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BenefitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column
    private String description;

    @Column
    private Integer price;

    @Column
    private Integer pointsCost;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private Boolean status;

    // Relacion tipo
    // Relacion cafeteria
    // Relacion tier

    @Column
    private Boolean isPublic;

    @Column
    private Integer maxRedemptions;


}

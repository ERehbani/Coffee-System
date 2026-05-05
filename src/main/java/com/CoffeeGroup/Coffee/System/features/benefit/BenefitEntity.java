package com.CoffeeGroup.Coffee.System.features.benefit;

import com.CoffeeGroup.Coffee.System.features.benefit_type.BenefitTypeEntity;
import com.CoffeeGroup.Coffee.System.features.cafe.CafeEntity;
import com.CoffeeGroup.Coffee.System.features.shared_benefits.SharedBenefitsEntity;
import com.CoffeeGroup.Coffee.System.features.tier.TierEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
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
    private String name;

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

    @Column
    private Boolean isPublic;

    @Column
    private Integer maxRedemptions;

    // Relacion tier
    @ManyToOne
    @JoinColumn(name = "tier_id",nullable = false)
    private TierEntity tier;
    //Relacion Beneficio compartido
    @OneToMany(mappedBy = "benefit")
    private List<SharedBenefitsEntity>sharedRewards;


    // Relacion tipo
    @ManyToOne
    @JoinColumn(name = "benefit_type_id", nullable = false)
    private BenefitTypeEntity benefitType;

    // Relacion cafeteria
    @ManyToOne
    @JoinColumn(name = "cafe_id") // No es null porque el beneficio puede ser general, de la app
    private CafeEntity cafe_id;
}

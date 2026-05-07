package com.CoffeeGroup.Coffee.System.features.benefit;

import com.CoffeeGroup.Coffee.System.features.cafe.CafeEntity;
import com.CoffeeGroup.Coffee.System.features.redemption.RedemptionEntity;
import com.CoffeeGroup.Coffee.System.features.shared_rewards.SharedRewardsEntity;
import com.CoffeeGroup.Coffee.System.features.tier.TierEntity;
import com.CoffeeGroup.Coffee.System.features.type.TypeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
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
    @Column(name = "Id_Benefit")
    private Long Id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID ExternalId;

    @Column(name = "Description_Benefit")
    private String Description;

    @Column(name = "Price_Benefit")
    private Integer Price;

    @Column(name = "PoinstCost_Benefit")
    private Integer PointsCost;

    @Column(name = "StarDate_Benefit")
    private Date StartDate;

    @Column(name = "EndDate_Benefit")
    private Date EndDate;

    @Column(name = "Status_Benefit")
    private Boolean Status;

    @Column(name = "IsPublic_Benefit")
    private Boolean isPublic;

    @Column(name = "MaxRedemptions_Benefit")
    private Integer MaxRedemptions;

    // Relation with type
    @ManyToOne
    @JoinColumn(name = "type_id",nullable = false)
    private TypeEntity Type;

    // Relacion cafeteria
    @ManyToOne
    @JoinColumn(name = "CafeEntity_id",nullable = false)
    private CafeEntity Cafe;

    // Relacion tier
    @ManyToOne
    @JoinColumn(name = "tier_id",nullable = false)
    private TierEntity Tier;

    //Relation sharedRewards
    @OneToOne(mappedBy = "benefit")
    private SharedRewardsEntity SharedRewards;

    // --- Relation Redemption ---
    @OneToMany(mappedBy = "benefit",fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<RedemptionEntity> Redemptions;
}

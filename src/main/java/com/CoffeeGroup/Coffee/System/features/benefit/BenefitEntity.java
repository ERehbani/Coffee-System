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

    @Column
    private Boolean isPublic;

    @Column
    private Integer maxRedemptions;

    // Relation with type
    @ManyToOne
    @JoinColumn(name = "type_id",nullable = false)
    private TypeEntity type;

    // Relacion cafeteria
    @ManyToOne
    @JoinColumn(name = "cafe_id",nullable = false)
    private CafeEntity cafe;

    // Relacion tier
    @ManyToOne
    @JoinColumn(name = "tier_id",nullable = false)
    private TierEntity tier;

    //Relation sharedRewards
    @OneToOne(mappedBy = "benefit")
    private SharedRewardsEntity sharedRewards;

    // --- Relation Redemption ---
    @OneToMany(mappedBy = "benefit", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<RedemptionEntity> redemptions;
}

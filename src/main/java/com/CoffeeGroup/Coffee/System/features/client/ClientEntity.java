package com.CoffeeGroup.Coffee.System.features.client;

import com.CoffeeGroup.Coffee.System.features.purchase.PurchaseEntity;
import com.CoffeeGroup.Coffee.System.features.redemption.RedemptionEntity;
import com.CoffeeGroup.Coffee.System.features.review.ReviewEntity;
import com.CoffeeGroup.Coffee.System.features.shared_rewards.SharedRewardsEntity;
import com.CoffeeGroup.Coffee.System.features.tier.TierEntity;
import com.CoffeeGroup.Coffee.System.features.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column(name = "name")
    private String name;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "current_points")
    private Integer currentPoints;

    @Column(name = "historical_points")
    private Integer historicalPoints;

    @OneToMany(mappedBy = "client")
    private List<RedemptionEntity> listRedemption;

    @OneToMany(mappedBy = "client")
    private List<PurchaseEntity> listPurchase;

    // Tier id Relation
    @ManyToOne
    @JoinColumn(name="tier_id",nullable = false)
    private TierEntity tier;

    @OneToMany(mappedBy = "transmitter")
    private List<SharedRewardsEntity> transmitter;

    //SharedReward Receptor Relation
    @OneToMany(mappedBy = "receiver")
    private List<SharedRewardsEntity> receiver;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "client")
    private List<ReviewEntity> Review;

}

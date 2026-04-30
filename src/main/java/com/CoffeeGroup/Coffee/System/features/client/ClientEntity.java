package com.CoffeeGroup.Coffee.System.features.client;

import com.CoffeeGroup.Coffee.System.features.purchase.PurchaseEntity;
import com.CoffeeGroup.Coffee.System.features.redemption.RedemptionEntity;
import com.CoffeeGroup.Coffee.System.features.shared_rewards.SharedRewardsEntity;
import com.CoffeeGroup.Coffee.System.features.tier.TierEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client")
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

    //Usuario ID relacion

    @Column
    private String name;

    @Column
    private String profilePhoto;

    @Column
    private Integer currentPoints;

    @Column
    private Integer historicalPoints;

    @OneToMany(mappedBy = "client_id")
    private List<RedemptionEntity> List_Redemption;

    @OneToMany(mappedBy = "client_id")
    private List<PurchaseEntity> List_Purchase;

    // Tier id Relation
    @ManyToOne
    @JoinColumn (name="tier_id",nullable = false)
    private TierEntity tier;

    // SharedRewards emisor relation
    @OneToMany(mappedBy = "emisor")
    private List<SharedRewardsEntity> RewardEmisor;

    //SharedReward Receptor Relation
    @OneToMany(mappedBy = "receptor")
    private List<SharedRewardsEntity>RewardReceptor;


}

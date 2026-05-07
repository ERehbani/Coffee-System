package com.CoffeeGroup.Coffee.System.features.client;

import com.CoffeeGroup.Coffee.System.features.purchase.PurchaseEntity;
import com.CoffeeGroup.Coffee.System.features.redemption.RedemptionEntity;
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
    @Column(name = "Id_Client")
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column(name = "name_client")
    private String name;

    @Column(name = "profilephoto_client")
    private String profilePhoto;

    @Column(name = "currentPoints_client")
    private Integer currentPoints;

    @Column(name = "historicalPoints_client")
    private Integer historicalPoints;

    @OneToMany(mappedBy = "client")
    private List<RedemptionEntity> List_Redemption;

    @OneToMany(mappedBy = "client")
    private List<PurchaseEntity> List_Purchase;

    // Tier id Relation
    @ManyToOne
    @JoinColumn(name="tier_id",nullable = false)
    private TierEntity tier;

    // SharedRewards emisor relation
    @OneToMany(mappedBy = "IssuingClient")
    private List<SharedRewardsEntity> RewardEmisor;

    //SharedReward Receptor Relation
    @OneToMany(mappedBy = "receivingclient")
    private List<SharedRewardsEntity>RewardReceptor;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;



}

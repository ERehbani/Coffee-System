package com.CoffeeGroup.Coffee.System.features.shared_rewards;

import com.CoffeeGroup.Coffee.System.features.benefit.BenefitEntity;
import com.CoffeeGroup.Coffee.System.features.client.ClientEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "shared_reward")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SharedRewardsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_SharedReward")
    private Long id;

    @Column(nullable = false,name = "id_reward")
    private Long Reward;

    @Column(nullable = false, name = "date_SharedReward")
    private java.time.LocalDate date;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    //RELACION CON BENEFICIO
    @OneToOne
    @JoinColumn(name = "benefit_id")
    private BenefitEntity benefit;

    //RELACION CON CLIENTE EMISOR

    @ManyToOne
    @JoinColumn(name = "IssuingClient",nullable = false)
    private ClientEntity IssuingClient;

    //RELACION CON CLIENTE RECEPTOR
    @ManyToOne
    @JoinColumn(name = "receivingclient",nullable = false)
    private  ClientEntity receivingclient;

}

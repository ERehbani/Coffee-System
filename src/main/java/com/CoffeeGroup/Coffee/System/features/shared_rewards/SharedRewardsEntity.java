package com.CoffeeGroup.Coffee.System.features.shared_rewards;

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
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    //RELACION CON BENEFICIO
    //RELACION CON CLIENTE EMISOR
    //RELACION CON CLIENTE RECEPTOR


}

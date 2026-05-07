package com.CoffeeGroup.Coffee.System.features.tier;

import com.CoffeeGroup.Coffee.System.features.client.ClientEntity;
import jakarta.persistence.*;
import jakarta.security.auth.message.ClientAuth;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tiers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tier")
    private Long id;

    @Column (name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column(name = "name_tier")
    private String Name;

    @Column(name = "MinPoints_tier")
    private Integer MinPoints;

    //relation tier
    @OneToMany(mappedBy = "tier")
    private List<ClientEntity> client;


}

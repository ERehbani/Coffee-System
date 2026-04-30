package com.CoffeeGroup.Coffee.System.features.tier;

import jakarta.persistence.*;
import lombok.*;

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
    private Long id;

    @Column (name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column
    private String nombre;

    @Column
    private Integer minimumPoints;
}

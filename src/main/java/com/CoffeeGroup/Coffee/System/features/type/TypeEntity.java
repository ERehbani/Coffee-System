package com.CoffeeGroup.Coffee.System.features.type;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "types")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type")
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column(name = "name_typer")
    private String name;
}

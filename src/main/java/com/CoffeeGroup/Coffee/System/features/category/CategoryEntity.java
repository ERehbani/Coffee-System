package com.CoffeeGroup.Coffee.System.features.category;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table (name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Category")
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column(name = "Name_Category")
    private String name;

}


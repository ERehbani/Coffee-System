package com.CoffeeGroup.Coffee.System.features.category;

import com.CoffeeGroup.Coffee.System.features.product.ProductEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column
    private String name;

    // Relacion con productos
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

}


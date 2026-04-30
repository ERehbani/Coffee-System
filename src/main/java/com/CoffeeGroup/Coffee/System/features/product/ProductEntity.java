package com.CoffeeGroup.Coffee.System.features.product;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "Product")
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long id_cafeteria;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column(nullable = false)
    private String Name;

    @Column(length = 500)
    private String Description;

    private float Price;

    private int Points_awarded;

    private long id_category;

    @Column(nullable = false)
    private boolean state;


}

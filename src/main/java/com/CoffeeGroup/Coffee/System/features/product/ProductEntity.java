package com.CoffeeGroup.Coffee.System.features.product;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
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


    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    //Relacion cafeteria

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    private BigDecimal price;

    private Integer pointsAwarded;

    //Relacion categoria


    @Column(nullable = false)
    private Boolean state;


}

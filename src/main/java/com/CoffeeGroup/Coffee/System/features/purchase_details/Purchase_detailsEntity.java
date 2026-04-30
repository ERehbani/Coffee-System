package com.CoffeeGroup.Coffee.System.features.purchase_details;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Purchase_detailsEntity")
@Entity
public class Purchase_detailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long purchase_id;

    private long id_product;

    private int amount;

    private float price_unit;

    private int points_generated;

}

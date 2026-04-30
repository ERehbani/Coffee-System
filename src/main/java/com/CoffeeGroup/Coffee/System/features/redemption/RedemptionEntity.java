package com.CoffeeGroup.Coffee.System.features.redemption;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "redemptions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RedemptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false,unique = true)
    private UUID externalId;

    //Relacion cliente y beneficio

    @Column
    private Date date;

    @Column
    private Integer points_used;

    @Column
    private Boolean state;

    @Column
    private String validationCode;
}

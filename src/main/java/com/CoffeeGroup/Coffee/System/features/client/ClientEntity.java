package com.CoffeeGroup.Coffee.System.features.client;

import com.CoffeeGroup.Coffee.System.features.purchase.PurchaseEntity;
import com.CoffeeGroup.Coffee.System.features.redemption.RedemptionEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    //Usuario ID relacion

    @Column
    private String name;

    @Column
    private String profilePhoto;

    @Column
    private Integer currentPoints;

    @Column
    private Integer historicalPoints;

    @OneToMany(mappedBy = "client_id")
    private List<RedemptionEntity> List_Redemption;

    @OneToMany(mappedBy = "client_id")
    private List<PurchaseEntity> List_Purchase;

}

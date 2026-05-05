package com.CoffeeGroup.Coffee.System.features.redemption;

import com.CoffeeGroup.Coffee.System.features.client.ClientEntity;
import com.CoffeeGroup.Coffee.System.features.purchase.PurchaseEntity;
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

    @Column
    private Date date;

    @Column
    private Integer usedPoints;

    @Column
    private Boolean state;

    @Column
    private String validationCode;

    @OneToOne
    @JoinColumn(name = "purchase_id")
    private PurchaseEntity purchase_id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client_id;
}

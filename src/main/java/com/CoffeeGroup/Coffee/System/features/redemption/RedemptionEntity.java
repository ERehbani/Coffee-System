package com.CoffeeGroup.Coffee.System.features.redemption;

import com.CoffeeGroup.Coffee.System.features.benefit.BenefitEntity;
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


    @Column(name = "date_redemption")
    private Date date;

    @Column(name = "pointsused_redemption")
    private Integer points_used;

    @Column(name = "state_redemption")
    private Boolean state;

    @Column(name = "validationCode_redemption")
    private String validationCode;

    @OneToOne
    @JoinColumn(name = "purchase_id")
    private PurchaseEntity purchase;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    // --- Relacion Beneficio ---
    @ManyToOne
    @JoinColumn(name = "benefit_id")
    private BenefitEntity benefit;

}

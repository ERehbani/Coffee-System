package com.CoffeeGroup.Coffee.System.features.benefit_type;


import com.CoffeeGroup.Coffee.System.features.benefit.BenefitEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "benefits")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BenefitTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column
    private String name;

    @OneToMany(mappedBy = "benefit_type")
    private List<BenefitEntity> benefits;

}

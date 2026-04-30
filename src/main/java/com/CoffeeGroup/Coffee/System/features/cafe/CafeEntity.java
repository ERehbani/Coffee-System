package com.CoffeeGroup.Coffee.System.features.cafe;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.UUID;

@Entity
@Table(name = "cafes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CafeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String email;

    private String phoneNumber;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Boolean state;

    private String image;

    private String schedule;


}

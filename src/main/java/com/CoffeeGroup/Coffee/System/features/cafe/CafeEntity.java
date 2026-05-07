package com.CoffeeGroup.Coffee.System.features.cafe;

import com.CoffeeGroup.Coffee.System.common.Model.Email;
import com.CoffeeGroup.Coffee.System.features.product.ProductEntity;
import com.CoffeeGroup.Coffee.System.features.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.List;
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
    @Column(name = "Id_Cafe")
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column(nullable = false, name = "Name_cafe")
    private String name;

    @Column(nullable = false,name = "Address_Cafe")
    private String address;

    // --- Relacion Producto ---
    @OneToMany(mappedBy = "cafe", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ProductEntity> products;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "email_address", unique = true, nullable = false))
    private Email email;

    @Column(name = "PhoneNumber_cafe")
    private String phoneNumber;


    @Column(length = 500, name = "Description_cafe")
    private String description;

    @Column(nullable = false,name = "State_Cafe")
    private Boolean state;

    @Column(name= "Image_cafe")
    private String image;
    @Column(name = "schedule_cafe")
    private String schedule;

    @ManyToMany
    @JoinTable(
            name = "cafe_user",
            joinColumns = @JoinColumn(name = "cafe_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserEntity> users;
}

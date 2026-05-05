package com.CoffeeGroup.Coffee.System.features.cafe;

import com.CoffeeGroup.Coffee.System.common.model.Email;
import com.CoffeeGroup.Coffee.System.features.product.ProductEntity;
import com.CoffeeGroup.Coffee.System.features.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.List;
import java.util.Set;
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

    // --- Relacion Producto ---
    @OneToMany(mappedBy = "cafe", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ProductEntity> products;

    //@Column(nullable = false, unique = true)
    @AttributeOverride(name = "value", column = @Column(name = "email", unique = true, nullable = false))
    private Email email; //Se declara de esta manera para que adopte las regex que se declaran en common/model

    private String phoneNumber;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Boolean state;

    private String image;

    private String schedule;

    // Relacion muchos a muchos de usuarios x cafeteria
    @ManyToMany
    @JoinTable(
            name = "cafe_x_user",
            joinColumns =  @JoinColumn(name = "cafe_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserEntity> users;


}
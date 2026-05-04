package com.CoffeeGroup.Coffee.System.features.user;

import com.CoffeeGroup.Coffee.System.features.cafe.CafeEntity;
import com.CoffeeGroup.Coffee.System.features.client.ClientEntity;
import com.CoffeeGroup.Coffee.System.features.role.RoleEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @Column
    private String password;

    @Column
    private Boolean state;

    @Column
    private Date creationDate;

    //Relacion Rol


    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @ManyToMany(mappedBy = "users")
    private List<CafeEntity> cafes;

    @OneToOne(mappedBy = "usuario")
    private ClientEntity cliente;
}

package com.CoffeeGroup.Coffee.System.features.product;
import com.CoffeeGroup.Coffee.System.features.cafe.CafeEntity;
import com.CoffeeGroup.Coffee.System.features.category.CategoryEntity;
import com.CoffeeGroup.Coffee.System.features.purchase_details.PurchaseDetailsEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Struct;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "Products")
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private long id;


    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    // --- Relacion Cafeteria ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cafe")
    @ToString.Exclude
    private CafeEntity cafe;

    @Column(nullable = false,name = "name_product")
    private String name;

    @Column(length = 500,name = "description_product")
    private String description;

    @Column(name = "price_product")
    private BigDecimal price;

    @Column(name = "pointsAwarded_product")
    private Integer pointsAwarded;

    // --- Relacion Categoria ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    @ToString.Exclude
    private CategoryEntity category;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<PurchaseDetailsEntity> purchaseDetails;


    @Column(nullable = false,name = "State_product")
    private Boolean state;


}

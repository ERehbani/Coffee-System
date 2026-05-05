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
@Table(name = "Product")
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    // --- Relacion Cafeteria ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")
    @ToString.Exclude
    private CafeEntity cafe;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    private BigDecimal price;

    private Integer pointsAwarded;

    // --- Relacion Categoria ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private CategoryEntity category;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<PurchaseDetailsEntity> purchaseDetails;


    @Column(nullable = false)
    private Boolean state;


}

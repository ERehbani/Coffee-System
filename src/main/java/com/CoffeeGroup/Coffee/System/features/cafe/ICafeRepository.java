package com.CoffeeGroup.Coffee.System.features.cafe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICafeRepository extends JpaRepository <CafeEntity, Long> {
    boolean existsById(UUID externalId);
}

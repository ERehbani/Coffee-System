package com.CoffeeGroup.Coffee.System.features.cafe.domain.dto;

import java.util.UUID;

public record CafeRequest(UUID externalId, String name) {
}

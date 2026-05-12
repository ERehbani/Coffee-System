package com.CoffeeGroup.Coffee.System.features.cafe.domain.dto;

import java.util.UUID;

public record CafeResponse(UUID externalId, String name, String phoneNumber, String description) {
}

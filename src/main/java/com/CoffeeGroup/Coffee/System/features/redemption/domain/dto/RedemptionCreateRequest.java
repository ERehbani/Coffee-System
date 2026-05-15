package com.CoffeeGroup.Coffee.System.features.redemption.domain.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RedemptionCreateRequest(

        @NotNull(message = "The customer ID is required")
        UUID clientid,

        @NotNull(message = "The Benefit ID is required")
        UUID benefitid,

        @NotNull(message = "The Purchase ID is required")
        UUID purchaseid

) {}

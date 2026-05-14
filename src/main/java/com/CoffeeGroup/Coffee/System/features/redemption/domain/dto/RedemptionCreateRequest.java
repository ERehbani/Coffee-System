package com.CoffeeGroup.Coffee.System.features.redemption.domain.dto;

import jakarta.validation.constraints.NotNull;

public record RedemptionCreateRequest(

        @NotNull(message = "The customer ID is required")
        Long clientid,

        @NotNull(message = "The Benefit ID is required")
        Long benefitid,

        @NotNull(message = "The Purchase ID is required")
        Long purchaseid

) {}

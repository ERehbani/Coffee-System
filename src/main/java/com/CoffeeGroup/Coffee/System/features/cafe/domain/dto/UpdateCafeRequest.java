package com.CoffeeGroup.Coffee.System.features.cafe.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateCafeRequest(

        @NotBlank(message = "La dirección es obligatoria")

        String address,

        @NotBlank(message = "El email es obligatorio")

        @Email(message = "Debe tener un formato de email válido")

        String email, // en el servicio lo convertimos al objeto Email

        String phoneNumber,

        @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")

        String description,

        String schedule,

        String image

) {
}

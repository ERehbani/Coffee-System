package com.CoffeeGroup.Coffee.System.features.user.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateUserRequest(
        @Email(message = "El email no es válido")
        String email,

        @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
                message = "La contraseña debe tener al menos una mayúscula, una minúscula y un número"
        )
        String password,

        Boolean state,

        Long roleId
        ) {
}

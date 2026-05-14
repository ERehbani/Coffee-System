package com.CoffeeGroup.Coffee.System.features.user.domain.dto;

import jakarta.validation.constraints.*;

public record CreateUserRequest(
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Email no valido")
    String email,

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "Ea contraseña debe tener al menos una mayuscula, una minuscula y un numero"
    )
    String password,

    @NotNull(message = "El rol es obligatorio")
    Long roleId

) {
}

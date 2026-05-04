package com.login.ecommerce_api.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest (
    @NotBlank(message = "Username no puede ser vacio") String username,
    @NotBlank(message = "password no puede ser vacio") String password){

}

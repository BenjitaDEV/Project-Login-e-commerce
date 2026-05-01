package com.login.ecommerce_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration //marca esta clase como configuracion de spring
public class SecurityConfig {

    @Bean // ejecuta este metodo y guarda el resultado
    public PasswordEncoder passwordEncoder(){ //define un metodo que devuelve un PasswordEncoder
        return new BCryptPasswordEncoder(); //Crea un objeto "BCrypt" algoritmo para encriptar contraseñas
    }

}

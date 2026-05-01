package com.login.ecommerce_api.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.ecommerce_api.model.Role;
import com.login.ecommerce_api.model.User;
import com.login.ecommerce_api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticatorService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //REGISTRO
    public User register(String username, String password){

        //validar si ya existe
        if (userRepository.findByUsername(username).isPresent()){ //evita dupiclados
            throw new RuntimeException("el username ya existe");
        }

        //encriptar el password
        String encodedPassword = passwordEncoder.encode(password);

        //Crear usuario
        User user = User.builder()
                    .username(username)
                    .password(encodedPassword)//encriptado
                    .role(Role.USER)
                    .build();

        //Guardar en base de datos
        return userRepository.save(user);
        
    }

    // Logeo
    public User login(String username, String password){
        //buscar usuario
        User user = userRepository.findByUsername(username) //Busca en la BD por username
        .orElseThrow(() -> new RuntimeException("usuario no encontrado")); //si no encuentra al usuario lanza un error

        //validar password busca usuario, valida passsword y retorna user
        //compara passoword con user.getPassword()
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new RuntimeException("Contraseña incorrecta");

    }

}

package org.example.repository;

import ch.qos.logback.classic.Logger;
import org.example.api.UserApiRest;
import org.example.api.createupdatedelete.Response;
import org.example.creditcard.repositories.CreditCardRepository;
import org.example.exceptions.UserNotFoundException;
import org.example.mappers.UserMapper;
import org.example.models.Usuario;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

public class UserRemoteRepository {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(UserRemoteRepository.class);
    private final UserApiRest userApiRest;

    public UserRemoteRepository(UserApiRest userApiRest) {
        this.userApiRest = userApiRest;
    }

    public List<Usuario> getAll() {
        logger.info("Obteniendo todos los usuarios...");
        var call = userApiRest.getAll();

        try{
            var response = call.get();
            return response.stream()
                    .map(UserMapper::toUserFromCreate)
                    .toList();
        }catch(Exception e){
            e.printStackTrace();
            return List.of();
        }
    }

    public Usuario getById(int id){
        logger.info("Obteniendo usuario con id: " + id);
        var call = userApiRest.getById(id);

        try{
            var response = call.get();
            return UserMapper.toUserFromCreate(response);

        }catch(Exception e){
            throw new UserNotFoundException("User " + id + "" + " not found");
        }
    }

    public Usuario create(Response response) {
        logger.info("Creando usuario...");
        return Usuario.builder()
                .id((long)response.getId())
                .name(response.getName())
                .username(response.getUsername())
                .email(response.getEmail())
                .createdAt(LocalDateTime.parse(response.getCreatedAt()))
                .updatedAt(LocalDateTime.parse(response.getCreatedAt()))
                .build();
    }

}

package org.example.mappers;

import org.example.users.api.createupdatedelete.Request;
import org.example.users.api.createupdatedelete.Response;
import org.example.users.api.getAll.ResponseUserGetAll;
import org.example.users.api.getById.ResponseUserGetByid;
import org.example.models.Usuario;
import org.example.users.api.getByName.ResponseUserGetByName;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class UserMapper {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(UserMapper.class);

    /**
     * Convertir un ResponseUserGetAll a un Usuario.
     * @param responseUserGetAll el objeto que contiene los datos del usuario
     * @return un objeto de tipo Usuario con los datos del usuario
     * @author Javier Hernandez, Yahya el hadri, Javier Ruiz, Alvaro herrero, Samuel Cortes, Raul Fernandez
     * @version 1.0
     */
    public static Usuario toUserFromCreate(ResponseUserGetAll responseUserGetAll) {
        return Usuario.builder()
                .id((long) responseUserGetAll.getId())
                .name(responseUserGetAll.getName())
                .username(responseUserGetAll.getUsername())
                .email(responseUserGetAll.getEmail())
                .build();
    }
    public static Usuario toUserFromCreate(ResponseUserGetByName responseUserGetByName) {
        return Usuario.builder()
                .id((long) responseUserGetByName.getId())
                .name(responseUserGetByName.getName())
                .username(responseUserGetByName.getUsername())
                .email(responseUserGetByName.getEmail())
                .build();
    }

    /**
     * Convertir un ResponseUserGetByid a un Usuario.
     * @param responseUserGetByid el objeto que contiene los datos del usuario
     * @return un objeto de tipo Usuario con los datos del usuario
     * @author Javier Hernandez, Yahya el hadri, Javier Ruiz, Alvaro herrero, Samuel Cortes, Raul Fernandez
     * @version 1.0
     */
    public static Usuario toUserFromCreate(ResponseUserGetByid responseUserGetByid) {
        return Usuario.builder()
                .id((long) responseUserGetByid.getId())
                .name(responseUserGetByid.getName())
                .username(responseUserGetByid.getUsername())
                .email(responseUserGetByid.getEmail())
                .build();
    }

    /**
     * Convertir un Response a un Usuario.
     * @param response el objeto que contiene los datos del usuario
     * @return un objeto de tipo Usuario con los datos del usuario
     * @author Javier Hernandez, Yahya el hadri, Javier Ruiz, Alvaro herrero, Samuel Cortes, Raul Fernandez
     * @version 1.0
     */
    public static Usuario toUserFromCreate(Response response) {
        return Usuario.builder()
                .id((long) response.getId())
                .name(response.getName())
                .username(response.getUsername())
                .email(response.getEmail())
                .createdAt(LocalDateTime.parse(response.getCreatedAt()))
                .updatedAt(LocalDateTime.parse(response.getUpdatedAt()))
                .build();
    }

    /**
     * Convertir un objeto Usuario a un Request.
     * @param usuario el objeto que contiene los datos del usuario
     * @return un objeto de tipo Request con los datos del usuario
     * @author Javier Hernandez, Yahya el hadri, Javier Ruiz, Alvaro herrero, Samuel Cortes, Raul Fernandez
     * @version 1.0
     */
    public static Request toRequest(Usuario usuario) {
        return Request.builder()
                .id(Math.toIntExact(usuario.getId()))
                .name(usuario.getName())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .build();
    }

    /**
     * Convertir un Response a un Usuario.
     * @param response el objeto que contiene los datos del usuario
     * @param id       el id del usuario
     * @return un objeto de tipo Usuario con los datos del usuario
     * @author Javier Hernandez, Yahya el hadri, Javier Ruiz, Alvaro herrero, Samuel Cortes, Raul Fernandez
     * @version 1.0
     */

    public static Usuario toUserFromUpdate(Response response, Long id) {
        return Usuario.builder()
                .id((long) id)
                .name(response.getName())
                .username(response.getUsername())
                .email(response.getEmail())
                .createdAt(LocalDateTime.parse(response.getCreatedAt()))
                .updatedAt(LocalDateTime.parse(response.getUpdatedAt()))
                .build();
    }

    /**
     * Convertir un Response a un Usuario.
     * @param usuario
     * @return un objeto de tipo Usuario con los datos del usuario
     * @author Javier Hernandez, Yahya el hadri, Javier Ruiz, Alvaro herrero, Samuel Cortes, Raul Fernandez
     * @version 1.0
     */

    public static Response toResponse(Usuario usuario) {
        return Response.builder()
                .id(Math.toIntExact(usuario.getId()))
               .name(usuario.getName())
               .username(usuario.getUsername())
               .email(usuario.getEmail())
               .createdAt(usuario.getCreatedAt().toString())
               .updatedAt(usuario.getUpdatedAt().toString())
               .build();
    }


}

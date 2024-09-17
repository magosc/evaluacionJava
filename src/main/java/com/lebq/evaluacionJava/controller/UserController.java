package com.lebq.evaluacionJava.controller;

import com.lebq.evaluacionJava.dto.UserRequest;
import com.lebq.evaluacionJava.exception.ErrorResponse;
import com.lebq.evaluacionJava.exception.UserAlreadyExistsException;
import com.lebq.evaluacionJava.model.User;
import com.lebq.evaluacionJava.repository.UserRepository;
import com.lebq.evaluacionJava.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@Api(value = "API Usuarios", description = "Operaciones para la gestion de usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "Crea un nuevo usuario", notes = "Crea un nuevo usuario generando su token JWT y lo persiste en la BD")
    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequest userRequest,
                                        BindingResult result){
        if(result.hasErrors()){
            String errorMessage = result.getFieldError().getDefaultMessage();
            return new ResponseEntity<>(new ErrorResponse(errorMessage), HttpStatus.BAD_REQUEST);
        }

        if(userRepository.findByEmail(userRequest.getEmail()).isPresent()){
            throw new UserAlreadyExistsException("El correo ya esta registrado");
        }

        User user = userService.createUser(userRequest);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}

/*
package com.lebq.evaluacionJava.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lebq.evaluacionJava.dto.UserRequest;
import com.lebq.evaluacionJava.exception.UserAlreadyExistsException;
import com.lebq.evaluacionJava.model.User;
import com.lebq.evaluacionJava.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateUser() throws Exception{
        UserRequest userRequest = new UserRequest();
        userRequest.setName("Luis Barboza");
        userRequest.setEmail("luis@barboza.com");
        userRequest.setPassword("Ligjm5@");

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setToken("fake-jwt-token");

        when(userService.createUser(any(UserRequest.class))).thenReturn(user);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Luis Barboza"))
                .andExpect(jsonPath("$.email").value("luis@barboza.com"))
                .andExpect(jsonPath("$.token").value("fake-jwt-token"));
    }

    @Test
    void testCreateUserWithDuplicateEmail() throws Exception{
        UserRequest userRequest = new UserRequest();
        userRequest.setName("Luis Barboza");
        userRequest.setEmail("luis@barboza.com");
        userRequest.setPassword("Ligjm5@");

        when(userService.createUser(any(UserRequest.class))).thenThrow(new UserAlreadyExistsException("El correo ya esta registrado"));

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message").value("El correo ya esta registrado"));
    }
}
*/

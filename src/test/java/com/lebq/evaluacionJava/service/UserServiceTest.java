package com.lebq.evaluacionJava.service;

import com.lebq.evaluacionJava.dto.PhoneRequest;
import com.lebq.evaluacionJava.dto.UserRequest;
import com.lebq.evaluacionJava.model.User;
import com.lebq.evaluacionJava.repository.UserRepository;
import com.lebq.evaluacionJava.util.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateUserSuccess(){
        UserRequest userRequest = new UserRequest();
        userRequest.setName("Luis Barboza");
        userRequest.setEmail("luis@barboza.com");
        userRequest.setPassword("Ligjm5@");

        PhoneRequest phoneRequest = new PhoneRequest();
        phoneRequest.setNumber("999999999");
        phoneRequest.setCityCode("1");
        phoneRequest.setCountryCode("2");
        List<PhoneRequest> phones = new ArrayList<>();
        phones.add(phoneRequest);

        userRequest.setPhones(phones);

        when(jwtUtil.generateToken(userRequest.getEmail())).thenReturn("fake-jwt-token");

        when(userRepository.save(any(User.class))).thenAnswer(invocationOnMock -> {
            User user = invocationOnMock.getArgument(0);
            user.setId(UUID.randomUUID());
            return user;
        });

        User createdUser = userService.createUser(userRequest);

        assertNotNull(createdUser);
        assertEquals("Luis Barboza", createdUser.getName());
        assertEquals("luis@barboza.com", createdUser.getEmail());
        assertEquals("fake-jwt-token", createdUser.getToken());
    }
}

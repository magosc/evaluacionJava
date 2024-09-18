package com.lebq.evaluacionJava.service;

import com.lebq.evaluacionJava.config.PasswordConfig;
import com.lebq.evaluacionJava.dto.UserRequest;
import com.lebq.evaluacionJava.exception.InvalidPasswordException;
import com.lebq.evaluacionJava.model.Phone;
import com.lebq.evaluacionJava.model.User;
import com.lebq.evaluacionJava.repository.UserRepository;
import com.lebq.evaluacionJava.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordConfig passwordConfig;

    @Transactional
    public User createUser(UserRequest userRequest){
        if(!Pattern.matches(passwordConfig.getPasswordRegex(), userRequest.getPassword())){
            throw new InvalidPasswordException("La contraseña no cumple con el formato requerido");
        }

        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());  // Se debería encriptar la contraseña
        user.setCreated(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setActive(true);

        String token = jwtUtil.generateToken(user.getEmail());
        user.setToken(token);

        List<Phone> phones = userRequest.getPhones().stream()
                .map(phoneRequest -> {
                    Phone phone = new Phone();
                    phone.setNumber(phoneRequest.getNumber());
                    phone.setCityCode(phoneRequest.getCityCode());
                    phone.setCountryCode(phoneRequest.getCountryCode());
                    return phone;
                }).collect(Collectors.toUnmodifiableList());

        user.setPhones(phones);

        return userRepository.save(user);
    }
}

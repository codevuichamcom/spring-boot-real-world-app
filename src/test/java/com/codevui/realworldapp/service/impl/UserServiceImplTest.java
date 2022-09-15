package com.codevui.realworldapp.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.codevui.realworldapp.entity.User;
import com.codevui.realworldapp.exception.custom.CustomBadRequestException;
import com.codevui.realworldapp.model.user.dto.UserDTOLoginRequest;
import com.codevui.realworldapp.model.user.dto.UserDTOResponse;
import com.codevui.realworldapp.repository.UserRepository;
import com.codevui.realworldapp.util.JwtTokenUtil;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private JwtTokenUtil jwtTokenUtil;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void testAuthenticate() throws CustomBadRequestException {

        // given

        Map<String, UserDTOLoginRequest> userLoginRequestMap = new HashMap<>();
        userLoginRequestMap.put("user", UserDTOLoginRequest.builder().email("quan@gmail.com").password("123").build());

        Map<String, UserDTOResponse> resultExpect = new HashMap<>();
        resultExpect.put("user", UserDTOResponse.builder().email("quan@gmail.com").build());

        // when

        Optional<User> userOptional = Optional
                .of(User.builder().id(1).email("quan@gmail.com").username("quan").password("123").build());
        when(userRepository.findByEmail("quan@gmail.com")).thenReturn(userOptional);
        when(passwordEncoder.matches("123", "123")).thenReturn(true);
        when(jwtTokenUtil.generateToken(userOptional.get(), 24 * 60 * 60)).thenReturn("TOKEN");

        // then

        Map<String, UserDTOResponse> resultActual = userService.authenticate(userLoginRequestMap);
        assertEquals(resultExpect.containsKey("user"), resultActual.containsKey("user"));
        UserDTOResponse userResponseActual = resultActual.get("user");
        assertEquals("quan@gmail.com", userResponseActual.getEmail());
        assertEquals("TOKEN", userResponseActual.getToken());
    }

    @Test
    void testFollowUser() {

    }

    @Test
    void testGetCurrentUser() {

    }

    @Test
    void testGetProfile() {

    }

    @Test
    void testGetUserLoggedIn() {

    }

    @Test
    void testRegisterUser() {

    }

    @Test
    void testUnfollowUser() {

    }
}

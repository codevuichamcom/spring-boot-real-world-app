package com.codevui.realworldapp.model.user.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.codevui.realworldapp.entity.User;
import com.codevui.realworldapp.model.user.dto.UserDTOResponse;

@ExtendWith(MockitoExtension.class)
public class UserMapperTest {
    @Test
    void testToUser() {

        User user = User.builder().username("Quan").build();

        UserDTOResponse resultExpect = UserDTOResponse.builder().username("Quan").build();

        assertEquals(resultExpect, UserMapper.toUserDTOResponse(user));
    }

    @Test
    void testToUserDTOResponse() {

    }
}

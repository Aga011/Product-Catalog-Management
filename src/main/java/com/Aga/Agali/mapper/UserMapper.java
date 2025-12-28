package com.Aga.Agali.mapper;

import com.Aga.Agali.dto.request.RegisterRequest;
import com.Aga.Agali.dto.response.UserResponse;
import com.Aga.Agali.entity.User;
import com.Aga.Agali.entity.Role;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public User toEntity(RegisterRequest request) {
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .nickName(request.getNickName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(request.getPassword())
                .role(Role.Role_USER)
                .build();
    }

    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .nickName(user.getNickName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .build();
    }
}

package com.Aga.Agali.controller.user;

import com.Aga.Agali.dto.request.LoginUserRequest;
import com.Aga.Agali.dto.request.RegisterRequest;
import com.Aga.Agali.dto.response.UserResponse;
import com.Aga.Agali.entity.User;
import jakarta.validation.Valid;

public interface IAuthController {
    UserResponse register(@Valid RegisterRequest request);
    UserResponse login(@Valid LoginUserRequest userRequest);
    User createAdmin(@Valid RegisterRequest request);
}

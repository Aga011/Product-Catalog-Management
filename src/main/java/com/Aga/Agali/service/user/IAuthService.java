package com.Aga.Agali.service.user;

import com.Aga.Agali.dto.request.RegisterRequest;
import com.Aga.Agali.dto.response.UserResponse;

public interface IAuthService {
    UserResponse register(RegisterRequest request);
    UserResponse login(String nickName, String password);
}

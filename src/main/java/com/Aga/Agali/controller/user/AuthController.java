package com.Aga.Agali.controller.user;

import com.Aga.Agali.dto.request.LoginUserRequest;
import com.Aga.Agali.dto.request.RegisterRequest;
import com.Aga.Agali.dto.response.UserResponse;
import com.Aga.Agali.entity.User;
import com.Aga.Agali.service.user.IAuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/auth")
public class AuthController implements IAuthController {
    private final IAuthService service;

    @Override
    @PostMapping("/register")
    @Transactional
    public UserResponse register(@RequestBody RegisterRequest request) {
        return service.register(request);
    }

    @Override
    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginUserRequest userRequest) {
        return service.login(userRequest.getNickName(), userRequest.getPassword());

    }
    @Override
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public User createAdmin(@RequestBody RegisterRequest request){
        return service.createAdmin(request);
    }
}

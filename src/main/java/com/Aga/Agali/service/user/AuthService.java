package com.Aga.Agali.service.user;

import com.Aga.Agali.dto.request.RegisterRequest;
import com.Aga.Agali.dto.response.UserResponse;
import com.Aga.Agali.entity.Role;
import com.Aga.Agali.entity.User;
import com.Aga.Agali.mapper.UserMapper;
import com.Aga.Agali.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email artıq mövcuddur");
        }
        if (userRepository.existsByNickName(request.getNickName())) {
            throw new IllegalArgumentException("Nickname artıq mövcuddur");
        }
        if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new IllegalArgumentException("Telefon nömrəsi artıq mövcuddur");
        }

        User user = userMapper.toEntity(request);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserResponse login(String nickname, String password) {
        User user = userRepository.findByNickName(nickname)
                .orElseThrow(() -> new IllegalArgumentException("User tapılmadı"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Şifrə yanlışdır");
        }

        return userMapper.toResponse(user);
    }
    public User createAdmin(RegisterRequest request) {
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .nickName(request.getNickName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();
    }
}

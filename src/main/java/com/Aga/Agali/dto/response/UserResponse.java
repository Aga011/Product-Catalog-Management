package com.Aga.Agali.dto.response;

import com.Aga.Agali.entity.Role;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String phoneNumber;
    private Role role;
}

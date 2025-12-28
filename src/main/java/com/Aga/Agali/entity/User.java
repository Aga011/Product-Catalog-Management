package com.Aga.Agali.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users",schema = "catalog_management")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",nullable = false)
    @NotBlank(message = "Ad boş ola bilməz")
    @Size(min = 3,max = 20,message = "Ad 3-20 simvol arası olmalıdır")
    private String firstName;
    @Column(name = "last_name",nullable = false)
    @NotBlank(message = "Soyad boş ola bilməz")
    @Size(min = 3,max = 20,message = "Soyad 3-20 simvol arası olmalıdır")
    private String lastName;
    @Column(name = "nick_name",nullable = false,unique = true)
    @NotBlank(message = "Nickname boş ola bilməz")
    @Size(min = 3, max = 20,
            message = "Nickname 3-20 simvol arası olmalıdır")
    @Pattern(
            regexp = "^[a-zA-Z0-9_]+$",
            message = "Nickname yalnız hərf, rəqəm və alt xətdən ibarət ola bilər"
    )
    private String nickName;
    @Column(nullable = false,unique = true)
    @NotBlank(message = "Email boş ola bilməz")
    @Email(message = "Email formatı yanlışdır")
    private String email;
    @Column(nullable = false,unique = true)
    @NotBlank(message = "Telefon nömrəsi boş ola bilməz")
    @Pattern(
            regexp = "^\\+994(50|51|55|70|77|99)\\d{7}$",
            message = "Telefon nömrəsi düzgün formatda deyil"
    )
    private String phoneNumber;
    @Column(nullable = false)
    @NotBlank(message = "Şifrə boş ola bilməz")
    @Size(min = 8, message = "Şifrə minimum 8 simvol olmalıdır")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Şifrə minimum 8 simvol, 1 böyük, 1 kiçik hərf, 1 rəqəm və 1 xüsusi simvoldan ibarət olmalıdır"
    )
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}

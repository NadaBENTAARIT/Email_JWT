package com.loterie.loterie.Dto;

import com.loterie.loterie.entity.Role;
import com.loterie.loterie.enums.ERole;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto implements Serializable {
    private Long id;

    private String username;
    private String email;
    private String password;

    private String tel;
    private Role role;



}
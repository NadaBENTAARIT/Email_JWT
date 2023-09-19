package com.loterie.loterie.Dto;

import com.loterie.loterie.entity.User;
import com.loterie.loterie.enums.ERole;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDto  implements Serializable {

    private Long id;
    private ERole role;
    private String description;
    private User user;

}

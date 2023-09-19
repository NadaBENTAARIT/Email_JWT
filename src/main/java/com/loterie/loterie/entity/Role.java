package com.loterie.loterie.entity;


import javax.persistence.*;

import com.loterie.loterie.enums.ERole;
import com.sun.istack.NotNull;
import lombok.*;
@Data

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING) // Spécifie que l'énumération sera persistée en tant que chaîne de caractères
    @Column
    private ERole role;


    @NotNull
    @Column
    private String description;

    @OneToOne()
    private User user;





    public Role() {
        super();
    }

}


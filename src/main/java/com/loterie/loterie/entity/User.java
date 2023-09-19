package com.loterie.loterie.entity;


import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;
@Data

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String username;


    @NotNull
    @Column
    private String email;


    @NotNull
    @Column
    private String password;

    @NotNull
    @Column
    private String tel;


    @OneToOne()
    private Role role;



    public User(String username, String email, String tel, String password, Role role) {
        this.username = username;
        this.email = email;
        this.tel = tel;
        this.password = password;
        this.role=role;
    }


    public User() {
        super();
    }


}


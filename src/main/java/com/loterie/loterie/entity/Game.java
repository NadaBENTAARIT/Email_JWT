package com.loterie.loterie.entity;


import javax.persistence.*;

import com.loterie.loterie.enums.ERole;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.Date;

@Data

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @Column
    private Date start_date;


    @NotNull
    @Column
    private Date end_date;


    @NotNull
    @Column
    private Long winning_amount;

    @NotNull
    @Column
    private Boolean active;


    @OneToOne()
    private User user;





    public Game() {
        super();
    }

}


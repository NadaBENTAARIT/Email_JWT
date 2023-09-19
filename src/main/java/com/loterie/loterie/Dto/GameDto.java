package com.loterie.loterie.Dto;


import java.io.Serializable;


import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GameDto  implements Serializable {
    private Long id;

    private Date start_date;

    private Date end_date;

    private Long winning_amount;

    private Boolean active;




}
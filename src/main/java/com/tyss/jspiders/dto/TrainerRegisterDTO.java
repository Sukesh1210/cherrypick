package com.tyss.jspiders.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
public class TrainerRegisterDTO {
    private String TrainerId;
    private String name;
    private String password;
}

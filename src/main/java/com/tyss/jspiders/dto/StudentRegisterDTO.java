package com.tyss.jspiders.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
public class StudentRegisterDTO {
    private String StudentId;
    private String name;
    private String password;
}

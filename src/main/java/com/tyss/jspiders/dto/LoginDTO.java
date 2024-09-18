package com.tyss.jspiders.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
public class LoginDTO {
    private String username;
    private String password;
}

package com.tyss.jspiders.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
public class EmployeeDTO {
    private String employeeId;
    private String name;
    private String password;
}

package com.tyss.jspiders.entity;

import lombok.*;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class AppUser {
    @Id
    private String username;
    private String password;


    @ManyToMany(
            cascade=CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Role> roles;
}

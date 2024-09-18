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
public class Role {
    @GeneratedValue
    @Id
    private Integer roleId;
    private String name;

    @ManyToMany(
            mappedBy = "roles",
            cascade= CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<AppUser> appUsers;
}

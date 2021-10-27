package com.viqsystems.multiplication.Users.Entities;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    private String alias;

    public Users(final String userAlias) {
        this(null, userAlias);
    }

}

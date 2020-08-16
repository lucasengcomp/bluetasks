package com.bluetasks.api.domain.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue
    @Getter
    private Integer id;

    @Getter
    @Setter
    @NotEmpty(message = "O nome do usuário é obrigatório.")
    private String username;

    @Getter
    @Setter
    @NotEmpty(message = "A senha é obrigatória.")
    private String password;

    @Getter
    @Setter
    @NotEmpty(message = "O nome de exibição é obrigatório.")
    private String displayName;

    public AppUser() {

    }

    public AppUser(String username, String password, String displayName) {
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

}


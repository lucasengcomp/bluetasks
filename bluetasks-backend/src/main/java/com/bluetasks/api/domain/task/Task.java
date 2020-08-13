package com.bluetasks.api.domain.task;

import com.bluetasks.api.domain.user.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue
    @Getter
    private Integer id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private LocalDate whenToDo;

    @Getter
    @Setter
    private Boolean done = false;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    @Getter
    @Setter
    private AppUser appUser;

    public Task() {
    }

    public Task(String description, LocalDate whenToDo, Boolean done) {
        this.description = description;
        this.whenToDo = whenToDo;
        this.done = done;
    }

}

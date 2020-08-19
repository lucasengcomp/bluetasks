package com.bluetasks.api.domain.task;


import com.bluetasks.api.domain.user.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@EntityListeners(TaskListener.class)
@Entity
public class Task {

    @Id
    @GeneratedValue
    @Getter
    private Integer id;

    @Getter
    @Setter
    @NotEmpty(message = "A descrição da tarefa é obrigatória")
    private String description;

    @Getter
    @Setter
    @NotNull(message = "A data da tarefa é obrigatória")
    @FutureOrPresent(message = "A data da tarefa não pode estar no passado")
    private LocalDate whenToDo;

    @Getter
    @Setter
    private Boolean done = false;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    @NotNull(message = "O usuário da tarefa é obrigatório")
    @JsonIgnore
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

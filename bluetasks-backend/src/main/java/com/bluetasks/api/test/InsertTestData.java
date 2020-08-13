package com.bluetasks.api.test;

import com.bluetasks.api.domain.task.Task;
import com.bluetasks.api.domain.task.TaskRepository;
import com.bluetasks.api.domain.user.AppUser;
import com.bluetasks.api.domain.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InsertTestData {

    private TaskRepository taskRepository;
    private AppUserRepository appUserRepository;

    @Autowired
    public InsertTestData(AppUserRepository appUserRepository, TaskRepository taskRepository) {
        this.appUserRepository = appUserRepository;
        this.taskRepository = taskRepository;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //TODO: Criptografar senha
        AppUser appUser = new AppUser("Jhon", "abc", "Jhon Coder");

        appUserRepository.save(appUser);

        LocalDate baseDate = LocalDate.parse("2025-01-01");
        for (int i = 1; i<10; i++) {
            Task task = new Task("Tarefa #" + i, baseDate.plusDays(i), false);
            task.setAppUser(appUser);
            taskRepository.save(task);
        }
    }
}

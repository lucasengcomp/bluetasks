package com.bluetasks.api.test;

import com.bluetasks.api.domain.task.Task;
import com.bluetasks.api.domain.task.TaskRepository;
import com.bluetasks.api.domain.user.AppUser;
import com.bluetasks.api.domain.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
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

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        AppUser appUser1 = new AppUser("Jhon", encoder.encode("abc"), "Jhon Coder");

        AppUser appUser2 = new AppUser("paul", encoder.encode("cba"), "paul Jdev");

        appUserRepository.save(appUser1);
        appUserRepository.save(appUser2);

        LocalDate baseDate = LocalDate.parse("2025-01-01");
        for (int i = 1; i < 10; i++) {
            Task task = new Task(String.format("Tarefa do %s #%d", appUser1.getUsername(), i), baseDate.plusDays(i), false);
            task.setAppUser(appUser1);
            taskRepository.save(task);
        }

        for (int i = 1; i < 10; i++) {
            Task task = new Task(String.format("Tarefa do %s #%d", appUser2.getUsername(), i), baseDate.plusDays(i), false);
            task.setAppUser(appUser2);
            taskRepository.save(task);
        }
    }
}

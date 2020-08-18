package com.bluetasks.api.domain.task;

import com.bluetasks.api.domain.user.AppUser;
import com.bluetasks.api.domain.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PrePersist;

@Component
public class TaskListener {

    @Autowired
    private static AppUserRepository appUserRepository;

    @PrePersist
    public void onPrePersistHandler(Task task) {
        if (task.getAppUser() == null) {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            AppUser appUser = appUserRepository.findByUsername(username);

            if (appUser == null) {
                throw new EntityNotFoundException("O usuário" + username + " não foi encontrado!");
            }

            task.setAppUser(appUser);
        }
    }

    public void init() {
        TaskListener.appUserRepository = appUserRepository;
    }
}

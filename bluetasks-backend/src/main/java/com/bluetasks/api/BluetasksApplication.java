package com.bluetasks.api;

import com.bluetasks.api.domain.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class BluetasksApplication implements RepositoryRestConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(BluetasksApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BluetasksApplication.class, args);
        logger.info("Aplicação rodando normalmente!");
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.getCorsRegistry()
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");

        logger.info("Repository Cors Setup...OK");

        config.exposeIdsFor(Task.class);
    }

    private Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener vrel) {
        Validator validator = validator();
        vrel.addValidator("beforeCreate", validator);
        vrel.addValidator("beforeSave", validator);

        logger.info("Configure validator... ok!");
    }

}

package com.bluetasks.api.domain.task;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Mapeado com PagingAndSortingRepository para suportar a ordenação
 * por data. Classe herda de CrudRepository
 * */
@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Integer> {

    Task findByDescription(String description);
}

package com.webexecuter.task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
@RepositoryRestResource(exported = false)
public interface TaskRepository extends CrudRepository<Task, Integer> {
    
    public default Task findByName(String name) {
        Iterable<Task> tasks = this.findAll();
        for (Task task : tasks) {
            if (task.getName() == name) {
                return task;
            }
        }
        throw new IllegalArgumentException(name);
    }
}

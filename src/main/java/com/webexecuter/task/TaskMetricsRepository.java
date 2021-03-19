package com.webexecuter.task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "tasks", collectionResourceRel = "tasks")
public interface TaskMetricsRepository extends CrudRepository<TaskMetrics, Integer> {

}

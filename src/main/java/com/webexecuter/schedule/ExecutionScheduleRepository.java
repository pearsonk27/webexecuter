package com.webexecuter.schedule;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface ExecutionScheduleRepository extends CrudRepository<ExecutionSchedule, Integer> {
    
}

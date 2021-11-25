package com.webexecuter.execution;

import java.util.ArrayList;
import java.util.List;

import com.webexecuter.schedule.ExecutionSchedule;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface ExecutionLogRepository extends CrudRepository<ExecutionLog, Integer> {
    
    public default List<ExecutionLog> findExecutionsBySchedule(ExecutionSchedule executionSchedule) {
        Iterable<ExecutionLog> executions = this.findAll();
        List<ExecutionLog> foundExecutions = new ArrayList<>();
        for (ExecutionLog execution : executions) {
            if (execution.getExecutionSchedule().getId() == executionSchedule.getId()) {
                foundExecutions.add(execution);
            }
        }
        return foundExecutions;
    }
}

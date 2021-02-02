package com.webexecutor.ui;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskMetricsRepository extends JpaRepository<TaskMetrics, Integer> {
    
}

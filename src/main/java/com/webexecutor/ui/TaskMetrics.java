package com.webexecutor.ui;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "task_metrics")
public class TaskMetrics {

    @Id
    @Column(name = "task_id", nullable = false)
    private int taskId;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "task_display_name", nullable = false)
    private String taskDisplayName;

    @Column(name = "last_execution_start_date_time", nullable = false)
    private OffsetDateTime lastExecutionStartDateTime;

    @Column(name = "last_execution_end_date_time")
    private OffsetDateTime lastExecutionEndDateTime;

    @Column(name = "was_success", nullable = false)
    private boolean wasSuccess;

    @Column(name = "current_status", nullable = false)
    private String currentStatus;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public OffsetDateTime getLastExecutionStartDateTime() {
        return lastExecutionStartDateTime;
    }

    public void setLastExecutionStartDateTime(OffsetDateTime lastExecutionStartDateTime) {
        this.lastExecutionStartDateTime = lastExecutionStartDateTime;
    }

    public OffsetDateTime getLastExecutionEndDateTime() {
        return lastExecutionEndDateTime;
    }

    public void setLastExecutionEndDateTime(OffsetDateTime lastExecutionEndDateTime) {
        this.lastExecutionEndDateTime = lastExecutionEndDateTime;
    }

    public boolean getWasSuccess() {
        return wasSuccess;
    }

    public void setWasSuccess(boolean wasSuccess) {
        this.wasSuccess = wasSuccess;
    }

    public String getTaskDisplayName() {
        return taskDisplayName;
    }

    public void setTaskDisplayName(String taskDisplayName) {
        this.taskDisplayName = taskDisplayName;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getFormattedLastExecutionStartDateTime() {
        if (lastExecutionStartDateTime == null) {
            return null;
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd h:m a");
        return lastExecutionStartDateTime.format(format);
    }
}

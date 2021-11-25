package com.webexecuter.task;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Test;

public class TaskMetricsUnitTest {

    @Test
    public void testGetFormattedLastExecutionStartDateTime() {
        TaskMetrics taskMetrics = new TaskMetrics();
        OffsetDateTime lastExecutionStartDateTime = OffsetDateTime.of(2016, 11, 6, 0, 20, 30, 1000, ZoneOffset.ofHours(-5));
        taskMetrics.setLastExecutionStartDateTime(lastExecutionStartDateTime);
        assertThat(taskMetrics.getFormattedLastExecutionStartDateTime()).isEqualTo("2016-11-06 12:20 AM");
    }
}

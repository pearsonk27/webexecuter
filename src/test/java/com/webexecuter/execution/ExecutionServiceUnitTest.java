package com.webexecuter.execution;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.webexecuter.schedule.ExecutionScheduleRepository;
import com.webexecuter.task.Task;
import com.webexecutor.ui.AppProperties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExecutionServiceUnitTest {

    @Mock
    private AppProperties appProperties;

    @Mock
    private ExecutionScheduleRepository executionScheduleRepository;

    @Mock
    private ExecutionLogRepository executionLogRepository;

    @Mock
    private Runtime runtime;

    @Test
    public void testRun() throws Exception {
        when(appProperties.getPythonCommand()).thenReturn("python");
        when(appProperties.getExecutionDirectory()).thenReturn("/test/directory");
        Task task = new Task();
        task.setName("test");
        ExecutionService executionService = new ExecutionService(executionLogRepository, appProperties, executionScheduleRepository);
        executionService.run(task, runtime);
        verify(runtime).exec("python /test/directory/main.py test");
    }
}

package com.webexecutor.ui;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Component
public class AppProperties {

    private String executionDirectory;

    public String getExecutionDirectory()
    {
        return executionDirectory;
    }

    public void setExecutionDirectory(String executionDirectory)
    {
        this.executionDirectory = executionDirectory;
    }
}

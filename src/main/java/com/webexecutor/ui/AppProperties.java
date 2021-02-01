package com.webexecutor.ui;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Component
public class AppProperties {

    private String executionDirectory;
    private String pythonCommand;

    public String getExecutionDirectory()
    {
        return executionDirectory;
    }

    public String getPythonCommand()
    {
        return pythonCommand;
    }

    public void setExecutionDirectory(String executionDirectory)
    {
        this.executionDirectory = executionDirectory;
    }

    public void setPythonCommand(String pythonCommand)
    {
        this.pythonCommand = pythonCommand;
    }
}

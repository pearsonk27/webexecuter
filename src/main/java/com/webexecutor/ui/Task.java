package com.webexecutor.ui;

public enum Task {
    WATER_BILL("waterBill", "water_bill"),
    GAS_BILL("gasBill", "gas_bill");

    private final String uiName;
    private final String executionName;

    private Task(String uiName, String executionName) {
        this.uiName = uiName;
        this.executionName = executionName;
    }

    public String getUiName() {
        return uiName;
    }

    public String getExecutionName() {
        return executionName;
    }

    public static Task findTaskByUiName(String uiName)
    {
        for (Task task : values()) {
            if (task.getUiName().equals(uiName)) {
                return task;
            }
        }
        throw new IllegalArgumentException(uiName);
    }
}

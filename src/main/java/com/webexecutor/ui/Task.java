package com.webexecutor.ui;

public enum Task {
    WATER_BILL("waterBill", "water_bill", "Water Bill"),
    GAS_BILL("gasBill", "gas_bill", "Gas Bill"),
    ELECTRIC_BILL("electricBill", "electric_bill", "Electric Bill"),
    CABLE_BILL("cableBill", "cable_bill", "Cable Bill"),
    TEST("test", "test", "Test");

    private final String uiName;
    private final String executionName;
    private final String displayName;

    private Task(String uiName, String executionName, String displayName) {
        this.uiName = uiName;
        this.executionName = executionName;
        this.displayName = displayName;
    }

    public String getUiName() {
        return uiName;
    }

    public String getExecutionName() {
        return executionName;
    }

    public String getDisplayName() {
        return displayName;
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

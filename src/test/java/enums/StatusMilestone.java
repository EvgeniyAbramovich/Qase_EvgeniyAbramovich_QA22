package enums;

public enum StatusMilestone {

    ACTIVE("Active"), COMPLETED("Completed");

    private final String name;

    StatusMilestone(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static StatusMilestone fromString(String value) {
        for (StatusMilestone statusMilestone : StatusMilestone.values()) {
            if (statusMilestone.getName().equals(value)) {
                return statusMilestone;
            }
        }
        return null;
    }
}

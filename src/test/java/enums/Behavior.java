package enums;

public enum Behavior {

    NOT_SET ("Not set"), POSITIVE ("Positive"), NEGATIVE ("Negative"), DESTRUCTIVE ("Destructive");

    private final String name;

    Behavior(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Behavior fromString(String value) {
        for (Behavior behavior : Behavior.values()) {
            if (behavior.getName().equals(value));
        }
        return null;
    }
}

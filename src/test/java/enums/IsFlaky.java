package enums;

public enum IsFlaky {

    NO ("No"), YES ("Yes");

    private final String name;

    IsFlaky(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static IsFlaky fromString(String value) {
        for (IsFlaky isFlaky : IsFlaky.values()) {
            if (isFlaky.getName().equals(value));
        }
        return null;
    }

}

package Models;

import Enums.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class TestCase {

    private String title;
    private Status status;
    private String description;
    private Severity severity;
    private Priority priority;
    private Type type;
    private Layer layer;
    private IsFlaky isFlaky;
    private Behavior behavior;
    private AutomationStatus automationStatus;
    private String preConditions;
    private String postConditions;

}

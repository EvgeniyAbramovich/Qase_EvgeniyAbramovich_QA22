package models;

import enums.Status;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class Milestones {

    private String milestoneName;
    private String description;
    private Status status;
    private String dueDate;

}

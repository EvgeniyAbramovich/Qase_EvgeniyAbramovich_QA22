package models;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class SharedSteps {

    private String sharedStepTitle;
    private String action;
    private String inputData;
    private String expectedResult;

}

package Models;

import Enums.Severity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class Defects {

    private String defectTitle;
    private String actualResult;
    private Severity severity;

}

package Models;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class Suite {

    private String suitName;
    private String description;
    private String preconditions;
}

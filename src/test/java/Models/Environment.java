package Models;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class Environment {

    private String title;
    private String slug;
    private String description;
    private String host;
}

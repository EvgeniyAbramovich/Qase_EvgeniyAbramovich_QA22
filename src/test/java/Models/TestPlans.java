package Models;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class TestPlans {

    private String title;
    private String description;
}

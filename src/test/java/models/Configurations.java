package models;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class Configurations {

    private String title;
}

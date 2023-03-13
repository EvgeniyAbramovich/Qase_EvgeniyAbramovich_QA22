package models;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class Defects {

    private String title;
    @SerializedName(value = "actual_result")
    private String actualResult;
    private int severity;
    private String status;

}

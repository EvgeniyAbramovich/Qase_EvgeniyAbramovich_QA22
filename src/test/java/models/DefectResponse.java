package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DefectResponse {

    private boolean status;
    private Defects result;
}

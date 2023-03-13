package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DefectResponse {
    @Builder.Default
    private boolean status = true;
    private Defects result;
}

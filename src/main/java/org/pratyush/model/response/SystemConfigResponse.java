package org.pratyush.model.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SystemConfigResponse {
    private String name;
    private String value;
}

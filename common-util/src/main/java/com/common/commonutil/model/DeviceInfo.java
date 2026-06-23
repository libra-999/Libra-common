package com.common.commonutil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
public class DeviceInfo {

    private String city;
    private String region;
    private String country;
    private String latitude;
    private String longitude;
}

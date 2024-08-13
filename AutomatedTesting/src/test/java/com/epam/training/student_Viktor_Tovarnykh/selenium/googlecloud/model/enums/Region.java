package com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.enums;

public enum Region {

    IOWA("Iowa (us-central1)"),
    OREGON("Oregon (us-west1)"),
    TAIWAN("Taiwan (asia-east1)"),
    SOUTH_CAROLINA("South Carolina (us-east1)"),
    NETHERLANDS("Netherlands (europe-west4)"),
    ALABAMA("Alabama (us-east7)");

    private final String region;

    Region(String region) {
        this.region = region;
    }

    public String getRegionName() {
        return region;
    }
}

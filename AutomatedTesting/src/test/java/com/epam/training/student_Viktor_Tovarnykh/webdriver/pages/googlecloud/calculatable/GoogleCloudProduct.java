package com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable;

public enum GoogleCloudProduct {
    COMPUTE_ENGINE(0),
    CLOUD_STORAGE(1),
    CLOUD_SQL(2),
    BIGQUERY(3),
    CLOUD_TPU(4),
    Cloud_GPU(5);

    private final int index;

    GoogleCloudProduct(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}

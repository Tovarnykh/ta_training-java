package com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable.products.compute_engine.config;

public class Constants {

    public static final String PRICING_BUTTON_SELECTOR = "a[href='https://cloud.google.com/pricing/']";
    public static final String PRICING_CALCULATOR_BUTTON_SELECTOR = "a[href='https://cloud.google.com/products/calculator/']";
    public static final String COOKIE_BUTTON = "//button[contains(text(), 'OK, got it')]";
    public static final String ADD_TO_ESTIMATE_BUTTON = "//span[text()='Add to estimate']";
    public static final String NUMBER_OF_INSTANCE_SELECTOR = "//div[contains(text(),'Number of instances')]/parent::div/following-sibling::div//input";
    public static final String OPERATING_SYSTEM_SELECTOR = "(//div[contains(@class, 'VfPpkd-aPP78e')])[4]";
    public static final String MACHINE_FAMILY_SELECTOR = "(//div[contains(@class, 'VfPpkd-aPP78e')])[5]";
    public static final String SERIES_SELECTOR = "(//div[contains(@class, 'VfPpkd-aPP78e')])[6]";
    public static final String MACHINE_SELECTOR = "(//div[contains(@class, 'VfPpkd-aPP78e')])[7]";
    public static final String GPU_MODEL_SELECTOR = "(//div[contains(@class, 'VfPpkd-aPP78e')])[8]";
    public static final String GPU_NUMBER_SELECTOR = "(//div[contains(@class, 'VfPpkd-aPP78e')])[9]";
    public static final String LOCAL_SSD_SELECTOR = "(//div[contains(@class, 'VfPpkd-aPP78e')])[10]";
    public static final String REGION_SELECTOR = "(//div[contains(@class, 'VfPpkd-aPP78e')])[11]";
    public static final String ADD_GPU_SELECTOR = "(//span[contains(@class, 'eBlXUe-hywKDc')])[6]";
    public static final String PROVISIONING_MODEL_SPOT_SELECTOR = "//label[contains(text(), 'Spot (Preemptible VM)')]";
    public static final String SHARE_BUTTON_SELECTOR = "//span[contains(text(),'Share')]";
    public static final String ESTIMATE_BUTTON_SELECTOR = "//a[contains(text(),'Open estimate summary')]";

    public static String TEMPLATE_DROPPING_LIST_SELECTOR = "//span[contains(text(),'%s')]/ancestor::li";
    public static String TEMPLATE_TO_ESTIMATE = "//div[@data-idx='%s']";

}

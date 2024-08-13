package com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.config;

import com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.ComputeEngineModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ConfigLoaderComputeEngine {

    public static ComputeEngineModel loadConfig(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream inputStream = ConfigLoaderComputeEngine.class.getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new IOException("Resource not found: " + filePath);
            }
            return objectMapper.readValue(inputStream, ComputeEngineModel.class);
        }
    }

}

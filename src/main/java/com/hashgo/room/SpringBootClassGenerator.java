package com.hashgo.room;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SpringBootClassGenerator {

    private static final String CONTROLLER_PACKAGE = "com.hashgo.room.controllers";
    private static final String SERVICE_PACKAGE = "com.hashgo.room.services";
    private static final String BASE_PATH = "src/main/java/";

    public static void main(String[] args) {
        List<String> classNames = List.of("Room", "Meal", "Expense","Task"); // Add more class names

        for (String className : classNames) {
            createClassFile(CONTROLLER_PACKAGE, className + "Controller");
            createClassFile(SERVICE_PACKAGE, className + "Service");
        }

        System.out.println("Empty classes created successfully!");
    }

    private static void createClassFile(String packageName, String className) {
        String directory = BASE_PATH + packageName.replace(".", "/");
        createDirectory(directory);

        String content = String.format("package %s;\n\npublic class %s {\n\n}", packageName, className);
        writeToFile(directory, className + ".java", content);
    }

    private static void createDirectory(String directory) {
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    private static void writeToFile(String directory, String fileName, String content) {
        try (FileWriter writer = new FileWriter(new File(directory, fileName))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing file: " + fileName);
            e.printStackTrace();
        }
    }
}

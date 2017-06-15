package com.demoqa.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Files {

    public String getTextFromFile(String pathToFile) {
        String text = "";
        File file = new File(pathToFile);

        try {
            for (String line : FileUtils.readLines(file, "UTF-8")) {
                text = text + line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }
}

package com.tfc.tshelpers.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ExampleTxtDataJsonReader {
    private static String textContent;

    public ExampleTxtDataJsonReader(){}

    public String getTextContent(){

        return textContent;
    }

    public static void readExampleTextDataFromJson(String filePath, String textType) {

        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            JsonObject jsonData = gson.fromJson(reader, JsonObject.class);
            JsonObject textTypes = jsonData.getAsJsonObject("textTypes");
            textContent = textTypes.get(textType).getAsString();
        
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Read error: " + ex.getMessage());
        }
    }
}

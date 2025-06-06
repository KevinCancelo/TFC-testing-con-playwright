package com.tfc.tshelpers.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ExampleTxtDataJsonReader {
    private static String textContent;  // Holds text content read from JSON

    public ExampleTxtDataJsonReader(){}

    public String getTextContent(){

        return textContent;
    }

    public static void readExampleTextDataFromJson(String filePath, String textType) {

        try (FileReader reader = new FileReader(filePath)) {
        Gson gson = new Gson();                                  // Create Gson instance
        JsonObject jsonData = gson.fromJson(reader, JsonObject.class); // Parse JSON file into JsonObject
        JsonObject textTypes = jsonData.getAsJsonObject("textTypes");  // Get "textTypes" object
        textContent = textTypes.get(textType).getAsString();           // Extract text for given type
                
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Read error: " + ex.getMessage());
        }
    }
}

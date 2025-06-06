package com.tfc.tshelpers.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TxtFileReader {
    
    private String textContent = "";  // Stores content read from file
    
    public TxtFileReader(){}

    public String getTextContent(){

        return textContent;
    }

    public void readFile(String path) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(path));
        
        for (String line : lines) {
        textContent = textContent + line;  // Concatenate each line
        }
    }
}

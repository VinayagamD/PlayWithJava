package com.vinaylogics.jdk11.apifeatures;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class FileReadWriteRunner {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("sample.txt").toURI());
        String fileContent = Files.readString(path);
        System.out.println(fileContent);
        String  newFileContent = fileContent.replace("Line", "Lines");
        System.out.println(newFileContent);

        Path newFilePath = Paths.get(ClassLoader.getSystemResource("sample-new.txt").toURI());
        Files.writeString(newFilePath, newFileContent);
    }
}

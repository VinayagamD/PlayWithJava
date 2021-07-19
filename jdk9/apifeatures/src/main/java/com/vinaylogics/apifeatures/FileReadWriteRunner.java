package com.vinaylogics.apifeatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileReadWriteRunner {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(Objects.requireNonNull(FileReadWriteRunner.class.getClassLoader().getResource("sample.txt")).getFile());
        String fileContent = Files.readString(path);

    }
}

package com.example.SpringBoot2.fileHandling2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileHandling {

    public static void main(String[] args) throws IOException {
        FileHandling fileHandling = new FileHandling();
        fileHandling.createIODir();
    }

    public void createIODir() throws IOException {
        File file = new File("E:\\Shreyash_1227\\Java\\IdeaProjects\\IdeaProjects\\SpringBoot2\\src\\main\\java\\com\\example\\SpringBoot2\\fileHandling2");

        if(!file.exists()){
            file.mkdir();
        }
        else {
            System.out.println("Dicrectory already exists.");
        }
        createIOFile(file.getAbsolutePath());
    }

    public void createIOFile(String path) throws IOException {
        File file = new File(path + "\\person.txt");
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        if (!file.exists()){
            file.createNewFile();
        }
        else {
            System.out.println("File already exists.");
        }
        writeIOFile(file);
    }

    public void writeIOFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Hello World");
        fileWriter.close();
    }
}

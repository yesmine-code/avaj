package com.avaj;

import java.io.File; 
import java.io.PrintWriter; 
import java.io.IOException;
import java.io.FileWriter;

public class FileManaj{

    public static FileManaj fileManager;
    public static File file;

    private FileManaj(){
    try {
            File myObj = new File("simulator.txt");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
            this.file = myObj;
        } else {
            System.out.println("File already exists.");}
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static FileManaj getFile(){
        if(fileManager == null){
            fileManager = new FileManaj();
        }
        return fileManager;
    }

    public static void writeIntoFile(String str){
        try {
            FileWriter myWriter = new FileWriter(file.getName(), true);
            PrintWriter printWriter = new PrintWriter(myWriter);
            printWriter.println(str);
            printWriter.write(str);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
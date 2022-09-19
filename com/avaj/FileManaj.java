package com.avaj;

import java.io.File; 
import java.io.PrintWriter; 
import java.io.IOException;
import java.io.FileWriter;
import com.avaj.exceptions.FileNotFoundException;

public class FileManaj{

    public static FileManaj fileManager;
    public static File file;

    private FileManaj(){
    }

    private static void createFile() throws FileNotFoundException{
        try {
            File myObj = new File("simulator.txt");
            if (!myObj.createNewFile()) {
                PrintWriter writer = new PrintWriter(myObj.getName());
                writer.print("");
                writer.close();
            }
            file = myObj;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            throw new FileNotFoundException(file.getName());
        }
    }

    public static FileManaj getFile() throws FileNotFoundException{
        if(fileManager == null){
            fileManager = new FileManaj();
            createFile();
        }
        return fileManager;
    }

    public static void writeIntoFile(String str){
        try {
            FileWriter myWriter = new FileWriter(file.getName(), true);
            PrintWriter printWriter = new PrintWriter(myWriter);
            printWriter.println(str);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
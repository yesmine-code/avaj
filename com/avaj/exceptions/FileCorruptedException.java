package com.avaj.exceptions;

public class FileCorruptedException extends Exception{
    public FileCorruptedException(){
        super("File is corrupted : first line doesn't contain only one integer or line is too short or too long! ");
    }
}

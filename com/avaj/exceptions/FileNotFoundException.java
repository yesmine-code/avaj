package com.avaj.exceptions;

public  class FileNotFoundException extends Exception{
     public FileNotFoundException(String filename){
         super(filename + " NOT FOUND!");
    }
}

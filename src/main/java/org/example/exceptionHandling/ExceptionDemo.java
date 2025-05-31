package org.example.exceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionDemo {
    public static void show() {
        try {
            //when a line throws an exception control directly moves to the catch
            var reader = new FileReader("file.txt");
            System.out.println("File opened");
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void multipleExceptions(){
        try {
            var reader = new FileReader("file.text");
            var value = reader.read();
            new SimpleDateFormat().parse("");
        } catch (IOException | ParseException e) {
            System.out.println("Could not read data!");
        }
    }

    public static void multipleExceptionsFinally(){
        FileReader reader = null;
        try {
            reader = new FileReader("file.text");
            var value = reader.read();
            reader.close();
        } catch (IOException e) {
            System.out.println("Could not read data!");
        }
        finally {
            //what if the code fails somewhere in line 34, then the reader.close() will never execute
            //that's where finally comes into rescue
            //Finally block will always get executed no matter what
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
//        multipleExceptions();
        multipleExceptionsFinally();
    }
}

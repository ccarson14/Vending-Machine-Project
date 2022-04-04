package com.techelevator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");

    public void writeLog(String transaction, double startBalance, double endBalance) {

        try(FileOutputStream outputStream = new FileOutputStream(("log.txt"), true);
            PrintWriter logWriter = new PrintWriter(outputStream)) {

            logWriter.println(format.format(dateTime) + " " + transaction + " $" +
                    String.format("%.2f", startBalance) + " $" + String.format("%.2f", endBalance));

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");;
        } catch (IOException e) {
            System.out.println("Unable to access file.");;
        }
    }

}

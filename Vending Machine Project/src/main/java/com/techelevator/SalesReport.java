package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SalesReport{

    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");

    Map<String, Integer> report = new HashMap<>();
    Map<String, Integer> report2 = new HashMap<>();

    Inventory inventory = new Inventory();

    public void makeReport(){
        Map<String, Integer> report = new HashMap<>();
        Map<String, Integer> report2 = new HashMap<>();

        inventory.createInventory();
        //System.out.print(inventory.inventoryLevels.size());
        //String slotIdentifier = entry.getKey();

        for(Map.Entry<String, List<Product>> entry : inventory.inventoryLevels.entrySet()) {
            String slotIdentifier = entry.getKey();
            Product tester = inventory.inventoryLevels.get(slotIdentifier).get(1);
            String test = tester.toString().replace(", ", "");
            String[] split = test.split(": \\$");
            String name = split[0];
            System.out.println(name + "|");
        }
    }

    public void salesReportTest(){
        File saleFile = new File(dateTime + " SalesReport.txt");
        try(Scanner scanFile = new Scanner(saleFile)){
            makeReport();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }






    //
//    public void salesReport() {
//        Map<String, Integer> report = new HashMap<>();
//
//        try {
//            List<String> lines = Files.readAllLines(Path.of("SalesReport.txt"));
//
//            for (String line : lines) {
//                String[] items = line.split("\\|");
//                report.put(items[0], Integer.parseInt(items[1]));
//            }
//            if (report.containsKey(product)) {
//                int value = report.get(product);
//                report.put(product, value++);
//            }
//
//            try (PrintWriter writer = new PrintWriter("SalesReport.txt")) {
//                for (Map.Entry<String, Integer> item : report.entrySet()) {
//                    writer.println(item + "|" + report.get(item));
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Critical error :X-|--<");
//        }
//    }

}

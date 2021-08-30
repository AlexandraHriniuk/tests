package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SumOfNumbers {

    public static void main(String args[]){
        ArrayList<String> strings = (ArrayList<String>) readFile("src/resources/numbers.txt");

        double total = strings.stream()
                .filter(SumOfNumbers::isNumber)
                .mapToDouble(Double::parseDouble)
                .sum();

        System.out.println(total);
    }

    private static boolean isNumber(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static List<String> readFile(String file){
        ArrayList<String> values = new ArrayList<>();
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                values.add(line);
            }

        } catch (IOException e) {
            throw new Error(e);
        }
        return values;
    }
}
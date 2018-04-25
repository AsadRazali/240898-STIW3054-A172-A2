package com.mycompany.rtpa2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public interface countwordandchar {
     String FILE_IN = "C:\\Users\\User\\240898-STIW3054-A172-A2\\RTPA2\\readwrite.txt";
    public static void countwordandcharacter() throws IOException {
        int words;
        int lines;
        int chars;
        int m = 0;
            int m2 = 0;
            char c= ' ';
        try (FileInputStream FILE_IN = new FileInputStream("C:\\Users\\User\\240898-STIW3054-A172-A2\\RTPA2\\readwrite.txt"); 
                Scanner fileinput = new Scanner(FILE_IN)) {
            words = 0;
            lines = 0;
            chars = 0;
            while (fileinput.hasNextLine()) {
                lines++;
                String line = fileinput.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ' ' || line.charAt(i) == '\n') {
                    } else {
                        chars++;
                    }
                }
                words += new StringTokenizer(line, " ,").countTokens();
            }   System.out.println("Number of lines: " + lines);
            System.out.println("Number of words: " + words);
            System.out.println("Number of characters: " + chars);
        }
        
       
         try (BufferedReader br = new BufferedReader(new FileReader(FILE_IN))) {

            String line = br.readLine();
            int value;
            

            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
          
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (map.containsKey(line.charAt(i))) {
                        value = map.get(line.charAt(i));
                        value++;
                        map.put(line.charAt(i), value);
                    } else {
                        map.put(line.charAt(i), 1);
                    }
                }
                line = br.readLine();
            }
            for (Character key : map.keySet()) {
                if (m < map.get(key)) {
                    m = map.get(key);
                }

            }

            for (Character key : map.keySet()) {
                if (m2< map.get(key)) {
                    if (m> map.get(key)) {
                       m2=map.get(key);
                       c=key;
                    }
                }

            }

            System.out.println( "The most frequent character is " + c + " " + m2 + " times");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        

        String fileName = "C:\\Users\\User\\240898-STIW3054-A172-A2\\RTPA2\\data.md";

        try {

            FileWriter fileWriter = new FileWriter(fileName);
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write("Number of lines: " + lines);
                bufferedWriter.write("\n");
                bufferedWriter.write("Number of words: " + words);
                bufferedWriter.write("\n");
                bufferedWriter.write("Number of characters: " + chars);
                bufferedWriter.write("\n");
                bufferedWriter.write("The most frequent character is " + c + " " + m2 + " times");
            }
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                    + fileName + "'");

        }
    }
}

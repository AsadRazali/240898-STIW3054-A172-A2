
import java.io.BufferedReader;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Assignment2 {

    private static final String FILE_IN = "C:\\Users\\User\\240898-STIW3054-A172-A2\\Assignment2\\Studentsupervisorlist.xlsx";
    private static final String FILE_OUT = "C:\\Users\\User\\240898-STIW3054-A172-A2\\Assignment2\\studentsupervisorlist.txt";

    public static void run() {

        Writer w = null;
      
        boolean lbreak = true;
    

        try {

            DataFormatter date = new DataFormatter();

            FileInputStream excelFile = new FileInputStream(new File(FILE_IN));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            File f = new File(FILE_OUT);
            w = new BufferedWriter(new FileWriter(f));

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    String d = date.formatCellValue(currentCell);
                    w.write(d + " ");
                }
                w.write("\r\n");
                if (lbreak == true) {

                    lbreak = false;
                }

            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        try {
            if (w != null) {
                w.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void countwordandcharacter() throws IOException {
        FileInputStream fin = new FileInputStream("C:\\Users\\User\\240898-STIW3054-A172-A2\\Assignment2\\studentsupervisorlist.txt");
        Scanner fileinput = new Scanner(fin);

        int words = 0;
        int lines = 0;
        int chars = 0;
        while (fileinput.hasNextLine()) {
            lines++;
            String line = fileinput.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) != ' ' && line.charAt(i) != '\n') {
                    chars++;
                }
            }
            words += new StringTokenizer(line, " ,").countTokens();
        }

        System.out.println("Number of lines: " + lines);
        System.out.println("Number of words: " + words);
        System.out.println("Number of characters: " + chars);
      
        fileinput.close();
        fin.close();

        String fileName = "C:\\Users\\User\\240898-STIW3054-A172-A2\\Assignment2\\statistic.md";

        try {
           
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
           
         
            bufferedWriter.write("Number of lines: " + lines);
            bufferedWriter.write("\n");
            bufferedWriter.write("Number of words: " + words);
            bufferedWriter.write("\n");
            bufferedWriter.write("Number of characters: " + chars);

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                    + fileName + "'");
          
        }
    }
    
    public static void statistic() throws IOException
    {
        
    }
     public static void githubpush() throws IOException
    {
              try{
          
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "cd && cd \"C:\\Users\\User\\240898-STIW3054-A172-A2\" && git add * && git commit -m \"Test\" && git pull && git push");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        System.out.println("\nCMD result : \n");
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
        sleep(5000);
        }catch(Exception e){
            System.out.println("Terminal cannot run");
        }
    }


    public static void main(String[] args) throws IOException {
        
        double r1=System.nanoTime();
        run();
        countwordandcharacter();
        statistic();
        double r2=System.nanoTime();
         System.out.println("Completing the execution= " + ((r2-r1)/1000000000 ) + " second");
        double t1=System.nanoTime();
        githubpush();
        double t2=System.nanoTime();
        System.out.println("Uploading file= " + ((t2-t1)/1000000000 ) + " second");

    }

}

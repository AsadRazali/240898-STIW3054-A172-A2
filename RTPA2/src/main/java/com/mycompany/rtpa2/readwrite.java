/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rtpa2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author User
 */
public interface readwrite {
     String FILE_IN = "C:\\Users\\User\\240898-STIW3054-A172-A2\\RTPA2\\Studentsupervisorlist.xlsx";
     String FILE_OUT = "C:\\Users\\User\\240898-STIW3054-A172-A2\\RTPA2\\readwrite.txt";
    
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
        }

    }
    
}

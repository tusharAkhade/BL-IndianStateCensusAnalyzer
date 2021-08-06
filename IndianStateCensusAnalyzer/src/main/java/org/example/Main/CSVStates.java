/***************************************************************************************
 *
 * Purpose :
 * UC2 : Ability for the analyser to load the Indian States Code
 *       Information from a csv file
 *       - Create CSVStates Class to load the CSV Data
 *       - Use Iterator to load the data
 *       - Check with StateCensusAnalyser to ensure number of record matches
 *
 *****************************************************************************************/

package org.example.Main;

import org.example.Exceptions.CustomizedExceptions;
import org.example.FileOperations.FileReaderWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVStates {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tusha\\Desktop\\IndianStateCensusAnalyzer\\src\\main\\java\\org\\example\\Files\\StateCode.csv";
        CSVStates csvStates = new CSVStates();
    }

    /**
     * Purpose : To get the number of records in CSV File
     *
     * @param filePath path of File
     * @return
     * @throws CustomizedExceptions
     */
    public int getNumberOfRecords(String filePath) throws CustomizedExceptions {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        int count = fileReaderWriter.getTotalRecords(filePath);

        return count;
    }

    /**
     * Purpose : To get flag  value from FileReader method
     *
     * @param filePath
     * @return
     */
    public boolean delimiterChecker(String filePath) {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        boolean flag = fileReaderWriter.checkDelimiter(filePath);
        return flag;
    }

    /**
     * Purpose : To get flag value from FileReaderWriter Method
     *
     * @param filePath
     * @return
     * @throws IOException
     * @throws CustomizedExceptions
     */
    public  boolean csvHeaderChecker(String filePath) throws IOException, CustomizedExceptions {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();

        // To compare actual CSV Headers with the headers in list
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("SrNo","State","Name","TIN","code"));
        boolean flag = fileReaderWriter.checkCSVHeader(filePath, stringArrayList);
        return flag;
    }

}

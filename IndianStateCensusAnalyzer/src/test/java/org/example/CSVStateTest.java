package org.example;

import org.example.Exceptions.CustomizedExceptions;
import org.example.Main.CSVStates;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Purpose : To perform JUnit testing
 */
public class CSVStateTest {

    CSVStates id = new CSVStates();

    /**
     * Test Case 1 : Given the CSV States file, Check to ensure the Number of Record matches
     *               This is a Happy Test Case where the records are checked.
     *
     * @throws CustomizedExceptions
     */
    @Test
    public void givenTheStateCensusCSVFileEnsuresNumberOfRecordsMatches() throws CustomizedExceptions {

        String filePath = "C:\\Users\\tusha\\Desktop\\IndianStateCensusAnalyzer\\src\\main\\java\\org\\example\\Files\\StateCode.csv";

        int result = id.getNumberOfRecords(filePath);

        Assert.assertEquals(38, result);
    }

    /**
     * Test Case 2 : Given the  CSV States File if incorrect Returns a custom Exception
     *               This is a Sad Test Case to verify if the exception is raised.
     */
    @Test
    public void givenStateCensusCSVFileIfIncorrectReturnsCustomException() {
        //File Name is Incorrect
        String filePath = "C:\\Users\\tusha\\Desktop\\IndianStateCensusAnalyzer\\src\\main\\java\\org\\example\\Files\\StaCode.csv";

        try {
            int result = id.getNumberOfRecords(filePath);
            Assert.assertEquals(38, result);
        } catch (CustomizedExceptions exceptions) {
            exceptions.printStackTrace();
        }
    }

    /**
     * Test Case 3 : Given the CSV States File when correct but type incorrect Returns a custom Exception
     *               This is a Sad Test Case to verify if the type is incorrect then exception is raised.
     */
    @Test
    public void givenStateCensusCSVFileWhenCorrectButTypeIncorrectReturnsCustomExceptions() {
        //File Type is different (.pdf)
        String filePath = "C:\\Users\\tusha\\Desktop\\IndianStateCensusAnalyzer\\src\\main\\java\\org\\example\\Files\\StateCode.pdf";

        try {
            int result = id.getNumberOfRecords(filePath);

            Assert.assertEquals(38, result);
        } catch (CustomizedExceptions exceptions) {
            exceptions.printStackTrace();
        }
    }

    /**
     * Test Case 4 : Given CSV States File when correct but delimiter incorrect
     *               Returns a custom Exception
     *              This is a Sad Test Case to verify if the file
     *              delimiter is incorrect then exception is raised.
     */
    @Test
    public void givenTheStateCensusCSVFileWhenCorrectButDelimeterIncorrectReturnsCustomizedExceptions() {
        String filePath = "C:\\Users\\tusha\\Desktop\\IndianStateCensusAnalyzer\\src\\main\\java\\org\\example\\Files\\StateCode.csv";
        try {
            boolean result = id.delimiterChecker(filePath);
            Assert.assertEquals(false, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test Case 5 : Given the  CSV State File when correct but csv header incorrect
     *              Returns a custom Exception
     *              This is a Sad Test Case to verify if the header is
     *              incorrect then exception is raised.
     *
     */
    @Test
    public void givenTheStateCensusCSVFileWhenCorrectButCSVHeaderIncorrectReturnsCustomException() {
        String filePath = "C:\\Users\\tusha\\Desktop\\IndianStateCensusAnalyzer\\src\\main\\java\\org\\example\\Files\\StateCode.csv";
        try {
            boolean result = id.csvHeaderChecker(filePath);
            Assert.assertEquals(false, result);
        } catch (IOException | CustomizedExceptions e) {
            e.printStackTrace();
        }
    }
}

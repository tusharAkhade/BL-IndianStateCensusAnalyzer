package org.example;
/**
 * Purpose : To Perform JUnit Testing
 */

import org.example.Exceptions.CustomizedExceptions;
import org.example.Main.IndianStateCensusAnalyzer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class IndianStateCensusAnalyzerTest {
    IndianStateCensusAnalyzer id = new IndianStateCensusAnalyzer();

    /**
     * Test Case 1 : Given the States Census CSV file, Check to ensure the Number of Record matches
     *               This is a Happy Test Case where the records are checked.
     *
     * @throws CustomizedExceptions
     */
    @Test
    public void givenTheStateCensusCSVFileEnsuresNumberOfRecordsMatches() throws CustomizedExceptions {
        String filePath = "C:\\Users\\tusha\\Desktop\\IndianStateCensusAnalyzer\\src\\main\\java\\org\\example\\Files\\StateCensusData.csv";
        int result = id.getNumberOfRecords(filePath);

        Assert.assertEquals(29, result);
    }

    /**
     * Test Case 2 : Given the State Census CSV File if incorrect Returns a custom Exception
     *               This is a Sad Test Case to verify if the exception is raised.
     */
    @Test
    public void givenStateCensusCSVFileIfIncorrectReturnsCustomException() {
        //File Name is Incorrect
        String filePath = "C:\\Users\\tusha\\Desktop\\IndianStateCensusAnalyzer\\src\\main\\java\\org\\example\\Files\\StateCnsData.csv";
        try {
            int result = id.getNumberOfRecords(filePath);
            Assert.assertEquals(29, result);
        } catch (CustomizedExceptions exceptions) {
            exceptions.printStackTrace();
        }
    }

    /**
     * Test Case 3 : Given the State Census CSV File when correct but type incorrect Returns a custom Exception
     *               This is a Sad Test Case to verify if the type is incorrect then exception is raised.
     */
    @Test
    public void givenStateCensusCSVFileWhenCorrectButTypeIncorrectReturnsCustomExceptions() {
        //File Type is different (.pdf)
        String filePath = "C:\\Users\\tusha\\Desktop\\IndianStateCensusAnalyzer\\src\\main\\java\\org\\example\\Files\\StateCensusData.pdf";
        try {
            int result = id.getNumberOfRecords(filePath);

            Assert.assertEquals(29, result);
        } catch (CustomizedExceptions exceptions) {
            exceptions.printStackTrace();
        }

    }

    /**
     * Test Case 4 : Given the State Census CSV File when correct but delimiter incorrect
     *               Returns a custom Exception
     *              This is a Sad Test Case to verify if the file
     *              delimiter is incorrect then exception is raised.
     */
    @Test
    public void givenTheStateCensusCSVFileWhenCorrectButDelimeterIncorrectReturnsCustomizedExceptions() {
        String filePath = "C:\\Users\\tusha\\Desktop\\IndianStateCensusAnalyzer\\src\\main\\java\\org\\example\\Files\\StateCensusData.csv";
        try {
            boolean result = id.delimiterChecker(filePath);
            Assert.assertEquals(false, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test Case 5 : Given the State Census CSV File when correct but csv header incorrect
     *              Returns a custom Exception
     *              This is a Sad Test Case to verify if the header is
     *              incorrect then exception is raised.
     */
    @Test
    public void givenTheStateCensusCSVFileWhenCorrectButCSVHeaderIncorrectReturnsCustomException() {
        String filePath = "C:\\Users\\tusha\\Desktop\\IndianStateCensusAnalyzer\\src\\main\\java\\org\\example\\Files\\StateCensusData.csv";
        try {
            boolean result = id.csvHeaderChecker(filePath);
            Assert.assertEquals(false, result);
        } catch (IOException | CustomizedExceptions e) {
            e.printStackTrace();
        }
    }
}

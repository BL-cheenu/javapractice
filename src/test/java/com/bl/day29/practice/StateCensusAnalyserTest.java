package com.bl.day29.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {
    @Test
    public void givenCensusCSV_WhenLoaded_ShouldReturnCorrectCount() throws Exception {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        int count = analyser.loadIndiaStateCensusData(
                "D:\\Workspace\\IndiaStateCensusData.csv"
        );

        Assertions.assertEquals(3, count);
    }
}

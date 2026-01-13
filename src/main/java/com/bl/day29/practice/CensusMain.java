package com.bl.day29.practice;

import com.bl.exception.StateCensusException;

public class CensusMain {
    public static void main(String[] args) {

        try {
            StateCensusAnalyser analyser = new StateCensusAnalyser();
            int censusCount  = analyser.loadIndiaStateCensusData("D:\\Workspace\\IndiaStateCensusData.csv");
            System.out.println("Total Records Loaded: " + censusCount );
            int stateCodeCount = analyser.loadIndiaStateCode(
                    "D:\\Workspace\\IndiaStateCode.csv"
            );
            System.out.println("State Code Records: " + stateCodeCount);
        } catch (StateCensusException e) {
            e.printStackTrace();
        }
    }
}

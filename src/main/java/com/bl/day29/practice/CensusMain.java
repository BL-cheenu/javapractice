package com.bl.day29.practice;

import com.bl.exception.StateCensusException;

public class CensusMain {
    public static void main(String[] args) {

        try {
            StateCensusAnalyser analyser = new StateCensusAnalyser();
            int count = analyser.loadIndiaStateCensusData("D:\\Workspace\\IndiaStateCensusData.csv");
            System.out.println("Total Records Loaded: " + count);
        } catch (StateCensusException e) {
            e.printStackTrace();
        }
    }
}

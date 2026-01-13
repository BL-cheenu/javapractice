package com.bl.day29.practice;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    public int loadIndiaStateCensusData(String csvFilePath) throws Exception {

        Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));

        CsvToBean<CSVStateCensus> csvToBean =
                new CsvToBeanBuilder<CSVStateCensus>(reader)
                        .withType(CSVStateCensus.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

        Iterator<CSVStateCensus> iterator = csvToBean.iterator();

        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }
}

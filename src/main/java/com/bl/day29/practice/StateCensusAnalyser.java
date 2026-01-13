package com.bl.day29.practice;

import com.bl.exception.StateCensusException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    public int loadIndiaStateCensusData(String csvFilePath)
            throws StateCensusException {

        try {
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

        } catch (Exception e) {
            throw new StateCensusException("Invalid file path",
                    StateCensusException.ExceptionType.FILE_NOT_FOUND
            );
        }
    }
}

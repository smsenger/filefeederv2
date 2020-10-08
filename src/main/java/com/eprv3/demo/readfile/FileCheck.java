package com.eprv3.demo.readfile;


import com.eprv3.demo.filemover.FileMover;
import com.eprv3.demo.filewriter.WriteFile;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class FileCheck extends ReadFile {

    @Autowired
    FileMover fileMover;

    @Autowired
    WriteFile writeFile;

    @Value("${processing.file.folder}")
    private Path processingFolder;

    @Value("${error.file.folder}")
    private Path errorFolder;

    public void fileCheck(String assocError, String fileName) throws IOException {
        List<String[]> list;
        List<String[]> filteredList = new ArrayList<>();
        List<String[]> errorList = new ArrayList<>();
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        CSVReader reader = null;
        log.info("Reading file containing error " + fileName);

        try {
            reader = new CSVReaderBuilder(new FileReader(errorFolder + File.separator + fileName))
                    .withCSVParser(parser).build();
            list = reader.readAll();
            int header = list.get(0).length;

            for (String[] assoc : list) {
                if (!assoc[0].equals(assocError) & assoc.length == header) {
                    filteredList.add(assoc);
                } else {
                    errorList.add(assoc);
                }
            }

        } catch (CsvException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int size = filteredList.size() -1;
            log.info("Generating file that contains errors from INTO0178 This file can be found in error folder.");
            writeFile.writeFile(errorList, errorFolder, fileName, "errors");
            log.info("Removed associated with error. Data structure now contains " + size + " associates.");
            writeFile.writeFile(filteredList, processingFolder, fileName, "fixed");
        }
    }
}
package com.eprv3.demo.filewriter;



import com.eprv3.demo.readfile.ReadFile;
import com.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Slf4j
@Service
public class WriteFile {

    @Autowired
    ReadFile readFile;

    @Value("${processing.file.folder}")
    private Path processingFolder;

    @Value("${error.file.folder}")
    private Path errorFolder;

    public void writeFile(List<String[]> list, Path path, String fileName, String ID) {
        //write to file

        String editedFixedFileName = fileName.substring(0, fileName.indexOf(".")) + ID + ".csv"; //fileName.csv = fileName
        log.info("Program will now write new file with correct associate entries " + editedFixedFileName);

        try {
            FileWriter fixedFile = new FileWriter(new File(path + File.separator + editedFixedFileName));
            CSVWriter writer = new CSVWriter(fixedFile, ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            writer.writeAll(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(path.equals(processingFolder)) {
            readFile.slimReader(editedFixedFileName, processingFolder);
        }
    }
}

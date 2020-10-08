package com.eprv3.demo.readfile;


import com.eprv3.demo.filemover.FileMover;
import com.eprv3.demo.filewriter.WriteFile;
import com.eprv3.demo.pojo.Associates;
import com.eprv3.demo.processor.ProcessAssocFile;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Slf4j
@Service
public class ReadFile {

    @Autowired
    FileCheck fileCheck;

    @Autowired
    FileMover fileMover;

    @Autowired
    WriteFile writeFile;

    @Autowired
    ProcessAssocFile process;

    @Value("${processing.file.folder}")
    private Path processingFolder;

    @Value("${archive.file.folder}")
    private Path archiveFolder;

    @Value("${error.file.folder}")
    private Path errorFolder;

    @Value("${file.name.prefix}")
    private String prefix;

    public void slimReader(String fileName, Path folder) {
        List<Associates> associatesList = null;
        FileReader reader = null;

        try {
            log.info("Reading file " + fileName);
            reader = new FileReader(folder + File.separator + fileName);
            //populates the pojos
            associatesList = new CsvToBeanBuilder(reader).withSeparator(',').withType(Associates.class).build().parse();
            log.info("Total of " + associatesList.size() + " Associates in the file. \n");

        } catch (Exception e) {
            String id = e.getMessage().substring(e.getMessage().indexOf("[") + 1, e.getMessage().indexOf(","));
            log.error("File " + fileName + " has an error in the data and has been rejected.\n"
                    + "The line that caused the error is " + id + "\n" + e.getCause().toString());
            try {
                reader.close();
                fileMover.moveSingleFile(processingFolder, errorFolder, fileName); //CREATE ERROR FILE MOVER
                fileCheck.fileCheck(id, fileName);
            } catch (IOException i) {
                i.printStackTrace();
            }
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        if(associatesList.size() >= 1) {//
            //call process class/method here, process calls fileFilter
            process.process(associatesList, fileName);
        }
        //fileMover.moveSingleFile(processingFolder, archiveFolder, fileName);
    }
}


/*    public void addToPojo(List<String[]> list) {
        Associates assoc;
        List<Associates> assocList = new ArrayList<>();

        for (String[] associate : list) {
            assoc = new Associates();
            assoc.setEmployeeNbr(associate[0]);
            assoc.setEffectiveDt(associate[1]);
            assoc.setWorkCtry(associate[2]);
            assoc.setFirstNm(associate[3]);
            assoc.setLastNm(associate[4]);
            assoc.setMiddleNm(associate[5]);

            assocList.add(assoc);
        }
    }
}*/




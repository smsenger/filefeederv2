package com.eprv3.demo.filemover;


import com.eprv3.demo.readfile.ReadFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Slf4j
@Component
public class FileMover {
    @Autowired
    ReadFile readFile;

    @Value("${input.file.folder}")
    private Path associateFolder;

    @Value("${processing.file.folder}")
    private Path processingFolder;

    @Value("${file.name.prefix}")
    private String prefix;


    public void openAssociatesFolder() {
        Long countFiles;
        try {
            countFiles = Files.walk(associateFolder).count() - 1;

            if(countFiles <= 0) {
                log.debug("No files in folder");
            } else {
                fileMover(associateFolder, processingFolder);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileMover(Path source, Path dest) {
        try {
            Files.createDirectories(dest);
            Files.walk(source)
                    .filter(f -> f.toString().endsWith(".csv"))
                    .forEach(f -> {
                        Path destination = dest.resolve(source.relativize(f));
                        try {
                            Files.createDirectories(destination.getParent());
                            Files.move(f, destination);
                            //readFile.readFile();
                        } catch (IOException i) {
                            i.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        openProcessingFolder(dest);
    }

    //move from source to destination folder
    public void moveSingleFile(Path source, Path destination, String fileName) {
        try {
            Path start = Paths.get(source + File.separator + fileName);
            Path end = Paths.get(destination + File.separator + fileName);
            Files.move(start, end, REPLACE_EXISTING);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void openProcessingFolder(Path destination) {
        List<Path> fileNameList = null;

        try {
            fileNameList = Files.walk(destination)
                    .filter(s -> s.toString().contains(prefix))
                    .map(Path:: getFileName)
                    .sorted()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileNameList.forEach(f -> readFile.slimReader(f.toString(), destination));
    }
}

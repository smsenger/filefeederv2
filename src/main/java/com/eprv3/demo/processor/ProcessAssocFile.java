package com.eprv3.demo.processor;


import com.eprv3.demo.filefilter.FileFilter;
import com.eprv3.demo.pojo.Associates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ProcessAssocFile {
    @Autowired
    FileFilter fileFilter;

    public void process(List<Associates> list, String fileName) {
     //this is where all the processing functions are called, including fileFilter
        List<Associates> filteredAssociates = new ArrayList<>();
        filteredAssociates = fileFilter.fileFilter(list, fileName);
    }
}

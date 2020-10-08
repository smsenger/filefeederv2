package com.eprv3.demo.rest;


import com.eprv3.demo.filemover.FileMover;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Rest {
//    @Autowired
//    FileReader fileO;

    @Autowired
    FileMover openAssociatesFolder;

    private static final String EPR_ASSOC_DETAILS_UPDATE = "/epr/associate/update";

    @RequestMapping(value = EPR_ASSOC_DETAILS_UPDATE, method = RequestMethod.POST)
    @Scheduled(cron = "0/2 * * * * *")
    public void startProcess() {

        openAssociatesFolder.openAssociatesFolder();
    }
}

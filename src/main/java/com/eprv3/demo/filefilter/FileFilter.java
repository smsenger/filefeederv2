package com.eprv3.demo.filefilter;


import com.eprv3.demo.pojo.Associates;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class FileFilter {

    public List<Associates> fileFilter(List<Associates> list, String fileName) {
// THIS GOES THROUGH EACH ASSOCIATE'S ARRAY AND CHECK FOR ERRORS. NEED TO EDIT TABLES AFTER ERROR REPORTED/DISCOVERED.


        list.forEach(a -> {
                    String id = a.getEmployeeNbr();
                    List<Associates> filteredList = new ArrayList<>();
                    List<Associates> rescindedList = new ArrayList<>();
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());


                    if (StringUtils.isBlank(id)) {
                        log.info("Associate ID is missing for " + a.getFirstNm() + " " + a.getLastNm() + ". " + fileName + " " + timestamp + ".");
                        return;
                    }

                    ////////Checks employee id
                    if (id.length() != 9 || id.matches("[*a-zA-z]")) {
                        log.error("Associate ID is in wrong format: " + id + ". " + fileName + " " + timestamp + ".");
                        return;
                    }

                    ////////handles empty employee status code field
                    if (StringUtils.isBlank(a.getEmpStatusCode())) {
                        log.error("Employee status code field empty for employee " + id + ". " + fileName + " " + timestamp + ".");
                        return;
                    }

                    ////////checks for employee level id
                    if (StringUtils.isBlank(a.getEmployeeLevelId())) {
                        log.error("Employee level ID field is empty for employee " + id + ". " + fileName + " " + timestamp + ".");
                        return;
                    }

                    if (!StringUtils.isBlank(a.getEmployeeLevelId()) || !(a.getEmployeeLevelId().matches("[0-9]+"))) {
                        log.error("Employee level ID field is incorrectly formatted for associate  " + id + ". " + fileName + " " + timestamp + ".");
                        return;
                    }

                    ////////if employee status code not empty, adds rescinded to rescinded list and logs terminated
                    if (!StringUtils.isBlank(a.getEmpStatusCode())) {
                        if (a.getEmpStatusCode().equals("D")) {
                            rescindedList.add(a);
                            return;
                        }
                        if (a.getEmpStatusCode().equals("T")) {
                            log.error("Employee " + id + "terminated. " + fileName + " " + timestamp + ".");
                            return;
                        }
                    }

                    ////////if employee devel description is not empty, checks for last work date and provides information for T and D
                    if (!StringUtils.isBlank(a.getEmpStatusCode())) {
                        if (!StringUtils.isBlank(a.getLastDateWorked())) {
                            if ((a.getEmpStatusCode().equals("D"))) {
                                log.error("Employee status code: " + a.getEmpStatusCode() + ". Last hire date: " + a.getLastHireDate() +
                                        " Last date worked: " + a.getLastDateWorked() + " Effective date: " + a.getEffectiveDt() +
                                        ". Job title: " + a.getJobCode() + ". " + fileName + " " + timestamp + ".");
                                return;
                            }
                            if ((a.getEmpStatusCode().equals("I"))) {
                                log.error("Employee status code: " + a.getEmpStatusCode() + ". Last hire date: " + a.getLastHireDate() +
                                        " Effective date: " + a.getEffectiveDt() + ". Job title: " + a.getJobCode() +
                                        ". Last date worked: " + a.getLastDateWorked() + ". " + fileName + " " + timestamp + ".");
                                return;
                            } else {
                                log.error("Last date worked for associate " + id + "is " + a.getLastDateWorked() + ". " + fileName + " " + timestamp + ".");
                                return;
                            }

                        }
                    }

                    ////////Checks if manager id of associate's manager is missing.
                    if (StringUtils.isBlank(a.getManagerEmployeeId())) {
                        log.error("Associate manager relationship for associate " + id + "incomplete. Manager associate ID missing. " + fileName + " " + timestamp + ".");
                    }

                    ////////Checks if manager id not missing but associate id is same as manager's id
                    if (!StringUtils.isBlank(a.getManagerEmployeeId())) {
                        if (a.getEmployeeNbr().equals(a.getManagerEmployeeId())) {
                            log.error("Manager's ID for associate " + id + " same as ID for associate. " + fileName + " " + timestamp + ".");
                        }
                    }

                    ////////Location type
                    ////////If NOT TERMINATED
                    if (!a.getEmpStatusCode().equals("T")) {
                        ////////If location type field empty, provides message
                        if (StringUtils.isBlank(a.getLocationType())) {
                            log.error("Location type field empty for associate " + id + ". " + fileName + " " + timestamp + ".");
                        }
                    }

                    if (StringUtils.isBlank(a.getDescription())) {
                        a.setDescription("9999-12-31");
                    }

                    if (StringUtils.isBlank(a.getDepartmentNumber())) {
                        a.setDepartmentNumber("000");
                    }

                    filteredList.add(a);

                    ////////delete rescinded form filteredList
                    if (a.getEmpStatusCode().equals("D")) {
                        filteredList.remove(a);
                        return;
                    }
                }
        );
        return list;
    }
}

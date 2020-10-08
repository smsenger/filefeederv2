package com.eprv3.demo.pojo;


import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Data
@NoArgsConstructor
public class Associates {
    @CsvBindByName(column = "employeenumber")
    String employeeNbr;
    @CsvBindByName(column = "effectivedate")
    String effectiveDt;
    @CsvBindByName(column = "workCountryAssignedToAssociate")
    String workCtry;
    @CsvBindByName(column = "associatedname")
    String associatedNm;
    @CsvBindByName(column = "associatednumber")
    String associatedNmbr;
    @CsvBindByName(column = "associateddistrictname")
    String associatedDistrictNm;

    @CsvBindByName(column = "associateddistrictnumber")
    String associatedDistrictNmbr;
    @CsvBindByName(column = "associateddivisonname")
    String associatedDivisionNm;
    @CsvBindByName(column = "associateddivisonnumber")
    String associatedDivisionNmbr;
    @CsvBindByName(column = "associatemarketname")
    String associateMarketNm;
    @CsvBindByName(column = "associatemarketnumber")
    String associateMarketNmbr;
    @CsvBindByName(column = "associateregionname")
    String associateRegionNm;

    @CsvBindByName(column = "associateregionnumber")
    String associateRegionNmbr;
    @CsvBindByName(column = "workStateAssignedToAssociate")
    String workStateAssignedToAssociate;
    @CsvBindByName(column = "associatestorename")
    String associateStoreName;
    @CsvBindByName(column = "associatestorenumber")
    String associateStoreNmbr;
    @CsvBindByName(column = "businesscategory")
    String businessCategory;
    @CsvBindByName(column = "businessunitname")
    String businessUnitName;

    @CsvBindByName(column = "businessunitcode")
    String businessUnitCode;
    @CsvBindByName(column = "departmentnumber")
    String departmentNumber;
    @CsvBindByName(column = "departmentDescription")
    String departmentDescription;
    ////////DESCRIPTION IS THE BIRTH DATE
    @CsvBindByName(column = "description")
    String description;
    @CsvBindByName(column = "employeetype")
    String employeeType;
    @CsvBindByName(column = "ecurrhiredate")
    String eCurrHireDate;

    @CsvBindByName(column = "erdeptbusinessunitid")
    String erDeptBusinessUnitId;
    @CsvBindByName(column = "erhrempolyeeid")
    String erHrEmployeeId;
    @CsvBindByName(column = "employeeNameSuffix")
    String employeeNameSuffix;
    @CsvBindByName(column = "employeeFullName")
    String employeeFullName;
    @CsvBindByName(column = "employeeFirstName")
    String firstNm;
    @CsvBindByName(column = "employeeLastName")
    String lastNm;

    @CsvBindByName(column = "employeeMiddleName")
    String middleNm;
    @CsvBindByName(column = "employeeRace")
    String employeeRace;
    @CsvBindByName(column = "employeeGender")
    String employeeGender;
    @CsvBindByName(column = "employeeLevelId")
    String employeeLevelId;
    @CsvBindByName(column = "employeeLevelDescription")
    String employeeLevelDescription;
    @CsvBindByName(column = "homeAddrLine1")
    String homeAddrLine1;

    @CsvBindByName(column = "homeAddrLine2")
    String homeAddrLine2;
    @CsvBindByName(column = "homeAddrCity")
    String homeAddrCity;
    @CsvBindByName(column = "homeAddrStateProvince")
    String homeAddrStateProvince;
    @CsvBindByName(column = "homeAddrPostalCode")
    String homeAddrPostalCode;
    @CsvBindByName(column = "homeAddrCountry")
    String homeAddrCountry;
    @CsvBindByName(column = "personalEmail")
    String personalEmail;

    @CsvBindByName(column = "homePhonePrimary")
    String homePhonePrimary;
    @CsvBindByName(column = "timeType")
    String timeType;
    @CsvBindByName(column = "baseRateFrequencyCode")
    String baseRateFrequencyCode;
    @CsvBindByName(column = "originalHireDate")
    String originalHireDate;
    @CsvBindByName(column = "lastHireDate")
    String lastHireDate;
    @CsvBindByName(column = "continuousServiceDate")
    String continuousServiceDate;

    @CsvBindByName(column = "taxEntityCode")
    String taxEntityCode;
    @CsvBindByName(column = "taxEntityName")
    String taxEntityName;
    @CsvBindByName(column = "payEntityCode")
    String payEntityCode;
    @CsvBindByName(column = "payEntityReferenceId")
    String payEntityReferenceId;
    @CsvBindByName(column = "payEntityDescription")
    String payEntityDescription;
    @CsvBindByName(column = "rehireEligibility")
    String rehireEligibility;
    @CsvBindByName(column = "maritalStatus")
    String maritalStatus;

    @CsvBindByName(column = "employeeWorkEmail")
    String employeeWorkEmail;
    @CsvBindByName(column = "supervisoryCode")
    String supervisoryCode;
    @CsvBindByName(column = "supervisoryOrgId")
    String supervisoryOrgId;
    @CsvBindByName(column = "supervisoryOrgName")
    String supervisoryOrgNm;
    @CsvBindByName(column = "managersSupervisoryOrg")
    String managersSupervisoryOrg;
    @CsvBindByName(column = "managersSupervisoryOrgName")
    String managersSupervisoryNm;

    @CsvBindByName(column = "managersSupervisoryOrgCode")
    String managersSupervisoryOrgCode;
    @CsvBindByName(column = "managersManagersSupervisoryOrgCode")
    String managersManagersSupervisoryOrgCode;
    @CsvBindByName(column = "jobDesignationCode")
    String jobDesignationCode;
    @CsvBindByName(column = "jobtitlecode")
    String jobTitleCode;
    @CsvBindByName(column = "jobtitledesc")
    String jobTitleDesc;
    @CsvBindByName(column = "jobCode")
    String jobCode;

    @CsvBindByName(column = "jobProfile")
    String jobProfile;
    @CsvBindByName(column = "jobClassification")
    String jobClassification;
    @CsvBindByName(column = "jobProfileName")
    String jobProfileNm;
    @CsvBindByName(column = "defaultCostCenter")
    String defaultCostCenter;
    @CsvBindByName(column = "locationNumber")
    String locationNumber;
    @CsvBindByName(column = "locationType")
    String locationType;

    @CsvBindByName(column = "locationDescription")
    String locationDescription;
    @CsvBindByName(column = "locationStateCode")
    String locationStateCode;
    @CsvBindByName(column = "locationTimeZone")
    String locationTimeZone;
    @CsvBindByName(column = "mgruid")
    String mgruid;
    @CsvBindByName(column = "managerName")
    String managerNm;
    @CsvBindByName(column = "managerEmployeeId")
    String managerEmployeeId;

    @CsvBindByName(column = "managerPositionNumber")
    String managerPositionNmbr;
    @CsvBindByName(column = "managerLocationNumber")
    String managerLocationNmbr;
    @CsvBindByName(column = "managerDepartment")
    String managerDepartment;
    @CsvBindByName(column = "managerTitleCode")
    String managerTitleCode;
    @CsvBindByName(column = "managerLevelId")
    String managerLevelId;
    @CsvBindByName(column = "orgunit")
    String orgunit;

    @CsvBindByName(column = "preferredLanguage")
    String preferredLanguage;
    @CsvBindByName(column = "prsnid")
    String prsnid;
    @CsvBindByName(column = "empstatusCode")
    String empStatusCode;
    @CsvBindByName(column = "sysusrid")
    String sysusrid;
    @CsvBindByName(column = "telephonenumber")
    String telephoneNumber;
    @CsvBindByName(column = "teletexterminalidentifier")
    String teleTexTerminalIdentifier;

    @CsvBindByName(column = "telexnumber")
    String telexNumber;
    @CsvBindByName(column = "title")
    String title;
    @CsvBindByName(column = "uid")
    String uId;
    @CsvBindByName(column = "preferredname")
    String preferredName;
    @CsvBindByName(column = "leaveOfAbsenceType")
    String leaveOfAbsenceType;
    @CsvBindByName(column = "leaveOfAbsenceExpectedReturnDate")
    String leaveOfAbsenceExpectedReturnDate;

    @CsvBindByName(column = "lastDateWorked")
    String lastDateWorked;
    @CsvBindByName(column = "leaveOfAbsenceReason")
    String leaveOfAbsenceReason;
    @CsvBindByName(column = "leaveOfAbsenceStartDate")
    String leaveOfAbsenceStartDate;
    @CsvBindByName(column = "terminalInvoluntaryVoluntary")
    String terminalInvolunatryVoluntary;
    @CsvBindByName(column = "terminalReason")
    String terminalReason;
    @CsvBindByName(column = "terminationDate")
    String terminationDate;














}

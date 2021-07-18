package com.pfs.riskmodel.service.Impl;

import com.pfs.riskmodel.domain.ProjectRiskLevel;
import com.pfs.riskmodel.domain.RiskProjectType;
import com.pfs.riskmodel.domain.RiskModelTemplate;
import com.pfs.riskmodel.domain.RiskType;
import com.pfs.riskmodel.dto.RiskModelReportDTO;
import com.pfs.riskmodel.repository.ProjectRiskLevelRepository;
import com.pfs.riskmodel.repository.RiskProjectTypeRepository;
import com.pfs.riskmodel.repository.RiskModelTemplateRepository;
import com.pfs.riskmodel.repository.RiskTypeRepository;
import com.pfs.riskmodel.resource.LoanApplication;
import com.pfs.riskmodel.service.IRiskModelTemplateService;
import com.pfs.riskmodel.service.IRiskTypeService;
import com.pfs.riskmodel.service.validator.RiskModelTemplateValidator;
import com.pfs.riskmodel.util.ValidationResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sajeev on 17-Dec-18.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RiskModelTemplateService implements IRiskModelTemplateService {

    @Autowired
    RiskModelTemplateRepository riskModelTemplateRepository;

    @Autowired
    RiskModelTemplateValidator riskModelTemplateValidator;

    @Autowired
    IRiskTypeService iRiskTypeService;

    @Autowired
    RiskTypeRepository riskTypeRepository;

    @Autowired
    RiskProjectTypeRepository riskProjectTypeRepository;

    @Autowired
    ProjectRiskLevelRepository projectRiskLevelRepository;

    @Override
    public RiskModelTemplate getByRiskModelId(Long id) {
       Optional<RiskModelTemplate> riskModelTemplateOptional = riskModelTemplateRepository.findById(id);
       return riskModelTemplateOptional.get();

    }

    @Override
    public List<RiskModelReportDTO> findByLoanNumberAndRiskProjectTypeAndProjectName(String loanNumber, String riskProjectTypeCode, String projectName) throws ParseException {

        List<RiskModelTemplate> riskModelTemplates = new ArrayList<>();

        RiskProjectType riskProjectType = riskProjectTypeRepository.findByCode(riskProjectTypeCode);

        // Find All
        if (loanNumber == null && riskProjectTypeCode == null && projectName == null) {
            riskModelTemplates = riskModelTemplateRepository.findAll();

        }


        // Find by Loan Number
        if (loanNumber != null && riskProjectType == null && projectName == null){
            riskModelTemplates = riskModelTemplateRepository.findByLoanNumber(  loanNumber);
        }

        // Find by Risk Project Type
        if (loanNumber == null && riskProjectType != null && projectName == null){
             riskModelTemplates = riskModelTemplateRepository.findByRiskProjectType(riskProjectType);

        }

        // Find by Project Name
        if (loanNumber == null && riskProjectType == null && projectName != null){
             riskModelTemplates = riskModelTemplateRepository.findByProjectNameContaining(projectName);
        }

        //Find by Risk Project Type and Project Name
        if (loanNumber == null && riskProjectType != null && projectName != null){
             riskModelTemplates = riskModelTemplateRepository.findByProjectNameContainingAndRiskProjectType( projectName,riskProjectType);
        }


        List<RiskModelReportDTO> riskModelReportDTOS = new ArrayList<>();
        for (RiskModelTemplate riskModelTemplate: riskModelTemplates) {
            if (riskModelTemplate.getModelType() == 1) {
                RiskModelReportDTO riskModelReportDTO = mapRiskModelTemplateToRiskModelDTO(riskModelTemplate);
                riskModelReportDTOS.add(riskModelReportDTO);
            }
        }


        return riskModelReportDTOS;
    }

    @Override
    public List<RiskModelReportDTO> findByLoanNumberAndRiskProjectTypeAndProjectNameFiltered(List<LoanApplication> loanApplications,String loanNumber, String riskProjectTypeCode, String projectName, Boolean activeLoanAccountsOnly, Boolean latestRatingsOnly) throws ParseException {

        List<RiskModelReportDTO> riskModelReportDTOS = this.findByLoanNumberAndRiskProjectTypeAndProjectName(loanNumber,riskProjectTypeCode,projectName);

        riskModelReportDTOS = this.filterOutput(loanApplications,riskModelReportDTOS,activeLoanAccountsOnly,latestRatingsOnly);

        return riskModelReportDTOS;


    }

    @Override
    public Map<String, Object> findByProjectTypeAndRiskLevel(String projectTypeCode, String projectRiskLevelCode) {

        Map<String, Object> result = new HashMap<>();
        ValidationResult validationResult = new ValidationResult();




        RiskProjectType riskProjectType =  riskProjectTypeRepository.findByCode(projectTypeCode);
        if (riskProjectType == null  ) {
            validationResult.setAttributeName("ProjectType.Code");
            validationResult.setValue(null);
            validationResult.setFailed(true);
            validationResult.setNotFound(true);
            result.put("ValidationResult", validationResult);
            return  result;
        }

        ProjectRiskLevel projectRiskLevel = projectRiskLevelRepository.findByCode(projectRiskLevelCode);
        if (projectRiskLevel == null) {
            validationResult.setAttributeName("ProjectType.RiskLevel");
            validationResult.setValue(null);
            validationResult.setFailed(true);
            validationResult.setNotFound(true);
            result.put("ValidationResult", validationResult);
            return  result;
        }

        String status = "X";
        // Find Risk Model Tempalates - modelType = 1 ONLY
        List<RiskModelTemplate>  riskModelTemplates =
                riskModelTemplateRepository.findByRiskProjectTypeAndProjectRiskLevelAndModelTypeAndStatus(riskProjectType,
                                                                                          projectRiskLevel, 0,
                                                                                          status);

        if ( riskModelTemplates.size() > 1 ){
            validationResult.setAttributeName("RiskModelTemplate");
            validationResult.setValue(null);
            validationResult.setFailed(true);
            validationResult.setMultipleValueFoundError(true);
            result.put("ValidationResult", validationResult);
            return  result;
        }

        if (riskModelTemplates.size() == 1) {
            validationResult.setAttributeName("RiskModelTemplate");
            validationResult.setValue(null);
            validationResult.setFailed(false);
            result.put("ValidationResult", validationResult);
            result.put("RiskModelTemplate", riskModelTemplates.get(0));
            return result;
        }

        if (riskModelTemplates.size() == 0) {
            validationResult.setAttributeName("RiskModelTemplate");
            validationResult.setValue(null);
            validationResult.setFailed(true);
            validationResult.setNotFound(true);
            validationResult.setObject("RiskModelTemplate");
            result.put("ValidationResult", validationResult);
            return  result;
        }


        return null;
    }


    @Override
    public Map<String, Object> createRiskModelTemplate(RiskModelTemplate riskModelTemplate) {
        Map<String, Object> result = new HashMap<>();

        ValidationResult validationResult =  riskModelTemplateValidator.validate(riskModelTemplate);
        result.put("ValidationResult", validationResult);
        if (validationResult.isFailed()) {
            return result;
        }

        riskModelTemplate =  riskModelTemplateRepository.save(riskModelTemplate);
        result.put("RiskModelTemplate", riskModelTemplate);

        Long createdRiskModelTemplateId = riskModelTemplate.getId();

        //On Creating New Entities, Mark all other entities as Inactive


        List<RiskModelTemplate> riskModelTemplatesActive =
                riskModelTemplateRepository.findByRiskProjectTypeAndProjectRiskLevelAndModelTypeAndStatus(
                        riskModelTemplate.getRiskProjectType(),
                        riskModelTemplate.getProjectRiskLevel(),
                        0, //Find Template Models only
                        "X");


        for (RiskModelTemplate riskModelTemplateActive : riskModelTemplatesActive ) {
            if ( riskModelTemplateActive.getId() != createdRiskModelTemplateId ) {
                riskModelTemplateActive.setStatus(" ");
                riskModelTemplateRepository.save(riskModelTemplateActive);
            }
            }

        return result;
    }

    @Override
    public Map<String, Object> updateRiskModelTemplate(RiskModelTemplate riskModelTemplate) {

        //List of RiskType Ids for Deletion
        List<Long> idsForDeletion = new ArrayList<>();

        Map<String, Object> result = new HashMap<>();

        ValidationResult validationResult =  riskModelTemplateValidator.validate(riskModelTemplate);
        if (validationResult.isFailed()) {
            result.put("ValidationResult", validationResult);
            return result;
        }

        // Get Existing Risk Model Template
        RiskModelTemplate riskModelTemplateExisting;
        riskModelTemplateExisting = riskModelTemplateRepository.getOne(riskModelTemplate.getId());

        if (riskModelTemplateExisting == null || riskModelTemplateExisting.getId() == null){
            validationResult.setNotFound(true);
            result.put("ValidationResult", validationResult);
            return null;
        }

        //Update Header Attribtues
        riskModelTemplateExisting.setStatus(riskModelTemplate.getStatus());
        riskModelTemplateExisting.setDescription(riskModelTemplate.getDescription());
        riskModelTemplateExisting.setRiskProjectType(riskModelTemplate.getRiskProjectType());
        riskModelTemplateExisting.setProjectRiskLevel(riskModelTemplate.getProjectRiskLevel());
        riskModelTemplateExisting.setComputingMethod(riskModelTemplate.getComputingMethod());
        riskModelTemplateExisting.setScore(riskModelTemplate.getScore());
        riskModelTemplateExisting.setModelCategory(riskModelTemplate.getModelCategory());

        // Update RiskType Items
        for (RiskType riskType: riskModelTemplate.getRiskTypes()) {

            Boolean itemFound = false;

            //New Item
            if (riskType.getId() == null) {
                riskModelTemplateExisting.addRiskType(riskType);
            }

            // Modified Items
            for (RiskType riskTypeExisting : riskModelTemplate.getRiskTypes()) {

                if ( riskTypeExisting.getId() == riskType.getId() ) {
                    itemFound = true;
                    riskTypeExisting.setDescription(riskType.getDescription());
                    riskTypeExisting.setScore(riskType.getScore());

                    result =  iRiskTypeService.updateRiskType(riskTypeExisting);

                    ValidationResult validationResultRiskType  = (ValidationResult) result.get("ValidationResult");
                    if (validationResultRiskType.isFailed() == true) {
                        result.put("ValidationResult", validationResult);
                        return result;
                    }
                }
            }

            if (itemFound = false)
                idsForDeletion.add(riskType.getId());

        }
        //Update Risk Model Template
        riskModelTemplate = riskModelTemplateRepository.save(riskModelTemplateExisting);


        // Delete the Item entries
        for (Long id: idsForDeletion) {
            riskTypeRepository.deleteById(id);
        }

        result.put("ValidationResult", validationResult);
        result.put("RiskModelTemplate", riskModelTemplateExisting);

        return result;

    }


    private  List<RiskModelReportDTO> filterOutput(List<LoanApplication> loanApplications,
                                                   List<RiskModelReportDTO> riskModelReportDTOS,
                                                   Boolean activeLoanAccountsOnly,
                                                   Boolean latestRatingsOnly) {



        if (activeLoanAccountsOnly == true) {
             loanApplications = this.filterLoans(loanApplications);
        }
        if (latestRatingsOnly == true) {
            riskModelReportDTOS =   this.filterRiskModelDTOLatestDate(loanApplications,riskModelReportDTOS,activeLoanAccountsOnly,latestRatingsOnly);
        }

        return riskModelReportDTOS;

    }

    private List<LoanApplication> filterLoans (List<LoanApplication> loanApplications) {

        List<LoanApplication> loanApplicationListFiltered = new ArrayList<>();

        for (LoanApplication loanApplication : loanApplicationListFiltered) {
            if (loanApplication.getLoanCurrentContractAmount() == 0 ||
                    loanApplication.getFunctionalStatus() == 8 ||
                    loanApplication.getFunctionalStatus() == 9 ||
                    loanApplication.getFunctionalStatus() == 10 ||
                    loanApplication.getFunctionalStatus() == 11 ||
                    loanApplication.getFunctionalStatus() == 12 ||
                    loanApplication.getFunctionalStatus() == 13
                    ) {
                loanApplicationListFiltered.add(loanApplication);
            }
        }

        return loanApplicationListFiltered;
    }

//    private List<RiskModelReportDTO> filterByLoanStatus(List<LoanApplication> loanApplicationListFiltered, List<RiskModelReportDTO> riskModelReportDTOS) {
//
//        for (RiskModelReportDTO riskModelReportDTO : riskModelReportDTOS) {
//            List<RiskModelReportDTO> riskModelReportDTOSForLoan =
//                    riskModelReportDTOS.stream().filter(riskModelReportDTO -> riskModelReportDTO.getLoanNumber().equals(loanApplication.getLoanContractId()))
//                            .collect(Collectors.toList());
//        }
//
//
//    }

    private  List<RiskModelReportDTO> filterRiskModelDTOLatestDate(List<LoanApplication> loanApplications,
                                                                   List<RiskModelReportDTO> riskModelReportDTOS,
                                                                   Boolean activeLoanAccountsOnly,
                                                                   Boolean latestRatingsOnly) {
        List<RiskModelReportDTO> riskModelReportDTOSFiltered = new ArrayList<>();

        for (LoanApplication loanApplication : loanApplications) {


            List<RiskModelReportDTO> riskModelReportDTOSForLoan =
                    riskModelReportDTOS.stream().filter(riskModelReportDTO -> riskModelReportDTO.getLoanNumber().equals(loanApplication.getLoanContractId()))
                            .collect(Collectors.toList());

            //if (riskModelReportDTOSForLoan.size() > 1) {
                if (latestRatingsOnly == true) {
                    Comparator<RiskModelReportDTO> riskModelReportDTOComparator = Comparator
                            .comparing(RiskModelReportDTO::getCreateDate)
                            .thenComparing(RiskModelReportDTO::getCreatedTime);

                    riskModelReportDTOSForLoan = riskModelReportDTOSForLoan.stream()
                            .sorted(riskModelReportDTOComparator)
                            .collect(Collectors.toList());

                    if (riskModelReportDTOSForLoan.size() > 0)
                        riskModelReportDTOSFiltered.add(riskModelReportDTOSForLoan.get(riskModelReportDTOSForLoan.size()-1));

                }
            }

       // }


        return riskModelReportDTOSFiltered;

    }

    private RiskModelReportDTO mapRiskModelTemplateToRiskModelDTO(RiskModelTemplate riskModelTemplate) throws ParseException {

        RiskModelReportDTO riskModelReportDTO = new RiskModelReportDTO();

        //Id
        riskModelReportDTO.setRiskModelId(riskModelTemplate.getId());
        //    Loan number
        riskModelReportDTO.setLoanNumber(riskModelTemplate.getLoanNumber());//.replaceFirst("^0+(?!$)", ""));
        //    Project Name
        riskModelReportDTO.setProjectName(riskModelTemplate.getProjectName());
        //    Project Type
        riskModelReportDTO.setProjectType(riskModelTemplate.getRiskProjectType().getValue());
        //    Project Phase
        riskModelReportDTO.setProjectPhase(riskModelTemplate.getProjectRiskLevel().getValue());

        //    InitiatingDepartment
        riskModelReportDTO.setInitiatingDepartment(riskModelTemplate.getPurpose().getDescription());

        //    Loan contractamount(Rs Crores)
        riskModelReportDTO.setLoanContractAmount(riskModelTemplate.getLoanContractAmount());

        //    Total DisbursedAmt(Rs Crores)
        riskModelReportDTO.setTotalLoanDisbursedAmount(riskModelTemplate.getLoanDisbursedAmount());

        //    Initiator
        riskModelReportDTO.setInitiator(riskModelTemplate.getCreatedBy());

        SimpleDateFormat dateFormatter = new SimpleDateFormat(
                "dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");


        //Create Date
        if (riskModelTemplate.getRatingDate() != null) {
            String date = dateFormatter.parse(dateFormatter.format(riskModelTemplate.getRatingDate())).toString();
            String time = timeFormat.format(riskModelTemplate.getRatingDate()).toString();

            // Creation date
            riskModelReportDTO.setCreateDate(date.substring(0, 10) + " " + date.substring(24, 28));
            riskModelReportDTO.setCreatedTime(time);
        }

        //    Process date (After finalapproval)
        if (riskModelTemplate.getThirdApprovalProcessDate() != null) {
            String date = dateFormatter.parse(dateFormatter.format(riskModelTemplate.getThirdApprovalProcessDate())).toString();
            String time = timeFormat.format(riskModelTemplate.getThirdApprovalProcessDate()); //.toString();

            // Creation date
            riskModelReportDTO.setProcessDate(date.substring(0, 10) + " " + date.substring(24, 28));
            riskModelReportDTO.setProcessTime(time);
        }

        // Processed By
        riskModelReportDTO.setProcessedBy(riskModelTemplate.getThirdLevelApprover());

        //    FinalRating
        riskModelReportDTO.setFinalRating(riskModelTemplate.getFinalProjectGrade());

        // Risk Category
        if (riskModelTemplate.getFinalProjectGrade() !=null || riskModelTemplate.getFinalProjectGrade().length() > 6) {
            log.info("Final Project Grade :" + riskModelTemplate.getFinalProjectGrade());
            if (riskModelTemplate.getFinalProjectGrade() != "") {
                Integer riskRating = Integer.parseInt(riskModelTemplate.getFinalProjectGrade().substring(6).replaceAll("\\s", ""));
                if (riskRating >= 7) {
                    riskModelReportDTO.setRiskCategory("High Risk");
                } else {
                    riskModelReportDTO.setRiskCategory("Low Risk");
                }
            }

        }

        return riskModelReportDTO;


    }

}

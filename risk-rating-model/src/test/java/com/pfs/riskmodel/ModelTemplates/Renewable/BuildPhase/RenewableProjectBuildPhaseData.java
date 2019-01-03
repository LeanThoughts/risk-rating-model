package com.pfs.riskmodel.ModelTemplates.Renewable.BuildPhase;

import com.pfs.riskmodel.ModelTemplates.InfraTransmission.OperationalPhase.InfraTransmission_OperationalPhase_RiskModelSummary;
import com.pfs.riskmodel.ModelTemplates.Renewable.ParentalNotchUp.Renewable_RiskParentalNotchUp;
import com.pfs.riskmodel.ModelTemplates.Renewable.RiskTypes.RenewablePostProjectRiskTypes;
import com.pfs.riskmodel.ModelTemplates.Renewable.RiskTypes.RenewableProjectRiskTypes;
import com.pfs.riskmodel.dto.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sajeev on 18-Dec-18.
 */
public class RenewableProjectBuildPhaseData {

    public  static  RiskModelTemplateDTO riskModelTemplateDTO;

    public  RiskModelTemplateDTO getRenewableProjectBuildPhaseData( ) {

          riskModelTemplateDTO = new RiskModelTemplateDTO();


//        Overall Project Score:        Minimum of PIR and PPIR scores

//        Project Implementation Risk (PIR)
//        Project Implementation Risk  -  Weighted Scores
//        Completion Risk -50%
//        Execution Risk 50%


        riskModelTemplateDTO.setId(null);
        riskModelTemplateDTO.setStatus("X");
        riskModelTemplateDTO.setVersion("v1");
        // Renewable-Build
        riskModelTemplateDTO.setModelCategoryCode(1);

        riskModelTemplateDTO.setModelType(0); //Template

        riskModelTemplateDTO.setProjectRiskLevelCode("01");
        riskModelTemplateDTO.setProjectRiskLevelDescription("Renewables Build Phase");

        riskModelTemplateDTO.setProjectTypeCode("01");
        riskModelTemplateDTO.setProjectTypeDescription("Renewables");
        riskModelTemplateDTO.setDescription("Renewables Build Phase");
        riskModelTemplateDTO.setComputingMethodCode("03");
        riskModelTemplateDTO.setComputingMethodDescription("Minimum");
        riskModelTemplateDTO.setScore(0D);


        riskModelTemplateDTO.setLoanNumber(" ");
        riskModelTemplateDTO.setLoanAmountInCrores(0D);
        riskModelTemplateDTO.setProjectName("Template Model for Renewables Build");
        riskModelTemplateDTO.setRatingDate(Date.from(Instant.now()));

        riskModelTemplateDTO.setOverallProjectGrade("");
        riskModelTemplateDTO.setModifiedProjectGrade("");
        riskModelTemplateDTO.setAfterParentalNotchUpGrade("");
        riskModelTemplateDTO.setFinalProjectGrade("");


        RiskTypeDTO projectImplRiskTypeDTO = RenewableProjectRiskTypes.buildRiskTypes();
        RiskTypeDTO postProjectImplRiskTypeDTO = RenewablePostProjectRiskTypes.buildRiskTypes();

        // Risk Types

        riskModelTemplateDTO.addRiskTypeDTO(projectImplRiskTypeDTO);
        riskModelTemplateDTO.addRiskTypeDTO(postProjectImplRiskTypeDTO);


        // Parental NotchUP
        Renewable_RiskParentalNotchUp renewable_riskParentalNotchUp = new Renewable_RiskParentalNotchUp();
        RiskParentalNotchUpDTO riskParentalNotchUpDTO = renewable_riskParentalNotchUp.getParentalNotchUp();
        List<RiskParentalNotchUpDTO> riskParentalNotchUpDTOSet = new ArrayList<>();
        riskParentalNotchUpDTOSet.add(riskParentalNotchUpDTO);

        riskModelTemplateDTO.setRiskParentalNotchUps(riskParentalNotchUpDTOSet);

        Renewable_BuildPhase_RiskModelSummary renewable_buildPhase_riskModelSummary = new Renewable_BuildPhase_RiskModelSummary();
        List<RiskModelSummaryDTO> riskModelSummaryDTOS = renewable_buildPhase_riskModelSummary.getRiskModelSummary();
        riskModelTemplateDTO.setRiskModelSummaries(riskModelSummaryDTOS);

        return riskModelTemplateDTO;
    }

}
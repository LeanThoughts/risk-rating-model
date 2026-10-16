package com.pfs.riskmodel.ModelTemplates.SME_FI.BuildPhase;

import com.pfs.riskmodel.ModelTemplates.Renewable.BuildPhase.Renewable_BuildPhase_RiskModelSummary;
import com.pfs.riskmodel.ModelTemplates.Renewable.RiskRatingModifiers.Renewable_RatingModifierDTO;
import com.pfs.riskmodel.ModelTemplates.Renewable.RiskTypes.RenewablePostProjectRiskTypes;
import com.pfs.riskmodel.ModelTemplates.Renewable.RiskTypes.RenewableProjectRiskTypes;
import com.pfs.riskmodel.ModelTemplates.RenewablesParentalNotchupTemplate;
import com.pfs.riskmodel.ModelTemplates.SME_FI.RiskTypes.SME_FI_ProjectRiskTypes;
import com.pfs.riskmodel.dto.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sajeev on 18-Dec-18.
 */
public class SME_FI_BuildPhaseData {

    public  static  RiskModelTemplateDTO riskModelTemplateDTO;

    public  RiskModelTemplateDTO getSME_FI_BuildPhaseData( ) {

          riskModelTemplateDTO = new RiskModelTemplateDTO();


//        Overall Project Score:        Minimum of PIR and PPIR scores

//        Project Implementation Risk (PIR)
//        Project Implementation Risk  -  Weighted Scores
//        Completion Risk -50%
//        Execution Risk 50%
        System.out.println( " ----------------------- BUILDING SME & FI DATA --------------------------------------");

        riskModelTemplateDTO.setId(null);
        riskModelTemplateDTO.setStatus("X");
        riskModelTemplateDTO.setVersion("v1");
        // Renewable-Build
        riskModelTemplateDTO.setModelCategoryCode(11);

        riskModelTemplateDTO.setModelType(0); //Template

        riskModelTemplateDTO.setPurposeCode("01");
        riskModelTemplateDTO.setPurposeDescription("Project Assessment");
        riskModelTemplateDTO.setProcessInstanceId(" ");
        riskModelTemplateDTO.setWorkflowStatusCode("01");
        riskModelTemplateDTO.setWorkflowStatusDescription("Created");


        riskModelTemplateDTO.setProjectRiskLevelCode("01");
        riskModelTemplateDTO.setProjectRiskLevelDescription("SME &FI Build Phase");

        riskModelTemplateDTO.setRiskProjectTypeCode("06");
        riskModelTemplateDTO.setRiskProjectTypeDescription("SME &FI");
        riskModelTemplateDTO.setDescription("SME & FI Build Phase");
        riskModelTemplateDTO.setComputingMethodCode("03");
        riskModelTemplateDTO.setComputingMethodDescription("Minimum");
        riskModelTemplateDTO.setScore(0D);


        riskModelTemplateDTO.setLoanNumber(" ");
        riskModelTemplateDTO.setLoanAmountInCrores(0D);
        riskModelTemplateDTO.setProjectName(" ");
        riskModelTemplateDTO.setRatingDate(Date.from(Instant.now()));

        riskModelTemplateDTO.setOverallProjectGrade(" ");
        riskModelTemplateDTO.setModifiedProjectGrade(" ");
        riskModelTemplateDTO.setAfterParentalNotchUpGrade(" ");
        riskModelTemplateDTO.setFinalProjectGrade(" ");


        //riskModelTemplateDTO.setApplyParentalNotchup(false);
        riskModelTemplateDTO.setApplyParentalNotchup(false);

        RiskTypeDTO projectImplRiskTypeDTO = SME_FI_ProjectRiskTypes.buildRiskTypes();
//        RiskTypeDTO postProjectImplRiskTypeDTO = RenewablePostProjectRiskTypes.buildRiskTypes();

        // Risk Types

        riskModelTemplateDTO.addRiskTypeDTO(projectImplRiskTypeDTO);
//        riskModelTemplateDTO.addRiskTypeDTO(postProjectImplRiskTypeDTO);


        // Rating Modifiers
        List<RiskRatingModifierDTO> riskRatingModifierDTOSet = new ArrayList<>();
        Renewable_RatingModifierDTO renewable_ratingModifierDTO = new Renewable_RatingModifierDTO();
        riskRatingModifierDTOSet = renewable_ratingModifierDTO.getRiskRatingModifierDTOs();

        riskModelTemplateDTO.setRiskRatingModifiers(riskRatingModifierDTOSet);

        //  Parental Notch Up
        RenewablesParentalNotchupTemplate renewablesParentalNotchupTemplate = new RenewablesParentalNotchupTemplate();
        RiskParentalNotchUpDTO riskParentalNotchUpDTO = renewablesParentalNotchupTemplate.getParentalNotchUp();


        List<RiskParentalNotchUpDTO> riskParentalNotchUpDTOSet = new ArrayList<>();
        riskParentalNotchUpDTOSet.add(riskParentalNotchUpDTO);

        riskModelTemplateDTO.setRiskParentalNotchUps(riskParentalNotchUpDTOSet);



        SME_FI_BuildPhase_RiskModelSummary sme_fi_buildPhase_riskModelSummary = new SME_FI_BuildPhase_RiskModelSummary();
        List<RiskModelSummaryDTO> riskModelSummaryDTOS = sme_fi_buildPhase_riskModelSummary.getRiskModelSummary();
        riskModelTemplateDTO.setRiskModelSummaries(riskModelSummaryDTOS);

        System.out.println( " ----------------------- BUILDING SME & FI DATA --------------------------------------");
        System.out.println( riskModelTemplateDTO.toString());
        return riskModelTemplateDTO;
    }

}

package com.pfs.riskmodel.ModelTemplates.InfraRoadHAM.OperationalPhase;

import com.pfs.riskmodel.ModelTemplates.InfraRoadHAM.BuildPhase.InfraRoadHAM_BuildPhase_RiskModelSummary;
import com.pfs.riskmodel.ModelTemplates.InfraTransmission.ParentalNotchUp.InfraTrans_RiskParentalNotchUp;
import com.pfs.riskmodel.ModelTemplates.InfraTransmission.RiskRatingModifiers.InfraTrans_RatingModifierDTO;
import com.pfs.riskmodel.ModelTemplates.InfraTransmission.RiskTypes.InfraTrans_PostProjectImplRiskTypes;
import com.pfs.riskmodel.dto.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sajeev on 29-Dec-18.
 */
public class InfraRoadHAM_OperationalPhaseData {


    RiskModelTemplateDTO riskModelTemplateDTO = new RiskModelTemplateDTO();


    public RiskModelTemplateDTO getInfraRoadHAM_OperationalPhaseData() {


        riskModelTemplateDTO = new RiskModelTemplateDTO();

        //        Overall Project Score:        Risk Type Score
        riskModelTemplateDTO.setId(null);
        riskModelTemplateDTO.setStatus("X");
        riskModelTemplateDTO.setVersion("v1");
        // Model Category 6: InfraRoadProjectHybridAnnuity-Operational
        riskModelTemplateDTO.setModelCategoryCode(6);

        riskModelTemplateDTO.setModelType(0); //Template

        riskModelTemplateDTO.setProjectRiskLevelCode("02");
        riskModelTemplateDTO.setProjectRiskLevelDescription("Infrastructure Road HAM Operational Phase");

        riskModelTemplateDTO.setProjectTypeCode("03");
        riskModelTemplateDTO.setProjectTypeDescription("Infrastructure Road HAM");

        riskModelTemplateDTO.setDescription("Infrastructure Road HAM Operational Phase");
        riskModelTemplateDTO.setComputingMethodCode("05");
        riskModelTemplateDTO.setComputingMethodDescription("Equals");
        riskModelTemplateDTO.setScore(0D);


        riskModelTemplateDTO.setLoanNumber(" ");
        riskModelTemplateDTO.setLoanAmountInCrores(0D);
        riskModelTemplateDTO.setProjectName("Template Model for Infra. Road HAM Operational Phase");
        riskModelTemplateDTO.setRatingDate(Date.from(Instant.now()));

        riskModelTemplateDTO.setOverallProjectGrade("");
        riskModelTemplateDTO.setModifiedProjectGrade("");
        riskModelTemplateDTO.setAfterParentalNotchUpGrade("");
        riskModelTemplateDTO.setFinalProjectGrade("");



        // RiskType
        //Project Risk Rating of Infrastructure Tranmission Operational Phase = Post Project Implementation Score
        InfraTrans_PostProjectImplRiskTypes infraTransPostProjectImplRiskTypes = new InfraTrans_PostProjectImplRiskTypes();
        RiskTypeDTO riskTypeDTO = infraTransPostProjectImplRiskTypes.buildPostProjectImplRiskTypes();

        riskModelTemplateDTO.addRiskTypeDTO(riskTypeDTO);


        // Rating Modifiers
        List<RiskRatingModifierDTO> riskRatingModifierDTOSet = new ArrayList<>();
        InfraTrans_RatingModifierDTO infraTrans_ratingModifierDTO = new InfraTrans_RatingModifierDTO();
        riskRatingModifierDTOSet = infraTrans_ratingModifierDTO.getRiskRatingModifierDTOs();

        riskModelTemplateDTO.setRiskRatingModifiers(riskRatingModifierDTOSet);

        // Parental Notchup
        RiskParentalNotchUpDTO riskParentalNotchUpDTO = new RiskParentalNotchUpDTO();
        InfraTrans_RiskParentalNotchUp infraTrans_riskParentalNotchUp = new InfraTrans_RiskParentalNotchUp();
        riskParentalNotchUpDTO = infraTrans_riskParentalNotchUp.getInfraTransmissonParentalNotchup();

        List<RiskParentalNotchUpDTO> riskParentalNotchUpDTOSet = new ArrayList<>();
        riskParentalNotchUpDTOSet.add(riskParentalNotchUpDTO);

        riskModelTemplateDTO.setRiskParentalNotchUps(riskParentalNotchUpDTOSet);

        InfraRoadHAM_OperationalPhase_RiskModelSummary infraRoadHAM_operationalPhase_riskModelSummary = new InfraRoadHAM_OperationalPhase_RiskModelSummary();
        List<RiskModelSummaryDTO> riskModelSummaryDTOS = infraRoadHAM_operationalPhase_riskModelSummary.getRiskModelSummary();
        riskModelTemplateDTO.setRiskModelSummaries(riskModelSummaryDTOS);


        return riskModelTemplateDTO;

    }

}
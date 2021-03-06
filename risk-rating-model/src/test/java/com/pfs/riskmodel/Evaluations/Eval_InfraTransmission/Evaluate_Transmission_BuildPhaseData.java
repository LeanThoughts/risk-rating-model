package com.pfs.riskmodel.Evaluations.Eval_InfraTransmission;

import com.pfs.riskmodel.ModelTemplates.InfraTransmission.BuildPhase.InfraTransmission_BuildPhase_RiskModelSummary;
import com.pfs.riskmodel.ModelTemplates.InfraTransmission.ParentalNotchUp.InfraTrans_RiskParentalNotchUp;
import com.pfs.riskmodel.ModelTemplates.InfraTransmission.RiskRatingModifiers.InfraTrans_RatingModifierDTO;
import com.pfs.riskmodel.ModelTemplates.InfraTransmission.RiskTypes.InfraTrans_PostProjectImplRiskTypes;
import com.pfs.riskmodel.ModelTemplates.InfraTransmission.RiskTypes.InfraTrans_ProjectImplRiskTypes;
import com.pfs.riskmodel.dto.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sajeev on 29-Dec-18.
 */
public class Evaluate_Transmission_BuildPhaseData {
    RiskModelTemplateDTO riskModelTemplateDTO = new RiskModelTemplateDTO();


    public RiskModelTemplateDTO getTransmission_BuildPhaseData() {


        riskModelTemplateDTO = new RiskModelTemplateDTO();

        //        Overall Project Score:        Minimum of PIR and PPIR
        riskModelTemplateDTO.setId(null);
        riskModelTemplateDTO.setStatus("X");
        riskModelTemplateDTO.setVersion("v1");
        // Model Category 3: InfraTransmission-Build
        riskModelTemplateDTO.setModelCategoryCode(3);

        riskModelTemplateDTO.setModelType(1); //Valuation - NOT TEMPLATE

        riskModelTemplateDTO.setPurposeCode("01");
        riskModelTemplateDTO.setPurposeDescription("Project Assessment");
        riskModelTemplateDTO.setProcessInstanceId(" ");
        riskModelTemplateDTO.setWorkflowStatusCode("01");
        riskModelTemplateDTO.setWorkflowStatusDescription("Created");


        riskModelTemplateDTO.setProjectRiskLevelCode("01"); // Build Phase
        riskModelTemplateDTO.setProjectRiskLevelDescription("Infrastructure Transmission Build Phase");

        riskModelTemplateDTO.setRiskProjectTypeCode("02");
        riskModelTemplateDTO.setRiskProjectTypeDescription("Infrastructure Transmission");

        riskModelTemplateDTO.setDescription("Infrastructure Transmission");
        riskModelTemplateDTO.setComputingMethodCode("03");
        riskModelTemplateDTO.setComputingMethodDescription("Minimum"); //Minimum of PIR and PPIR
        riskModelTemplateDTO.setScore(0D);



        riskModelTemplateDTO.setLoanNumber("1000001");
        riskModelTemplateDTO.setLoanAmountInCrores(2000D);
        riskModelTemplateDTO.setProjectName("ABC Transmission Infrastrucutres");
        riskModelTemplateDTO.setRatingDate(Date.from(Instant.now()));

        riskModelTemplateDTO.setOverallProjectGrade(" ");
        riskModelTemplateDTO.setModifiedProjectGrade(" ");
        riskModelTemplateDTO.setAfterParentalNotchUpGrade(" ");
        riskModelTemplateDTO.setFinalProjectGrade(" ");


        // RiskType
        //Project Risk Rating of Infrastructure Toll Build Phase = Minimum of PIR and PPIR  Scores


        // Project Impl. Risk Types
        InfraTrans_ProjectImplRiskTypes projectImplRiskTypes = new InfraTrans_ProjectImplRiskTypes();
        RiskTypeDTO projectImplRiskTypeDTO = projectImplRiskTypes.buildProjectImplRiskTypes();


        // Set TEST DATA for Risk Sub Factor Attributes per Risk Component per Risk Sub Factor
        for (RiskComponentDTO riskComponentDTO: projectImplRiskTypeDTO.getRiskComponents()) {

            for (RiskFactorDTO riskFactorDTO: riskComponentDTO.getRiskFactors())  {

                for (RiskSubFactorDTO riskSubFactorDTO: riskFactorDTO.getRiskSubFactors()) {

                    Boolean riskDeflator = false;
                    if (riskSubFactorDTO.getScoreTypeCode().equals("02") ||  riskSubFactorDTO.getScoreTypeCode().equals("03"))
                        riskDeflator = true;

                    for (RiskSubFactorAttributeDTO riskSubFactorAttributeDTO: riskSubFactorDTO.getRiskSubFactorAttributes()) {
                        // Select the second last attribute
                        Integer secondLastItem = riskSubFactorDTO.getRiskSubFactorAttributes().size() - 1;

                        // Select first attribute for Deflators and secondLastItem for Normal SubFactors
                        Integer itemNo = 1;
                        if (riskDeflator == true)
                            itemNo = 1;
                        else
                            itemNo = secondLastItem;

                        // Select second item only for execution risk
                        if (riskComponentDTO.getDescription().contains("Execution")) {
                            if (riskSubFactorAttributeDTO.getItemNo() == 2) {
                                riskSubFactorAttributeDTO.setIsSelected(true);
                                break;
                            }
                        }
                        else {
                            if (riskSubFactorAttributeDTO.getItemNo() == itemNo) {
                                riskSubFactorAttributeDTO.setIsSelected(true);
                                break;
                            }
                        }





                    }
                }
            }
        }


        riskModelTemplateDTO.addRiskTypeDTO(projectImplRiskTypeDTO);


        // Post Project Impl. Risk Types
        InfraTrans_PostProjectImplRiskTypes postProjectImplRiskTypes = new InfraTrans_PostProjectImplRiskTypes();
        RiskTypeDTO postProjectImplRiskTypeDTO = postProjectImplRiskTypes.buildPostProjectImplRiskTypes();

        // Set TEST DATA for Risk Sub Factor Attributes per Risk Component per Risk Sub Factor
        for (RiskComponentDTO riskComponentDTO: postProjectImplRiskTypeDTO.getRiskComponents()) {

            for (RiskFactorDTO riskFactorDTO: riskComponentDTO.getRiskFactors())  {

                for (RiskSubFactorDTO riskSubFactorDTO: riskFactorDTO.getRiskSubFactors()) {

                    Boolean riskDeflator = false;
                    if (riskSubFactorDTO.getScoreTypeCode().equals("02") ||  riskSubFactorDTO.getScoreTypeCode().equals("03"))
                        riskDeflator = true;

                    for (RiskSubFactorAttributeDTO riskSubFactorAttributeDTO: riskSubFactorDTO.getRiskSubFactorAttributes()) {
                        // Select the second last attribute
                        Integer secondLastItem = riskSubFactorDTO.getRiskSubFactorAttributes().size() - 1;

                        // Select first attribute for Deflators and secondLastItem for Normal SubFactors
                        Integer itemNo = 1;
                        if (riskDeflator == true)
                            itemNo = 1;
                        else
                            itemNo = secondLastItem;


                        if (riskSubFactorAttributeDTO.getItemNo() == itemNo) {
                             riskSubFactorAttributeDTO.setIsSelected(true);
                            break;
                        }
                    }
                }
            }
        }


        riskModelTemplateDTO.addRiskTypeDTO(postProjectImplRiskTypeDTO);



        // Rating Modifiers

        List<RiskRatingModifierDTO> riskRatingModifierDTOSet = new ArrayList<>();
        InfraTrans_RatingModifierDTO infraTrans_ratingModifierDTO = new InfraTrans_RatingModifierDTO();
        riskRatingModifierDTOSet = infraTrans_ratingModifierDTO.getRiskRatingModifierDTOs();

        for (RiskRatingModifierDTO riskRatingModifierDTO:riskRatingModifierDTOSet) {
            if (riskRatingModifierDTO.getModifierType() == 0)
                for (RiskRatingModifierAttributeDTO riskRatingModifierAttributeDTO : riskRatingModifierDTO.getRiskRatingModifierAttributes()) {
                    riskRatingModifierAttributeDTO.setYesOrNoIndicator('N');
                }
            else {
                for (RiskRatingModifierAttributeDTO riskRatingModifierAttributeDTO : riskRatingModifierDTO.getRiskRatingModifierAttributes()) {
                    riskRatingModifierAttributeDTO.setYesOrNoIndicator('Y');

                }

            }
        }


        riskModelTemplateDTO.setRiskRatingModifiers(riskRatingModifierDTOSet);

        // Parental Notchup
        RiskParentalNotchUpDTO riskParentalNotchUpDTO = new RiskParentalNotchUpDTO();
        InfraTrans_RiskParentalNotchUp infraTrans_riskParentalNotchUp = new InfraTrans_RiskParentalNotchUp();
        riskParentalNotchUpDTO = infraTrans_riskParentalNotchUp.getInfraTransmissonParentalNotchup();


        for (RiskParentalNotchUpConditionDTO riskParentalNotchUpConditionDTO: riskParentalNotchUpDTO.getRiskParentalConditions()) {

            // Obligor Rating Grade of the Parent Firm as per reference source
            if (riskParentalNotchUpConditionDTO.getItemNo() == 1) {
                riskParentalNotchUpConditionDTO.setValue("1");

            }
            //Borrower Rating Grade of the Parent Firm
            if (riskParentalNotchUpConditionDTO.getItemNo() == 2) {
                riskParentalNotchUpConditionDTO.setValue("1");

            }
            // The parent’s rating is better than the borrower’s rating
            if (riskParentalNotchUpConditionDTO.getItemNo() == 3) {
                riskParentalNotchUpConditionDTO.setYesNoIndicatorValue('Y');
            }
            // The borrower’s rating is not GRADE10 (in default)
            if (riskParentalNotchUpConditionDTO.getItemNo() == 4) {
                riskParentalNotchUpConditionDTO.setYesNoIndicatorValue('Y');
            }
        }

        // Select First Item for Parental Notcuhup Sub Factor Attributes
        for (RiskSubFactorDTO riskSubFactorDTO: riskParentalNotchUpDTO.getRiskSubFactors()) {
            for (RiskSubFactorAttributeDTO riskSubFactorAttributeDTO: riskSubFactorDTO.getRiskSubFactorAttributes()){
                if (riskSubFactorAttributeDTO.getItemNo() == 1)
                    riskSubFactorAttributeDTO.setIsSelected(true);
            }
        }


        List<RiskParentalNotchUpDTO> riskParentalNotchUpDTOSet = new ArrayList<>();
        riskParentalNotchUpDTOSet.add(riskParentalNotchUpDTO);


        InfraTransmission_BuildPhase_RiskModelSummary infraTransmission_buildPhase_riskModelSummary = new InfraTransmission_BuildPhase_RiskModelSummary();
        List<RiskModelSummaryDTO> riskModelSummaryDTOS = infraTransmission_buildPhase_riskModelSummary.getRiskModelSummary();
        riskModelTemplateDTO.setRiskModelSummaries(riskModelSummaryDTOS);

        riskModelTemplateDTO.setRiskParentalNotchUps(riskParentalNotchUpDTOSet);

        return riskModelTemplateDTO;
    }
}

package com.pfs.riskmodel.ModelTemplates.SME_FI.RiskComponents;

import com.pfs.riskmodel.dto.RiskComponentDTO;
import com.pfs.riskmodel.dto.RiskFactorDTO;
import com.pfs.riskmodel.dto.RiskSubFactorAttributeDTO;
import com.pfs.riskmodel.dto.RiskSubFactorDTO;

/**
 * Created by sajeev on 19-Dec-18.
 */
public  class SME_FI_PP_ManagementRiskRiskComponentDTO {

    public static RiskComponentDTO getManagementRiskComponentDTO () {

     //   RiskComponentDTO riskComponentDTO = new RiskComponentDTO();
        /**********************************************************************************************************************
         *  Risk Component 1 :Management Risk -35%
         *  This has only two levels below and therefore the Risk Factor will be a dummy entry (Management Risk Factor) with same name
         **********************************************************************************************************************/

        //                       Risk Type 1 - Risk Component 1
        //  1                      Management Risk
        RiskComponentDTO financialRiskComponentDTO = new RiskComponentDTO();
        financialRiskComponentDTO.setId(null);
        financialRiskComponentDTO.setItemNo(4);
        financialRiskComponentDTO.setDescription("Management Risk");
        financialRiskComponentDTO.setWeightage(0.10D);
        financialRiskComponentDTO.setComputingMethodCode("05");
        financialRiskComponentDTO.setComputingMethodDescription("Equals");
        financialRiskComponentDTO.setScoreTypeCode("01");
        financialRiskComponentDTO.setScoreTypeDescription("Normal");
        financialRiskComponentDTO.setScore(0D);

        financialRiskComponentDTO.setIsApplicable(true);


        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1
        //1.1                           Management Risk ->Management Risk Factor (DUMMY ENTRY)
        // *  Value Derived from the Risk Sub Factor is just passed on - Therefore Computing Method = EQUALS
        //                                       100%

        RiskFactorDTO financialRiskFactorDTO = new RiskFactorDTO();
        financialRiskFactorDTO.setId(null);
        financialRiskFactorDTO.setItemNo(1);
        financialRiskFactorDTO.setDescription("Management Risk Factor");
        financialRiskFactorDTO.setWeightage(1.00);
        financialRiskFactorDTO.setComputingMethodCode("01");
        financialRiskFactorDTO.setComputingMethodDescription("Weighted");
        financialRiskFactorDTO.setScoreTypeCode("01");
        financialRiskFactorDTO.setScoreTypeDescription("Normal");
        financialRiskFactorDTO.setScore(0D);


        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1 - Risk SubFactor 1
        // 1.1.1                     Management Risk ->Management Risk Factor - > Shareholding of promoters and Institutional investors

        ///                                     40%
        RiskSubFactorDTO shareHoldingRiskSubFactorDTO = new RiskSubFactorDTO();
        shareHoldingRiskSubFactorDTO.setId(null);
        shareHoldingRiskSubFactorDTO.setItemNo(1);
        shareHoldingRiskSubFactorDTO.setDescription("Shareholding of promoters and Institutional investors");
        shareHoldingRiskSubFactorDTO.setWeightage(0.40D);
        shareHoldingRiskSubFactorDTO.setScore(0D);
        shareHoldingRiskSubFactorDTO.setScoreTypeCode("01");
        shareHoldingRiskSubFactorDTO.setScoreTypeDescription("Normal");

        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                      Management Risk ->Management Risk Factor - > Shareholding of promoters and Institutional investors -> Attributes
        // 1.1.1 -> Four Attributes

        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Aggregate shareholding of promoters and institutional investors \ncontinues to be more than 51% over the last 3 financial years");
        riskSubFactorAttributeDTO1.setScore(10D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Aggregate shareholding of promoters and institutional investors \ncontinues to be in the range of 26% - 50% over the last three years");
        riskSubFactorAttributeDTO2.setScore(5.00D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Aggregate shareholding of promoters and institutional investors \nis less than 26% over the last three years");
        riskSubFactorAttributeDTO3.setScore(0.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);



        // Collect Risk Sub Factor Attributes
        shareHoldingRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        shareHoldingRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        shareHoldingRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);



        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 2
        // 1.1.2                     Management Risk ->Management Risk Factor - > Industry experience of Board of Directors and Senior Management 
        ///                                     35%
        RiskSubFactorDTO industryExperienceRiskSubFactorDTO = new RiskSubFactorDTO();
        industryExperienceRiskSubFactorDTO.setId(null);
        industryExperienceRiskSubFactorDTO.setItemNo(2);
        industryExperienceRiskSubFactorDTO.setDescription("Industry experience of Board of Directors and Senior Management ");
        industryExperienceRiskSubFactorDTO.setWeightage(0.35D);
        industryExperienceRiskSubFactorDTO.setScore(0D);
        industryExperienceRiskSubFactorDTO.setScoreTypeCode("01");
        industryExperienceRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                      Management Risk ->Management Risk Factor - > Industry experience of Board of Directors and Senior Management  -> Attributes
        // 1.1.2 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Board of Directors and senior management possess very good experience of financial services sector in India");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Board of Directors and senior management possess reasonable experience of financial services sector in India");
        riskSubFactorAttributeDTO2.setScore(5.00D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Aggregate shareholding of promoters and institutional investors is less than 26% over the last three years");
        riskSubFactorAttributeDTO3.setScore(0.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);


        // Collect Risk Sub Factor Attributes
        industryExperienceRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        industryExperienceRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        industryExperienceRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
 


        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 3
        // 1.1.3                    Management Risk ->Management Risk Factor - >  Track Record of Promoters in Mobilization of Capital          
        ///                                     25%
        RiskSubFactorDTO trackRecordRiskSubFactorDTO = new RiskSubFactorDTO();
        trackRecordRiskSubFactorDTO.setId(null);
        trackRecordRiskSubFactorDTO.setItemNo(3);
        trackRecordRiskSubFactorDTO.setDescription(" Track Record of Promoters in Mobilization of Capital          ");
        trackRecordRiskSubFactorDTO.setWeightage(0.25D);
        trackRecordRiskSubFactorDTO.setScore(0D);
        trackRecordRiskSubFactorDTO.setScoreTypeCode("01");
        trackRecordRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                      Management Risk ->Management Risk Factor - > Track Record of Promoters in Mobilization of Capital          ------> Attributes
        // 1.1.3 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Board of Directors and senior management possess very good experience of financial services sector in India");
        riskSubFactorAttributeDTO1.setScore(10D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Board of Directors and senior management possess reasonable experience of financial services sector in India");
        riskSubFactorAttributeDTO2.setScore(5.00D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Board of Directors and senior management does not have reasonable experience of financial services sector in India");
        riskSubFactorAttributeDTO3.setScore(0.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);


        // Collect Risk Sub Factor Attributes
        trackRecordRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        trackRecordRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        trackRecordRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);


        //Collect RiskFactor
        financialRiskFactorDTO.addRiskSubFactorDTO(shareHoldingRiskSubFactorDTO);
        financialRiskFactorDTO.addRiskSubFactorDTO(industryExperienceRiskSubFactorDTO);
        financialRiskFactorDTO.addRiskSubFactorDTO(trackRecordRiskSubFactorDTO);

        //Collect Risk Factors
        financialRiskComponentDTO.addRiskFactorDTO(financialRiskFactorDTO);
        return  financialRiskComponentDTO;

    }
}

package com.pfs.riskmodel.ModelTemplates.SME_FI.RiskComponents;

import com.pfs.riskmodel.dto.RiskComponentDTO;
import com.pfs.riskmodel.dto.RiskFactorDTO;
import com.pfs.riskmodel.dto.RiskSubFactorAttributeDTO;
import com.pfs.riskmodel.dto.RiskSubFactorDTO;

/**
 * Created by sajeev on 19-Dec-18.
 */
public  class SME_FI_PP_BusinessRiskRiskComponentDTO {

    public static RiskComponentDTO getBusinessRiskComponentDTO () {

     //   RiskComponentDTO riskComponentDTO = new RiskComponentDTO();
        /**********************************************************************************************************************
         *  Risk Component 1 : Business - 30%
         *  
         **********************************************************************************************************************/

        //                       Risk Type 1 - Risk Component 1
        //  1                       Business Risk
        RiskComponentDTO businessRiskComponentDTO = new RiskComponentDTO();
        businessRiskComponentDTO.setId(null);
        businessRiskComponentDTO.setItemNo(4);
        businessRiskComponentDTO.setDescription("Business Risk");
        businessRiskComponentDTO.setWeightage(0.30D);
        businessRiskComponentDTO.setComputingMethodCode("05");
        businessRiskComponentDTO.setComputingMethodDescription("Equals");
        businessRiskComponentDTO.setScoreTypeCode("01");
        businessRiskComponentDTO.setScoreTypeDescription("Normal");
        businessRiskComponentDTO.setScore(0D);

        businessRiskComponentDTO.setIsApplicable(true);


        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1
        //1.1                            Business Risk -> Business Risk Factor (DUMMY ENTRY)
        // *  Value Derived from the Risk Sub Factor is just passed on - Therefore Computing Method = EQUALS
        //                                       100%

        RiskFactorDTO businessRiskFactorDTO = new RiskFactorDTO();
        businessRiskFactorDTO.setId(null);
        businessRiskFactorDTO.setItemNo(1);
        businessRiskFactorDTO.setDescription("Business Risk Factor");
        businessRiskFactorDTO.setWeightage(1.00);
        businessRiskFactorDTO.setComputingMethodCode("01");
        businessRiskFactorDTO.setComputingMethodDescription("Weighted");
        businessRiskFactorDTO.setScoreTypeCode("01");
        businessRiskFactorDTO.setScoreTypeDescription("Normal");
        businessRiskFactorDTO.setScore(0D);


        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1 - Risk SubFactor 1
        // 1.1.1                      Business Risk -> Business Risk Factor - > Growth in Asset Under Management  

        ///                                    15%
        RiskSubFactorDTO growthOnAssetRiskSubFactorDTO = new RiskSubFactorDTO();
        growthOnAssetRiskSubFactorDTO.setId(null);
        growthOnAssetRiskSubFactorDTO.setItemNo(1);
        growthOnAssetRiskSubFactorDTO.setDescription("Growth in Asset Under Management");
        growthOnAssetRiskSubFactorDTO.setWeightage(0.15D);
        growthOnAssetRiskSubFactorDTO.setScore(0D);
        growthOnAssetRiskSubFactorDTO.setScoreTypeCode("01");
        growthOnAssetRiskSubFactorDTO.setScoreTypeDescription("Normal");

        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Business Risk -> Business Risk Factor - > Growth in Asset Under Management   -> Attributes
        // 1.1.1 -> 5 Attributes

        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("CAGR is equal or more than 18%");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("CAGR is equal or more than 14% but less than 18%");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("CAGR is equal or more 10% but less than 14%");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO4 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("CAGR is equal or more than 6% but less than 10%");
        riskSubFactorAttributeDTO4.setScore(2.50D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO5 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO5.setId(null);
        riskSubFactorAttributeDTO5.setItemNo(5);
        riskSubFactorAttributeDTO5.setDescription("CAGR is less than 6%");
        riskSubFactorAttributeDTO5.setScore(0.00D);
        riskSubFactorAttributeDTO5.setWeightage(00D);riskSubFactorAttributeDTO5.setIsSelected(false);




        // Collect Risk Sub Factor Attributes
        growthOnAssetRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        growthOnAssetRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        growthOnAssetRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        growthOnAssetRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        growthOnAssetRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);


        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 2
        // 1.1.2                      Business Risk -> Business Risk Factor - > Asset Concentration 
        ///                                     25%
        RiskSubFactorDTO assetConcentrationRiskSubFactorDTO = new RiskSubFactorDTO();
        assetConcentrationRiskSubFactorDTO.setId(null);
        assetConcentrationRiskSubFactorDTO.setItemNo(2);
        assetConcentrationRiskSubFactorDTO.setDescription("Asset Concentration");
        assetConcentrationRiskSubFactorDTO.setWeightage(0.25D);
        assetConcentrationRiskSubFactorDTO.setScore(0D);
        assetConcentrationRiskSubFactorDTO.setScoreTypeCode("01");
        assetConcentrationRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Business Risk -> Business Risk Factor - > Asset Concentration  -> Attributes
        // 1.1.2 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Aggregate asset concentration to unsecured category across the asset class \n is equal or less than 20% of Asset Under Management (AUM)");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Aggregate asset concentration to unsecured category across the asset class \n is more than 20% but less than 35% of Asset Under Management (AUM)");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Aggregate asset concentration to unsecured category across the asset class \n is equal or more than 35% but less than 50% of Asset Under Management (AUM)");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);


        riskSubFactorAttributeDTO4 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("EAggregate asset concentration to unsecured category across the asset class \n is equal or more than 50% but less than 65% of Asset Under Management (AUM)");
        riskSubFactorAttributeDTO4.setScore(2.50D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);

        riskSubFactorAttributeDTO5 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO5.setId(null);
        riskSubFactorAttributeDTO5.setItemNo(5);
        riskSubFactorAttributeDTO5.setDescription("Aggregate asset concentration to unsecured category across the asset class \n is equal or more than 65% of Asset Under Management (AUM)");
        riskSubFactorAttributeDTO5.setScore(0.00D);
        riskSubFactorAttributeDTO5.setWeightage(00D);riskSubFactorAttributeDTO5.setIsSelected(false);


        // Collect Risk Sub Factor Attributes
        assetConcentrationRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        assetConcentrationRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        assetConcentrationRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        assetConcentrationRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        assetConcentrationRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);



        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 3
        // 1.1.3                     Business Risk -> Business Risk Factor - > Total Asset Under Management
        ///                                     30%
        RiskSubFactorDTO assetUnderManagementRiskSubFactorDTO = new RiskSubFactorDTO();
        assetUnderManagementRiskSubFactorDTO.setId(null);
        assetUnderManagementRiskSubFactorDTO.setItemNo(3);
        assetUnderManagementRiskSubFactorDTO.setDescription("Total Asset Under Management  ");
        assetUnderManagementRiskSubFactorDTO.setWeightage(0.30D);
        assetUnderManagementRiskSubFactorDTO.setScore(0D);
        assetUnderManagementRiskSubFactorDTO.setScoreTypeCode("01");
        assetUnderManagementRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Business Risk -> Business Risk Factor - > Total Asset Under Management  ------> Attributes
        // 1.1.3 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Equal or more than 20,000 crores");
        riskSubFactorAttributeDTO1.setScore(10D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Equal or more than 10,000 crores but less than 20,000 crores");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Equal or more than 4,000 crores but less than 10,000 crores");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);


        riskSubFactorAttributeDTO4 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("Equal or more than 1,000 crores but less than 4,000 crores");
        riskSubFactorAttributeDTO4.setScore(2.50D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);


        riskSubFactorAttributeDTO5 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO5.setId(null);
        riskSubFactorAttributeDTO5.setItemNo(5);
        riskSubFactorAttributeDTO5.setDescription("Less than 1000 crores");
        riskSubFactorAttributeDTO5.setScore(0.00D);
        riskSubFactorAttributeDTO5.setWeightage(00D);riskSubFactorAttributeDTO5.setIsSelected(false);

        // Collect Risk Sub Factor Attributes
        assetUnderManagementRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        assetUnderManagementRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        assetUnderManagementRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        assetUnderManagementRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        assetUnderManagementRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);


        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 4
        // 1.1.4                    Business Risk -> Business Risk Factor - >  Type of Lenders
        ///                                     20%
        RiskSubFactorDTO typeOfLendersRiskSubFactorDTO = new RiskSubFactorDTO();
        typeOfLendersRiskSubFactorDTO.setId(null);
        typeOfLendersRiskSubFactorDTO.setItemNo(4);
        typeOfLendersRiskSubFactorDTO.setDescription("Type of Lenders");
        typeOfLendersRiskSubFactorDTO.setWeightage(0.20D);
        typeOfLendersRiskSubFactorDTO.setScore(0D);
        typeOfLendersRiskSubFactorDTO.setScoreTypeCode("01");
        typeOfLendersRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Business Risk -> Business Risk Factor - >  Type of Lenders ------> Attributes
        // 1.1.4 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Borrowings from Equal or more than 4 types of lenders");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);

        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Borrowings from 3 types of lenders");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Borrowings from 2 types of lenders");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);

        riskSubFactorAttributeDTO4 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("Borrowings from 1 types of lenders");
        riskSubFactorAttributeDTO4.setScore(0.00D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);

        // Collect Risk Sub Factor Attributes
        typeOfLendersRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        typeOfLendersRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        typeOfLendersRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        typeOfLendersRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        typeOfLendersRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);



        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 4
        // 1.1.5                    Business Risk -> Business Risk Factor - > Geographical Diversity 
        ///                                     10%
        RiskSubFactorDTO geographicalDiversityRiskSubFactorDTO = new RiskSubFactorDTO();
        geographicalDiversityRiskSubFactorDTO.setId(null);
        geographicalDiversityRiskSubFactorDTO.setItemNo(5);
        geographicalDiversityRiskSubFactorDTO.setDescription("Geographical Diversity");
        geographicalDiversityRiskSubFactorDTO.setWeightage(0.10D);
        geographicalDiversityRiskSubFactorDTO.setScore(0D);
        geographicalDiversityRiskSubFactorDTO.setScoreTypeCode("01");
        geographicalDiversityRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Business Risk -> Business Risk Factor - > Geographical Diversity  ------> Attributes
        // 1.1.5 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Equal to or more than 85% of the AUM concentration in more than 4 states");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);

        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Equal to or more than 85% of the AUM concentration in 4 states");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);

        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Equal to or more than 85% of the AUM concentration in 3 states");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);

        riskSubFactorAttributeDTO4 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("Equal to or more than 85% of the AUM concentration in 2 states");
        riskSubFactorAttributeDTO4.setScore(2.50D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);


        riskSubFactorAttributeDTO5 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO5.setId(null);
        riskSubFactorAttributeDTO5.setItemNo(5);
        riskSubFactorAttributeDTO5.setDescription("Equal to or more than 85% of the AUM concentration in 1 state");
        riskSubFactorAttributeDTO5.setScore(0.00D);
        riskSubFactorAttributeDTO5.setWeightage(00D);riskSubFactorAttributeDTO5.setIsSelected(false);



        // Collect Risk Sub Factor Attributes
        geographicalDiversityRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        geographicalDiversityRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        geographicalDiversityRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        geographicalDiversityRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        geographicalDiversityRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);

 

        //Collect RiskFactor
        businessRiskFactorDTO.addRiskSubFactorDTO(growthOnAssetRiskSubFactorDTO);
        businessRiskFactorDTO.addRiskSubFactorDTO(assetConcentrationRiskSubFactorDTO);
        businessRiskFactorDTO.addRiskSubFactorDTO(assetUnderManagementRiskSubFactorDTO);
        businessRiskFactorDTO.addRiskSubFactorDTO(typeOfLendersRiskSubFactorDTO);
        businessRiskFactorDTO.addRiskSubFactorDTO(geographicalDiversityRiskSubFactorDTO);

        //Collect Risk Factors
        businessRiskComponentDTO.addRiskFactorDTO(businessRiskFactorDTO);
        return  businessRiskComponentDTO;

    }
}

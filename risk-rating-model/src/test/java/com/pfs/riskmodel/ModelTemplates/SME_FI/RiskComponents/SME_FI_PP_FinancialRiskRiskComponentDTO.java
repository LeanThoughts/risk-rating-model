package com.pfs.riskmodel.ModelTemplates.SME_FI.RiskComponents;

import com.pfs.riskmodel.dto.RiskComponentDTO;
import com.pfs.riskmodel.dto.RiskFactorDTO;
import com.pfs.riskmodel.dto.RiskSubFactorAttributeDTO;
import com.pfs.riskmodel.dto.RiskSubFactorDTO;

/**
 * Created by sajeev on 19-Dec-18.
 */
public  class SME_FI_PP_FinancialRiskRiskComponentDTO {

    public static RiskComponentDTO getFinancialRiskComponentDTO () {

     //   RiskComponentDTO riskComponentDTO = new RiskComponentDTO();
        /**********************************************************************************************************************
         *  Risk Component 1 : Financial Risk -35%
         *  This has only two levels below and therefore the Risk Factor will be a dummy entry (Financial Risk Factor) with same name
         **********************************************************************************************************************/

        //                       Risk Type 1 - Risk Component 1
        //  1                       Financial Risk
        RiskComponentDTO financialRiskComponentDTO = new RiskComponentDTO();
        financialRiskComponentDTO.setId(null);
        financialRiskComponentDTO.setItemNo(4);
        financialRiskComponentDTO.setDescription("Financial Risk");
        financialRiskComponentDTO.setWeightage(0.35D);
        financialRiskComponentDTO.setComputingMethodCode("05");
        financialRiskComponentDTO.setComputingMethodDescription("Equals");
        financialRiskComponentDTO.setScoreTypeCode("01");
        financialRiskComponentDTO.setScoreTypeDescription("Normal");
        financialRiskComponentDTO.setScore(0D);

        financialRiskComponentDTO.setIsApplicable(true);


        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1
        //1.1                            Financial Risk -> Financial Risk Factor (DUMMY ENTRY)
        // *  Value Derived from the Risk Sub Factor is just passed on - Therefore Computing Method = EQUALS
        //                                       100%

        RiskFactorDTO financialRiskFactorDTO = new RiskFactorDTO();
        financialRiskFactorDTO.setId(null);
        financialRiskFactorDTO.setItemNo(1);
        financialRiskFactorDTO.setDescription("Financial Risk Factor");
        financialRiskFactorDTO.setWeightage(1.00);
        financialRiskFactorDTO.setComputingMethodCode("01");
        financialRiskFactorDTO.setComputingMethodDescription("Weighted");
        financialRiskFactorDTO.setScoreTypeCode("01");
        financialRiskFactorDTO.setScoreTypeDescription("Normal");
        financialRiskFactorDTO.setScore(0D);


        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1 - Risk SubFactor 1
        // 1.1.1                      Financial Risk -> Financial Risk Factor - > Return on Assets

        ///                                     20%
        RiskSubFactorDTO returnOnAssetRiskSubFactorDTO = new RiskSubFactorDTO();
        returnOnAssetRiskSubFactorDTO.setId(null);
        returnOnAssetRiskSubFactorDTO.setItemNo(1);
        returnOnAssetRiskSubFactorDTO.setDescription("Return on Asset");
        returnOnAssetRiskSubFactorDTO.setWeightage(0.20D);
        returnOnAssetRiskSubFactorDTO.setScore(0D);
        returnOnAssetRiskSubFactorDTO.setScoreTypeCode("01");
        returnOnAssetRiskSubFactorDTO.setScoreTypeDescription("Normal");

        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Financial Risk -> Financial Risk Factor - > Return on Assets -> Attributes
        // 1.1.1 -> Four Attributes

        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("More than and equal to 5%");
        riskSubFactorAttributeDTO1.setScore(10D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Equal or more than 4% but less than 5%");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Equal or more than 3% but less than 4%");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO4 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("Equal or more than 2% but less than 3%");
        riskSubFactorAttributeDTO4.setScore(2.50D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO5 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO5.setId(null);
        riskSubFactorAttributeDTO5.setItemNo(5);
        riskSubFactorAttributeDTO5.setDescription("Less than 2%");
        riskSubFactorAttributeDTO5.setScore(0.00D);
        riskSubFactorAttributeDTO5.setWeightage(00D);riskSubFactorAttributeDTO5.setIsSelected(false);




        // Collect Risk Sub Factor Attributes
        returnOnAssetRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        returnOnAssetRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        returnOnAssetRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        returnOnAssetRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        returnOnAssetRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);


        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 2
        // 1.1.2                      Financial Risk -> Financial Risk Factor - > Gross Stage 3 by Gross Loan Book
        ///                                     15%
        RiskSubFactorDTO grossStage3ByGrossLoanBookRiskSubFactorDTO = new RiskSubFactorDTO();
        grossStage3ByGrossLoanBookRiskSubFactorDTO.setId(null);
        grossStage3ByGrossLoanBookRiskSubFactorDTO.setItemNo(2);
        grossStage3ByGrossLoanBookRiskSubFactorDTO.setDescription("Gross Stage 3 by Gross Loan Book");
        grossStage3ByGrossLoanBookRiskSubFactorDTO.setWeightage(0.15D);
        grossStage3ByGrossLoanBookRiskSubFactorDTO.setScore(0D);
        grossStage3ByGrossLoanBookRiskSubFactorDTO.setScoreTypeCode("01");
        grossStage3ByGrossLoanBookRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Financial Risk -> Financial Risk Factor - > Gross Stage 3 by Gross Loan Book -> Attributes
        // 1.1.2 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Less than 2.5%");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Equal or more than 2.5% but less than 3%");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Equal or more 3% but less than 3.5%");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);


        riskSubFactorAttributeDTO4 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("Equal or more than 3.5% but less than 4%");
        riskSubFactorAttributeDTO4.setScore(2.50D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);

        riskSubFactorAttributeDTO5 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO5.setId(null);
        riskSubFactorAttributeDTO5.setItemNo(5);
        riskSubFactorAttributeDTO5.setDescription("Equal or more than 4%");
        riskSubFactorAttributeDTO5.setScore(0.00D);
        riskSubFactorAttributeDTO5.setWeightage(00D);riskSubFactorAttributeDTO5.setIsSelected(false);


        // Collect Risk Sub Factor Attributes
        grossStage3ByGrossLoanBookRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        grossStage3ByGrossLoanBookRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        grossStage3ByGrossLoanBookRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        grossStage3ByGrossLoanBookRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        grossStage3ByGrossLoanBookRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);



        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 3
        // 1.1.3                     Financial Risk -> Financial Risk Factor - >  Adjusted Tier 1 Capital Adequacy Ratio
        ///                                     25%
        RiskSubFactorDTO adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO = new RiskSubFactorDTO();
        adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO.setId(null);
        adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO.setItemNo(3);
        adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO.setDescription(" Adjusted Tier 1 Capital Adequacy Ratio");
        adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO.setWeightage(0.25D);
        adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO.setScore(0D);
        adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO.setScoreTypeCode("01");
        adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Financial Risk -> Financial Risk Factor - > Adjusted Tier 1 Capital Adequacy Ratio------> Attributes
        // 1.1.3 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Equal or more than 11%");
        riskSubFactorAttributeDTO1.setScore(10D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Equal or more than 10% but less than 11%");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Equal or more than 9% but less than 10%");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);


        riskSubFactorAttributeDTO4 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("Equal or more than 8% but less than 9%");
        riskSubFactorAttributeDTO4.setScore(2.50D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);


        riskSubFactorAttributeDTO5 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO5.setId(null);
        riskSubFactorAttributeDTO5.setItemNo(5);
        riskSubFactorAttributeDTO5.setDescription("Less than 8%");
        riskSubFactorAttributeDTO5.setScore(0.00D);
        riskSubFactorAttributeDTO5.setWeightage(00D);riskSubFactorAttributeDTO5.setIsSelected(false);

        // Collect Risk Sub Factor Attributes
        adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);


        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 4
        // 1.1.4                    Financial Risk -> Financial Risk Factor - >  Leverage
        ///                                     15%
        RiskSubFactorDTO leverageRiskSubFactorDTO = new RiskSubFactorDTO();
        leverageRiskSubFactorDTO.setId(null);
        leverageRiskSubFactorDTO.setItemNo(4);
        leverageRiskSubFactorDTO.setDescription("Leverage");
        leverageRiskSubFactorDTO.setWeightage(0.15D);
        leverageRiskSubFactorDTO.setScore(0D);
        leverageRiskSubFactorDTO.setScoreTypeCode("01");
        leverageRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Financial Risk -> Financial Risk Factor - >  Leverage ------> Attributes
        // 1.1.4 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Less than 2.5%");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);

        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Equal to 2.5% but less than 3.5%");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Equal or more 3.5% but less than 4.5%");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);

        riskSubFactorAttributeDTO4 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("Equal or more than 4.5% but less than 6%");
        riskSubFactorAttributeDTO4.setScore(2.50D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);


        riskSubFactorAttributeDTO5 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO5.setId(null);
        riskSubFactorAttributeDTO5.setItemNo(5);
        riskSubFactorAttributeDTO5.setDescription("Equal or more than 6%");
        riskSubFactorAttributeDTO5.setScore(0.00D);
        riskSubFactorAttributeDTO5.setWeightage(00D);riskSubFactorAttributeDTO5.setIsSelected(false);


        // Collect Risk Sub Factor Attributes
        leverageRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        leverageRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        leverageRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        leverageRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        leverageRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);



        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 4
        // 1.1.5                    Financial Risk -> Financial Risk Factor - >  Asset Liability Maturity profile
        ///                                     15%
        RiskSubFactorDTO assetLiabilityMaturityProfileRiskRiskSubFactorDTO = new RiskSubFactorDTO();
        assetLiabilityMaturityProfileRiskRiskSubFactorDTO.setId(null);
        assetLiabilityMaturityProfileRiskRiskSubFactorDTO.setItemNo(5);
        assetLiabilityMaturityProfileRiskRiskSubFactorDTO.setDescription("Asset Liability Maturity profile ");
        assetLiabilityMaturityProfileRiskRiskSubFactorDTO.setWeightage(0.15D);
        assetLiabilityMaturityProfileRiskRiskSubFactorDTO.setScore(0D);
        assetLiabilityMaturityProfileRiskRiskSubFactorDTO.setScoreTypeCode("01");
        assetLiabilityMaturityProfileRiskRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Financial Risk -> Financial Risk Factor - > Asset Liability Maturity profile  ------> Attributes
        // 1.1.5 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Equal or more 1.25%");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);

        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Equal or more than 1.20% but less than 1.25%");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);

        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Equal or more than 1.10% but less than 1.20%");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);

        riskSubFactorAttributeDTO4 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("Equal or more than 1.00% but less than 1.10%");
        riskSubFactorAttributeDTO4.setScore(2.50D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);


        riskSubFactorAttributeDTO5 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO5.setId(null);
        riskSubFactorAttributeDTO5.setItemNo(5);
        riskSubFactorAttributeDTO5.setDescription("Less than 1.00%");
        riskSubFactorAttributeDTO5.setScore(0.00D);
        riskSubFactorAttributeDTO5.setWeightage(00D);riskSubFactorAttributeDTO5.setIsSelected(false);



        // Collect Risk Sub Factor Attributes
        assetLiabilityMaturityProfileRiskRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        assetLiabilityMaturityProfileRiskRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        assetLiabilityMaturityProfileRiskRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        assetLiabilityMaturityProfileRiskRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        assetLiabilityMaturityProfileRiskRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);



        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 6
        // 1.1.7                    Financial Risk -> Financial Risk Factor - > Access to diversified sources of borrowings
        ///

        RiskSubFactorDTO accessToDivSourcesOfBorrowSubFactorDTO = new RiskSubFactorDTO();
        accessToDivSourcesOfBorrowSubFactorDTO.setId(null);
        accessToDivSourcesOfBorrowSubFactorDTO.setItemNo(7);
        accessToDivSourcesOfBorrowSubFactorDTO.setDescription(" Access to diversified sources of borrowings  ");
        accessToDivSourcesOfBorrowSubFactorDTO.setWeightage(0.10D);
        accessToDivSourcesOfBorrowSubFactorDTO.setScore(0D);
        accessToDivSourcesOfBorrowSubFactorDTO.setScoreTypeCode("01");
        accessToDivSourcesOfBorrowSubFactorDTO.setScoreTypeDescription("Normal");




        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Financial Risk -> Financial Risk Factor - > Access to diversified sources of borrowings  -> Attributes
        // 1.1.7 -> Five Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Top 3 lenders constitute less than 40% of borrowings");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);

        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Top 3 lenders constitute equal or more than 40% but less than 60% of borrowings");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);

        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Top 3 lenders constitute equal or more than 60% but less than 75% of borrowings");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);


        riskSubFactorAttributeDTO4= new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("Top 3 lenders constitute equal or more than 75% but less than 85% of borrowings");
        riskSubFactorAttributeDTO4.setScore(2.50D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);

        riskSubFactorAttributeDTO5 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO5.setId(null);
        riskSubFactorAttributeDTO5.setItemNo(5);
        riskSubFactorAttributeDTO5.setDescription("Top 3 lenders constitute equal or more than 85% of borrowings");
        riskSubFactorAttributeDTO5.setScore(0.00D);
        riskSubFactorAttributeDTO5.setWeightage(00D);riskSubFactorAttributeDTO5.setIsSelected(false);


        // Collect Risk Sub Factor Attributes
        accessToDivSourcesOfBorrowSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        accessToDivSourcesOfBorrowSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        accessToDivSourcesOfBorrowSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        accessToDivSourcesOfBorrowSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        accessToDivSourcesOfBorrowSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);


        //Collect RiskFactor
        financialRiskFactorDTO.addRiskSubFactorDTO(returnOnAssetRiskSubFactorDTO);
        financialRiskFactorDTO.addRiskSubFactorDTO(grossStage3ByGrossLoanBookRiskSubFactorDTO);
        financialRiskFactorDTO.addRiskSubFactorDTO(adjustedTier1CapitalAdequacyRatioRiskSubFactorDTO);
        financialRiskFactorDTO.addRiskSubFactorDTO(leverageRiskSubFactorDTO);
        financialRiskFactorDTO.addRiskSubFactorDTO(assetLiabilityMaturityProfileRiskRiskSubFactorDTO);
        financialRiskFactorDTO.addRiskSubFactorDTO(accessToDivSourcesOfBorrowSubFactorDTO);

        //Collect Risk Factors
        financialRiskComponentDTO.addRiskFactorDTO(financialRiskFactorDTO);
        return  financialRiskComponentDTO;

    }
}

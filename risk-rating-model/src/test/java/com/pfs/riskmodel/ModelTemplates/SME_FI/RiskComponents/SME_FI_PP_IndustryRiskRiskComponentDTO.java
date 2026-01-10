package com.pfs.riskmodel.ModelTemplates.SME_FI.RiskComponents;

import com.pfs.riskmodel.dto.RiskComponentDTO;
import com.pfs.riskmodel.dto.RiskFactorDTO;
import com.pfs.riskmodel.dto.RiskSubFactorAttributeDTO;
import com.pfs.riskmodel.dto.RiskSubFactorDTO;

/**
 * Created by sajeev on 19-Dec-18.
 */
public  class SME_FI_PP_IndustryRiskRiskComponentDTO {

    public static RiskComponentDTO getIndustryRiskComponentDTO () {

     //   RiskComponentDTO riskComponentDTO = new RiskComponentDTO();
        /**********************************************************************************************************************
         *  Risk Component 1 :Industry Risk -35%
         *  This has only two levels below and therefore the Risk Factor will be a dummy entry (Industry Risk Factor) with same name
         **********************************************************************************************************************/

        //                       Risk Type 1 - Risk Component 1
        //  1                      Industry Risk
        RiskComponentDTO industryRiskComponentDTO = new RiskComponentDTO();
        industryRiskComponentDTO.setId(null);
        industryRiskComponentDTO.setItemNo(4);
        industryRiskComponentDTO.setDescription("Industry Risk");
        industryRiskComponentDTO.setWeightage(0.05D);
        industryRiskComponentDTO.setComputingMethodCode("05");
        industryRiskComponentDTO.setComputingMethodDescription("Equals");
        industryRiskComponentDTO.setScoreTypeCode("01");
        industryRiskComponentDTO.setScoreTypeDescription("Normal");
        industryRiskComponentDTO.setScore(0D);

        industryRiskComponentDTO.setIsApplicable(true);


        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1
        //1.1                           Industry Risk ->Industry Risk Factor (DUMMY ENTRY)
        // *  Value Derived from the Risk Sub Factor is just passed on - Therefore Computing Method = EQUALS
        //                                       100%

        RiskFactorDTO industryRiskFactorDTO = new RiskFactorDTO();
        industryRiskFactorDTO.setId(null);
        industryRiskFactorDTO.setItemNo(1);
        industryRiskFactorDTO.setDescription("Industry Risk Factor");
        industryRiskFactorDTO.setWeightage(1.00);
        industryRiskFactorDTO.setComputingMethodCode("01");
        industryRiskFactorDTO.setComputingMethodDescription("Weighted");
        industryRiskFactorDTO.setScoreTypeCode("01");
        industryRiskFactorDTO.setScoreTypeDescription("Normal");
        industryRiskFactorDTO.setScore(0D);


        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1 - Risk SubFactor 1
        // 1.1.1                     Industry Risk ->Industry Risk Factor - > Mix of Loan Product Offerings              

        ///                                     40%
        RiskSubFactorDTO mixOfProductOfferingsRiskSubFactorDTO = new RiskSubFactorDTO();
        mixOfProductOfferingsRiskSubFactorDTO.setId(null);
        mixOfProductOfferingsRiskSubFactorDTO.setItemNo(1);
        mixOfProductOfferingsRiskSubFactorDTO.setDescription("Mix of Loan Product Offerings");
        mixOfProductOfferingsRiskSubFactorDTO.setWeightage(0.40D);
        mixOfProductOfferingsRiskSubFactorDTO.setScore(0D);
        mixOfProductOfferingsRiskSubFactorDTO.setScoreTypeCode("01");
        mixOfProductOfferingsRiskSubFactorDTO.setScoreTypeDescription("Normal");

        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                      Industry Risk ->Industry Risk Factor - > Mix of Loan Product Offerings               -> Attributes
        // 1.1.1 -> Four Attributes

        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Have varied product offerings across wholesale & retail segments for its customer base");
        riskSubFactorAttributeDTO1.setScore(10D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setScore(5.00D);
        riskSubFactorAttributeDTO2.setDescription("Have varied product offerings in either wholesale or retail segments for its customer base");
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Intense competition from peer players in the identified business segments offering similar products at competitive pricing");
        riskSubFactorAttributeDTO3.setScore(0.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);



        // Collect Risk Sub Factor Attributes
        mixOfProductOfferingsRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        mixOfProductOfferingsRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        mixOfProductOfferingsRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);



        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 2
        // 1.1.2                     Industry Risk ->Industry Risk Factor - > Extent of Competition from NBFCs/HFC/Banks & Financial Institution 
        ///                                     35%
        RiskSubFactorDTO extentOfCompetetionRiskSubFactorDTO = new RiskSubFactorDTO();
        extentOfCompetetionRiskSubFactorDTO.setId(null);
        extentOfCompetetionRiskSubFactorDTO.setItemNo(2);
        extentOfCompetetionRiskSubFactorDTO.setDescription("Extent of Competition from NBFCs/HFC/Banks & Financial Institution ");
        extentOfCompetetionRiskSubFactorDTO.setWeightage(0.40D);
        extentOfCompetetionRiskSubFactorDTO.setScore(0D);
        extentOfCompetetionRiskSubFactorDTO.setScoreTypeCode("01");
        extentOfCompetetionRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                      Industry Risk ->Industry Risk Factor - > Extent of Competition from NBFCs/HFC/Banks & Financial Institution  -> Attributes
        // 1.1.2 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Few peer Players (i.e 1 to 5) in the identified business segments.\n Peer players command dominance in pricing of product offering.");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Competition is not intense in the identified business segments where \n peer players are offering similar products however at differential pricing");
        riskSubFactorAttributeDTO2.setScore(5.00D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Intense competition from peer players \nin the identified business segments offering similar products at competitive pricing");
        riskSubFactorAttributeDTO3.setScore(0.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);


        // Collect Risk Sub Factor Attributes
        extentOfCompetetionRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        extentOfCompetetionRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        extentOfCompetetionRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
 


        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 3
        // 1.1.3                    Industry Risk ->Industry Risk Factor - >  Exposure to Cyclical Industries           
        ///                                     25%
        RiskSubFactorDTO exposureToCyclicalIndustriesRiskSubFactorDTO = new RiskSubFactorDTO();
        exposureToCyclicalIndustriesRiskSubFactorDTO.setId(null);
        exposureToCyclicalIndustriesRiskSubFactorDTO.setItemNo(3);
        exposureToCyclicalIndustriesRiskSubFactorDTO.setDescription(" Exposure to Cyclical Industries");
        exposureToCyclicalIndustriesRiskSubFactorDTO.setWeightage(0.30D);
        exposureToCyclicalIndustriesRiskSubFactorDTO.setScore(0D);
        exposureToCyclicalIndustriesRiskSubFactorDTO.setScoreTypeCode("01");
        exposureToCyclicalIndustriesRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                      Industry Risk ->Industry Risk Factor - > Exposure to Cyclical Industries           ------> Attributes
        // 1.1.3 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Operating in business segments of those industries which are not impacted to cyclical trends of economic environment");
        riskSubFactorAttributeDTO1.setScore(10D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Operating in business segments of those industries which are neutral to cyclical trends of economic environment");
        riskSubFactorAttributeDTO2.setScore(5.00D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Operating in business segments of those industries which are completely exposed to cyclical trends of economic environment");
        riskSubFactorAttributeDTO3.setScore(0.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);


        // Collect Risk Sub Factor Attributes
        exposureToCyclicalIndustriesRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        exposureToCyclicalIndustriesRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        exposureToCyclicalIndustriesRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);


        //Collect RiskFactor
        industryRiskFactorDTO.addRiskSubFactorDTO(mixOfProductOfferingsRiskSubFactorDTO);
        industryRiskFactorDTO.addRiskSubFactorDTO(extentOfCompetetionRiskSubFactorDTO);
        industryRiskFactorDTO.addRiskSubFactorDTO(exposureToCyclicalIndustriesRiskSubFactorDTO);

        //Collect Risk Factors
        industryRiskComponentDTO.addRiskFactorDTO(industryRiskFactorDTO);
        return  industryRiskComponentDTO;

    }
}

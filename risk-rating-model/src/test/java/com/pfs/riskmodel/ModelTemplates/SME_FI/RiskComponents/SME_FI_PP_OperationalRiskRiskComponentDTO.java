package com.pfs.riskmodel.ModelTemplates.SME_FI.RiskComponents;

import com.pfs.riskmodel.dto.RiskComponentDTO;
import com.pfs.riskmodel.dto.RiskFactorDTO;
import com.pfs.riskmodel.dto.RiskSubFactorAttributeDTO;
import com.pfs.riskmodel.dto.RiskSubFactorDTO;

/**
 * Created by sajeev on 19-Dec-18.
 */
public  class SME_FI_PP_OperationalRiskRiskComponentDTO {

    public static RiskComponentDTO getOperationalRiskComponentDTO () {

     //   RiskComponentDTO riskComponentDTO = new RiskComponentDTO();
        /**********************************************************************************************************************
         *  Risk Component 1 : Operational Risk - 20%
         *  This has only two levels below and therefore the Risk Factor will be a dummy entry (Operational Risk Factor) with same name
         **********************************************************************************************************************/

        //                       Risk Type 1 - Risk Component 1
        //  1                       Operational Risk
        RiskComponentDTO operationalRiskComponentDTO = new RiskComponentDTO();
        operationalRiskComponentDTO.setId(null);
        operationalRiskComponentDTO.setItemNo(4);
        operationalRiskComponentDTO.setDescription("Operational Risk");
        operationalRiskComponentDTO.setWeightage(0.20D);
        operationalRiskComponentDTO.setComputingMethodCode("05");
        operationalRiskComponentDTO.setComputingMethodDescription("Equals");
        operationalRiskComponentDTO.setScoreTypeCode("01");
        operationalRiskComponentDTO.setScoreTypeDescription("Normal");
        operationalRiskComponentDTO.setScore(0D);

        operationalRiskComponentDTO.setIsApplicable(true);


        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1
        //1.1                            Operational Risk -> Operational Risk Factor (DUMMY ENTRY)
        // *  Value Derived from the Risk Sub Factor is just passed on - Therefore Computing Method = EQUALS
        //                                       100%

        RiskFactorDTO financialRiskFactorDTO = new RiskFactorDTO();
        financialRiskFactorDTO.setId(null);
        financialRiskFactorDTO.setItemNo(1);
        financialRiskFactorDTO.setDescription("Operational Risk Factor");
        financialRiskFactorDTO.setWeightage(1.00);
        financialRiskFactorDTO.setComputingMethodCode("01");
        financialRiskFactorDTO.setComputingMethodDescription("Weighted");
        financialRiskFactorDTO.setScoreTypeCode("01");
        financialRiskFactorDTO.setScoreTypeDescription("Normal");
        financialRiskFactorDTO.setScore(0D);


        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1 - Risk SubFactor 1
        // 1.1.1                      Operational Risk -> Operational Risk Factor - > Collection Efficiency Ratio

        ///                                     20%
        RiskSubFactorDTO collectionEfficiencyRatioRiskSubFactorDTO = new RiskSubFactorDTO();
        collectionEfficiencyRatioRiskSubFactorDTO.setId(null);
        collectionEfficiencyRatioRiskSubFactorDTO.setItemNo(1);
        collectionEfficiencyRatioRiskSubFactorDTO.setDescription("Collection Efficiency Ratio");
        collectionEfficiencyRatioRiskSubFactorDTO.setWeightage(0.30D);
        collectionEfficiencyRatioRiskSubFactorDTO.setScore(0D);
        collectionEfficiencyRatioRiskSubFactorDTO.setScoreTypeCode("01");
        collectionEfficiencyRatioRiskSubFactorDTO.setScoreTypeDescription("Normal");

        //                       Risk Type 1 - Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Operational Risk -> Operational Risk Factor - > Collection Efficiency Ratio -> Attributes
        // 1.1.1 -> Four Attributes

        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Equal to or more than 95%");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Equal or more than 90% but less than 95%");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Equal or more than 88% but less than 90%");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO4 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("Equal or more than 85% but less than 88%");
        riskSubFactorAttributeDTO4.setScore(2.50D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);


        RiskSubFactorAttributeDTO riskSubFactorAttributeDTO5 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO5.setId(null);
        riskSubFactorAttributeDTO5.setItemNo(5);
        riskSubFactorAttributeDTO5.setDescription("Less than 85%");
        riskSubFactorAttributeDTO5.setScore(0.00D);
        riskSubFactorAttributeDTO5.setWeightage(00D);riskSubFactorAttributeDTO5.setIsSelected(false);




        // Collect Risk Sub Factor Attributes
        collectionEfficiencyRatioRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        collectionEfficiencyRatioRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        collectionEfficiencyRatioRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        collectionEfficiencyRatioRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        collectionEfficiencyRatioRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);


        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 2
        // 1.1.2                      Operational Risk -> Operational Risk Factor - > Compliance with regulatory & Statutory regulations
        ///                                     15%
        RiskSubFactorDTO complianceWithRegulationsRiskSubFactorDTO = new RiskSubFactorDTO();
        complianceWithRegulationsRiskSubFactorDTO.setId(null);
        complianceWithRegulationsRiskSubFactorDTO.setItemNo(2);
        complianceWithRegulationsRiskSubFactorDTO.setDescription("Compliance with regulatory & Statutory regulations");
        complianceWithRegulationsRiskSubFactorDTO.setWeightage(0.15D);
        complianceWithRegulationsRiskSubFactorDTO.setScore(0D);
        complianceWithRegulationsRiskSubFactorDTO.setScoreTypeCode("01");
        complianceWithRegulationsRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Operational Risk -> Operational Risk Factor - > Compliance with regulatory & Statutory regulations -> Attributes
        // 1.1.2 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("No adverse observation by regulators (i.e RBI/SEBI/NSE/BSE) \n with respect to compliance of regulatory and statutory regulations");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Observation by regulators (i.e RBI/SEBI/NSE/BSE) \n which do not adversely affect the business operations of the company");
        riskSubFactorAttributeDTO2.setScore(5.00D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Levy of penalties by regulators during last 2 years");
        riskSubFactorAttributeDTO3.setScore(0.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);




        // Collect Risk Sub Factor Attributes
        complianceWithRegulationsRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        complianceWithRegulationsRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        complianceWithRegulationsRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);




        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 3
        // 1.1.3                     Operational Risk -> Operational Risk Factor - >  Existence of Organizational governance structure & Employee engagement policies  
        ///                                     15%
        RiskSubFactorDTO existenceOfOrganizationalGovernanceRiskSubFactorDTO = new RiskSubFactorDTO();
        existenceOfOrganizationalGovernanceRiskSubFactorDTO.setId(null);
        existenceOfOrganizationalGovernanceRiskSubFactorDTO.setItemNo(3);
        existenceOfOrganizationalGovernanceRiskSubFactorDTO.setDescription("Existence of Organizational governance structure & Employee engagement policies");
        existenceOfOrganizationalGovernanceRiskSubFactorDTO.setWeightage(0.15D);
        existenceOfOrganizationalGovernanceRiskSubFactorDTO.setScore(0D);
        existenceOfOrganizationalGovernanceRiskSubFactorDTO.setScoreTypeCode("01");
        existenceOfOrganizationalGovernanceRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Operational Risk -> Operational Risk Factor - > Existence of Organizational governance structure & Employee engagement policies  ------> Attributes
        // 1.1.3 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Organizational governance structure with clearly defined roles \n and responsibilities of all departments including Compensation Policy \n for all employees. Accounting policies are consistent with newly issued Ind AS guidelines, as amended from time to time, and is aligned with general industry practice." );
        riskSubFactorAttributeDTO1.setScore(10D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);


        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Organizational governance structure is not in line with the governance guidelines \n of applicable regulators/Roles and Responsibilities of selected departments are defined/Compensation Policy are designed only for KMPs and SMPs. \nAccounting policies requires change to align the accounting policy with general industry practice. ");
        riskSubFactorAttributeDTO2.setScore(5.00D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Organizational governance structure along with roles \n and responsibilities of departments are not defined/Non-existence of compensation policy.  \nAccounting policies not in line with the general industry practice. ");
        riskSubFactorAttributeDTO3.setScore(0.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);

        // Collect Risk Sub Factor Attributes
        existenceOfOrganizationalGovernanceRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        existenceOfOrganizationalGovernanceRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        existenceOfOrganizationalGovernanceRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
 


        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 4
        // 1.1.4                    Operational Risk -> Operational Risk Factor - >  Publishing of audited financial statements within timelines with applicable disclosure standards    
        ///                                     12.50%
        RiskSubFactorDTO publishingOfAuditedFinStmtRiskSubFactorDTO = new RiskSubFactorDTO();
        publishingOfAuditedFinStmtRiskSubFactorDTO.setId(null);
        publishingOfAuditedFinStmtRiskSubFactorDTO.setItemNo(4);
        publishingOfAuditedFinStmtRiskSubFactorDTO.setDescription("Publishing of audited financial statements within timelines with applicable disclosure standards    ");
        publishingOfAuditedFinStmtRiskSubFactorDTO.setWeightage(0.125D);
        publishingOfAuditedFinStmtRiskSubFactorDTO.setScore(0D);
        publishingOfAuditedFinStmtRiskSubFactorDTO.setScoreTypeCode("01");
        publishingOfAuditedFinStmtRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Operational Risk -> Operational Risk Factor - >  Publishing of audited financial statements within timelines with applicable disclosure standards     ------> Attributes
        // 1.1.4 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Annual financial statements/quarterly financial statements are audited and published within 60 days from the end of the preceding quarter.");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);

        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Annual financial statements/quarterly financial statements are audited and published within 90 days from the end of the preceding quarter.");
        riskSubFactorAttributeDTO2.setScore(5.00D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);


        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Annual financial statements/quarterly financial statements are audited and published after 90 days from the end of the preceding quarter.");
        riskSubFactorAttributeDTO3.setScore(0.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);

        // Collect Risk Sub Factor Attributes
        publishingOfAuditedFinStmtRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        publishingOfAuditedFinStmtRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        publishingOfAuditedFinStmtRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);



        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 4
        // 1.1.5                    Operational Risk -> Operational Risk Factor - >   Institutionalization of Management Information Systems and existence of Credit Risk Management Systems and Policies     
        ///                                     12.5%
        RiskSubFactorDTO institutionalizationRiskSubFactorDTO = new RiskSubFactorDTO();
        institutionalizationRiskSubFactorDTO.setId(null);
        institutionalizationRiskSubFactorDTO.setItemNo(5);
        institutionalizationRiskSubFactorDTO.setDescription(" Institutionalization of Management Information Systems and existence of Credit Risk Management Systems and Policies      ");
        institutionalizationRiskSubFactorDTO.setWeightage(0.125D);
        institutionalizationRiskSubFactorDTO.setScore(0D);
        institutionalizationRiskSubFactorDTO.setScoreTypeCode("01");
        institutionalizationRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //                       Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //                       Operational Risk -> Operational Risk Factor - >  Institutionalization of Management Information Systems and existence of Credit Risk Management Systems and Policies       ------> Attributes
        // 1.1.5 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Key financial and operational performance indicators are identified \n and computed through Information technology systems which are \n commensurate to the size and complexity of business operations. \nExistence of board approved framework for credit assessment, collection processes, security & collateral management, \n and risk management along with defined timelines of periodic reviews");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);

        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Key financial and operational performance indicators are identified\n and computed through Information technology systems which are not commensurate to the size and complexity of business operations/manually computed. \nNon-existence of framework for credit assessment, collection processes, security & collateral management, \n and risk management, with no defined timelines of review");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);

        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription(" Key financial and operational performance indicators are not identified. \nNon-existence of framework for credit assessment, collection processes, security & collateral management, \n and risk management, with no defined timelines of review");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);




        // Collect Risk Sub Factor Attributes
        institutionalizationRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        institutionalizationRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        institutionalizationRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
 



        //                           Risk Component 1 - Risk Factor 1 - Risk SubFactor 4
        // 1.1.6                    Operational Risk -> Operational Risk Factor - >  Vintage
        ///                                     15%
        RiskSubFactorDTO vintageRiskSubFactorDTO = new RiskSubFactorDTO();
        vintageRiskSubFactorDTO.setId(null);
        vintageRiskSubFactorDTO.setItemNo(6);
        vintageRiskSubFactorDTO.setDescription("Vintage");
        vintageRiskSubFactorDTO.setWeightage(0.15D);
        vintageRiskSubFactorDTO.setScore(0D);
        vintageRiskSubFactorDTO.setScoreTypeCode("01");
        vintageRiskSubFactorDTO.setScoreTypeDescription("Normal");


        //      Risk Component 1 - Risk Factor 1 - Risk SubFactor 1 ->Risk Sub Factor Attributes
        //      Operational Risk -> Operational Risk Factor ->  Vintage  -> Attributes
        // 1.1.6 -> Six Attributes

        riskSubFactorAttributeDTO1 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO1.setId(null);
        riskSubFactorAttributeDTO1.setItemNo(1);
        riskSubFactorAttributeDTO1.setDescription("Equal or Greater than 9 years of Operations");
        riskSubFactorAttributeDTO1.setScore(10.00D);
        riskSubFactorAttributeDTO1.setWeightage(00D);riskSubFactorAttributeDTO1.setIsSelected(false);

        riskSubFactorAttributeDTO2 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO2.setId(null);
        riskSubFactorAttributeDTO2.setItemNo(2);
        riskSubFactorAttributeDTO2.setDescription("Equal or Greater than 7 years but less than 9 years of Operations");
        riskSubFactorAttributeDTO2.setScore(7.50D);
        riskSubFactorAttributeDTO2.setWeightage(00D);riskSubFactorAttributeDTO2.setIsSelected(false);

        riskSubFactorAttributeDTO3 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO3.setId(null);
        riskSubFactorAttributeDTO3.setItemNo(3);
        riskSubFactorAttributeDTO3.setDescription("Equal or Greater than 5 years but less than 7 years of Operations");
        riskSubFactorAttributeDTO3.setScore(5.00D);
        riskSubFactorAttributeDTO3.setWeightage(00D);riskSubFactorAttributeDTO3.setIsSelected(false);

        riskSubFactorAttributeDTO4 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO4.setId(null);
        riskSubFactorAttributeDTO4.setItemNo(4);
        riskSubFactorAttributeDTO4.setDescription("Equal or Greater than 3 years but less than 5 years of Operations");
        riskSubFactorAttributeDTO4.setScore(2.50D);
        riskSubFactorAttributeDTO4.setWeightage(00D);riskSubFactorAttributeDTO4.setIsSelected(false);


        riskSubFactorAttributeDTO5 = new RiskSubFactorAttributeDTO();
        riskSubFactorAttributeDTO5.setId(null);
        riskSubFactorAttributeDTO5.setItemNo(5);
        riskSubFactorAttributeDTO5.setDescription("Less than 3 years of Operations");
        riskSubFactorAttributeDTO5.setScore(0.00D);
        riskSubFactorAttributeDTO5.setWeightage(00D);riskSubFactorAttributeDTO5.setIsSelected(false);

        // Collect Risk Sub Factor Attributes
        vintageRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO1);
        vintageRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO2);
        vintageRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO3);
        vintageRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO4);
        vintageRiskSubFactorDTO.addRiskSubFactorAttribute(riskSubFactorAttributeDTO5);




        //Collect RiskFactor
        financialRiskFactorDTO.addRiskSubFactorDTO(collectionEfficiencyRatioRiskSubFactorDTO);
        financialRiskFactorDTO.addRiskSubFactorDTO(complianceWithRegulationsRiskSubFactorDTO);
        financialRiskFactorDTO.addRiskSubFactorDTO(existenceOfOrganizationalGovernanceRiskSubFactorDTO);
        financialRiskFactorDTO.addRiskSubFactorDTO(publishingOfAuditedFinStmtRiskSubFactorDTO);
        financialRiskFactorDTO.addRiskSubFactorDTO(institutionalizationRiskSubFactorDTO);
        financialRiskFactorDTO.addRiskSubFactorDTO(vintageRiskSubFactorDTO);

        //Collect Risk Factors
        operationalRiskComponentDTO.addRiskFactorDTO(financialRiskFactorDTO);
        return  operationalRiskComponentDTO;

    }
}

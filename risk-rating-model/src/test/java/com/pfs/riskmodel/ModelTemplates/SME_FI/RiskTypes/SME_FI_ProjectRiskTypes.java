package com.pfs.riskmodel.ModelTemplates.SME_FI.RiskTypes;

import com.pfs.riskmodel.ModelTemplates.Renewable.RiskComponents.ROP_BP_AccountConductRiskDTO;
import com.pfs.riskmodel.ModelTemplates.Renewable.RiskComponents.RP_CompletionRiskComponentDTO;
import com.pfs.riskmodel.ModelTemplates.Renewable.RiskComponents.RP_ExecutionRiskDTO;
import com.pfs.riskmodel.ModelTemplates.SME_FI.RiskComponents.*;
import com.pfs.riskmodel.dto.RiskComponentDTO;
import com.pfs.riskmodel.dto.RiskTypeDTO;

/**
 * Created by sajeev on 20-Dec-18.
 */
public class SME_FI_ProjectRiskTypes {
    public static RiskTypeDTO riskTypeDTO ;

    public static RiskTypeDTO buildRiskTypes () {

        //---------------------------------------------------------------------------------//
        // ---------------------------RiskType 1 -----------------------------------------//
        //                      Project Implementation Risk

        riskTypeDTO = new RiskTypeDTO();
        riskTypeDTO.setId(null);
        riskTypeDTO.setItemNo(1);
        riskTypeDTO.setDescription("Project Implementation Risk");
        riskTypeDTO.setScore(0D);
        riskTypeDTO.setGrade(" ");
        riskTypeDTO.setIsAccountConductRiskComponentPresent(true);



        //  Risk Component 1 : Financial Risk -35%
        SME_FI_PP_FinancialRiskRiskComponentDTO sme_fi_pp_financialRiskRiskComponentDTO = new SME_FI_PP_FinancialRiskRiskComponentDTO();
        RiskComponentDTO financialRiskComponentDTO = sme_fi_pp_financialRiskRiskComponentDTO.getFinancialRiskComponentDTO();
        financialRiskComponentDTO.setWeightage(0.35);

        //  Risk Component 2 : Business Risk - 30%
        SME_FI_PP_BusinessRiskRiskComponentDTO sme_fi_pp_businessRiskRiskComponentDTO = new SME_FI_PP_BusinessRiskRiskComponentDTO();
        RiskComponentDTO businessRiskComponentDTO = sme_fi_pp_businessRiskRiskComponentDTO.getBusinessRiskComponentDTO();
        businessRiskComponentDTO.setWeightage(0.30);

        //  Risk Component 3 : Operational Risk - 20%
        SME_FI_PP_OperationalRiskRiskComponentDTO sme_fi_pp_operationalRiskRiskComponentDTO = new SME_FI_PP_OperationalRiskRiskComponentDTO();
        RiskComponentDTO operationalRiskDTO = sme_fi_pp_operationalRiskRiskComponentDTO.getOperationalRiskComponentDTO();
        operationalRiskDTO.setWeightage(0.20);

        //  Risk Component 4 : Management Risk - 10%
        SME_FI_PP_ManagementRiskRiskComponentDTO sme_fi_pp_managementRiskRiskComponentDTO = new SME_FI_PP_ManagementRiskRiskComponentDTO();
        RiskComponentDTO managementRiskDTO = sme_fi_pp_managementRiskRiskComponentDTO.getManagementRiskComponentDTO();
        managementRiskDTO.setWeightage(0.10);

        //  Risk Component 5 : Industry Risk - 5%
        SME_FI_PP_IndustryRiskRiskComponentDTO sme_fi_pp_industryRiskRiskComponentDTO = new SME_FI_PP_IndustryRiskRiskComponentDTO
                ();
        RiskComponentDTO industryRiskDTO = sme_fi_pp_industryRiskRiskComponentDTO.getIndustryRiskComponentDTO();
        industryRiskDTO.setIsApplicable(true);
        industryRiskDTO.setWeightage(0.05);

        riskTypeDTO.addRiskComponentDTO(financialRiskComponentDTO);
        riskTypeDTO.addRiskComponentDTO(businessRiskComponentDTO);
        riskTypeDTO.addRiskComponentDTO(operationalRiskDTO);
        riskTypeDTO.addRiskComponentDTO(managementRiskDTO);
        riskTypeDTO.addRiskComponentDTO(industryRiskDTO);



        return  riskTypeDTO;
    }
}

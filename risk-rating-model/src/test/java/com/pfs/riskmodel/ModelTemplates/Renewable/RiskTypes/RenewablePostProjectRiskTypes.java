package com.pfs.riskmodel.ModelTemplates.Renewable.RiskTypes;

import com.pfs.riskmodel.ModelTemplates.Renewable.RiskComponents.RPP_BusinessRiskComponentDTO;
import com.pfs.riskmodel.ModelTemplates.Renewable.RiskComponents.RPP_FinancialRiskRiskComponentDTO;
import com.pfs.riskmodel.ModelTemplates.Renewable.RiskComponents.RPP_IndustryRiskRiskComponentDTO;
import com.pfs.riskmodel.ModelTemplates.Renewable.RiskComponents.RPP_ManagementRiskRiskComponentDTO;
import com.pfs.riskmodel.dto.RiskComponentDTO;
import com.pfs.riskmodel.dto.RiskTypeDTO;

/**
 * Created by sajeev on 20-Dec-18.
 */
public class RenewablePostProjectRiskTypes {
    public static RiskTypeDTO riskTypeDTO ;

    public static RiskTypeDTO buildRiskTypes () {

        //---------------------------------------------------------------------------------//
        // ---------------------------RiskType 1 -----------------------------------------//
        //                      Post Project Implementation Risk

        riskTypeDTO = new RiskTypeDTO();
        riskTypeDTO.setId(null);
        riskTypeDTO.setItemNo(2);
        riskTypeDTO.setDescription("Post Project Implementation Risk");
        riskTypeDTO.setScore(0D);
        riskTypeDTO.setGrade(" ");



        //  Risk Component 1 : Business Risk - 32%
        RiskComponentDTO businessRiskComponent = new RiskComponentDTO();
        businessRiskComponent = RPP_BusinessRiskComponentDTO.getBusinessRiskComponentDTO();

        //  Risk Component 2 : Industry Risk - 16%
        RiskComponentDTO industryRiskComponent = new RiskComponentDTO();
        industryRiskComponent = RPP_IndustryRiskRiskComponentDTO.getIndustryRiskComponentDTO();

        //  Risk Component 3 : Financial Risk - 32%
        RiskComponentDTO financialRiskComponent = new RiskComponentDTO();
        financialRiskComponent = RPP_FinancialRiskRiskComponentDTO.getFinancialRiskComponentDTO();

        //  Risk Component 4 : Management Risk - 20%
        RiskComponentDTO managementRiskComponent = new RiskComponentDTO();
        managementRiskComponent = RPP_ManagementRiskRiskComponentDTO.managementRiskComponentDTO();


        riskTypeDTO.addRiskComponentDTO(businessRiskComponent);
        riskTypeDTO.addRiskComponentDTO(industryRiskComponent);
        riskTypeDTO.addRiskComponentDTO(financialRiskComponent);
        riskTypeDTO.addRiskComponentDTO(managementRiskComponent);

        return  riskTypeDTO;
    }
}

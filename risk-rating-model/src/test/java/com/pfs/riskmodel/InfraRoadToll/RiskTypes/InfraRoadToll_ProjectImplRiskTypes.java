package com.pfs.riskmodel.InfraRoadToll.RiskTypes;

import com.pfs.riskmodel.InfraRoadHAM.RiskComponents.IRHAM_PIR_CompletionRiskDTO;
import com.pfs.riskmodel.InfraRoadHAM.RiskComponents.IRHAM_PIR_ExecutionRiskDTO;
import com.pfs.riskmodel.InfraRoadToll.RiskComponents.IRToll_PIR_CompletionRiskDTO;
import com.pfs.riskmodel.InfraRoadToll.RiskComponents.IRToll_PIR_ExecutionRiskDTO;
import com.pfs.riskmodel.dto.RiskComponentDTO;
import com.pfs.riskmodel.dto.RiskTypeDTO;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sajeev on 29-Dec-18.
 */
public class InfraRoadToll_ProjectImplRiskTypes {


    public RiskTypeDTO buildProjectImplRiskTypes() {


        RiskTypeDTO riskTypeDTO = new RiskTypeDTO();


        riskTypeDTO.setId(null);
        riskTypeDTO.setItemNo(1);
        riskTypeDTO.setDescription("Infra. Road HAM - Project Implementation Risk Type");
        riskTypeDTO.setScore(0D);

        Set<RiskComponentDTO> riskComponentDTOs = new HashSet<>();


        IRToll_PIR_CompletionRiskDTO irToll_pir_completionRiskDTO = new IRToll_PIR_CompletionRiskDTO();
        RiskComponentDTO completionRiskDTO = irToll_pir_completionRiskDTO.getCompletionRiskDTO();

        IRToll_PIR_ExecutionRiskDTO irToll_pir_executionRiskDTO = new IRToll_PIR_ExecutionRiskDTO();
        RiskComponentDTO executionRiskComponentDTO = irToll_pir_executionRiskDTO.getExecutionRiskDTO();

        riskComponentDTOs.add(completionRiskDTO);
        riskComponentDTOs.add(executionRiskComponentDTO);

        riskTypeDTO.setRiskComponents(riskComponentDTOs);
        return riskTypeDTO;

    }
}
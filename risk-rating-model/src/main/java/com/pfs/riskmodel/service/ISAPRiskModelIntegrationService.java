package com.pfs.riskmodel.service;

import com.pfs.riskmodel.domain.RiskModelTemplate;
import com.pfs.riskmodel.resource.RiskEvaluationSummary;

/**
 * Created by sajeev on 15-Dec-18.
 */
public interface ISAPRiskModelIntegrationService {

   //public void createRiskModelInSAP(RiskModelTemplate riskModelTemplate) ;

    public RiskEvaluationSummary postRiskModelInSAP(RiskModelTemplate riskModelTemplate) ;

    public void putRiskModelInSAP(RiskModelTemplate riskModelTemplate) ;

    public RiskEvaluationSummary replicateRiskModelInSAP(RiskEvaluationSummary riskEvaluationSummary);

    public RiskEvaluationSummary mapRiskModelToSAPModel(RiskModelTemplate riskModel);

}

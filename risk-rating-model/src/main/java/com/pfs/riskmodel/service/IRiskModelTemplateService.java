package com.pfs.riskmodel.service;

import com.pfs.riskmodel.domain.RiskModelTemplate;
import com.pfs.riskmodel.domain.RiskProjectType;
import com.pfs.riskmodel.domain.RiskType;
import com.pfs.riskmodel.dto.RiskModelReportDTO;
import com.pfs.riskmodel.resource.LoanApplication;
import com.pfs.riskmodel.resource.RiskEvaluationInSAP;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by sajeev on 15-Dec-18.
 */
public interface IRiskModelTemplateService {

    public Map<String, Object> createRiskModelTemplate(RiskModelTemplate riskModelTemplate);
    public Map<String, Object>  updateRiskModelTemplate(RiskModelTemplate riskModelTemplate);
    public Map<String , Object> findByProjectTypeAndRiskLevel (String projectType, String projectRiskLevel);

    public RiskModelTemplate getByRiskModelId(Long id);

    public List<RiskModelReportDTO> findByLoanNumberAndRiskProjectTypeAndProjectName(String loanNumber, String riskProjectTypeCode, String projectName) throws ParseException;

    public List<RiskModelReportDTO> findByLoanNumberAndRiskProjectTypeAndProjectNameFiltered(List<LoanApplication> loanApplications,
                                                                                             String loanNumber,
                                                                                             String riskProjectTypeCode,
                                                                                             String projectName,
                                                                                             Boolean activeLoanAccountsOnly,
                                                                                             Boolean latestRatingsOnly) throws ParseException;



}

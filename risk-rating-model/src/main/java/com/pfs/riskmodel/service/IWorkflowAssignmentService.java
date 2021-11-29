package com.pfs.riskmodel.service;

import com.pfs.riskmodel.domain.RiskModelTemplate;
import com.pfs.riskmodel.domain.RiskPurpose;
import com.pfs.riskmodel.domain.WorkflowAssignment;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by sajeev on 15-Dec-18.
 */
public interface IWorkflowAssignmentService {

    public WorkflowAssignment getWorkFlowAssignmentForEvaluationDateAndPurpose(Date riskEvaluationDate, RiskPurpose riskPurpose) ;

}

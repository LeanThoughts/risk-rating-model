package com.pfs.riskmodel.service.Impl;

import com.pfs.riskmodel.client.LMSEnquiryClient;
import com.pfs.riskmodel.domain.RiskModelTemplate;
import com.pfs.riskmodel.domain.RiskPurpose;
import com.pfs.riskmodel.domain.WorkflowAssignment;
import com.pfs.riskmodel.repository.WorkflowAssignmentRepository;
import com.pfs.riskmodel.repository.WorkflowStatusRepository;
import com.pfs.riskmodel.resource.EmailId;
import com.pfs.riskmodel.resource.LoanApplication;
import com.pfs.riskmodel.resource.User;
import com.pfs.riskmodel.service.IWorkflowAssignmentService;
import com.pfs.riskmodel.service.IWorkflowService;
import com.pfs.riskmodel.util.ValidationResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by sajeev on 17-Dec-18.
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class WorkflowAssignmentService implements IWorkflowAssignmentService {

    @Autowired
    private WorkflowAssignmentRepository workflowAssignmentRepository;

    @Override
    public WorkflowAssignment getWorkFlowAssignmentForEvaluationDateAndPurpose(Date riskEvaluationDate, RiskPurpose riskPurpose) {
        List<WorkflowAssignment> workflowAssignmentList = workflowAssignmentRepository.findAll();

        for (WorkflowAssignment workflowAssignment: workflowAssignmentList ) {
            if (workflowAssignment.getPurpose().getDescription().toString().equals( riskPurpose.getDescription().toString()))  {

                int validFromComparisonResult   = workflowAssignment.getValidFromDate().compareTo(riskEvaluationDate);
                int validToComparisonResult     = workflowAssignment.getValidToDate().compareTo(riskEvaluationDate);

                if (validFromComparisonResult == -1 && validToComparisonResult == 1) {
                    return workflowAssignment;
                }
            }

        }

        return null;
    }
}
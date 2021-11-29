package com.pfs.riskmodel.dao;

import com.pfs.riskmodel.domain.RiskPurpose;
import com.pfs.riskmodel.domain.WorkflowAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface WorkflowAssignmentDao extends JpaRepository<WorkflowAssignment,Long> {

    // Get WorkAssignment as of a Run Date and RiskPurpose
    @Query("Select w from WorkflowAssignment w  where DATE(w.validFromDate)>= :rundate and  DATE(w.validToDate)  <= :rundate and w.purpose = :purpose")
    public WorkflowAssignment findWorkflowAssignmentByDate(@Param("rundate") Date runDate,  @Param("purpose") RiskPurpose purpose) ;

    @Query("select w from WorkflowAssignment w  where w.validFromDate >= :rundate and  w.validToDate <= :rundate and w.purpose = :purpose")
    public WorkflowAssignment findWorkflowAssignmentByDateBetween(@Param("rundate") Date runDate,  @Param("purpose") RiskPurpose purpose) ;

}

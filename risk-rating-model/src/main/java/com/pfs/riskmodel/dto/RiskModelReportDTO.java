package com.pfs.riskmodel.dto;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.annotation.After;

import java.sql.Time;
import java.util.Date;

/**
 * Created by sajeev on 23-May-21.
 */
@Getter
@Setter
public class RiskModelReportDTO {

      // Risk Model Id
            private Long riskModelId;

      //    Loannumber
            private String loanNumber;
      //    Project Name
            private String projectName;
      //    Project Type
            private String projectType;
      //    Project Phase
            private String projectPhase;
      //    InitiatingDepartment
            private String initiatingDepartment;
      //    Loan contractamount(Rs Crores)
            private Double loanContractAmount;
      //    Total DisbursedAmt(Rs Crores)
            private Double totalLoanDisbursedAmount;
      //    Initiator
            private String initiator;
      // Creation date
            private String createDate;
      // Creation Time
            private String createdTime;

            //    Process date (After finalapproval)

            private  String processDate;

            private String processTime;

            // Processed By
            private String processedBy;

      //    FinalRating
            private String finalRating;

      //    Risk Category
            private String riskCategory;





}

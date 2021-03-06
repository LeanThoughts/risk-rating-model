package com.pfs.riskmodel.dto;

import com.pfs.riskmodel.domain.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * Created by sajeev on 17-Dec-18.
 */
@Getter
@Setter
public class RiskModelTemplateDTO {

    private Long id;
    private String version;
    private String status;
    private String description;


    /*
        01 - Project Assessment
        02 - Risk Assessment
        03 - Monitoring
     */
    private String purposeCode;
    private String purposeDescription;
    private String processInstanceId;

    /*
        01 - Created
        02 - Sent for Approval
        03 - Approved
        04 - Rejected
     */
    private String workflowStatusCode;
    private String workflowStatusDescription;



    // 0 - Template
    // 1 - Project Valuation
    private Integer modelType;



    private Integer modelCategoryCode;
    private String modelCategoryDescription;



    /*
    "01", "Renewable Project"
    "02", "Infrastructure Transmission Project"
    "03", "Infrastructure Road Project – Hybrid Annuity"
    "04", "Infrastrucutre Road Project - Toll "
     "05", "Holding Company"
*/
     private String riskProjectTypeCode;
     private String riskProjectTypeDescription;


    /*
    "01", "Build Phase "
    "02", "Operational Risk Phase"
    */

     private String projectRiskLevelCode;
     private String projectRiskLevelDescription;

    /**
     ("01", "Weighted");
     ("02", "Sum");
     ("03", "Minimum");
     ("04", "Maximum");
     ("05", "Equals");
     ("06", "Multiply")
     */
     private String computingMethodCode;
     private String computingMethodDescription;


     private String loanNumber;
     private String projectName;
     private Double loanAmountInCrores;
     private Date ratingDate;


     private Double score;
     private String overallProjectGrade;
     private String modifiedProjectGrade;
     private String afterParentalNotchUpGrade;
     private String finalProjectGrade;




    // Risk Types
    private List<RiskTypeDTO> riskTypes;

    public void addRiskTypeDTO (RiskTypeDTO riskTypeDTO ) {
        if (riskTypes == null){
            riskTypes = new ArrayList<>();
        }
        riskTypes.add(riskTypeDTO);
    }


    // Risk Rating Modifiers
    private List<RiskRatingModifierDTO> riskRatingModifiers;

    public void addRiskRatingModifierDTO (RiskRatingModifierDTO riskRatingModifierDTO) {
        if (riskRatingModifiers == null){
            riskRatingModifiers = new ArrayList<>();
        }
        riskRatingModifiers.add(riskRatingModifierDTO);
    }


    // Risk - Parental NotchUp
    private List<RiskParentalNotchUpDTO> riskParentalNotchUps;

    public void addRiskParentalNotchUpModifierDTO (RiskParentalNotchUpDTO riskParentalNotchUpDTO) {
        if (riskParentalNotchUps == null){
            riskParentalNotchUps = new ArrayList<>();
        }
        riskParentalNotchUps.add(riskParentalNotchUpDTO);
    }


    private List<RiskModelSummaryDTO> riskModelSummaries;
    public RiskModelSummaryDTO addRiskModelSummaryDTO (RiskModelSummaryDTO riskModelSummaryDTO) {

        this.getRiskModelSummaries().add(riskModelSummaryDTO);
        return riskModelSummaryDTO;

    }

}

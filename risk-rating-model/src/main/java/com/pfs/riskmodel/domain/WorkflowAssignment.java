package com.pfs.riskmodel.domain;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sajeev on 26-Jan-19.
 */

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class WorkflowAssignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    /*
        01 - Project Assessment
        02 - Risk Assessment
        03 - Monitoring
     */

    @NotNull
    @OneToOne(  fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH})
     private RiskPurpose purpose;

    // Validity Period : Added on 18th Nov 2021
    private Date validFromDate;
    private Date validToDate;

    private String firstLevelApproverName;
    private String firstLevelApproverEmailId;
    private String secondLevelApproverName;
    private String secondLevelApproverEmailId;
    private String thirdLevelApproverName;
    private String thirdLevelApproverEmailId;

}

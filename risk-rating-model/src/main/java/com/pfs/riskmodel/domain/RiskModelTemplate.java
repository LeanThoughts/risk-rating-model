package com.pfs.riskmodel.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by sajeev on 15-Dec-18.
 */
@Entity
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class RiskModelTemplate extends AuditModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private String version;

    @NotNull
    private Boolean active;


    @NotNull
    @Size(max = 250)
    private String description;


    /*
    "01", "Renewable Project"
    "02", "Infrastructure Transmission Project"
    "03", "Infrastructure Road Project – Hybrid Annuity"
    "04", "Infrastrucutre Road Project - Toll "
     "05", "Holding Company"
*/
    @NotNull
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ProjectType projectType;


    /*
    "01", "Build Phase "
    "02", "Operational Risk Phase"
    */

    @NotNull
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ProjectRiskLevel projectRiskLevel;

    /**
     ("01", "Weighted");
     ("02", "Sum");
     ("03", "Minimum");
     ("04", "Maximum");
     ("05", "Equals");
     ("06", "Multiply")
     */
    @NotNull
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ComputingMethod computingMethod;


    @NotNull
    private Double score;



    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @JoinColumn(name="riskModelTemplate__id",referencedColumnName = "id")
    private Set<RiskType> riskTypes;


    public RiskType addRiskType (RiskType riskType) {

        this.getRiskTypes().add(riskType);
        return riskType;
    }

}
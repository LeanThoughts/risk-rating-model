package com.pfs.riskmodel.dto;

import com.pfs.riskmodel.domain.ComputingMethod;
import com.pfs.riskmodel.domain.RiskSubFactor;
import com.pfs.riskmodel.domain.ScoreType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by sajeev on 17-Dec-18.
 */
@Getter
@Setter
public class RiskFactorDTO {

    private Long id;
    private String description;
    private String computingMethodCode;
    private String scoreTypeCode;
    private Double score;
    private Double weightage;

    private Set<RiskSubFactorDTO> riskSubFactors;


    public void addRiskSubFactorDTO (RiskSubFactorDTO riskSubFactorDTO) {
        this.riskSubFactors.add(riskSubFactorDTO);
    }
}

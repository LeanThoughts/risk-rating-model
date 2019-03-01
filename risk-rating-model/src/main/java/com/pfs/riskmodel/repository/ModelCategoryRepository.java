package com.pfs.riskmodel.repository;

import com.pfs.riskmodel.domain.ModelCategory;
import com.pfs.riskmodel.domain.RiskProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by sajeev on 17-Dec-18.
 */
@RepositoryRestResource
@Repository
public interface ModelCategoryRepository extends JpaRepository<ModelCategory, Long>{

    ModelCategory findByCode(Integer code);
}

 
package com.pfs.riskmodel.repository;

 import com.pfs.riskmodel.domain.ScoreType;
import com.pfs.riskmodel.domain.WorkflowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 import org.springframework.stereotype.Repository;

/**
 * Created by sajeev on 17-Dec-18.
 */

@RepositoryRestResource
@Repository
public interface WorkflowStatusRepository extends JpaRepository<WorkflowStatus, Long>{

    WorkflowStatus findByCode(String code);
}

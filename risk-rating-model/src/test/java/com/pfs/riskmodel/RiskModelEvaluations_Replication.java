package com.pfs.riskmodel;

import com.pfs.riskmodel.repository.RiskModelTemplateRepository;
import com.pfs.riskmodel.service.ISAPRiskModelIntegrationService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by sajeev on 18-Dec-18.
 */
public  class RiskModelEvaluations_Replication extends AbstractTest {

    @Autowired
    RiskModelTemplateRepository riskModelTemplateRepository;

    @Autowired
    ISAPRiskModelIntegrationService isapRiskModelIntegrationService;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }


    @Test
    public void test () throws Exception {
    }


    @Test
    public  void replicate() throws Exception {

        this.replicateRiskModels();

    }




    private void replicateRiskModels() throws  Exception {


//        List<RiskModelTemplate> riskModels = riskModelTemplateRepository.findAll();
//
//        for (RiskModelTemplate riskModel: riskModels) {
//
//            if (riskModel.getModelType() == 1) {
//                if (riskModel.getLoanNumber() != null) {
//                    System.out.println("Replicating Loan Contract: " + riskModel.getLoanNumber());
//                    System.out.println("Replicating Risk Model Id: " + riskModel.getId().toString());
//                    RiskEvaluationInSAP riskEvaluationInSAP =
//                            isapRiskModelIntegrationService.replicateRiskModelInSAP(riskModel.getId());
//
//                    if (riskEvaluationInSAP == null) {
//                        System.out.println("Replication Failed for Loan Contract: "
//                                                + riskModel.getLoanNumber() + "Risk Model Id:" + riskModel.getId() );
//                    } else {
//                        System.out.println("Replication Successful for Loan Contract: "
//                                + riskModel.getLoanNumber() + "Risk Model Id:" + riskModel.getId() );
//
//                    }
//
//                }
//            }


    }




}

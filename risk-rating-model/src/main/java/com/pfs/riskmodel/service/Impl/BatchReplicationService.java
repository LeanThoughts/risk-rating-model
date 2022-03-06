package com.pfs.riskmodel.service.Impl;

import com.pfs.riskmodel.client.LMSEnquiryClient;
import com.pfs.riskmodel.domain.RiskModelTemplate;
import com.pfs.riskmodel.repository.RiskModelTemplateRepository;
import com.pfs.riskmodel.resource.LoanApplicationResource;
import com.pfs.riskmodel.resource.RiskEvaluationSummary;
import com.pfs.riskmodel.resource.SearchResource;
import com.pfs.riskmodel.service.IBatchReplicationService;
import com.pfs.riskmodel.service.ISAPRiskModelIntegrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;


/**
 * Created by sajeev on 17-Dec-18.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BatchReplicationService implements IBatchReplicationService {

    @Autowired
    RiskModelTemplateRepository riskModelTemplateRepository;

    @Autowired
    ISAPRiskModelIntegrationService isapRiskModelIntegrationService;

    private final LMSEnquiryClient lmsEnquiryClient;


    @Override
    public void replicationService(HttpServletRequest request, Integer loanNumberFrom, Integer loanNumberTo) {

        if (loanNumberFrom == null)  loanNumberFrom = 0;
        if (loanNumberFrom == null)  loanNumberTo = 99999;

        SearchResource resource = new SearchResource();
        if (loanNumberFrom != null)
            resource.setLoanNumberFrom(loanNumberFrom);
        if (loanNumberTo != null)
            resource.setLoanNumberTo(loanNumberTo);
        ResponseEntity<List<LoanApplicationResource>> resources =
                lmsEnquiryClient.searchEnquiries(resource, getAuthorizationBearer(request.getUserPrincipal()));

        List<LoanApplicationResource> loanApplicationResourceList = resources.getBody();


        for (LoanApplicationResource loanApplicationResource: loanApplicationResourceList) {
            List<RiskModelTemplate> riskModelsForLoan
                    = riskModelTemplateRepository.findByLoanNumber(loanApplicationResource.getLoanApplication().getLoanContractId());

            for  (RiskModelTemplate riskModel: riskModelsForLoan) {

                    System.out.println("Replicating Loan Contract: " + riskModel.getLoanNumber());
                    System.out.println("Replicating Risk Model Id: " + riskModel.getId().toString());

                RiskEvaluationSummary riskEvaluationSummary =
                        isapRiskModelIntegrationService.mapRiskModelToSAPModel(riskModel);
                isapRiskModelIntegrationService.replicateRiskModelInSAP(riskEvaluationSummary);

                if (riskEvaluationSummary == null) {
                    System.out.println("Replication Failed for Loan Contract: "
                            + riskModel.getLoanNumber() + "Risk Model Id:" + riskModel.getId());
                } else {
                    System.out.println("Replication Successful for Loan Contract: "
                            + riskModel.getLoanNumber() + "Risk Model Id:" + riskModel.getId());

                }
            }

        }



    }

    public String getAuthorizationBearer(Principal user) {
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) ((OAuth2Authentication) user).getDetails();
        return "Bearer " + details.getTokenValue();
    }
}




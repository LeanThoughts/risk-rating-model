package com.pfs.riskmodel.service.Impl;

import com.pfs.riskmodel.domain.RiskComponent;
import com.pfs.riskmodel.domain.RiskModelTemplate;
import com.pfs.riskmodel.domain.RiskType;
import com.pfs.riskmodel.repository.RiskModelTemplateRepository;
import com.pfs.riskmodel.resource.*;
import com.pfs.riskmodel.service.IRiskModelTemplateService;
import com.pfs.riskmodel.service.ISAPRiskModelIntegrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;


@Slf4j
@Service
@RequiredArgsConstructor
public class SAPRiskModelIntegrationService implements ISAPRiskModelIntegrationService {

    @Value("${sap.postUrl}")
    private String postURL;

    @Value("${sap.userName}")
    private String userName;

    @Value("${sap.password}")
    private String password;

    @Autowired
    private RiskModelTemplateRepository riskModelTemplateRepository;

    @Autowired
    private IRiskModelTemplateService iRiskModelService;


    public String fetchCSRFToken() {


        HttpHeaders headers = new HttpHeaders() {
            {
                String auth =  userName + ":" + password; // "SAP_PFS_GW" + ":" + "Sapsap@4646";
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
        headers.add("X-Csrf-Token", "Fetch ");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        System.out.println("THE REQUEST : " + requestEntity.toString());

        URI uri = null;
        try {
            uri = new URI("http://192.168.1.203:8000/sap/opu/odata/sap/ZPFS_LOAN_ENQ_PORTAL_SRV/?sap-client=300$metadata");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println("THE URI : " + uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
        System.out.println("Headers: " + responseEntity.getHeaders());
        System.out.println("Result - status (" + responseEntity.getStatusCode() + ") has body: " + responseEntity.hasBody());
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("THE STATUS CODE: " + statusCode);

        System.out.println(responseEntity.getHeaders().get("x-csrf-token").get(0));

        return responseEntity.getHeaders().get("x-csrf-token").get(0);
    }

    public RiskEvaluationSummary mapRiskModelToSAPModel(RiskModelTemplate riskModel) {


        RiskEvaluationSummary riskEvaluationSummary = new RiskEvaluationSummary();

        riskEvaluationSummary.RiskEvalId = riskModel.getId().toString();
        riskEvaluationSummary.LoanContractId = riskModel.getLoanNumber();

        riskEvaluationSummary.RiskPrjType = riskModel.getProjectRiskLevel().getCode();
        riskEvaluationSummary.RiskPrjTypeT = riskModel.getRiskProjectType().getValue();
        riskEvaluationSummary.ProjectName = riskModel.getProjectName();
        riskEvaluationSummary.RiskPrjPhase = riskModel.getProjectRiskLevel().getValue();

        java.sql.Timestamp timestamp = new java.sql.Timestamp(riskModel.getRatingDate().getDate());

        LocalDate date = LocalDate.now();
        riskEvaluationSummary.RatingDate = date.toString();

        riskEvaluationSummary.CurrDepartment = riskModel.getPurposeDescription();
        riskEvaluationSummary.InitiatedBy = riskModel.getCreatedByUserId();
        if (riskModel.getFirstLevelApprover() != null)
            riskEvaluationSummary.FirstLvlApprover = riskModel.getFirstLevelApprover();
        else
            riskEvaluationSummary.FirstLvlApprover = " ";

        if (riskModel.getSecondLevelApprover() != null)
            riskEvaluationSummary.SecondLvlApprover = riskModel.getSecondLevelApprover();
        else
            riskEvaluationSummary.SecondLvlApprover = " ";

        if (riskModel.getThirdLevelApprover() != null)
        riskEvaluationSummary.ThirdLvlApprover = riskModel.getThirdLevelApprover();
        else
            riskEvaluationSummary.ThirdLvlApprover = " ";

        if (riskModel.getReviewedBy() != null)
        riskEvaluationSummary.LatestReviewer = riskModel.getReviewedBy();
        else
            riskEvaluationSummary.LatestReviewer = " ";

        riskEvaluationSummary.WfStatusDesc = riskModel.getWorkflowStatus().getDescription();

        riskEvaluationSummary.FinalGrade = riskModel.getFinalProjectGrade();

        RiskEvaluationScore riskEvaluationScore = new RiskEvaluationScore();

        Integer ratingTypeId = 0;
        Double score = 0D; ;
        DecimalFormat df = new DecimalFormat("#.##");



        for (RiskType riskType : riskModel.getRiskTypes()) {
            riskEvaluationScore = new RiskEvaluationScore();
            ratingTypeId++;
            riskEvaluationScore.RiskEvalId = riskModel.getId().toString();
            riskEvaluationScore.RatingType = riskType.getDescription();
            riskEvaluationScore.RiskRatingId = ratingTypeId.toString();
            riskEvaluationScore.Grade = riskType.getGrade();

            score = Double.valueOf(df.format(riskType.getScore()));
            riskEvaluationScore.Score = score.toString();

            riskEvaluationSummary.RiskEvaluation_OverallScore_Nav.add(riskEvaluationScore);
            ratingTypeId++;

            for (RiskComponent riskComponent : riskType.getRiskComponents()) {
                RiskEvaluationComponentScore riskEvaluationComponentScore = new RiskEvaluationComponentScore();
                riskEvaluationComponentScore.RiskEvalId = riskModel.getId().toString();

                riskEvaluationComponentScore.ProjectPhase = riskType.getDescription();
                riskEvaluationComponentScore.ComponentId = riskComponent.getId().toString();
                riskEvaluationComponentScore.ComponentName = riskComponent.getDescription();
                score = Double.valueOf(df.format(riskComponent.getScore()));
                riskEvaluationComponentScore.Score = score.toString();
                riskEvaluationSummary.RiskEvaluation_ComponentScore_Nav.add(riskEvaluationComponentScore);
            }

        }


//      Overall Project Rating
        if (riskModel.getScore() != null) {
            riskEvaluationScore = new RiskEvaluationScore();
            ratingTypeId++;
            riskEvaluationScore.RiskEvalId = riskModel.getId().toString();
            riskEvaluationScore.RatingType = "Overall Project Rating";
            riskEvaluationScore.RiskRatingId = ratingTypeId.toString();
            riskEvaluationScore.Grade = riskModel.getOverallProjectGrade();
            if (riskModel.getScore() != null) {
                score = Double.valueOf(df.format(riskModel.getScore()));
                riskEvaluationScore.Score = score.toString();

            }
            else
                riskEvaluationScore.Score = " ";

            riskEvaluationSummary.RiskEvaluation_OverallScore_Nav.add(riskEvaluationScore);
        }

//      Overall Project Rating
        if (riskModel.getOverallProjectGrade() != null) {
            riskEvaluationScore = new RiskEvaluationScore();
            ratingTypeId++;
            riskEvaluationScore.RiskEvalId = riskModel.getId().toString();
            riskEvaluationScore.RatingType = "Overall Project Grade";
            riskEvaluationScore.RiskRatingId = ratingTypeId.toString();
            riskEvaluationScore.Grade = riskModel.getOverallProjectGrade();
            riskEvaluationScore.Score = "";
            riskEvaluationSummary.RiskEvaluation_OverallScore_Nav.add(riskEvaluationScore);
        }

        if (riskModel.getModifiedProjectGrade() != null) {
            riskEvaluationScore = new RiskEvaluationScore();
            ratingTypeId++;
            riskEvaluationScore.RiskEvalId = riskModel.getId().toString();
            riskEvaluationScore.RatingType = "Modified Project Grade";
            riskEvaluationScore.RiskRatingId = ratingTypeId.toString();
            riskEvaluationScore.Grade = riskModel.getModifiedProjectGrade();
            riskEvaluationScore.Score = " ";
            riskEvaluationSummary.RiskEvaluation_OverallScore_Nav.add(riskEvaluationScore);
        }

        if (riskModel.getAfterParentalNotchUpGrade() != null) {
            riskEvaluationScore = new RiskEvaluationScore();
            ratingTypeId++;
            riskEvaluationScore.RiskEvalId = riskModel.getId().toString();
            riskEvaluationScore.RatingType = "After Parental Notchup Project Grade";
            riskEvaluationScore.RiskRatingId = ratingTypeId.toString();
            riskEvaluationScore.Grade = riskModel.getAfterParentalNotchUpGrade();
            riskEvaluationScore.Score = " ";
            riskEvaluationSummary.RiskEvaluation_OverallScore_Nav.add(riskEvaluationScore);
        }

        if (riskModel.getFinalProjectGrade() != null) {
            riskEvaluationScore = new RiskEvaluationScore();
            ratingTypeId++;
            riskEvaluationScore.RiskEvalId = riskModel.getId().toString();
            riskEvaluationScore.RatingType = "Final Project Grade";
            riskEvaluationScore.RiskRatingId = ratingTypeId.toString();
            riskEvaluationScore.Grade = riskModel.getFinalProjectGrade();
            riskEvaluationScore.Score = " ";
            riskEvaluationSummary.RiskEvaluation_OverallScore_Nav.add(riskEvaluationScore);

        }


        return riskEvaluationSummary;

    }




    @Override
    public RiskEvaluationSummary postRiskModelInSAP(RiskModelTemplate riskModel ) {


        // Map Risk Model to SAP Risk Model Summary Object
        RiskEvaluationSummary riskEvaluationSummary = mapRiskModelToSAPModel(riskModel );


        System.out.println("SAP User Name: " +userName);
        System.out.println("SAP Pwd      : " +password);


        HttpHeaders headers = new HttpHeaders() {
            {
                String auth = userName + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
                setContentType(MediaType.APPLICATION_JSON);
                add("X-Requested-With", "X");
            }
        };

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RiskEvaluationSummary> riskEvaluation = null;
        HttpEntity<RiskEvaluationSummary> requestToPost = new HttpEntity<RiskEvaluationSummary>(riskEvaluationSummary, headers);


        try {
            log.info("POSTING RISK MODEL TO SAP  FOR LOAN : " + riskEvaluationSummary.LoanContractId);
            log.info("POSTING RISK MODEL TO SAP  FOR PROJECT : " + riskEvaluationSummary.ProjectName);
            riskEvaluation = restTemplate.exchange(postURL, HttpMethod.POST, requestToPost, RiskEvaluationSummary.class);
        } catch (Exception ex) {
            log.info("EXCEPTION POSTING RISK MODEL TO SAP  FOR LOAN / PROJECT: " + riskEvaluationSummary.LoanContractId + " / " + riskEvaluationSummary.ProjectName);
            System.out.println(ex.getMessage());
            return null;
        }

        HttpStatus statusCode = riskEvaluation.getStatusCode();
        RiskEvaluationSummary riskEvaluationSummaryReponse = riskEvaluation.getBody();


        riskModelTemplateRepository.save(riskModel);


        return riskEvaluationSummaryReponse;

    }

    @Override
    public void putRiskModelInSAP(RiskModelTemplate riskModelTemplate) {

    }

    @Override
    public RiskEvaluationSummary replicateRiskModelInSAP(RiskEvaluationSummary riskEvaluationSummary) {
        this.postSAPRiskModelInSAP(riskEvaluationSummary);
        return riskEvaluationSummary;

    }


    private RiskEvaluationSummary postSAPRiskModelInSAP(RiskEvaluationSummary riskEvaluationSummary) {



        System.out.println("SAP User Name: " +userName);
        System.out.println("SAP Pwd      : " +password);

        HttpHeaders headers = new HttpHeaders() {
            {
//                String auth = "sajeev" + ":" + "sapsap";
                String auth = userName + ":" + password;

                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
                setContentType(MediaType.APPLICATION_JSON);
                add("X-Requested-With", "X");
            }
        };

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RiskEvaluationSummary> riskEvaluation = null;
        HttpEntity<RiskEvaluationSummary> requestToPost = new HttpEntity<RiskEvaluationSummary>(riskEvaluationSummary, headers);


        try {
            log.info("POSTING RISK MODEL TO SAP  FOR LOAN : " + riskEvaluationSummary.LoanContractId);
            log.info("POSTING RISK MODEL TO SAP  FOR PROJECT : " + riskEvaluationSummary.ProjectName);
            riskEvaluation = restTemplate.exchange(postURL, HttpMethod.POST, requestToPost, RiskEvaluationSummary.class);
        } catch (Exception ex) {

            log.info("EXCEPTION POSTING RISK MODEL TO SAP  FOR LOAN / PROJECT: " + riskEvaluationSummary.LoanContractId + " / " + riskEvaluationSummary.ProjectName);
            System.out.println(ex.getMessage());

            return null;
        }

        HttpStatus statusCode = riskEvaluation.getStatusCode();
        RiskEvaluationSummary riskEvaluationSummaryReponse = riskEvaluation.getBody();


        return riskEvaluationSummaryReponse;

    }


}

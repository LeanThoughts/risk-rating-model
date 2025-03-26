package com.pfs.riskmodel.pdfservice;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.pfs.riskmodel.client.LMSEnquiryClient;
import com.pfs.riskmodel.domain.RiskComponent;
import com.pfs.riskmodel.domain.RiskModelTemplate;
import com.pfs.riskmodel.domain.RiskType;
import com.pfs.riskmodel.domain.WorkflowAssignment;
import com.pfs.riskmodel.resource.EmailId;
import com.pfs.riskmodel.resource.LoanApplicationResource;
import com.pfs.riskmodel.resource.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;

/**
 * Created by sajeev on 01-Jan-19.
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class RiskModelPDFBuilder {

    @Autowired
    HttpServletRequest request;

    @Autowired
    LMSEnquiryClient lmsEnquiryClient;

    private String getAuthorizationBearer() {
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) ((OAuth2Authentication) request.getUserPrincipal()).getDetails();
        return "Bearer " + details.getTokenValue();
    }

    public ByteArrayOutputStream buildPdfDocument(RiskModelTemplate riskModelTemplate,
                                                  WorkflowAssignment workflowAssignment,
                                                  Task task
                                                 ) throws Exception {

        ResponseEntity<User> reUser =
                lmsEnquiryClient.getUserResourceByEmail(new EmailId(riskModelTemplate.getCreatedByUserId()), getAuthorizationBearer());
        User createdByUser = reUser.getBody();

        System.out.println("Fetching loan enquiry details for ## " + riskModelTemplate.getLoanEnquiryId());

        ResponseEntity<LoanApplicationResource> loanApplicationEntity =
                lmsEnquiryClient.getLoanApplicationByEnquiryId(riskModelTemplate.getLoanEnquiryId(), getAuthorizationBearer());
        LoanApplicationResource loanApplicationResource = null;
        loanApplicationResource = loanApplicationEntity.getBody();

        Document doc = new Document(PageSize.A4,36, 36, 70, 80);


        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(doc,stream);


        PDFFooter event = new PDFFooter( riskModelTemplate.getProjectName(),
                riskModelTemplate.getLoanAmountInCrores().toString(),
                riskModelTemplate.getRatingDate(),
                riskModelTemplate.getRiskProjectType().getValue(),
                riskModelTemplate.getProjectRiskLevel().getValue());

        writer.setPageEvent(event);

        doc.open();

        doc.add(new Paragraph(" "));
        doc.add(new Paragraph(" "));

        doc.addTitle(riskModelTemplate.getProjectName() + " " + riskModelTemplate.getProjectRiskLevel().getValue());

        // Header Table with Loan Details
        RiskModelPDFHeaderTable riskModelPDFHeaderTable = new RiskModelPDFHeaderTable();
        System.out.println("Loan Application Resource: " + loanApplicationResource.toString());
        doc = riskModelPDFHeaderTable.buildHeader(doc, riskModelTemplate, workflowAssignment, task, createdByUser,
                loanApplicationResource);

        // Rating Overview Table
        RiskModelPDFHeaderRatingOverviewTable riskModelPDFHeaderRatingOverviewTable = new RiskModelPDFHeaderRatingOverviewTable();
        doc = riskModelPDFHeaderRatingOverviewTable.buildHeaderRatingTable(doc, riskModelTemplate);

        // Risk Component Scores
        RiskModelPDFRiskTypeComponentTable riskModelPDFRiskTypeComponentOverviewTable = new RiskModelPDFRiskTypeComponentTable();
        doc = riskModelPDFRiskTypeComponentOverviewTable.buildRiskTypeComponentOverview(doc, riskModelTemplate);


        Font parafont = new Font(Font.FontFamily.HELVETICA );
        parafont.setSize(14);
        parafont.setStyle(Font.BOLD);
        parafont.setStyle(Font.UNDERLINE);
        parafont.setColor(BaseColor.BLUE.darker().darker().darker().darker());

        // Details
        for (RiskType riskType: riskModelTemplate.getRiskTypes()){

            // Risk Type Desc. BOLD AND UNDERLINED
            Phrase riskTypeDesc = new Phrase(riskType.getDescription(),parafont);
            Paragraph riskTypePara = new Paragraph();
            riskTypePara.setAlignment(Element.ALIGN_CENTER);

            doc.add(new Paragraph(" "));
            doc.add(new Paragraph( riskTypeDesc.getContent().toString(),parafont));
            doc.add(new Paragraph(" "));

            // Component, Factors, Sub Factors and Attribtues
            for (RiskComponent riskComponent: riskType.getRiskComponents()){

                // Skip Component if it not applicable: E.g. Account Conduct Risk
                if (riskComponent.getIsApplicable() == false)
                    continue;

                RiskModelPDFComponentTable riskModelPDFComponentTable = new RiskModelPDFComponentTable();
                riskModelPDFComponentTable.buildRiskComponentTable(doc,riskModelTemplate,riskComponent);
            }
        }


        // Rating Modifiers
        RiskModelPDFRiskRatingModifiersTable riskModelPDFRiskRatingModifiersTable = new RiskModelPDFRiskRatingModifiersTable();
        doc = riskModelPDFRiskRatingModifiersTable.buildRatingModifiers(doc, riskModelTemplate);

        // Parental Notchup
        if ( riskModelTemplate.getApplyParentalNotchup() == true ) {
            RiskModelPDFRiskParentalNotchupTable riskModelPDFRiskParentalNotchupTable = new RiskModelPDFRiskParentalNotchupTable();
            doc = riskModelPDFRiskParentalNotchupTable.buildParentalNotchup(doc, riskModelTemplate);
        }
        doc.close();

        return stream;

    }



}

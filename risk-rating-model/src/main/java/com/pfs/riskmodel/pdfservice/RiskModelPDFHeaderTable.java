package com.pfs.riskmodel.pdfservice;

import com.google.common.io.ByteStreams;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.pfs.riskmodel.domain.RiskModelTemplate;
import com.pfs.riskmodel.domain.WorkflowAssignment;
import com.pfs.riskmodel.repository.WorkflowAssignmentRepository;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by sajeev on 03-Jan-19.
 */
public class RiskModelPDFHeaderTable {


    private static Image getTickImage() throws Exception {

        try {
            InputStream imageStream = ClassLoader.getSystemResourceAsStream("images/Tick_Icon.png");

            Path path = Paths.get(ClassLoader.getSystemResource("images/Tick_Icon.png").toURI());
            Image img = Image.getInstance(path.toAbsolutePath().toString());

            img.scalePercent(50f);
            img.setAlignment(Element.ALIGN_CENTER);
            return img;

        } catch (Exception ex) {

            FileSystemResource logo = new FileSystemResource("/opt/risk-rating-model/risk-rating-model/src/main/resources/images/Tick_Icon.png");
            Image image = Image.getInstance(ByteStreams.toByteArray(logo.getInputStream()));
            image.scalePercent(50f);
            image.setAlignment(Element.ALIGN_CENTER);
            return image;
        }
    }


    private static Image getCrossImage() throws Exception {

        try {
            InputStream imageStream = ClassLoader.getSystemResourceAsStream("images/cross_Icon.png");

            Path path = Paths.get(ClassLoader.getSystemResource("images/cross_Icon.png").toURI());
            Image img = Image.getInstance(path.toAbsolutePath().toString());

            img.scalePercent(20f);
            img.setAlignment(Element.ALIGN_CENTER);
            return img;

        } catch (Exception ex) {

            FileSystemResource logo = new FileSystemResource("/opt/risk-rating-model/risk-rating-model/src/main/resources/images/cross_Icon.png");
            Image image = Image.getInstance(ByteStreams.toByteArray(logo.getInputStream()));
            image.scalePercent(20f);
            image.setAlignment(Element.ALIGN_CENTER);
            return image;
        }
    }


    public Document buildHeader(   Document doc, RiskModelTemplate riskModelTemplate,
                                   WorkflowAssignment workflowAssignment,
                                   Task task) throws Exception {


        // Header Font
        Font headerfont = new Font(Font.FontFamily.HELVETICA );
        headerfont.setColor(BaseColor.WHITE);
        headerfont.setSize(8);

        // Value Font
        Font valueFont = new Font(Font.FontFamily.HELVETICA);
        valueFont.setColor(BaseColor.BLACK);
        valueFont.setSize(8);


        //Project Details Table
        float[] columnWidths = {3, 7, 4, 3};
        PdfPTable projectDetailsTable = new PdfPTable(columnWidths);
        projectDetailsTable.setWidthPercentage(100.0f);


        // First Column - Project Name Text
        PdfPCell projectDetailsCell1 = new PdfPCell();
        projectDetailsCell1.setBackgroundColor(BaseColor.BLACK);
        projectDetailsCell1.setPhrase(new Phrase("Project Name",headerfont));

        // Second Column - Project Name
        PdfPCell projectDetailsCell2 = new PdfPCell();
        projectDetailsCell2.setBackgroundColor(BaseColor.WHITE);
        projectDetailsCell2.setPhrase(new Phrase(riskModelTemplate.getProjectName(),valueFont));

        // Third Column - Loan Number Text
        PdfPCell projectDetailsCell3 = new PdfPCell();
        projectDetailsCell3.setBackgroundColor(BaseColor.BLACK);
        projectDetailsCell3.setPhrase(new Phrase("Loan Number",headerfont));

        // Fourth Column - Loan Number
        PdfPCell projectDetailsCell4 = new PdfPCell();
        projectDetailsCell4.setBackgroundColor(BaseColor.WHITE);
        projectDetailsCell4.setPhrase(new Phrase(riskModelTemplate.getLoanNumber()  ,valueFont));

        projectDetailsTable.addCell(projectDetailsCell1);
        projectDetailsTable.addCell(projectDetailsCell2);
        projectDetailsTable.addCell(projectDetailsCell3);
        projectDetailsTable.addCell(projectDetailsCell4);
        projectDetailsTable.completeRow();




        // First Column - Project Type Text
        projectDetailsCell1 = new PdfPCell();
        projectDetailsCell1.setBackgroundColor(BaseColor.BLACK);
        projectDetailsCell1.setPhrase(new Phrase("Project Type",headerfont));

        // Second Column - Project Type
        projectDetailsCell2 = new PdfPCell();
        projectDetailsCell2.setBackgroundColor(BaseColor.WHITE);
        projectDetailsCell2.setPhrase(new Phrase(riskModelTemplate.getRiskProjectType().getValue(),valueFont));

        // Third Column - Loan Number Text
        projectDetailsCell3 = new PdfPCell();
        projectDetailsCell3.setBackgroundColor(BaseColor.BLACK);
        projectDetailsCell3.setPhrase(new Phrase("Loan Amount",headerfont));

        // Fourth Column - Loan Number
        projectDetailsCell4 = new PdfPCell();
        projectDetailsCell4.setBackgroundColor(BaseColor.WHITE);
        projectDetailsCell4.setPhrase(new Phrase(riskModelTemplate.getLoanAmountInCrores().toString() + " CR"  ,valueFont));

        projectDetailsTable.addCell(projectDetailsCell1);
        projectDetailsTable.addCell(projectDetailsCell2);
        projectDetailsTable.addCell(projectDetailsCell3);
        projectDetailsTable.addCell(projectDetailsCell4);
        projectDetailsTable.completeRow();





        // First Column - Risk Level Label
        projectDetailsCell1 = new PdfPCell();
        projectDetailsCell1.setBackgroundColor(BaseColor.BLACK);
        projectDetailsCell1.setPhrase(new Phrase("Project Phase",headerfont));

        // Second Column - Risk Level Name
        projectDetailsCell2 = new PdfPCell();
        projectDetailsCell2.setBackgroundColor(BaseColor.WHITE);

        String projectPhase = riskModelTemplate.getProjectRiskLevel().getValue(); // + " (" +riskModelTemplate.getPurpose().getDescription() + ")";

        projectDetailsCell2.setPhrase(new Phrase(projectPhase,valueFont));


        // Third Column - Rating Date  Text
        projectDetailsCell3 = new PdfPCell();
        projectDetailsCell3.setBackgroundColor(BaseColor.BLACK);
        projectDetailsCell3.setPhrase(new Phrase("Rating Date",headerfont));

        // Fourth Column - Loan Number
        projectDetailsCell4 = new PdfPCell();
        projectDetailsCell4.setBackgroundColor(BaseColor.WHITE);

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        String dateAsString = sdf.format(riskModelTemplate.getRatingDate());

        projectDetailsCell4.setPhrase(new Phrase(dateAsString ,valueFont));

        projectDetailsTable.addCell(projectDetailsCell1);
        projectDetailsTable.addCell(projectDetailsCell2);
        projectDetailsTable.addCell(projectDetailsCell3);
        projectDetailsTable.addCell(projectDetailsCell4);
        projectDetailsTable.completeRow();

        doc.add(projectDetailsTable);





        float[] columnWidths1 = {3f, 7f, 4f, 3f};

        PdfPTable workflowTable = new PdfPTable(columnWidths1);
        workflowTable.setWidthPercentage(100.0f);

        // Row 1
        // First Column - Initiating Dept. Label
        PdfPCell workflowCell1 = new PdfPCell();
        workflowCell1.setBackgroundColor(BaseColor.BLACK);
        workflowCell1.setPhrase(new Phrase("Initiating Dept.",headerfont));

        // Second Column - Initiating Department
        PdfPCell workflowCell2 = new PdfPCell();
        workflowCell2.setBackgroundColor(BaseColor.WHITE);
        workflowCell2.setPhrase(new Phrase(riskModelTemplate.getPurpose().getDescription(),valueFont));

        // Third Column - Initator Label
        PdfPCell workflowCell3 = new PdfPCell();
        workflowCell3.setBackgroundColor(BaseColor.BLACK);
        workflowCell3.setPhrase(new Phrase("Initiator",headerfont));

        // Fourth Column - Reviewed By Name
        PdfPCell workflowCell4 = new PdfPCell();
        workflowCell4.setBackgroundColor(BaseColor.WHITE);
        workflowCell4.setPhrase(new Phrase(riskModelTemplate.getCreatedBy()  ,valueFont));

        workflowTable.addCell(workflowCell1);
        workflowTable.addCell(workflowCell2);
        workflowTable.addCell(workflowCell3);
        workflowTable.addCell(workflowCell4);
        workflowTable.completeRow();

        // Row 6 - Risk Model Id
        // First Column - Risk Model Id
        workflowCell1 = new PdfPCell();
        workflowCell1.setBackgroundColor(BaseColor.BLACK);
        workflowCell1.setPhrase(new Phrase( "Risk Model Id." ,headerfont));

        // Second Column - Risk Model Id
        workflowCell2 = new PdfPCell();
        workflowCell2.setBackgroundColor(BaseColor.WHITE);
        workflowCell2.setPhrase(new Phrase(riskModelTemplate.getId().toString(),valueFont));

        // Third Column - Empty
        workflowCell3 = new PdfPCell();
        workflowCell3.setBackgroundColor(BaseColor.BLACK);
        workflowCell3.setPhrase(new Phrase(" ",valueFont));

        // Fourth Column - Empty
        workflowCell4 = new PdfPCell();
        workflowCell4.setBackgroundColor(BaseColor.WHITE);
        workflowCell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        workflowCell4.setVerticalAlignment(Element.ALIGN_CENTER);
        workflowCell4.setPhrase(new Phrase("", valueFont));


        workflowTable.addCell(workflowCell1);
        workflowTable.addCell(workflowCell2);
        workflowTable.addCell(workflowCell3);
        workflowTable.addCell(workflowCell4);
        workflowTable.completeRow();


        // Row 2
        // First Column - Department
        workflowCell1 = new PdfPCell();
        workflowCell1.setBackgroundColor(BaseColor.GRAY);
        workflowCell1.setPhrase(new Phrase("Department",headerfont));

        // Second Column - Processor
        workflowCell2 = new PdfPCell();
        workflowCell2.setBackgroundColor(BaseColor.GRAY);
        workflowCell2.setPhrase(new Phrase("Processor",headerfont));


        // Third Column - Initator Label
        workflowCell3 = new PdfPCell();
        workflowCell3.setBackgroundColor(BaseColor.GRAY);
        workflowCell3.setPhrase(new Phrase("Role",headerfont));

        // Fourth Column - Approval Status
        workflowCell4 = new PdfPCell();
        workflowCell4.setBackgroundColor(BaseColor.GRAY);
        workflowCell4.setPhrase(new Phrase("Approval Status" ,headerfont));

        workflowTable.addCell(workflowCell1);
        workflowTable.addCell(workflowCell2);
        workflowTable.addCell(workflowCell3);
        workflowTable.addCell(workflowCell4);
        workflowTable.completeRow();

        //WorkflowAssignment workflowAssignment = workflowAssignmentRepository.findByPurpose(riskModelTemplate.getPurpose());

        Boolean rejectFlagProcessed = false;
        Integer firstLevelApprovalStatus  = 1; //   1: Not Initiated 2: Initiated 3: Completed ; 4 : Rejected
        Integer secondLevelApprovalStatus = 1; //   1: Not Initiated 2: Initiated 3: Completed ; 4 : Rejected
        Integer thirdLevelApprovalStatus  = 1; //   1: Not Initiated 2: Initiated 3: Completed ; 4 : Rejected

        if (task != null) {

            Map<String, Object> processVariables = task.getProcessVariables();
            Boolean firstLevelApproval = (Boolean) processVariables.get("firstLevelApproval");
            Boolean secondLevelApproval = (Boolean) processVariables.get("secondLevelApproval");
            Boolean thirdLevelApproval = (Boolean) processVariables.get("thirdLevelApproval");

            String firstLevelApprovalReject = (String) processVariables.get("rejectedInFirstLevel");
            String secondLevelApprovalReject = (String) processVariables.get("rejectedInSecondLevel");
            String thirdLevelApprovalReject = (String) processVariables.get("rejectedInThirdLevel");

            if (riskModelTemplate.getWorkflowStatus().getCode().equals("02")) {
                firstLevelApprovalStatus = 2;
            }

            if (firstLevelApproval == true) {
                firstLevelApprovalStatus = 3;
            } else if (firstLevelApprovalReject.equals("X")) {
                firstLevelApprovalStatus = 4;
            }


            if (riskModelTemplate.getWorkflowStatus().getCode().equals("03") ){
                firstLevelApprovalStatus  = 3;
                secondLevelApprovalStatus = 2;
            }
            if (secondLevelApproval == true) {
                firstLevelApprovalStatus =  3;
                secondLevelApprovalStatus = 3;
                thirdLevelApprovalStatus = 2;
            } else if (secondLevelApprovalReject.equals("X")) {
                firstLevelApprovalStatus = 3;
                secondLevelApprovalStatus = 4;
            }


            if (riskModelTemplate.getWorkflowStatus().getCode().equals("07") ){
                firstLevelApprovalStatus = 3;
                secondLevelApprovalStatus = 3;
                thirdLevelApprovalStatus = 2;
            }
            if (thirdLevelApproval == true) {
                firstLevelApprovalStatus = 3;
                secondLevelApprovalStatus = 3;
                thirdLevelApprovalStatus = 3;
            } else if (thirdLevelApprovalReject.equals("X")) {
                firstLevelApprovalStatus = 3;
                secondLevelApprovalStatus = 3;
                thirdLevelApprovalStatus = 4;
            }

        }
        else {
            if (riskModelTemplate.getWorkflowStatus().getCode().equals("04")) {
                firstLevelApprovalStatus = 4;
                secondLevelApprovalStatus = 1;
                thirdLevelApprovalStatus = 1;
            }
        }

        if (riskModelTemplate.getWorkflowStatus().getCode().equals("08")) {
            firstLevelApprovalStatus = 3;
            secondLevelApprovalStatus = 3;
            thirdLevelApprovalStatus = 3;
        }

        // Row 3 - First LEVEL Approval
        // First Column - Department
        workflowCell1 = new PdfPCell();
        workflowCell1.setBackgroundColor(BaseColor.WHITE);
        workflowCell1.setPhrase(new Phrase( riskModelTemplate.getPurpose().getDescription() ,valueFont));

        // Second Column - First Level Approver Name
        workflowCell2 = new PdfPCell();
        workflowCell2.setBackgroundColor(BaseColor.WHITE);
        workflowCell2.setPhrase(new Phrase(workflowAssignment.getFirstLevelApproverName(),valueFont));

        // Third Column - Role
        workflowCell3 = new PdfPCell();
        workflowCell3.setBackgroundColor(BaseColor.WHITE);
        workflowCell3.setPhrase(new Phrase("Department Head",valueFont));

        // Fourth Column - Approval Status
        workflowCell4 = new PdfPCell();
        workflowCell4.setBackgroundColor(BaseColor.WHITE);
        workflowCell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        workflowCell4.setVerticalAlignment(Element.ALIGN_CENTER);


        workflowCell4 = getWorkFlowApprovalStatusCell(firstLevelApprovalStatus);

        workflowTable.addCell(workflowCell1);
        workflowTable.addCell(workflowCell2);
        workflowTable.addCell(workflowCell3);
        workflowTable.addCell(workflowCell4);
        workflowTable.completeRow();


        // Row 4 - Second Level Approval
        // First Column - Department
        workflowCell1 = new PdfPCell();
        workflowCell1.setBackgroundColor(BaseColor.WHITE);
        workflowCell1.setPhrase(new Phrase( "Risk" ,valueFont));

        // Second Column - First Level Approver Name
        workflowCell2 = new PdfPCell();
        workflowCell2.setBackgroundColor(BaseColor.WHITE);
        workflowCell2.setPhrase(new Phrase(workflowAssignment.getSecondLevelApproverName(),valueFont));

        // Third Column - Role
        workflowCell3 = new PdfPCell();
        workflowCell3.setBackgroundColor(BaseColor.WHITE);
        workflowCell3.setPhrase(new Phrase("Officer",valueFont));

        // Fourth Column - Approval Status
        workflowCell4 = new PdfPCell();
        workflowCell4.setBackgroundColor(BaseColor.WHITE);
        workflowCell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        workflowCell4.setVerticalAlignment(Element.ALIGN_CENTER);

        workflowCell4 = getWorkFlowApprovalStatusCell(secondLevelApprovalStatus);

        workflowTable.addCell(workflowCell1);
        workflowTable.addCell(workflowCell2);
        workflowTable.addCell(workflowCell3);
        workflowTable.addCell(workflowCell4);
        workflowTable.completeRow();




        // Row 5 - Third Level Approval
        // First Column - Department
        workflowCell1 = new PdfPCell();
        workflowCell1.setBackgroundColor(BaseColor.WHITE);
        workflowCell1.setPhrase(new Phrase( "Risk" ,valueFont));

        // Second Column - First Level Approver Name
        workflowCell2 = new PdfPCell();
        workflowCell2.setBackgroundColor(BaseColor.WHITE);
        workflowCell2.setPhrase(new Phrase(workflowAssignment.getThirdLevelApproverName(),valueFont));

        // Third Column - Role
        workflowCell3 = new PdfPCell();
        workflowCell3.setBackgroundColor(BaseColor.WHITE);
        workflowCell3.setPhrase(new Phrase("Department Head",valueFont));

        // Fourth Column - Approval Status
        workflowCell4 = new PdfPCell();
        workflowCell4.setBackgroundColor(BaseColor.WHITE);
        workflowCell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        workflowCell4.setVerticalAlignment(Element.ALIGN_CENTER);

        workflowCell4 = getWorkFlowApprovalStatusCell(thirdLevelApprovalStatus);


        workflowTable.addCell(workflowCell1);
        workflowTable.addCell(workflowCell2);
        workflowTable.addCell(workflowCell3);
        workflowTable.addCell(workflowCell4);
        workflowTable.completeRow();




        doc.add(workflowTable);
        return doc;
    }


    private PdfPCell getWorkFlowApprovalStatusCell ( Integer status ) throws Exception {

        // Value Font
        Font valueFont = new Font(Font.FontFamily.HELVETICA);
        valueFont.setColor(BaseColor.BLACK);
        valueFont.setSize(8);


        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.WHITE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);

        switch (status) {
            case 1: // Not Initiated
                cell.setBackgroundColor(BaseColor.WHITE);
                cell.setPhrase(new Phrase(" ", valueFont));
                break;
            case 2: //Initiated
                cell.setBackgroundColor(BaseColor.YELLOW.brighter().brighter());
                cell.setPhrase(new Phrase("-", valueFont));
                break;
            case 3:
                cell.setBackgroundColor(BaseColor.GREEN.brighter().brighter());
                cell.addElement(this.getTickImage());
                break;
            case 4:
                cell.setBackgroundColor(BaseColor.RED.brighter().brighter());
                cell.addElement(this.getCrossImage());
                break;
        }
        return cell;
    }
}


//
//// First Level Approval Status
//        if (riskModelTemplate.getWorkflowStatus().getCode().equals("02")) {
//                firstLevelApprovalStatus = 2;
//                }
//                if (    riskModelTemplate.getWorkflowStatus().getCode().equals("03") ||
//                riskModelTemplate.getWorkflowStatus().getCode().equals("05") ||
//                riskModelTemplate.getWorkflowStatus().getCode().equals("06") ||
//                riskModelTemplate.getWorkflowStatus().getCode().equals("07") ||
//                riskModelTemplate.getWorkflowStatus().getCode().equals("08")) {
//                firstLevelApprovalStatus = 3;
//                }
//
//                if (riskModelTemplate.getWorkflowStatus().getCode().equals("05")) {
//                secondLevelApprovalStatus = 2;
//                }
//
//                // Second Level Approval Status
//                if (riskModelTemplate.getWorkflowStatus().getCode().equals("03")) { // First Level Approval Completed
//                secondLevelApprovalStatus = 2;
//                }
//
//                if (    riskModelTemplate.getWorkflowStatus().getCode().equals("06") ||   //Second Level Approval Completed
//                riskModelTemplate.getWorkflowStatus().getCode().equals("07") ||   //Sent for Third Level Approval
//                riskModelTemplate.getWorkflowStatus().getCode().equals("08")) {   //Third Level Approval Completed
//                secondLevelApprovalStatus = 3;
//                }
//                if (riskModelTemplate.getWorkflowStatus().getCode().equals("07")) { //Sent for Third Level Approval
//                thirdLevelApprovalStatus = 2;
//                }
//
//                // Third Level Approval Status
//                if (riskModelTemplate.getWorkflowStatus().getCode().equals("08")) {
//                thirdLevelApprovalStatus = 3;
//                }
//
//                if (riskModelTemplate.getCurrentWorkFlowLevel() != null) {
//                switch (riskModelTemplate.getCurrentWorkFlowLevel()) {
//                case 1:
//                if (riskModelTemplate.getWorkflowStatus().getCode().equals("04")) {
//                secondLevelApprovalStatus = 4;
//                firstLevelApprovalStatus = 3;
//                break;
//                }
//                case 2:
//                if (riskModelTemplate.getWorkflowStatus().getCode().equals("04")) {
//                firstLevelApprovalStatus = 3;
//                secondLevelApprovalStatus = 3;
//                thirdLevelApprovalStatus = 4;
//                }
//                break;
//                }
//                } else {
//                if (riskModelTemplate.getWorkflowStatus().getCode().equals("04")) {
//                firstLevelApprovalStatus = 4;
//                }
//                }

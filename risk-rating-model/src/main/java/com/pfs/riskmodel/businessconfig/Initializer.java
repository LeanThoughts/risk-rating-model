package com.pfs.riskmodel.businessconfig;

import com.pfs.riskmodel.dao.WorkflowAssignmentDao;
import com.pfs.riskmodel.domain.*;
import com.pfs.riskmodel.repository.*;
import com.pfs.riskmodel.service.IWorkflowAssignmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by sajeev on 17-Dec-18.
 */
@Slf4j
@Component
@RequiredArgsConstructor



public class Initializer implements CommandLineRunner{

    @Autowired
    private final ComputingMethodRepository computingMethodRepository;
    @Autowired
    private final ScoreTypeRepository scoreTypeRepository;
    @Autowired
    private final RiskProjectTypeRepository riskProjectTypeRepository;
    @Autowired
    private final ProjectRiskLevelRepository projectRiskLevelRepository;
    @Autowired
    private final ModelCategoryRepository modelCategoryRepository;
    @Autowired
    private final RatingModifierComputingMethodRepository riskRatingComputingMethodRepository;
    @Autowired
    private final RiskPurposeRepository purposeRepository;
    @Autowired
    private final WorkflowStatusRepository workflowStatusRepository;
    @Autowired
    private final WorkflowAssignmentRepository workflowAssignmentRepository;

    @Autowired
    private final RiskPurposeRepository riskPurposeRepository;

    @Autowired
    private Environment environment;

    @Autowired
    private WorkflowAssignmentDao workflowAssignmentDao;

    @Autowired
    private IWorkflowAssignmentService workflowAssignmentService;

    @Override
    public void run(String... strings) throws Exception {

        System.out.println("-------------------------- Adding Model Category  data");


        if(modelCategoryRepository.count() == 0) {
            ModelCategory  c1 = new ModelCategory(1, "Renewable-Build");
            ModelCategory  c2 = new ModelCategory( 2,"Renewable-Operational");
            ModelCategory  c3 = new ModelCategory(  3,"InfraTransmission-Build");
            ModelCategory  c4 = new ModelCategory( 4,"InfraTransmission-Operational");
            ModelCategory  c5 = new ModelCategory( 5,"InfraRoadProjectHybridAnnuity-Build");
            ModelCategory  c6 = new ModelCategory( 6,"InfraRoadProjectHybridAnnuity-Operational");
            ModelCategory  c7 = new ModelCategory( 7,"InfraRoadProjectToll-Build");
            ModelCategory  c8 = new ModelCategory( 8,"InfraRoadProjectToll-Operational");
            ModelCategory  c9 = new ModelCategory( 9,"HoldingCompany-Build");
            ModelCategory  c10 = new ModelCategory( 10,"HoldingCompany-Operational");


            modelCategoryRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10));
            log.info("-------------------------- Added Model Category  data");
        }

        System.out.println("-------------------------- Adding computingMethodRepository ");


        if(computingMethodRepository.count() == 0) {
            ComputingMethod  c1 = new ComputingMethod(null,"01", "Weighted");
            ComputingMethod  c2 = new ComputingMethod(null,"02", "Sum");
            ComputingMethod  c3 = new ComputingMethod(null,"03", "Minimum");
            ComputingMethod  c4 = new ComputingMethod(null,"04", "Maximum");
            ComputingMethod  c5 = new ComputingMethod(null,"05", "Equals");
            ComputingMethod  c6 = new ComputingMethod(null,"06", "Multiply");


            computingMethodRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6));
            log.info("-------------------------- Added Computing Methods data");
        }

        System.out.println("-------------------------- Adding scoreTypeRepository ");

        if (scoreTypeRepository.count() == 0) {
            ScoreType s1 = new ScoreType(null,"01","Normal");
            ScoreType s2 = new ScoreType(null,"02","Deflator");
            ScoreType s3 = new ScoreType(null,"03","Multiplier");

            scoreTypeRepository.saveAll(Arrays.asList( s1,s2,s3));
            log.info("-------------------------- Added Score Types data");


        }
        System.out.println("-------------------------- Adding riskProjectTypeRepository ");


        if(riskProjectTypeRepository.count() == 0) {
            RiskProjectType p1 = new RiskProjectType(null,"01", "Renewable Project");
            RiskProjectType p2 = new RiskProjectType(null,"02", "Infrastructure Transmission Project");
            RiskProjectType p3 = new RiskProjectType(null,"03", "Infrastructure Road Project – Hybrid Annuity");
            RiskProjectType p4 = new RiskProjectType(null,"04", "Infrastrucutre Road Project - Toll ");
            RiskProjectType p5 = new RiskProjectType(null,"05", "Holding Company");



            riskProjectTypeRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
            log.info("-------------------------- Added project Type   data");
        }

        System.out.println("-------------------------- Adding projectRiskLevelRepository ");

        if(projectRiskLevelRepository.count() == 0) {
            ProjectRiskLevel p1 = new ProjectRiskLevel(null,"01", "Build Phase ");
            ProjectRiskLevel  p2 = new ProjectRiskLevel(null,"02", "Operational Phase");



            projectRiskLevelRepository.saveAll(Arrays.asList(p1,p2 ));
            log.info("-------------------------- Added project Risk Level (Phases) data");
        }

        ProjectRiskLevel p1 = projectRiskLevelRepository.findByCode("01");
        if (p1 !=null){
            p1.setValue("Build Phase");
            projectRiskLevelRepository.save(p1);
        }

        ProjectRiskLevel p2 = projectRiskLevelRepository.findByCode("02");
        if (p2 !=null){
            p2.setValue("Operational Phase");
            projectRiskLevelRepository.save(p2);
        }


        System.out.println("-------------------------- Adding riskRatingComputingMethodRepository ");


        if(riskRatingComputingMethodRepository.count() == 0) {

            //Modifiers to cap final ratings at sub-investment grade
            RatingModifierComputationMethod  m1 = new RatingModifierComputationMethod(null,"01", "On Select Any One - Notch Down to Sub Investment Grade");
            // Modifiers having impact on final ratings up to 2 notches
            RatingModifierComputationMethod m2 = new RatingModifierComputationMethod(null,"02", "Notch Down By Selection- OneorTwoBYOne, MoreThanThree By Two");

            riskRatingComputingMethodRepository.saveAll(Arrays.asList(m1,m2 ));
            log.info("-------------------------- Added Risk Rating Modifier Computing Method data");
        }



        if(purposeRepository.count() == 0) {

            RiskPurpose r1 = new RiskPurpose(null, "01", "Project Assessment");
            RiskPurpose r2 = new RiskPurpose(null, "02", "Risk Assessment");
            RiskPurpose r3 = new RiskPurpose(null, "03", "Monitoring");


            purposeRepository.saveAll(Arrays.asList(r1,r2,r3 ));
            log.info("-------------------------- Added Purposes data");
        }

        WorkflowStatus w1 = new WorkflowStatus();

        HashMap<String, String> workflowStatus = new HashMap<>();
        workflowStatus.put("01","Created");
        workflowStatus.put("02","Sent for 1st Level Approval");
        workflowStatus.put("03", "First Lvl Approval Completed");
        workflowStatus.put( "04", "Rejected");
        workflowStatus.put( "05", "Sent for 2nd Level Approval");
        workflowStatus.put( "06", "Second Lvl Approval Completed");
        workflowStatus.put( "07", "Sent for Third Level Approval");
        workflowStatus.put( "08", "Third Lvl Approval Completed");

            Integer codeAsInt = 1;
            for (Integer i=0; i<=7; i++) {

                String code = "0" + codeAsInt.toString();

                if (workflowStatusRepository.findByCode(code) == null)
                    w1 = new WorkflowStatus(null,code , workflowStatus.get(code));
                else {
                    w1 = workflowStatusRepository.findByCode(code);
                    w1.setDescription(workflowStatus.get(code));
                }

                workflowStatusRepository.save(w1);
                codeAsInt ++;

                log.info("-------------------------- Added Work Flow Status: " + w1.toString());
             }



        //if(workflowAssignmentRepository.count() == 0) {


           if (riskPurposeRepository.count() == 0) {
               System.out.println( "-------------------------- Starting to add Risk Purpose----------------------");

               RiskPurpose r1 = riskPurposeRepository.findByCode("01");
               if (r1 == null)
                   r1 = new RiskPurpose(null, "01", "Project");

               RiskPurpose r2 = riskPurposeRepository.findByCode("02");
               if (r2 == null) {
                   r2 = new RiskPurpose(null, "02", "Risk");
               }
               RiskPurpose r3 = riskPurposeRepository.findByCode("03");
               if (r3 == null) {
                   r3 = new RiskPurpose(null, "03", "Monitoring");
               }

               System.out.println("Risk Purpose :" + r1.toString());
               r1 = riskPurposeRepository.saveAndFlush(r1);
               System.out.println("-------------------------- Saved Risk Purpose :" + r1.toString());

               System.out.println("Risk Purpose :" + r2.toString());
               r2 = riskPurposeRepository.saveAndFlush(r2);
               System.out.println("-------------------------- Saved Risk Purpose :" + r2.toString());


               System.out.println("Risk Purpose :" + r3.toString());
               r3 = riskPurposeRepository.saveAndFlush(r3);
               System.out.println("-------------------------- Saved Risk Purpose :" + r3.toString());
           }

        WorkflowAssignment wa1 = new WorkflowAssignment();
        WorkflowAssignment wa2 = new WorkflowAssignment();;
        WorkflowAssignment wa3 = new WorkflowAssignment();;



        System.out.println(" ");
        System.out.println(" ");
        System.out.println( "-------------------------------------------------------------------------------------");
        System.out.println( "-------------------------- Starting to add Workflow Assignments----------------------");

        RiskPurpose  r1 = riskPurposeRepository.findByCode("01");

        System.out.println("  Risk Purpose for code 01: " + r1.getDescription());

        Date validFromDate = new Date();
        validFromDate = new GregorianCalendar(2001, Calendar.JANUARY, 01).getTime();
        Date validToDate = new Date();
        validToDate = new GregorianCalendar(2021, Calendar.OCTOBER, 22).getTime();


        //Workflow Assignment is changed from October 23rd. Therefore, fetch the assignment between Jan 1st 2001 and Oct 23rd 2021
        Date riskEvaluationDate = new GregorianCalendar(2021, Calendar.OCTOBER, 21).getTime();

        if (r1 != null) {


            wa1 = workflowAssignmentService.getWorkFlowAssignmentForEvaluationDateAndPurpose(riskEvaluationDate, r1);

            if (wa1 == null) {
                System.out.println(" Workflow Assignment Not Found for Risk Purpose " + r1.getDescription());
                System.out.println("-------------------------- Starting to add Workflow Assignments----------------------");



                wa1 = new WorkflowAssignment(null, r1, validFromDate,validToDate, "Sitesh Kumar Sinha", "sksinha@ptcfinancial.com",
                        "Neeraj Yadav", "neerajyadav@ptcfinancial.com",
                        "Devesh Singh", "devesh@ptcfinancial.com");

            } else {
                System.out.println(" Workflow Assignment Found for Risk Purpose " + r1.getDescription());
                wa1.setPurpose(r1);
                wa1.setValidFromDate(validFromDate);
                wa1.setValidToDate(validToDate);
                wa1.setFirstLevelApproverEmailId("sksinha@ptcfinancial.com");
                wa1.setFirstLevelApproverName("Sitesh Kumar Sinha");
                wa1.setSecondLevelApproverEmailId("neerajyadav@ptcfinancial.com");
                wa1.setSecondLevelApproverName("Neeraj Yadav");
                wa1.setThirdLevelApproverEmailId("devesh@ptcfinancial.com");
                wa1.setThirdLevelApproverName("Devesh Singh");
            }

            System.out.println(" Saving Workflow Assingment 1 :" + wa1.toString());
            workflowAssignmentRepository.save(wa1);
        }


        RiskPurpose r2 = riskPurposeRepository.findByCode("03");

        if( r2 != null) {

            wa2 = workflowAssignmentService.getWorkFlowAssignmentForEvaluationDateAndPurpose(riskEvaluationDate, r2);

            if (wa2 == null) {
                System.out.println(" Workflow Assignment Not Found for Risk Purpose " + r2.getDescription());

                wa2 = new WorkflowAssignment(null, r2,validFromDate,validToDate, "Rony Mahajan", "pfsprojecthead@gmail.com",
                        "Neeraj Yadav", "neerajyadav@ptcfinancial.com",
                        "Devesh Singh", "devesh@ptcfinancial.com");
            } else {
                wa1.setPurpose(r2);
                wa1.setValidFromDate(validFromDate);
                wa1.setValidToDate(validToDate);
                wa2.setFirstLevelApproverEmailId("rony.mahajan@ptcfinancial.com");
                wa2.setFirstLevelApproverName("Rony Mahajan");
                wa2.setSecondLevelApproverEmailId("neerajyadav@ptcfinancial.com");
                wa2.setSecondLevelApproverName("Neeraj Yadav");
                wa2.setThirdLevelApproverEmailId("devesh@ptcfinancial.com");
                wa2.setThirdLevelApproverName("Devesh Singh");
            }

            System.out.println(" Saving Workflow Assingment 2 :" + wa2.toString());
            workflowAssignmentRepository.save(wa2);

        }

        RiskPurpose r3 = riskPurposeRepository.findByCode("03");

        wa3 = workflowAssignmentService.getWorkFlowAssignmentForEvaluationDateAndPurpose(riskEvaluationDate, r3);

            if (wa3 == null) {
                wa3 = new WorkflowAssignment(null,r3,validFromDate,validToDate,"","","","","","");
            } else{
                wa3 = new WorkflowAssignment(null, r3,validFromDate,validToDate, "","","","","","");
            }
           // workflowAssignmentRepository.save(wa3);


        log.info("Workflow Assignments - Changed as of  October 23 2021");
        //Workflow Assignment is changed from October 23rd. Therefore, fetch the assignment after and Oct 23rd 2021
         riskEvaluationDate = new GregorianCalendar(2021, Calendar.OCTOBER, 25).getTime();

        validFromDate = new Date();
        validFromDate = new GregorianCalendar(2001, Calendar.OCTOBER, 23).getTime();
        validToDate = new Date(); // Set it is as 31st Dec 9999
        validToDate = new GregorianCalendar(9999, Calendar.DECEMBER, 31).getTime();


        WorkflowAssignment  wa4 = workflowAssignmentService.getWorkFlowAssignmentForEvaluationDateAndPurpose(riskEvaluationDate, r1);

        if (wa4 == null) {
            System.out.println(" Revised Workflow Assignment Not Found for Risk Purpose " + r1.getDescription());
            System.out.println("-------------------------- Starting to add Workflow Assignments----------------------");



            wa4 = new WorkflowAssignment(null, r1, validFromDate,validToDate, "Sitesh Kumar Sinha", "sksinha@ptcfinancial.com",
                    "Ankit Nagarnaik", "ankit.nagarnaik@ptcfinancial.com",
                    "Devesh Singh", "devesh@ptcfinancial.com");

        } else {
            System.out.println(" Workflow Assignment Found for Risk Purpose " + r1.getDescription());
            wa4.setPurpose(r1);
            wa4.setValidFromDate(validFromDate);
            wa4.setValidToDate(validToDate);
            wa4.setFirstLevelApproverEmailId("sksinha@ptcfinancial.com");
            wa4.setFirstLevelApproverName("Sitesh Kumar Sinha");
            wa4.setSecondLevelApproverEmailId("ankit.nagarnaik@ptcfinancial.com");
            wa4.setSecondLevelApproverName("Ankit Nagarnaik");
            wa4.setThirdLevelApproverEmailId("devesh@ptcfinancial.com");
            wa4.setThirdLevelApproverName("Devesh Singh");
        }

        System.out.println(" Saving Workflow Assingment 4 :" + wa4.toString());
        workflowAssignmentRepository.save(wa4);


        WorkflowAssignment  wa5 = workflowAssignmentService.getWorkFlowAssignmentForEvaluationDateAndPurpose(riskEvaluationDate, r2);

        if (wa5 == null) {
            System.out.println(" Revised Workflow Assignment Not Found for Risk Purpose " + r2.getDescription());
            System.out.println("-------------------------- Starting to add Workflow Assignments----------------------");

            validToDate = new GregorianCalendar(9999, Calendar.MAY, 26).getTime();


            wa5 = new WorkflowAssignment(null, r2, validFromDate,validToDate, "Shray Shikhar", "shikhar@ptcfinancial.com",
                    "Ankit Nagarnaik", "ankit.nagarnaik@ptcfinancial.com",
                    "Devesh Singh", "devesh@ptcfinancial.com");

        } else {
            System.out.println(" Workflow Assignment Found for Risk Purpose " + r2.getDescription());
            wa5.setPurpose(r2);
            wa5.setValidFromDate(validFromDate);
            wa5.setValidToDate(validToDate);
            wa5.setFirstLevelApproverEmailId("shikhar@ptcfinancial.com");
            wa5.setFirstLevelApproverName("Shray Shikhar");
            wa5.setSecondLevelApproverEmailId("ankit.nagarnaik@ptcfinancial.com");
            wa5.setSecondLevelApproverName("Ankit Nagarnaik");
            wa5.setThirdLevelApproverEmailId("devesh@ptcfinancial.com");
            wa5.setThirdLevelApproverName("Devesh Singh");
        }

        System.out.println(" Saving Workflow Assingment 5 :" + wa5.toString());
        workflowAssignmentRepository.save(wa5);





        List<WorkflowAssignment> workflowAssignmentList = workflowAssignmentRepository.findAll();
        log.info("Running with the following Workflow Assignments");
        for (WorkflowAssignment workflowAssignment: workflowAssignmentList
             ) {
            log.info(workflowAssignment.toString());

        }

   }
}

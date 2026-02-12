package com.pfs.riskmodel.businessconfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajeev on 31-Dec-18.
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class SME_FI_BuildPhaseGrade implements CommandLineRunner {


     public   static  List<ProjectGrade> projectGradeList;

    @Override
    public void run(String... strings) throws Exception {

        if ( projectGradeList == null){
             projectGradeList = new ArrayList<>();
        }

        ProjectGrade p1 = new ProjectGrade(1,"11",0.0D,1.85,"Default","GRADE 10",10);
        ProjectGrade p2 = new ProjectGrade(2,"11",1.85,2.85,"Sub Investment","GRADE 9",9);
        ProjectGrade p3 = new ProjectGrade(3,"11",2.85,3.85,"Sub Investment","GRADE 8",8);
        ProjectGrade p4 = new ProjectGrade(3,"11",3.85,4.85,"Sub Investment","GRADE 7",7);
        ProjectGrade p5 = new ProjectGrade(4,"11",4.85,5.85,"Sub Investment","GRADE 6",6);
        ProjectGrade p6 = new ProjectGrade(5,"11",5.85,7.50,"Sub Investment","GRADE 5",5);
        ProjectGrade p7 = new ProjectGrade(6,"11",7.50,8.00,"Investment","GRADE 4",4);
        ProjectGrade p8 = new ProjectGrade(7,"11",8.00,9.00,"Investment","GRADE 3",3);
        ProjectGrade p9 = new ProjectGrade(8,"11",9.00,9.5,"Investment","GRADE 2",2);
        ProjectGrade p10 = new ProjectGrade(9,"11",9.50,10.0,"Investment","GRADE 1",1);

        projectGradeList.add(p1);
        projectGradeList.add(p2);
        projectGradeList.add(p3);
        projectGradeList.add(p4);
        projectGradeList.add(p5);
        projectGradeList.add(p6);
        projectGradeList.add(p7);

        projectGradeList.add(p8);

        projectGradeList.add(p9);
        projectGradeList.add(p10);
    }



}

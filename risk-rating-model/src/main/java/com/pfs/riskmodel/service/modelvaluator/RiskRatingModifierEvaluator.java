package com.pfs.riskmodel.service.modelvaluator;

import com.pfs.riskmodel.domain.*;

import java.util.List;

/**
 * Created by sajeev on 30-Dec-18.
 */
public class RiskRatingModifierEvaluator {

    Double riskRatingModifierScore;

    public RiskRatingModifier evaluateRiskRatingModifier(RiskRatingModifier riskRatingModifier, RiskModelTemplate riskModelTemplate) {


        Boolean subInvestmentGradeCapping = false;
        Integer numberOfNotchesDown = 0;
        Integer numberOfNotchesDownItems = 0;

        for (RiskRatingModifierAttribute riskRatingModifierAttribute:riskRatingModifier.getRiskRatingModifierAttributes()){

               /*
                  Modifier Type 0 is for SubInvestment GRADE Capping
                    In case any of these modifiers are true for an entity,
                     then the lender may cap the final ratings of the entity at the sub-investment grades.
               */
                         if (riskRatingModifier.getModifierType() == 0) {
                 if (riskRatingModifierAttribute.getYesOrNoIndicator().equals('Y') ){
                     subInvestmentGradeCapping = true;
                     riskRatingModifier.setIsApplicable(true);
                     break;
                 } else
                     riskRatingModifier.setIsApplicable(false);
             }


            /* Modifier Type 1 is used for Notch Down - Change done as per issue reported on April 2nd 2019
                 In case 3 or 4 modifiers are true for an entity,
                        then the lender may downgrade the final ratings of the entity by one notch.
                 In case 5 or 6 modifiers are true,
                        the final rating may be downgraded by two notches.
             */
             if (riskRatingModifier.getModifierType() == 1) {

                 if (riskRatingModifierAttribute.getYesOrNoIndicator().equals('Y')) {
                     numberOfNotchesDownItems += 1;
                 }
             }

        }

        riskRatingModifier.setCountOfDowngradeBy1or2Notches(numberOfNotchesDownItems);
        /*
           - Change done as per issue reported on Nov 29 2021
            BUILD PHASE
            -	In case three or four modifiers are true for an entity then the lender may downgrade the final ratings of the entity by one notch
            -	In case five or six modifiers are true, the final rating may be downgraded by two notches
            OPERATIONAL PHASE
                -	In case One or Two modifiers are true for an entity then the lender may downgrade the final ratings of the entity by one notch.
                -	In case Three or Four modifiers are true, the final rating may be downgraded by two notches.
             */
        if (riskModelTemplate.getProjectRiskLevel().getCode().toString().equals("01")) // Build Phase
        {
            if (numberOfNotchesDownItems == 3 || numberOfNotchesDownItems == 4)
                numberOfNotchesDown = 1;
            if (numberOfNotchesDownItems == 5 || numberOfNotchesDownItems == 6)
                numberOfNotchesDown = 2;
        } else {                                                                      // Operational Phase
            if (numberOfNotchesDownItems == 1 || numberOfNotchesDownItems == 2)
                numberOfNotchesDown = 1;
            if (numberOfNotchesDownItems == 3 || numberOfNotchesDownItems == 4)
                numberOfNotchesDown = 2;
        }

        riskRatingModifier.setNumberOfNotchesDown(numberOfNotchesDown);
        riskRatingModifier.setNumberOfNotchesDownGraded(numberOfNotchesDown);


        if (riskRatingModifier.getModifierType() == 0)
           riskRatingModifier.setSubInvestmentGradeCapping(subInvestmentGradeCapping);

        if (riskRatingModifier.getModifierType() == 1)
            riskRatingModifier.setNumberOfNotchesDown(numberOfNotchesDown);

         return riskRatingModifier;


    }








}

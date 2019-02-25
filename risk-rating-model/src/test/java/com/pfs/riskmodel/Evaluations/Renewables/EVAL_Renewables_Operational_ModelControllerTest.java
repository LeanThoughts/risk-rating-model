package com.pfs.riskmodel.Evaluations.Renewables;

import com.pfs.riskmodel.AbstractTest;
import com.pfs.riskmodel.Evaluations.Eval_InfraRoadHAM.Evaluate_InfraRoadHAM_OperationalPhaseData;
import com.pfs.riskmodel.dto.RiskModelTemplateDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

/**
 * Created by sajeev on 18-Dec-18.
 */
public class EVAL_Renewables_Operational_ModelControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }


    @Test
    public void test () throws Exception {
    }

   // @Test
    public void evaluate_REN_OP_PHASE () throws Exception {
        String uri = "/api/riskModel?action=1";


        RiskModelTemplateDTO riskModelTemplateDTO = new RiskModelTemplateDTO();

        Evaluate_Renewables_OperationalPhaseData evaluate_renewables_operationalPhaseData
                = new Evaluate_Renewables_OperationalPhaseData() ;
        riskModelTemplateDTO = evaluate_renewables_operationalPhaseData.getRenewablesOperationalPhaseData();

        String inputJson = super.mapToJson(riskModelTemplateDTO);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();



        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

        System.out.println(content);


        //String jsonOutput = mapToJSON(content);

        //System.out.println(jsonOutput);

      //  RiskSubFactorAttribute[] riskSubFactorAttributes = super.mapFromJson(content, RiskSubFactorAttribute[].class );



    }




}

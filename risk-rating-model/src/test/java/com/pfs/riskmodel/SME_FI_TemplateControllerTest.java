package com.pfs.riskmodel;

import com.pfs.riskmodel.ModelTemplates.Renewable.BuildPhase.RenewableProjectBuildPhaseData;
import com.pfs.riskmodel.ModelTemplates.SME_FI.BuildPhase.SME_FI_BuildPhaseData;
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
public class SME_FI_TemplateControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }



    @Test
    public void test () throws Exception {
    }

   // @Test
    public void createRiskModelTemplate() throws Exception {
        String uri = "/api/riskModelTemplate";



        RiskModelTemplateDTO riskModelTemplateDTO = new RiskModelTemplateDTO();

        SME_FI_BuildPhaseData sme_fi_buildPhaseData = new SME_FI_BuildPhaseData() ;


        riskModelTemplateDTO = sme_fi_buildPhaseData.getSME_FI_BuildPhaseData();

        String inputJson = super.mapToJson(riskModelTemplateDTO);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();



        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

        //String jsonOutput = mapToJSON(content);

        //System.out.println(jsonOutput);

      //  RiskSubFactorAttribute[] riskSubFactorAttributes = super.mapFromJson(content, RiskSubFactorAttribute[].class );



    }




}

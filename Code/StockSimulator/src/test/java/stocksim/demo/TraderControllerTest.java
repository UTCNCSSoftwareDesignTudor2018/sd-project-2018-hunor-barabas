package stocksim.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import stocksim.demo.controller.TraderController;
import stocksim.demo.persistence.entity.Trader;
import stocksim.demo.persistence.entity.Wallet;
import stocksim.demo.service.TraderService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TraderController.class, secure = false)
public class TraderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TraderService traderService;

    private List<Wallet> walletList = new ArrayList<>();

   /* Trader mockTrader = new Trader("TestGuy","testuser","testpw",walletList);

    @Test
    public void findById() throws Exception{
        Mockito.when(
                traderService.findById(Mockito.anyInt())).thenReturn(mockTrader);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trader1").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{name:TestGuy,username:testuser,password:testpw}";

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }
    */
}

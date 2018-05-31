package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import stocksim.demo.AbstractTest;
import stocksim.demo.persistence.entity.Trader;
import stocksim.demo.service.TraderService;

import java.util.List;

public class TraderServiceTest extends AbstractTest {

    @Autowired
    private TraderService traderService;

    @Test
    public void testFindAll(){

        List<Trader> list = traderService.getAllTraders();

        Assert.assertNotNull("failure, expected not null",list);
    }
}

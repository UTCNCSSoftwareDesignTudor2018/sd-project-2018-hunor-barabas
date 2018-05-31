package stocksim.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import stocksim.demo.persistence.entity.Stock;
import stocksim.demo.service.StockService;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @RequestMapping(value = "/stocks",method = RequestMethod.GET)
    public ModelAndView viewStocks()
    {
        List<Stock> stockList = stockService.getAllStocks();

        ModelAndView mav = new ModelAndView("stock_template");
        mav.addObject("stockList", stockList);

        return mav;
    }




}

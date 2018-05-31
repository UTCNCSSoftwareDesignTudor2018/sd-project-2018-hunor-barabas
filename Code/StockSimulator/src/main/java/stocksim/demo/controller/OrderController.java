package stocksim.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import stocksim.demo.persistence.entity.Order;
import stocksim.demo.persistence.entity.Stock;
import stocksim.demo.persistence.entity.Wallet;
import stocksim.demo.service.OrderService;
import stocksim.demo.service.StockService;
import stocksim.demo.service.TraderService;
import stocksim.demo.service.WalletService;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    TraderService traderService;

    @Autowired
    StockService stockService;


    /*


     @RequestMapping(value = "/trader/{id}/orders",method = RequestMethod.POST)
    public ModelAndView makeOrder(@PathVariable String id){



       // orderService.findAllByTrader(traderService.findById(Integer.parseInt(id)));

        return new ModelAndView("redirect:/trader/{id}/orders");
    }

    @RequestMapping(value = "/trader/{id}/wallet/{wid}/order",method = RequestMethod.GET)
    public ModelAndView viewCourses(@PathVariable String id)
    {
        List<Stock> stockList = stockService.getAllStocks();
        ModelAndView mav = new ModelAndView("order_template");
        mav.addObject("stockList", stockList);

        return mav;
    }
    */




}

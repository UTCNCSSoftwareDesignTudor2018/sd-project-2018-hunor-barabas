package stocksim.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import stocksim.demo.persistence.entity.Order;
import stocksim.demo.persistence.entity.Stock;
import stocksim.demo.persistence.entity.Wallet;
import stocksim.demo.service.OrderService;
import stocksim.demo.service.StockService;
import stocksim.demo.service.WalletService;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    WalletService walletService;

    @Autowired
    StockService stockService;


     @RequestMapping(value = "/trader/{id}/wallet/{wid}/order",method = RequestMethod.POST)
    public ModelAndView makeOrder(@RequestBody Order order, @PathVariable String wid, @RequestParam Integer stockid, @RequestParam Integer amount){

        Wallet wallet = walletService.findById(Integer.parseInt(wid));
        Stock stock = stockService.findById(stockid);

        orderService.makeOrder(wallet,stock,amount);

        return new ModelAndView("redirect:/trader/{id}/wallet/{wid}");
    }

    @RequestMapping(value = "/trader/{id}/wallet/{wid}/order",method = RequestMethod.GET)
    public ModelAndView viewCourses(@PathVariable String id)
    {
        List<Stock> stockList = stockService.getAllStocks();

        ModelAndView mav = new ModelAndView("order_template");
        mav.addObject("stockList", stockList);

        return mav;
    }


}

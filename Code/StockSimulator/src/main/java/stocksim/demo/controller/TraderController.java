package stocksim.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import stocksim.demo.persistence.entity.Stock;
import stocksim.demo.persistence.entity.Trader;
import stocksim.demo.persistence.entity.Wallet;
import stocksim.demo.service.OrderService;
import stocksim.demo.service.TraderService;
import stocksim.demo.service.WalletService;

import java.util.List;

@RestController
public class TraderController {

    @Autowired
    TraderService traderService;

    @Autowired
    WalletService walletService;

    @RequestMapping(value = "/trader/{id}",method = RequestMethod.GET)
    public ModelAndView viewWallets(@PathVariable String id)
    {
        Trader t = traderService.findById(Integer.parseInt(id));
        System.out.println(t.toString());
        List<Wallet> walletList = walletService.findByTrader(t);

        ModelAndView mav = new ModelAndView("trader_template");
        mav.addObject("trader",t);
        mav.addObject("wallets",walletList);

        return mav;
    }

   /* @RequestMapping(value = "/trader/{id}",method = RequestMethod.POST)
    public ModelAndView viewCourses(@PathVariable String id, @ModelAttribute(value="walletid") @RequestParam Integer walletid)
    {

        return new ModelAndView("redirect:/trader/{id}/wallet/{walletid}");
    }
    */



}

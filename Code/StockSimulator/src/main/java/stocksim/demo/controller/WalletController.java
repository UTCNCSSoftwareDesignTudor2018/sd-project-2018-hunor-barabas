package stocksim.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import stocksim.demo.persistence.entity.Stock;
import stocksim.demo.persistence.entity.Wallet;
import stocksim.demo.service.WalletService;

import java.util.List;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    @RequestMapping(value = "/trader{id}/wallet/{wid}",method = RequestMethod.GET)
    public ModelAndView viewCourses(@PathVariable String id,@PathVariable String wid)
    {
        Wallet wallet = walletService.findById(Integer.parseInt(wid));
        Stock stock = wallet.getStock();

        ModelAndView mav = new ModelAndView("wallet_template");
        mav.addObject("stock",stock);
       // mav.addObject("enrollmentList",enrollmentList);

        return mav;
    }

    @RequestMapping(value = "/trader{id}/wallet/{wid}",method = RequestMethod.POST)
    public ModelAndView toOrder()
    {

        return new ModelAndView("redirect:/trader/{id}/wallet/{wid}/order");
    }
}

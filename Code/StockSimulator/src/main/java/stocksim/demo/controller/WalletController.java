package stocksim.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import stocksim.demo.persistence.entity.Stock;
import stocksim.demo.persistence.entity.Wallet;
import stocksim.demo.service.WalletService;

import java.util.List;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    @RequestMapping(value = "/trader{id}/wallet{wid}",method = RequestMethod.GET)
    public ModelAndView viewCourses(@PathVariable String id,@PathVariable String wid)
    {
        Wallet wallet = walletService.findById(Integer.parseInt(wid));
        Stock stock = wallet.getStock();

        ModelAndView mav = new ModelAndView("wallet_template");
        mav.addObject("stock",stock);
       // mav.addObject("enrollmentList",enrollmentList);

        return mav;
    }
}

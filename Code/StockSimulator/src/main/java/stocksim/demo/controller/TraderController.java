package stocksim.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import stocksim.demo.persistence.entity.Stock;
import stocksim.demo.persistence.entity.StockData;
import stocksim.demo.persistence.entity.Trader;
import stocksim.demo.persistence.entity.Wallet;
import stocksim.demo.service.OrderService;
import stocksim.demo.service.StockService;
import stocksim.demo.service.TraderService;
import stocksim.demo.service.WalletService;

import java.util.List;

@RestController
public class TraderController {

    @Autowired
    TraderService traderService;

    @Autowired
    WalletService walletService;

    @Autowired
    StockService stockService;

    @Autowired
    OrderService orderService;

    private ModelAndView mav;
    private Trader t;

    @PostMapping(value = "/trader/{id}", params="Create Wallet")
    public ModelAndView openWallet(@RequestParam(name="stockid")String stockid, @PathVariable String id){
        System.out.println(stockid);
        Stock stock = stockService.findById(Integer.parseInt(stockid));
        System.out.println(stock.getSymbol());
        walletService.createWallet(t,stock);
        return new ModelAndView("redirect:/trader/{id}");
    }

    @PostMapping(value = "/trader/{id}", params="Buy")
    public ModelAndView buyStock(@RequestParam(name="walletid")Integer walletid,@RequestParam(name="amount")String amount, @PathVariable String id){
        Wallet wallet = walletService.findById(walletid);

        orderService.makeOrder(wallet,wallet.getStock(),Integer.parseInt(amount));
        return new ModelAndView("redirect:/trader/{id}");
    }

    @PostMapping(value = "/trader/{id}", params="Sell")
    public ModelAndView sellStock(@RequestParam(name="walletid")Integer walletid,@RequestParam(name="amount")String amount, @PathVariable String id){
        Wallet wallet = walletService.findById(walletid);
        orderService.sellOrder(wallet,wallet.getStock(),Integer.parseInt(amount));
        return new ModelAndView("redirect:/trader/{id}");
    }

    @RequestMapping(value = "/trader/{id}",method = RequestMethod.GET)
    public ModelAndView viewWallets(@PathVariable String id)
    {
        mav = new ModelAndView("trader_template");
        t = traderService.findById(Integer.parseInt(id));
        mav.addObject("trader",t);
        System.out.println(t.toString());

        List<Wallet> walletList = walletService.findByTrader(t);
        mav.addObject("wallets",walletList);

        List<Stock> stockList = stockService.getAllStocks();
        mav.addObject("stocks",stockList);

        Stock btc = stockList.get(1);

        List<StockData> stockData = btc.getStockData();
        mav.addObject("btcPrices",stockData);

        return mav;
    }


   /* @RequestMapping(value = "/trader/{id}",method = RequestMethod.POST)
    public ModelAndView viewCourses(@PathVariable String id, @ModelAttribute(value="walletid") @RequestParam Integer walletid)
    {

        return new ModelAndView("redirect:/trader/{id}/wallet/{walletid}");
    }
    */



}

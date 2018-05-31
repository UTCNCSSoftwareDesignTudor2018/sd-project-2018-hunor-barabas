package stocksim.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stocksim.demo.persistence.entity.*;
import stocksim.demo.persistence.repository.OrderRepo;
import stocksim.demo.service.validators.Validator;
import stocksim.demo.service.validators.ValidatorFactory;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    WalletService walletService;

    private Integer i = 1;

    public void makeOrder(Wallet wallet, Stock stock, Integer amount){
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator v = validatorFactory.getValidator("ORDER");


            Order order = new Order();
            StockData data = stock.getStockData().get(i);
            wallet.setAmount(wallet.getAmount()+amount);
            wallet.setBalance(wallet.getBalance()-data.getPrice());
            order.setOrderDate(new Date());
            order.setStock(stock);
            order.setAmount(amount);
            order.setWallet(wallet);
            v.validate(order);
            orderRepo.save(order);

           // i++;
    }

    public void sellOrder(Wallet wallet, Stock stock, Integer amount){
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator v = validatorFactory.getValidator("ORDER");

        Order order = new Order();
        StockData data = stock.getStockData().get(i);
        wallet.setAmount(wallet.getAmount()-amount);
        wallet.setBalance(wallet.getBalance()+data.getPrice());
        order.setOrderDate(new Date());
        order.setStock(stock);
        order.setAmount(amount);
        order.setWallet(wallet);
        v.validate(order);
        orderRepo.save(order);
       // i++;
    }

    public Order findById(Integer id){ return orderRepo.getOne(id);}

    public void cancelOrder(Order o){ orderRepo.delete(o);}

   /* public List<Order> findAllByTrader(Trader t){
        return orderRepo.findAllByTraderid(t.getTraderid());
    }
    */
}

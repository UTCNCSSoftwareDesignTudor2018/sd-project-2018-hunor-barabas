package stocksim.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stocksim.demo.persistence.entity.Order;
import stocksim.demo.persistence.entity.Stock;
import stocksim.demo.persistence.entity.Wallet;
import stocksim.demo.persistence.repository.OrderRepo;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    public void makeOrder(Wallet wallet, Stock stock, Integer amount){
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setStock(stock);
            order.setAmount(amount);
            order.setWallet(wallet);
            orderRepo.save(order);
    }

    public Order findById(Integer id){ return orderRepo.getOne(id);}

    public void cancelOrder(Order o){ orderRepo.delete(o);}
}

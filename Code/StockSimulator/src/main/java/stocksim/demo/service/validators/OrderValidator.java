package stocksim.demo.service.validators;

import stocksim.demo.persistence.entity.Order;
import stocksim.demo.persistence.entity.Stock;
import stocksim.demo.persistence.entity.StockData;
import stocksim.demo.persistence.entity.Wallet;

public class OrderValidator implements Validator<Order> {


    @Override
    public void validate(Order order) {
        Integer amount = order.getAmount();
        Wallet wallet = order.getWallet();
        Stock stock = order.getStock();
        StockData data = stock.getStockData().get(1);


        if(wallet.getBalance() < amount * data.getPrice()){
            throw new IllegalArgumentException("Not enough money to buy stock");
        }

    }
}

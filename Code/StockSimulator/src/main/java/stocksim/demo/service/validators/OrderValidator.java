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

        if(wallet.getBalance() < amount * 10){
            throw new IllegalArgumentException("Not enough money to buy stock");
        }

    }
}

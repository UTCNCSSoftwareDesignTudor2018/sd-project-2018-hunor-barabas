package stocksim.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stocksim.demo.persistence.entity.Stock;
import stocksim.demo.persistence.entity.Trader;
import stocksim.demo.persistence.entity.Wallet;
import stocksim.demo.persistence.repository.WalletRepo;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    WalletRepo walletRepo;

    public Wallet findById(Integer id){ return walletRepo.getOne(id);}

    public void createWallet(Trader trader, Stock stock){
        Wallet wallet = new Wallet();
        wallet.setBalance(1000);
        wallet.setTrader(trader);
        wallet.setStock(stock);
        walletRepo.save(wallet);
    }

    public Wallet updateWallet(Wallet w){
        return walletRepo.save(w);
    }

    public List<Wallet> findByTrader(Trader trader){
        return walletRepo.findByTrader(trader);
    }

}

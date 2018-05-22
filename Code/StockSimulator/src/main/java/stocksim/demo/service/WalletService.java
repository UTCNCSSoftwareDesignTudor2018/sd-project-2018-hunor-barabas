package stocksim.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stocksim.demo.persistence.entity.Trader;
import stocksim.demo.persistence.entity.Wallet;
import stocksim.demo.persistence.repository.WalletRepo;

@Service
public class WalletService {

    @Autowired
    WalletRepo walletRepo;

    public Wallet findById(Integer id){ return walletRepo.getOne(id);}

    public void createWallet(Trader trader){
        Wallet wallet = new Wallet();
        wallet.setBalance(1000);
        wallet.setTrader(trader);
        walletRepo.save(wallet);}

}

package stocksim.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stocksim.demo.persistence.entity.Trader;
import stocksim.demo.persistence.entity.Wallet;

import java.util.List;

public interface WalletRepo extends JpaRepository<Wallet,Integer> {

    public List<Wallet> findByTrader(Trader trader);
}

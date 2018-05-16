package stocksim.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stocksim.demo.persistence.entity.Wallet;

public interface WalletRepo extends JpaRepository<Wallet,Integer> {
}

package stocksim.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stocksim.demo.persistence.entity.Trader;

public interface TraderRepo extends JpaRepository<Trader,Integer> {
}

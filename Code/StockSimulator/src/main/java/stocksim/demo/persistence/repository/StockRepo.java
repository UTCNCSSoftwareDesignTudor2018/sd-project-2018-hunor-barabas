package stocksim.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stocksim.demo.persistence.entity.Stock;

public interface StockRepo extends JpaRepository<Stock, Integer> {
}

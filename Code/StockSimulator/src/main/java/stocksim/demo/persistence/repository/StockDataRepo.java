package stocksim.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stocksim.demo.persistence.entity.StockData;

public interface StockDataRepo extends JpaRepository<StockData, Integer> {
}

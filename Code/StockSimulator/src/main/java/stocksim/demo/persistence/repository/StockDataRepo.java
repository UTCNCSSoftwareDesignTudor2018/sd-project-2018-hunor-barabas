package stocksim.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stocksim.demo.persistence.entity.StockData;

import java.sql.Date;

public interface StockDataRepo extends JpaRepository<StockData, Integer> {

    public StockData findByDate(Date date);
}

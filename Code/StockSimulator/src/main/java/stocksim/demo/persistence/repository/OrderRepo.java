package stocksim.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stocksim.demo.persistence.entity.Order;
import stocksim.demo.persistence.entity.Trader;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {

   // public List<Order> findAllByTraderid(Integer id);

}

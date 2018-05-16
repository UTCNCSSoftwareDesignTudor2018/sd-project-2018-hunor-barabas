package stocksim.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stocksim.demo.persistence.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}

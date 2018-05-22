package stocksim.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stocksim.demo.persistence.entity.Stock;
import stocksim.demo.persistence.repository.OrderRepo;
import stocksim.demo.persistence.repository.StockRepo;

import java.util.List;

@Service
public class StockService {

    @Autowired
    StockRepo stockRepo;

    public Stock findById(Integer id){ return stockRepo.getOne(id);}

    public Stock addStock(Stock stock){ return stockRepo.save(stock);}

    public List<Stock> getAllStocks(){ return stockRepo.findAll();}




}

package stocksim.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stocksim.demo.persistence.entity.Stock;
import stocksim.demo.persistence.entity.StockData;
import stocksim.demo.persistence.repository.OrderRepo;
import stocksim.demo.persistence.repository.StockRepo;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StockService {

    @Autowired
    StockRepo stockRepo;

    public Stock findById(Integer id){ return stockRepo.getOne(id);}

    public Stock addStock(Stock stock){ return stockRepo.save(stock);}

    public List<Stock> getAllStocks(){ return stockRepo.findAll();}

    public Integer getCurrentPrice(Stock stock){
        List<StockData> sdlist = stock.getStockData();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date = new Date();

       // String formattedDate = dateFormat.format(date);

        for(StockData sd: sdlist){
            if(sd.getDate() == date){
                return sd.getPrice();
            }
        }

        return 10;
    }




}

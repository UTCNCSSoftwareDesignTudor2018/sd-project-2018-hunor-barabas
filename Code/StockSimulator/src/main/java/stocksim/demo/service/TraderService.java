package stocksim.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stocksim.demo.persistence.entity.Trader;
import stocksim.demo.persistence.repository.TraderRepo;

import java.util.List;

@Service
public class TraderService {

    @Autowired
    TraderRepo traderRepo;

    public Trader addTrader(Trader t){ return traderRepo.save(t);}

    public Trader updateTrader(Trader t) { return traderRepo.save(t);}

    public Trader findById(Integer id) { return traderRepo.getOne(id);}

    public List<Trader> getAllTraders(){ return traderRepo.findAll();}

    public void deleteTrader(Trader t){
        if(t.getTraderid() != null){
            traderRepo.delete(t);
        }else{
            System.out.println("No such trader");
        }
    }

    public void validateTrader(Trader trader){


    }
}

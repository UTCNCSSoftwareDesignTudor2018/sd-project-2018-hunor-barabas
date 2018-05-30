package stocksim.demo.service.validators;

import stocksim.demo.persistence.entity.Trader;
import stocksim.demo.service.utility.Form;

public class NameValidator implements Validator<Trader> {
    public void validate(Trader trader){
        if(!Form.isWellFormed(trader.getName(),10,"WEAK")){
            throw new IllegalArgumentException("Invalid name");
        }
    }
}

package stocksim.demo.service.validators;

public class ValidatorFactory {

    private static ValidatorFactory instance = new ValidatorFactory();
    private static final String ORDER = "ORDER";
    private static final String TRADERNAME = "TRADERNAME";

    private ValidatorFactory(){

    }

    public static ValidatorFactory getInstance(){
        return instance;
    }

    public Validator getValidator(String validatorType){
        if(validatorType == null){
            return null;
        }
        if(validatorType.equalsIgnoreCase(ORDER)){
            return new OrderValidator();
        }
        if(validatorType.equalsIgnoreCase(TRADERNAME)){
            return new NameValidator();
        }


        return null;
    }
}

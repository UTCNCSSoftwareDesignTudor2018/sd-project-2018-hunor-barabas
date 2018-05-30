package stocksim.demo.service.utility;

public class Form {

    public static final String STRONG = "STRONG";
    public static final String WEAK = "WEAK";



    public static boolean isNumeric(String str){

        try{
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean isWellFormed(String str, int length, String type){
        if(type.equals(STRONG))
            return length == str.length();
        if(type.equals(WEAK)){
            return length>=str.length();
        }

        else return false;
    }
}

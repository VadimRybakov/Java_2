package exceptions;

public class NotNumberException extends Exception {
    private String symbols;
    public NotNumberException(String message, String s){
        super(message);
        this.symbols = s;
    }
    public String getSymbols(){
        return symbols;
    }
}

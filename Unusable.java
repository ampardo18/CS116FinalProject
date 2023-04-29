public class Unusable extends RuntimeException{
    //This error message will be displayed if a custom error message within the class is not specified
    public Unusable(){
        super("ERROR: Invalid data was found in this line!");
    }
    //If a specific error message is given when throwing the Unusable exception, the custom message will be displayed
    public Unusable(String message){
        super(message);
    }
}
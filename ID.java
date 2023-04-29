//implements Printable interface. However, since class is abstract, the interface method does not have to be implemented.
//It will be inherited by other classes
public abstract class ID implements Printable{
    protected String IDNumber, firstName, lastName;
    protected String IDType;
    protected int age;
    //Constructor that accepts ID type, ID number, first/last name, and age. These values are validated
    public ID(String inputtedIDType, String inputtedID, String inputtedFirstName, String inputtedLastName, int inputtedAge){
        //Checls if given ID type exists from the pre-determined ones
        if(inputtedIDType.equalsIgnoreCase("F") || inputtedIDType.equalsIgnoreCase("S") || inputtedIDType.equalsIgnoreCase("T")){
            IDType = inputtedIDType;
        }
        else{
            //Unusable exception thrown when the ID type given does not exist
            throw new Unusable("ERROR: ID Type given does not exist.");
        }
        //Checks if age given is positive
        if(inputtedAge > 0){
            age = inputtedAge;
        }
        else{
            //Error message displayed when age is negative
           System.out.println("ERROR: age provided is negative.");
        }
        //checks if ID given is not empty
        if(inputtedID.equals("") || inputtedID == null){
            //Error displayed when empty ID is provided
            System.out.println("ERROR: ID Number provided is empty");
        }
        else{
            IDNumber = inputtedID;
        }
        //checks if first name is empty
        if(inputtedFirstName.equals("") || inputtedFirstName == null){
            //Unusable exception thrown when first name is empty
            throw new Unusable("ERROR: First name provided is an empty string.");
        }
        else{
            firstName = inputtedFirstName;
        }
        //checks if last name is empty
        if(inputtedLastName.equals("") || inputtedLastName == null){
            //Unusable exception thrown when last name is empty
            throw new Unusable("ERROR: Last name provided is an empty string.");
        }
        else{
            lastName = inputtedLastName;
        }
    }
    //getter for ID Number
    public String getIDNumber(){
        return IDNumber;
    }
    //getter for first name
    public String getFirstName(){
        return firstName;
    }
    //getter for last name
    public String getLastName(){
        return lastName;
    }
    //getter for ID type
    public String getIDType(){
        return IDType;
    }
    //getter for age
    public int getAge(){
        return age;
    }
}

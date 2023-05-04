public class StudentID extends ID{
    protected String degree;
    //Constructor that accepts information from ID class (age, first/last name, etc.) plus degree 
    public StudentID(String inputtedIDType, String inputtedID, String inputtedFirstName, String inputtedLastName, int inputtedAge, String inputtedDegree){
        //calls super constructor from ID class to input all of these variables to its constructor
        super(inputtedIDType, inputtedID, inputtedFirstName, inputtedLastName, inputtedAge);
        //first checks if given degree is empty
        if(inputtedDegree.equals("") || inputtedDegree == null){
            //Error message displayed when degree is empty
            System.out.println("ERROR: An empty string was provided for a degree.");
        }
        else{
            //Checks if degree matches with the pre-determined ones
            if(inputtedDegree.equalsIgnoreCase("BSc") || inputtedDegree.equalsIgnoreCase("MSc") || inputtedDegree.equalsIgnoreCase("PhD")){
                degree = inputtedDegree;
                System.out.println("Success!");
            }
            else{
                //error message displayed when degree does not exist
                System.out.println("ERROR: Degree inputed does not exist.");
            }
        }
    }
    //getter for degree
    public String getDegree(){
        return degree;
    }
    //Using method overriding based off the ID class, the contents of the interface are overriden. Displays unique information about StudentID
    @Override
    public void print(){
        System.out.println(getIDType() + ", " + getIDNumber() + ", " + getFirstName() + ", " + getLastName() + ", " + getAge() + ", " + getDegree());
    }
}

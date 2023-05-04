public class FacultyID extends ID{
    protected String department;
    //an array of Strings that contains all departments within IIT
    private static final String [] IITDepartments = {"BME" , "CHBE", "CAE", "ECE", "INTM", "INTM", "MMAE", "ARCH", "AMAT", "CS", "ITM", "BIOL", "CHEM", "ELS",
    "FDSN", "HUM", "PHYS", "PSYC", "SOCI", "ID", "SSB", "LAW" };
    //Constructor that accepts information from ID class (age, first/last name, etc.) plus department 
    public FacultyID(String inputtedIDType, String inputtedID, String inputtedFirstName, String inputtedLastName, int inputtedAge, String inputtedDepartment){
        //calls super constructor from ID class to input all of these variables to its constructor
        super(inputtedIDType, inputtedID, inputtedFirstName, inputtedLastName, inputtedAge);
        boolean found = false;
        //first checks if department given is not empty
        if(inputtedDepartment.equals("") || inputtedDepartment == null){
            //Error message displayed when string is empty
            System.out.println("ERROR: Department given is empty");  
        }
        else{
            for(int i = 0; i < IITDepartments.length; i++){
                //Checks if given department exists by moving through each element of the array
                if(inputtedDepartment.equalsIgnoreCase(IITDepartments[i])){
                    department = inputtedDepartment;
                    System.out.println("Success!");
                    found = true;
                    break;
                }
            }  
            if(!found){
                    //error message displayed when department provided does not exist
                    System.out.println("ERROR: Department provided does not exist.");    
                } 
        }
    }
    //getter for department
    public String getDepartment(){
        return department;
    }
    //Using method overriding based off the ID class, the contents of the interface are overriden. Displays unique information about StudentID
    @Override
    public void print(){
        System.out.println(getIDType() + ", " + getIDNumber() + ", " + getFirstName() + ", " + getLastName() + ", " + getAge() + ", " + getDepartment());
    }
}

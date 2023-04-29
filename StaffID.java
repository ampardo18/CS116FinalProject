public class StaffID extends ID{
    protected int salary;
    //Constructor that accepts information from ID class (age, first/last name, etc.) plus salary 
    public StaffID(String inputtedIDType, String inputtedID, String inputtedFirstName, String inputtedLastName, int inputtedAge, int inputtedSalary){
        //calls super constructor from ID class to input all of these variables to its constructor
        super(inputtedIDType, inputtedID, inputtedFirstName, inputtedLastName, inputtedAge);
        //checks if salary given is negative
        if(inputtedSalary > 0){
            salary = inputtedSalary;
            //System.out.println("Success!");
        }
        //error message displayed if salary provided is negative
        else{
            System.out.println("ERROR: Salary provided was negative.");
        }
        
    }
    //getter for salary
    public int getSalary(){
        return salary;
    }
    //Using method overriding based off the ID class, the contents of the interface are overriden. Displays unique information about StudentID
    @Override
    public void print(){
        System.out.println(getIDType() + ", " + getIDNumber() + ", " + getFirstName() + ", " + getLastName() + ", " + getAge() + ", " + getSalary());
    }
}

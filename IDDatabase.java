import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IDDatabase {
    //creates an arrayList named database
    protected ArrayList<ID> database = new ArrayList<ID>();
    //Scanner object is created
    Scanner scan = new Scanner(System.in);

    /*Using method overloading, the method accepts a StaffID object and adds it into the database if it's not null. An 
    error will be displayed if object is null.*/
    public void add(StaffID givenStaffID){
        boolean IDExists = false;
        if(givenStaffID != null){
            //for loop checks the IDNumber of each ID object in the arrayList and checks if it is equal to the IDNumber of the givenID
            for(int i=0; i < database.size(); i++) {
                if(database.get(i).getIDNumber().equalsIgnoreCase(givenStaffID.getIDNumber())) {
                    IDExists = true;
                    break;
                }
            }
            if(IDExists) {
                //if the boolean IDExists is true then a duplicate error is displayed
                System.out.println("ERROR: ID number already exists");
            }
            else {
                //if the boolean IDExists is false then the givenID is added to the database
                database.add(givenStaffID);
            }
        }
        else{
            //Error displayed when the StaffID object given is null
            System.out.println("ERROR: ID could not be added since it is empty");
        }
    }
    /*Using method overloading, the method accepts a FacultyID object and adds it into the database if it's not null. An 
    error will be displayed if object is null.*/
    public void add(FacultyID givenFacultyID){
        boolean IDExists = false;
        if(givenFacultyID != null){
            //for loop checks the IDNumber of each ID object in the arrayList and checks if it is equal to the IDNumber of the givenID
            for(int i=0; i < database.size(); i++) {
                if(database.get(i).getIDNumber().equalsIgnoreCase(givenFacultyID.getIDNumber())) {
                    IDExists = true;
                    break;
                }
            }
            if(IDExists) {
                //if the boolean IDExists is true then a duplicate error is displayed
                System.out.println("ERROR: ID number already exists");
            }
            else {
                //if the boolean IDExists is false then the givenID is added to the database
                database.add(givenFacultyID);
            }
        }
        else{
            //Error displayed when the FacultyID object given is null
            System.out.println("ERROR: ID could not be added since it is empty");
        }
    }
    /*Using method overloading, the method accepts a StudentID object and adds it into the database if it's not null. An 
    error will be displayed if object is null.*/
    public void add(StudentID givenStudentID){
       boolean IDExists = false;
        if(givenStudentID != null){
            //for loop checks the IDNumber of each ID object in the arrayList and checks if it is equal to the IDNumber of the givenID
            for(int i=0; i < database.size(); i++) {
                if(database.get(i).getIDNumber().equalsIgnoreCase(givenStudentID.getIDNumber())) {
                    IDExists = true;
                    break;
                }
            }
            if(IDExists) {
                //if the boolean IDExists is true then a duplicate error is displayed
                System.out.println("ERROR: ID number already exists");
            }
            else {
                //if the boolean IDExists is false then the givenID is added to the database
                database.add(givenStudentID);
            }
       }
       else{
        //Error displayed when the StudentID object given is null
        System.out.println("ERROR: ID could not be added since it is empty");
       }
    }
    /*
    Using method overloading, the method accepts a file name and creates a respective ID object based on ID type and if
    all data within line is valid.
     */
    public void add(String inputtedFileName){ 
        boolean IDExists = false;
        /*
         Initilly checks if file name provided is empty
         */
        if(inputtedFileName != null && !(inputtedFileName.equals(""))){
            //try catch needed to surround file objects when file reading
            try{
                //Setting up file object 
                File IDFile = new File(inputtedFileName);
                Scanner scanFile = new Scanner(IDFile);
                System.out.println("Processing " + inputtedFileName);
                //While loop checks if the file has a next line. If not, the process stops
                while(scanFile.hasNextLine()){
                    //Variable that stores the contents of the current file line
                    String line = scanFile.nextLine();
                    //Checks if the file line is empty
                    if(line != null && !(line.equals(""))){
                        //splits the current line of the file into an array of strings using the split method. The split method splits the line based off ","
                        String [] lineAsArray = line.split(",");
                        //Checks if new array is not null and is exactly a length of 6. If the length is not 6, an error will be displayed
                        if(lineAsArray != null && lineAsArray.length == 6){
                            //try-catch used to catch the NumberFormatException. Will be thrown if a String does not follow the appropriate format of a variable (i.e. int)
                            try{
                                //Adds all data from ID class into temporary variables
                                //No checks are needed since these variables will be checked in the ID's constructor
                                String newIDType = lineAsArray[0];
                                String newIDNumber = lineAsArray[1];
                                String newFirstName = lineAsArray[2];
                                String newLastName = lineAsArray[3];
                                int newAge = Integer.parseInt(lineAsArray[4]);
                                /*
                                These if statements decide what ID object is created based off the ID type found in each line
                                 */
                                if(newIDType.equalsIgnoreCase("S")){
                                    //Degree will be stored in temporary variable. No checks needed since validation is performed in StudentID's constructor
                                    String newDegree = lineAsArray[5];
                                    //Creates new StudentID object with the data collected from the line
                                    StudentID newStudentID = new StudentID(newIDType, newIDNumber, newFirstName, newLastName, newAge, newDegree);
                                    //Calls the method add() that adds StudentID objects into database
                                    //for loop checks if there are any ID objects with the same IDNumber before adding to database
                                    for(int i=0; i < database.size(); i++) {
                                        if(database.get(i).getIDNumber().equalsIgnoreCase(newStudentID.getIDNumber())) {
                                            IDExists = true;
                                            break;
                                        }
                                    }
                                    if(IDExists) {
                                        //if boolean IDExists is true then a duplicate error is displayed and ID is not added to database
                                        System.out.println("ERROR: ID number already exists");
                                    }
                                    else {
                                        //if boolean IDExists is false then the ID object is added to the database
                                    add(newStudentID);
                                    }
                                    System.out.println("Success!");
                                }
                                else if(newIDType.equalsIgnoreCase("F")){
                                    //Department will be stored in temporary variable. No checks needed since validation is performed in DepartmentID's constructor
                                    String newDepartment = lineAsArray[5];
                                    //Creates new FacultyID object with the data collected from line
                                    FacultyID newFacultyID = new FacultyID(newIDType, newIDNumber, newFirstName, newLastName, newAge, newDepartment);
                                    //Calls the method add() that adds FacultyID objects into database
                                    //for loop checks if there are any ID objects with the same IDNumber before adding to database
                                    for(int i=0; i < database.size(); i++) {
                                        if(database.get(i).getIDNumber().equalsIgnoreCase(newFacultyID.getIDNumber())) {
                                            IDExists = true;
                                            break;
                                        }
                                    }
                                    if(IDExists) {
                                        //if boolean IDExists is true then a duplicate error is displayed and ID is not added to database
                                        System.out.println("ERROR: ID number already exists");
                                    }
                                    else {
                                        //if boolean IDExists is false then the ID object is added to the database
                                    add(newFacultyID);
                                    }
                                    System.out.println("Success!");
                                }
                                else if(newIDType.equalsIgnoreCase("T")){
                                    int newSalary = Integer.parseInt(lineAsArray[5]);
                                    //Creates new StaffID object with the data collected from line
                                    StaffID newStaffID = new StaffID(newIDType, newIDNumber, newFirstName, newLastName, newAge, newSalary);
                                    //Calls the method add() that adds StaffID objects into database
                                    //for loop checks if there are any ID objects with the same IDNumber before adding to database
                                    for(int i=0; i < database.size(); i++) {
                                        if(database.get(i).getIDNumber().equalsIgnoreCase(newStaffID.getIDNumber())) {
                                            IDExists = true;
                                            break;
                                        }
                                    }
                                    if(IDExists) {
                                        //if boolean IDExists is true then a duplicate error is displayed and ID is not added to database
                                        System.out.println("ERROR: ID number already exists");
                                    }
                                    else {
                                        //if boolean IDExists is false then the ID object is added to the database
                                    add(newStaffID);
                                    }
                                    System.out.println("Success!"); 
                                }
                            }catch(NumberFormatException error){
                                //Error message displayed when string does not follow appropriate formatting of a variable (int)
                                System.out.println("ERROR: Invalid number was provided (" + line + ").");
                            }
                        }
                        else{
                            //Error message displated when the line does not equal to 6 parts when split into an array
                            System.out.println("ERROR: Inconsistent or no data read (" + line + ").");
                        }
                    }
                    else{
                        //Error message displayed when line is empty
                        System.out.println("ERROR: Line does not have any data");
                    }
                    
                }
                scanFile.close();
            }catch(FileNotFoundException error1){
                //Error message displated when the file name given does not exist
                System.out.println("ERROR: File not found");
            }
        }
    }
    /*
    Using method overloading, the method accepts a last name as an argument so it can be removed from the database. If multiple people
    have the same last name, an ID number will be asked for so it can be removed through A number;
     */
    public void removeID(String inputtedLastName){
        try{
            //checks if database is empty
            if(database.size() != 0){
                //for loop used to check for duplicate last names within database
                for(int i = 0; i < database.size(); i++){
                    //checks for duplicate last names within database
                    if(database.get(i).getLastName().equalsIgnoreCase(database.get(i+1).getLastName())){
                        //If found, the user is prompted to give A number without the A 
                        System.out.println("People with the same last name. Input A number (Do not include the A)"); 
                        int newID = scan.nextInt();
                        //Method call for other removeID method (accepts an int that represents the number of an ID)
                        removeID(newID);
                        break;
                    }
                        else{
                        //If database does not have any duplicate last names, the ID is removed through last name
                        if(database.get(i).getLastName().equalsIgnoreCase(inputtedLastName)){
                            database.remove(i);
                            System.out.println("Success!");
                            break;
                        }
                    }
                }    
            }
            else{
                System.out.println("Database is empty");
            } 
        }
        catch(IndexOutOfBoundsException error){
            System.out.println("ERROR: Person does not exist within database.");
        }  
    }
    /*
    Using method overloading, this method accepts the number part of an ID and removes the specific ID tied
    to that ANumber from within the database.
     */
    public void removeID(int inputtedID){
        boolean found = false;
        String temp = "A" + String.valueOf(inputtedID);
        //checks if database is empty
        if(database.size() != 0){
            for(int i = 0; i < database.size(); i++){
                // for loop checks each ID Object's IDNumber to see if it matches inputtedID
                if(database.get(i).getIDNumber().equals(temp)){
                    //if the IDNumbers match, then that ID object is removed
                    database.remove(i);
                    System.out.println("Success!");
                    found = true;
                }
            }
            if(!found){
                System.out.println("ERROR: Person does not exist within database.");
            }
        }
        else{
            System.out.println("Database is empty");
        }
    }
    //This method displayed the size of the database by using the method .size() for array lists
    public int databaseSize(){
        return database.size();
    }
    /*
    Using method overloading, this method displays all the contents of the database
     */
    public void show(){
        //checks if database is empty
        if(database.size() != 0){
            for(int i = 0; i < database.size(); i++){
                database.get(i).print();
            }
        }
        else{
            System.out.println("Database is empty");
        }
        
    }
    /*
    Using method overloading, this method accepts a certain ID type (char) as an argument. The method searches for all IDs that are the specified ID type
    and prints their contents
     */
    public void show(String inputtedIDType){
        //checks if database is empty
        if(database.size() != 0){
           //Checks if ID type provided exists from the pre-determined ones
            for(int i = 0; i < database.size(); i++){
                //Checking every object's ID type and determining if it equals to the provided ID type
                if(database.get(i).getIDType().equalsIgnoreCase(inputtedIDType)){
                    database.get(i).print();
                }
            }
        } 
        else{
            System.out.println("Database is empty");
        } 
            
    }
    /*
    Using method overloading, this method accepts an age as an argument and displays all IDs that are above the provided age.
     */
    public void show(int certainAge){
        //checks if database is empty
        if(database.size() != 0){
            for(int i = 0; i < database.size(); i++){
                //Checks each object's age and if it is greater than the age given. If so, the contents of the ID is printed
                if(database.get(i).getAge() > certainAge){
                    database.get(i).print();
                }
            }
        }
        else{
            System.out.println("Datbase is empty");
        }
    }

    public void saveIDs(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
        Date date = new Date();
        try{
            FileOutputStream fos = new FileOutputStream("DATABASE_" + dateFormat.format(date), false);
            PrintWriter myWritter = new PrintWriter(fos);
            for(int i = 0; i < database.size(); i++){
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(outputStream);
                // Redirect standard output to the print stream
                System.setOut(printStream);
                // Call the pre-existing println statement
                database.get(i).print();
                // Get the output as a string
                String output = outputStream.toString();
                //prints the string in variable "output" into the file being created
                myWritter.println(output);
            }
            myWritter.close();
        }catch(FileNotFoundException error){
            System.out.println("File not found");
        }
    }
}

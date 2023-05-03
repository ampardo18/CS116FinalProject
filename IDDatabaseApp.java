import java.util.InputMismatchException;
import java.util.Scanner;

public class IDDatabaseApp {
    static IDDatabase myIDDatabase = new IDDatabase();
    static Scanner scan = new Scanner(System.in);
    //main method calls the mainMenu method
    public static void main(String [] args){
        
        mainMenu();
    }
    /*
    This method displays the main menu of the database. Accepts a user choice that determines the next action taken
     */
   public static void mainMenu(){
        int userChoice;
        //A try catch is used to make sure an input mismatch exception is caught when a string is given for user choice (int)
        try{
            System.out.println("Hello, do you want to:" +"\n" + "1.) Add new ID from database" + "\n" + "2.) Remove an ID from database" + "\n" + 
            "3.) Show IDs from database" + "\n" + "4.) Add IDs through a file" + "\n" + "5.) Save IDs to a file" + "\n" + "6.) Exit");
            userChoice = scan.nextInt();
            //clears buffer line
            scan.nextLine();
            //switch case determines what actions to be taken next based off user choice
            switch(userChoice){
                case 1:
                    //calls add id method 
                    addID();
                    break;
                case 2: 
                    //calls remove id method
                    removeID();
                    break;
                case 3: 
                    //calls show id method
                    showID();
                    break;
                case 4: 
                    //calls file add method
                    fileAdd();
                    break;
                case 5: 
                    //calls file save method
                    fileSave();
                    break;
                case 6:
                    //program is shut down
                    System.out.println("Shutting down");
                    System.exit(0);
                default:
                    //If choice is not from the ones specified, the main menu is restarts
                    System.out.println("ERROR: Invalid choice");
                    mainMenu();
                    break;
            }
        }catch(InputMismatchException error){
            System.out.println("ERROR: Choice provided is not a value.");
            scan.nextLine();
            mainMenu();
        }
   }
   /*
    A method that allows the user to add a specific ID based off ID type given. 
    */
   public static void addID(){
        int age, salary;
        String IDType, IDNumber, firstName, lastName, department, degree;
        //try catch used to catch InputMismatchException for age and salary
        try{
            System.out.println("What type of ID do you want to add into the database? (F: Faculty, S: Student, T: Staff)"); 
            IDType = scan.nextLine();
            System.out.println("What is the ANumber of the person?");
            IDNumber = scan.nextLine();
            System.out.println("What is the first name of the person?");
            firstName = scan.nextLine();
            System.out.println("What is the last name of the person?");
            lastName = scan.nextLine();
            System.out.println("What is the age of the person?");
            age = scan.nextInt();
            scan.nextLine();
            //If id type is "S", it will ask for degree
            if(IDType.equalsIgnoreCase("S")){
                System.out.println("What is the student's degree?");
                degree = scan.nextLine();
                //Instantiates a StudentID object with all information gathered
                StudentID newStudent = new StudentID(IDType, IDNumber, firstName, lastName, age, degree);
                //passes it through the add method of myIDDatabase
                myIDDatabase.add(newStudent);
                //displays main menu again after 
                mainMenu();
            }
            //if id type is "F" it will ask for department
            else if(IDType.equalsIgnoreCase("F")){
                System.out.println("What is faculty's department?");
                department = scan.nextLine();
                FacultyID newFaculty = new FacultyID(IDType, IDNumber, firstName, lastName, age, department);
                myIDDatabase.add(newFaculty);
                mainMenu();
            }
            //if id type is "T" it will ask for salary
            else if(IDType.equalsIgnoreCase("T")){
                System.out.println("What is the staff's salary?");
                salary = scan.nextInt();
                StaffID newStaff = new StaffID(IDType, IDNumber, firstName, lastName, age, salary);
                myIDDatabase.add(newStaff);
                mainMenu();
            }
            else{
                System.out.println("ERROR: Given ID type does not exist");
                mainMenu();
            }
        }catch(InputMismatchException error){
            System.out.println("ERROR: String provided for either age or salary");
            mainMenu();
        }
   }

   public static void removeID(){
        int userChoice, IDNumber;
        String lastName;

        try{
            //prompts the user for how they want to remove an id
            System.out.println("Do you want to remove ID through last name (1), ANumber (2), or return to main menu? (3)");
            userChoice = scan.nextInt();
            scan.nextLine();
            switch(userChoice){
                case 1:
                    System.out.println("Enter last name of the person");
                    lastName = scan.nextLine();
                    myIDDatabase.removeID(lastName);
                    mainMenu();
                    break;
                case 2:
                    System.out.println("Enter an ANumber for the person (Without the A)");
                    IDNumber = scan.nextInt();
                    myIDDatabase.removeID(IDNumber);
                    mainMenu();
                    break;
                case 3:
                    mainMenu();
                    break;
                default: 
                    System.out.println("ERROR: Invalid choice");
                    mainMenu();
                    break;
            }
        }catch(InputMismatchException error){
            System.out.println("ERROR: Choice or ID number given is a String");
            mainMenu();
        }
   }

   public static void showID(){
        int userChoice;
        String IDType;
        int ageGreater;
        try{
            //prompts the user for how they want to show/display ID's
            System.out.println("Do you want to show all IDs (1), IDs of certain ID type (2), IDs of age greater than (3), or return to main menu? (4)");
            userChoice = scan.nextInt();
            scan.nextLine();
            switch(userChoice){
                case 1:
                    myIDDatabase.show();
                    break;
                case 2:
                    System.out.println("Enter an ID type do display");
                    IDType = scan.nextLine();
                    //Checks if ID type provided exists from the pre-determined ones
                    if(IDType.equalsIgnoreCase("F") || IDType.equalsIgnoreCase("S") || IDType.equalsIgnoreCase("T")){
                        myIDDatabase.show(IDType);
                    }
                    else{
                        //If ID type given does not exist, an error message will be displayed
                        System.out.println("ERROR: Cannot print anything from database because ID type given does not exist");
                        mainMenu();
                    }
                
                    break;
                case 3:
                    System.out.println("Enter an age that will display IDs that have an age greater than");
                    ageGreater = scan.nextInt();
                    if(ageGreater > 0){
                        myIDDatabase.show(ageGreater);
                    }
                    else{
                        System.out.println("ERROR: Age provided is negative.");
                        mainMenu();
                    }
                    break;
                case 4:
                    mainMenu();
                    break;
                default: 
                    System.out.println("ERROR: Invalid choice");
                    mainMenu();
                    break;
            }
        }catch(InputMismatchException error){
            System.out.println("ERROR: User choice or age provided is a string");
            mainMenu();
        }
   }

   public static void fileAdd(){
        String fileName;
        //prompts user to input a file name
        System.out.println("Enter file name that you want to load into the database");
        fileName = scan.nextLine();
        myIDDatabase.add(fileName);
        mainMenu();
   }

   public static void fileSave(){
        myIDDatabase.saveIDs();
   }
   
}

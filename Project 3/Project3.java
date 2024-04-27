/* Sebastien Adam
   COP 3330
   4/10/2021
*/
import java.util.*;

public class Project3 {
   public static void main(String args[]) {
      System.out.println("               Personnel Management Program                ");
      System.out.println();
      
      ArrayList<Student> studentList = new ArrayList<Student>();
      ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
      ArrayList<Staff> staffList = new ArrayList<Staff>();
      
      mainLoop(studentList, staffList, facultyList);     
   }
public interface Person {   
   public void printInfo();
   
   public StringBuffer getName();
   
   public StringBuffer getID();
}
public static class Student implements Person {
   private StringBuffer name = new StringBuffer();
   private StringBuffer ID = new StringBuffer();
   private double GPA;
   private int creditHours;
   
   public Student(){
      this.name.setLength(0);
      this.ID.setLength(0);
      GPA = 0;
      creditHours = 0;
   }
   public void setID(String ID) {
      this.ID.setLength(0);
      this.ID.append(ID);
   }
   public void setName(String name) {
      this.name.setLength(0);
      this.name.append(name);
   }
   public StringBuffer getName() {
      return this.name;
   }
   public StringBuffer getID() {
      return this.ID;
   }
   public void setGPA(double GPA) {
      this.GPA = GPA;
   }
   public void setCreditHours(int creditHours) {
      this.creditHours = creditHours;
   }
   public double getGPA() {
      return this.GPA;
   }
   public int getCreditHours() {
      return this.creditHours;
   }
   public void printInfo() {
      double totalPayment = (236.45 * this.creditHours) + 52;
      double discount = 0;
      
      if (this.GPA >= 3.85){
         discount = 0.25 * totalPayment;
      }
      System.out.println("---------------------------------------------------------------");
      System.out.println(this.name + "				" + this.ID);
      System.out.println("Credit Hours: " + this.creditHours + " (236.45$/credit hour)");
      System.out.println("Fees: $52");
      System.out.println();
      System.out.println("Total payment (after discount): " + " $" + String.format("%.2f", (totalPayment - discount)) + "                 " + "($" + String.format("%.2f", discount) + " discount applied)");
      System.out.println("---------------------------------------------------------------");
      System.out.println();
   }
   public boolean hasValidID() {
      if(!(this.ID.length() == 6)) {
         return false;
      } 
      if(Character.isLetter(this.ID.charAt(0)) && Character.isLetter(this.ID.charAt(1)) && Character.isDigit(this.ID.charAt(2)) && Character.isDigit(this.ID.charAt(3)) && Character.isDigit(this.ID.charAt(4)) && Character.isDigit(this.ID.charAt(5))) {
         return true;
      }
      else{
         return false;
      }
   }        
}
public static class Staff implements Person {
   private StringBuffer name = new StringBuffer();
   private StringBuffer ID = new StringBuffer();
   private StringBuffer status = new StringBuffer();
   private StringBuffer department = new StringBuffer();
   
   public Staff() {
      this.name.setLength(0);
      this.ID.setLength(0);
      this.status.setLength(0);
      this.department.setLength(0);
   }
   public void setID(String ID) {
      this.ID.setLength(0);
      this.ID.append(ID);
   }
   public void setName(String name) {
      this.name.setLength(0);
      this.name.append(name);
   }
   public void setStatus(String status){
   if(this.status.toString().equalsIgnoreCase("P")) {
            this.status.setLength(0);
            this.status.append("Part Time");
          }
   else if(this.status.toString().equalsIgnoreCase("F")) {
            this.status.setLength(0);
            this.status.append("Full Time");  
          }
   }
   public void setDepartment(String department) {
      this.department.setLength(0);
      this.department.append(department);
   }
   public StringBuffer getName() {
      return this.name;
   }
   public StringBuffer getID() {
      return this.ID;
   }
   public StringBuffer getDepartment(){
      return this.department;      
   }
   public StringBuffer getStatus(){
      return this.status;
   }
   public void printInfo(){
         System.out.println("---------------------------------------------------------------");
         System.out.println(this.name + "       " + this.ID);
         System.out.println(this.department + " Department, " + this.status);
         System.out.println("---------------------------------------------------------------");
         System.out.println();
   }
   public boolean hasValidID() {
      if(!(this.ID.length() == 6)) {
         return false;
      } 
      if(Character.isLetter(this.ID.charAt(0)) && Character.isLetter(this.ID.charAt(1)) && Character.isDigit(this.ID.charAt(2)) && Character.isDigit(this.ID.charAt(3)) && Character.isDigit(this.ID.charAt(4)) && Character.isDigit(this.ID.charAt(5))) {
         return true;
      }
      else{
         return false;
      }
   }     
}
public static class Faculty implements Person {
   private StringBuffer name = new StringBuffer();
   private StringBuffer ID = new StringBuffer();
   private StringBuffer rank = new StringBuffer();
   private StringBuffer department = new StringBuffer();
   
   public Faculty(){
      this.name.setLength(0);
      this.ID.setLength(0);
      this.rank.setLength(0);
      this.department.setLength(0);      
   }
   public void setID(String ID) {
      this.ID.setLength(0);
      this.ID.append(ID);
   }
   public void setName(String name) {
      this.name.setLength(0);
      this.name.append(name);
   }
   public void setRank(String rank){
      this.rank.setLength(0);
      this.rank.append(rank);
   }
   public void setDepartment(String department){
      this.department.setLength(0);
      this.department.append(department);
   } 
   public StringBuffer getName() {
      return this.name;
   }
   public StringBuffer getID() {
      return this.ID;
   }
   public StringBuffer getDepartment(){
      return this.department;      
   }
   public StringBuffer getRank(){
      return this.rank;
   }
   public void printInfo(){
      System.out.println("---------------------------------------------------------------");
      System.out.println(this.name + "       " + this.ID);
      System.out.println(this.department + " Department, " + this.rank);
      System.out.println("---------------------------------------------------------------");
      System.out.println();
   }
   public boolean hasValidID() {
      if(!(this.ID.length() == 6)) {
         return false;
      } 
      if(Character.isLetter(this.ID.charAt(0)) && Character.isLetter(this.ID.charAt(1)) && Character.isDigit(this.ID.charAt(2)) && Character.isDigit(this.ID.charAt(3)) && Character.isDigit(this.ID.charAt(4)) && Character.isDigit(this.ID.charAt(5))) {
         return true;
      }
      else{
         return false;
      }
   }     
}
public static class InvalidIDException extends Exception {
     
}
public static void mainLoop(ArrayList<Student> studentList, ArrayList<Staff> staffList, ArrayList<Faculty> facultyList){
   Scanner inputScnr =  new Scanner(System.in);
   int selectionInput = 0;
   while(true){
      try{
            printMainScreen();
            selectionInput = inputScnr.nextInt();
            inputScnr.nextLine();
            if(selectionInput > 7 || selectionInput < 1) {
               System.out.println();
               System.out.println("Invalid input. Please try again");
               System.out.println();
               mainLoop(studentList, staffList, facultyList);
            }
            if(selectionInput == 1){
               addFaculty(facultyList);  
            }
            else if(selectionInput == 2) {
               addStudent(studentList);   
            }
            else if(selectionInput == 3) {
               int i;
               StringBuffer queryID = new StringBuffer();
               if(studentList.isEmpty()) {
                  System.out.println();
                  System.out.println("There are no students to print tuition information for, you can add student information by selecting option 2 on the main menu");
                  System.out.println();
               }
               else {
                  System.out.print("Enter the Student's ID: ");
                  try{
                     queryID.setLength(0);
                     queryID.append(inputScnr.nextLine());
                     for(i = 0; i <= studentList.size(); i++) {
                        if(queryID.toString().equals(studentList.get(i).getID().toString())) {
                           System.out.println();
                           System.out.println("Here is the tuition invoice for " + studentList.get(i).getID());
                           System.out.println();
                           System.out.println();
                           studentList.get(i).printInfo();
                           break;
                        }
                        if(i == studentList.size() - 1) {
                           System.out.println();
                           System.out.println("No student matched!");
                           System.out.println();
                           break;
                        }
                     }
                  }
                  catch(InputMismatchException exception) {
                     System.out.println();
                     System.out.println("Invalid input. Please try again");
                     System.out.println();   
                  }
                  catch(Exception exception) {
                     System.out.println();
                     System.out.println("Uknown error. Please try again");
                     System.out.println();   
                  }
               }
            }   
            else if(selectionInput == 4) {
               int i;
               StringBuffer queryID = new StringBuffer();
               if(facultyList.isEmpty()) {
                  System.out.println();
                  System.out.println("There are no faculty to print information for, you can add faculty information by selecting option 1 on the main menu");
                  System.out.println();   
               }
               else{
                  System.out.print("Enter the Faculty's ID: ");
                  try{
                     queryID.setLength(0);
                     queryID.append(inputScnr.nextLine());
                     for(i = 0; i <= facultyList.size(); i++) {
                        if(queryID.toString().equals(facultyList.get(i).getID().toString())) {
                           System.out.println();
                           facultyList.get(i).printInfo();
                           break;
                        }
                        if(i == studentList.size() - 1) {
                           System.out.println();
                           System.out.println("No faculty matched!");
                           System.out.println();
                           break;
                        }
                     }
                  }
                  catch(InputMismatchException exception) {
                     System.out.println();
                     System.out.println("Invalid input. Please try again");
                     System.out.println();   
                  }
                  catch(Exception exception) {
                     System.out.println();
                     System.out.println("Uknown error. Please try again");
                     System.out.println();   
                  }
               }
            }
            else if(selectionInput == 5) {
               addStaff(staffList);
            }
            else if(selectionInput == 6) {
               int i;
               StringBuffer queryID = new StringBuffer();
               if(staffList.isEmpty()) {
                  System.out.println();
                  System.out.println("There are no staff to print information for, you can add staff information by selecting option 5 on the main menu");
                  System.out.println();   
               }
               else{
                  System.out.print("Enter the Staff's ID: ");
                  try{
                     queryID.setLength(0);
                     queryID.append(inputScnr.nextLine());
                     for(i = 0; i <= staffList.size(); i++) {
                        if(queryID.toString().equals(staffList.get(i).getID().toString())) {
                           System.out.println();
                           staffList.get(i).printInfo();
                           break;
                        }
                        if(i == staffList.size() - 1) {
                           System.out.println();
                           System.out.println("No Staff matched!");
                           System.out.println();
                           break;
                        }
                     }
                  }
                  catch(InputMismatchException exception) {
                     System.out.println();
                     System.out.println("Invalid input. Please try again");
                     System.out.println();   
                  }
                  catch(Exception exception) {
                     System.out.println();
                     System.out.println("Uknown error. Please try again");
                     System.out.println();   
                  }
               }               
            }
            else if(selectionInput == 7) {
               System.out.println();
               System.out.print("Would you like to create a report? (Y/N): ");   
               if(inputScnr.next().equalsIgnoreCase("Y")) {
                  //createReport();   
               }
               else if(inputScnr.next().equalsIgnoreCase("N")) {
                 System.out.println();
                  System.out.println("Goodbye!");
                  System.exit(0);
               }
               System.exit(0);
            }   
      }
      catch(InputMismatchException exception) {
            System.out.println();
            System.out.println("Invalid input. Please try again.");
            System.out.println();
            mainLoop(studentList, staffList, facultyList);   
      }
      catch(Exception exception) {
         System.out.println();
         System.out.println("Unknown error, please try again.");
         System.out.println();
         mainLoop(studentList, staffList, facultyList);
      }
   }
}
public static void printMainScreen() {
   System.out.println("1. Enter the information of a faculty");
   System.out.println("2. Enter information of a student");
   System.out.println("3. Print tuition invoice for a student");
   System.out.println("4. Print faculty information");
   System.out.println("5. Enter the information of a staff member");
   System.out.println("6. Print the information of a staff member");
   System.out.println("7. Exit program");
  }
public static void addFaculty(ArrayList<Faculty> facultyList) {
      Faculty newFaculty = new Faculty();
      Scanner inputScnr = new Scanner(System.in);
     
      try { 
         System.out.println("Please enter faculty info:");
         System.out.println();
           
         System.out.print("       Name of the faculty: ");
         newFaculty.setName(inputScnr.nextLine());
            
         System.out.print("       ID: ");
         newFaculty.setID(inputScnr.nextLine());
         if(!(newFaculty.hasValidID())) {
            throw new InvalidIDException();   
         }
           
         System.out.print("       Rank: ");
         newFaculty.setRank(inputScnr.nextLine());
         while(!(newFaculty.getRank().toString().equals("Professor")) && !(newFaculty.getRank().toString().equals("Adjunct"))) {
            System.out.println(); 
            System.out.println("'" + newFaculty.getRank() + "'" + " is invalid, please re-enter the rank");
            System.out.println();
            System.out.print("       Rank: ");
            newFaculty.setRank(inputScnr.nextLine());
         } 
         
         System.out.print("       Department: ");
         newFaculty.setDepartment(inputScnr.nextLine());
         
         while(!(newFaculty.getDepartment().toString().equals("Mathematics")) && !(newFaculty.getDepartment().toString().equals("Engineering")) && !(newFaculty.getDepartment().toString().equals("Sciences"))) {    
                if(newFaculty.getDepartment().toString().equals("matheMatics") || newFaculty.getDepartment().toString().equals("MathematiCs") || newFaculty.getDepartment().toString().equals("mathematics")) {
                   newFaculty.setDepartment("Mathematics");        
                }
                else if(newFaculty.getDepartment().toString().equalsIgnoreCase("engineering")) {
                   newFaculty.setDepartment("Engineering");                        
                }
                else if(newFaculty.getDepartment().toString().equalsIgnoreCase("sciences"))
                {
                   newFaculty.setDepartment("Sciences");                        
                }                     
                else
                {
                   System.out.println();
                   System.out.println("Invalid department entry. Please re-enter the department");
                   System.out.println();
                   System.out.print("       Department: ");
                   newFaculty.setDepartment(inputScnr.nextLine());
                }       
            }
            facultyList.add(newFaculty);
            System.out.println();
            System.out.println("Faculty sucessfully added!");
            System.out.println();
              
      }
      catch(InvalidIDException exception) {
         System.out.println();
         System.out.println("Invalid ID format. ID's must be of the form LetterLetterDigitDigitDigitDigit. Please try again");
         System.out.println();
         addFaculty(facultyList);      
      }
      catch(InputMismatchException exception) {
         System.out.println();
         System.out.println("Incorrect type of input. Please try again");
         System.out.println();
         addFaculty(facultyList);
      }
      catch(Exception exception) {
         System.out.println();
         System.out.println("Unknown error. Please try again");
         System.out.println();
         addFaculty(facultyList);      
      }      
   }
public static void addStudent(ArrayList<Student> studentList) {
      Student newStudent =  new Student();
      Scanner inputScnr = new Scanner(System.in);
      
      try {
         System.out.println("Please enter student info:");
         System.out.println();
         
         System.out.print("       Name of the Student: ");
         newStudent.setName(inputScnr.nextLine());
         
         System.out.print("       ID: ");
         newStudent.setID(inputScnr.nextLine());
         if(!(newStudent.hasValidID())) {
            throw new InvalidIDException();   
         }
         
         System.out.print("       GPA: ");
         newStudent.setGPA(inputScnr.nextDouble());
         inputScnr.nextLine();
         
         System.out.print("       Credit Hours: ");
         newStudent.setCreditHours(inputScnr.nextInt());
         inputScnr.nextLine();
         
         studentList.add(newStudent);
         System.out.println();
         System.out.println("Student sucessfully added!");
         System.out.println();              
      }
      catch(InvalidIDException exception) {
         System.out.println();
         System.out.println("Invalid ID format. ID's must be of the form LetterLetterDigitDigitDigitDigit. Please try again");
         System.out.println();
         addStudent(studentList);      
       }
      catch(InputMismatchException exception) {
         System.out.println();
         System.out.println("Incorrect type of input. Please try again");
         System.out.println();
         addStudent(studentList);
      }
      catch(Exception exception) {
         System.out.println();
         System.out.println("Unknown error. Please try again");
         System.out.println();
         addStudent(studentList);
      }   
   }
public static void addStaff(ArrayList<Staff> staffList) {
      Scanner inputScnr = new Scanner(System.in);
      Staff newStaff = new Staff();
      
      try {
         System.out.println("Please enter Staff info:");
         System.out.println();
         
         System.out.print("       Name of the Staff: ");
         newStaff.setName(inputScnr.nextLine());
         
         System.out.print("       ID: ");
         newStaff.setID(inputScnr.nextLine());
         if(!(newStaff.hasValidID())) {
            throw new InvalidIDException();
         }
         System.out.print("       Department: ");
         newStaff.setDepartment(inputScnr.nextLine());
         System.out.println();
         
         while(!(newStaff.getDepartment().toString().equals("Mathematics")) && !(newStaff.getDepartment().toString().equals("Engineering")) && !(newStaff.getDepartment().toString().equals("Sciences"))) {    
                if(newStaff.getDepartment().toString().equals("matheMatics") || newStaff.getDepartment().toString().equals("MathematiCs") || newStaff.getDepartment().toString().equals("mathematics")) {
                   newStaff.setDepartment("Mathematics");        
                }
                else if(newStaff.getDepartment().toString().equalsIgnoreCase("engineering")) {
                   newStaff.setDepartment("Engineering");                        
                }
                else if(newStaff.getDepartment().toString().equalsIgnoreCase("sciences"))
                {
                   newStaff.setDepartment("Sciences");                        
                }                     
                else
                {
                   System.out.println("Invalid department entry. Please re-enter the department");
                   System.out.print("       Department: ");
                   newStaff.setDepartment(inputScnr.nextLine());
                }       
            }
         System.out.print("       Status, Enter 'P' for Part Time or 'F' for Full Time: ");
         newStaff.setStatus(inputScnr.nextLine());
         
         staffList.add(newStaff);
         System.out.println();
         System.out.println("Staff successfully added!");
         System.out.println();     
      }
      catch(InvalidIDException exception) {
         System.out.println();
         System.out.println("Invalid ID format. ID's must be of the form LetterLetterDigitDigitDigitDigit. Please try again");
         System.out.println();
         addStaff(staffList);
      }
      catch(InputMismatchException exception) {
         System.out.println();
         System.out.println("Incorrect type of input. Please try again");
         System.out.println();
         addStaff(staffList);
      }
      catch(Exception exception) {
         System.out.println();
         System.out.println("Unknown error. Please try again");
         System.out.println();
         addStaff(staffList);
      }   
   }   
}

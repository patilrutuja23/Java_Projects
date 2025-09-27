
import java.util.*;

// class Student 
// {
//     String ID;
//     String Name;
//     String Classes;
//     String Grade;
//     String RollNum;
//     public Student(String ID, String Name, String Classes, String Grade,String RollNum) 
//     {
//         this.ID=ID;
//         this.Name = Name;
//         this.Classes= Classes;
//         this.Grade = Grade;
//         this.RollNum = RollNum;
//     }

//     public void setId(String ID) 
//     {
//         this.ID = ID;
//     }
//     public String getId() 
//     {
//         return ID;
//     }

//     public void setName(String Name) 
//     {
//         this.Name = Name;
//     }
//     public String getName() 
//     {
//         return Name;
//     }
    
//     public void setClasses(String Classes) 
//     {
//         this.Classes = Classes;
//     }
//     public String getClasses() 
//     {
//         return Classes;
//     }

//     public void setGrade(String Grade) 
//     {
//         this.Grade = Grade;
//     }
//     public String getGrade() 
//     {
//         return Grade;
//     }

//     public void setRollNum(String RollNum)
//     {
//         this.RollNum=RollNum;
//     }
//     public String getRollNum()
//     {
//         return RollNum;
//     }

//     public void displayDetails() 
//     {
//         System.out.println("Student ID: " + ID);
//         System.out.println("Name: " + Name);
//         System.out.println("Class: " + Classes);
//         System.out.println("Grade: " + Grade);
//         System.out.println("Roll number: "+ RollNum);
//     }

//     class School{
//         static ArrayList<Student> students = new ArrayList<>();
//         static Scanner sc = new Scanner(System.in);
        
//             public static void addStudent() 
//             {
//                 System.out.print("Enter ID of Student: ");
//                 String ID = sc.next();
//                 System.out.print("Enter Name of Student: ");
//                 String Name = sc.next();
//                 System.out.print("Enter Class of Student: ");
//                 String Classes = sc.next();
//                 System.out.print("Enter Grade of Student: ");
//                 String Grade = sc.next();
//                 System.out.print("Enter RollNum of Student: ");
//                 String RollNum = sc.next();
                
//                 students.add(new Student());
//                 System.out.println("Student added successfully.");
//             }
        
//             public static void viewStudents()
//             {
//                 if (students.isEmpty()) 
//                 {
//                     System.out.println("No students found.");
//                 } 
//                 else 
//                 {
//                     for (Student student : students) 
//                     {
//                         student.displayDetails();
//                     }
//                 }
//             }
//     }

// }

// public class SchoolManagementSystem {
    
//         public static void main(String[] args) {
//             Student school = new Student();
//             School.addStudent();
//             School.viewStudents();
//         }
// }




















// import java.util.*;

// // Student class to represent individual student details
// class Student {
//     private String ID;
//     private String Name;
//     private String Classes;
//     private String Grade;
//     private String RollNum;

//     // Constructor to initialize a student object
//     public Student(String ID, String Name, String Classes, String Grade, String RollNum) {
//         this.ID = ID;
//         this.Name = Name;
//         this.Classes = Classes;
//         this.Grade = Grade;
//         this.RollNum = RollNum;
//     }

//     // Setters and Getters for Student properties
//     public String getID() {
//         return ID;
//     }

//     public void setID(String ID) {
//         this.ID = ID;
//     }

//     public String getName() {
//         return Name;
//     }

//     public void setName(String Name) {
//         this.Name = Name;
//     }

//     public String getClasses() {
//         return Classes;
//     }

//     public void setClasses(String Classes) {
//         this.Classes = Classes;
//     }

//     public String getGrade() {
//         return Grade;
//     }

//     public void setGrade(String Grade) {
//         this.Grade = Grade;
//     }

//     public String getRollNum() {
//         return RollNum;
//     }

//     public void setRollNum(String RollNum) {
//         this.RollNum = RollNum;
//     }

//     // Display student details
//     public void displayDetails() {
//         System.out.println("Student ID: " + ID);
//         System.out.println("Name: " + Name);
//         System.out.println("Class: " + Classes);
//         System.out.println("Grade: " + Grade);
//         System.out.println("Roll Number: " + RollNum);
//     }

//     // toString method for better student information display in list
//     @Override
//     public String toString() {
//         return "Student ID: " + ID + ", Name: " + Name + ", Class: " + Classes + ", Grade: " + Grade + ", Roll Number: " + RollNum;
//     }
// }

// // School class to manage students
// class School {
//     private static ArrayList<Student> students = new ArrayList<>();
//     private static Scanner sc = new Scanner(System.in);

//     // Method to add a new student
//     public static void addStudent() {
//         System.out.print("Enter ID of Student: ");
//         String ID = sc.next();
//         System.out.print("Enter Name of Student: ");
//         String Name = sc.next();
//         System.out.print("Enter Class of Student: ");
//         String Classes = sc.next();
//         System.out.print("Enter Grade of Student: ");
//         String Grade = sc.next();
//         System.out.print("Enter Roll Number of Student: ");
//         String RollNum = sc.next();

//         // Create a new Student object and add it to the list
//         Student newStudent = new Student(ID, Name, Classes, Grade, RollNum);
//         students.add(newStudent);

//         System.out.println("Student added successfully.");
//     }

//     // Method to view all students
//     public static void viewStudents() {
//         if (students.isEmpty()) {
//             System.out.println("No students found.");
//         } else {
//             // Anonymous Class - sorting students by Name in ascending order
//             Collections.sort(students, new Comparator<Student>() {
//                 @Override
//                 public int compare(Student s1, Student s2) {
//                     return s1.getName().compareTo(s2.getName());
//                 }
//             });

//             // Alternatively, using Lambda expression to sort by Name
//             // Collections.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));

//             // Display all students
//             students.forEach(student -> student.displayDetails());
//         }
//     }

//     // Method to sort students using Lambda expression
//     public static void sortByGrade() {
//         // Sorting by Grade using Lambda expression
//         students.sort((s1, s2) -> s1.getGrade().compareTo(s2.getGrade()));

//         System.out.println("Students sorted by Grade:");
//         students.forEach(student -> System.out.println(student));
//     }
// }

// // Main class to run the program
// public class SchoolManagementSystem {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
        
//         while (true) {
//             System.out.println("\nSchool Management System");
//             System.out.println("1. Add Student");
//             System.out.println("2. View Students");
//             System.out.println("3. Sort Students by Grade");
//             System.out.println("4. Exit");
//             System.out.print("Enter your choice: ");
//             int choice = sc.nextInt();
            
//             switch (choice) {
//                 case 1:
//                     School.addStudent();
//                     break;
//                 case 2:
//                     School.viewStudents();
//                     break;
//                 case 3:
//                     School.sortByGrade();
//                     break;
//                 case 4:
//                     System.out.println("Exiting the program.");
//                     System.exit(0);
//                     break;
//                 default:
//                     System.out.println("Invalid choice. Please try again.");
//             }
//         }
//     }
// }









import java.util.*;

// Student class to represent individual student details
class Student {
    private String ID;
    private String Name;
    private String Classes;
    private String Grade;
    private String RollNum;

    // Default constructor
    public Student() {
        // Default constructor - no parameters
    }

    // Setters for Student properties
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getClasses() {
        return Classes;
    }

    public void setClasses(String Classes) {
        this.Classes = Classes;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public String getRollNum() {
        return RollNum;
    }

    public void setRollNum(String RollNum) {
        this.RollNum = RollNum;
    }

    // Display student details
    public void displayDetails() {
        System.out.println("Student ID: " + ID);
        System.out.println("Name: " + Name);
        System.out.println("Class: " + Classes);
        System.out.println("Grade: " + Grade);
        System.out.println("Roll Number: " + RollNum);
    }

    // toString method for better student information display in list
    @Override
    public String toString() {
        return "Student ID: " + ID + ", Name: " + Name + ", Class: " + Classes + ", Grade: " + Grade + ", Roll Number: " + RollNum;
    }
}

// School class to manage students
class School {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Method to add a new student
    public static void addStudent() {
        System.out.print("Enter ID of Student: ");
        String ID = sc.next();
        System.out.print("Enter Name of Student: ");
        String Name = sc.next();
        System.out.print("Enter Class of Student: ");
        String Classes = sc.next();
        System.out.print("Enter Grade of Student: ");
        String Grade = sc.next();
        System.out.print("Enter Roll Number of Student: ");
        String RollNum = sc.next();

        // Create a new Student object using default constructor and set the values via setters
        Student newStudent = new Student();
        newStudent.setID(ID);
        newStudent.setName(Name);
        newStudent.setClasses(Classes);
        newStudent.setGrade(Grade);
        newStudent.setRollNum(RollNum);

        students.add(newStudent);

        System.out.println("Student added successfully.");
    }

    // Method to view all students
    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            // Anonymous Class - sorting students by Name in ascending order
            Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return s1.getName().compareTo(s2.getName());
                }
            });

            // Alternatively, using Lambda expression to sort by Name
            // Collections.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));

            // Display all students
            students.forEach(student -> student.displayDetails());
        }
    }

    // Method to sort students using Lambda expression
    public static void sortByGrade() {
        // Sorting by Grade using Lambda expression
        students.sort((s1, s2) -> s1.getGrade().compareTo(s2.getGrade()));

        System.out.println("Students sorted by Grade:");
        students.forEach(student -> System.out.println(student));
    }
}

// Main class to run the program
public class SchoolManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nSchool Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Sort Students by Grade");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    School.addStudent();
                    break;
                case 2:
                    School.viewStudents();
                    break;
                case 3:
                    School.sortByGrade();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
 










// import java.util.*;

// class Student {
//     private String ID, Name, Classes, Grade, RollNum;

//     // Setters and Getters
//     public void setID(String ID) { this.ID = ID; }
//     public void setName(String Name) { this.Name = Name; }
//     public void setClasses(String Classes) { this.Classes = Classes; }
//     public void setGrade(String Grade) { this.Grade = Grade; }
//     public void setRollNum(String RollNum) { this.RollNum = RollNum; }

//     public String getName() { return Name; }
//     public String getGrade() { return Grade; }

//     // Display student details
//     public void displayDetails() {
//         System.out.println("ID: " + ID + ", Name: " + Name + ", Class: " + Classes + ", Grade: " + Grade + ", Roll No: " + RollNum);
//     }
// }

// class School {
//     private static final List<Student> students = new ArrayList<>();
//     private static final Scanner sc = new Scanner(System.in);

//     // Add a student
//     public static void addStudent() {
//         Student student = new Student();
//         System.out.print("ID: "); student.setID(sc.next());
//         System.out.print("Name: "); student.setName(sc.next());
//         System.out.print("Class: "); student.setClasses(sc.next());
//         System.out.print("Grade: "); student.setGrade(sc.next());
//         System.out.print("Roll No: "); student.setRollNum(sc.next());
//         students.add(student);
//     }

//     // View students
//     public static void viewStudents() {
//         if (students.isEmpty()) {
//             System.out.println("No students found.");
//         } else {
//             students.sort(Comparator.comparing(Student::getName));  // Lambda-style sorting by Name
//             students.forEach(Student::displayDetails);
//         }
//     }

//     // Sort students by grade
//     public static void sortByGrade() {
//         students.sort(Comparator.comparing(Student::getGrade));
//         students.forEach(System.out::println);
//     }
// }

// public class SchoolManagementSystem {
//     public static void main(String[] args) {
//         while (true) {
//             System.out.println("\n1. Add Student\n2. View Students\n3. Sort by Grade\n4. Exit");
//             int choice = new Scanner(System.in).nextInt();
//             switch (choice) {
//                 case 1: School.addStudent(); break;
//                 case 2: School.viewStudents(); break;
//                 case 3: School.sortByGrade(); break;
//                 case 4: return;
//                 default: System.out.println("Invalid option!");
//             }
//         }
//     }
// }

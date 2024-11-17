import java.util.*;

class Student 
{
    String ID;
    String Name;
    String Classes;
    String Grade;
    String RollNum;
    public Student(String ID, String Name, String Classes, String Grade,String RollNum) 
    {
        this.ID=ID;
        this.Name = Name;
        this.Classes= Classes;
        this.Grade = Grade;
        this.RollNum = RollNum;
    }

    public void setId(String ID) 
    {
        this.ID = ID;
    }
    public String getId() 
    {
        return ID;
    }

    public void setName(String Name) 
    {
        this.Name = Name;
    }
    public String getName() 
    {
        return Name;
    }
    
    public void setClasses(String Classes) 
    {
        this.Classes = Classes;
    }
    public String getClasses() 
    {
        return Classes;
    }

    public void setGrade(String Grade) 
    {
        this.Grade = Grade;
    }
    public String getGrade() 
    {
        return Grade;
    }

    public void setRollNum(int RollNum)
    {
        this.RollNum=RollNum;
    }
    public int getRollNum()
    {
        return RollNum;
    }

    public void displayDetails() 
    {
        System.out.println("Student ID: " + ID);
        System.out.println("Name: " + Name);
        System.out.println("Class: " + Classes);
        System.out.println("Grade: " + Grade);
        System.out.println("Roll number: "+ RollNum);
    }
}

class Teacher
{
    String ID;
    String Name;
    String Classes;
    String Subject;
    public Teacher(String ID, String Name, String Classes ,String Subject) 
    {
        this.ID = ID;
        this.Name = Name;
        this.Subject = Subject;
        this.Classes=Classes;
    }

    public void setId(String ID) 
    {
        this.ID = ID;
    }
    public String getId() 
    {
        return ID;
    }

    public void setName(String Name) 
    {
        this.Name = Name;
    }
    public String getName() 
    {
        return Name;
    }

    public void setSubject(String Subject) 
    {
        this.Subject = Subject;
    }
    public String getSubject() 
    {
        return Subject;
    }

    public void setClasses(String Classes)
    {
        this.Classes=Classes;
    }
    public String getClasses()
    {
        return Classes;
    }
    public void displayDetails()
    {
        System.out.println("Teacher ID: " + ID);
        System.out.println("Name: " + Name);
        System.out.println("Subject: " + Subject);
        System.out.println("Class: "+ Classes);
    }
}

class Course 
{
    private String courseName;
    private String courseCode;
    private String teacher;

    public Course(String courseName, String courseCode, String teacher) 
    {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.teacher = teacher;
    }

    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }
    public String getCourseName() 
    {
        return courseName;
    }

    public void setCourseCode(String courseCode) 
    {
        this.courseCode = courseCode;
    }
    public String getCourseCode() 
    {
        return courseCode;
    }
    
    public void setTeacher(String teacher) 
    {
        this.teacher = teacher;
    }
    public String getTeacher() 
    {
        return teacher;
    }

    public void displayCourseDetails() 
    {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Teacher: " + teacher);
    }
}

class FeesStructure 
    {
        static double tuitionFee;
        static double examFee;
        static double additionalFees;
    
        public FeesStructure(double tuitionFee, double examFee, double additionalFees) 
        {
            this.tuitionFee = tuitionFee;
            this.examFee = examFee;
            this.additionalFees = additionalFees;
        }
    
        public static double getTotalFees() 
        {
            return tuitionFee + examFee + additionalFees;
        }
    
        public static double getTuitionFee() 
        {
            return tuitionFee;
        }
    
        public static double getExamFee() 
        {
            return examFee;
        }
    
        public double getAdditionalFees() 
        {
            return additionalFees;
        }
        public static void feesDetails()
        {
            System.out.println("Tuition Fee: "+tuitionFee);
            System.out.println("Exam Fee: "+examFee);
            System.out.println("Additional Fee: "+additionalFees);
            System.out.println("Total fees: "+ getTotalFees());

        }
    }

public class SchoolManagementSystem 
{
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();
    static ArrayList<Course> course = new ArrayList<>();
    static FeesStructure fees= new FeesStructure(1200, 1000, 5800);
        static Scanner sc = new Scanner(System.in);
    
        public static void addStudent() 
        {
            System.out.print("Enter ID of Student: ");
            String ID = sc.next();
            System.out.print("Enter Name of Student: ");
            String Name = sc.next();
            System.out.print("Enter Class of Student: ");
            String Classes = sc.next();
            System.out.print("Enter Grade of Student: ");
            String Grade = sc.next();
            System.out.print("Enter RollNum of Student: ");
            String RollNum = sc.next();
            
            students.add(new Student(ID, Name, Classes, Grade, RollNum));
            System.out.println("Student added successfully.");
        }
    
        public static void viewStudents()
        {
            if (students.isEmpty()) 
            {
                System.out.println("No students found.");
            } 
            else 
            {
                for (Student student : students) 
                {
                    student.displayDetails();
                }
            }
        }

        public static void removeStudent() 
        {
            if (students.isEmpty()) 
            {
                System.out.println("No students to remove.");
                return;
            }
        
            System.out.print("Enter ID of the student to remove: ");
            String ID = sc.next();
        
            boolean found = false;
            for (Student student : students) 
            {
                if (student.getId() == ID) 
                {
                    students.remove(student);
                    System.out.println("Student with ID " + ID + " removed successfully.");
                    found = true;
                    break;
                }
            }
        
            if (!found) 
            {
                System.out.println("No student found with ID " + ID + ".");
            }
        }

        public static void searchStudent() 
        {
            if (students.isEmpty()) 
            {
                System.out.println("No students found.");
                return;
            }
        
            System.out.print("Enter student ID or Name to search: ");
            String search = sc.next();  
        
            boolean found = false;
            for (Student student : students) 
            {
                if (String.valueOf(student.getId()).equals(search) || student.getName().equalsIgnoreCase(search)) {
                    student.displayDetails(); 
                    found = true;
                    break;
                }
            }
        
            if (!found) 
            {
                System.out.println("No student found with the given ID or Name.");
            }
        }
        
        
        public static void addTeacher() 
        {
            System.out.print("Enter ID of Teacher: ");
            String ID = sc.next();
            System.out.print("Enter Name of Teacher: ");
            String Name = sc.next();
            System.out.print("Enter Class of Teacher: ");
            String Classes = sc.next();
            System.out.print("Enter Subject of Teacher: ");
            String Subject = sc.next();
            teachers.add(new Teacher(ID, Name, Classes,Subject));
            System.out.println("Teacher added successfully.");
        }
    
       
        public static void viewTeachers() 
        {
            if (teachers.isEmpty()) {
                System.out.println("No teachers found.");
            } else {
                for (Teacher teacher : teachers) {
                    teacher.displayDetails();
                }
            }
        }
    
        public static void addCourse()
        {
            System.out.print("Enter the name of the course: ");
            String courseName = sc.next();
            System.out.print("Enter the course code for the course: ");
            String courseCode = sc.next();
            System.out.print("Enter the teacher assign to the course: ");
            String teacher = sc.next();
            course.add(new Course(courseName, courseCode, teacher));
            System.out.println("Course added successfully.");
        }
        
        public static void viewCourseDetails()
        {
            if (course.isEmpty()) 
            {
                System.out.println("No course found.");
            } 
            else 
            {
                for (Course courses : course) 
                {
                    courses.displayCourseDetails();
                }
            }
        }
    
        public static void viewFees()
        {
            fees.feesDetails();
    }
    
    public static void main(String[] args) 
    {
        while (true) 
        {
            System.out.println("*** School Management System ***");
            System.out.println("1. Add Student");
            System.out.println("2. View Students Details");
            System.out.println("3. Add Teacher");
            System.out.println("4. View Teachers Details");
            System.out.println("5. Remove Student");
            System.out.println("6. Search Student");
            System.out.println("7. Add Course");
            System.out.println("8. View Course Details");
            System.out.println("9. View Fees Details");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            switch (choice) 
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    addTeacher();
                    break;
                case 4:
                    viewTeachers();
                    break;
                case 5:
                    removeStudent();
                    break;
                case 6:
                    searchStudent(); 
                    break;
                case 7:
                    addCourse();
                    break;
                case 8:
                    viewCourseDetails();
                    break;
                case 9:
                    viewFees();
                    break;
                case 10:
                    System.out.println("Exiting from school management system program...!");
                    return; 
                default:
                    System.out.println("Invalid choice. Please enter valid input.");
            }
        }
    }
    
    
}

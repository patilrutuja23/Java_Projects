
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        GetGrade.addNumOfStudents();
    }
}

class GetGrade {
    static final ArrayList<Double> grades = new ArrayList<>();
    static final Scanner sc = new Scanner(System.in);

    public static void addNumOfStudents() {
        System.out.print("Enter the number of students: ");
        int numOfStud = sc.nextInt();

        for(int i=0; i<numOfStud ; i++) {
            System.out.print("Enter Grade of Student "+(i+1)+" : ");
            double gradeOfStud = sc.nextDouble();
            grades.add(gradeOfStud);
        }
        double sum = 0;
        double highest = grades.get(0);
        double lowest = grades.get(0);

        for(double grade : grades) {
            sum += grade;
            if(grade > highest)
                highest = grade;
            if(grade < lowest)
                lowest = grade;
             
        }

        double avg = sum/numOfStud;

        System.out.println("Average of Students Grade is: "+avg);
        System.out.println("Highest of Students Grade is: "+highest);
        System.out.println("Lowest of Students Grade is: "+lowest);
    }
    

}




// import java.util.ArrayList;
// import java.util.Scanner;

// public class StudentGradeTracker {
//     public static void main(String[] args) {
//         // Call functions to execute the program
//         GetGrade.addNumOfStudents();
//         GetGrade.addGrades();
        
//         // Display results
//         double average = GetGrade.calculateAverage();
//         double highest = GetGrade.calculateHighest();
//         double lowest = GetGrade.calculateLowest();
        
//         System.out.println("Average of Students' Grades: " + average);
//         System.out.println("Highest of Students' Grades: " + highest);
//         System.out.println("Lowest of Students' Grades: " + lowest);
//     }
// }

// class GetGrade {
//     static final ArrayList<Double> grades = new ArrayList<>();
//     static final Scanner sc = new Scanner(System.in);
//     static int numOfStud;

//     // Function to input the number of students
//     public static void addNumOfStudents() {
//         System.out.print("Enter the number of students: ");
//         numOfStud = sc.nextInt();
//     }

//     // Function to input grades for each student
//     public static void addGrades() {
//         for (int i = 0; i < numOfStud; i++) {
//             System.out.print("Enter Grade of Student " + (i + 1) + " : ");
//             double gradeOfStud = sc.nextDouble();
//             grades.add(gradeOfStud);
//         }
//     }

//     // Function to calculate and return the average grade
//     public static double calculateAverage() {
//         double sum = 0;
//         for (double grade : grades) {
//             sum += grade;
//         }
//         return sum / numOfStud;
//     }

//     // Function to calculate and return the highest grade
//     public static double calculateHighest() {
//         double highest = grades.get(0);
//         for (double grade : grades) {
//             if (grade > highest) {
//                 highest = grade;
//             }
//         }
//         return highest;
//     }

//     // Function to calculate and return the lowest grade
//     public static double calculateLowest() {
//         double lowest = grades.get(0);
//         for (double grade : grades) {
//             if (grade < lowest) {
//                 lowest = grade;
//             }
//         }
//         return lowest;
//     }
// }

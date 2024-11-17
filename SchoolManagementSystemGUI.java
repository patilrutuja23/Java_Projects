import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student 
{
    String ID;
    String Name;
    String Classes;
    String Grade;
    String RollNum;

    public Student(String ID, String Name, String Classes, String Grade, String RollNum) 
    {
        this.ID = ID;
        this.Name = Name;
        this.Classes = Classes;
        this.Grade = Grade;
        this.RollNum = RollNum;
    }

    public String toString() 
    {
        return "ID: " + ID + "\n" +
               "Name: " + Name + "\n" +
               "Class: " + Classes + "\n" +
               "Grade: " + Grade + "\n" +
               "Roll Number: " + RollNum + "\n";
    }
}

class Teacher 
{
    String ID;
    String Name;
    String Classes;
    String Subject;

    public Teacher(String ID, String Name, String Classes, String Subject) 
    {
        this.ID = ID;
        this.Name = Name;
        this.Classes = Classes;
        this.Subject = Subject;
    }

    public String toString() 
    {
        return "ID: " + ID + "\n" +
               "Name: " + Name + "\n" +
               "Class: " + Classes + "\n" +
               "Subject: " + Subject + "\n";
    }
}

class Course 
{
    String courseName;
    String courseCode;
    String teacher;

    public Course(String courseName, String courseCode, String teacher) 
    {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.teacher = teacher;
    }

    public String toString() 
    {
        return "Course Name: " + courseName + "\n" +
               "Course Code: " + courseCode + "\n" +
               "Teacher: " + teacher + "\n";
    }
}

public class SchoolManagementSystemGUI extends JFrame 
{
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    
    static JPanel cardPanel;
    static JTextArea displayArea;

    static JTextField idField, nameField, classField, gradeField, rollNumField, courseNameField, courseCodeField, teacherField;

    public SchoolManagementSystemGUI() 
    {
        setTitle("School Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        String[] actions = {"Add Student", "View Students", "Add Teacher", "View Teachers", "Add Course", "View Courses"};
        JComboBox<String> actionsComboBox = new JComboBox<>(actions);
        actionsComboBox.setPreferredSize(new Dimension(200, 30));

        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        actionsComboBox.addActionListener(e -> updateFormForAction((String) actionsComboBox.getSelectedItem()));

        cardPanel = new JPanel(new CardLayout());

        cardPanel.add(createAddStudentForm(), "Add Student");
        cardPanel.add(createViewStudentsPanel(), "View Students");
        cardPanel.add(createAddTeacherForm(), "Add Teacher");
        cardPanel.add(createViewTeachersPanel(), "View Teachers");
        cardPanel.add(createAddCourseForm(), "Add Course");
        cardPanel.add(createViewCoursesPanel(), "View Courses");

        JPanel topPanel = new JPanel();
        topPanel.add(actionsComboBox);
        topPanel.add(submitButton);
        topPanel.add(clearButton);

        add(topPanel, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        submitButton.addActionListener(e -> handleAction(actionsComboBox.getSelectedItem().toString()));
        clearButton.addActionListener(e -> clearFields());

        setVisible(true);
    }

    private JPanel createAddStudentForm() 
    {
        JPanel panel = new JPanel(new GridLayout(6, 2));
        idField = new JTextField(10);
        nameField = new JTextField(10);
        classField = new JTextField(10);
        gradeField = new JTextField(10);
        rollNumField = new JTextField(10);

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Class:"));
        panel.add(classField);
        panel.add(new JLabel("Grade:"));
        panel.add(gradeField);
        panel.add(new JLabel("Roll Number:"));
        panel.add(rollNumField);

        return panel;
    }

    private JPanel createAddTeacherForm() 
    {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        idField = new JTextField(10);
        nameField = new JTextField(10);
        classField = new JTextField(10);
        teacherField = new JTextField(10); 

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Class:"));
        panel.add(classField);
        panel.add(new JLabel("Teacher:"));
        panel.add(teacherField);

        return panel;
    }

    private JPanel createAddCourseForm() 
    {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        courseNameField = new JTextField(10);
        courseCodeField = new JTextField(10);
        teacherField = new JTextField(10); // Teacher for the course

        panel.add(new JLabel("Course Name:"));
        panel.add(courseNameField);
        panel.add(new JLabel("Course Code:"));
        panel.add(courseCodeField);
        panel.add(new JLabel("Teacher:"));
        panel.add(teacherField);

        return panel;
    }

    private JPanel createViewStudentsPanel() 
    {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student).append("\n");
        }
        textArea.setText(sb.toString());

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createViewTeachersPanel() 
    {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        StringBuilder sb = new StringBuilder();
        for (Teacher teacher : teachers) {
            sb.append(teacher).append("\n");
        }
        textArea.setText(sb.toString());

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createViewCoursesPanel() 
    {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        StringBuilder sb = new StringBuilder();
        for (Course course : courses) {
            sb.append(course).append("\n");
        }
        textArea.setText(sb.toString());

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void updateFormForAction(String action) 
    {
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, action);
    }

    private void handleAction(String action) 
    {
        switch (action) 
        {
            case "Add Student":
                addStudent();
                break;
            case "Add Teacher":
                addTeacher();
                break;
            case "Add Course":
                addCourse();
                break;
            case "View Students":
                viewStudents();
                break;
            case "View Teachers":
                viewTeachers();
                break;
            case "View Courses":
                viewCourses();
                break;
        }
    }

    private void addStudent() 
    {
        String id = idField.getText();
        String name = nameField.getText();
        String classes = classField.getText();
        String grade = gradeField.getText();
        String rollNum = rollNumField.getText();

        students.add(new Student(id, name, classes, grade, rollNum));

        displayArea.setText("Student Added Successfully!\n");

        clearFields();
    }

    private void addTeacher() 
    {
        String id = idField.getText();
        String name = nameField.getText();
        String classes = classField.getText();
        String teacher = teacherField.getText();

        teachers.add(new Teacher(id, name, classes, teacher));
        displayArea.setText("Teacher Added Successfully!\n");

        clearFields(); 
    }

    private void addCourse() 
    {
        String courseName = courseNameField.getText();
        String courseCode = courseCodeField.getText();
        String teacher = teacherField.getText();

        courses.add(new Course(courseName, courseCode, teacher));
        displayArea.setText("Course Added Successfully!\n");

        clearFields(); 
    }

    private void viewStudents() 
    {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) 
        {
            sb.append(student).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    private void viewTeachers() 
    {
        StringBuilder sb = new StringBuilder();
        for (Teacher teacher : teachers) 
        {
            sb.append(teacher).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    private void viewCourses() 
    {
        StringBuilder sb = new StringBuilder();
        for (Course course : courses) 
        {
            sb.append(course).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        classField.setText("");
        gradeField.setText("");
        rollNumField.setText("");
        courseNameField.setText("");
        courseCodeField.setText("");
        teacherField.setText("");
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new SchoolManagementSystemGUI());
    }
}
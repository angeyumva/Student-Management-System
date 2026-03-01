import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends JFrame {
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private JTextField nameField, emailField, courseField, marksField;
    private JComboBox<String> courseComboBox;
    private List<Student> students;

    public MainPage() {
        students = new ArrayList<>();
        setTitle("Student Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Input Fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Course:"));
        courseField = new JTextField();
        inputPanel.add(courseField);

        inputPanel.add(new JLabel("Marks:"));
        marksField = new JTextField();
        inputPanel.add(marksField);

        courseComboBox = new JComboBox<>(new String[]{"Course 1", "Course 2", "Course 3"});
        inputPanel.add(courseComboBox);

        add(inputPanel, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton searchButton = new JButton("Search");
        JButton showAllButton = new JButton("Show All");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(showAllButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Table
        tableModel = new DefaultTableModel(new String[]{"Name", "Email", "Course", "Marks"}, 0);
        studentTable = new JTable(tableModel);
        add(new JScrollPane(studentTable), BorderLayout.SOUTH);

        // Button Actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllStudents();
            }
        });
    }

    private void addStudent() {
        String name = nameField.getText();
        String email = emailField.getText();
        String course = (String) courseComboBox.getSelectedItem();
        String marks = marksField.getText();

        tableModel.addRow(new Object[]{name, email, course, marks});
        students.add(new Student(name, email, course, Integer.parseInt(marks)));
    }

    private void updateStudent() {
        // Update Student Implementation
    }

    private void deleteStudent() {
        // Delete Student Implementation
    }

    private void searchStudent() {
        // Search Student Implementation
    }

    private void showAllStudents() {
        // Show All Students Implementation
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainPage().setVisible(true);
        });
    }

    private class Student {
        String name;
        String email;
        String course;
        int marks;

        public Student(String name, String email, String course, int marks) {
            this.name = name;
            this.email = email;
            this.course = course;
            this.marks = marks;
        }
    }
}
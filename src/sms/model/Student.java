package sms.model;

public class Student extends Person {
    private int id;
    private String course;
    private int marks;

    public Student(int id, String name, String email, String course, int marks) {
        super(name, email);
        this.id = id;
        this.course = course;
        this.marks = marks;
    }

    public Student(String name, String email, String course, int marks) {
        this(0, name, email, course, marks);
    }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + name + " | " + email + " | " + course + " | " + marks);
    }

    public int getId() { return id; }
    public String getCourse() { return course; }
    public int getMarks() { return marks; }
    public void setId(int id) { this.id = id; }
    public void setCourse(String course) { this.course = course; }
    public void setMarks(int marks) { this.marks = marks; }
}
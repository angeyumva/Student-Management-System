public class Student extends Person implements DatabaseOperations {
    private int id;
    private String course;
    private double marks;

    public Student(int id, String course, double marks) {
        this.id = id;
        this.course = course;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    // Implement methods from DatabaseOperations interface
}

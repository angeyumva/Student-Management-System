public class Student extends Person implements DatabaseOperations {
    private int id;
    private String course;
    private double marks;

    public Student(int id, String name, String email, String course, double marks) {
        super(name, email);
        this.id = id;
        this.course = course;
        this.marks = marks;
    }

    public Student(int id, String name, String email) {
        super(name, email);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + id + ", Name: " + name + ", Email: " + email + ", Course: " + course + ", Marks: " + marks);
    }

    @Override
    public void add(Object obj) {
        // Implementation will be in StudentDAO
    }

    @Override
    public void delete(int id) {
        // Implementation will be in StudentDAO
    }

    @Override
    public void update(Object obj) {
        // Implementation will be in StudentDAO
    }

    @Override
    public Object search(int id) {
        // Implementation will be in StudentDAO
        return null;
    }
}
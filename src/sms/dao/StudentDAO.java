package sms.dao;

import sms.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public boolean insert(Student s) {
        String sql = "INSERT INTO students(name,email,course,marks) VALUES (?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getMarks());

            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Insert error: " + e.getMessage());
            return false;
        }
    }

    public boolean update(Student s) {
        String sql = "UPDATE students SET name=?, email=?, course=?, marks=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getMarks());
            ps.setInt(5, s.getId());

            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
            return false;
        }
    }

    public List<Student> getAll() {
        String sql = "SELECT id,name,email,course,marks FROM students ORDER BY id DESC";
        List<Student> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course"),
                        rs.getInt("marks")
                ));
            }
        } catch (SQLException e) {
            System.out.println("GetAll error: " + e.getMessage());
        }
        return list;
    }

    public List<Student> search(String keyword) {
        String sql = """
            SELECT id,name,email,course,marks
            FROM students
            WHERE lower(name) LIKE ? OR lower(email) LIKE ? OR lower(course) LIKE ?
            ORDER BY id DESC
        """;
        List<Student> list = new ArrayList<>();
        String k = "%" + keyword.toLowerCase() + "%";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, k);
            ps.setString(2, k);
            ps.setString(3, k);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("course"),
                            rs.getInt("marks")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Search error: " + e.getMessage());
        }
        return list;
    }
}
package sms.dao;

public class DbTest {
    public static void main(String[] args) {
        DBConnection.initDatabase();
        System.out.println("✅ Database created and table ready!");
    }
}
import java.sql.*;

public class JDBCExample {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/students";

    static final String USER = "root";
    static final String PASSWORD = "password";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql;
        sql = "SELECT * FROM students";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: $" + salary);
        }
        
        resultSet.close();
        statement.close();
        connection.close();
    }
}


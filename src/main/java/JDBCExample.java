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

        sql = "SELECT * FROM Students";
	sql = "SELECT * FROM Students WHERE Group = 'Психологический'";
	sql = "SELECT * FROM Students WHERE Year = 1998"



        ResultSet resultSet = statement.executeQuery(sql);



        while (resultSet.next()) {

            int id = resultSet.getInt("id");

            String name = resultSet.getString("FIO");

            String group = resultSet.getString("Group");

            int year = resultSet.getInt("Year");



            System.out.println("id: " + id);

            System.out.println("FIO: " + name);

            System.out.println("Group: " + group);

            System.out.println("Year" + year);

        }

        

        resultSet.close();

        statement.close();

        connection.close();

    }

}


import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/student?"
                        + "useSSL=false&user=root&password=root");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select id, city from CITY");

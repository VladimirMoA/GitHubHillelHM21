import java.sql.*;
public class JDBCExample {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/Students";

    static final String USER = "root";
    static final String PASSWORD = "password";

    public static String listOfStudents() {
        return "SELECT * FROM students";
    }

    public static String listOfGroupStudents() {
        return "SELECT * FROM students WHERE group = 'Психологический'";
    }

    public static String listOfYearStudents() {
        return "SELECT * FROM students WHERE year = 1998";
    }

    public static String specificStudent() {
        return "SELECT Students.students, Points.lesson, Lesson.teacher, Points.point FROM Points, Lesson WHERE Students.students = 'Анатолий Викторович Полено'";
    }

    public static String avgStudentPoints() {
        return "SELECT Students.students, AVG(Points.point) WHERE Students.students = 'Анатолий Викторович Полено'";
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();

        String sql;

        sql = listOfStudents();
        sql = listOfGroupStudents();
        sql = listOfYearStudents();
        sql = specificStudent();
        sql = avgStudentPoints();

        ResultSet resultSet = statement.executeQuery(sql);

        if (sql == listOfStudents() || sql == listOfGroupStudents() || sql == listOfYearStudents()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("FIO");
                String group = resultSet.getString("group");
                int year = resultSet.getInt("year");

                System.out.println("id: " + id);
                System.out.println("FIO: " + name);
                System.out.println("Group: " + group);
                System.out.println("Year" + year);
            }
        }

        if (sql == specificStudent()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("FIO");
                String lesson = resultSet.getString("lesson");
                String teacher = resultSet.getString("teacher");
                int points = resultSet.getInt("points");

                System.out.println("id: " + id);
                System.out.println("FIO: " + name);
                System.out.println("Lesson: " + lesson);
                System.out.println("Teacher" + teacher);
                System.out.println("Points" + points);
            }
        }

        if (sql == avgStudentPoints()) {
            while (resultSet.next()) {
                String name = resultSet.getString("FIO");


                System.out.println("FIO: " + name);
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
    }
}

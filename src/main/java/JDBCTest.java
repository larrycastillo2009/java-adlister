import java.sql.*;
import java.util.ArrayList;
import com.mysql.cj.jdbc.Driver;

public class JDBCTest {

    private static ArrayList<String> getEmployeesFirstNames() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                "root",
                "codeup"
        );

        Statement statement = connection.createStatement();

        String query = "SELECT first_name From employees.employees";

        ResultSet rs = statement.executeQuery(query);

        rs.next();

        ArrayList<String> names = new ArrayList<String>();
        names.add(rs.getString("first_name"));
        rs.next();
        names.add(rs.getString("first_name"));
        rs.next();
        names.add(rs.getString("first_name"));
        rs.next();
        names.add(rs.getString("first_name"));
        rs.next();
        names.add(rs.getString("first_name"));
        rs.next();
        names.add(rs.getString("first_name"));
        rs.next();
        names.add(rs.getString("first_name"));
        rs.next();
        names.add(rs.getString("first_name"));
        rs.next();
        names.add(rs.getString("first_name"));
        rs.next();
        names.add(rs.getString("first_name"));

        return names;
    }

    private static ArrayList<String> getEmployeesFirstNames(int times) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                "root",
                "codeup"
        );

        Statement statement = connection.createStatement();

        String query = "SELECT first_name From employees.employees";

        ResultSet rs = statement.executeQuery(query);

        ArrayList<String> names = new ArrayList<String>();

        for(int i = 0; i < times; i++){
            rs.next();
            names.add(rs.getString("first_name"));
        }



        return names;
//
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getEmployeesFirstNames());
        System.out.println(getEmployeesFirstNames(15));
    }
}

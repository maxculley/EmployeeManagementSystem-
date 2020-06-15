package Database;

import java.sql.*;

public class DataBaseRequests {

    public static String isEmployee(int ID) throws ClassNotFoundException {
        String query = "SELECT employee_type FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("employee_type");

        } catch (Exception e) {
            return "User input is invalid";
        }
    }

    public static String getFirstName(int ID) throws ClassNotFoundException {
        String query = "SELECT first_name FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("first_name");

        } catch (Exception e) {
            return "User input is invalid";
        }
    }

    public static String getLastName(int ID) throws ClassNotFoundException {
        String query = "SELECT last_name FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("last_name");

        } catch (Exception e) {
            return "User input is invalid";
        }
    }

    public static String getGender(int ID) throws ClassNotFoundException {
        String query = "SELECT gender FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("gender");

        } catch (Exception e) {
            return "User input is invalid";
        }
    }
}

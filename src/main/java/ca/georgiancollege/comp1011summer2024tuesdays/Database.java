package ca.georgiancollege.comp1011summer2024tuesdays;

import java.sql.*;
import java.util.Properties;

public class Database {

    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql",
                    "admin", "password");

            Statement statement = connection.createStatement();

            statement.execute("");// sql query with no result
            ResultSet result = statement.executeQuery(""); //returns rows

            
        }
        catch (SQLException e){
            System.err.println(e);
        }

    }
}

package ca.georgiancollege.comp1011summer2024tuesdays;

import java.sql.*;

public class DBUtil {

    //Connection String
    //username
    //password
    //database
    private String connectionString, username, password, database;
    private String table;

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public DBUtil(String database) {
        this.database = database;
        connectionString = "jdbc:mysql://database-1.cr4g0gw0k10a.us-west-2.rds.amazonaws.com:3306";
        username = "admin";
        password = "";

        try{
            connection = DriverManager.getConnection(
                    connectionString + "/" + database,
                    username, password);
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void queryExec(String sql) throws Exception{
        statement = connection.createStatement();
        statement.execute(sql);
    }
    public ResultSet queryResult(String sql) throws SQLException{

        preparedStatement = connection.prepareStatement(sql);

        return preparedStatement.executeQuery();

    }


}

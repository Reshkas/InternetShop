package store.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class DBConnector {

    private String dbDevName;
    private String host;
    private String port;
    private String user;
    private String password;
    private String nameDb;
    private String url;

    private Connection sqlConnect;

    public DBConnector(){

        Properties dbConfig = new Properties();

        FileInputStream in = null;

        try {
            in = new FileInputStream("./src/main/resources/dbConfig.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbConfig.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.dbDevName = dbConfig.getProperty("dbDevName");
        this.host = dbConfig.getProperty("host");
        this.port = dbConfig.getProperty("port");
        this.user = dbConfig.getProperty("user");
        this.password = dbConfig.getProperty("password");
        this.nameDb = dbConfig.getProperty("nameDb");
    }

    public void init() {
        if (sqlConnect == null) {
            url = "jdbc:" + dbDevName + "://" + host + ":" + port + "/" + nameDb;

            try {

                Class.forName("org.postgresql.Driver");
                sqlConnect = DriverManager.getConnection(url, user, password);

                System.out.println("Соединение с БД " + dbDevName + " установлено");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet query(String query) {

        ResultSet result = null;

        try {
            Statement stmt = sqlConnect.createStatement();
            result = stmt.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                sqlConnect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;

    }

    public  void cuidQuery ( String query){

        try {
            Statement stmt = sqlConnect.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                sqlConnect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeSqlConnect() {

        try {
            sqlConnect.close();
            sqlConnect = null;
            System.out.println("Соединение с БД " + dbDevName + " разорвано");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

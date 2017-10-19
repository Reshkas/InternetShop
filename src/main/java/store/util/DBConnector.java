package store.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnector {

    private String user;
    private String password;
    private String url;
    private String driver;
    private Connection sqlConnect;

    private static DBConnector instance;

    private DBConnector() {

        Properties dbConfig = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream("./src/main/resources/dbConfig.properties")) {

            dbConfig.load(fileInputStream);
            this.url = dbConfig.getProperty("url");
            this.driver = dbConfig.getProperty("driver");
            this.user = dbConfig.getProperty("user");
            this.password = dbConfig.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            Class.forName(driver);
            sqlConnect = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DBConnector init() {

        if (instance == null) {

            instance = new DBConnector();
        }
        return instance;
    }

    public Connection getSqlConnect() {

        if (sqlConnect == null) {
            try {
                sqlConnect = DriverManager.getConnection(url, user, password);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return sqlConnect;
    }

    public void closeSqlConnect() {

        try {
            sqlConnect.close();
            sqlConnect = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

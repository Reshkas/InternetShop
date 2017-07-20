package store;

import store.businesLogik.*;
import store.dao.impl.*;
import store.model.*;

import org.apache.commons.codec.digest.DigestUtils;
import store.security.Authentication;
import store.util.DBConnector;


import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {


//        Properties dbConfig = new Properties();
//
//        FileInputStream in = null;
//
//        try {
//            in = new FileInputStream("./src/main/resources/dbConfig.properties");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            dbConfig.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        DBConnector connectPostgres = new DBConnector(dbConfig.getProperty("dbDevName"),
//                dbConfig.getProperty("host"),dbConfig.getProperty("port"),dbConfig.getProperty("user"),
//                dbConfig.getProperty("password"),dbConfig.getProperty("nameDb"));

        DBConnector connectPostgres = new DBConnector();

        connectPostgres.init();

        Store store = Store.getInstance();


        ProductDaoImpl product = new ProductDaoImpl("mouse", 30, 10.5f, "description", 1122);


        //connectPostgres.cuidQuery("CREATE TABLE users (login varchar(64), password varchar(64))");

/*        for (int i = 0; i < 10; i++) {

            String heshPassword = md5ApacheExample("password" + i);
            String sql = "INSERT INTO users VALUES(DEFAULT,'login" + i + "','" + heshPassword + "','ADMIN')";

            connectPostgres.cuidQuery(sql);
        }
*/
        //connectPostgres.cuidQuery("UPDATE users SET login = 'login25' WHERE login = 'login5'");

        //ResultSet resultUsers = connectPostgres.query("SELECT password FROM users where login = 'login1'");

        //String myLogin = md5ApacheExample("password1");
        //System.out.println(myLogin);

        /*try {
            while (resultUsers.next()) {

                //String login = resultUsers.getString("login");
                String password = resultUsers.getString("password");
                //System.out.println(login + " : " + password);
                System.out.println(password);

                if(password.equals(myLogin) & password != myLogin ){

                    System.out.println("Пароль правильный!");
                }else{
                    System.out.println("Не угадал!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        //connectPostgres.cuidQuery("TRUNCATE users");


        ResultSet resultInfo = store.getInfoProduct("Мышка");
        try {
            System.out.println("Название " + "  Цена  " + "     Описание          ");
            while (resultInfo.next()) {
                String name = resultInfo.getString("name");
                float price = resultInfo.getFloat("price");
                String description = resultInfo.getString("description");

                System.out.println(name + "    | " + price + " | " + description);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        store.updDescription("Мышка", "Мышка как мышка...");

        //store.addProduct(product);

        store.delProduct(4);

        store.updNameProduct("Мышка", "Мышь");

        store.updAmountProduct(3, 22);

        store.updPriceProduct(3, 45.35f);

        System.out.println(store.getAllProductName());

        System.out.println(store.getAllInfoProduct("Мышка"));

/** Тестирование класса авторизации */

        User user1 = new User("login1", "password1");

        Authentication authoriz = new Authentication();

        authoriz.getAuthorization(user1);


        //connectPostgres.closeSqlConnect();


    }

    private static String md5ApacheExample(String text) {
        return DigestUtils.md5Hex(text);
    }
}

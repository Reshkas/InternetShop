package store.businesLogik;

import store.util.DBConnector;
import store.dao.impl.ProductDaoImpl;

import java.sql.ResultSet;

public class Store {

    private static Store inctance = new Store();

    private Store() {

    }

    public static Store getInstance() {

        return inctance;
    }

    DBConnector connectStore = new DBConnector();


    public ResultSet getInfoProduct(String productName) {

        connectStore.init();

        ResultSet resultInfo = connectStore.query("SELECT name,price,description FROM store where name = '" + productName + "'");

        connectStore.closeSqlConnect();

        System.out.println(resultInfo.toString());

        return resultInfo;
    }

    public ResultSet getAllProductName() {

        connectStore.init();

        ResultSet resultAllProductName = connectStore.query("SELECT name FROM store");

        connectStore.closeSqlConnect();

        return resultAllProductName;
    }

    public ResultSet getAllInfoProduct(String productName) {

        connectStore.init();

        ResultSet getAllInfoProduct = connectStore.query("SELECT * FROM store where name = '+" + productName + "'");

        connectStore.closeSqlConnect();

        return getAllInfoProduct;

    }

    public void updDescription(String productName, String newDescription) {

        connectStore.init();

        connectStore.cuidQuery("UPDATE store SET description ='" + newDescription + "'" + "where name = '" + productName + "'");

        connectStore.closeSqlConnect();

    }

    public void addProduct(ProductDaoImpl product) {

        connectStore.init();

        connectStore.cuidQuery("INSERT INTO store VALUES (DEFAULT, '" + product.getName() + "', "
                + product.getAmount() + ", " + product.getPrice() + ", '" + product.getDescription() + "')");

        connectStore.closeSqlConnect();

    }

    public void delProduct(int id) {

        connectStore.init();

        connectStore.cuidQuery("DELETE FROM store where id =" + id + "");

        connectStore.closeSqlConnect();

    }

    public void updNameProduct(String oldName, String newName) {

        connectStore.init();

        connectStore.cuidQuery("UPDATE store SET name ='" + newName + "' where name = '" + oldName + "'");

        connectStore.closeSqlConnect();

    }

    public void updAmountProduct(int id, int newAmount) {

        connectStore.init();

        connectStore.cuidQuery("UPDATE store SET amount = '" + newAmount + "' where id = " + id);

        connectStore.closeSqlConnect();

    }

    public void updPriceProduct(int id, float newPrice) {

        connectStore.init();

        connectStore.cuidQuery("UPDATE store SET price = " + newPrice + " where id =" + id);

        connectStore.closeSqlConnect();

    }

}

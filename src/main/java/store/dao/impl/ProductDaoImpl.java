package store.dao.impl;

import store.dao.IProduct;

public class ProductDaoImpl implements IProduct {

    private int id;

    private String name;
    private int amount;
    private float price;
    private String description;
    private int productCode;

    public ProductDaoImpl( String name, int amount, float price, String description, int productCode) {

        this.name = name;
        this.amount = amount;
        this.price = price;
        this.description = description;
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getProductCode() {
        return productCode;
    }
}

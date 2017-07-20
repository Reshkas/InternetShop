package store.model;


public class Product {

    private int id;

    private String name;
    private float amount;
    private float price;
    private int productCode;
    private String description;

    public Product(){

    }

    public Product(int id, String name, float amount, float price, int productCode, String description) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.productCode = productCode;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

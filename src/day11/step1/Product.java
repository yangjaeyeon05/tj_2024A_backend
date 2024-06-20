package day11.step1;

public class Product {
    private int productCode;
    private String productName;
    private int productPrice;
    private int categoryCode;

    public Product(int productCode, String productName, int productPrice, int categoryCode) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryCode = categoryCode;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode=" + productCode +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", categoryCode=" + categoryCode +
                '}';
    }
}

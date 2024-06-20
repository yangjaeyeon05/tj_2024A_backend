package day11.step2;

public class Product {
    private int productCode;
    private String productName;
    private int productPrice;
    private int categoryCode;
    private static int count = 1;

    public Product(String productName, int productPrice, int categoryCode) {
        this.productCode = count;
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryCode = categoryCode;
        count++;
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

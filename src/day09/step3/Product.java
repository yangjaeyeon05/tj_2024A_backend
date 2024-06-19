package day09.step3;

public class Product {
    String productCode;
    String productName;
    int productPrice;

    public Product(String productCode, String productName, int productPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}

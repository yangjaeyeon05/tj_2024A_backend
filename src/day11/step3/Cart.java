package day11.step3;

public class Cart {
    private int cartCode;
    private int productCode;
    private int amount;

    public Cart(int cartCode, int productCode, int amount) {
        this.cartCode = cartCode;
        this.productCode = productCode;
        this.amount = amount;
    }

    public int getCartCode() {
        return cartCode;
    }

    public void setCartCode(int cartCode) {
        this.cartCode = cartCode;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartCode=" + cartCode +
                ", productCode=" + productCode +
                ", amount=" + amount +
                '}';
    }
}

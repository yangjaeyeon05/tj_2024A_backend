package day11.step3;

public class OrderDetail {
    private int orderDetailCode;    // 주문마다 자동 증가
    private int productCode;        // 카트에서 넘어오는 속성.
    private int orderAmount;        // 카트에서 넘어오는 속성.
    static int orderdetailCount = 1;

    public int getOrderDetailCode() {
        return orderDetailCode;
    }

    public void setOrderDetailCode(int orderDetailCode) {
        this.orderDetailCode = orderdetailCount;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }


    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailCode=" + orderDetailCode +
                ", productCode=" + productCode +
                ", orderAmount=" + orderAmount +
                '}';
    }
}

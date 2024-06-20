package day11.step1;

import java.util.ArrayList;

public class Order {
    private int orderCode;
    private String orderTime;
    ArrayList<OrderDetail> orderDetailList;

    public Order(int orderCode, String orderTime) {
        this.orderCode = orderCode;
        this.orderTime = orderTime;
        orderDetailList = new ArrayList<OrderDetail>();
    }

    public void addOrderDetail(int orderDetailCode, int productCode, int orderAmount){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailCode(orderDetailCode);
        orderDetail.setProductCode(productCode);
        orderDetail.setOrderAmount(orderAmount);
        orderDetailList.add(orderDetail);
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderCode=" + orderCode +
                ", orderTime='" + orderTime + '\'' +
                ", orderDetailList=" + orderDetailList +
                '}';
    }
}

package day11.step2;

import java.util.ArrayList;

import static day11.step2.OrderDetail.orderdetailCount;

public class Order {
    private int orderCode;
    private String orderTime;
    ArrayList<OrderDetail> orderDetailList;
    private static int count = 1;

    public Order(String orderTime) {
        this.orderCode = count;
        this.orderTime = orderTime;
        orderDetailList = new ArrayList<OrderDetail>();
        count++;
    }

    public void addOrderDetail(int productCode, int orderAmount){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailCode(orderdetailCount);
        orderDetail.setProductCode(productCode);
        orderDetail.setOrderAmount(orderAmount);
        orderDetailList.add(orderDetail);
        orderdetailCount++;

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

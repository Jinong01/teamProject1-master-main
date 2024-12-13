package com.koreait.coffee.model.dto;

public class OrderDetail {
    private Integer id;
    private String name;
    private Integer orderId;
    private Integer dishId;
    private Integer number;
    private Double price;

    public OrderDetail(Integer id, String name, Integer orderId, Integer dishId, Integer number, Double price) {
        this.id = id;
        this.name = name;
        this.orderId = orderId;
        this.dishId = dishId;
        this.number = number;
        this.price = price;
    }

    public OrderDetail(String name, Integer orderId, Integer dishId, Integer number, Double price) {
        this.name = name;
        this.orderId = orderId;
        this.dishId = dishId;
        this.number = number;
        this.price = price;
    }

    public OrderDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderId=" + orderId +
                ", dishId=" + dishId +
                ", number=" + number +
                ", price=" + price +
                '}';
    }
}

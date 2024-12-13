package com.koreait.coffee.model.dto;

public class Dish {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Integer price;
    private Integer status;
    private Temperature temperature;
    private Shot shot;

    public Dish(Integer id, String name, Integer categoryId, Integer price, Integer status, Temperature temperature, Shot shot) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.status = status;
        this.temperature = temperature;
        this.shot = shot;
    }


    public Dish() {
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", status=" + status +
                ", temperature=" + temperature +
                ", shot=" + shot +
                '}';
    }
}

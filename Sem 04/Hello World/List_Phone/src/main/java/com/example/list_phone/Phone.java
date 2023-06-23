package com.example.list_phone;

public class Phone {

    private int id;
    private String name;
    private String brand;
    private String price;
    private  String description;

    public Phone(String name, String brand, String price, String description){
        this.name=name;
        this.brand = brand;
        this.price = price;
        this.description=description;

    }
    public Phone( int id, String name, String brand, String price, String description){
        this.id = id;
        this.name=name;
        this.brand = brand;
        this.price = price;
        this.description=description;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString(){
        return "Phone [id="+ id +", name=" + name +", brand=" +brand + "," +
                "price=" + price + ",description =" + description  +"]";
    }
}

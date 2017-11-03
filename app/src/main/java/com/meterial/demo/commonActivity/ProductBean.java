package com.meterial.demo.commonActivity;

public class ProductBean {
    private String img;
    private String name;
    private String intro;
    private String price;
 
    public ProductBean(String img, String name, String intro, String price) {
        this.img = img;
        this.name = name;
        this.intro = intro;
        this.price = price;
    } 
 
    public String getImg() {
        return img;
    } 
 
    public void setImg(String img) {
        this.img = img;
    } 
 
    public String getName() {
        return name;
    } 
 
    public void setName(String name) {
        this.name = name;
    } 
 
    public String getIntro() {
        return intro;
    } 
 
    public void setIntro(String intro) {
        this.intro = intro;
    } 
 
    public String getPrice() {
        return price;
    } 
 
    public void setPrice(String price) {
        this.price = price;
    } 
} 

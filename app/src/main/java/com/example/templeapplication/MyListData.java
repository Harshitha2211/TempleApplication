package com.example.templeapplication;

public class MyListData extends MainActivity {
    String item;
    int amount;
    int imgid;


    public MyListData(String item, int amount, int imgid) {
        this.item = item;
        this.amount = amount;
        this.imgid = imgid;
    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}

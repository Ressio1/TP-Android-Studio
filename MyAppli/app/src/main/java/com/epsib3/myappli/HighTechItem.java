package com.epsib3.myappli;

public class HighTechItem {

    //field
    private String name;
    private String mnemonic;
    private double price;
    private String url;
    //constructor
    public HighTechItem(String name, String mnemonic, double price, String url){
        this.name = name;
        this.mnemonic = mnemonic;
        this.price = price;
        this.url = url;
    }
    //methods
    public String getName(){ return name; }
    public String getMnemonic(){ return mnemonic; }
    public double getPrice(){ return price; }
    public String geturl(){ return url; }
}

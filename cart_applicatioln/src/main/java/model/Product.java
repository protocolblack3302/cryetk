package model;


import java.io.Serializable;
import java.text.NumberFormat;

class Product implements Serializable {
private String code;
private String description;
private double price;

public Product(){
	code="";
	description="";
	price=0;
}

public void setCode(String code){
	this.code=code;

}

public String getCode() {return code;}
public String getDescription() {return description;}

public void setDescription(String description){
	this.description=description;


}
public void setPrice(double price){
	this.price=price;
}

public double getPrice(){
	return price;
}


public String getPriceCurrencyFormat(){
	NumberFormat currency= NumberFormat.getCurrencyInstance();
	return currency.format(price);
}

}


	


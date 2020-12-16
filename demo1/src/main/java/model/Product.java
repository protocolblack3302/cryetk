package model;

import java.io.Serializable;
import java.util.Currency;
import java.util.Locale;

public class Product implements Serializable {
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
Currency c=Currency.getInstance(Locale.getDefault());
return c.getSymbol()+getPrice();
}

}


	


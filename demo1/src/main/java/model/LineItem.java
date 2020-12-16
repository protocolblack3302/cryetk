package model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class LineItem implements Serializable {

	private Product product;
	private int quantity;
	public LineItem(){

	}

	public void setProduct(Product product){
		this.product = product;

	}

	public Product getProduct(){
		return product;

	}

	public void setQuantity(int quantity){

		this.quantity = quantity;

	}

	public int getQuantity(){
		return quantity;

	}

	public double getTotal(){

		return product.getPrice()*quantity;
	}

	public String getTotalCurrencyFormat(){
		Currency c=Currency.getInstance(Locale.getDefault());
		return  c.getSymbol(Locale.US)+getTotal();
	}
}
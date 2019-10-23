package csv;

import java.util.Date;

public class Apple {
	
	private String name;
	private int price;
	private Date day;
	
	public Apple() {
		super();
	}
	
	public Apple(String name, int price, Date day) {
		super();
		this.name = name;
		this.price = price;
		this.day = day;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	
	@Override
	public String toString() {
		return "Apple [name=" + name + ", price=" + price + ", day=" + day + "]";
	}
		

}

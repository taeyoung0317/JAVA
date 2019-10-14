package domain;

import java.util.Date;

public class Buy {
	
	private int buycode;
	private String itemname;
	private String customerid;
	private int count;
	private Date buydate;
	
	public int getBuycode() {
		return buycode;
	}
	public void setBuycode(int buycode) {
		this.buycode = buycode;
	}
	public String getItmename() {
		return itemname;
	}
	public void setItmename(String itmename) {
		this.itemname = itmename;
	}
	public String getCostumerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getBuydate() {
		return buydate;
	}
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}
	
	@Override
	public String toString() {
		return "Buy [buycode=" + buycode + ", itemname=" + itemname + ", customerid=" + customerid + ", count=" + count
				+ ", buydate=" + buydate + "]";
	}
	

}

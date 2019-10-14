package main;

import dao.BuyDao;

public class Main {

	public static void main(String[] args) {
		BuyDao dao = new BuyDao();
		
		System.out.printf("%s\n", dao.getBuy(4));
		
	}

}

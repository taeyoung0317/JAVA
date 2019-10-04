package multithread;

public class Consumer extends Thread {
	Product product;
	
	public Consumer(Product product) {
		this.product = product;
	}

	public void run() {
		for(int i=0;i<26;i=i+1) {
			product.get();
		}
	}
}

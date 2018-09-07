package DemoTest;

public class threadlocaltestmain {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new ThreadLocalTest());
		Thread t2 = new Thread(new ThreadLocalTest());
//		Thread t3 = new Thread(new ThreadLocalTest(t1,"111"));
//		Thread t4 = new Thread(new ThreadLocalTest(t2,"222"));
////		Thread t5 = new Thread(t);
		
		t1.start();;
		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
		
	}

}

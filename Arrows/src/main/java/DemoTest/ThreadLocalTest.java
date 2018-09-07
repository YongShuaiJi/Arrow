package DemoTest;

public class ThreadLocalTest implements Runnable {
	
	private static String type;
	public static final ThreadLocal Threads = new ThreadLocal();
	public static Thread thread;
	ThreadLocalTest(){
		synchronized(this){
			
		}
		
	}
	

	public void run() {
		System.out.println(type+Thread.currentThread().getName());
		Threads.set(type);
		
		System.out.println(Threads.get());
	}
}
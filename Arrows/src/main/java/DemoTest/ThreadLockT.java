package DemoTest;

public class ThreadLockT {
public static final ThreadLocal Threads = new ThreadLocal();
public static void main(String[] args) {
	Threads.set("111");
	Threads.set("222");
	System.out.println(Threads.get());
}
	

}
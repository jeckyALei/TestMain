package search;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchTest {

	public static void main(String[] args) {
		// ServiceLoader<Search> s = ServiceLoader.load(Search.class);
		// Iterator<Search> searchs = s.iterator();
		// if (searchs.hasNext()) {
		// Search curSearch = searchs.next();
		// curSearch.search("test");
		// }
		// System.out.println("000000");
		final String name = "alei";
		final String uname = "alei";
		final AtomicInteger num = new AtomicInteger(0);
				new Thread(new Runnable() {
					@Override
					public void run() {
						out(num.get(), name);
					}
				}).start();;
				new Thread(new Runnable() {
					@Override
					public void run() {
						out(num.get(), uname);
					}
				}).start();;

	}

	public static void out(int num, String name) {
		synchronized (name) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println(name);
		}
	}
}
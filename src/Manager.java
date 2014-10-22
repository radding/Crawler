import java.net.URL;
import java.util.Queue;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Manager {
	
	public Queue <String> urlsToOpen;
//	public Queue <URL> urls;
	public String baseURL;
	public final ReentrantLock lock;
	
	List <Thread> lisOfThreads;
	List <String> results;
	List <String> previousURL;
	int amountOfOpeningThreads;
	int amountOfURLThreads;
	
	
	public Manager(){
		lock = new ReentrantLock();
	}
	
	public int CreateNewThread(){
		
		return 1;
	}
	
	public void addURL(boolean b, String attr) {
		
	}
}

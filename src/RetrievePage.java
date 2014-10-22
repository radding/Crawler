import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class RetrievePage implements Runnable{
	Manager manager;
	URL myPage;
	String content;
	boolean folow;
	public RetrievePage(Manager master, boolean follow, String link){
		manager = master;
		try {
			myPage = new URL(link);
			folow = follow;
			content = new String();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public RetrievePage(String test){
//		manager = master;
		try {
			myPage = new URL(test);
			content = new String();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		if(!folow){
			return;
		}
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(myPage.openStream()));
			
			String line;
			while((line = in.readLine())!= null){
				 content = content.concat(line);
			}
			
			in.close();
			this.getURLS();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Thread start(){
		Thread temp = new Thread(this);
		temp.start();
		return temp;
	}
	private void getURLS(){
//		Document things = Jsoup.parse(content);
//		Elements links = things.select("a[href]");
//		for(Element i : links){
//			
//			if(i.attr("abs:href") != ""){
//				manager.lock.lock();
//				if(!manager.previousURL.contains(i.attr("abs:href"))){
//					manager.addURL(false, i.attr("abs:href"));
//				}
//					
//				manager.lock.unlock();
//			}
//			
//			else{
//				manager.lock.lock();
//				if(!manager.previousURL.contains(manager.baseURL + i.attr("href")))
//					manager.addURL(true, i.attr("href"));
//				manager.lock.unlock();
//			}
//		}
	}
}

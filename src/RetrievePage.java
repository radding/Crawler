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
	public RetrievePage(Manager master){
		manager = master;
	}
	
	public RetrievePage(String test){
//		manager = master;
		try {
			myPage = new URL(test);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		if(manager != null)
			myPage = manager.urls.remove();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(myPage.openStream()));
			
			String line;
			while((line = in.readLine())!= null){
				content.concat(line);
			}
			
			in.close();
			this.getURLS();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getURLS(){
		Document things = Jsoup.parse(content);
		Elements links = things.select("a[href]");
		for(Element i : links){
			System.out.println("links: "+i.attr("abs:href"));
		}
	}
}

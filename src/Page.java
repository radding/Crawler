import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Page {
	public Website master;
	public String url;
	String baseSite;
	Page callingPage;
	List <Page> pagesICalled;
	List <String> brokenLinks;
	List <String> cssURLs;
	List <String> javaScirpt;
	List <String> internalLinks;
	List <String> externalLinks;
	long loadingTime;
	String content;
	
	
	public Page(Page caller, String url){
		this.callingPage = caller;
		this.url = url;
		content = new String();
		master = caller.master;
		this.profilePage();
		
	}
	
	public void profilePage(){
		try {
			long start = System.nanoTime();
			URL temp = new URL(url);
			loadingTime = System.nanoTime() - start;
			
			BufferedReader in = new BufferedReader(new InputStreamReader(temp.openStream()));
			String line;
			while((line = in.readLine())!= null){
				 content = content.concat(line);
			}
			Document things = Jsoup.parse(content);
			Elements links = things.select("a[href]");
			for(Element i : links){
				
				if(i.attr("abs:href") != "" ){
					temp = new URL(i.attr("abs:href"));
					try {
			            InputStream l = temp.openStream();
			        } 
					catch (UnknownHostException ex) {
			           this.brokenLinks.add(i.attr("abs:href"));
			        }
				}
				
				else{
					String tempURL = i.attr("href");
					tempURL = this.baseSite.concat(tempURL);
					temp = new URL(tempURL);
					try {
			            InputStream l = temp.openStream();
			        } 
					catch (UnknownHostException ex) {
			           this.brokenLinks.add(tempURL);
			        }
					if(master.followInternal){
						this.pagesICalled.add(new Page(this, tempURL));
					}
				}
			}
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

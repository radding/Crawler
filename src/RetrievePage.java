import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class RetrievePage implements Runnable{
	Manager manager;
	URL myPage;
	String content;
	public RetrievePage(Manager master){
		manager = master;
	}
	
	public void run(){
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
		
	}
}


public class Main {
	public static void main(String [] args){
		System.out.println("I started up");
		RetrievePage test = new RetrievePage("https://www.google.com/");
		test.run();
//		new MainWindow();
//		MainWindow.createAndShow();
		System.out.println("I ended");
	}
}

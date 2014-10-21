import javax.swing.*;

public class MainWindow {
	
	public static void createAndShow(){
		 JFrame frame = new JFrame("Crawler Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
	
}

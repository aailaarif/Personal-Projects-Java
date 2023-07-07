import javax.swing.JFrame;

public class Frame extends JFrame{
	Frame(){
		//Create an instance of game panel and set title
		Panel thePanel = new Panel();
		this.add(thePanel);
		this.setTitle("Snake");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pack function allows new elements to be added to panel easily
		this.pack();
		//make panel visible
		this.setVisible(true);
		//make panel show in the middle of screen
		this.setLocationRelativeTo(null);
	}

}

package javax.swing;

public class Steadfast extends JFrame {
	/**
	+	 * 
	+	 */
		private static final long serialVersionUID = 1L;
	
		public Steadfast() {
			// Making sure we have a nice window decorations
			setDefaultLookAndFeelDecorated(true);
			//creating and setting up windows
			setTitle("SteadFast");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// Adding label with the text to be displayed.
			JLabel label =  new JLabel("GUI window created !!");
			getContentPane().add(label);
			//displaying window
			pack();
			setVisible(true);
		}
		
		public static void main(String[]args){
			@SuppressWarnings("unused")
			Steadfast justswing = new Steadfast();
			
		}
	
}

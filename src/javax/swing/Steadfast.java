package javax.swing;


import java.awt.FlowLayout;		//For defining the layout
import java.awt.event.ActionListener;
import java.io.*;				// input-output operations
import java.net.HttpURLConnection;	// making a connection
import java.net.URL;			// in making a URL object

import javax.activation.CommandInfo;

import java.awt.event.*;


public class Steadfast extends JFrame {
	

	/**
	 * 
	 */
	final static int interval = 100;
	int i;
	JLabel label;
	JProgressBar pb;
	
	static JButton button;
	static JButton cancelButton;
	static JButton pauseButton;
	static JButton startButton;
	
	
	
	private static final long serialVersionUID = 1L;

	
	
	
	
	public static final void main(String[] args) throws Exception {
		setDefaultLookAndFeelDecorated(true);
		
		
		final String website = "https://github.com/ronz94/Steadfast/archive/basicgui.zip";
		final String itemname = "basicgui.zip";
		JFrame dhanja = new JFrame();
		dhanja.setTitle("SteadFast Downloader");
		final JProgressBar candybar = new JProgressBar(0,100);
		candybar.setSize(70,70);
		candybar.setValue(0); //setting initial candybar value to zero
		candybar.setStringPainted(true);
		
		//setting the buttons
		button = new JButton("Start");
		//button.addActionListener(new ButtonListener());
		cancelButton = new JButton ("Cancel");
		pauseButton = new JButton("Pause");
		startButton = new JButton ("Resume");
		cancelButton.setEnabled(false);
		pauseButton.setEnabled(false);
		startButton.setEnabled(false);
		
		//setting buttons to the frame
		dhanja.add(cancelButton);
		dhanja.add(pauseButton);
        dhanja.add(startButton);		
		dhanja.add(button);
		
		// setting progress bar to the frame
		dhanja.add(candybar);
		dhanja.setVisible(true);
		dhanja.setLayout(new FlowLayout());
		dhanja.setSize(300,150);
		dhanja.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		  
		
		
		
		        
		

	@SuppressWarnings("unused")
	class ButtonListener implements ActionListener {
		private HttpURLConnection https;

		
		public void actionPerformed(ActionEvent ae){
			
			String command = ae.getActionCommand();
			
			if (command.equals("button")){
			
			// now throwing exception
			try {
				URL link = new URL(website);
				
				HttpURLConnection con = (HttpURLConnection) link.openConnection();
				
			
				int filesize = con.getContentLength(); // checking download size
				float tDataRead = 0;
				java.io.BufferedInputStream takingin = new java.io.BufferedInputStream(con.getInputStream()); //starting download
				java.io.FileOutputStream place_to_vomit = new java.io.FileOutputStream(itemname);
				java.io.BufferedOutputStream vomitting_out = new BufferedOutputStream(place_to_vomit,1024);
				byte[] data = new byte[1024];
				int i = 0;
				while((i = takingin.read(data,0,1024)) >= 0){
					tDataRead = tDataRead +i;
					vomitting_out.write(data,0,i);
					float completed = (tDataRead * 100)/filesize;
					candybar.setValue((int)completed);
				}
				vomitting_out.close();
				takingin.close();
			}catch (Exception e){
				javax.swing.JOptionPane.showConfirmDialog((java.awt.Component)null,e.getMessage(), "Download Error",javax.swing.JOptionPane.DEFAULT_OPTION);
			}
		}
			
		}
	}
}
}

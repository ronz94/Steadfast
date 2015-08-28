package javax.swing;


import java.awt.FlowLayout;		//For defining the layout
import java.io.*;				// input-output operations
import java.net.HttpURLConnection;	// making a connection
import java.net.URL;			// in making a URL object

import java.awt.event.*;


public class Steadfast extends JFrame implements ActionListener{
	

	/**
	 * 
	 */
	final int interval = 100;
	
	static final JFrame dhanja = new JFrame();
	static final JButton cancelButton = new JButton ("Cancel");
	static final JButton pauseButton = new JButton("Pause");
	static final JButton startButton = new JButton ("Start");
	static final JProgressBar candybar = new JProgressBar(0,100);
	static final JTextField URLText = new JTextField(10);
	private static final long serialVersionUID = 1L;

	

	
	
	public Steadfast()  throws Exception  {
		setDefaultLookAndFeelDecorated(true);
		
		
		

		
		dhanja.setSize(400,100);
		dhanja.setTitle("SteadFast Downloader");
		//final JProgressBar candybar = new JProgressBar(0,100);
	    candybar.setSize(70,70);
		candybar.setValue(0); //setting initial candybar value to zero
		candybar.setStringPainted(true);
		
		
		cancelButton.addActionListener(this);
		pauseButton.addActionListener(this);
		startButton.addActionListener(this);
		cancelButton.setEnabled(true);
		pauseButton.setEnabled(true);
		startButton.setEnabled(true);
		
		//setting buttons to the frame
		dhanja.add(URLText);
		// setting progress bar to the frame
		dhanja.add(candybar);
		dhanja.setVisible(true);
		dhanja.setLayout(new FlowLayout());
		dhanja.setSize(300,150);
		dhanja.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dhanja.add(startButton);
		dhanja.add(pauseButton);
		dhanja.add(cancelButton);
	   
	}


	public static final void main(String[] args) throws Exception {
		new Steadfast();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae ) {
		// TODO Auto-generated method stub
		
		String command = ae.getActionCommand();
		
		if (command.equals("Start")){
		
		// now throwing exception
			try {
				final String website = "https://github.com/ronz94/Steadfast/archive/basicgui.zip";
				final String itemname = "basicgui.zip";
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
	
		
		if (command.equals("Pause")){
			try { 
				Thread.sleep(2000); 
				} catch(InterruptedException e) { 
				} 
		}
		
		if (command.equals("Cancel")){
			System.exit(0);
		}
		
	}

	
}



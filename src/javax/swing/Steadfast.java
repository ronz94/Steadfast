package javax.swing;


import java.awt.FlowLayout;		//For defining the layout
import java.io.*;				// input-output operations
import java.net.HttpURLConnection;	// making a connection
import java.net.URL;			// in making a URL object

import java.awt.event.*;


public  class Steadfast extends JFrame implements ActionListener{
	

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
	static final JTextField filename = new JTextField(10);
	static final JPanel progress_holder = new JPanel();
	private static final long serialVersionUID = 1L;

	String content = URLText.getText();
	String name = filename.getText();

	public Steadfast()  throws Exception  {
		setDefaultLookAndFeelDecorated(true);
		
		dhanja.setLayout(new FlowLayout());
		dhanja.setSize(300,250);
		dhanja.setTitle("SteadFast Downloader");
		dhanja.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel holder = new JPanel();
		JPanel holder2 = new JPanel();
		JPanel holder3 = new JPanel();
		JPanel holder4 = new JPanel();
		JPanel holder5 = new JPanel();
		JLabel urlinfo = new JLabel("-:Enter your URL here:-");
		JLabel fileinfo = new JLabel("-:Enter your filename here:-");
		//final JProgressBar candybar = new JProgressBar(0,100);
	    candybar.setSize(90,70);
		candybar.setValue(0); //setting initial candybar value to zero
		candybar.setStringPainted(true);
		
		
		cancelButton.addActionListener(this);
		pauseButton.addActionListener(this);
		startButton.addActionListener(this);
		cancelButton.setEnabled(true);
		pauseButton.setEnabled(true);
		startButton.setEnabled(true);
		
		dhanja.add(holder);
		holder.add(urlinfo);
		dhanja.add(holder2);
		holder2.add(URLText);
		dhanja.add(holder3);
		holder3.add(fileinfo);
		dhanja.add(holder4);
		holder4.add(filename);
		
		dhanja.add(progress_holder);
		progress_holder.add(candybar);
		
		dhanja.add(holder5);
		holder5.add(startButton);
		holder5.add(pauseButton);
		holder5.add(cancelButton);
		dhanja.setVisible(true);
	}


	public static final void main(String[] args) throws Exception {
		Steadfast a = new Steadfast();
		(a.new action()).start();
	}
	
	public class action extends Thread {
		private final Object command = null;
		{
		

	if (command.equals("Start")){
		
	
	// now throwing exception
		try {
			final String website = URLText.getText();
			final String itemname = filename.getText();
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
	public void actionPerformed(ActionEvent ae ) {
		// TODO Auto-generated method stub
		
		String command = ae.getActionCommand();
		new action();
	}
		

	
	//public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}



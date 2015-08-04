import java.awt.FlowLayout;		//For defining the layout
import java.io.*;				// input-output operations
import java.net.HttpURLConnection;	// making a connection
import java.net.URL;			// in making a URL object
import javax.swing.JFrame;		//s in making Swing Frame
import javax.swing.JProgressBar;	// in implementing Progress Bar

public class Steadfast extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final void main(String[] args) throws Exception {
		String website = "https://github.com/ronz94/Steadfast/archive/basicgui.zip";
		String itemname = "basicgui.zip";
		JFrame dhanja = new JFrame();
		JProgressBar candybar = new JProgressBar(0,100);
		candybar.setSize(50,50);
		candybar.setValue(0); //setting inital candybar value to zero
		candybar.setStringPainted(true);
		// setting progress bar to the frame
		dhanja.add(candybar);
		dhanja.setVisible(true);
		dhanja.setLayout(new FlowLayout());
		dhanja.setSize(600,400);
		dhanja.setDefaultCloseOperation(EXIT_ON_CLOSE);
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

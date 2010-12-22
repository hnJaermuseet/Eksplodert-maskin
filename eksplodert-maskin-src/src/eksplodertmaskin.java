import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class eksplodertmaskin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length < 2)
		{
			System.out.println("Må oppgi plassering til bilde samt" +
					" plassering for programmet som skal kjøres.");
			System.exit(0);
		}
		
		final String to_run = args[1];
		
		Frame f = new Frame("Eksplodert maskin - Vitenfabrikken");
		f.setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		
		ImageIcon ikon = new ImageIcon(args[0]);
		JLabel cdrom = new JLabel("Lag aktivitet på CD-rom",
			ikon, JLabel.CENTER);
		cdrom.setForeground(Color.white);
		
		cdrom.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					// TODO: run script in its own process and dont let the user click while the process is running
					System.out.println("Label clicked.");
					Process proc = Runtime.getRuntime().exec(
							new String[] {"bash", "-c", to_run});
					InputStream inputstream = proc.getInputStream(); 
					InputStreamReader inputstreamreader = new InputStreamReader(inputstream); 
					BufferedReader bufferedreader = new BufferedReader(inputstreamreader); 
					String line; 
					while ((line = bufferedreader.readLine()) != null) { 
						System.out.println("OUTPUT = " + line); 
					} 
					try { 
						if (proc.waitFor() != 0) { 
							System.err.println("exit value = " + proc.exitValue()); 
						} 
					} catch (InterruptedException e) { 
						System.err.println("ERROR = " + e); 
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
		});
		
		// Adding the button in the middle of the screen
		cdrom.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(Box.createVerticalGlue());
		panel.add(cdrom);
		panel.add(Box.createVerticalGlue());
		
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel ("Kilde - bilde: Wikimedia Commons, GFDL-lisens"));
		panel2.add(panel);
		
		// Adding a background
		panel.setBackground(Color.DARK_GRAY);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {System.exit(0);}});
		f.add("Center",panel);
		f.pack();
		
		f.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		f.setVisible(true);
	}

}

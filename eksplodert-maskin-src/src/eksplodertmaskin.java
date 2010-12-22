import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class eksplodertmaskin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("Eksplodert maskin - Vitenfabrikken");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		
		ImageIcon ikon = new ImageIcon("CD-ROM-resize.png");
		JLabel cdrom = new JLabel("Lag aktivitet på CD-rom",
			ikon, JLabel.CENTER);
		
		cdrom.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Process p = Runtime.getRuntime().exec("/home/vitenfabrikken/aktivitet-cd.sh");
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
		f.setSize(new Dimension(320,550));
		f.setVisible(true);
	}

}

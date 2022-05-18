package p1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UspesanKraj extends JFrame {

	public JPanel contentPane;
	JLabel lblIspis;
	JLabel lblSlika;
	JLabel lbl0;
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JLabel niz[]=new JLabel[4];
	private JLabel lblTanaKombinacija;
	InGameFrame ig;

	/**
	 * Create the frame.
	 */
	public UspesanKraj() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Desktop\\Slagalica\\Slagalica\\img\\face32.png"));
		setTitle("Sko\u010Dko kviz");
		setBackground(Color.WHITE);
		setBounds(100, 100, 450, 294);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		lblSlika = new JLabel("");
		Image imgLogo = new ImageIcon(this.getClass().getResource("/face64.png")).getImage();
		lblSlika.setIcon(new ImageIcon(imgLogo));
		lblSlika.setBounds(191, 88, 64, 64);
		contentPane.add(lblSlika);
		
		lblIspis = new JLabel("");
		lblIspis.setHorizontalAlignment(SwingConstants.CENTER);
		lblIspis.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIspis.setBounds(10, 11, 424, 64);
		contentPane.add(lblIspis);
		
		lbl0 = new JLabel("");
		lbl0.setBounds(91, 203, 32, 32);
		contentPane.add(lbl0);
		
		lbl1 = new JLabel("");
		lbl1.setBounds(165, 203, 32, 32);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setBounds(239, 203, 32, 32);
		contentPane.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setBounds(313, 203, 32, 32);
		contentPane.add(lbl3);
		
		niz[0]=lbl0; 
		niz[1]=lbl1; 
		niz[2]=lbl2; 
		niz[3]=lbl3; 
		
		lblTanaKombinacija = new JLabel("Ta\u010Dna kombinacija:");
		lblTanaKombinacija.setHorizontalAlignment(SwingConstants.CENTER);
		lblTanaKombinacija.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTanaKombinacija.setBounds(10, 147, 424, 45);
		contentPane.add(lblTanaKombinacija);
		Image imgLogo2 = new ImageIcon(this.getClass().getResource("/start32.png")).getImage();
		Image imgLogo3 = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		
	
	}
}

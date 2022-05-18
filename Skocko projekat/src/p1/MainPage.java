package p1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.SystemColor;

public class MainPage extends JFrame {

	private JPanel contentPane;
	public static MainPage frame;
	private InGameFrame i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() { //prvi prozor igre
		setLocationRelativeTo(frame);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Desktop\\Slagalica\\Slagalica\\img\\face32.png"));
		setTitle("Sko\u010Dko kviz");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblSlagalica = new JLabel("Sko\u010Dko");
		lblSlagalica.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 30));
		lblSlagalica.setBounds(156, 11, 117, 57);
		contentPane.add(lblSlagalica);
		
		JLabel label = new JLabel("");
		Image imgLogo = new ImageIcon(this.getClass().getResource("/quiz128.png")).getImage();
		label.setIcon(new ImageIcon(imgLogo));
		label.setBounds(44, 79, 128, 150);
		contentPane.add(label);
		
		JButton btnPoniNovuIgru = new JButton("Po\u010Dni novu igru");
		btnPoniNovuIgru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				i=new InGameFrame();
				i.setVisible(true);
				dispose();
			}
		});
		btnPoniNovuIgru.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		Image imgStart = new ImageIcon(this.getClass().getResource("/start32.png")).getImage();
		btnPoniNovuIgru.setIcon(new ImageIcon(imgStart));
		btnPoniNovuIgru.setBounds(239, 104, 174, 41);
		contentPane.add(btnPoniNovuIgru);
		btnPoniNovuIgru.setFocusPainted(false);
		btnPoniNovuIgru.setContentAreaFilled(false);
		
		
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setIcon(new ImageIcon("D:\\Desktop\\Slagalica\\Slagalica\\img\\exit32.png"));
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnIzlaz.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		
		btnIzlaz.setBounds(239, 177, 174, 41);
		contentPane.add(btnIzlaz);
		btnIzlaz.setFocusPainted(false);
		btnIzlaz.setContentAreaFilled(false);
		
		
		JLabel label_1 = new JLabel("");
		Image imgLogo2 = new ImageIcon(this.getClass().getResource("/underline.png")).getImage();
		label_1.setIcon(new ImageIcon(imgLogo2));
		label_1.setBounds(128, 41, 164, 27);
		contentPane.add(label_1);
	}
}

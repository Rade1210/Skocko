package p1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class InGameFrame extends JFrame {

	public JPanel contentPane;
	public int x = 0, y = 0;
	Slicice matrica[][] = new Slicice[4][6]; //4 slicice u kombinaciji od 6 ukupnih
	Slicice matrica2[][] = new Slicice[4][6];
	Slicice resenje[] = new Slicice[4]; //4 slicice u kombinaciji
	public JFrame UspesanKraj;

	public void unos(String symbol) {
		if (x <= 3) { //ako je broj slicica manji od 4
			Image imgMatrix = new ImageIcon(this.getClass().getResource("/" + symbol + ".png")).getImage(); //uzmi slicicu
			matrica[x][y].setIcon(new ImageIcon(imgMatrix)); //i ubaci je u matricu
			x++;
		}
	}

	public int RandomBroj() {
		Random rand = new Random();
		return rand.nextInt(6);
	}

	public void KreirajResenje() {
		for (int i = 0; i < 4; i++) {
			resenje[i] = new Slicice();
			resenje[i].symbol = RandomBroj(); //resenje je nasumicno odabrana kombinacija
			System.out.println(resenje[i].symbol); //ispis simbola resenja
		}
	}

	public InGameFrame() {

		KreirajResenje();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2); //postavljanje pocetnog kadra u centar ekrana

		setForeground(new Color(248, 248, 255));
		setResizable(false); //prozori se ne mogu povecati ili smanjiti
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Desktop\\Slagalica\\Slagalica\\img\\face32.png")); //manja slika smajlica kao simbola
		setTitle("Sko\u010Dko kviz");
		setBounds(100, 100, 706, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205)); //boja pozadine
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton btnNazad = new JButton("");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				MainPage m = new MainPage();
				m.setVisible(true);
			}
		});
		btnNazad.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		Image imgHome = new ImageIcon(this.getClass().getResource("/home.png")).getImage(); //slika kucice za povratak na prvi prozor
		btnNazad.setIcon(new ImageIcon(imgHome));
		btnNazad.setBounds(20, 11, 49, 40);
		contentPane.add(btnNazad);
		btnNazad.setFocusPainted(false);
		btnNazad.setContentAreaFilled(false);

		JPanel panel = new JPanel();
		panel.setBounds(20, 62, 500, 311);
		contentPane.add(panel);
		panel.setLayout(null);

		for (int i = 0; i < 4; i++) { //matrica za ubacivanje znaka pitanja u panel
			for (int j = 0; j < 6; j++) {
				matrica[i][j] = new Slicice();
				matrica[i][j].i = i;
				matrica[i][j].j = j;
				matrica[i][j].setBounds(20 + (i * 56), 35 + (j * 40), 32, 32);
				Image imgMatrix = new ImageIcon(this.getClass().getResource("/question.png")).getImage();
				matrica[i][j].setIcon(new ImageIcon(imgMatrix));
				panel.add(matrica[i][j]);
			}

		}

		for (int i = 0; i < 4; i++) { //matrica za ubacivanje sivog semafora u panel
			for (int j = 0; j < 6; j++) {
				matrica2[i][j] = new Slicice();
				matrica2[i][j].i = i;
				matrica2[i][j].j = j;
				matrica2[i][j].setBounds(283 + (i * 56), 35 + (j * 40), 32, 32);
				Image imgMatrix = new ImageIcon(this.getClass().getResource("/nisipogodio.png")).getImage();
				matrica2[i][j].setIcon(new ImageIcon(imgMatrix));
				panel.add(matrica2[i][j]);
			}

		}

		JButton btnZvezda = new JButton("");
		btnZvezda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (x != 4) 
					matrica[x][y].symbol = 5;
				unos("zvezda"); //peti simbol
			}
		});
		Image imgS1 = new ImageIcon(this.getClass().getResource("/zvezda.png")).getImage();
		btnZvezda.setIcon(new ImageIcon(imgS1));
		btnZvezda.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnZvezda.setFocusPainted(false);
		btnZvezda.setContentAreaFilled(false);
		btnZvezda.setBounds(370, 409, 60, 41);
		contentPane.add(btnZvezda);

		JButton btnFace = new JButton("");
		btnFace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (x != 4) 
					matrica[x][y].symbol = 0;
				unos("face32"); //nulti simbol

			}
		});
		Image imgS2 = new ImageIcon(this.getClass().getResource("/face32.png")).getImage();
		btnFace.setIcon(new ImageIcon(imgS2));
		btnFace.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnFace.setFocusPainted(false);
		btnFace.setContentAreaFilled(false);
		btnFace.setBounds(20, 409, 60, 41);
		contentPane.add(btnFace);

		JButton btnDetelina = new JButton("");
		btnDetelina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (x != 4)
					matrica[x][y].symbol = 1; 
				unos("detelina"); //prvi simbol
			}
		});
		Image imgS3 = new ImageIcon(this.getClass().getResource("/detelina.png")).getImage();
		btnDetelina.setIcon(new ImageIcon(imgS3));
		btnDetelina.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnDetelina.setFocusPainted(false);
		btnDetelina.setContentAreaFilled(false);
		btnDetelina.setBounds(90, 409, 60, 41);
		contentPane.add(btnDetelina);

		JButton btnList = new JButton("");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (x != 4)
					matrica[x][y].symbol = 2;
				unos("list"); //drugi simbol
			}
		});
		Image imgS4 = new ImageIcon(this.getClass().getResource("/list.png")).getImage();
		btnList.setIcon(new ImageIcon(imgS4));
		btnList.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnList.setFocusPainted(false);
		btnList.setContentAreaFilled(false);
		btnList.setBounds(160, 409, 60, 41);
		contentPane.add(btnList);

		JButton btnKocka = new JButton("");
		btnKocka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (x != 4)
					matrica[x][y].symbol = 4;
				unos("kocka"); //cetvrti simbol
			}
		});
		Image imgS5 = new ImageIcon(this.getClass().getResource("/kocka.png")).getImage();
		btnKocka.setIcon(new ImageIcon(imgS5));
		btnKocka.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnKocka.setFocusPainted(false);
		btnKocka.setContentAreaFilled(false);
		btnKocka.setBounds(300, 409, 60, 41);
		contentPane.add(btnKocka);

		JButton btnSrce = new JButton("");
		btnSrce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (x != 4)
					matrica[x][y].symbol = 3;
				unos("srce"); //treci simbol
			}
		});
		Image imgS6 = new ImageIcon(this.getClass().getResource("/srce.png")).getImage();
		btnSrce.setIcon(new ImageIcon(imgS6));
		btnSrce.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnSrce.setFocusPainted(false);
		btnSrce.setContentAreaFilled(false);
		btnSrce.setBounds(230, 409, 60, 41);
		contentPane.add(btnSrce);

		JLabel label = new JLabel("");
		Image imgLogo = new ImageIcon(this.getClass().getResource("/face64.png")).getImage();
		label.setIcon(new ImageIcon(imgLogo));
		label.setBounds(573, 166, 69, 64);
		contentPane.add(label);


		JButton btnObrii = new JButton("Obri\u0161i");
		btnObrii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (x > 0) { // brise simbol iz unete kombinacije
					x--;
					Image imgMatrix = new ImageIcon(this.getClass().getResource("/question.png")).getImage();
					matrica[x][y].setIcon(new ImageIcon(imgMatrix));
					matrica[x][y].symbol = -1;

				} else if (x == 0) { //ako nema simbola u kombinaciji, ne brise nista
					Image imgMatrix = new ImageIcon(this.getClass().getResource("/question.png")).getImage();
					matrica[x][y].setIcon(new ImageIcon(imgMatrix));
					matrica[x][y].symbol = -1;
				}
			}
		});
		btnObrii.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		Image imgExit = new ImageIcon(this.getClass().getResource("/nazad32.png")).getImage(); //slika za brisanje simbola
		btnObrii.setIcon(new ImageIcon(imgExit));
		btnObrii.setFocusPainted(false);
		btnObrii.setContentAreaFilled(false);
		btnObrii.setBounds(573, 410, 117, 40);
		contentPane.add(btnObrii);

		JButton btnProveri = new JButton("Proveri");
		btnProveri.setIcon(new ImageIcon("D:\\Desktop\\Slagalica\\Slagalica\\img\\questionbtn32.png"));
		btnProveri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (x == 4) { //ako smo uneli sva 4 simbola

					int pomZuta = 0;
					int pomCrvena = 0;
					for (int i = 0; i < x; i++) {
						for (int j = 0; j < 4; j++) {
							if (resenje[i].symbol == matrica[j][y].symbol && matrica[j][y].isChecked == false) { //ako je slicica u kombinaciji, a nije na svom mestu
								SetSlicica(pomZuta);
								pomZuta++;
								matrica[j][y].isChecked = true;
								break;
							}
						}
					}

					for (int i = pomZuta; i < x; i++) {
						SetSlicicaCrna(pomZuta); //postavljanje zutog svetla u semafor
						pomZuta++;
					}

					int j = 0;
					for (int i = 0; i < 4; i++) {
						if (resenje[i].symbol == matrica[j][y].symbol) { //ako je u kombinaciji i na svom mestu
							SetSlicicaCrvena(pomCrvena);
							pomCrvena++;
						}
						j++;
					}

					if (pomCrvena == x) { //ako su svi simboli u kombinaciji
						
						btnFace.setEnabled(false);
						btnDetelina.setEnabled(false);
						btnList.setEnabled(false);
						btnSrce.setEnabled(false);
						btnKocka.setEnabled(false);
						btnZvezda.setEnabled(false);
						btnObrii.setEnabled(false);
						btnProveri.setEnabled(false);
						
						UspesanKraj uk = new UspesanKraj();
						uk.lblIspis.setText("Čestitamo! Uspešno ste pogodili kombinaciju!");
						Image imgLogo = new ImageIcon(this.getClass().getResource("/face64.png")).getImage(); //veliki smajli na kraju
						uk.lblSlika.setIcon(new ImageIcon(imgLogo));
						uk.setVisible(true);
						for (int i = 0; i < 4; i++) {
							switch (resenje[i].symbol) { //ubacivanje simbola u niz
							case 0: {
								Image img0 = new ImageIcon(this.getClass().getResource("/face32.png")).getImage();
								uk.niz[i].setIcon(new ImageIcon(img0));
								break;
							}
							case 1: {
								Image img0 = new ImageIcon(this.getClass().getResource("/detelina.png")).getImage();
								uk.niz[i].setIcon(new ImageIcon(img0));
								break;
							}
							case 2: {
								Image img0 = new ImageIcon(this.getClass().getResource("/list.png")).getImage();
								uk.niz[i].setIcon(new ImageIcon(img0));
								break;
							}
							case 3: {
								Image img0 = new ImageIcon(this.getClass().getResource("/srce.png")).getImage();
								uk.niz[i].setIcon(new ImageIcon(img0));
								break;
							}
							case 4: {
								Image img0 = new ImageIcon(this.getClass().getResource("/kocka.png")).getImage();
								uk.niz[i].setIcon(new ImageIcon(img0));
								break;
							}
							case 5: {
								Image img0 = new ImageIcon(this.getClass().getResource("/zvezda.png")).getImage();
								uk.niz[i].setIcon(new ImageIcon(img0));
								break;
							}}}}
					y++; //prenos u novi red semafora
					System.out.println(y+ "   "+pomCrvena); //prenosi u novi red crveno svetlo
					if (y == 6 && pomCrvena < x) { //u slucaju da nismo pogodili kombinaciju a stigli smo do kraja semafora
						UspesanKraj uk = new UspesanKraj();
						uk.lblIspis.setText("Žao nam je! Niste uspeli pogoditi kombinaciju!");
						Image imgLogo = new ImageIcon(this.getClass().getResource("/sad64.png")).getImage();
						uk.lblSlika.setIcon(new ImageIcon(imgLogo));
						uk.setVisible(true);
						for (int i = 0; i < 4; i++) {
							switch (resenje[i].symbol) {
							case 0: {
								Image img0 = new ImageIcon(this.getClass().getResource("/face32.png")).getImage();
								uk.niz[i].setIcon(new ImageIcon(img0));
								break;
							}
							case 1: {
								Image img0 = new ImageIcon(this.getClass().getResource("/detelina.png")).getImage();
								uk.niz[i].setIcon(new ImageIcon(img0));
								break;
							}
							case 2: {
								Image img0 = new ImageIcon(this.getClass().getResource("/list.png")).getImage();
								uk.niz[i].setIcon(new ImageIcon(img0));
								break;
							}
							case 3: {
								Image img0 = new ImageIcon(this.getClass().getResource("/srce.png")).getImage();
								uk.niz[i].setIcon(new ImageIcon(img0));
								break;
							}
							case 4: {
								Image img0 = new ImageIcon(this.getClass().getResource("/kocka.png")).getImage();
								uk.niz[i].setIcon(new ImageIcon(img0));
								break;
							}
							case 5: {
								Image img0 = new ImageIcon(this.getClass().getResource("/zvezda.png")).getImage();
								uk.niz[i].setIcon(new ImageIcon(img0));
								break;
							}
							}
						}
					}
					x = 0;
				}

			}
		});
		btnProveri.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnProveri.setFocusPainted(false);
		btnProveri.setContentAreaFilled(false);
		btnProveri.setBounds(440, 409, 123, 40);
		contentPane.add(btnProveri);
		
		JButton btnNovaIgra = new JButton("Nova igra");
		btnNovaIgra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InGameFrame ig= new InGameFrame();
				ig.setVisible(true);
			}
		});
		Image img0 = new ImageIcon(this.getClass().getResource("/new32.png")).getImage();
		btnNovaIgra.setIcon(new ImageIcon(img0));
		btnNovaIgra.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnNovaIgra.setFocusPainted(false);
		btnNovaIgra.setContentAreaFilled(false);
		btnNovaIgra.setBounds(79, 11, 129, 40);
		contentPane.add(btnNovaIgra);
	}

	public void SetSlicica(int pom) {
		Image imgMatrix2 = new ImageIcon(this.getClass().getResource("/pogodioALI.png")).getImage();
		matrica2[pom][y].setIcon(new ImageIcon(imgMatrix2));
	}

	public void SetSlicicaCrvena(int pom) {
		Image imgMatrix2 = new ImageIcon(this.getClass().getResource("/pogodio.png")).getImage();
		matrica2[pom][y].setIcon(new ImageIcon(imgMatrix2));
	}

	public void SetSlicicaCrna(int pom) {
		Image imgMatrix2 = new ImageIcon(this.getClass().getResource("/Nista.png")).getImage();
		matrica2[pom][y].setIcon(new ImageIcon(imgMatrix2));
	}

}

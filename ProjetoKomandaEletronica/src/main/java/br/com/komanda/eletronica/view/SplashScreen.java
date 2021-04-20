package br.com.komanda.eletronica.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;

@SuppressWarnings("unused")
public class SplashScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static SplashScreen aux = null;
	
	//private final int duration;

	

	/**
	 * Create the frame.
	 */
	
	
	
	public SplashScreen() throws SQLException{
		setLocationByPlatform(true);
		
		//duration = d;
		
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		setBounds(100, 100, 730, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Inform\u00E1tica\\Documents\\Projetos Eclipse\\Komanda Eletr\u00F4nica\\komanda-eletronica\\ProjetoKomandaEletronica\\src\\main\\java\\img\\logo_if_resize.png"));
		lblNewLabel.setBounds(10, 48, 700, 82);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PROJETO INTERDISCIPLINAR");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 11, 700, 46);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SplashScreen.class.getResource("/img/Logo Komanda Eletronica.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2.setBounds(10, 141, 700, 354);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Danilo Liparini Moraes - RA: 201924410096 ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 506, 700, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Luciano Luiz Romero - RA: 201924410106");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(10, 531, 700, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Mateus Botelho Ribeiro - RA: 201924410271");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setBounds(10, 556, 700, 14);
		panel.add(lblNewLabel_3_2);
		
	}
	
	public void ShowLogin(SplashScreen splash) {
		Login login = new Login();
		login.setLocationRelativeTo(null);
		//splash.dispose();
		try {
			Thread.sleep(5000);
			//login.FechaSplashScreen(splash);
			login.setVisible(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
								
	}
	
	public void ShowSplash() {
		try {
			Thread.sleep(5000);
			//login.FechaSplashScreen(splash);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Login login = new Login();
		login.setLocationRelativeTo(null);
		//splash.dispose();
		login.setVisible(true);			
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					aux = frame;
					//frame.ShowLogin(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}		
			}
		});
		try {
			Thread.sleep(5000);
			Login login = new Login();
			login.setLocationRelativeTo(null);
			//splash.dispose();
			login.FechaSplashScreen(aux);
			login.setVisible(true);			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

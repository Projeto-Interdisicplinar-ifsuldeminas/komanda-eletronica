package br.com.komanda.eletronica.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private static MainDashboard main = null;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Login() {
		
		setSize(new Dimension(13, 0));
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(32739, 25000));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 25, 420, 27);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 90, 420, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 134, 420, 33);
		panel.add(passwordField);
		
		JButton btnOk = new JButton("Login");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ValidaUsuario();			
			}
		});
		btnOk.setBackground(new Color(0, 128, 0));
		btnOk.setBounds(35, 222, 180, 23);
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setBounds(225, 222, 180, 23);
		panel.add(btnCancel);
		
		
	}
	
	public void SetMainDashboard(MainDashboard p) {
		main = p;
	}
	
	public MainDashboard GetMainDashboard() {
		return main;
	}
	
	public void ValidaUsuario() {
		this.dispose();
		MainDashboard window = null;
		if(main != null) {
			window = main;
		}else {
			window = new MainDashboard(this);
		}
		window.GetFrame().setVisible(true);
		window.GetFrame().setLocationRelativeTo(null);		
	}
	
	public void FechaSplashScreen(SplashScreen splash) {
		splash.dispose();
	}
}

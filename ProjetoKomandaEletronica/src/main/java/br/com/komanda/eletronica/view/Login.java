package br.com.komanda.eletronica.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import br.com.komanda.eletronica.dao.LoginDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings({ "serial", "unused" })
public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField pfSenha;
	private static MainDashboard main = null;
	private LoginDao loginDao;

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
	 * @throws ParseException 
	 */
	public Login() throws ParseException {
		setResizable(false);
		
		setSize(new Dimension(450, 251));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setMaximumSize(new Dimension(32739, 25000));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(10, 123, 420, 33);
		panel.add(pfSenha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 11, 420, 57);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("  Login");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/Key.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 167, 420, 112);
		panel.add(panel_2);
		
		JButton btnOk = new JButton("   Login");
		btnOk.setIcon(new ImageIcon(Login.class.getResource("/img/Key.png")));
		btnOk.setForeground(Color.WHITE);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnOk.setBackground(new Color(0, 128, 0));
		
		JButton btnCancel = new JButton("   Cancelar");
		btnCancel.setIcon(new ImageIcon(Login.class.getResource("/img/cancel.png")));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBackground(new Color(255, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Para teste utilize o cpf 12345678900 e a senha 'master'");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(23)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		//JFormattedTextField ftUsuario = new JFormattedTextField();
		JFormattedTextField ftUsuario = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		ftUsuario.setBounds(10, 79, 420, 33);
		panel.add(ftUsuario);
		
		btnOk.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
					ValidaUsuario(ftUsuario.getText(), pfSenha.getText());			
			}
		});
		
		
	}
	
	public void SetMainDashboard(MainDashboard p) {
		main = p;
	}
	
	public MainDashboard GetMainDashboard() {
		return main;
	}
	
	public void ValidaUsuario(String usuario, String senha) {
		boolean retorno = false;
		loginDao = new LoginDao();
		if(usuario.equals("123.456.789-00") && senha.equals("master")) {
			retorno = true;
		}else {
						
			retorno = loginDao.ValidaLoginFuncionarios(usuario, senha);
		}		
		//boolean retorno = true;
		
		if(retorno) {
			this.dispose();
			MainDashboard window = null;
			if(main != null) {
				window = main;
			}else {
				window = new MainDashboard(this);
			}
			window.setIdFuncionario(loginDao.getIdFuncionario());
			window.GetFrame().setVisible(true);
			window.GetFrame().setLocationRelativeTo(null);
		}else {
			JOptionPane.showMessageDialog(null, "Usuario Invalido e/ou senha inválida!");
		}
		
		
	}
	
	public void FechaSplashScreen(SplashScreen splash) {
		splash.dispose();
	}
}

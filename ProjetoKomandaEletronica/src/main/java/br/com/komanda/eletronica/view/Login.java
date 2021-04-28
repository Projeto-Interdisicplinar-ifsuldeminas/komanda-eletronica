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
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import br.com.komanda.eletronica.dao.FuncionarioDao;
import br.com.komanda.eletronica.dao.LoginDao;
import br.com.komanda.eletronica.model.Funcionario;
import br.com.komanda.eletronica.model.LoginFuncionarios;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

@SuppressWarnings({ "serial", "unused" })
public class Login extends JFrame {

	private JPanel contentPane;
	public JPasswordField pfSenha;
	JFormattedTextField ftUsuario;
	private static MainDashboard main = null;
	private LoginDao loginDao;
	private JLabel lbLog;
	private Funcionario func;

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
		
		setUndecorated(true);
		setResizable(false);
		
		setSize(new Dimension(530, 398));
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 58, 420, 98);
		panel.add(panel_1);
		
		//JFormattedTextField ftUsuario = new JFormattedTextField();
		ftUsuario = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		ftUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ftUsuario.setBorder(new TitledBorder(null, "CPF", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ftUsuario.setText("");
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pfSenha.setBorder(new TitledBorder(null, "Senha", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pfSenha.setText("");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(ftUsuario, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
						.addComponent(pfSenha, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(ftUsuario, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pfSenha, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 167, 420, 112);
		panel.add(panel_2);
		
		JButton btnOk = new JButton("");
		btnOk.setToolTipText("Login");
		btnOk.setIcon(new ImageIcon(Login.class.getResource("/img/account-login-32.png")));
		btnOk.setForeground(Color.WHITE);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnOk.setBackground(new Color(0, 128, 0));
		
		JButton btnCancel = new JButton("");
		btnCancel.setToolTipText("Cancelar");
		btnCancel.setIcon(new ImageIcon(Login.class.getResource("/img/cancel-32.png")));
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
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		lbLog = new JLabel("");
		lbLog.setForeground(new Color(0, 0, 205));
		lbLog.setHorizontalAlignment(SwingConstants.CENTER);
		lbLog.setVisible(false);
		lbLog.setBounds(10, 153, 420, 14);
		panel.add(lbLog);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(10, 11, 420, 36);
		panel.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("   Acesso ao sistema");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/komanda.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
		);
		panel_3.setLayout(gl_panel_3);
		
		
		btnOk.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
					try {
						ValidaUsuario(ftUsuario.getText(), pfSenha.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
			}
		});
		
		
	}
	
	public void MostraLabel() {
		lbLog.setText("Usuário Logado: " + func.getNome());
		lbLog.setVisible(true);
	}
	
	public void SetMainDashboard(MainDashboard p) {
		main = p;
	}
	
	public MainDashboard GetMainDashboard() {
		return main;
	}
	
	public void ValidaUsuario(String usuario, String senha) throws SQLException {
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
				window = new MainDashboard(this, loginDao);
			}
			int idFunc = loginDao.getIdFuncionario();
			LoginFuncionarios logFunc = new LoginFuncionarios();
			logFunc = loginDao.consultaid(idFunc);
			if(logFunc.isPrimeiroAcesso()) {
				Funcionario f;
				FuncionarioDao aux = new FuncionarioDao();
				f = aux.consultaid(idFunc);
				AlteraSenha alterarSenha = new AlteraSenha(f);
				alterarSenha.setLocationRelativeTo(null);
				window = new MainDashboard(this, loginDao);
				AlteraSenha.setMain(window);
				//window.frmSistemaDeCadastro.setEnabled(false);
				alterarSenha.setVisible(true);
			}else {
				window.setIdFuncionario(idFunc);
				window.GetFrame().setVisible(true);
				window.GetFrame().setLocationRelativeTo(null);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Usuario Invalido e/ou senha inválida!");
		}
		
		
	}
	
	public void FechaSplashScreen(SplashScreen splash) {
		splash.dispose();
	}

	public Funcionario getFunc() {
		return func;
	}

	public void setFunc(Funcionario funcionario) {
		func = funcionario;
	}	
}

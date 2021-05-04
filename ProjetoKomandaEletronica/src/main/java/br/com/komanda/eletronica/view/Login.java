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
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.komanda.eletronica.connection.ConnectFactory;
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

	private JPanel contentPane, Servidor, Porta, Usuario, senha, panel_4;
	public JPasswordField pfSenha;
	JFormattedTextField ftUsuario;
	private static MainDashboard main = null;
	private LoginDao loginDao;
	private JLabel lbLog, rotulo;
	private Funcionario func;
	private JTextField txtServer;
	private JTextField txtPorta;
	private JTextField txtUser;
	private JPasswordField pswSenha; 
	private int buttonState = 0;
	private Login log;	
	private static String server, door, user, nameDB, password;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Login() throws ParseException {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setMaximumSize(new Dimension(32739, 25000));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
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
						.addComponent(pfSenha, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(6)
					.addComponent(ftUsuario, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pfSenha, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
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
						.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addGap(12))
		);
		panel_2.setLayout(gl_panel_2);
		
		lbLog = new JLabel("");
		lbLog.setForeground(new Color(0, 0, 205));
		lbLog.setHorizontalAlignment(SwingConstants.CENTER);
		lbLog.setVisible(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbLog, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lbLog, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		rotulo = new JLabel("Configura\u00E7\u00F5es do Banco de dados");
		rotulo.setForeground(Color.RED);
		
		Servidor = new JPanel();
		Servidor.setBorder(new TitledBorder(null, "Servidor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		Porta = new JPanel();
		Porta.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Porta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		Usuario = new JPanel();
		Usuario.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Usu\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		senha = new JPanel();
		senha.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Senha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		pswSenha = new JPasswordField();
		GroupLayout gl_senha = new GroupLayout(senha);
		gl_senha.setHorizontalGroup(
			gl_senha.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_senha.createSequentialGroup()
					.addContainerGap()
					.addComponent(pswSenha, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_senha.setVerticalGroup(
			gl_senha.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_senha.createSequentialGroup()
					.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		senha.setLayout(gl_senha);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		GroupLayout gl_Usuario = new GroupLayout(Usuario);
		gl_Usuario.setHorizontalGroup(
			gl_Usuario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Usuario.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtUser, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_Usuario.setVerticalGroup(
			gl_Usuario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Usuario.createSequentialGroup()
					.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		Usuario.setLayout(gl_Usuario);
		
		txtPorta = new JTextField();
		txtPorta.setColumns(10);
		GroupLayout gl_Porta = new GroupLayout(Porta);
		gl_Porta.setHorizontalGroup(
			gl_Porta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Porta.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtPorta, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_Porta.setVerticalGroup(
			gl_Porta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Porta.createSequentialGroup()
					.addComponent(txtPorta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		Porta.setLayout(gl_Porta);
		
		txtServer = new JTextField();
		txtServer.setColumns(10);
		GroupLayout gl_Servidor = new GroupLayout(Servidor);
		gl_Servidor.setHorizontalGroup(
			gl_Servidor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Servidor.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtServer, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_Servidor.setVerticalGroup(
			gl_Servidor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Servidor.createSequentialGroup()
					.addComponent(txtServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		Servidor.setLayout(gl_Servidor);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(rotulo, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(Servidor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Porta, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(Usuario, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(11)
					.addComponent(rotulo)
					.addGap(6)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(Porta, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(Servidor, GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		
		ConnectFactory conection = null;
		try {
			conection = lerXML();
			txtServer.setText(conection.getServer());
			txtPorta.setText(conection.getPorta());
			txtUser.setText(conection.getUser());
			pswSenha.setText(conection.getSenha());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//contentPane.setBounds(100, 100, 450, 320);
		
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
		boolean master = false;
		loginDao = new LoginDao();
		if(usuario.equals("123.456.789-00") && senha.equals("master")) {
			retorno = true;
			master = true;
		}else {
			ConnectFactory conection = null;
			try {
				conection = lerXML();
				retorno = loginDao.ValidaLoginFuncionarios(usuario, senha, conection.getServer(), conection.getPorta(), conection.getNome(), conection.getUser(), conection.getSenha());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		//boolean retorno = true;
		if(retorno && master) {
			this.dispose();
			MainDashboard window = null;
			if(main != null) {
				window = main;
			}else {
				window = new MainDashboard(this, loginDao);
			}
			window.setIdFuncionario(0);
			window.GetFrame().setVisible(true);
			window.GetFrame().setLocationRelativeTo(null);
		}else if(retorno && !master) {
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
	
	public Login getLog() {
		return log;
	}

	public void setLog(Login log) {
		this.log = log;
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
	

	private ConnectFactory lerXML() throws Exception{
		File fXmlFile = new File("src/main/java/configuracao/conexao.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		ConnectFactory con = null;
		NodeList nList = doc.getElementsByTagName("conexao");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			//System.out.println("\nElemento corrente :" + nNode.getNodeName());
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				server = eElement.getElementsByTagName("server").item(0).getTextContent();
				door = eElement.getElementsByTagName("porta").item(0).getTextContent();
				nameDB = eElement.getElementsByTagName("base").item(0).getTextContent();
				user = eElement.getElementsByTagName("user").item(0).getTextContent();
				password = eElement.getElementsByTagName("senha").item(0).getTextContent();
				
				con = new ConnectFactory(server, password, nameDB, user, door);
			}
		}
		return con;
	}
}

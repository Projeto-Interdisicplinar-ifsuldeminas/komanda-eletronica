package br.com.komanda.eletronica.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.com.komanda.eletronica.dao.FuncionarioDao;
import br.com.komanda.eletronica.model.Funcionario;
import br.com.komanda.eletronica.model.LoginFuncionarios;
import br.com.komanda.eletronica.model.TiposdeFuncao;

public class CadastroFuncionarios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	
	private static MainDashboard main = null;
	private JTextField txtMatricula;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox, cbNivel;
	private JFormattedTextField ftTelefone;
	private JRadioButton RBSim;
	private JRadioButton RBNao;
	private JComboBox<String> cbFuncao;
	private JFormattedTextField ftCpf;
	
	private JButton btnSalvar;
	
	private BuscaFuncionarios buscarFunc;
	
	

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CadastroFuncionarios(int id) throws Exception {
		
		setUndecorated(true);
		setTitle("CADASTRO DE FUNCION\u00C1RIOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroFuncionarios.class.getResource("/img/user_edit.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1144, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
						.addComponent(panel_7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel rotulo = new JLabel("O USU\u00C1RIO PARA ACESSO SER\u00C1 O CPF CADASTRADO E A SENHA INICIAL SER\u00C1 \"12345678\" (ESTA SER\u00C1 SOLICITADA A ALTERA\u00C7\u00C3O NO PRIMEIRO ACESSO).");
		rotulo.setForeground(Color.RED);
		rotulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(rotulo, GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
					.addGap(115))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(rotulo, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Matr\u00EDcula", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Fun\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nome Completo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Gerente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CPF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Email", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_5_2_1 = new JPanel();
		panel_5_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Telefone", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "N\u00EDvel de Acesso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "N\u00EDvel de acesso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		cbNivel = new JComboBox();
		cbNivel.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "ATENDENTE", "GERENTE", "ADMINISTRADOR"}));
		GroupLayout gl_panel_3_1 = new GroupLayout(panel_3_1);
		gl_panel_3_1.setHorizontalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(cbNivel, 0, 570, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3_1.setVerticalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_1.createSequentialGroup()
					.addComponent(cbNivel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_3_1.setLayout(gl_panel_3_1);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_3_1, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_5_2, GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_5_2_1, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
						.addComponent(panel_5_1, GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
						.addComponent(panel_5_1_1, GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel_6, 0, 0, Short.MAX_VALUE))
						.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_4, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_5_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_5_2_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5_1_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "Administrador", "Gerente", "Atendente"}));
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, 0, 430, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_8.setLayout(gl_panel_8);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		GroupLayout gl_panel_5_1_1 = new GroupLayout(panel_5_1_1);
		gl_panel_5_1_1.setHorizontalGroup(
			gl_panel_5_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5_1_1.setVerticalGroup(
			gl_panel_5_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_1_1.createSequentialGroup()
					.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5_1_1.setLayout(gl_panel_5_1_1);
		
		ftTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		ftTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_5_2_1 = new GroupLayout(panel_5_2_1);
		gl_panel_5_2_1.setHorizontalGroup(
			gl_panel_5_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_2_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(ftTelefone, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5_2_1.setVerticalGroup(
			gl_panel_5_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_2_1.createSequentialGroup()
					.addComponent(ftTelefone, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5_2_1.setLayout(gl_panel_5_2_1);
		
		ftCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		ftCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_5_2 = new GroupLayout(panel_5_2);
		gl_panel_5_2.setHorizontalGroup(
			gl_panel_5_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(ftCpf, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5_2.setVerticalGroup(
			gl_panel_5_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_2.createSequentialGroup()
					.addComponent(ftCpf, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5_2.setLayout(gl_panel_5_2);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEndereco.setColumns(10);
		GroupLayout gl_panel_5_1 = new GroupLayout(panel_5_1);
		gl_panel_5_1.setHorizontalGroup(
			gl_panel_5_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtEndereco, GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5_1.setVerticalGroup(
			gl_panel_5_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_1.createSequentialGroup()
					.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_5_1.setLayout(gl_panel_5_1);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setColumns(10);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		
		cbFuncao = new JComboBox();
		cbFuncao.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
		cbFuncao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		try {
			CadastroDeFuncoes cadFuncao = new CadastroDeFuncoes();
			ArrayList<TiposdeFuncao> funcoes = cadFuncao.GetAllFuncoes();
			for(TiposdeFuncao tipo : funcoes) {
				cbFuncao.addItem(tipo.getFuncao().toString());
			}
			/*for(int i=0; i < funcoes.size(); i++) {
				String texto = funcoes.get(i).getIdFuncao() + " - " + funcoes.get(i).getFuncao().toString();
				cbFuncao.add
			}*/
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(cbFuncao, 0, 479, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(cbFuncao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		txtMatricula = new JTextField();
		txtMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMatricula.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtMatricula, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(txtMatricula, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		RBSim = new JRadioButton("SIM");
		
		RBSim.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		RBNao = new JRadioButton("N\u00C3O");
		RBNao.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		RBSim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(RBSim.isSelected()) {
					RBNao.setSelected(false);
					RBSim.setSelected(true);
				}
			}
		});
		RBNao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(RBNao.isSelected()) {
					RBSim.setSelected(false);
					RBNao.setSelected(true);
				}
			}
		});
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addComponent(RBSim)
					.addGap(18)
					.addComponent(RBNao)
					.addContainerGap())
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(RBSim)
						.addComponent(RBNao)))
		);
		panel_6.setLayout(gl_panel_6);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnFechar = new JButton("");
		btnFechar.setToolTipText("Fechar");
		btnFechar.setIcon(new ImageIcon(CadastroFuncionarios.class.getResource("/img/close-window-32.png")));
		btnFechar.setBackground(Color.RED);
		btnFechar.setForeground(Color.WHITE);
		btnFechar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.GetFrame().setEnabled(true);
				dispose();
			}
		});
		
		btnSalvar = new JButton("");
		btnSalvar.setToolTipText("Salvar");
		
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(0, 128, 0));
		btnSalvar.setIcon(new ImageIcon(CadastroFuncionarios.class.getResource("/img/save-32.png")));
		
		JButton btnApagar = new JButton("");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(
				        null, 
				        "Deseja excluir o funcionário?",
				        "Continua",
				        JOptionPane.YES_NO_OPTION
				        );
				if(i == 0) {
					JOptionPane.showMessageDialog(null, "Para desfazer a exclusão, caso necessário.\nContate o administrador do sistema.");
					FuncionarioDao conection1 = new FuncionarioDao();
					try {
						if(conection1.Deletar(id)) {
							JOptionPane.showMessageDialog(null, "Funcionário excluído!");
							buscarFunc.setEnabled(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Erro ao excluir funcionário.");
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					
				}				
			}
		});
		btnApagar.setToolTipText("Apagar");
		btnApagar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnApagar.setBackground(Color.RED);
		btnApagar.setForeground(Color.WHITE);
		btnApagar.setIcon(new ImageIcon(CadastroFuncionarios.class.getResource("/img/erase-32.png")));
		
		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMatricula.setEditable(true);				
				RBSim.setEnabled(true);
				RBNao.setEnabled(true);								
				txtNome.setEditable(true);				
				comboBox.setEnabled(true);				
				cbFuncao.setEnabled(true);				
				txtEndereco.setEditable(true);				
				txtEmail.setEditable(true);				
				ftCpf.setEditable(true);				
				ftTelefone.setEditable(true);
				cbNivel.setEnabled(true);
				btnSalvar.setEnabled(true);
			}
		});
		btnEditar.setToolTipText("Editar");
		btnEditar.setIcon(new ImageIcon(CadastroFuncionarios.class.getResource("/img/edit-32.png")));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(Color.BLUE);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 361, Short.MAX_VALUE)
					.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnApagar, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnApagar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFechar, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE FUNCION\u00C1RIOS");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				try {
					SalvarOuAtualizar(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		if(id != 0) {
			try {
				FuncionarioDao conectionEdit = new FuncionarioDao();
				Funcionario f = conectionEdit.ConsultaIdCompleta(id);
				
				String matricula = Integer.toString(f.getNumeroRegistro());
				txtMatricula.setEditable(false);
				txtMatricula.setText(matricula);
				
				RBSim.setEnabled(false);
				RBNao.setEnabled(false);
				if(f.isIsGerente()) {
					RBSim.setSelected(true);
					RBNao.setSelected(false);
				}else {
					RBSim.setSelected(false);
					RBNao.setSelected(true);
				}
				
				txtNome.setEditable(false);
				txtNome.setText(f.getNome());
				
				comboBox.setEnabled(false);
				comboBox.setSelectedIndex(f.getNivelAcesso());
				
				cbFuncao.setEnabled(false);
				cbFuncao.setSelectedIndex(f.getIdFuncao());
				
				txtEndereco.setEditable(false);
				txtEndereco.setText(f.getEndereço());
				
				txtEmail.setEditable(false);
				txtEmail.setText(f.getEmail());
				
				ftCpf.setEditable(false);
				ftCpf.setText(f.getCPF());
				
				ftTelefone.setEditable(false);
				ftTelefone.setText(f.getTelefone());
				
				cbNivel.setEnabled(false);
				cbNivel.setSelectedIndex(f.getNivelAcesso());
				
				btnSalvar.setEnabled(false);
				
				rotulo.setVisible(false);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void SalvarOuAtualizar(int id) throws Exception {
		boolean isGerente = false;
		int control = 0;
		if(id == 0) {
			//INSERT
			if(RBSim.isSelected()) {
				isGerente = true;
				control = 1;
			}else if(RBNao.isSelected()) {
				isGerente = false;
				control = 1;
			}
			
			if(control == 1) {
				Funcionario funcionario = new Funcionario(txtNome.getText(), ftCpf.getText(),txtEndereco.getText(), 
						ftTelefone.getText(), txtEmail.getText(), true, false, 
						Integer.parseInt(txtMatricula.getText()),isGerente, false, cbFuncao.getSelectedIndex());
				LoginFuncionarios login = new LoginFuncionarios("12345678", comboBox.getSelectedIndex(), false, funcionario);
				FuncionarioDao conection = new FuncionarioDao();
				boolean resultado = false;
				try {
					resultado = conection.adicionar(funcionario, login);
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(resultado == true) {
					JOptionPane.showMessageDialog(null, "FUNCIONÁRIO CADASTRADO COM SUCESSO!");
					buscarFunc.setEnabled(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR NOVO USUÁRIO");
				}
			}else {
				JOptionPane.showMessageDialog(null, "POR FAVOR VERIFIQUE OS CAMPOS E TENTE NOVAMENTE!");
			}
		}else {
			//Update
			if(RBSim.isSelected()) {
				isGerente = true;
				control = 1;
			}else if(RBNao.isSelected()) {
				isGerente = false;
				control = 1;
			}
			
			if(control == 1) {
				
				FuncionarioDao conection = new FuncionarioDao();
				Funcionario func = conection.ConsultaIdCompleta(id);
				
				func.setNome(txtNome.getText());
				func.setCPF(ftCpf.getText());
				func.setEndereço(txtEndereco.getText());
				func.setTelefone(ftTelefone.getText());
				func.setEmail(txtEmail.getText());
				func.setIsGerente(isGerente);
				func.setIdFuncao(cbFuncao.getSelectedIndex());
				func.setNivelAcesso(cbNivel.getSelectedIndex());
				
				boolean resultado = false;
				resultado = conection.Atualizar(func);
				if(resultado == true) {
					JOptionPane.showMessageDialog(null, "FUNCIONÁRIO ATUALIZADO COM SUCESSO!");
					buscarFunc.setEnabled(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR USUÁRIO");
				}
			}else {
				JOptionPane.showMessageDialog(null, "POR FAVOR VERIFIQUE OS CAMPOS E TENTE NOVAMENTE!");
			}
		}
		
		
	}
	
	public void SetMainDashboard(MainDashboard p) {
		main = p;
	}
	
	public MainDashboard GetMainDashboard() {
		return main;
	}
	
	
	public boolean ValidaCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
	}

	public BuscaFuncionarios getBuscarFunc() {
		return buscarFunc;
	}

	public void setBuscarFunc(BuscaFuncionarios buscarFunc) {
		this.buscarFunc = buscarFunc;
	}
	
	
}

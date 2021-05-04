package br.com.komanda.eletronica.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.komanda.eletronica.dao.FuncionarioDao;
import br.com.komanda.eletronica.model.Funcionario;
import javax.swing.JFormattedTextField;

public class BuscaFuncionarios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableFuncionario;
	private JTextField txtMatricula;
	private JTextField txtNome;
	private JFormattedTextField ftCpf;
	private static MainDashboard main = null;
	private ArrayList<Funcionario> listaDeFuncionarios;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public BuscaFuncionarios() throws SQLException, ParseException {
		setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
						.addComponent(panel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 889, 305);
		panel_3.add(scrollPane);
		
		tableFuncionario = new JTable();
		
		tableFuncionario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Matricula", "Nome", "CPF"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		tableFuncionario.getColumnModel().getColumn(1).setPreferredWidth(326);
		scrollPane.setViewportView(tableFuncionario);	
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarFuncionario((int)tableFuncionario.getModel().getValueAt(
						tableFuncionario.getSelectedRow(),0));
			}
		});
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setIcon(new ImageIcon(BuscaFuncionarios.class.getResource("/img/edit-32.png")));
		btnNewButton_1.setToolTipText("Editar");
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.GetFrame().setEnabled(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(BuscaFuncionarios.class.getResource("/img/cancel-32.png")));
		btnNewButton_1_1_1.setToolTipText("Fechar");
		btnNewButton_1_1_1.setBackground(Color.RED);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroDeFuncionario();
			}
		});
		btnNewButton_1_2.setIcon(new ImageIcon(BuscaFuncionarios.class.getResource("/img/plus-5-32.png")));
		btnNewButton_1_2.setToolTipText("Novo");
		btnNewButton_1_2.setBackground(new Color(0, 128, 0));
		
		JButton btnNewButton_1_1_2 = new JButton("");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreencheTabela();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_2.setIcon(new ImageIcon(BuscaFuncionarios.class.getResource("/img/refresh-32.png")));
		btnNewButton_1_1_2.setToolTipText("Atualizar tabela");
		btnNewButton_1_1_2.setBackground(Color.ORANGE);
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(295)
					.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
						.addComponent(btnNewButton_1_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
						.addComponent(btnNewButton_1_1_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Matricula", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_1 = new JLabel("OU");
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nome", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1_1 = new JLabel("OU");
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CPF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioDao conection = new FuncionarioDao();
				String matricula = txtMatricula.getText();
				String nome = txtNome.getText();
				String cpf = ftCpf.getText();
				cpf = cpf.replace( " " , ""); //tira espaço em branco
				cpf = cpf.replace( "." , ""); //tira ponto
				cpf = cpf.replace( "/" , ""); //tira barra
				cpf = cpf.replace( "-" , ""); //tira hífen
				try {
					listaDeFuncionarios = new ArrayList<>();
					listaDeFuncionarios = conection.getFuncionarios(nome, matricula, cpf);
					PreencheTabelaPesquisa(listaDeFuncionarios);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setToolTipText("Pesquisar");
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setIcon(new ImageIcon(BuscaFuncionarios.class.getResource("/img/search-2-32.png")));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_5_1, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(panel_5_1_1, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(27)
							.addComponent(lblNewLabel_1_1))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(28)
							.addComponent(lblNewLabel_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		GroupLayout gl_panel_5_1 = new GroupLayout(panel_5_1);
		gl_panel_5_1.setHorizontalGroup(
			gl_panel_5_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5_1.setVerticalGroup(
			gl_panel_5_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_1.createSequentialGroup()
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_5_1.setLayout(gl_panel_5_1);
		
		ftCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		GroupLayout gl_panel_5_1_1 = new GroupLayout(panel_5_1_1);
		gl_panel_5_1_1.setHorizontalGroup(
			gl_panel_5_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(ftCpf, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5_1_1.setVerticalGroup(
			gl_panel_5_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_1_1.createSequentialGroup()
					.addComponent(ftCpf, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5_1_1.setLayout(gl_panel_5_1_1);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtMatricula, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel = new JLabel("PESQUISA DE FUNCION\u00C1RIOS");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		PreencheTabela();
	}
	
	public void CadastroDeFuncionario() {
		try {
			CadastroFuncionarios funcionarios = new CadastroFuncionarios(0);
			funcionarios.setLocationRelativeTo(null);
			funcionarios.SetMainDashboard(main);
			funcionarios.setBuscarFunc(this);
			// main.frmSistemaDeCadastro.set
			main.frmSistemaDeCadastro.setEnabled(false);
			funcionarios.setVisible(true);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void EditarFuncionario(int id) {
		try {
			CadastroFuncionarios funcionarios = new CadastroFuncionarios(id);
			funcionarios.setLocationRelativeTo(null);
			funcionarios.SetMainDashboard(main);
			// main.frmSistemaDeCadastro.set
			main.frmSistemaDeCadastro.setEnabled(false);
			funcionarios.setVisible(true);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void SetMainDashboard(MainDashboard p) {
		main = p;
	}
	
	public MainDashboard GetMainDashboard() {
		return main;
	}
	
	public void PreencheTabela() throws SQLException {		
		listaDeFuncionarios = new ArrayList<>();
		listaDeFuncionarios = this.GetAll();
		
		DefaultTableModel model = (DefaultTableModel) tableFuncionario.getModel();
		model.setNumRows(0);
		
		for(int i=0; i < listaDeFuncionarios.size(); i++) {
			int id = listaDeFuncionarios.get(i).getIdFuncionario();
			String nome = listaDeFuncionarios.get(i).getNome();
			String cpf = listaDeFuncionarios.get(i).getCPF();
			int matricula = listaDeFuncionarios.get(i).getNumeroRegistro();
			model.insertRow(0, new Object[] { id, matricula, nome, cpf});
		}
	}
	
	public void PreencheTabelaPesquisa(ArrayList<Funcionario> lista) throws SQLException {		
		
		DefaultTableModel model = (DefaultTableModel) tableFuncionario.getModel();
		model.setNumRows(0);
		
		if(lista.size() > 0) {
			for(int i=0; i < lista.size(); i++) {
				int id = lista.get(i).getIdFuncionario();
				String nome = lista.get(i).getNome();
				String cpf = lista.get(i).getCPF();
				int matricula = lista.get(i).getNumeroRegistro();
				model.insertRow(0, new Object[] { id, matricula, nome, cpf});
				model.insertRow(0, new Object[] { id, nome, cpf});
			}
		}else {
			JOptionPane.showMessageDialog(null, "Não existem ");
		}
	}
	
	public ArrayList<Funcionario> GetAll() throws SQLException {
		return new FuncionarioDao().getAll();
	}
}

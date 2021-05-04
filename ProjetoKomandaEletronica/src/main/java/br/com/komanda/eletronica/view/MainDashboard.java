package br.com.komanda.eletronica.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.komanda.eletronica.dao.FuncionarioDao;
import br.com.komanda.eletronica.dao.LoginDao;
import br.com.komanda.eletronica.model.Funcionario;
import br.com.komanda.eletronica.view.enums.CadastroDeFuncoes;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Frame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.SoftBevelBorder;

@SuppressWarnings("unused")
public class MainDashboard {

	public JFrame frmSistemaDeCadastro;
	private JLabel JLHora;
	private JLabel JLData;
	private static Login login;
	private static MainDashboard main = null;
	private static LoginDao loginDao;
	
	private int IdFuncionario;
	private Funcionario func;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { MainDashboard window = new
	 * MainDashboard(); window.frmSistemaDeCadastro.setVisible(true);
	 * window.frmSistemaDeCadastro.setLocationRelativeTo(null); } catch (Exception
	 * e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public MainDashboard(Login log, LoginDao logDao) {
		
		login = log;
		login.ftUsuario.setText("");
		login.pfSenha.setText("");
		main = this;
		loginDao = logDao;
		this.BuscaFuncionario(loginDao.getIdFuncionario());
		initialize();
	}
	
	

	public int getIdFuncionario() {
		return IdFuncionario;
	}



	public void setIdFuncionario(int idFuncionario) {
		IdFuncionario = idFuncionario;
	}



	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frmSistemaDeCadastro = new JFrame();
		frmSistemaDeCadastro.setUndecorated(true);
		frmSistemaDeCadastro.setResizable(false);
		frmSistemaDeCadastro.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// data
				Date dataSistema = new Date();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
				JLData.setText(formato.format(dataSistema));

				// hora
				Timer timer = new Timer(1000, new hora());
				timer.start();

			}
		});
		frmSistemaDeCadastro
				.setIconImage(Toolkit.getDefaultToolkit().getImage(MainDashboard.class.getResource("/img/layout.png")));
		frmSistemaDeCadastro.setTitle("SISTEMA DE KOMANDA ELETR\u00D4NICA");
		frmSistemaDeCadastro.setBounds(100, 100, 1040, 584);
		frmSistemaDeCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeCadastro.setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnArquivo);

		JMenuItem MenuItemSair = new JMenuItem("Sair");
		MenuItemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		MenuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		MenuItemSair.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/door_out.png")));
		mnArquivo.add(MenuItemSair);
		
		JMenuItem bloqueio = new JMenuItem("Bloquear");
		bloqueio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		bloqueio.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/Key.png")));
		bloqueio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.SetMainDashboard(main);
				((Login) login).setFunc(func);
				login.MostraLabel();
				login.setVisible(true);
				main.frmSistemaDeCadastro.dispose();
			}
		});
		mnArquivo.add(bloqueio);

		JMenu mnCadastro = new JMenu("Cadastro ");
		mnCadastro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnCadastro);

		JMenu MenuPessoas = new JMenu("Funcionarios");
		MenuPessoas.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/User-Group-icon.png")));
		mnCadastro.add(MenuPessoas);

		JMenuItem MenuItemAdicionar = new JMenuItem("Funcion\u00E1rios");
		MenuItemAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BuscaDeFuncionarios();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		MenuItemAdicionar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_MASK));
		MenuItemAdicionar.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/user_add.png")));
		MenuPessoas.add(MenuItemAdicionar);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alterar Senha");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlteraSenha alterarSenha = new AlteraSenha(func);
				alterarSenha.setLocationRelativeTo(null);
				AlteraSenha.setMain(main);
				main.frmSistemaDeCadastro.setEnabled(false);
				alterarSenha.setVisible(true);
			}
		});
		
				JMenuItem mntmNewMenuItem = new JMenuItem("Fun\u00E7\u00F5es");
				MenuPessoas.add(mntmNewMenuItem);
				mntmNewMenuItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CadastroDeFuncoes cadFuncoes;
						try {
							cadFuncoes = new CadastroDeFuncoes();
							cadFuncoes.setLocationRelativeTo(null);
							cadFuncoes.SetMainDashboard(main);
							main.frmSistemaDeCadastro.setEnabled(false);
							cadFuncoes.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				mntmNewMenuItem.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/cog_add.png")));
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/Key.png")));
		MenuPessoas.add(mntmNewMenuItem_1);

		JMenu MenuMesas = new JMenu("Mesas");
		MenuMesas.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/book_next.png")));
		mnCadastro.add(MenuMesas);

		JMenuItem mntmNewMenuMesas = new JMenuItem("Controle de Mesas");
		mntmNewMenuMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Evento para abrir nova tela
				CadastroMesas cadastromesas;
				try {
					cadastromesas = new CadastroMesas();
					cadastromesas.setLocationRelativeTo(null);
					cadastromesas.SetMainDashboard(main);

					main.frmSistemaDeCadastro.setEnabled(false);
					cadastromesas.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mntmNewMenuMesas.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/arrow_refresh.png")));
		MenuMesas.add(mntmNewMenuMesas);

		JMenu MenuCardapio = new JMenu("Cardapios");
		MenuCardapio.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/table_multiple.png")));
		mnCadastro.add(MenuCardapio);

		JMenuItem mntmNewMenuCardapio = new JMenuItem("Cadastro Cardapio");
		mntmNewMenuCardapio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Evento para abrir nova tela
				CadastroCardapio cadastrocardapio;
				try {
					cadastrocardapio = new CadastroCardapio();
					cadastrocardapio.setLocationRelativeTo(null);
					cadastrocardapio.SetMainDashboard(main);

					main.frmSistemaDeCadastro.setEnabled(false);
					cadastrocardapio.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		MenuCardapio.add(mntmNewMenuCardapio);
		
		JMenu MenuEstoque = new JMenu("Estoque");
		MenuEstoque.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/estoque.png")));
		mnCadastro.add(MenuEstoque);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cadastro  Produtos");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				// TODO Evento para abrir nova tela
				CadastroProdutoEstoque cadastroprodutoestoque;
				try {
					cadastroprodutoestoque = new CadastroProdutoEstoque();
					cadastroprodutoestoque.setLocationRelativeTo(null);
					cadastroprodutoestoque.SetMainDashboard(main);

					main.frmSistemaDeCadastro.setEnabled(false);
					cadastroprodutoestoque.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			
				
				
			}
		});
		MenuEstoque.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Tipos de Produtos");
		MenuEstoque.add(mntmNewMenuItem_3);

		JMenu mnPedido = new JMenu("Pedido");
		mnPedido.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnPedido);

		JMenu MenuMesa = new JMenu("Mesa");
		MenuMesa.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/book_next.png")));
		mnPedido.add(MenuMesa);

		JMenuItem mmtmMesaPedido = new JMenuItem("Pedido na Mesa");
		mmtmMesaPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Evento para abrir nova tela
				PedidoMesa pedidomesa;
				try {
					pedidomesa = new PedidoMesa();
					pedidomesa.setLocationRelativeTo(null);
					pedidomesa.SetMainDashboard(main);

					main.frmSistemaDeCadastro.setEnabled(false);
					pedidomesa.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		mmtmMesaPedido.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/arrow_refresh.png")));
		MenuMesa.add(mmtmMesaPedido);

		JMenu MenuDelivery = new JMenu("Delivery");
		mnPedido.add(MenuDelivery);

		JMenu mnRelatorio = new JMenu("Relatorio");
		mnRelatorio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnRelatorio.setIcon(null);
		menuBar.add(mnRelatorio);

		JMenuItem MenuItemRelatorio = new JMenuItem("Relatorio");
		MenuItemRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		MenuItemRelatorio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, InputEvent.ALT_MASK));
		MenuItemRelatorio.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/report.png")));
		mnRelatorio.add(MenuItemRelatorio);

		JMenu mnInformacao = new JMenu("Informacao");
		mnInformacao.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnInformacao.setIcon(null);
		menuBar.add(mnInformacao);

		JMenuItem MenuItemContato = new JMenuItem("Contato");
		MenuItemContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contato contato = new Contato(main);
				contato.setLocationRelativeTo(null);
				contato.setVisible(true);
			}
		});
		MenuItemContato.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, InputEvent.ALT_MASK));
		MenuItemContato.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/feed.png")));
		mnInformacao.add(MenuItemContato);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JLHora = new JLabel("");
		JLHora.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JLHora.setHorizontalAlignment(SwingConstants.CENTER);
		JLHora.setForeground(Color.BLUE);
		JLHora.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLData = new JLabel("");
		JLData.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JLData.setHorizontalAlignment(SwingConstants.CENTER);
		JLData.setForeground(Color.BLUE);
		JLData.setFont(new Font("Tahoma", Font.BOLD, 14));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/power-32.png")));
		btnNewButton.setToolTipText("Fechar");
		btnNewButton.setSelectedIcon(new ImageIcon(
				"C:\\Users\\Inform\u00E1tica\\Documents\\Projetos Eclipse\\Komanda Eletr\u00F4nica\\komanda-eletronica\\ProjetoKomandaEletronica\\src\\main\\java\\img\\cancel.png"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSistemaDeCadastro.dispose();
			}
		});

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/padlock-32.png")));
		btnNewButton_1.setToolTipText("Bloquear Sistema");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.SetMainDashboard(main);
				((Login) login).setFunc(func);
				login.MostraLabel();
				login.setVisible(true);
				main.frmSistemaDeCadastro.dispose();
			}
		});
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JLabel lblNewLabellog = new JLabel("");
		lblNewLabellog.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabellog.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/logo_if_resize.png")));
		GroupLayout groupLayout = new GroupLayout(frmSistemaDeCadastro.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(10)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 256,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10)
												.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE))
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE))
								.addGap(6))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(panel_1,
								GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)))
				.addGap(20)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGap(11).addComponent(panel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addGap(15)));
		
		JLabel lbLogin = new JLabel("");
		lbLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbLogin.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbLogin.setForeground(new Color(0, 0, 205));
		lbLogin.setText("Usuário Logado: " + func.getNome());
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbLogin, GroupLayout.PREFERRED_SIZE, 716, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(JLData, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(JLHora, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
					.addGap(8))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(JLData, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
							.addComponent(JLHora, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)))
					.addGap(7))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_3.createSequentialGroup().addContainerGap(190, Short.MAX_VALUE)
						.addComponent(lblNewLabellog, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabellog, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
						.addContainerGap()));
		panel_3.setLayout(gl_panel_3);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										gl_panel_2.createSequentialGroup().addGap(10).addComponent(btnNewButton,
												GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
								.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
										.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
						.addGap(16)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE).addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE).addContainerGap()));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/Logo Komanda.png")));
		
		JPanel panel_menus = new JPanel();
		panel_menus.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Menus R\u00E1pidos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_menus, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_menus, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addGap(31))
		);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("Funcion\u00E1rios");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(0, 0, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/conference-32.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BuscaDeFuncionarios();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setToolTipText("Card\u00E1pio");
		btnNewButton_2_1.setBackground(new Color(0, 0, 255));
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2_1.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/menu-4-32.png")));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCardapio cadastrocardapio;
				try {
					cadastrocardapio = new CadastroCardapio();
					cadastrocardapio.setLocationRelativeTo(null);
					cadastrocardapio.SetMainDashboard(main);

					main.frmSistemaDeCadastro.setEnabled(false);
					cadastrocardapio.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_2_2 = new JButton("");
		btnNewButton_2_2.setToolTipText("Produtos");
		btnNewButton_2_2.setBackground(new Color(0, 0, 255));
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2_2.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/product-32.png")));
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Evento para abrir nova tela
				CadastroProdutoEstoque cadastroprodutoestoque;
				try {
					cadastroprodutoestoque = new CadastroProdutoEstoque();
					cadastroprodutoestoque.setLocationRelativeTo(null);
					cadastroprodutoestoque.SetMainDashboard(main);

					main.frmSistemaDeCadastro.setEnabled(false);
					cadastroprodutoestoque.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_2_3 = new JButton("");
		btnNewButton_2_3.setToolTipText("Pedido na mesa");
		btnNewButton_2_3.setBackground(new Color(0, 0, 255));
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2_3.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/book-19-32.png")));
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Evento para abrir nova tela
				PedidoMesa pedidomesa;
				try {
					pedidomesa = new PedidoMesa();
					pedidomesa.setLocationRelativeTo(null);
					pedidomesa.SetMainDashboard(main);

					main.frmSistemaDeCadastro.setEnabled(false);
					pedidomesa.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_2_4 = new JButton("");
		btnNewButton_2_4.setToolTipText("Delivery");
		btnNewButton_2_4.setBackground(new Color(0, 0, 255));
		btnNewButton_2_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2_4.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/delivery-32.png")));
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Função ainda em desenvolvimento!");
			}
		});
		
		JButton btnNewButton_2_5 = new JButton("");
		btnNewButton_2_5.setToolTipText("Mesas");
		btnNewButton_2_5.setBackground(new Color(0, 0, 255));
		btnNewButton_2_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2_5.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/table-32.png")));
		btnNewButton_2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Evento para abrir nova tela
				CadastroMesas cadastromesas;
				try {
					cadastromesas = new CadastroMesas();
					cadastromesas.setLocationRelativeTo(null);
					cadastromesas.SetMainDashboard(main);

					main.frmSistemaDeCadastro.setEnabled(false);
					cadastromesas.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel_menus = new GroupLayout(panel_menus);
		gl_panel_menus.setHorizontalGroup(
			gl_panel_menus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_menus.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2_2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2_3, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2_4, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2_5, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_panel_menus.setVerticalGroup(
			gl_panel_menus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_menus.createSequentialGroup()
					.addComponent(btnNewButton_2_5, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel_menus.createSequentialGroup()
					.addGroup(gl_panel_menus.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_2_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
						.addComponent(btnNewButton_2_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
						.addGroup(gl_panel_menus.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
							.addComponent(btnNewButton_2_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
							.addComponent(btnNewButton_2_2, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panel_menus.setLayout(gl_panel_menus);
		panel_4.setLayout(gl_panel_4);
		panel_1.setLayout(gl_panel_1);
		frmSistemaDeCadastro.getContentPane().setLayout(groupLayout);

		frmSistemaDeCadastro.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// frmSistemaDeCadastro.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		//this.BuscaFuncionario(this.getIdFuncionario());
		
		
	}
	
	public void BuscaDeFuncionarios() throws ParseException {
		BuscaFuncionarios busca;
		try {
			busca = new BuscaFuncionarios();
			busca.setLocationRelativeTo(null);
			busca.SetMainDashboard(main);
			// main.frmSistemaDeCadastro.set
			main.frmSistemaDeCadastro.setEnabled(false);
			busca.setVisible(true);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// classe hora
	class hora implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Calendar now = Calendar.getInstance();
			JLHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
		}
	}
	
	public void BuscaFuncionario(int id) {
		if(id != 0) {
			FuncionarioDao funcDao = new FuncionarioDao();
			try {
				func = funcDao.consultaid(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}else {
			func = new Funcionario(0, 0, "Administrador","12345678900", false, 0, true,0);
		}
				
		//return func;
	}

	public JFrame GetFrame() {
		return frmSistemaDeCadastro;
	}
}// fim da classe principal

package br.com.komanda.eletronica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;

@SuppressWarnings("unused")
public class MainDashboard {

	private JFrame frmSistemaDeCadastro;
	private JLabel JLHora;
	private JLabel JLData;
	private static Login login;
	private static MainDashboard main = null;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDashboard window = new MainDashboard();
					window.frmSistemaDeCadastro.setVisible(true);
					window.frmSistemaDeCadastro.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public MainDashboard(Login log) {
		initialize();
		login = log;
		main = this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frmSistemaDeCadastro = new JFrame();
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

		JMenu mnCadastro = new JMenu("Cadastro ");
		menuBar.add(mnCadastro);

		JMenu MenuPessoas = new JMenu("Funcionarios");
		mnCadastro.add(MenuPessoas);

		JMenuItem MenuItemAdicionar = new JMenuItem("Adicionar");
		MenuItemAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		MenuItemAdicionar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_MASK));
		MenuItemAdicionar.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/user_add.png")));
		MenuPessoas.add(MenuItemAdicionar);

		JMenuItem MenuItemAtualizar = new JMenuItem("Atualizar");
		MenuItemAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		MenuItemAtualizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, InputEvent.ALT_MASK));
		MenuItemAtualizar.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/user_edit.png")));
		MenuPessoas.add(MenuItemAtualizar);

		JMenuItem MenuItemDeletar = new JMenuItem("Deletar");
		MenuItemDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		MenuItemDeletar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, InputEvent.ALT_MASK));
		MenuItemDeletar.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/user_delete.png")));
		MenuPessoas.add(MenuItemDeletar);
		
		JMenu MenuProdutos = new JMenu("Produtos");
		mnCadastro.add(MenuProdutos);
		
		JMenu MenuMesas = new JMenu("Mesas");
		mnCadastro.add(MenuMesas);
		
		JMenu MenuCardapio = new JMenu("Cardapios");
		mnCadastro.add(MenuCardapio);
						
						JMenu mnPedido = new JMenu("Pedido");
						menuBar.add(mnPedido);
						
						JMenu MenuMesa = new JMenu("Mesa");
						mnPedido.add(MenuMesa);
						
						JMenu MenuDelivery = new JMenu("Delivery");
						mnPedido.add(MenuDelivery);
				
						JMenu mnRelatorio = new JMenu("Relatorio");
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
				mnInformacao.setIcon(null);
				menuBar.add(mnInformacao);
				
						JMenuItem MenuItemContato = new JMenuItem("Contato");
						MenuItemContato.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Contato contato = new Contato();
								contato.setLocationRelativeTo(null);
								contato.setVisible(true);
							}
						});
						MenuItemContato.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, InputEvent.ALT_MASK));
						MenuItemContato.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/feed.png")));
						mnInformacao.add(MenuItemContato);
		frmSistemaDeCadastro.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(-13, 477, 1052, 57);
		frmSistemaDeCadastro.getContentPane().add(panel);
		panel.setLayout(null);

		JLHora = new JLabel("");
		JLHora.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JLHora.setBounds(890, 11, 121, 21);
		JLHora.setHorizontalAlignment(SwingConstants.CENTER);
		JLHora.setForeground(Color.BLUE);
		JLHora.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(JLHora);

		JLData = new JLabel("");
		JLData.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JLData.setHorizontalAlignment(SwingConstants.CENTER);
		JLData.setForeground(Color.BLUE);
		JLData.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLData.setBounds(760, 11, 121, 21);
		panel.add(JLData);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 11, 1004, 310);
		frmSistemaDeCadastro.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 332, 256, 134);
		frmSistemaDeCadastro.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("FECHAR");
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\Inform\u00E1tica\\Documents\\Projetos Eclipse\\Komanda Eletr\u00F4nica\\komanda-eletronica\\ProjetoKomandaEletronica\\src\\main\\java\\img\\cancel.png"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSistemaDeCadastro.dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 230, 51);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BLOQUEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.SetMainDashboard(main);
				login.setVisible(true);
				main.frmSistemaDeCadastro.dispose();
			}
		});
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 73, 230, 51);
		panel_2.add(btnNewButton_1);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBounds(276, 332, 738, 134);
				frmSistemaDeCadastro.getContentPane().add(panel_3);
						panel_3.setLayout(null);
				
						JLabel lblNewLabellog = new JLabel("");
						lblNewLabellog.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabellog.setBounds(10, 11, 718, 113);
						panel_3.add(lblNewLabellog);
						lblNewLabellog.setIcon(new ImageIcon(MainDashboard.class.getResource("/img/logo_if_resize.png")));
	}

	// classe hora
	class hora implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Calendar now = Calendar.getInstance();
			JLHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
		}
	}
	
	public JFrame GetFrame() {
		return frmSistemaDeCadastro;
	}
}// fim da classe principal

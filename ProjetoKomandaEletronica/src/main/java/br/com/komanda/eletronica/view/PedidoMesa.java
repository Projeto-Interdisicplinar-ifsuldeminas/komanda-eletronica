package br.com.komanda.eletronica.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.komanda.eletronica.dao.CadastroCardapioDao;
import br.com.komanda.eletronica.dao.MesaDao;
import br.com.komanda.eletronica.model.Mesa;
import br.com.komanda.eletronica.model.Pedido;
import br.com.komanda.eletronica.model.ProdutoCardapio;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PedidoMesa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private static MainDashboard main = null;
	private JTextField TFid;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cbPedido;
	
	private JTable tablePedido;
	private JTextField txtVlTotal;
	private JSpinner spQuantidade;
	private ArrayList<Pedido> listaDePedidos;

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PedidoMesa() throws Exception {
		listaDePedidos = new ArrayList<>();
		setUndecorated(true);
		setTitle("CADASTRO DE MESAS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PedidoMesa.class.getResource("/img/user_edit.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 786);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);

		JPanel panel_header = new JPanel();
		panel_header.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JPanel panel_botoes_crud = new JPanel();
		panel_botoes_crud.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JPanel panel_central = new JPanel();
		panel_central.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_central, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
						.addComponent(panel_header, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
						.addComponent(panel_botoes_crud, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_header, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_central, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_botoes_crud, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Card\u00E1pio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel panelID = new JPanel();
		panelID.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"ID DO PEDIDO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelID.setToolTipText("");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Mesa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pedidos da mesa (Selecione)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel_central = new GroupLayout(panel_central);
		gl_panel_central.setHorizontalGroup(
			gl_panel_central.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_central.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_central.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
						.addComponent(panel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
						.addComponent(panelID, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_central.setVerticalGroup(
			gl_panel_central.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_central.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelID, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		tablePedido = new JTable();
		
		tablePedido.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Item", "Quant.", "Vl. Unit.", "Vl. Total", "Status"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			@SuppressWarnings({ })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		tablePedido.getColumnModel().getColumn(1).setPreferredWidth(326);
		scrollPane.setViewportView(tablePedido);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Valor Total", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
				JButton btnApagar = new JButton("");
				btnApagar.setToolTipText("Apagar Produto Selecionado");
				btnApagar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// TODO Botao apagar
						int selected = tablePedido.getSelectedRow();
						listaDePedidos.remove(selected);
						try {
							PreencheTabela();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnApagar.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnApagar.setBackground(Color.RED);
				btnApagar.setForeground(Color.WHITE);
				btnApagar.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/erase-32.png")));
		
				JButton btnEditar = new JButton("");
				btnEditar.setToolTipText("Editar Produto Selecionado");
				btnEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// TODO Botao atualizar

//				String idtexto = TFid.getText();
//				String nome = TFidpedido.getText();
//				int id = Integer.parseInt(idtexto);
//				Mesa mesa = new Mesa(id, nome);
//
//				MesaDao conexaoupdate = new MesaDao();
//				boolean resposta = false;
//				try {
//					resposta = conexaoupdate.atualizar(mesa, id);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				if (resposta == true) {
//					JOptionPane.showMessageDialog(null, "\nRegistro atualizado com sucesso !", "Sucesso",
//							JOptionPane.INFORMATION_MESSAGE);
//				} else {
//					JOptionPane.showMessageDialog(null, "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
//				}

					}
				});
				btnEditar.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/edit-32.png")));
				btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnEditar.setForeground(Color.WHITE);
				btnEditar.setBackground(Color.BLUE);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnApagar, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 504, Short.MAX_VALUE)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEditar, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
								.addComponent(btnApagar, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))))
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1 = new JLabel("R$");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtVlTotal = new JTextField();
		txtVlTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtVlTotal.setText("0.00");
		txtVlTotal.setEditable(false);
		txtVlTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtVlTotal.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtVlTotal, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtVlTotal, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		panel_1.setLayout(gl_panel_1);
		
				JComboBox cbMesa = new JComboBox();
				cbMesa.setModel(new DefaultComboBoxModel(new String[] { "SELECIONE" }));
				cbMesa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(cbMesa, 0, 933, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(cbMesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		panelID.setLayout(null);

		TFid = new JTextField();
		TFid.setText("0");
		TFid.setEnabled(false);
		TFid.setBounds(23, 16, 126, 35);
		panelID.add(TFid);
		TFid.setColumns(10);
		panel_5.setLayout(null);

		try {
			MesaDao mesadao = new MesaDao();
			List<Mesa> funcoes = mesadao.listamesa();
			for (Mesa tipo : funcoes) {
				cbMesa.addItem(tipo);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		cbPedido = new JComboBox();
		cbPedido.setEnabled(false);
		cbPedido.setModel(new DefaultComboBoxModel(new String[] { "SELECIONE" }));
		cbPedido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbPedido.setBounds(10, 22, 771, 47);
		panel_5.add(cbPedido);		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Quantidade", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(791, 22, 141, 47);
		panel_5.add(panel_2);
		
		spQuantidade = new JSpinner();
		spQuantidade.setEnabled(false);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(spQuantidade, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(spQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel_central.setLayout(gl_panel_central);

		CarregaCardapio();
		
		

		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Fechar");
		btnNewButton.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/cancel-32.png")));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.GetFrame().setEnabled(true);
				dispose();
			}
		});
		
		JButton btnIncluir = new JButton("");
		btnIncluir.setEnabled(false);
		btnIncluir.setToolTipText("Incluir");
		btnIncluir.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/plus-5-32.png")));
		btnIncluir.setBackground(new Color(0, 128, 0));
		btnIncluir.setBounds(942, 22, 80, 47);
		panel_5.add(btnIncluir);
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido pedido = new Pedido();
				ProdutoCardapio index = (ProdutoCardapio)cbPedido.getSelectedItem();
				Mesa m = (Mesa)cbMesa.getSelectedItem();
				pedido.setMesa(m);
				pedido.setProdutoCardapio(index);
				pedido.setQuantidade(Integer.parseInt(spQuantidade.getValue().toString()));
				pedido.setStatus(1);
				listaDePedidos.add(pedido);
				try {
					PreencheTabela();
					MostraTotal();
					//cbPedido.setSelectedIndex("SELECIONE");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//JOptionPane.showMessageDialog(null, index);
				
			}
		});
		
		cbMesa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cbPedido.setEnabled(true);
				spQuantidade.setEnabled(true);
				btnIncluir.setEnabled(true);
				LimpaTabela();
			}
		});

		JButton btnSalvar = new JButton("");
		btnSalvar.setToolTipText("Fechar Pedido");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Botão Salvar

//				String nome = TFidpedido.getText();
//				Mesa mesa = new Mesa(nome);
//
//				MesaDao conexaoadicionar = new MesaDao();
//				boolean resposta;
//				try {
//					resposta = conexaoadicionar.adicionar(mesa);
//					if (resposta == true) {
//						JOptionPane.showMessageDialog(null, "\nincluido com sucesso !", "Sucesso",
//								JOptionPane.INFORMATION_MESSAGE);
//					} else {
//						JOptionPane.showMessageDialog(null, "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
//					}
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}

			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(0, 128, 0));
		btnSalvar.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/save-32.png")));

		JButton btnFrente = new JButton("");
		btnFrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO botao navegar para frente

//				String idatual = TFid.getText();
//				int soma = Integer.parseInt(idatual);
//				soma = soma + 1;
//				int id = 0;
//				id = id + soma;
//				MesaDao consultaid = new MesaDao();
//				List<Mesa> mesa;
//				try {
//					mesa = consultaid.consultaid(id);
//					if (mesa.isEmpty()) {
//						String idex = Integer.toString(id);
//						TFid.setText(idex);
//						TFidpedido.setText("");
//					} else {
//						for (Mesa m : mesa) {
//							String retornoid = Integer.toString(m.getIdMesa());
//							TFid.setText(retornoid);
//							TFidpedido.setText(m.getNomeMesa());
//						}
//					}
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});
		btnFrente.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/arrow-24-32.png")));
		btnFrente.setForeground(Color.WHITE);
		btnFrente.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFrente.setBackground(Color.CYAN);

		JButton btnTras = new JButton("");
		btnTras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO botao navegar para tras

//				String idatual = TFid.getText();
//				int soma = Integer.parseInt(idatual);
//				if (soma == -1) {
//					soma = 1;
//				}
//				soma = soma - 1;
//				int id = 0;
//				id = id + soma;
//				MesaDao consultaid = new MesaDao();
//				List<Mesa> mesa;
//				try {
//					mesa = consultaid.consultaid(id);
//					if (mesa.isEmpty()) {
//						String idex = Integer.toString(id);
//						TFid.setText(idex);
//						TFidpedido.setText("");
//					} else {
//						for (Mesa m : mesa) {
//							String retornoid = Integer.toString(m.getIdMesa());
//							TFid.setText(retornoid);
//							TFidpedido.setText(m.getNomeMesa());
//						}
//					}
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});
		btnTras.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/arrow-88-32.png")));
		btnTras.setForeground(Color.WHITE);
		btnTras.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTras.setBackground(Color.CYAN);
		GroupLayout gl_panel_botoes_crud = new GroupLayout(panel_botoes_crud);
		gl_panel_botoes_crud.setHorizontalGroup(
			gl_panel_botoes_crud.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_botoes_crud.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnTras, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFrente, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_botoes_crud.setVerticalGroup(
			gl_panel_botoes_crud.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_botoes_crud.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_botoes_crud.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_botoes_crud.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnFrente, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnTras, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_botoes_crud.setLayout(gl_panel_botoes_crud);

		JLabel lblNewLabel = new JLabel("CADASTRO DE PEDIDOS");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_header = new GroupLayout(panel_header);
		gl_panel_header.setHorizontalGroup(
			gl_panel_header.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_header.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_header.setVerticalGroup(
			gl_panel_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_header.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel_header.setLayout(gl_panel_header);
		contentPane.setLayout(gl_contentPane);
	}

	public void SetMainDashboard(MainDashboard p) {
		main = p;
	}

	public MainDashboard GetMainDashboard() {
		return main;
	}
	
	public void MostraTotal() {
		double valorTotal = 0.00;
		for(int i=0; i < listaDePedidos.size(); i++) {
			valorTotal = valorTotal + (listaDePedidos.get(i).getQuantidade() * listaDePedidos.get(i).getProdutoCardapio().getValor()); 
		}
		txtVlTotal.setText(String.valueOf(valorTotal));
	}
	
	public void LimpaTabela() {
		DefaultTableModel model = (DefaultTableModel) tablePedido.getModel();
		model.setNumRows(0);
	}
	
	@SuppressWarnings({ "unchecked" })
	public void CarregaCardapio() throws Exception {
		try {
			CadastroCardapioDao cardapio = new CadastroCardapioDao();
			ArrayList<ProdutoCardapio> listaCardapio = (ArrayList<ProdutoCardapio>) cardapio.produtocardapiolista();
			//cbPedido.setModel(new ComboBoxModelAll(ProdutoCardapio));
			for(ProdutoCardapio tipo : listaCardapio) {
				//cbPedido.addItem(tipo.getNome());
				cbPedido.addItem(tipo);
			}
			//cbPedido.DisplayMember = "nome";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void PreencheTabela() throws Exception {		
		
		DefaultTableModel model = (DefaultTableModel) tablePedido.getModel();
		model.setNumRows(0);	
		
		for(int i=0; i < listaDePedidos.size(); i++) {
			model.insertRow(0, new Object[] { listaDePedidos.get(i).getProdutoCardapio().getIdProdutoCardapio(), listaDePedidos.get(i).getProdutoCardapio().getNome(), listaDePedidos.get(i).getQuantidade(),listaDePedidos.get(i).getProdutoCardapio().getValor(), (listaDePedidos.get(i).getProdutoCardapio().getValor()*listaDePedidos.get(i).getQuantidade()), "Aguardando envio à cozinha"});
		}
	}
	
}

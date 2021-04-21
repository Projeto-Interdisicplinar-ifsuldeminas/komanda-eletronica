package br.com.komanda.eletronica.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.komanda.eletronica.model.Mesa;
import dao.MesaDao;

public class PedidoMesa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TFNome;

	private static MainDashboard main = null;
	private JTextField TFid;

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public PedidoMesa() throws ParseException {

		setUndecorated(true);
		setTitle("CADASTRO DE MESAS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PedidoMesa.class.getResource("/img/user_edit.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 610);
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
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_central, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
						.addComponent(panel_botoes_crud, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 989,
								Short.MAX_VALUE)
						.addComponent(panel_header, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel_header, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_central, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
						.addComponent(panel_botoes_crud, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nome Completo da Mesa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel panelID = new JPanel();
		panelID.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ID",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelID.setToolTipText("");
		GroupLayout gl_panel_central = new GroupLayout(panel_central);
		gl_panel_central.setHorizontalGroup(gl_panel_central.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_central.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_central.createParallelGroup(Alignment.LEADING)
								.addComponent(panelID, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel_central.setVerticalGroup(gl_panel_central.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_central.createSequentialGroup().addGap(20)
						.addComponent(panelID, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(130, Short.MAX_VALUE)));
		panelID.setLayout(null);

		TFid = new JTextField();
		TFid.setText("0");
		TFid.setEnabled(false);
		TFid.setBounds(23, 16, 126, 35);
		panelID.add(TFid);
		TFid.setColumns(10);

		TFNome = new JTextField();
		TFNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFNome.setColumns(10);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup().addContainerGap()
						.addComponent(TFNome, GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE).addGap(12)));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
						.addComponent(TFNome, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_5.setLayout(gl_panel_5);
		panel_central.setLayout(gl_panel_central);

		JButton btnNewButton = new JButton("   FECHAR");
		btnNewButton.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/cancel.png")));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.GetFrame().setEnabled(true);
				dispose();
			}
		});

		JButton btnSalvar = new JButton("   SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Botão Salvar
				String nome = TFNome.getText();
				Mesa mesa = new Mesa(nome);

				MesaDao conexaoadicionar = new MesaDao();
				boolean resposta = conexaoadicionar.adicionar(mesa);

				if (resposta == true) {
					JOptionPane.showMessageDialog(null, "\nincluido com sucesso !", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(0, 128, 0));
		btnSalvar.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/user_add.png")));

		JButton btnApagar = new JButton("   APAGAR");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Botao apagar
				String rcid = TFid.getText();
				int idenvio = 0;
				idenvio = Integer.parseInt(rcid);
				MesaDao deletarpessoa = new MesaDao();
				try {
					boolean retorno = deletarpessoa.deletar(idenvio);
					if (retorno == true) {
						JOptionPane.showMessageDialog(null, "\nDeletado com sucesso !", "Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					System.out.println("Erro na conexao apagar");
				}
				// Limpando os campos
				TFid.setText("0");
				TFNome.setText("");
			}
		});
		btnApagar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnApagar.setBackground(Color.RED);
		btnApagar.setForeground(Color.WHITE);
		btnApagar.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/user_delete.png")));

		JButton btnEditar = new JButton("   EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Botao atualizar
				String idtexto = TFid.getText();
				String nome = TFNome.getText();
				int id = Integer.parseInt(idtexto);
				Mesa mesa = new Mesa(id, nome);

				MesaDao conexaoupdate = new MesaDao();
				boolean resposta = false;
				try {
					resposta = conexaoupdate.atualizar(mesa, id);
				} catch (SQLException e1) {
					System.out.println("Erro na conexao update");
				}
				if (resposta == true) {
					JOptionPane.showMessageDialog(null, "\nRegistro atualizado com sucesso !", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnEditar.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/user_edit.png")));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(Color.BLUE);

		JButton btnFrente = new JButton("");
		btnFrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO botao navegar para frente
				String idatual = TFid.getText();
				int soma = Integer.parseInt(idatual);
				soma = soma + 1;
				int id = 0;
				id = id + soma;
				MesaDao consultaid = new MesaDao();
				try {
					List<Mesa> mesa = consultaid.consultaid(id);
					if (mesa.isEmpty()) {
						String idex = Integer.toString(id);
						TFid.setText(idex);
						TFNome.setText("");
					} else {
						for (Mesa m : mesa) {
							String retornoid = Integer.toString(m.getIdMesa());
							TFid.setText(retornoid);
							TFNome.setText(m.getNomeMesa());
						}
					}

				} catch (SQLException e1) {
					System.out.println("Erro botao navegar para frente");
				}
			}
		});
		btnFrente.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/arrow_right.png")));
		btnFrente.setForeground(Color.WHITE);
		btnFrente.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFrente.setBackground(Color.CYAN);

		JButton btnTras = new JButton("");
		btnTras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO botao navegar para tras
				String idatual = TFid.getText();
				int soma = Integer.parseInt(idatual);
				if (soma == -1) {
					soma = 1;
				}
				soma = soma - 1;
				int id = 0;
				id = id + soma;
				MesaDao consultaid = new MesaDao();
				try {
					List<Mesa> mesa = consultaid.consultaid(id);
					if (mesa.isEmpty()) {
						String idex = Integer.toString(id);
						TFid.setText(idex);
						TFNome.setText("");
					} else {
						for (Mesa m : mesa) {
							String retornoid = Integer.toString(m.getIdMesa());
							TFid.setText(retornoid);
							TFNome.setText(m.getNomeMesa());
						}
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "\nOcorreu um erro, verificar o ID !", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnTras.setIcon(new ImageIcon(PedidoMesa.class.getResource("/img/arrow_left.png")));
		btnTras.setForeground(Color.WHITE);
		btnTras.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTras.setBackground(Color.CYAN);
		GroupLayout gl_panel_botoes_crud = new GroupLayout(panel_botoes_crud);
		gl_panel_botoes_crud.setHorizontalGroup(gl_panel_botoes_crud.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_botoes_crud.createSequentialGroup().addContainerGap()
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addGap(28).addComponent(btnTras, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnFrente, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnApagar, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel_botoes_crud.setVerticalGroup(gl_panel_botoes_crud.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_botoes_crud.createSequentialGroup().addContainerGap().addGroup(gl_panel_botoes_crud
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_botoes_crud.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnFrente, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTras, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnApagar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)).addContainerGap()));
		panel_botoes_crud.setLayout(gl_panel_botoes_crud);

		JLabel lblNewLabel = new JLabel("CADASTRO DE MESAS");
		lblNewLabel.setForeground(new Color(34, 139, 34));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_header = new GroupLayout(panel_header);
		gl_panel_header.setHorizontalGroup(gl_panel_header.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_header.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE).addContainerGap()));
		gl_panel_header.setVerticalGroup(gl_panel_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_header.createSequentialGroup().addGap(5)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE).addContainerGap()));
		panel_header.setLayout(gl_panel_header);
		contentPane.setLayout(gl_contentPane);
	}

	public void SetMainDashboard(MainDashboard p) {
		main = p;
	}

	public MainDashboard GetMainDashboard() {
		return main;
	}
}

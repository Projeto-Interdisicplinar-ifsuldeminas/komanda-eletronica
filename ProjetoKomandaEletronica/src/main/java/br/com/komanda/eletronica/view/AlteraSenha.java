package br.com.komanda.eletronica.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class AlteraSenha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private static MainDashboard main = null;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	
	/**
	 * Create the frame.
	 */
	public AlteraSenha() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlteraSenha.class.getResource("/img/Key.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 628, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblNewLabel = new JLabel("   ALTERAR SENHA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 605, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 59, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Senha Antiga", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		passwordField = new JPasswordField();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 581, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 63, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nova Senha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		passwordField_1 = new JPasswordField();
		GroupLayout gl_panel_3_1 = new GroupLayout(panel_3_1);
		gl_panel_3_1.setHorizontalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 581, Short.MAX_VALUE)
				.addGroup(gl_panel_3_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3_1.setVerticalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 63, Short.MAX_VALUE)
				.addGroup(gl_panel_3_1.createSequentialGroup()
					.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3_1.setLayout(gl_panel_3_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Repita Nova Senha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		passwordField_2 = new JPasswordField();
		GroupLayout gl_panel_3_2 = new GroupLayout(panel_3_2);
		gl_panel_3_2.setHorizontalGroup(
			gl_panel_3_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 581, Short.MAX_VALUE)
				.addGroup(gl_panel_3_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(passwordField_2, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3_2.setVerticalGroup(
			gl_panel_3_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 63, Short.MAX_VALUE)
				.addGroup(gl_panel_3_2.createSequentialGroup()
					.addComponent(passwordField_2, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3_2.setLayout(gl_panel_3_2);
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 605, Short.MAX_VALUE)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
						.addComponent(panel_3_1, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
						.addComponent(panel_3_2, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 231, Short.MAX_VALUE)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton btnAtualizar = new JButton("   ATUALIZAR");
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtualizar.setBackground(Color.BLUE);
		
		JButton btnNewButton = new JButton("   CANCELAR");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(Color.RED);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 605, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(271, Short.MAX_VALUE)
					.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}


	public static MainDashboard getMain() {
		return main;
	}


	public static void setMain(MainDashboard main) {
		AlteraSenha.main = main;
	}
	
	
}

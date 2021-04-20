package br.com.komanda.eletronica.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.InputMismatchException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class CadastroFuncionarios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private static MainDashboard main = null;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public CadastroFuncionarios() throws ParseException {
		
		setUndecorated(true);
		setTitle("CADASTRO DE FUNCION\u00C1RIOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroFuncionarios.class.getResource("/img/user_edit.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
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
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_5_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(2)
							.addComponent(panel_5_1, GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_5_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_5_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_6, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_4, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5_2_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5_1_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		GroupLayout gl_panel_5_1_1 = new GroupLayout(panel_5_1_1);
		gl_panel_5_1_1.setHorizontalGroup(
			gl_panel_5_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5_1_1.setVerticalGroup(
			gl_panel_5_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_1_1.createSequentialGroup()
					.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5_1_1.setLayout(gl_panel_5_1_1);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		formattedTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_5_2_1 = new GroupLayout(panel_5_2_1);
		gl_panel_5_2_1.setHorizontalGroup(
			gl_panel_5_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_2_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(formattedTextField_1, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5_2_1.setVerticalGroup(
			gl_panel_5_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_2_1.createSequentialGroup()
					.addComponent(formattedTextField_1, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5_2_1.setLayout(gl_panel_5_2_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_5_2 = new GroupLayout(panel_5_2);
		gl_panel_5_2.setHorizontalGroup(
			gl_panel_5_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(formattedTextField, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5_2.setVerticalGroup(
			gl_panel_5_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_2.createSequentialGroup()
					.addComponent(formattedTextField, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5_2.setLayout(gl_panel_5_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		GroupLayout gl_panel_5_1 = new GroupLayout(panel_5_1);
		gl_panel_5_1.setHorizontalGroup(
			gl_panel_5_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5_1.setVerticalGroup(
			gl_panel_5_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5_1.createSequentialGroup()
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_5_1.setLayout(gl_panel_5_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
					.addGap(12))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, 0, 479, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		JRadioButton RBSim = new JRadioButton("SIM");
		RBSim.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JRadioButton RBNao = new JRadioButton("N\u00C3O");
		RBNao.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		
		JButton btnNewButton = new JButton("   FECHAR");
		btnNewButton.setIcon(new ImageIcon(CadastroFuncionarios.class.getResource("/img/cancel.png")));
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
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(0, 128, 0));
		btnSalvar.setIcon(new ImageIcon(CadastroFuncionarios.class.getResource("/img/user_add.png")));
		
		JButton btnApagar = new JButton("   APAGAR");
		btnApagar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnApagar.setBackground(Color.RED);
		btnApagar.setForeground(Color.WHITE);
		btnApagar.setIcon(new ImageIcon(CadastroFuncionarios.class.getResource("/img/user_delete.png")));
		
		JButton btnEditar = new JButton("   EDITAR");
		btnEditar.setIcon(new ImageIcon(CadastroFuncionarios.class.getResource("/img/user_edit.png")));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(Color.BLUE);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE FUNCION\u00C1RIOS");
		lblNewLabel.setForeground(new Color(34, 139, 34));
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
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
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
}

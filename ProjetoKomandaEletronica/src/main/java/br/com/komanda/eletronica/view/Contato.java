package br.com.komanda.eletronica.view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Contato extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contato frame = new Contato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Contato() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Contato.class.getResource("/img/feed.png")));
		setTitle("SISTEMA DE KOMANDA ELETR\u00D4NICA- Contato");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 468, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trabalho Realizado: \r\n");
		lblNewLabel.setBounds(10, 11, 322, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Versao: 0.1");
		lblNewLabel_2.setBounds(23, 145, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Clique e Assista ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//TODO Adicionar link explicando o trabalho
					URI link = new URI("https://www.youtube.com/");
					Desktop.getDesktop().browse(link);
				} catch (Exception erro) {
					System.out.println(erro);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(Contato.class.getResource("/img/bullet_error.png")));
		btnNewButton.setBounds(165, 136, 187, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblDaniloLipariniMoraes = new JLabel(" \r\nDanilo Liparini Moraes RA:201924410096");
		lblDaniloLipariniMoraes.setBounds(10, 39, 322, 21);
		contentPane.add(lblDaniloLipariniMoraes);
		
		JLabel lblLucianoLuizRomero = new JLabel(" Luciano Luiz Romero RA:201924410106");
		lblLucianoLuizRomero.setBounds(10, 71, 322, 21);
		contentPane.add(lblLucianoLuizRomero);
		
		JLabel lblDaniloLipariniMoraes_1_1 = new JLabel("Mateus Botelho Ribeiro RA:201924410271");
		lblDaniloLipariniMoraes_1_1.setBounds(10, 103, 322, 21);
		contentPane.add(lblDaniloLipariniMoraes_1_1);
	}
}

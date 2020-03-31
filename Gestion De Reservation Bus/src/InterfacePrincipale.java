import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class InterfacePrincipale extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePrincipale frame = new InterfacePrincipale();
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
	public InterfacePrincipale() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 422);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 32, 751, 52);
		contentPane.add(panel);
		
		Label label = new Label("Gestion Des R\u00E9servations De Tickets");
		label.setFont(new Font("Tahoma", Font.BOLD, 28));
		label.setAlignment(Label.CENTER);
		panel.add(label);
		
		Button button = new Button("Cliquez ici, pour vous identifer");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Identification id = new Identification();
				setLocationRelativeTo(null);
				id.setVisible(true);
			}
			
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(374, 142, 253, 52);
		contentPane.add(button);
		
		Button button_1 = new Button("Cliquez ici, pour vous identifier");
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Administration admin = new Administration();
				admin.setLocationRelativeTo(null);
				admin.setVisible(true);
			}
			
		});
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(374, 216, 253, 52);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("Si vous etes un client");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(136, 153, 197, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblSiVousEtes = new JLabel("Si vous etes un Administrateur");
		lblSiVousEtes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSiVousEtes.setBounds(128, 229, 240, 29);
		contentPane.add(lblSiVousEtes);
	}
}

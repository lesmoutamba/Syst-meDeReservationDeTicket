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
		
		Label label = new Label("RESERVATION DES TICKETS DE BUS");
		label.setFont(new Font("Tahoma", Font.BOLD, 28));
		label.setAlignment(Label.CENTER);
		panel.add(label);
		
		Button button = new Button("Identifiez-vous");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Identification id = new Identification();
				setLocationRelativeTo(null);
				id.setVisible(true);
			}
			
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(131, 153, 156, 36);
		contentPane.add(button);
		
		Button button_1 = new Button("Administrateur");
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Administration admin = new Administration();
				admin.setLocationRelativeTo(null);
				admin.setVisible(true);
			}
			
		});
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBounds(485, 153, 156, 36);
		contentPane.add(button_1);
	}
}

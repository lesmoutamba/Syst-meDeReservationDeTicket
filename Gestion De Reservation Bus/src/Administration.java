import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Administration extends JFrame {

	private JPanel contentPane;
	private JTextField adminpseudoTF;
	private JPasswordField motdepasseadminTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administration frame = new Administration();
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
	
	public void clearFieldValue() {
		adminpseudoTF.setText("");
		motdepasseadminTF.setText("");	
	}
	
	public Administration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 379);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(5, 5, 198, 324);
		contentPane.add(panel);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPseudo.setBounds(277, 69, 102, 22);
		contentPane.add(lblPseudo);
		
		JLabel label_1 = new JLabel("Mot de passe");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(277, 116, 102, 22);
		contentPane.add(label_1);
		
		adminpseudoTF = new JTextField();
		adminpseudoTF.setColumns(10);
		adminpseudoTF.setBounds(389, 69, 220, 22);
		contentPane.add(adminpseudoTF);
		
		Label label_2 = new Label("ADMINISTRATEUR");
		label_2.setAlignment(Label.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(389, 10, 220, 22);
		contentPane.add(label_2);
		
		JButton button = new JButton("Je valide");
		button.addActionListener(new ActionListener() {
			
			public void infoMessage(String message , String titre) {
				JOptionPane.showMessageDialog(null, message, titre, JOptionPane.INFORMATION_MESSAGE);
			}
			
			public void actionPerformed(ActionEvent arg0) {
				

				String pseudo = adminpseudoTF.getText();
				String motdepasse = motdepasseadminTF.getText();
				
				
try {
					
					Class.forName("com.mysql.jdbc.Driver");
				    String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
					
					Connection con = DriverManager.getConnection(databaseURL, "root", "");
					
					String selectQuery = "select * from details_admin where adminpseudo = '"+pseudo+"' and motdepasseadmin = '"+motdepasse+"'";
					Statement stat = con.createStatement();
					ResultSet rs=stat.executeQuery(selectQuery);
		            if(rs.next()){

		            // infoMessage("Parfait.....", "Bienvenue à vous!!!!!");
		             dispose();
		             
		            AccueilAdmin accueiladmin = new AccueilAdmin(pseudo);
		            accueiladmin.setLocationRelativeTo(null);
		            accueiladmin.setVisible(true);
		             
		            }
		            
		            else
		            {
		                  infoMessage("Ce compte n'existe pas !", " Vérifiez vos identifiants");
		                  
		            }
					
				}
				
				catch (Exception excep){
					
					System.out.println(excep);
				}
			}
		});
		
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(389, 180, 92, 36);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Actualiser");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clearFieldValue();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(517, 180, 92, 36);
		contentPane.add(button_1);
		
		JButton btnUtilisateur = new JButton("Utilisateur");
		btnUtilisateur.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				Identification id = new Identification();
				id.setLocationRelativeTo(null);
				id.setVisible(true);
			}
			
		});
		btnUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUtilisateur.setBounds(389, 237, 220, 36);
		contentPane.add(btnUtilisateur);
		
		motdepasseadminTF = new JPasswordField();
		motdepasseadminTF.setBounds(389, 118, 220, 22);
		contentPane.add(motdepasseadminTF);
	}
}

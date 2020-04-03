import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Identification extends JFrame {

	private JPanel contentPane;
	private JTextField pseudoTF;
	private JPasswordField motdepassePF;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Identification frame = new Identification();
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
	
	public void actualiser() {
		pseudoTF.setText("");
		motdepassePF.setText("");
	}
	
	
	public void infoMessage(String message , String titre) {
		JOptionPane.showMessageDialog(null, message, titre, JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	
	public Identification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 395);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(5, 5, 178, 340);
		contentPane.add(panel);
		
		Label label = new Label("IDENTIFICATION");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(378, 10, 220, 22);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Pseudo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(266, 63, 102, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMotDePasse.setBounds(265, 114, 102, 22);
		contentPane.add(lblMotDePasse);
		
		pseudoTF = new JTextField();
		pseudoTF.setBounds(378, 63, 220, 22);
		contentPane.add(pseudoTF);
		pseudoTF.setColumns(10);
		
		JButton btnNewButton = new JButton("Je valide");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				String pseudo = pseudoTF.getText();
				String motdepasse = motdepassePF.getText();
				
				
                try {
					
					Class.forName("com.mysql.jdbc.Driver");
				    String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
					
					Connection con = DriverManager.getConnection(databaseURL, "root", "");
					
					String selectQuery = "select * from details_utilisateurs where pseudo = '"+pseudo+"' and motdepasse = '"+motdepasse+"'";
					Statement stat = con.createStatement();
					ResultSet rs=stat.executeQuery(selectQuery);
		            if(rs.next()){

		             infoMessage("Parfait.....", "Bienvenue à vous!!!!!");
		             dispose();
		             
		            AccueilUtilisateur accueilutilisateur = new AccueilUtilisateur(pseudo);
		            accueilutilisateur.setLocationRelativeTo(null);
		            accueilutilisateur.setVisible(true);
		             
		            }
		            
		            else
		            {
		                  infoMessage("Ce compte n'existe pas ! Creez un nouveau", " Desolé !!!!!");
		                  dispose();
		                  Enregistrement enregistre=new Enregistrement();
		                  enregistre.setLocationRelativeTo(null);
		                  enregistre.setVisible(true);
		                  
		            }
					
				}
				
				catch (Exception excep){
					
					System.out.println(excep);
				}
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(378, 167, 92, 36);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Actualiser");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualiser();
				
			}
		});
		
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(506, 167, 92, 36);
		contentPane.add(btnReset);
		
		JButton btnCreerUnCompte = new JButton("Cr\u00E9er un compte");
		btnCreerUnCompte.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Enregistrement enregistre = new Enregistrement();
				enregistre.setLocationRelativeTo(null);
				enregistre.setVisible(true);  
			}
			
			
			
		});
		btnCreerUnCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreerUnCompte.setBounds(378, 230, 220, 36);
		contentPane.add(btnCreerUnCompte);
		
		JButton btnAdministrateurs = new JButton("Administrateur");
		btnAdministrateurs.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Administration admin = new Administration();
				admin.setLocationRelativeTo(null);
				admin.setVisible(true);
			}
			
		});
		btnAdministrateurs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdministrateurs.setBounds(379, 283, 219, 36);
		contentPane.add(btnAdministrateurs);
		
		motdepassePF = new JPasswordField();
		motdepassePF.setBounds(378, 113, 220, 22);
		contentPane.add(motdepassePF);
	}
}

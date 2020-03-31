import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Enregistrement extends JFrame {

	private JPanel contentPane;
	private JTextField nomTF;
	private JTextField pseudoTF;
	private JTextField prenomTF;
	private JPasswordField motdepassePF;
	private JTextField emailTF;
	private JTextField telephoneTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enregistrement frame = new Enregistrement();
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
	public Enregistrement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENREGISTREZ VOUS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(156, 11, 509, 30);
		contentPane.add(lblNewLabel);
		
		nomTF = new JTextField();
		nomTF.setColumns(10);
		nomTF.setBounds(156, 59, 174, 22);
		contentPane.add(nomTF);
		
		pseudoTF = new JTextField();
		pseudoTF.setColumns(10);
		pseudoTF.setBounds(156, 115, 174, 23);
		contentPane.add(pseudoTF);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPseudo.setBounds(54, 115, 92, 22);
		contentPane.add(lblPseudo);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNom.setBounds(54, 60, 85, 22);
		contentPane.add(lblNom);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			
			public void infoMessage(String message , String titre) {
				JOptionPane.showMessageDialog(null, message, titre, JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			public void actionPerformed(ActionEvent e) {
				
				String nom = nomTF.getText();
				String prenom = prenomTF.getText();
				String pseudo = pseudoTF.getText();
				String motdepasse = motdepassePF.getText();
				String email = emailTF.getText();
				String telephone = telephoneTF.getText();
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
				    String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
					Connection con = DriverManager.getConnection(databaseURL, "root", "");
					Statement stat = con.createStatement();
					
					String selectQuery = "select count(*) from details_utilisateurs where pseudo = '"+pseudo+"' and motdepasse = '"+motdepasse+"' ";
					ResultSet rs = stat.executeQuery(selectQuery);
				    System.out.println(rs.next());
					
					if (rs.next() == true) {
						infoMessage(" Cet utilisateur existe déjà!!!" , "Alert!!");
					}
					else {
						String insertQuery = "insert into details_utilisateurs values('0','"+nom+"' , '"+prenom+"', '"+pseudo+"' , '"+motdepasse+"' , '"+email+"' , '"+telephone+"')";
						stat.executeUpdate(insertQuery);
						infoMessage(" L'utilisateur a ete creé avec succès!!!" , "Alert!!");
						
					    dispose();
					    Identification id = new Identification();
					    id.setLocationRelativeTo(null);
						id.setVisible(true);
							
						
					}
					}
					
				
				catch (Exception excep){
					
					System.out.println(excep);
				}
			}
			
		});
		
		btnEnregistrer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnregistrer.setBounds(156, 226, 174, 36);
		contentPane.add(btnEnregistrer);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualiser.setBounds(491, 226, 174, 36);
		contentPane.add(btnActualiser);
		
		prenomTF = new JTextField();
		prenomTF.setColumns(10);
		prenomTF.setBounds(491, 59, 174, 22);
		contentPane.add(prenomTF);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrenom.setBounds(364, 60, 111, 22);
		contentPane.add(lblPrenom);
		
		JLabel label_3 = new JLabel("Mot de passe");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(364, 115, 111, 22);
		contentPane.add(label_3);
		
		motdepassePF = new JPasswordField();
		motdepassePF.setBounds(491, 114, 174, 22);
		contentPane.add(motdepassePF);
		
		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(156, 167, 174, 22);
		contentPane.add(emailTF);
		
		JLabel lblUrl = new JLabel("Telephone");
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUrl.setBounds(364, 168, 111, 22);
		contentPane.add(lblUrl);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(54, 168, 92, 22);
		contentPane.add(lblEmail);
		
		JButton btnIdentificationTF = new JButton("Avez vous d\u00E9j\u00E0 un compte ? Identifiez-vous");
		btnIdentificationTF.setBackground(Color.ORANGE);
		btnIdentificationTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIdentificationTF.setBounds(156, 282, 509, 36);
		contentPane.add(btnIdentificationTF);
		
		telephoneTF = new JTextField();
		telephoneTF.setColumns(10);
		telephoneTF.setBounds(491, 167, 174, 22);
		contentPane.add(telephoneTF);
	}
}

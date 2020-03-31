import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AjouterConducteur extends JInternalFrame {
	private JTextField emailConducteurTF;
	private JTextField nomConducteurTF;
	private JTextField telephoneConducteurTF;
	private JTextField prenomConducteurTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterConducteur frame = new AjouterConducteur();
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
	
	public void infoMessage(String message , String titre) {
		JOptionPane.showMessageDialog(null, message, titre, JOptionPane.INFORMATION_MESSAGE);
		
	}
	public AjouterConducteur() {
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(1, 1, 983, 388);
		getContentPane().setLayout(null);
		
		emailConducteurTF = new JTextField();
		emailConducteurTF.setColumns(10);
		emailConducteurTF.setBounds(221, 158, 172, 20);
		getContentPane().add(emailConducteurTF);
		
		nomConducteurTF = new JTextField();
		nomConducteurTF.setColumns(10);
		nomConducteurTF.setBounds(221, 112, 172, 20);
		getContentPane().add(nomConducteurTF);
		
		telephoneConducteurTF = new JTextField();
		telephoneConducteurTF.setColumns(10);
		telephoneConducteurTF.setBounds(534, 157, 172, 20);
		getContentPane().add(telephoneConducteurTF);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone");
		lblTlphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTlphone.setBounds(435, 155, 89, 22);
		getContentPane().add(lblTlphone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(122, 155, 89, 22);
		getContentPane().add(lblEmail);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNom.setBounds(122, 109, 89, 22);
		getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrenom.setBounds(435, 110, 89, 22);
		getContentPane().add(lblPrenom);
		
		prenomConducteurTF = new JTextField();
		prenomConducteurTF.setColumns(10);
		prenomConducteurTF.setBounds(534, 112, 172, 20);
		getContentPane().add(prenomConducteurTF);
		
		JLabel lblAjouteurUnNouveau = new JLabel("Ajouteur un nouveau conducteur");
		lblAjouteurUnNouveau.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouteurUnNouveau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAjouteurUnNouveau.setBounds(10, 29, 853, 22);
		getContentPane().add(lblAjouteurUnNouveau);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			
			public void clearFieldValue() {
				nomConducteurTF.setText("");
				prenomConducteurTF.setText("");
				emailConducteurTF.setText("");
				telephoneConducteurTF.setText("");
				
			}
			
			public void actionPerformed(ActionEvent e) {
				
				String nomconducteur = nomConducteurTF.getText();
				String prenomconducteur = prenomConducteurTF.getText();
				String emailconducteur = emailConducteurTF.getText();
				String telephoneconducteur = telephoneConducteurTF.getText();
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
				    String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
					Connection con = DriverManager.getConnection(databaseURL, "root", "");
					Statement stat = con.createStatement();
					
					String selectQuery = "select count(*) from details_conducteurs where nom = '"+nomconducteur+"' and prenom = '"+prenomconducteur+"' ";
					ResultSet rs = stat.executeQuery(selectQuery);
				    System.out.println(rs.next());
					
					if (rs.next() == true) {
						infoMessage(" Ce conducteur existe déjà!!!" , "Alert!!");
						
						clearFieldValue();
					}
					else {
						String insertQuery = "insert into details_conducteurs values('0','"+nomconducteur+"' , '"+prenomconducteur+"', '"+emailconducteur+"' , '"+telephoneconducteur+"')";
						stat.executeUpdate(insertQuery);
						infoMessage(" Le conducteur a ete ajouté avec succès!!!" , "Alert!!");
						clearFieldValue();
						
					}
					
				}
				catch (Exception ex){
					System.out.println(ex);
				}
			}
		});
		
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAjouter.setBounds(222, 241, 172, 23);
		getContentPane().add(btnAjouter);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualiser.setBounds(534, 241, 172, 23);
		getContentPane().add(btnActualiser);

	}
}

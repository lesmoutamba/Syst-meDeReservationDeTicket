import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;

import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;


public class AjoutBus extends JInternalFrame {
	private JTextField busnoTF;
	private JTextField busdepartTF;
	private JTextField busdestinationTF;
	private JTextField siegeTF;
	private JTextField horaireTF;
	private JTextField prixTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutBus frame = new AjoutBus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	static JDateChooser datedepartTF;
	static JComboBox comboBoxTF;
	
	
	public void infoMessage(String message , String titre) {
		JOptionPane.showMessageDialog(null, message, titre, JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	
	public void actualiser() {
		busnoTF.setText("");
		busdepartTF.setText("");
		busdestinationTF.setText("");
		horaireTF.setText("");
		prixTF.setText("");
		siegeTF.setText("");	
	}

	/**
	 * Create the frame.
	 */
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AjoutBus() {
		setTitle("Ajouter Bus");
		setVisible(true);
		setClosable(true);
		setResizable(true);
		setBounds(1, 1, 983, 380);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter les informations du Bus");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(180, 11, 485, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("No. Bus");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(81, 76, 89, 22);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblDpart = new JLabel("D\u00E9part");
		lblDpart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDpart.setBounds(394, 122, 89, 22);
		getContentPane().add(lblDpart);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDestination.setBounds(81, 122, 89, 22);
		getContentPane().add(lblDestination);
		
		busnoTF = new JTextField();
		busnoTF.setBounds(180, 79, 172, 20);
		getContentPane().add(busnoTF);
		busnoTF.setColumns(10);
		
		busdepartTF = new JTextField();
		busdepartTF.setColumns(10);
		busdepartTF.setBounds(493, 124, 172, 20);
		getContentPane().add(busdepartTF);
		
		JButton btnNewButton = new JButton("Entrer");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			

			
			public void actionPerformed(ActionEvent arg0) {
				
				String busno = busnoTF.getText();
				String busdepart = busdepartTF.getText();
				String busdestination = busdestinationTF.getText();
				
				java.util.Date datedepart = datedepartTF.getDate();
	            SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            String datedepartD = oDateFormat.format(datedepart);
				
				String bagage =(String)comboBoxTF.getSelectedItem();
				String heure = horaireTF.getText();
				String prix = prixTF.getText();
				String nbre_siege = siegeTF.getText();
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
				    String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
					Connection con = DriverManager.getConnection(databaseURL, "root", "");
					Statement stat = con.createStatement();
					
					String selectQuery = "select count(*) from details_bus where bus_no = '"+busno+"' and bus_depart = '"+busdepart+"' ";
					ResultSet rs = stat.executeQuery(selectQuery);
				    System.out.println(rs.next());
					
					if (rs.next() == true) {
						infoMessage(" Ce details existe déjà!!!" , "Alert!!");
						
						actualiser();
					}
					else {
						String insertQuery = "insert into details_bus values('0','"+busno+"' , '"+busdepart+"', '"+busdestination+"' , '"+datedepartD+"' , '"+bagage+"' , '"+heure+"' , '"+prix+"' , '"+nbre_siege+"')";
						stat.executeUpdate(insertQuery);
						infoMessage(" Le détails a ete creé avec succès!!!" , "Alert!!");
						
						actualiser();
						
					}
					
				}
				catch (Exception e){
					System.out.println(e);
				}
			}
		});
		
		btnNewButton.setBounds(180, 279, 172, 23);
		getContentPane().add(btnNewButton);
		
		busdestinationTF = new JTextField();
		busdestinationTF.setBounds(180, 125, 172, 20);
		getContentPane().add(busdestinationTF);
		busdestinationTF.setColumns(10);
		
		siegeTF = new JTextField();
		siegeTF.setColumns(10);
		siegeTF.setBounds(493, 225, 172, 20);
		getContentPane().add(siegeTF);
		
		horaireTF = new JTextField();
		horaireTF.setColumns(10);
		horaireTF.setBounds(493, 177, 172, 20);
		getContentPane().add(horaireTF);
		
		JLabel lblPrix = new JLabel("Date");
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrix.setBounds(81, 174, 89, 22);
		getContentPane().add(lblPrix);
		
		JLabel lblBagage = new JLabel("Bagage (kg)");
		lblBagage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBagage.setBounds(394, 76, 89, 22);
		getContentPane().add(lblBagage);
		
		JLabel lblHoraire = new JLabel("Heure");
		lblHoraire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoraire.setBounds(394, 174, 89, 22);
		getContentPane().add(lblHoraire);
		
		JLabel lblSiege = new JLabel("Nbre de Si\u00E8ge");
		lblSiege.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiege.setBounds(394, 223, 89, 22);
		getContentPane().add(lblSiege);
		
		prixTF = new JTextField();
		prixTF.setColumns(10);
		prixTF.setBounds(180, 225, 172, 20);
		getContentPane().add(prixTF);
		
		JLabel lblPrix_1 = new JLabel("Prix");
		lblPrix_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrix_1.setBounds(81, 223, 89, 22);
		getContentPane().add(lblPrix_1);
		
		comboBoxTF = new JComboBox();
		comboBoxTF.setModel(new DefaultComboBoxModel(new String[] {"10 Kg", "15 Kg", "20 Kg", "25 Kg"}));
		comboBoxTF.setBounds(493, 79, 172, 20);
		getContentPane().add(comboBoxTF);
		
		datedepartTF = new JDateChooser();
		datedepartTF.setBounds(180, 177, 172, 20);
		getContentPane().add(datedepartTF);

	}
}

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssignerConducteur extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignerConducteur frame = new AssignerConducteur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	static JComboBox comboBox1;
	static JComboBox comboBox2;
	
	
	
	 public void infoMessage(String message, String tittle) {
	      JOptionPane.showMessageDialog(null, message, tittle, JOptionPane.INFORMATION_MESSAGE);
	   }
	   
	
	public void conducteursInfo() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		    String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
			Connection con = DriverManager.getConnection(databaseURL, "root", "");
			Statement stat = con.createStatement();
			
			String selectQuery = "select nom from details_conducteurs";
			ResultSet rs = stat.executeQuery(selectQuery);
			while(rs.next()) {
				comboBox1.addItem(rs.getString("nom"));
			}
			
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
  public void busNoConducteur() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		    String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
			Connection con = DriverManager.getConnection(databaseURL, "root", "");
			Statement stat = con.createStatement();
			
			String selectQuery = "select bus_no from details_bus";
			ResultSet rs = stat.executeQuery(selectQuery);
			while(rs.next()) {
				comboBox2.addItem(rs.getString("bus_no"));
			}
			
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}
  
   
	/**
	 * Create the frame.
	 */
	public AssignerConducteur() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(1, 1, 983, 368);
		getContentPane().setLayout(null);
		
		
		JLabel lblConducteurs = new JLabel("Conducteurs");
		lblConducteurs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConducteurs.setBounds(92, 90, 89, 22);
		getContentPane().add(lblConducteurs);
		
		comboBox1 = new JComboBox();
		comboBox1.setBounds(191, 93, 172, 20);
		getContentPane().add(comboBox1);
		
		JLabel label_1 = new JLabel("Ajouter les informations du Bus");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(10, 11, 747, 22);
		getContentPane().add(label_1);
		
		JLabel lblBusNo = new JLabel("Bus No.");
		lblBusNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBusNo.setBounds(411, 91, 89, 22);
		getContentPane().add(lblBusNo);
		
		comboBox2 = new JComboBox();
		comboBox2.setBounds(510, 94, 172, 20);
		getContentPane().add(comboBox2);
		
		
		JButton btnAssigner = new JButton("Assigner");
		btnAssigner.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				 String nom_conducteur =(String)comboBox1.getSelectedItem();
			     String busno =(String)comboBox2.getSelectedItem();
			        
			        try{
			            Class.forName("com.mysql.jdbc.Driver");
			            String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
			            Connection con = DriverManager.getConnection(databaseURL, "root", "");
			            Statement stat = con.createStatement(); 
			            
			            String selectQuery="select bus_no from assigner_conducteur where bus_no ='"+busno+"' and nom_conducteur ='"+nom_conducteur+"'";
			            ResultSet rs=stat.executeQuery(selectQuery);
			            if(rs.next())
			            {
			                infoMessage("Ce bus est déjà été assigné", "Choisissez un autre!!");
			            }
			            else
			            {
			                String insertQuery="insert into assigner_conducteur values(null,'"+nom_conducteur+"','"+busno+"')";
			                int i=stat.executeUpdate(insertQuery);
			                if(i==1)
			                {
			                     infoMessage("Parfait, le Bus a été assigné au conducteur", "Assigner un autre !!");
			                }
			                  
			            }
			        
			        }
			        catch(Exception ex){
			            System.out.println(ex);
			        }
			}
		});
		
		btnAssigner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAssigner.setBounds(191, 178, 172, 23);
		getContentPane().add(btnAssigner);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualiser.setBounds(510, 178, 172, 23);
		getContentPane().add(btnActualiser);

		conducteursInfo();
		busNoConducteur();
	}
}

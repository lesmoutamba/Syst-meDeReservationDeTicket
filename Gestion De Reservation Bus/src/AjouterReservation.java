import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

public class AjouterReservation extends JInternalFrame {
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterReservation frame = new AjouterReservation();
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
	 static JFrame BookingFormFrame;
     static JPanel BookingFormPanel;
     static GridLayout gl;
     
	static JDateChooser dateChooser1;
	static JDateChooser dateChooser2;
	
	static JComboBox comboBox1;
	static JComboBox comboBox2;
	
	public void departInfo() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		    String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
			Connection con = DriverManager.getConnection(databaseURL, "root", "");
			Statement stat = con.createStatement();
			
			String selectQuery = "select bus_depart from details_bus";
			ResultSet rs = stat.executeQuery(selectQuery);
			while(rs.next()) {
				comboBox2.addItem(rs.getString("bus_depart"));
			}
			
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
public void destinationInfo() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		    String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
			Connection con = DriverManager.getConnection(databaseURL, "root", "");
			Statement stat = con.createStatement();
			
			String selectQuery = "select bus_destination from details_bus";
			ResultSet rs = stat.executeQuery(selectQuery);
			while(rs.next()) {
				comboBox1.addItem(rs.getString("bus_destination"));
			}
			
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}


String pseudoUtilisateur;
public AjouterReservation(String pseudoUtil) {
	
	setResizable(true);
	setClosable(true);
	setMaximizable(true);
	setIconifiable(true);
	setBounds(1, 1, 983, 417);
	getContentPane().setLayout(null);
	
	JButton btnRechercher = new JButton("Rechercher");
	btnRechercher.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			
			String busdepart =(String)comboBox2.getSelectedItem();
			String busdestination = (String)comboBox1.getSelectedItem();
			
			java.util.Date dedate = dateChooser1.getDate();
			java.util.Date adate = dateChooser2.getDate();
			
            SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dedateD = oDateFormat.format(dedate);
            String adateD = oDateFormat.format(adate);
			
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
			    String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
				Connection con = DriverManager.getConnection(databaseURL, "root", "");
				Statement stat = con.createStatement();
				String selectQuery = "select * from details_bus where bus_depart='"+busdepart+"' and bus_destination='"+busdestination+"' and datedepart between '"+dedateD+"' and '"+adateD+"'";
				
				PreparedStatement pst = con.prepareStatement(selectQuery);		
				ResultSet rs = pst.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
			}
			catch (Exception e){
				
				System.out.println(e);
				
			}
		}
	});
	
	btnRechercher.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnRechercher.setBounds(330, 132, 119, 23);
	getContentPane().add(btnRechercher);
	
	comboBox1 = new JComboBox();
	comboBox1.setBounds(330, 67, 119, 20);
	getContentPane().add(comboBox1);
	
	JLabel lblDestination = new JLabel("Destination");
	lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblDestination.setBounds(242, 64, 78, 22);
	getContentPane().add(lblDestination);
	
	comboBox2 = new JComboBox();
	comboBox2.setBounds(84, 67, 119, 20);
	getContentPane().add(comboBox2);
	
	JLabel lblDpart = new JLabel("D\u00E9part");
	lblDpart.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblDpart.setBounds(21, 65, 51, 22);
	getContentPane().add(lblDpart);
	
	JLabel lblReservations = new JLabel("Reservations");
	lblReservations.setHorizontalAlignment(SwingConstants.CENTER);
	lblReservations.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblReservations.setBounds(10, 11, 947, 22);
	getContentPane().add(lblReservations);
	
	JLabel lblDate = new JLabel("De date");
	lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblDate.setBounds(21, 99, 51, 22);
	getContentPane().add(lblDate);
	
	JLabel lblRsultatDeLa = new JLabel("R\u00E9sultat de la recherche ...");
	lblRsultatDeLa.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblRsultatDeLa.setBounds(21, 132, 354, 22);
	getContentPane().add(lblRsultatDeLa);
	
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.addMouseListener(new MouseAdapter() {
		
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			int index = table.getSelectedRow();
			TableModel model = table.getModel();
			
			String busno = (String) model.getValueAt(index, 1);
	        String busdepart = (String) model.getValueAt(index, 2);
	        String busdestination = (String) model.getValueAt(index, 3);
	        String datedepart= (String) model.getValueAt(index, 4);
	        String bagage = model.getValueAt(index, 5).toString();  
	        String heure = (String) model.getValueAt(index, 6);
	        String prix = (String) model.getValueAt(index, 7);
	        String siege_dispo =(String) model.getValueAt(index, 8);
	        
	       BookingFormFrame = new JFrame();
	       BookingFormPanel = new JPanel();
	       gl = new GridLayout(0,4);
	       
	       JLabel l1=new JLabel("Bus No");
	       JLabel l11=new JLabel(busno);
	       JLabel l2=new JLabel("Bagage(kg)");
	       JLabel l12=new JLabel(bagage);
	       JLabel l3=new JLabel("Départ");
	       JLabel l13=new JLabel(busdepart);
	       JLabel l4=new JLabel("Bus Dest");
	       JLabel l14=new JLabel(busdestination);
	       JLabel l5=new JLabel("Depart Date");
	       JLabel l15=new JLabel(datedepart);
	       JLabel l6=new JLabel("Heure");
	       JLabel l16=new JLabel(heure);
	       JLabel l7=new JLabel("Prix");
	       JLabel l17=new JLabel(prix);
	       JLabel l8=new JLabel("Sièges Disponibles");
	       JLabel l18=new JLabel(siege_dispo);
	       JLabel numsiege =new JLabel("Numéro du siège");
	       JLabel idno=new JLabel("No. Pièce ID");
	       JLabel prenom =new JLabel("Prénom");
	       JLabel nom =new JLabel("Nom");
	       JTextField t1=new JTextField(18);
	       JTextField t2=new JTextField(18);
	       JTextField t3=new JTextField(18);
	       JTextField t4=new JTextField(18);
	       
	       BookingFormFrame.getContentPane().add(BookingFormPanel);
	       BookingFormPanel.setLayout(gl);
	       
	       BookingFormPanel.add(l1);
	       BookingFormPanel.add(l11);
	       BookingFormPanel.add(l2);
	       BookingFormPanel.add(l12);
	       BookingFormPanel.add(l3);
	       BookingFormPanel.add(l13);
	       BookingFormPanel.add(l4);
	       BookingFormPanel.add(l14);
	       BookingFormPanel.add(l5);
	       BookingFormPanel.add(l15);
	       BookingFormPanel.add(l6);
	       BookingFormPanel.add(l16);
	       BookingFormPanel.add(l7);
	       BookingFormPanel.add(l17);
	       BookingFormPanel.add(l8);
	       BookingFormPanel.add(l18);
	        
	       BookingFormPanel.add(numsiege);
	       BookingFormPanel.add(t1);
	       BookingFormPanel.add(idno);
	       BookingFormPanel.add(t2);
	       BookingFormPanel.add(prenom);
	       BookingFormPanel.add(t3);
	       BookingFormPanel.add(nom);
	       BookingFormPanel.add(t4);
	         
	       int result = JOptionPane.showConfirmDialog(BookingFormFrame,BookingFormPanel,"Booking Form",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
	       
	       if(result == JOptionPane.OK_OPTION) {
	    	  
	    	    String utilisateur = pseudoUtilisateur;
	            String numerosiege = t1.getText();
	            String pieceid = t2.getText();
	            String prenom_client = t3.getText();
	            String nom_client = t4.getText();
	       
	            try {
	    	      Class.forName("com.mysql.jdbc.Driver");
			      String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
				  Connection con = DriverManager.getConnection(databaseURL, "root", "");
				  Statement stat = con.createStatement();
				  
				  String selectQuery = "select * from details_reservation where busno ='"+busno+"' and datedepart ='"+datedepart+"' and utilisateur ='"+utilisateur+"' and pieceid ='"+pieceid+"'";
				  
				  System.out.println(selectQuery);
		            ResultSet rs=stat.executeQuery(selectQuery);
		         //   System.out.println(rs.next());
		           if(rs.next()) {
		        	   infoMessage("Déjà réservé", "Alert !!");
		           }
		           
		           else {
		        	   
		        	   String insertQuery = "insert into details_reservation values(null,'" +utilisateur+ "','" +datedepart+ "','" +busno+ "','" +numerosiege+ "','" +pieceid+ "','" +prenom_client+ "','" +nom_client+ "')";
		               
		               int i= stat.executeUpdate(insertQuery);
		               if(i==1) {
		            	   /*int siegerestant =Integer.parseInt(siege_dispo)-Integer.parseInt(numerosiege);*/
		            	   int siegerestant =Integer.parseInt(siege_dispo)-1;
		            	   
		                   String updateQuery="update details_bus set nbre_siege ='"+siegerestant+"' where bus_no='"+busno+"' and bagage ='"+bagage+"' and datedepart ='"+datedepart+"'";
		                   int j=stat.executeUpdate(updateQuery);
		                   
		                   if(j==1) {
		                	   
		                	   String bus_depart = (String)comboBox2.getSelectedItem();
		                       String bus_destination =(String)comboBox1.getSelectedItem();
		                       java.util.Date de_date = dateChooser1.getDate();
		                       java.util.Date a_date = dateChooser2.getDate();
		                       
		                       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		                       String dedateformated = sdf.format(de_date);
		                       String adateformated = sdf.format(a_date);   
		                       
		                       infoMessage("Votre reservation a été enregistrée", "Alert !!");
		                       
		                       String selectQuery1 = "select utilisateur, busno, numerosiege, pieceid, prenom_client, nom_client from details_reservation where utilisateur ='"+utilisateur+"' and datedepart ='"+datedepart+"' and busno ='"+busno+"' and numerosiege ='"+numerosiege+"' and pieceid ='"+pieceid+"' and prenom_client ='"+prenom_client+"' and nom_client ='"+nom_client+"'";
		                       ResultSet rs1=stat.executeQuery(selectQuery1);
		                    
		                       table_1.setModel(DbUtils.resultSetToTableModel(rs1));
		                       table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		                   }
		               }
		           }
		           
	              }
	              catch (Exception ex) {
	            	  
	    	           System.out.println(ex);
	              }
	            
	       }
		}
	});
	
	
	scrollPane.setBounds(23, 165, 448, 191);
	getContentPane().add(scrollPane);
	
	table = new JTable();
	scrollPane.setViewportView(table);
	
	JLabel lblMesReservations = new JLabel("Mes r\u00E9servations ...");
	lblMesReservations.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblMesReservations.setBounds(481, 61, 378, 22);
	getContentPane().add(lblMesReservations);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(481, 88, 476, 268);
	getContentPane().add(scrollPane_1);
	
	table_1 = new JTable();
	scrollPane_1.setViewportView(table_1);
	
	dateChooser1 = new JDateChooser();
	dateChooser1.setBounds(85, 101, 119, 20);
	getContentPane().add(dateChooser1);
	
	JLabel lblADate = new JLabel("A date");
	lblADate.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblADate.setBounds(272, 99, 58, 22);
	getContentPane().add(lblADate);
	
	dateChooser2 = new JDateChooser();
	dateChooser2.setBounds(330, 101, 119, 20);
	getContentPane().add(dateChooser2);
	
	
	this.pseudoUtilisateur = pseudoUtil;
	departInfo();
	destinationInfo();
}

public void infoMessage(String message , String titre) {
	JOptionPane.showMessageDialog(null, message, titre, JOptionPane.INFORMATION_MESSAGE);
	
}

	public AjouterReservation() {
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(1, 1, 851, 417);
		getContentPane().setLayout(null);
		
		/*JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				String busdepart =(String)comboBox2.getSelectedItem();
				String busdestination = (String)comboBox1.getSelectedItem();
				
				java.util.Date dedate = dateChooser1.getDate();
				java.util.Date adate = dateChooser2.getDate();
				
	            SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            String dedateD = oDateFormat.format(dedate);
	            String adateD = oDateFormat.format(adate);
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
				    String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
					Connection con = DriverManager.getConnection(databaseURL, "root", "");
					Statement stat = con.createStatement();
					String selectQuery = "select * from details_bus where bus_depart='"+busdepart+"' and bus_destination='"+busdestination+"' and datedepart between '"+dedateD+"' and '"+adateD+"'";
					
					PreparedStatement pst = con.prepareStatement(selectQuery);		
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					
				}
				catch (Exception e){
					
					System.out.println(e);
					
				}
			}
		});
		
		btnRechercher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRechercher.setBounds(330, 132, 119, 23);
		getContentPane().add(btnRechercher);
		
		comboBox1 = new JComboBox();
		comboBox1.setBounds(330, 67, 119, 20);
		getContentPane().add(comboBox1);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDestination.setBounds(242, 64, 78, 22);
		getContentPane().add(lblDestination);
		
		comboBox2 = new JComboBox();
		comboBox2.setBounds(84, 67, 119, 20);
		getContentPane().add(comboBox2);
		
		JLabel lblDpart = new JLabel("D\u00E9part");
		lblDpart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDpart.setBounds(21, 65, 51, 22);
		getContentPane().add(lblDpart);
		
		JLabel lblReservations = new JLabel("Reservations");
		lblReservations.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservations.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReservations.setBounds(10, 11, 947, 22);
		getContentPane().add(lblReservations);
		
		JLabel lblDate = new JLabel("De date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(21, 99, 51, 22);
		getContentPane().add(lblDate);
		
		JLabel lblRsultatDeLa = new JLabel("R\u00E9sultat de la recherche ...");
		lblRsultatDeLa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRsultatDeLa.setBounds(21, 132, 354, 22);
		getContentPane().add(lblRsultatDeLa);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String busno = (String) model.getValueAt(index, 1);
		        String bagage = (String) model.getValueAt(index, 2);
		        String busdepart = (String) model.getValueAt(index, 3);
		        String busdestination = (String) model.getValueAt(index, 4);
		        String datedepart = model.getValueAt(index, 5).toString();  
		        String heure = (String) model.getValueAt(index, 6);
		        String prix = (String) model.getValueAt(index, 7);
		        String siege_dispo =(String) model.getValueAt(index, 8);
		        
		       BookingFormFrame = new JFrame();
		       BookingFormPanel = new JPanel();
		       gl = new GridLayout(0,4);
		       
		       JLabel l1=new JLabel("Bus No");
		       JLabel l11=new JLabel(busno);
		       JLabel l2=new JLabel("Bagage (kg)");
		       JLabel l12=new JLabel(bagage);
		       JLabel l3=new JLabel("Départ");
		       JLabel l13=new JLabel(busdepart);
		       JLabel l4=new JLabel("Bus Dest");
		       JLabel l14=new JLabel(busdestination);
		       JLabel l5=new JLabel("Depart Date");
		       JLabel l15=new JLabel(datedepart);
		       JLabel l6=new JLabel("Heure");
		       JLabel l16=new JLabel(heure);
		       JLabel l7=new JLabel("Prix");
		       JLabel l17=new JLabel(prix);
		       JLabel l8=new JLabel("Sièges Disponibles");
		       JLabel l18=new JLabel(siege_dispo);
		       JLabel numsiege =new JLabel("Numéro du siège");
		       JLabel idno=new JLabel("No. Pièce ID");
		       JLabel prenom =new JLabel("Prénom");
		       JLabel nom =new JLabel("Nom");
		       JTextField t1=new JTextField(18);
		       JTextField t2=new JTextField(18);
		       JTextField t3=new JTextField(18);
		       JTextField t4=new JTextField(18);
		       
		       BookingFormFrame.getContentPane().add(BookingFormPanel);
		       BookingFormPanel.setLayout(gl);
		       
		       BookingFormPanel.add(l1);
		       BookingFormPanel.add(l11);
		       BookingFormPanel.add(l2);
		       BookingFormPanel.add(l12);
		       BookingFormPanel.add(l3);
		       BookingFormPanel.add(l13);
		       BookingFormPanel.add(l4);
		       BookingFormPanel.add(l14);
		       BookingFormPanel.add(l5);
		       BookingFormPanel.add(l15);
		       BookingFormPanel.add(l6);
		       BookingFormPanel.add(l16);
		       BookingFormPanel.add(l7);
		       BookingFormPanel.add(l17);
		       BookingFormPanel.add(l8);
		       BookingFormPanel.add(l18);
		        
		       BookingFormPanel.add(numsiege);
		       BookingFormPanel.add(t1);
		       BookingFormPanel.add(idno);
		       BookingFormPanel.add(t2);
		       BookingFormPanel.add(prenom);
		       BookingFormPanel.add(t3);
		       BookingFormPanel.add(nom);
		       BookingFormPanel.add(t4);
		         
		       int result = JOptionPane.showConfirmDialog(BookingFormFrame,BookingFormPanel,"Booking Form",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		       
		       if(result == JOptionPane.OK_OPTION) {
		    	  
		    	    String utilisateur = pseudoUtilisateur;
		            String numerosiege = t1.getText();
		            String pieceid = t2.getText();
		            String prenom_client = t3.getText();
		            String nom_client = t4.getText();
		       
		            try {
		    	      Class.forName("com.mysql.jdbc.Driver");
				      String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
					  Connection con = DriverManager.getConnection(databaseURL, "root", "");
					  Statement stat = con.createStatement();
					  
					  String selectQuery = "select * from details_reservation where busno ='"+busno+"' and datedepart ='"+datedepart+"' and utilisateur ='"+utilisateur+"' and pieceid ='"+pieceid+"'";
					  
					  System.out.println(selectQuery);
			            ResultSet rs=stat.executeQuery(selectQuery);
			         //   System.out.println(rs.next());
			           if(rs.next()) {
			        	   infoMessage("Déjà réservé", "Alert !!");
			           }
			           
			           else {
			        	   
			        	   String insertQuery = "insert into details_reservation values(null,'" +utilisateur+ "','" +datedepart+ "','" +busno+ "','" +numerosiege+ "','" +pieceid+ "','" +prenom_client+ "','" +nom_client+ "')";
			               
			               int i= stat.executeUpdate(insertQuery);
			               if(i==1) {
			            	   int siegerestant =Integer.parseInt(siege_dispo)-Integer.parseInt(numerosiege);
			                   
			                   String updateQuery="update details_bus set siege ='"+siegerestant+"' where bus_no='"+busno+"' and bagage ='"+bagage+"' and datedepart ='"+datedepart+"'";
			                   int j=stat.executeUpdate(updateQuery);
			                   
			                   if(j==1) {
			                	   
			                	   String bus_depart = (String)comboBox2.getSelectedItem();
			                       String bus_destination =(String)comboBox1.getSelectedItem();
			                       java.util.Date de_date = dateChooser1.getDate();
			                       java.util.Date a_date = dateChooser2.getDate();
			                       
			                       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			                       String dedateformated = sdf.format(de_date);
			                       String adateformated = sdf.format(a_date);   
			                       
			                       infoMessage("Votre reservation a été enregistrée", "Alert !!");
			                       
			                       String selectQuery1 = "select utilisateur, busno, numerosiege, pieceid, prenom_utilisateur , nom_client from details_reservation where utilisateur ='"+utilisateur+"' and datedepart ='"+datedepart+"' and busno ='"+busno+"' and numerosiege ='"+numerosiege+"' and pieceid ='"+pieceid+"' and prenom_client ='"+prenom_client+"' and nom_client ='"+nom_client+"'";
			                       ResultSet rs1=stat.executeQuery(selectQuery1);
			                    
			                       table_1.setModel(DbUtils.resultSetToTableModel(rs1));
			                       table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			                   }
			               }
			           }
			           
		              }
		              catch (Exception ex) {
		            	  
		    	           System.out.println(ex);
		              }
		            
		       }
			}
		});
		
		
		scrollPane.setBounds(23, 165, 424, 191);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		
		JLabel lblMesReservations = new JLabel("Mes r\u00E9servations ...");
		lblMesReservations.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMesReservations.setBounds(459, 64, 378, 22);
		getContentPane().add(lblMesReservations);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(459, 88, 366, 268);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(85, 101, 119, 20);
		getContentPane().add(dateChooser1);
		
		JLabel lblADate = new JLabel("A date");
		lblADate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblADate.setBounds(272, 99, 58, 22);
		getContentPane().add(lblADate);
		
		dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(330, 101, 119, 20);
		getContentPane().add(dateChooser2);
		
		departInfo();
		destinationInfo();
                           */
	}
}

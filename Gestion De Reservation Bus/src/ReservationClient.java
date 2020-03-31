import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class ReservationClient extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationClient frame = new ReservationClient();
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
	
	String pseudoUtilisateur;
	
	public ReservationClient(String pseudoUtil) {
		
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(1, 1, 802, 354);
		getContentPane().setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Afficher toutes mes reservations");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String utilisateur = pseudoUtilisateur;
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				      String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
					  Connection con = DriverManager.getConnection(databaseURL, "root", "");
					  Statement stat = con.createStatement();
					  
					  String selectQuery1 = "select * from details_reservation where utilisateur ='"+utilisateur+"'";
                      ResultSet rs1=stat.executeQuery(selectQuery1);
                   
                      table.setModel(DbUtils.resultSetToTableModel(rs1));
                     /* table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);*/
					}
					catch (Exception ex){
						System.out.println(ex);
					}
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 11, 227, 31);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 53, 766, 230);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		this.pseudoUtilisateur = pseudoUtil;
		
	}
	
	
	public ReservationClient() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(1, 1, 802, 354);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Afficher toutes mes reservations");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String utilisateur = pseudoUtilisateur;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				      String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
					  Connection con = DriverManager.getConnection(databaseURL, "root", "");
					  Statement stat = con.createStatement();
					  
					  String selectQuery1 = "select * from details_reservation where utilisateur ='"+utilisateur+"'";
                      ResultSet rs1=stat.executeQuery(selectQuery1);
                   
                      table.setModel(DbUtils.resultSetToTableModel(rs1));
                      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					}
					catch (Exception ex){
						System.out.println(ex);
					}
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 11, 227, 31);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 53, 766, 230);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
}

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.*;


public class AffichageDetailsBus extends JInternalFrame {
	
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichageDetailsBus frame = new AffichageDetailsBus();
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
	public AffichageDetailsBus() {
		setClosable(true);
		setTitle("Affichage Details Bus");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(1, 1, 933, 437);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPaneTable.setBounds(10, 45, 773, 373);
		getContentPane().add(scrollPaneTable);
		
		table = new JTable();
		scrollPaneTable.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JButton btnNewButton = new JButton("Afficher");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				Class.forName("com.mysql.jdbc.Driver");
			    String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
				
				Connection con = DriverManager.getConnection(databaseURL, "root", "");
				
				String selectQuery = "select * from details_bus";
				PreparedStatement pst = con.prepareStatement(selectQuery);		
				ResultSet rs = pst.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch (Exception ex){
					System.out.println(ex);
				}
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 11, 114, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(160, 11, 114, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSupprimer.setBounds(300, 11, 114, 23);
		getContentPane().add(btnSupprimer);

	}
}

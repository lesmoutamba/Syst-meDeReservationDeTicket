import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ListeReservations extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeReservations frame = new ListeReservations();
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
	public ListeReservations() {
		setBounds(1, 1, 807, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Afficher toutes les reservations");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				      String databaseURL = "jdbc:mysql://localhost:3308/gestionticket?characterEncoding=latin1";
					  Connection con = DriverManager.getConnection(databaseURL, "root", "");
					  Statement stat = con.createStatement();
					  
					  String selectQuery1 = "select * from details_reservation";
                      ResultSet rs1=stat.executeQuery(selectQuery1);
                   
                      table.setModel(DbUtils.resultSetToTableModel(rs1));
                      /*table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);*/
					}
					catch (Exception ex){
						System.out.println(ex);
					}
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 11, 239, 23);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 771, 214);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
}

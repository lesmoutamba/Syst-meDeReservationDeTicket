import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class AccueilUtilisateur extends JFrame {

	private JPanel contentPane;
	
    
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccueilUtilisateur frame = new AccueilUtilisateur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}
	
	static JDesktopPane desktopPane;
	String pseudoUtilisateur;
	
	public AccueilUtilisateur (String pseudoUtil) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.RED);
		menuBar.setBounds(20, 0, 937, 27);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Faire une R\u00E9servation");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ajouter une R\u00E9servation");
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					AjouterReservation ajouterreservation = new AjouterReservation(pseudoUtilisateur);
					desktopPane.add(ajouterreservation );
					desktopPane.moveToFront(ajouterreservation );
					ajouterreservation .setSize(desktopPane.getWidth(),desktopPane.getHeight());
					//ajoutbus.setLocation(null);
					ajouterreservation.show();
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
			}
			
		});
		
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Mes R\u00E9servations");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try {
					ReservationClient reservationclient = new ReservationClient(pseudoUtilisateur);
					desktopPane.add(reservationclient);
					desktopPane.moveToFront(reservationclient);
					reservationclient.setSize(desktopPane.getWidth(),desktopPane.getHeight());
					//ajoutbus.setLocation(null);
					reservationclient.show();
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
		
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("D\u00E9connexion");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Se D\u00E9connecter");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Identification id = new Identification();
				id.setLocationRelativeTo(null);
				id.setVisible(true);
			}
		});
		
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JLabel lblUtilisateur = new JLabel("Bienvenue : ");
		lblUtilisateur.setHorizontalAlignment(SwingConstants.LEFT);
		lblUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUtilisateur.setBounds(725, 38, 111, 39);
		contentPane.add(lblUtilisateur);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(20, 95, 937, 320);
		contentPane.add(desktopPane);
		
		
		this.pseudoUtilisateur = pseudoUtil;
		//String getValue = jLabel1.getText();
		//jLabel1.setText(getValue+" : "+pseudoUtil);
		
		JLabel jLabel1 = new JLabel(pseudoUtil);
		jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel1.setLabelFor(this);
		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel1.setBounds(846, 38, 111, 39);
		contentPane.add(jLabel1);
		
	}
	
	/**
	 * Create the frame.
	 */
	
	
	public AccueilUtilisateur() {
		
	}
	
	private javax.swing.JLabel jLabel1;
}

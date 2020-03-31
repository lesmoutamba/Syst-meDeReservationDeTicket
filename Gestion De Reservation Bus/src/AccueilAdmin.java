import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

public class AccueilAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccueilAdmin frame = new AccueilAdmin();
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
	String adminpseudo;
	
	public AccueilAdmin (String apseudo) {
		
		this.adminpseudo = apseudo; 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.RED);
		menuBar.setBounds(52, 0, 880, 27);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("DetailsBus");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Ajouter Bus");
		
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				AjoutBus ajoutbus = new AjoutBus();
				desktopPane.add(ajoutbus);
				desktopPane.moveToFront(ajoutbus);
				ajoutbus.setSize(desktopPane.getWidth(),desktopPane.getHeight());
				//ajoutbus.setLocation(null);
				ajoutbus.show();
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Afficher Bus");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					AffichageDetailsBus affichagedetailsbus = new AffichageDetailsBus();
					desktopPane.add(affichagedetailsbus);
					desktopPane.moveToFront(affichagedetailsbus);
					affichagedetailsbus.setSize(desktopPane.getWidth(),desktopPane.getHeight());
					//ajoutbus.setLocation(null);
					affichagedetailsbus.show();
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		
		mntmNewMenuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_3 = new JMenu("Conducteurs");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Ajouter Conducteur");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					AjouterConducteur ajouterconducteur = new AjouterConducteur();
					desktopPane.add(ajouterconducteur);
					desktopPane.moveToFront(ajouterconducteur);
					ajouterconducteur.setSize(desktopPane.getWidth(),desktopPane.getHeight());
					//ajoutbus.setLocation(null);
					ajouterconducteur.show();
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
			}
			
		});
		
		mntmNewMenuItem_10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Assigner Conducteur");
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AssignerConducteur assignerconducteur = new AssignerConducteur();
					desktopPane.add(assignerconducteur);
					desktopPane.moveToFront(assignerconducteur);
					assignerconducteur.setSize(desktopPane.getWidth(),desktopPane.getHeight());
					//ajoutbus.setLocation(null);
					assignerconducteur.show();
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		mntmNewMenuItem_18.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnNewMenu_3.add(mntmNewMenuItem_18);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Afficher Conducteurs");
		mntmNewMenuItem_13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnNewMenu_3.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_5 = new JMenu("Reservations");
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Ajouter R\u00E9servation");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AjouterReservation ajouterreservation = new AjouterReservation(apseudo);
					desktopPane.add(ajouterreservation );
					desktopPane.moveToFront(ajouterreservation );
					ajouterreservation.setSize(desktopPane.getWidth(),desktopPane.getHeight());
					//ajoutbus.setLocation(null);
					ajouterreservation.show();
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		mntmNewMenuItem_14.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnNewMenu_5.add(mntmNewMenuItem_14);
		
		JMenuItem mntmMesRservations = new JMenuItem("Liste des Reservations");
		mntmMesRservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmMesRservations.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mnNewMenu_5.add(mntmMesRservations);
		
		JMenu mnNewMenu_6 = new JMenu("D\u00E9connexion");
		mnNewMenu_6.setForeground(Color.DARK_GRAY);
		mnNewMenu_6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Se D\u00E9connecter");
		mntmNewMenuItem_17.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnNewMenu_6.add(mntmNewMenuItem_17);
		
		JLabel lblNewLabel = new JLabel("Bonjour");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(750, 32, 58, 21);
		contentPane.add(lblNewLabel);
		
		JLabel jLabel1 = new JLabel(apseudo);
		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabel1.setBounds(818, 32, 88, 21);
		contentPane.add(jLabel1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 59, 898, 388);
		contentPane.add(scrollPane);
		

		this.adminpseudo = apseudo; 
		
		desktopPane = new JDesktopPane();
		scrollPane.setViewportView(desktopPane);
	}
	
	
	
	static JDesktopPane desktopPane;
	
	public AccueilAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.RED);
		menuBar.setBounds(52, 0, 880, 27);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("DetailsBus");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Ajouter Bus");
		
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				AjoutBus ajoutbus = new AjoutBus();
				desktopPane.add(ajoutbus);
				desktopPane.moveToFront(ajoutbus);
				ajoutbus.setSize(desktopPane.getWidth(),desktopPane.getHeight());
				//ajoutbus.setLocation(null);
				ajoutbus.show();
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Afficher Bus");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					AffichageDetailsBus affichagedetailsbus = new AffichageDetailsBus();
					desktopPane.add(affichagedetailsbus);
					desktopPane.moveToFront(affichagedetailsbus);
					affichagedetailsbus.setSize(desktopPane.getWidth(),desktopPane.getHeight());
					//ajoutbus.setLocation(null);
					affichagedetailsbus.show();
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		
		mntmNewMenuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_3 = new JMenu("Conducteurs");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Ajouter Conducteur");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					AjouterConducteur ajouterconducteur = new AjouterConducteur();
					desktopPane.add(ajouterconducteur);
					desktopPane.moveToFront(ajouterconducteur);
					ajouterconducteur.setSize(desktopPane.getWidth(),desktopPane.getHeight());
					//ajoutbus.setLocation(null);
					ajouterconducteur.show();
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
			}
			
		});
		
		mntmNewMenuItem_10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Assigner Conducteur");
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AssignerConducteur assignerconducteur = new AssignerConducteur();
					desktopPane.add(assignerconducteur);
					desktopPane.moveToFront(assignerconducteur);
					assignerconducteur.setSize(desktopPane.getWidth(),desktopPane.getHeight());
					//ajoutbus.setLocation(null);
					assignerconducteur.show();
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		mntmNewMenuItem_18.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnNewMenu_3.add(mntmNewMenuItem_18);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Afficher Conducteurs");
		mntmNewMenuItem_13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnNewMenu_3.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_5 = new JMenu("Reservations");
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Ajouter R\u00E9servation");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AjouterReservation ajouterreservation = new AjouterReservation();
					desktopPane.add(ajouterreservation );
					desktopPane.moveToFront(ajouterreservation );
					ajouterreservation.setSize(desktopPane.getWidth(),desktopPane.getHeight());
					//ajoutbus.setLocation(null);
					ajouterreservation.show();
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		mntmNewMenuItem_14.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnNewMenu_5.add(mntmNewMenuItem_14);
		
		JMenuItem mntmMesRservations = new JMenuItem("Liste des Reservations");
		mntmMesRservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmMesRservations.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mnNewMenu_5.add(mntmMesRservations);
		
		JMenu mnNewMenu_6 = new JMenu("D\u00E9connexion");
		mnNewMenu_6.setForeground(Color.DARK_GRAY);
		mnNewMenu_6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Se D\u00E9connecter");
		mntmNewMenuItem_17.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnNewMenu_6.add(mntmNewMenuItem_17);
		
		JLabel lblNewLabel = new JLabel("Bonjour");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(750, 32, 58, 21);
		contentPane.add(lblNewLabel);
		
		JLabel jLabel1 = new JLabel("New label");
		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabel1.setBounds(818, 32, 88, 21);
		contentPane.add(jLabel1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 59, 898, 388);
		contentPane.add(scrollPane);
		
		
		desktopPane = new JDesktopPane();
		scrollPane.setViewportView(desktopPane);
	}
}

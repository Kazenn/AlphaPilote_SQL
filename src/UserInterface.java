import java.awt.AWTException;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class UserInterface extends JFrame{
	/**
	 * 
	 */
	Component LastEntered;
	private static final long serialVersionUID = 1L;
	private JComboBox MaComboBox;
	private String MachineDansMaComboBox;
	private JTextArea ZoneTextLog;
	private JLabel LabelTestFichierConfig;
	private JLabel LabelTestFichierMachine;
	private JLabel LabelTestFichierLog;
	private JLabel labelTestCouleurOk;
	private JLabel labelTestCouleurNok;
	private String UserNameStation = "Username non reconnu";
	
	String CheminQuick3270 = "D:\\AlphaPilote\\Quick3270\\Quick3270.exe";
	String CheminPutty = "D:\\AlphaPilote\\Putty\\Putty.exe";
	/*
	//String CheminFichierConfig ="D:\\AlphaPilote\\config.txt";
	//String CheminFichierLog ="D:\\AlphaPilote\\log.txt";
	//String CheminFichierMachine ="D:\\AlphaPilote\\machine.txt";
	
	String CheminFichierConfig ="D:\\AlphaPilote\\"+UserNameStation+"\\config.txt";
	String CheminFichierLog ="D:\\AlphaPilote\\"+UserNameStation+"\\log.txt";
	String CheminFichierMachine ="D:\\AlphaPilote\\machine.txt";
	
	String CheminQuick3270ProfileGmvs = "D:\\AlphaPilote\\Quick3270\\Profiles\\GMVS.ecf";
	String CheminQuick3270MacroGmvs = "D:\\AlphaPilote\\Quick3270\\Profiles\\GMVS.qmc";
	String CheminQuick3270ProfileGmvs_no_auto_login = "D:\\AlphaPilote\\Quick3270\\Profiles\\GMVS_no_auto_login.ecf";
	
	String CheminQuick3270ProfileKmvs = "D:\\AlphaPilote\\Quick3270\\Profiles\\KMVS.ecf";
	String CheminQuick3270MacroKmvs = "D:\\AlphaPilote\\Quick3270\\Profiles\\KMVS.qmc";
	String CheminQuick3270ProfileKmvs_no_auto_login = "D:\\AlphaPilote\\Quick3270\\Profiles\\KMVS_no_auto_login.ecf";
	
	String CheminQuick3270ProfileZmvs = "D:\\AlphaPilote\\Quick3270\\Profiles\\ZMVS.ecf";
	String CheminQuick3270MacroZmvs = "D:\\AlphaPilote\\Quick3270\\Profiles\\Zmvs.qmc";
	String CheminQuick3270ProfileZmvs_no_auto_login = "D:\\AlphaPilote\\Quick3270\\Profiles\\ZMVS_no_auto_login.ecf";
	
	String CheminQuick3270ProfileSysa = "D:\\AlphaPilote\\Quick3270\\Profiles\\Sysa.ecf";
	String CheminQuick3270MacroSysa = "D:\\AlphaPilote\\Quick3270\\Profiles\\Sysa.qmc";
	String CheminQuick3270ProfileSysa_no_auto_login = "D:\\AlphaPilote\\Quick3270\\Profiles\\Sysa_no_auto_login.ecf";
	
	String CheminQuick3270ProfileSysg = "D:\\AlphaPilote\\Quick3270\\Profiles\\Sysg.ecf";
	String CheminQuick3270MacroSysg = "D:\\AlphaPilote\\Quick3270\\Profiles\\Sysg.qmc";
	String CheminQuick3270ProfileSysg_no_auto_login = "D:\\AlphaPilote\\Quick3270\\Profiles\\Sysg_no_auto_login.ecf";
	*/


	
	
	public UserInterface() {
		UserNameStation = System.getProperty("user.name");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserInterface.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		setTitle(" AlphaPilote v0.1 - Environnement chargé pour "+UserNameStation+"");
		
		
		JMenuBar BarreMenuPrincipale = new JMenuBar();
		setJMenuBar(BarreMenuPrincipale);
		
		JMenu MenuFichier = new JMenu("Fichier");
		BarreMenuPrincipale.add(MenuFichier);
		
		JMenuItem MenuQuitter = new JMenuItem("Quitter");
		
		final ImageIcon IconQuitter = new ImageIcon(getClass().getResource("/door-open-icon.png"));
		MenuQuitter.setIcon(IconQuitter);
		MenuQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int code_retour = 0;
				System.exit(code_retour);
				}
		});
		
		JMenuItem MenuTestAccesFichiers = new JMenuItem("Tester l'acc\u00E8s aux fichiers");
		MenuTestAccesFichiers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			
				int RetourTest = TestAccesFichier();
				if (RetourTest == 1)
				{
					ZoneTextLog.append("L'accès à tous les fichiers est valide"+"\n");
					
				}
			
			}
		});
		MenuTestAccesFichiers.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		MenuFichier.add(MenuTestAccesFichiers);
		
		JSeparator SeparateurMenuFichier = new JSeparator();
		MenuFichier.add(SeparateurMenuFichier);
		
		
		MenuQuitter.setBackground(Color.RED);
		MenuFichier.add(MenuQuitter);
		
		JSeparator SeparateurFichierFavoris = new JSeparator();
		SeparateurFichierFavoris.setPreferredSize(new Dimension(0, 10));
		SeparateurFichierFavoris.setMaximumSize(new Dimension(5, 100));
		SeparateurFichierFavoris.setOrientation(SwingConstants.VERTICAL);
		BarreMenuPrincipale.add(SeparateurFichierFavoris);
		
		JMenu MenuFavoris = new JMenu("Favoris web");
		BarreMenuPrincipale.add(MenuFavoris);
		
		JScrollPane ScrollZoneTextLog = new JScrollPane();
		ScrollZoneTextLog.setViewportBorder(new TitledBorder(null, "Log", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		ScrollZoneTextLog.setBounds(10, 268, 478, 201);
		getContentPane().add(ScrollZoneTextLog);
		
		ZoneTextLog = new JTextArea();
		ScrollZoneTextLog.setViewportView(ZoneTextLog);
		ZoneTextLog.setWrapStyleWord(true);
		ZoneTextLog.setLineWrap(true);
		ZoneTextLog.setFont(new Font("Verdana", Font.PLAIN, 11));
		ZoneTextLog.setBackground(Color.LIGHT_GRAY);
		ZoneTextLog.setEditable(false);
		
		JMenu MenuOutils = new JMenu("Outils");
		BarreMenuPrincipale.add(MenuOutils);
		
		JMenuItem MenuPutty = new JMenuItem("Putty");
		final ImageIcon IconPutty = new ImageIcon(getClass().getResource("/putty-icon.png"));
		MenuPutty.setIcon(IconPutty);
		MenuPutty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				GestionLog MaLog = new GestionLog();
				GestionChemin Chemin = new GestionChemin();
				
				ProcessBuilder builder = new ProcessBuilder(new String[] {Chemin.DemandeChemin("CheminPutty")});
				try {
					Process p = builder.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " +e);
					ZoneTextLog.append("Erreur au lancement : Consulter la log."+"\n" );
		            
					
				}
				
			}
		});
		MenuOutils.add(MenuPutty);
		
		JMenuItem MenuQuick3270 = new JMenuItem("Quick3270");
		final ImageIcon IconQuick3270 = new ImageIcon(getClass().getResource("/quick3270-icon.png"));
		MenuQuick3270.setIcon(IconQuick3270);
		MenuQuick3270.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				GestionChemin Chemin = new GestionChemin();
				GestionLog MaLog = new GestionLog();
				ProcessBuilder builder = new ProcessBuilder(new String[] {Chemin.DemandeChemin("CheminQuick3270")});
				try {
					Process p = builder.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " +e1);
					ZoneTextLog.append("Erreur au lancement : Consulter la log."+"\n" );
		            
					
				}
				
			}
		});
		MenuOutils.add(MenuQuick3270);
		
		
		
		JMenu MenuConnexionMvs = new JMenu("Connexion");
		BarreMenuPrincipale.add(MenuConnexionMvs);
		
		JMenu SousMenuConnexionMvs = new JMenu("MVS");
		SousMenuConnexionMvs.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		MenuConnexionMvs.add(SousMenuConnexionMvs);
		
		JMenuItem MenuZmvs = new JMenuItem("Zmvs (CFF)");
		final ImageIcon IconZmvs = new ImageIcon(getClass().getResource("/Letter-Z-icon.png"));
		MenuZmvs.setIcon(IconZmvs);
		MenuZmvs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				GestionLog MaLog = new GestionLog();
				UserInterfaceConfig UserInterfaceConfigPourDemande = new UserInterfaceConfig();
				GestionChemin RequeteChemin = new GestionChemin();
				
								
				try {
					
					if ( UserInterfaceConfigPourDemande.DemandeEtatAutoLoginZmvs() == true)
		            {
		            
						ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileZmvs") });
						Process p = builder.start();
						
						ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuZmvs.getText() + " AUTOLOGIN");
			            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
		            	
		            }
					
					if ( UserInterfaceConfigPourDemande.DemandeEtatAutoLoginZmvs() == false)
		            {
						
						ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileZmvs_no_auto_login") });
						Process p = builder.start();
						
						ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuZmvs.getText());
			            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				
		            }
				
				} catch (IOException e1) {
					e1.printStackTrace();
					MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour ZMVS : " +e1);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				
				}
			
			}
		});
		
		JMenuItem MenuSysa = new JMenuItem("Sysa");
		final ImageIcon IconSysa = new ImageIcon(getClass().getResource("/Letter-A-blue-icon.png"));
		MenuSysa.setIcon(IconSysa);
		MenuSysa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				GestionLog MaLog = new GestionLog();
				UserInterfaceConfig UserInterfaceConfigPourDemande = new UserInterfaceConfig();
				GestionChemin RequeteChemin = new GestionChemin();				
				try {
					
					if ( UserInterfaceConfigPourDemande.DemandeEtatAutoLoginSysa() == true)
		            {
		            
						ProcessBuilder builder = new ProcessBuilder(new String[] {RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileSysa")});
						Process p = builder.start();
						
						ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuSysa.getText() + " AUTOLOGIN");
			            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
		            	
		            }
					
					if ( UserInterfaceConfigPourDemande.DemandeEtatAutoLoginSysa() == false)
		            {
						
						ProcessBuilder builder = new ProcessBuilder(new String[] {RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileSysa_no_auto_login")});
						Process p = builder.start();
						
						ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuSysa.getText());
			            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
						
		            }
				
				} catch (IOException e1) {
					e1.printStackTrace();
					MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour Sysa : " +e1);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					
				}	
				
				
			}
		});
		SousMenuConnexionMvs.add(MenuSysa);
		
		JMenuItem MenuKmvs = new JMenuItem("Kmvs (IP0)");
		final ImageIcon IconKmvs = new ImageIcon(getClass().getResource("/Letter-K-red-icon.png"));
		MenuKmvs.setIcon(IconKmvs);
		MenuKmvs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
				GestionLog MaLog = new GestionLog();
				UserInterfaceConfig UserInterfaceConfigPourDemande = new UserInterfaceConfig();
				GestionChemin RequeteChemin = new GestionChemin();				
				try {
					
					if ( UserInterfaceConfigPourDemande.DemandeEtatAutoLoginKmvs() == true)
		            {
		            
						ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileKmvs") });
						Process p = builder.start();
						
						ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuKmvs.getText() + " AUTOLOGIN");
			            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
		            	
		            }
					
					if ( UserInterfaceConfigPourDemande.DemandeEtatAutoLoginKmvs() == false)
		            {
						
						ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileKmvs_no_auto_login") });
						Process p = builder.start();					
						ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuKmvs.getText());
			            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
						
		            }
				
				} catch (IOException e1) {
					e1.printStackTrace();
					MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour KMVS : " +e1);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				
				}
			
			}
		});
		SousMenuConnexionMvs.add(MenuKmvs);
		SousMenuConnexionMvs.add(MenuZmvs);
		
		JMenuItem MenuSysg = new JMenuItem("Sysg (XENOS)");
		final ImageIcon IconSysg = new ImageIcon(getClass().getResource("/g-icon.png"));
		MenuSysg.setIcon(IconSysg);
		MenuSysg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
				GestionLog MaLog = new GestionLog();
				UserInterfaceConfig UserInterfaceConfigPourDemande = new UserInterfaceConfig();
				GestionChemin RequeteChemin = new GestionChemin();				
				try {
					
					if ( UserInterfaceConfigPourDemande.DemandeEtatAutoLoginSysg() == true)
		            {
		            
						ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileSysg") });
						Process p = builder.start();
						ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuSysg.getText() + " AUTOLOGIN");
			            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
		            	
		            }
					
					if ( UserInterfaceConfigPourDemande.DemandeEtatAutoLoginSysg() == false)
		            {
						
						ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileSysg_no_auto_login") });
						Process p = builder.start();
						
						ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuSysg.getText());
			            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				
		            }
			
				} catch (IOException e1) {
					e1.printStackTrace();
					MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour Sysg : " +e1);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					
				}
			}
				
				
			
		});
		SousMenuConnexionMvs.add(MenuSysg);
		
		JSeparator SeparateurMenuConnexionMvs = new JSeparator();
		SousMenuConnexionMvs.add(SeparateurMenuConnexionMvs);
		
		JMenuItem MenuGmvs = new JMenuItem("TPX Gmvs");
		SousMenuConnexionMvs.add(MenuGmvs);
		
		MenuGmvs.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaVolumeThumb.png")));
		
		MenuGmvs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				GestionLog MaLog = new GestionLog();
				UserInterfaceConfig UserInterfaceConfigPourDemande = new UserInterfaceConfig();
				GestionChemin RequeteChemin = new GestionChemin();
								
				try {
					
					if ( UserInterfaceConfigPourDemande.DemandeEtatAutoLoginGmvs() == true)
		            {
		            
						ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileGmvs") });
						Process p = builder.start();
						ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuGmvs.getText() + " AUTOLOGIN");
			            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
		            	
		            }
					
					if ( UserInterfaceConfigPourDemande.DemandeEtatAutoLoginGmvs() == false)
		            {
						
						ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileGmvs_no_auto_login") });
						Process p = builder.start();
						
						ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuGmvs.getText());
			            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				
		            }
			
				} catch (IOException e1) {
					e1.printStackTrace();
					MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour GMVS : " +e1);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					
				}
			}
		});
		getContentPane().setLayout(null);
		
		JPanel PaneZoneConnexion = new JPanel();
		PaneZoneConnexion.setSize(new Dimension(10, 10));
		PaneZoneConnexion.setOpaque(false);
		PaneZoneConnexion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Connexion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 99, 71)));
		PaneZoneConnexion.setBounds(10, 2, 308, 180);
		getContentPane().add(PaneZoneConnexion);
		PaneZoneConnexion.setLayout(null);
		
		JButton BoutonValideIp = new JButton("Ping");
		BoutonValideIp.setBounds(226, 16, 72, 23);
		PaneZoneConnexion.add(BoutonValideIp);
		
		JButton BoutonValideTelnet = new JButton("Telnet");
		BoutonValideTelnet.setBounds(216, 50, 82, 23);
		PaneZoneConnexion.add(BoutonValideTelnet);
	
		JButton BoutonValideSsh = new JButton("SSH");
		BoutonValideSsh.setBounds(216, 84, 82, 23);
		PaneZoneConnexion.add(BoutonValideSsh);
		
		
		
		JMenuItem MenuOdip = new JMenuItem("ODIP");
		MenuOdip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				URI uri = URI.create("http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action");
				try {
					Desktop.getDesktop().browse(uri);
					
					ZoneTextLog.append("Ouverture de la page " + MenuOdip.getText() );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
		            
				} catch (IOException e) {
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement d'ODIP : " +e);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					e.printStackTrace();
				}
				
			}
		});
		
		MenuOdip.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		MenuFavoris.add(MenuOdip);
		
		JMenu MenuConfiguration = new JMenu("Configuration");
		BarreMenuPrincipale.add(MenuConfiguration);
		
		JMenuItem MenuModifierFichierConfig = new JMenuItem("Editer configuration MVS/UNIX");
		MenuModifierFichierConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				UserInterfaceConfig PageConfig = new UserInterfaceConfig();
				
				PageConfig.setVisible(true);
				PageConfig.setSize(640,480);;
				
			}
		});
		MenuModifierFichierConfig.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		MenuConfiguration.add(MenuModifierFichierConfig);
		
		JMenu MenuAPropos = new JMenu("Aide");
		BarreMenuPrincipale.add(MenuAPropos);
		
		JMenuItem MenuLogErreurs = new JMenuItem("Log d'erreurs");
		MenuLogErreurs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				GestionChemin RequeteChemin = new GestionChemin();
	            
				try {
					ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "start ",RequeteChemin.DemandeChemin("CheminFichierLog"));
					Process p = builder.start();
				} catch (IOException e) {
					
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement de la log : " +e);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					e.printStackTrace();
				}
				
			}
		});
		MenuAPropos.add(MenuLogErreurs);
		
		JSeparator SeparateurApropos = new JSeparator();
		MenuAPropos.add(SeparateurApropos);
		
		JMenuItem MenuSignalerUnBug = new JMenuItem("Signaler un bug");
		MenuSignalerUnBug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				Desktop desktop = Desktop.getDesktop(); 
			    String message = "mailto:epfistner@gmail.com?subject=AlphaPilote";
			    URI uri = URI.create(message); 
			    try {
					desktop.mail(uri);
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}
		});
		MenuAPropos.add(MenuSignalerUnBug);
		
		JMenuItem MenuInterrogation = new JMenuItem("?");
		MenuAPropos.add(MenuInterrogation);
		
		
		JButton BoutonValideMstsc = new JButton("MSTSC");
		BoutonValideMstsc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
				GestionMachine MaMachine = new GestionMachine();
				String Resultatdemande = MaMachine.DemandeIp(MachineDansMaComboBox);
				String ResultatdemandeSave = Resultatdemande;
				
				//String TextZoneIp = ZoneIp.getText();
				if (Resultatdemande == null)
				{
					Resultatdemande = MachineDansMaComboBox;
					ResultatdemandeSave = MachineDansMaComboBox;
				}
				
				try {
					Runtime.getRuntime().exec(String.format("mstsc.exe /v:" + Resultatdemande ));
					ZoneTextLog.append("Lancement mstsc pour " + Resultatdemande  );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				} catch (IOException e1) {
					
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement de la log : " +e1);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					e1.printStackTrace();
				}
				
				
			}
		});
		BoutonValideMstsc.setBounds(216, 118, 82, 23);
		PaneZoneConnexion.add(BoutonValideMstsc);
		
		JLabel ResultatPing = new JLabel("");
		ResultatPing.setFont(new Font("Arial", Font.BOLD, 13));
		ResultatPing.setForeground(new Color(51, 153, 0));
		ResultatPing.setBounds(164, 17, 64, 20);
		PaneZoneConnexion.add(ResultatPing);
		
		JPanel ZoneConnexionAutoLogin = new JPanel();
		ZoneConnexionAutoLogin.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Auto login (SSH seulement)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 102, 204)));
		ZoneConnexionAutoLogin.setBounds(10, 54, 178, 114);
		PaneZoneConnexion.add(ZoneConnexionAutoLogin);
		ZoneConnexionAutoLogin.setLayout(null);
		
		
		
		JRadioButton BoutonRadioRoot = new JRadioButton("root");
		BoutonRadioRoot.setMargin(new Insets(0, 0, 0, 0));
		BoutonRadioRoot.setBounds(6, 18, 70, 23);
		ZoneConnexionAutoLogin.add(BoutonRadioRoot);
		
		
		JRadioButton BoutonRadioSalle = new JRadioButton("salle");
		BoutonRadioSalle.setMargin(new Insets(0, 0, 0, 0));
		BoutonRadioSalle.setBounds(6, 42, 70, 27);
		ZoneConnexionAutoLogin.add(BoutonRadioSalle);
		
		
		JRadioButton BoutonRadioUserPerso = new JRadioButton("j0*****");
		BoutonRadioUserPerso.setMargin(new Insets(0, 0, 0, 0));
		BoutonRadioUserPerso.setBounds(6, 74, 70, 18);
		ZoneConnexionAutoLogin.add(BoutonRadioUserPerso);
		
		
		//Ajout des bouton dans le ButtonGroup
				ButtonGroup MesBoutonsLogin = new ButtonGroup();
				MesBoutonsLogin.add(BoutonRadioRoot);
				MesBoutonsLogin.add(BoutonRadioSalle);
				MesBoutonsLogin.add(BoutonRadioUserPerso);
				
				Checkbox CheckBoxPassword = new Checkbox("+ pass");
				CheckBoxPassword.setBounds(82, 74, 63, 18);
				ZoneConnexionAutoLogin.add(CheckBoxPassword);
		
		MaComboBox = new JComboBox();
		MaComboBox.setAutoscrolls(true);
		MaComboBox.setMaximumRowCount(10);
		//MaComboBox.setModel(new DefaultComboBoxModel(new String[] {" ", "vintage", "vtom", "femat", "192.168.0.1", "aazeaz", "sdfsd", "hfdghrt", "jrtyy", "xchn", "tyudjc", "bn"}));
		MaComboBox.setBounds(10, 17, 128, 20);
		MaComboBox.setEditable(true);
		AutoCompleteDecorator.decorate(MaComboBox);
		PaneZoneConnexion.add(MaComboBox);
		
		MaComboBox.addItemListener(new ItemListener(){
			  public void itemStateChanged(ItemEvent ie){
			  MachineDansMaComboBox = (String)MaComboBox.getSelectedItem();
			  //ZoneTextLog.append(MachineDansMaComboBox);
			  //ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
			  
			  }
			  });
		
		JProgressBar MaBarreProgression = new JProgressBar();
		MaBarreProgression.setBounds(10, 237, 164, 20);
		getContentPane().add(MaBarreProgression);
		MaBarreProgression.setMaximum(20);
		MaBarreProgression.setIndeterminate(true);
		MaBarreProgression.setForeground(new Color(60, 179, 113));
		
		JPanel ZoneConfig = new JPanel();
		ZoneConfig.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Raccourcis", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 99, 71)));
		ZoneConfig.setBounds(558, 2, 216, 146);
		getContentPane().add(ZoneConfig);
		ZoneConfig.setLayout(null);
		
		JButton BoutonChargerConfig = new JButton("Recharger configuration");
		final ImageIcon IconBoutonRecharger = new ImageIcon(getClass().getResource("/reload-icon.png"));
		BoutonChargerConfig.setIcon(IconBoutonRecharger);
		BoutonChargerConfig.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
//LECTURE USER UNIX --------------------------------------------------------
				int CodeRetour = 5;
				String UserUnix = "#Erreur#";
				GestionConfig MaConfig = new GestionConfig();
				CodeRetour = MaConfig.LireConfig();
				
				UserUnix = MaConfig.DemandeUser("Unix");
				MaConfig.DemandePassword("Unix");
				
				
				MaConfig.DemandeUser("Gmvs");
				MaConfig.DemandePassword("Gmvs");
				
				
				MaConfig.DemandeUser("Sysa");
				MaConfig.DemandePassword("Sysa");
				
				
				MaConfig.DemandeUser("Kmvs");
				MaConfig.DemandePassword("Kmvs");
				
				
				MaConfig.DemandeUser("Zmvs");
				MaConfig.DemandePassword("Zmvs");
				
				MaConfig.DemandeUser("Sysg");
				MaConfig.DemandePassword("Sysg");
				
				
				
//FIN LECTURE USER UNIX--------------------------------------------------------			
				
 				GestionMachine MaMachine = new GestionMachine();
				
				//ArrayList<String> ReturnLigne = null;
				String[] ListeMachinePourComboBox = {"NO MACHINE"};
				try {
					ListeMachinePourComboBox = MaMachine.LireFichierGlossary();
					
				} catch (IOException e) 
				{
					e.printStackTrace();
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur dans la saisie machine(ip) : " +e);
					ZoneTextLog.append("Erreur de l'alimentation de la zone saisie machine(ip) : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					
				}
				MaComboBox.removeAllItems();
				MaComboBox.setModel(new DefaultComboBoxModel(ListeMachinePourComboBox));

// LECTURE USER PROFILE--------------------------------------------------------		
				
				
				GestionProfile GP = new GestionProfile();
				try {
					GP.ModifierPasswordProfile("Gmvs",MaConfig.DemandePassword("Gmvs"));
					GP.ModifierUserProfile("Gmvs", MaConfig.DemandeUser("Gmvs"));
					
					GP.ModifierPasswordProfile("Sysg",MaConfig.DemandePassword("Sysg"));
					GP.ModifierUserProfile("Sysg", MaConfig.DemandeUser("Sysg"));
					
					GP.ModifierPasswordProfile("Zmvs",MaConfig.DemandePassword("Zmvs"));
					GP.ModifierUserProfile("Zmvs", MaConfig.DemandeUser("Zmvs"));
					
					GP.ModifierPasswordProfile("Kmvs",MaConfig.DemandePassword("Kmvs"));
					GP.ModifierUserProfile("Kmvs", MaConfig.DemandeUser("Kmvs"));
					
					GP.ModifierPasswordProfile("Sysa",MaConfig.DemandePassword("Sysa"));
					GP.ModifierUserProfile("Sysa", MaConfig.DemandeUser("Sysa"));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur lors du chargement des macros : " +e);
					ZoneTextLog.append("Erreur lors du chargement des macros : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					
				}
				
				if (CodeRetour == 0)
				{
					ZoneTextLog.append("Configuration rechargée avec succés");
					ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					BoutonRadioUserPerso.setText(UserUnix);
					
					
				}
				if (CodeRetour == 1)
				{
					ZoneTextLog.append("Problème rechargement config");
					ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					BoutonRadioUserPerso.setText("#Erreur");
					
				}
				
				
			}
		});
		BoutonChargerConfig.setBounds(6, 16, 200, 23);
		ZoneConfig.add(BoutonChargerConfig);
		
		JPanel PanelZoneTestFichier = new JPanel();
		PanelZoneTestFichier.setForeground(new Color(255, 69, 0));
		PanelZoneTestFichier.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Test d'acc\u00E8s aux fichiers", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 99, 71)));
		PanelZoneTestFichier.setBounds(511, 308, 164, 161);
		getContentPane().add(PanelZoneTestFichier);
		PanelZoneTestFichier.setLayout(null);
		
		LabelTestFichierConfig = new JLabel(" Fichier configuration");
		LabelTestFichierConfig.setBounds(6, 30, 122, 14);
		PanelZoneTestFichier.add(LabelTestFichierConfig);
		LabelTestFichierConfig.setOpaque(true);
		LabelTestFichierConfig.setBackground(new Color(192, 192, 192));
		LabelTestFichierConfig.setToolTipText("");
		
		LabelTestFichierMachine = new JLabel(" Fichier machine");
		LabelTestFichierMachine.setBounds(6, 55, 95, 14);
		PanelZoneTestFichier.add(LabelTestFichierMachine);
		LabelTestFichierMachine.setBackground(new Color(192, 192, 192));
		LabelTestFichierMachine.setOpaque(true);
		
		LabelTestFichierLog = new JLabel(" Fichier log");
		LabelTestFichierLog.setBounds(6, 80, 59, 14);
		PanelZoneTestFichier.add(LabelTestFichierLog);
		LabelTestFichierLog.setBackground(new Color(192, 192, 192));
		LabelTestFichierLog.setOpaque(true);
		
		labelTestCouleurOk = new JLabel(" Acc\u00E8s OK");
		labelTestCouleurOk.setBounds(6, 136, 59, 14);
		PanelZoneTestFichier.add(labelTestCouleurOk);
		labelTestCouleurOk.setOpaque(true);
		labelTestCouleurOk.setBackground(new Color(60, 179, 113));
		
		labelTestCouleurNok = new JLabel(" Acc\u00E8s NOK");
		labelTestCouleurNok.setBounds(75, 136, 73, 14);
		PanelZoneTestFichier.add(labelTestCouleurNok);
		labelTestCouleurNok.setOpaque(true);
		labelTestCouleurNok.setBackground(new Color(178, 34, 34));
	
		
		
		
		BoutonValideSsh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				GestionMachine MaMachine = new GestionMachine();
				String Resultatdemande = MaMachine.DemandeIp(MachineDansMaComboBox);
				String ResultatdemandeSave = Resultatdemande;
				GestionChemin RequeteChemin = new GestionChemin();
				
				//String TextZoneIp = ZoneIp.getText();
				if (Resultatdemande == null)
				{
					Resultatdemande = MachineDansMaComboBox;
					ResultatdemandeSave = MachineDansMaComboBox;
				}					
			
					try {
						
						Boolean LanceUneFois = true;
			            
			             if (BoutonRadioRoot.isSelected() == true && LanceUneFois == true ) {
			            	 
			            	 	Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande +" -ssh -l root"));
			            	 	ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande + " avec le user root" );
					            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					            LanceUneFois = false;
					            MesBoutonsLogin.clearSelection();
					       
			             }
			             		             		             
			             if (BoutonRadioSalle.isSelected() == true && LanceUneFois == true ) {
			            	 
			            	 	Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande +" -ssh -l salle"));
			            	 	ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande + " avec le user salle" );
					            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					            LanceUneFois = false;
					            MesBoutonsLogin.clearSelection();
			             }
					            
					     if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == false) {
					            	 
				            	 	String EtatBouton = BoutonRadioUserPerso.getText();
				            	 	Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande +" -ssh -l "+EtatBouton));
				            	 	ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande + " avec le user " + BoutonRadioUserPerso.getText() );
						            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
						            LanceUneFois = false;
						            MesBoutonsLogin.clearSelection();
				            	     
				             }
				             
				          if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == true) {
				            	 	
				            	 	String EtatBouton = BoutonRadioUserPerso.getText();
				            	 	Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande +" -ssh -l "+EtatBouton));
				            	 	ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande + " avec le user " +EtatBouton+" et le mot de passe" );
						            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
						            LanceUneFois = false;
						            MesBoutonsLogin.clearSelection();
						            
						            int CodeRetour = 0;
									String PasswordUnix = "";
									GestionConfig MaConfig = new GestionConfig();
									PasswordUnix = MaConfig.DemandePassword("Unix");
									
									if (CodeRetour == 0)
									{
										
										SmartRobot SuperRobot = new SmartRobot();
							            SuperRobot.delay(1500);
							            SuperRobot.writeToClipboard(PasswordUnix);
							            SuperRobot.mousePress(InputEvent.BUTTON3_MASK);
							            SuperRobot.delay(50);
							            SuperRobot.mouseRelease(InputEvent.BUTTON3_MASK);
							            SuperRobot.delay(50);
							            SuperRobot.keyPress(KeyEvent.VK_ENTER);
									
									}
									else
									{
										CheckBoxPassword.setState(false);
										ZoneTextLog.append("Problème lors de la demande du mot de passe");
										ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
										
									}
					
				             }
			      
			             
			             if (LanceUneFois == true){
			            	 	Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " "+ Resultatdemande + " -ssh" ));
			            	 	ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande);
			            	 	ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
			            	 	LanceUneFois = false;
			            	 	MesBoutonsLogin.clearSelection();
					         
			             }
			             CheckBoxPassword.setState(false);
						
					} catch (IOException e1) {
						
						GestionLog MaLog = new GestionLog();
						MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " +e1);
						ZoneTextLog.append("Erreur au lancement : Consulter la log." );
			            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
						e1.printStackTrace();
					} catch (AWTException e1) {
						
						GestionLog MaLog = new GestionLog();
						MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " +e1);
						ZoneTextLog.append("Erreur au lancement : Consulter la log." );
			            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
						e1.printStackTrace();
					}
			            
				
			}
		});
		BoutonValideTelnet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
				//final String CHEMIN = "D:\\";
				
				GestionMachine MaMachine = new GestionMachine();
				String Resultatdemande = MaMachine.DemandeIp(MachineDansMaComboBox);
				String ResultatdemandeSave = Resultatdemande;
				GestionChemin RequeteChemin = new GestionChemin();
				//ResultatPing.setForeground(Color.GRAY);
				//String TextZoneIp = ZoneIp.getText();
				if (Resultatdemande == null)
				{
					Resultatdemande = MachineDansMaComboBox;
					ResultatdemandeSave = MachineDansMaComboBox;
				}
				
				//String TextZoneIp = ZoneIp.getText();
				
				try {
					
		            Boolean LanceUneFois = true;
		            
		             if (BoutonRadioRoot.isSelected() == true && LanceUneFois == true ) {
		            	 
		            	 	Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " "+ Resultatdemande +" -telnet -l root"));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande + " avec le user root" );
				            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				            LanceUneFois = false;
				            MesBoutonsLogin.clearSelection();
				            
		            	     
		             }
		             		             		             
		             if (BoutonRadioSalle.isSelected() == true && LanceUneFois == true ) {
		            	 
		            	 	Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande +" -telnet -l salle"));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande + " avec le user salle" );
				            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				            LanceUneFois = false;
				            MesBoutonsLogin.clearSelection();
		            	     
		             }
		             
		             if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == false) {
		            	 
		            	 	String EtatBouton = BoutonRadioUserPerso.getText();
		            	 	Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande +" -telnet -l "+EtatBouton));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande + " avec le user " + BoutonRadioUserPerso.getText() );
				            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				            LanceUneFois = false;
				            MesBoutonsLogin.clearSelection();
		            	     
		             }
		             
		             if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == true) {
		            	 	
		            	 	String EtatBouton = BoutonRadioUserPerso.getText();
		            	 	Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande +" -telnet -l "+EtatBouton));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande + " avec le user " +EtatBouton+" et le mot de passe" );
				            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				            LanceUneFois = false;
				            MesBoutonsLogin.clearSelection();
				            
				            int CodeRetour = 0;
							String PasswordUnix = "";
							GestionConfig MaConfig = new GestionConfig();
							
							PasswordUnix = MaConfig.DemandePassword("Unix");
							if (CodeRetour == 0)
							{
								CheckBoxPassword.setState(false);
								SmartRobot SuperRobot = new SmartRobot();
					            SuperRobot.delay(1500);
					            SuperRobot.type(PasswordUnix);
					            SuperRobot.keyPress(KeyEvent.VK_ENTER);
							
							}
							else
							{
								CheckBoxPassword.setState(false);
								ZoneTextLog.append("Problème lors de la demande du mot de pass");
								ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
								
							}
			
		             }
		             
		             if (LanceUneFois == true){
		            	 	//Runtime.getRuntime().exec(String.format("cmd.exe /c start D:\\AlphaPilote\\Putty.exe -telnet " + TextZoneIp ));
		            	 	
		            	 	Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty")+" " + Resultatdemande ));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande);
		            	 	ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
		            	 	LanceUneFois = false;
		            	 	MesBoutonsLogin.clearSelection();
		             }
		             // Lancement avec User perso, à faire quand la config remontera le user UNIX
		             	             
		       		            
				} catch (IOException e) {
					e.printStackTrace();
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " +e);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					
				} catch (AWTException e) {
					e.printStackTrace();
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " +e);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					
				}
				
				
		    
			}
	
		});
		
		
		BoutonValideIp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LastEntered = e.getComponent();
				GestionMachine MaMachine = new GestionMachine();
				String ResultatDemandeTest = MaMachine.DemandeIp(MachineDansMaComboBox);
				String ResultatdemandeSave = ResultatDemandeTest;
				
				ResultatPing.setForeground(Color.GRAY);
				
				if (ResultatDemandeTest == null)
				{
					ResultatDemandeTest = MachineDansMaComboBox;
					ResultatdemandeSave = MachineDansMaComboBox;
					
				}
								
				ZoneTextLog.append("Ping vers " + ResultatdemandeSave + " en cours ...");
	            ZoneTextLog.setText(ZoneTextLog.getText() + "\n");
					
				
				//final String CHEMIN = "D:\\";
			    
			        try {
			        	//System.setOut(new PrintStream(System.out, true, "IBM850"));
			        	
			        	ResultatPing.setForeground(Color.GRAY);
			            
			            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", " ping "+ResultatDemandeTest+" -n 1");
			            //pb.directory(new File(CHEMIN));
			            
			            Map<String, String> env = pb.environment();
			            for (Entry<?, ?> entry : env.entrySet()) {
			                System.out.println(entry.getKey() + " : " + entry.getValue());
			            }
			            
			            env.put("MonArg", "Valeur");
			            
			            Process p = pb.start();
			            AfficheurFlux fluxSortie = new AfficheurFlux(p.getInputStream());
			            AfficheurFlux fluxErreur = new AfficheurFlux(p.getErrorStream());
			            new Thread(fluxSortie).start();
			            new Thread(fluxErreur).start();
			           
			            p.waitFor();
			            
			            Boolean resultping = fluxSortie.LecteurFind();
			            
			            if (resultping == true){
			            	
			            	//ResultatPing.setEnabled(true);
			            	ResultatPing.setText("Ping OK");
			        		
			            	ResultatPing.setForeground(new Color(51, 153, 0));
			        	}
			            
			            if (resultping == false){
			            	//ResultatPing.setEnabled(true);
			            	ResultatPing.setText("Ping KO");
			    
			        		ResultatPing.setForeground(Color.RED);
			        	}
			         
			            String CharASupprimer = "ÿ"; 
			            String LigneRetourPourAffichage = fluxSortie.LecteurDeFlux();
			            LigneRetourPourAffichage = LigneRetourPourAffichage.replaceAll(CharASupprimer," ");
			            ZoneTextLog.append(LigneRetourPourAffichage);
			            

			        } catch (IOException e1) {
			        	e1.printStackTrace();
			            ZoneTextLog.append("PING KO - Echec de la commande");
			            ZoneTextLog.setText(ZoneTextLog.getText() + "\n");
			            GestionLog MaLog = new GestionLog();
						MaLog.EcrireDansFichierLog("Erreur au lancement du ping : " +e);
						
						
			            
			         } catch (InterruptedException e1) {
			        	 e1.printStackTrace();
			        	 ZoneTextLog.append("PING KO - Echec de la commande");
				         ZoneTextLog.setText(ZoneTextLog.getText() + "\n");
				         GestionLog MaLog = new GestionLog();
						 MaLog.EcrireDansFichierLog("Erreur au lancement du ping : " +e1);
						 
						 
					}
			    }	
			
			
			//LANCE AU CHARGEMENT DE LA FENETRE PRINCIPALE
					
					int RetourTest = TestAccesFichier();
					
					
					
					
			
		});

	}
	
	
	
	public int TestAccesFichier()
	{
		GestionChemin RequeteChemin = new GestionChemin();
		File FichierMachine = new File(RequeteChemin.DemandeChemin("CheminFichierMachine"));
		if (FichierMachine.exists())
		{
			LabelTestFichierMachine.setBackground(new Color(60, 179, 113));
			LabelTestFichierMachine.setOpaque(true);		
		}
		else
		{
			ZoneTextLog.append("Impossible de trouver le fichier : "+RequeteChemin.DemandeChemin("CheminFichierMachine")+"\n");
			LabelTestFichierMachine.setBackground(new Color(178, 34, 34));
			LabelTestFichierConfig.setOpaque(true);
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur lors du test présence du fichier machine dans : "+RequeteChemin.DemandeChemin("CheminFichierMachine"));
		}
		File FichierConfig = new File(RequeteChemin.DemandeChemin("CheminFichierConfig"));
		if (FichierConfig.exists())
		{
			LabelTestFichierConfig.setBackground(new Color(60, 179, 113));
			LabelTestFichierConfig.setOpaque(true);		
		}
		else
		{
			ZoneTextLog.append("Impossible de trouver le config : "+RequeteChemin.DemandeChemin("CheminFichierConfig")+"\n");
			LabelTestFichierConfig.setBackground(new Color(178, 34, 34));
			LabelTestFichierConfig.setOpaque(true);
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur lors du test présence du fichier config dans : "+RequeteChemin.DemandeChemin("CheminFichierMachine"));
		}
		File FichierLog = new File(RequeteChemin.DemandeChemin("CheminFichierLog"));
		if (FichierLog.exists())
		{
			LabelTestFichierLog.setBackground(new Color(60, 179, 113));
			LabelTestFichierLog.setOpaque(true);		
		}
		else
		{
			ZoneTextLog.append("Impossible de trouver le log : "+RequeteChemin.DemandeChemin("CheminFichierLog")+"\n");
			ZoneTextLog.append("Création d'un nouveau fichier de log"+"\n");
			LabelTestFichierLog.setBackground(new Color(178, 34, 34));
			LabelTestFichierLog.setOpaque(true);
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur lors du test présence du log config dans : "+RequeteChemin.DemandeChemin("CheminFichierMachine"));
			
		}
		return 1;	
	}
	
		
	protected ImageIcon createImageIcon(String path,String description) 
	{
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}

	
}

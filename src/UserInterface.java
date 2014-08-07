import java.awt.AWTException;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ButtonGroup;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.DefaultComboBoxModel;

public class UserInterface extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox MaComboBox;
	private String MachineDansMaComboBox;
	
	String CheminQuick3270 = "D:\\AlphaPilote\\Quick3270\\Quick3270.exe";
	String CheminPutty = "D:\\AlphaPilote\\Putty.exe";
	
	
	String CheminQuick3270ProfileGmvs = "D:\\AlphaPilote\\GMVS.ecf";
	String CheminQuick3270ProfileSyno = "D:\\AlphaPilote\\Quick3270\\Profiles\\Macro_syno_test.ecf";
	
	
	public UserInterface() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserInterface.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		setTitle(" AlphaPilote v0.1    -     Etienne PFISTNER");
		
		JMenuBar BarreMenuPrincipale = new JMenuBar();
		setJMenuBar(BarreMenuPrincipale);
		
		JMenu MenuFichier = new JMenu("Fichier");
		BarreMenuPrincipale.add(MenuFichier);
		
		JMenuItem MenuQuitter = new JMenuItem("Quitter");
		MenuQuitter.setIcon(new ImageIcon(UserInterface.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		MenuQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int code_retour = 0;
				System.exit(code_retour);
				}
		});
		
		
		MenuQuitter.setBackground(Color.RED);
		MenuFichier.add(MenuQuitter);
		
		JSeparator SeparateurFichierFavoris = new JSeparator();
		SeparateurFichierFavoris.setPreferredSize(new Dimension(0, 10));
		SeparateurFichierFavoris.setMaximumSize(new Dimension(5, 100));
		SeparateurFichierFavoris.setOrientation(SwingConstants.VERTICAL);
		BarreMenuPrincipale.add(SeparateurFichierFavoris);
		
		JMenu mnFavorisPilotage = new JMenu("Favoris Pilotage");
		BarreMenuPrincipale.add(mnFavorisPilotage);
		
		JScrollPane ScrollZoneTextLog = new JScrollPane();
		ScrollZoneTextLog.setViewportBorder(new TitledBorder(null, "Log", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		ScrollZoneTextLog.setBounds(10, 268, 564, 201);
		getContentPane().add(ScrollZoneTextLog);
		
		JTextArea ZoneTextLog = new JTextArea();
		ScrollZoneTextLog.setViewportView(ZoneTextLog);
		ZoneTextLog.setWrapStyleWord(true);
		ZoneTextLog.setLineWrap(true);
		ZoneTextLog.setFont(new Font("Verdana", Font.PLAIN, 11));
		ZoneTextLog.setBackground(Color.LIGHT_GRAY);
		ZoneTextLog.setEditable(false);
		
		
		
		JMenu MenuConnexionMvs = new JMenu("Connexion");
		BarreMenuPrincipale.add(MenuConnexionMvs);
		
		JMenu SousMenuConnexionMvs = new JMenu("MVS");
		SousMenuConnexionMvs.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		MenuConnexionMvs.add(SousMenuConnexionMvs);
		
		JMenuItem MenuGmvs = new JMenuItem("TPX Gmvs");
		SousMenuConnexionMvs.add(MenuGmvs);
		
		MenuGmvs.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaVolumeThumb.png")));
		
		JMenu SousMenuConnexionUnix = new JMenu("Unix");
		MenuConnexionMvs.add(SousMenuConnexionUnix);
		
		JMenuItem MenuSyno = new JMenuItem("Syno");
		MenuSyno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				GestionLog MaLog = new GestionLog();
				
				
				ProcessBuilder builder = new ProcessBuilder(new String[] { CheminQuick3270, CheminQuick3270ProfileSyno });
				
				try {
					Process process = builder.start();
					ZoneTextLog.append("Ouverture connexion telnet vers " + MenuSyno.getText());
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour GMVS : " +e);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					
				}
				
				
				
			}
		});
		SousMenuConnexionUnix.add(MenuSyno);
		
		MenuGmvs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				GestionLog MaLog = new GestionLog();
				
								
				try {
					
					
					//String CheminQuick3270 = "C:\\Program Files (x86)\\Quick3270 Secure\\Quick3270.exe";
					//String CheminQuick3270ProfileGmvs = "D:\\AlphaPilote\\GMVS.ecf";
					ProcessBuilder builder = new ProcessBuilder(new String[] { CheminQuick3270, CheminQuick3270ProfileGmvs });
					Process p = builder.start();
					
					ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuGmvs.getText());
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				
		            UserInterfaceConfig UserInterfacePourDemande = new UserInterfaceConfig();
		            if ( UserInterfacePourDemande.DemandeEtatAutoLoginGmvs() == true)
		            {
		           
		            SmartRobot SuperRobot = new SmartRobot();
		            SuperRobot.delay(500);
		            SuperRobot.type("tpx");
		            SuperRobot.delay(50);
		            SuperRobot.keyPress(KeyEvent.VK_ENTER);
		            
		            GestionConfig MaConfig = new GestionConfig();
		            String UserDemande = MaConfig.DemandeUser("Gmvs");
		            String PassDemande = MaConfig.DemandePassword("Gmvs");
		            
		            SuperRobot.delay(250);
		            SuperRobot.type(UserDemande);
		            SuperRobot.keyPress(KeyEvent.VK_TAB);
		            SuperRobot.type(PassDemande);
		            SuperRobot.keyPress(KeyEvent.VK_ENTER);
		            }
					
				} catch (IOException e1) {
					
					MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour GMVS : " +e1);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					e1.printStackTrace();
					
				} catch (AWTException e) {
					e.printStackTrace();
					MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour GMVS : " +e);
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
		mnFavorisPilotage.add(MenuOdip);
		
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
		
		JMenuItem MenuModifierFichierMachine = new JMenuItem("Editer machines");
		MenuModifierFichierMachine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				UserInterfaceMachine PageMachine = new UserInterfaceMachine();
				
				PageMachine.setVisible(true);
				PageMachine.setSize(640,480);;
				//ZoneTextLog.append(MachineDansMaComboBox);
				//ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				
				
				
			}
		});
	            
	            
	            
		MenuConfiguration.add(MenuModifierFichierMachine);
		
		JMenu MenuAPropos = new JMenu("A propos d'AlphaPilote");
		BarreMenuPrincipale.add(MenuAPropos);
		
		JMenuItem MenuLogErreurs = new JMenuItem("Log d'erreurs");
		MenuLogErreurs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
	            //pb.CheminQuick3270ProfileGmvs(new File(CHEMIN));
								//ProcessBuilder builder = new ProcessBuilder(new String[] { CheminQuick3270, CheminQuick3270ProfileGmvs });
				try {
					ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "start D:\\AlphaPilote\\log.txt");
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
			    String message = "mailto:epfistner@gmail.com?subject=Bug_ou_suggestion_pour_AlphaPilote&body=Fichier_log_attache&attachment=d:/AlphaPilote/log.txt"; 
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
		ZoneConnexionAutoLogin.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Auto login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 102, 204)));
		ZoneConnexionAutoLogin.setBounds(10, 54, 147, 114);
		PaneZoneConnexion.add(ZoneConnexionAutoLogin);
		ZoneConnexionAutoLogin.setLayout(null);
		
		
		
		JRadioButton BoutonRadioRoot = new JRadioButton("root");
		BoutonRadioRoot.setBounds(6, 16, 70, 23);
		ZoneConnexionAutoLogin.add(BoutonRadioRoot);
		
		
		JRadioButton BoutonRadioSalle = new JRadioButton("salle");
		BoutonRadioSalle.setBounds(6, 42, 70, 27);
		ZoneConnexionAutoLogin.add(BoutonRadioSalle);
		
		
		JRadioButton BoutonRadioUserPerso = new JRadioButton("j0*****");
		BoutonRadioUserPerso.setBounds(6, 72, 70, 18);
		ZoneConnexionAutoLogin.add(BoutonRadioUserPerso);
		
		
		//Ajout des bouton dans le ButtonGroup
				ButtonGroup MesBoutonsLogin = new ButtonGroup();
				MesBoutonsLogin.add(BoutonRadioRoot);
				MesBoutonsLogin.add(BoutonRadioSalle);
				MesBoutonsLogin.add(BoutonRadioUserPerso);
				
				Checkbox CheckBoxPassword = new Checkbox("+ pass");
				CheckBoxPassword.setBounds(83, 72, 54, 22);
				ZoneConnexionAutoLogin.add(CheckBoxPassword);
		
		JComboBox MaComboBox = new JComboBox();
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
		ZoneConfig.setBounds(486, 2, 216, 146);
		getContentPane().add(ZoneConfig);
		ZoneConfig.setLayout(null);
		
		JButton BoutonChargerConfig = new JButton("Recharger configuration");
		BoutonChargerConfig.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		BoutonChargerConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
//LECTURE USER UNIX --------------------------------------------------------
				int CodeRetour = 5;
				String UserUnix = "";
				GestionConfig MaConfig = new GestionConfig();
				CodeRetour = MaConfig.LireConfig();
				
				MaConfig.DemandeUser("Unix");
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
				
				
				if (CodeRetour == 0)
				{
					ZoneTextLog.append("Chargement config OK");
					ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					BoutonRadioUserPerso.setText(UserUnix);
					
					
				}
				if (CodeRetour == 1)
				{
					ZoneTextLog.append("Problème chargement config");
					ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					
				}
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
					MaLog.EcrireDansFichierLog("Erreur de l'alimentation de la zone saisie machine(ip) : " +e);
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
				
				
			}
		});
		BoutonChargerConfig.setBounds(6, 16, 200, 23);
		ZoneConfig.add(BoutonChargerConfig);
	
		
		
		
		BoutonValideSsh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				GestionMachine MaMachine = new GestionMachine();
				String Resultatdemande = MaMachine.DemandeIp(MachineDansMaComboBox);
				String ResultatdemandeSave = Resultatdemande;
				
				//String TextZoneIp = ZoneIp.getText();
				if (Resultatdemande == null)
				{
					Resultatdemande = MachineDansMaComboBox;
					ResultatdemandeSave = MachineDansMaComboBox;
				}					
				
				
					//final String CHEMIN = "D:\\";
					//String TextZoneIp = ZoneIp.getText();
					
					try {
						//Runtime.getRuntime().exec(String.format("cmd.exe /c start D:\\AlphaPilote\\Putty.exe -ssh " + TextZoneIp ));
						//ZoneTextLog.append("Lancement putty ssh pour " + ZoneIp.getText()  );
			            //ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
						
						Boolean LanceUneFois = true;
			            
			             if (BoutonRadioRoot.isSelected() == true && LanceUneFois == true ) {
			            	 
			            	 	Runtime.getRuntime().exec(String.format(CheminPutty + " " + Resultatdemande +" -ssh -l root"));
			            	 	ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande + " avec le user root" );
					            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					            LanceUneFois = false;
					            MesBoutonsLogin.clearSelection();
					       
			             }
			             		             		             
			             if (BoutonRadioSalle.isSelected() == true && LanceUneFois == true ) {
			            	 
			            	 	Runtime.getRuntime().exec(String.format(CheminPutty + " " + Resultatdemande +" -ssh -l salle"));
			            	 	ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande + " avec le user salle" );
					            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					            LanceUneFois = false;
					            MesBoutonsLogin.clearSelection();
			             }
					            
					     if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == false) {
					            	 
				            	 	String EtatBouton = BoutonRadioUserPerso.getText();
				            	 	Runtime.getRuntime().exec(String.format(CheminPutty + " " + Resultatdemande +" -ssh -l "+EtatBouton));
				            	 	ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande + " avec le user " + BoutonRadioUserPerso.getText() );
						            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
						            LanceUneFois = false;
						            MesBoutonsLogin.clearSelection();
				            	     
				             }
				             
				          if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == true) {
				            	 	
				            	 	String EtatBouton = BoutonRadioUserPerso.getText();
				            	 	Runtime.getRuntime().exec(String.format(CheminPutty + " " + Resultatdemande +" -ssh -l "+EtatBouton));
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
			            	 	Runtime.getRuntime().exec(String.format(CheminPutty + " "+ Resultatdemande + " -ssh" ));
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
		            	 
		            	 	Runtime.getRuntime().exec(String.format(CheminPutty + " "+ Resultatdemande +" -telnet -l root"));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande + " avec le user root" );
				            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				            LanceUneFois = false;
				            MesBoutonsLogin.clearSelection();
				            
		            	     
		             }
		             		             		             
		             if (BoutonRadioSalle.isSelected() == true && LanceUneFois == true ) {
		            	 
		            	 	Runtime.getRuntime().exec(String.format(CheminPutty + " " + Resultatdemande +" -telnet -l salle"));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande + " avec le user salle" );
				            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				            LanceUneFois = false;
				            MesBoutonsLogin.clearSelection();
		            	     
		             }
		             
		             if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == false) {
		            	 
		            	 	String EtatBouton = BoutonRadioUserPerso.getText();
		            	 	Runtime.getRuntime().exec(String.format(CheminPutty + " " + Resultatdemande +" -telnet -l "+EtatBouton));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande + " avec le user " + BoutonRadioUserPerso.getText() );
				            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				            LanceUneFois = false;
				            MesBoutonsLogin.clearSelection();
		            	     
		             }
		             
		             if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == true) {
		            	 	
		            	 	String EtatBouton = BoutonRadioUserPerso.getText();
		            	 	Runtime.getRuntime().exec(String.format(CheminPutty + " " + Resultatdemande +" -telnet -l "+EtatBouton));
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
		            	 	
		            	 	Runtime.getRuntime().exec(String.format(CheminPutty+" " + Resultatdemande ));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande);
		            	 	ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
		            	 	LanceUneFois = false;
		            	 	MesBoutonsLogin.clearSelection();
		             }
		             // Lancement avec User perso, à faire quand la config remontera le user UNIX
		             	             
		       		            
				} catch (IOException e) {
					
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " +e);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					e.printStackTrace();
				} catch (AWTException e) {
					
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " +e);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					e.printStackTrace();
				}
				
				
		    
			}
	
		});
		
		
		BoutonValideIp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
		
				GestionMachine MaMachine = new GestionMachine();
				String Resultatdemande = MaMachine.DemandeIp(MachineDansMaComboBox);
				String ResultatdemandeSave = Resultatdemande;
				ResultatPing.setForeground(Color.GRAY);
				//String TextZoneIp = ZoneIp.getText();
				if (Resultatdemande == null)
				{
					Resultatdemande = MachineDansMaComboBox;
					ResultatdemandeSave = MachineDansMaComboBox;
				}
				
				Resultatdemande = Resultatdemande + "\"";
				
				
				StringBuffer StringFinal = new StringBuffer (Resultatdemande);  
				String guillemet = "\"ping ";  
				StringFinal.insert (0, guillemet);  
				Resultatdemande = StringFinal.toString();	
				ZoneTextLog.append("Ping vers " + ResultatdemandeSave + " en cours ...");
	            ZoneTextLog.setText(ZoneTextLog.getText() + "\n");
					
				
				final String CHEMIN = "D:\\";
			    
			        try {
			        	//System.setOut(new PrintStream(System.out, true, "IBM850"));
			        	
			        	ResultatPing.setForeground(Color.GRAY);
			            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", Resultatdemande, " -n 1");
			            pb.directory(new File(CHEMIN));
			            
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
			         
			            //MaBarreProgression.setValue(100);
			             
			            //ZoneTextLog.append(fluxSortie.RetourFluxAfficheur);
			            //String TESTTTEST = fluxSortie.LecteurDeFlux();
			            //ZoneTextLog.setForeground(Color.GREEN);
			            ZoneTextLog.append(fluxSortie.LecteurDeFlux());

			        } catch (IOException e1) {
			            
			            ZoneTextLog.append("PING KO - Echec de la commande");
			            ZoneTextLog.setText(ZoneTextLog.getText() + "\n");
			            GestionLog MaLog = new GestionLog();
						MaLog.EcrireDansFichierLog("Erreur au lancement du ping : " +e);
						
						e1.printStackTrace();
			            
			         } catch (InterruptedException e1) {
						
			        	 ZoneTextLog.append("PING KO - Echec de la commande");
				         ZoneTextLog.setText(ZoneTextLog.getText() + "\n");
				         GestionLog MaLog = new GestionLog();
						 MaLog.EcrireDansFichierLog("Erreur au lancement du ping : " +e1);
						 e1.printStackTrace();
					}
			    }				
		});

	}
}

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URI;
import java.security.Timestamp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Map.Entry;

import com.jgoodies.forms.factories.FormFactory;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Robot;

import javax.swing.border.TitledBorder;

import java.awt.event.KeyAdapter;
import java.awt.Checkbox;


public class UserInterface extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField ZoneIp;

	public UserInterface() {
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
		
		JMenu MenuSeparateur = new JMenu("         ");
		MenuSeparateur.setForeground(Color.BLACK);
		MenuSeparateur.setEnabled(false);
		BarreMenuPrincipale.add(MenuSeparateur);
		
		JMenu mnFavorisPilotage = new JMenu("Favoris Pilotage");
		BarreMenuPrincipale.add(mnFavorisPilotage);
		
		
		
		JMenu MenuConnexionMvs = new JMenu("Connexion MVS");
		BarreMenuPrincipale.add(MenuConnexionMvs);
		
		JMenuItem MenuGmvs = new JMenuItem("TPX Gmvs");
		
		MenuGmvs.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaVolumeThumb.png")));
		MenuConnexionMvs.add(MenuGmvs);
		getContentPane().setLayout(null);
		
		JPanel PaneZoneConnexion = new JPanel();
		PaneZoneConnexion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Connexion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 99, 71)));
		PaneZoneConnexion.setBounds(6, 2, 308, 224);
		getContentPane().add(PaneZoneConnexion);
		PaneZoneConnexion.setLayout(null);
		
		ZoneIp = new JTextField();
		
		ZoneIp.setBounds(6, 17, 164, 20);
		PaneZoneConnexion.add(ZoneIp);
		ZoneIp.setText("192.168.0.253");
		ZoneIp.setColumns(10);
		
		
		JButton BoutonValideIp = new JButton("Ping");
		BoutonValideIp.setBounds(226, 16, 72, 23);
		PaneZoneConnexion.add(BoutonValideIp);
		
		JButton BoutonValideTelnet = new JButton("Telnet");
		BoutonValideTelnet.setBounds(216, 50, 82, 23);
		PaneZoneConnexion.add(BoutonValideTelnet);
		
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
		
		MenuGmvs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
								
				try {
					
					String exeloc = "C:\\Program Files (x86)\\Quick3270 Secure\\Quick3270.exe";
					String directory = "D:\\AlphaPilote\\GMVS.ecf";
					ProcessBuilder builder = new ProcessBuilder(new String[] { exeloc, directory });
					Process p = builder.start();
					
					ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuGmvs.getText());
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					
		            SmartRobot SuperRobot = new SmartRobot();
		            SuperRobot.delay(500);
		            SuperRobot.type("tpx");
		            SuperRobot.keyPress(KeyEvent.VK_ENTER);
		           
					//Robot robot = new Robot();
					//robot.delay(500);
					//robot.keyPress(KeyEvent.VK_T);
					//robot.keyPress(KeyEvent.VK_P);
					//robot.keyPress(KeyEvent.VK_X);
					//robot.keyPress(KeyEvent.VK_ENTER);
										
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					ZoneTextLog.append("Erreur au lancement");
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					e1.printStackTrace();
					System.out.println("Second:" + e1);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		MenuOdip.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		mnFavorisPilotage.add(MenuOdip);
		
		JMenu MenuConfiguration = new JMenu("Configuration");
		BarreMenuPrincipale.add(MenuConfiguration);
		
		JMenuItem MenuModifierFichierConfig = new JMenuItem("Modifier fichier de config");
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
		
		
		JButton BoutonValideMstsc = new JButton("MSTSC");
		BoutonValideMstsc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				String TextZoneIp = ZoneIp.getText();
				
				try {
					Runtime.getRuntime().exec(String.format("mstsc.exe /v:" + TextZoneIp ));
					ZoneTextLog.append("Lancement mstsc pour " + ZoneIp.getText()  );
		            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		BoutonValideMstsc.setBounds(216, 118, 82, 23);
		PaneZoneConnexion.add(BoutonValideMstsc);
		
		JLabel ResultatPing = new JLabel("");
		ResultatPing.setFont(new Font("Arial", Font.BOLD, 13));
		ResultatPing.setForeground(new Color(51, 153, 0));
		ResultatPing.setBounds(166, 17, 64, 20);
		PaneZoneConnexion.add(ResultatPing);
		
		JPanel ZoneConnexionAutoLogin = new JPanel();
		ZoneConnexionAutoLogin.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Auto login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 102, 204)));
		ZoneConnexionAutoLogin.setBounds(6, 44, 147, 114);
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
		
		
		
		
		JProgressBar MaBarreProgression = new JProgressBar();
		MaBarreProgression.setBounds(10, 237, 164, 20);
		getContentPane().add(MaBarreProgression);
		MaBarreProgression.setMaximum(20);
		MaBarreProgression.setIndeterminate(true);
		MaBarreProgression.setForeground(new Color(60, 179, 113));
		
		JPanel ZoneConfig = new JPanel();
		ZoneConfig.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Configuration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 99, 71)));
		ZoneConfig.setBounds(486, 2, 216, 146);
		getContentPane().add(ZoneConfig);
		ZoneConfig.setLayout(null);
		
		JButton BoutonChargerConfig = new JButton("Charger config");
		BoutonChargerConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				int CodeRetour = 5;
				String UserG = "";
				String UserUnix = "";
				GestionConfig MaConfig = new GestionConfig();
				CodeRetour = MaConfig.LireConfig();
				UserG = MaConfig.DemandeUser("G");
				UserUnix = MaConfig.DemandeUser("Unix");
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
				
				
			}
		});
		BoutonChargerConfig.setBounds(6, 16, 126, 23);
		ZoneConfig.add(BoutonChargerConfig);
		BoutonValideSsh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
									
					//final String CHEMIN = "D:\\";
					String TextZoneIp = ZoneIp.getText();
					
					try {
						//Runtime.getRuntime().exec(String.format("cmd.exe /c start D:\\AlphaPilote\\Putty.exe -ssh " + TextZoneIp ));
						//ZoneTextLog.append("Lancement putty ssh pour " + ZoneIp.getText()  );
			            //ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
						
						Boolean LanceUneFois = true;
			            
			             if (BoutonRadioRoot.isSelected() == true && LanceUneFois == true ) {
			            	 
			            	 	Runtime.getRuntime().exec(String.format("D:\\AlphaPilote\\Putty.exe " + TextZoneIp +" -ssh -l root"));
			            	 	ZoneTextLog.append("Lancement putty ssh vers " + ZoneIp.getText() + " avec le user root" );
					            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					            LanceUneFois = false;
					            MesBoutonsLogin.clearSelection();
					       
			             }
			             		             		             
			             if (BoutonRadioSalle.isSelected() == true && LanceUneFois == true ) {
			            	 
			            	 	Runtime.getRuntime().exec(String.format("D:\\AlphaPilote\\Putty.exe " + TextZoneIp +" -ssh -l salle"));
			            	 	ZoneTextLog.append("Lancement putty ssh vers " + ZoneIp.getText() + " avec le user salle" );
					            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					            LanceUneFois = false;
					            MesBoutonsLogin.clearSelection();
			             }
					            
					     if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == false) {
					            	 
				            	 	String EtatBouton = BoutonRadioUserPerso.getText();
				            	 	Runtime.getRuntime().exec(String.format("D:\\AlphaPilote\\Putty.exe " + TextZoneIp +" -ssh -l "+EtatBouton));
				            	 	ZoneTextLog.append("Lancement putty ssh vers " + ZoneIp.getText() + " avec le user " + BoutonRadioUserPerso.getText() );
						            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
						            LanceUneFois = false;
						            MesBoutonsLogin.clearSelection();
				            	     
				             }
				             
				          if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == true) {
				            	 	
				            	 	String EtatBouton = BoutonRadioUserPerso.getText();
				            	 	Runtime.getRuntime().exec(String.format("D:\\AlphaPilote\\Putty.exe " + TextZoneIp +" -ssh -l "+EtatBouton));
				            	 	ZoneTextLog.append("Lancement putty ssh vers " + ZoneIp.getText() + " avec le user " +EtatBouton+" et le mot de passe" );
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
			            	 	Runtime.getRuntime().exec(String.format("D:\\AlphaPilote\\Putty.exe -ssh " + TextZoneIp ));
			            	 	ZoneTextLog.append("Lancement putty ssh vers " + ZoneIp.getText());
			            	 	ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
			            	 	LanceUneFois = false;
			            	 	MesBoutonsLogin.clearSelection();
					         
			             }
			             CheckBoxPassword.setState(false);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						ZoneTextLog.append("Erreur, impossible de trouver putty.exe dans D:\\AlphaPilote");
	            	 	ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						ZoneTextLog.append("Erreur du robot pour taper le mot de passe");
	            	 	ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
					}
			            
				
			}
		});
		BoutonValideTelnet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				//final String CHEMIN = "D:\\";
				String TextZoneIp = ZoneIp.getText();
				
				try {
					
		            Boolean LanceUneFois = true;
		            
		             if (BoutonRadioRoot.isSelected() == true && LanceUneFois == true ) {
		            	 
		            	 	Runtime.getRuntime().exec(String.format("D:\\AlphaPilote\\Putty.exe " + TextZoneIp +" -telnet -l root"));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + ZoneIp.getText() + " avec le user root" );
				            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				            LanceUneFois = false;
				            MesBoutonsLogin.clearSelection();
				            
		            	     
		             }
		             		             		             
		             if (BoutonRadioSalle.isSelected() == true && LanceUneFois == true ) {
		            	 
		            	 	Runtime.getRuntime().exec(String.format("D:\\AlphaPilote\\Putty.exe " + TextZoneIp +" -telnet -l salle"));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + ZoneIp.getText() + " avec le user salle" );
				            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				            LanceUneFois = false;
				            MesBoutonsLogin.clearSelection();
		            	     
		             }
		             
		             if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == false) {
		            	 
		            	 	String EtatBouton = BoutonRadioUserPerso.getText();
		            	 	Runtime.getRuntime().exec(String.format("D:\\AlphaPilote\\Putty.exe " + TextZoneIp +" -telnet -l "+EtatBouton));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + ZoneIp.getText() + " avec le user " + BoutonRadioUserPerso.getText() );
				            ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				            LanceUneFois = false;
				            MesBoutonsLogin.clearSelection();
		            	     
		             }
		             
		             if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == true) {
		            	 	
		            	 	String EtatBouton = BoutonRadioUserPerso.getText();
		            	 	Runtime.getRuntime().exec(String.format("D:\\AlphaPilote\\Putty.exe " + TextZoneIp +" -telnet -l "+EtatBouton));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + ZoneIp.getText() + " avec le user " +EtatBouton+" et le mot de passe" );
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
		            	 	Runtime.getRuntime().exec(String.format("D:\\AlphaPilote\\Putty.exe -telnet " + TextZoneIp ));
		            	 	ZoneTextLog.append("Lancement putty telnet vers " + ZoneIp.getText());
		            	 	ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
		            	 	LanceUneFois = false;
		            	 	MesBoutonsLogin.clearSelection();
		             }
		             // Lancement avec User perso, à faire quand la config remontera le user UNIX
		             	             
		       		            
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ZoneTextLog.append("Erreur, impossible de trouver putty.exe dans D:\\AlphaPilote");
            	 	ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ZoneTextLog.append("Erreur du robot pour taper le mot de passe");
            	 	ZoneTextLog.setText (ZoneTextLog.getText() + "\n");
				}
				
				
		    
			}
	
		});
		BoutonValideIp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
								
				ResultatPing.setForeground(Color.GRAY);
				String TextZoneIp = ZoneIp.getText();
				
				TextZoneIp = TextZoneIp + "\"";
				//System.out.println(TextZoneIp);	
				
				StringBuffer StringFinal = new StringBuffer (TextZoneIp);  
				String guillemet = "\"ping ";  
				StringFinal.insert (0, guillemet);  
				TextZoneIp = StringFinal.toString();	
				//System.out.println (TextZoneIp); 	
				
				final String CHEMIN = "D:\\";
			    
			        try {
			        	//System.setOut(new PrintStream(System.out, true, "IBM850"));
			        	ResultatPing.setForeground(Color.GRAY);
			            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", TextZoneIp, " -n 1");
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
			            
			            ZoneTextLog.append("Ping vers " + ZoneIp.getText() + " en cours ...");
			            ZoneTextLog.setText(ZoneTextLog.getText() + "\n");
			         
			            //MaBarreProgression.setValue(0);
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
			            e1.printStackTrace();
			            ZoneTextLog.append("PING KO - Echec de la commande");
			            ZoneTextLog.setText(ZoneTextLog.getText() + "\n");
			            
			         } catch (InterruptedException e1) {
						// TODO Auto-generated catch block
			        	 ZoneTextLog.append("PING KO - Echec de la commande");
				         ZoneTextLog.setText(ZoneTextLog.getText() + "\n");
						e1.printStackTrace();
					}
			    }				
		
		});
		
		ZoneIp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				AWTEvent mouseReleased;
				
				BoutonValideIp.getMouseListeners();
				
				//ZoneTextLog.append(BoutonValideIp.getMouseListeners());
				//BoutonValideIp.dispatchEvent();
				//mouseReleased(MouseEvent e) {
			}
		});
		
		
	}
		
	public String getZoneIpText() {
		return ZoneIp.getText();
		
	}
	public void setZoneIpText(String text) {
		ZoneIp.setText(text);
	}
}

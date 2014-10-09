import java.awt.AWTException;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
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
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class UserInterface extends JFrame implements ActionListener {
	/**
	 * @category Variables
	 */

	Component LastEntered;
	private static final long serialVersionUID = 1L;

	private JComboBox<?> MaComboBox;
	private String MachineDansMaComboBox;
	private JTextArea ZoneTextLog;
	private String UserNameStation = "Username non reconnu";
	private Boolean SuccesCreation = false;
	private JMenuItem MenuSysa;
	private JMenuItem MenuKmvs;
	private JMenuItem MenuZmvs;
	private JMenuItem MenuGmvs;
	private JMenuItem MenuSysg;
	private JMenuItem MenuQuick3270;
	private JRadioButton BoutonRadioRoot;
	private JRadioButton BoutonRadioSalle;
	private JRadioButton BoutonRadioUserPerso;
	private ButtonGroup MesBoutonsLogin;
	private JButton BoutonConnexionTelnetOuSsh;
	private Checkbox CheckBoxPassword;
	private JButton BoutonValideIp;
	private JButton BoutonValideTelnet;
	private JButton BoutonValideSsh;
	public Thread LeThreadInterface;
	public JProgressBar ProgressBarExecutionGlobale;
	public Point PositionFenetrePrincipale;
	private JMenu MenuFichier;
	private JLabel ResultatPing;
	private JLabel LabelUtilisationMemoire;
	private JMenuItem MenuAS400Br;
	private JMenuItem MenuAS400Bdi;
	private JMenuItem MenuAS400Bdaf;
	private JMenuItem MenuAS400Socly;
	private JMenuItem MenuSocmcsd;
	private JMenuItem MenuPfbcly;
	private JMenuItem MenuOdip;
	private JMenuItem MenuBbr;
	private JMenuItem MenuIpLabel;
	private JMenuItem MenuNewtest;
	private JMenuItem MenuOseIp1;
	private JMenuItem MenuOseIp2;
	private JMenuItem MenuXguard;
	private JMenuItem MenuIp1;
	private JMenuItem MenuIp2;
	private JMenuItem MenuIp3;
	private JMenuItem MenuBmvs;
	private JLabel LabelNombreThread;
	private JMenuItem MenuHmc;
	private JMenuItem MenuKvm;
	private JMenuItem MenuTina5;
	private JMenuItem MenuTina6;
	private JMenuItem MenuVcenter;
	private JMenuItem MenuSismoIp1;
	private JMenuItem MenuSismoIp2;
	private JMenuItem MenuSismoOceor;
	private JMenuItem MenuSismoPalatine;
	private JMenu MenuFavoris;
	private JMenuItem MenuArsV8;
	private JMenuItem MenuWebIas;
	private JMenuItem MenuCfta;
	private JMenuItem MenuCftacore;
	private JMenuItem MenuArsCff;
	private String MonIp = "";
	private JLabel LabelAdresseIp;
	private Boolean GainedFocus = false;
	private JMenuItem MenuArsRemedy;
	private JMenuItem MenuPuttyCm;
	private JMenuItem MenuTinaIp1Siris;
	private JMenuItem MenuTinaIp1Tinap203;
	private JMenuItem mntmTina;
	private JMenu MenuFavorisCommuns;
	private JMenuItem MenuEditionFavoris;
	private JMenu MenuParametresHaut;
	private JLabel LabelDateHeure;
	private CatchKeyboardEvent CK;
	private JLabel LabelCapture;
	private JLabel LabelConnexion;
	private JLabel LabelDetectionDoublon;
	private JLabel LabelConsignes;
	private JLabel LabelChargementProfil;
	private int PositionInterfaceX;
	private int PositionInterfaceY;
	GestionProduits LanceProduit = new GestionProduits();
	private JMenuItem MenuSauvegarderLaPosition;
	private JCheckBoxMenuItem MenuItceParisBercy;
	private JCheckBoxMenuItem MenuBourglareine;
	private JSeparator separator_5;
	private int Session = 1;
	private JLabel LabelProfile;
	public JLabel LabelImageRessources;
	private JLabel LabelLancementAuto;
	private JButton BoutonCancel;
	private Boolean BoutonCancelVar = false;

	public UserInterface() {
		addWindowFocusListener(new WindowFocusListener() {
			@Override
			public void windowGainedFocus(WindowEvent arg0) {
				if (GainedFocus == true) {
					new Thread(new ThreadRechargementConfigInterface()).start();
					MenuFavorisCommuns.removeAll();
					new Thread(new ThreadChargementFavoris()).start();
					GainedFocus = false;
					try {
						ReloadRaccourcis();
						MajAffichageRaccourcis();
					}
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

			@Override
			public void windowLostFocus(WindowEvent arg0) {
			}
		});

		// ------------HOOK

		// ----------------

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setIconImage(Toolkit.getDefaultToolkit().getImage(UserInterface.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		UserNameStation = System.getProperty("user.name");
		setTitle("AlphaPilote - Pr\u00EAt \u00E0 demembrer pour " + UserNameStation);
		// setAlwaysOnTop(true);

		setSize(790, 570);

		LirePositionFenetreConfig();
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				MiseAjourPositionFenetre();

			}
		});

		GestionSessions GS = new GestionSessions();

		JMenuBar BarreMenuPrincipale = new JMenuBar();
		setJMenuBar(BarreMenuPrincipale);

		MenuFichier = new JMenu("Fichier");
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

				TestAccesFichier();

			}
		});

		MenuSauvegarderLaPosition = new JMenuItem("Sauvegarder position de la fen\u00EAtre");
		MenuSauvegarderLaPosition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				GestionSql LaBase = new GestionSql();
				Connection ConnectionBase = LaBase.InitConnexion();

				String ValeurX = Integer.toString(PositionInterfaceX);
				LaBase.AjoutDonneePilote(ConnectionBase, "PositionFenetreX", ValeurX);
				String ValeurY = Integer.toString(PositionInterfaceY);
				LaBase.AjoutDonneePilote(ConnectionBase, "PositionFenetreY", ValeurY);
				ZoneTextLog.append("Position d'AlphaPilote sauvegardée." + "\n");
				LaBase.FermerConnexion(ConnectionBase);

			}
		});
		final ImageIcon IconSave = new ImageIcon(getClass().getResource("/save-icon.png"));
		MenuSauvegarderLaPosition.setIcon(IconSave);
		MenuFichier.add(MenuSauvegarderLaPosition);
		MenuTestAccesFichiers.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		MenuFichier.add(MenuTestAccesFichiers);

		JSeparator separator_4 = new JSeparator();
		MenuFichier.add(separator_4);
		MenuFichier.add(MenuQuitter);

		JSeparator SeparateurFichierFavoris = new JSeparator();
		SeparateurFichierFavoris.setPreferredSize(new Dimension(0, 10));
		SeparateurFichierFavoris.setMaximumSize(new Dimension(5, 100));
		SeparateurFichierFavoris.setOrientation(SwingConstants.VERTICAL);
		BarreMenuPrincipale.add(SeparateurFichierFavoris);

		MenuFavoris = new JMenu("Favoris web");
		BarreMenuPrincipale.add(MenuFavoris);

		JScrollPane ScrollZoneTextLog = new JScrollPane();
		ScrollZoneTextLog.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ScrollZoneTextLog.setViewportBorder(new TitledBorder(null, "Log", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		ScrollZoneTextLog.setBounds(10, 291, 478, 201);
		getContentPane().add(ScrollZoneTextLog);

		ZoneTextLog = new JTextArea();
		ZoneTextLog.setForeground(new Color(0, 0, 0));
		ScrollZoneTextLog.setViewportView(ZoneTextLog);
		ZoneTextLog.setWrapStyleWord(true);
		ZoneTextLog.setLineWrap(true);
		ZoneTextLog.setFont(new Font("Verdana", Font.PLAIN, 11));
		ZoneTextLog.setBackground(Color.LIGHT_GRAY);
		ZoneTextLog.setEditable(false);
		// DefaultCaret caret = (DefaultCaret) ZoneTextLog.getCaret();
		ZoneTextLog.setCaretPosition(ZoneTextLog.getDocument().getLength());
		DefaultCaret caret = (DefaultCaret) ZoneTextLog.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		JMenu MenuOutils = new JMenu("Outils");
		BarreMenuPrincipale.add(MenuOutils);

		JMenuItem MenuPutty = new JMenuItem("Putty");
		final ImageIcon IconPutty = new ImageIcon(getClass().getResource("/putty-icon.png"));
		MenuPutty.setIcon(IconPutty);
		MenuPutty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				if (LanceProduit.LancePutty() == true) {
					ZoneTextLog.append("Lancement de putty." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");
				}

			}
		});

		JMenuItem MenuOutlook = new JMenuItem("Outlook 2014");
		final ImageIcon IconOutlook = new ImageIcon(getClass().getResource("/Outlook-icon.png"));
		MenuOutlook.setIcon(IconOutlook);

		MenuOutlook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceOutlook() == true) {
					ZoneTextLog.append("Lancement d'outlook." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au d'Outlook : Consulter la log." + "\n");
				}

			}
		});
		MenuOutils.add(MenuOutlook);

		JMenuItem MenuControlm = new JMenuItem("Control-M");
		final ImageIcon IconConstromlm = new ImageIcon(getClass().getResource("/Controlm-icon.png"));
		MenuControlm.setIcon(IconConstromlm);
		MenuControlm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				try {
					if (LanceProduit.LanceControlm() == true) {
						ZoneTextLog.append("Lancement de Control-m." + "\n");
					}
					else {
						ZoneTextLog.append("Erreur au lancement de control-m: Consulter la log." + "\n");
					}
				}
				catch (IOException e) {
					ZoneTextLog.append("Erreur au lancement de control-m: Consulter la log." + "\n");
					e.printStackTrace();
				}

			}
		});
		MenuOutils.add(MenuControlm);

		JMenuItem MenuIprox = new JMenuItem("Iprox");
		final ImageIcon IconIprox = new ImageIcon(getClass().getResource("/iprox-icon.png"));
		MenuIprox.setIcon(IconIprox);
		MenuIprox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceIprox() == true) {
					ZoneTextLog.append("Lancement d'Iprox." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement d'Iprox : Consulter la log." + "\n");
				}

			}
		});
		MenuOutils.add(MenuIprox);

		MenuArsRemedy = new JMenuItem("ARSv7 Remedy");
		final ImageIcon IconArsRemedy = new ImageIcon(getClass().getResource("/ars-icon.png"));
		MenuArsRemedy.setIcon(IconArsRemedy);
		MenuArsRemedy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceArsRemedy() == true) {
					ZoneTextLog.append("Ouverture d'ARS Remedy v7." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement ARS Remedy v7 : Consulter la log." + "\n");
				}

			}
		});
		MenuOutils.add(MenuArsRemedy);

		MenuArsV8 = new JMenuItem("ARSv8 (client l\u00E9ger)");
		MenuArsV8.setIcon(IconArsRemedy);
		MenuArsV8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				if (LanceProduit.LanceArsV8() == true) {
					ZoneTextLog.append("Ouverture d'ARS Remedy v8 (web)." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement ARS Remedy v8 : Consulter la log." + "\n");
				}
			}
		});
		MenuOutils.add(MenuArsV8);

		MenuArsCff = new JMenuItem("ARS Cff");
		MenuArsCff.setIcon(IconArsRemedy);
		MenuArsCff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceArsCff() == true) {
					ZoneTextLog.append("Ouverture d'ARS CFF." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement ARS CFF : Consulter la log." + "\n");
				}
			}
		});
		MenuOutils.add(MenuArsCff);
		MenuOutils.add(MenuPutty);

		MenuQuick3270 = new JMenuItem("Quick3270");
		final ImageIcon IconQuick3270 = new ImageIcon(getClass().getResource("/quick3270-icon.png"));
		MenuQuick3270.setIcon(IconQuick3270);
		MenuQuick3270.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				GestionChemin Chemin = new GestionChemin();
				GestionLog MaLog = new GestionLog();
				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270") });
				try {
					builder.start();
				}
				catch (IOException e1) {

					e1.printStackTrace();
					MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " + e1);
					ZoneTextLog.append("Erreur au lancement de Putty : Consulter la log." + "\n");

				}

			}
		});

		MenuPuttyCm = new JMenuItem("Putty CM");
		final ImageIcon IconPuttyCm = new ImageIcon(getClass().getResource("/puttycm-icon.png"));
		MenuPuttyCm.setIcon(IconPuttyCm);
		MenuPuttyCm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				if (LanceProduit.LancePuttyCm() == true) {
					ZoneTextLog.append("Lancement de Putty CM." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de Putty Connection Manager: Consulter la log." + "\n");
				}
			}

		});
		MenuOutils.add(MenuPuttyCm);

		JMenuItem MenuMremote = new JMenuItem("mRemote");
		MenuMremote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				if (LanceProduit.LanceMremote() == true) {
					ZoneTextLog.append("Lancement d'mRemote." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de mRemote: Consulter la log." + "\n");
				}
			}
		});
		final ImageIcon IconMremote = new ImageIcon(getClass().getResource("/icon-mremote.png"));
		MenuMremote.setIcon(IconMremote);
		MenuOutils.add(MenuMremote);
		MenuOutils.add(MenuQuick3270);

		JMenu mnVtom = new JMenu("Vtom");
		final ImageIcon IconVtomSelected = new ImageIcon(getClass().getResource("/arrow-down.gif"));
		mnVtom.setSelectedIcon(IconVtomSelected);
		mnVtom.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		MenuOutils.add(mnVtom);

		JMenuItem MenuVtomIp1q = new JMenuItem("IP1 UP2TO002");
		final ImageIcon IconVtom = new ImageIcon(getClass().getResource("/vtom-icon.png"));
		MenuVtomIp1q.setIcon(IconVtom);
		MenuVtomIp1q.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceVtomIp1q() == true) {
					ZoneTextLog.append("Lancement de VTOM UP2TO002." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de VTOM UP2TO002: Consulter la log." + "\n");
				}

			}
		});
		mnVtom.add(MenuVtomIp1q);

		JMenuItem MenuVtomIp1d = new JMenuItem("IP1 UP2TO003");
		MenuVtomIp1d.setIcon(IconVtom);
		MenuVtomIp1d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceVtomIp1d() == true) {
					ZoneTextLog.append("Lancement de VTOM UP2TO003." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de VTOM UP2TO003: Consulter la log." + "\n");
				}
			}
		});
		mnVtom.add(MenuVtomIp1d);

		JSeparator separator_2 = new JSeparator();
		mnVtom.add(separator_2);

		JMenuItem MenuVtomIp2q = new JMenuItem("IP2 UP1TO002");
		MenuVtomIp2q.setIcon(IconVtom);
		MenuVtomIp2q.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceVtomIp2q() == true) {
					ZoneTextLog.append("Lancement de VTOM UP1TO002." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de VTOM UP1TO002: Consulter la log." + "\n");
				}
			}
		});
		mnVtom.add(MenuVtomIp2q);

		JMenuItem MenuVtomIp2d = new JMenuItem("IP2 UP1TO003");
		MenuVtomIp2d.setIcon(IconVtom);
		MenuVtomIp2d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceVtomIp2d() == true) {
					ZoneTextLog.append("Lancement de VTOM IP1TO003." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de VTOM IP1TO003: Consulter la log." + "\n");
				}
			}

		});
		mnVtom.add(MenuVtomIp2d);

		JMenu MenuTinaExceed = new JMenu("Tina(+Exceed)");
		MenuTinaExceed.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		MenuOutils.add(MenuTinaExceed);

		JMenuItem MenuExceed = new JMenuItem("Exceed");
		// MenuExceed.setIcon(new
		// ImageIcon(UserInterface.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		final ImageIcon IconExceed = new ImageIcon(getClass().getResource("/exceed-icon.PNG"));
		MenuExceed.setIcon(IconExceed);
		MenuExceed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				if (LanceProduit.LanceExceed() == true) {
					ZoneTextLog.append("Lancement d'exceed." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement d'exceed Manager: Consulter la log." + "\n");
				}
			}
		});
		MenuTinaExceed.add(MenuExceed);

		JMenuItem MenuCltec5 = new JMenuItem("Tina Cltec5");
		final ImageIcon IconTina5 = new ImageIcon(getClass().getResource("/tina-icon.jpg"));
		MenuCltec5.setIcon(IconTina5);
		MenuCltec5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				if (LanceProduit.LanceTinaCltec5() == true) {
					ZoneTextLog.append("Lancement de Tina Cltec5." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de Tina Cltec5: Consulter la log." + "\n");
				}

			}
		});
		MenuTinaExceed.add(MenuCltec5);

		JMenuItem mntmTinaCltec = new JMenuItem("Tina Cltec6");
		mntmTinaCltec.setIcon(IconTina5);
		mntmTinaCltec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceTinaCltec6() == true) {
					ZoneTextLog.append("Lancement de Tina Cltec6." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de Tina Cltec6: Consulter la log." + "\n");
				}
			}
		});
		MenuTinaExceed.add(mntmTinaCltec);

		MenuTinaIp1Siris = new JMenuItem("Tina UP2TS004 (IP1- Siris1)");
		MenuTinaIp1Siris.setIcon(IconTina5);
		MenuTinaIp1Siris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new Thread(new LanceTinaSiris1()).start();
			}
		});
		MenuTinaExceed.add(MenuTinaIp1Siris);

		MenuTinaIp1Tinap203 = new JMenuItem("Tina UP2TS004 (IP1 - Tinap203)");
		MenuTinaIp1Tinap203.setIcon(IconTina5);
		MenuTinaIp1Tinap203.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new Thread(new LanceTinaTinap203()).start();

			}
		});
		MenuTinaExceed.add(MenuTinaIp1Tinap203);

		mntmTina = new JMenuItem("Tina UP1TS004 (IP2 - Tinap105 & 102)");
		mntmTina.setIcon(IconTina5);
		mntmTina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				new Thread(new LanceTinaTinap105103()).start();

			}
		});
		MenuTinaExceed.add(mntmTina);

		JMenu MenuCFT = new JMenu("CFT");
		MenuCFT.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		MenuOutils.add(MenuCFT);

		MenuCfta = new JMenuItem("CFTA");
		MenuCfta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceCfta() == true) {
					ZoneTextLog.append("Ouverture de CFTA." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de CFTA : Consulter la log." + "\n");
				}
			}
		});
		MenuCFT.add(MenuCfta);

		MenuCftacore = new JMenuItem("CFTACORE");
		MenuCftacore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceCftacore() == true) {
					ZoneTextLog.append("Ouverture de CFTACORE." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de CFTACORE : Consulter la log." + "\n");
				}
			}
		});
		MenuCFT.add(MenuCftacore);

		JMenu mnDivers = new JMenu("Divers");
		final ImageIcon IconmnDivers = new ImageIcon(getClass().getResource("/icon-divers.png"));
		mnDivers.setIcon(IconmnDivers);
		MenuOutils.add(mnDivers);

		JMenuItem MenuPartageDocIprox = new JMenuItem("Partage doc Iprox");
		MenuPartageDocIprox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LancePartageIprox() == true) {
					ZoneTextLog.append("Montage lecteurs documents Iprox..." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au montage du lecteur Iprox : Consulter la log." + "\n");
				}
			}
		});
		mnDivers.add(MenuPartageDocIprox);

		JMenu MenuConnexionMvs = new JMenu("Consoles");
		BarreMenuPrincipale.add(MenuConnexionMvs);

		JMenu SousMenuConnexionMvs = new JMenu("MVS");
		SousMenuConnexionMvs.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		MenuConnexionMvs.add(SousMenuConnexionMvs);

		MenuZmvs = new JMenuItem("Zmvs (CFF)");
		final ImageIcon IconZmvs = new ImageIcon(getClass().getResource("/Letter-Z-icon.png"));
		MenuZmvs.setIcon(IconZmvs);
		MenuZmvs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				if (LanceProduit.LanceZmvs() == true) {

					ZoneTextLog.append("Lancement de ZMVS." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de ZMVS: Consulter la log." + "\n");
				}

			}
		});

		MenuSysa = new JMenuItem("Sysa");
		final ImageIcon IconSysa = new ImageIcon(getClass().getResource("/Letter-A-blue-icon.png"));
		MenuSysa.setIcon(IconSysa);
		MenuSysa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceSysa() == true) {

					ZoneTextLog.append("Lancement de SYSA." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de SYSA: Consulter la log." + "\n");
				}

			}
		});
		SousMenuConnexionMvs.add(MenuSysa);

		MenuKmvs = new JMenuItem("Kmvs (IP0)");
		final ImageIcon IconKmvs = new ImageIcon(getClass().getResource("/Letter-K-red-icon.png"));
		MenuKmvs.setIcon(IconKmvs);
		MenuKmvs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				if (LanceProduit.LanceKmvs() == true) {

					ZoneTextLog.append("Lancement de KMVS." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de KMVS: Consulter la log." + "\n");
				}

			}
		});

		MenuSysg = new JMenuItem("Sysg (XENOS)");
		final ImageIcon IconSysg = new ImageIcon(getClass().getResource("/g-icon.png"));
		MenuSysg.setIcon(IconSysg);
		MenuSysg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceSysg() == true) {

					ZoneTextLog.append("Lancement de SYSG." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de SYSG: Consulter la log." + "\n");
				}

			}

		});
		SousMenuConnexionMvs.add(MenuSysg);
		SousMenuConnexionMvs.add(MenuKmvs);
		SousMenuConnexionMvs.add(MenuZmvs);

		JSeparator SeparateurMenuConnexionMvs = new JSeparator();
		SousMenuConnexionMvs.add(SeparateurMenuConnexionMvs);

		MenuIp1 = new JMenuItem("IP1");
		final ImageIcon IconIp1 = new ImageIcon(getClass().getResource("/1-icon.png"));
		MenuIp1.setIcon(IconIp1);
		MenuIp1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceIp1() == true) {

					ZoneTextLog.append("Lancement de IP1." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de IP1: Consulter la log." + "\n");
				}
			}
		});
		SousMenuConnexionMvs.add(MenuIp1);

		MenuIp2 = new JMenuItem("IP2");
		final ImageIcon IconIp2 = new ImageIcon(getClass().getResource("/2-icon.png"));
		MenuIp2.setIcon(IconIp2);
		MenuIp2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceIp2() == true) {

					ZoneTextLog.append("Lancement de IP2." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de IP2: Consulter la log." + "\n");
				}
			}
		});
		SousMenuConnexionMvs.add(MenuIp2);

		MenuIp3 = new JMenuItem("IP3");
		final ImageIcon IconIp3 = new ImageIcon(getClass().getResource("/3_icon.png"));
		MenuIp3.setIcon(IconIp3);
		MenuIp3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceIp3() == true) {

					ZoneTextLog.append("Lancement de IP3." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de IP3: Consulter la log." + "\n");
				}
			}
		});
		SousMenuConnexionMvs.add(MenuIp3);

		JSeparator separator_3 = new JSeparator();
		SousMenuConnexionMvs.add(separator_3);

		MenuGmvs = new JMenuItem("TPX Gmvs");
		SousMenuConnexionMvs.add(MenuGmvs);

		MenuGmvs.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaVolumeThumb.png")));

		MenuBmvs = new JMenuItem("Bmvs (Recette IP0)");
		final ImageIcon IconBmvs = new ImageIcon(getClass().getResource("/B_icon.png"));
		MenuBmvs.setIcon(IconBmvs);
		MenuBmvs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceBmvs() == true) {

					ZoneTextLog.append("Lancement de BMVS." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de BMVS: Consulter la log." + "\n");
				}
			}
		});
		SousMenuConnexionMvs.add(MenuBmvs);

		JMenu MenuAS400 = new JMenu("AS400");
		MenuAS400.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		MenuConnexionMvs.add(MenuAS400);

		MenuAS400Br = new JMenuItem("BRCLY");
		final ImageIcon IconAS400Br = new ImageIcon(getClass().getResource("/as400-icon.png"));
		MenuAS400Br.setIcon(IconAS400Br);
		MenuAS400Br.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				if (LanceProduit.LanceAs400Br() == true) {

					ZoneTextLog.append("Lancement de AS400BR." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de AS400BR: Consulter la log." + "\n");
				}
			}
		});
		MenuAS400.add(MenuAS400Br);

		MenuAS400Bdi = new JMenuItem("BDICLY");
		final ImageIcon IconAS400Bdi = new ImageIcon(getClass().getResource("/as400-icon.png"));
		MenuAS400Bdi.setIcon(IconAS400Bdi);
		MenuAS400Bdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceAs400Bdi() == true) {

					ZoneTextLog.append("Lancement de AS400BDI." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de AS400BDI: Consulter la log." + "\n");
				}
			}
		});
		MenuAS400.add(MenuAS400Bdi);

		MenuAS400Bdaf = new JMenuItem("BDAFCLY");
		final ImageIcon IconAS400Bdaf = new ImageIcon(getClass().getResource("/as400-icon.png"));
		MenuAS400Bdaf.setIcon(IconAS400Bdaf);
		MenuAS400Bdaf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceAs400Bdaf() == true) {

					ZoneTextLog.append("Lancement de AS400BDAF." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de AS400BDAF: Consulter la log." + "\n");
				}
			}
		});
		MenuAS400.add(MenuAS400Bdaf);

		JSeparator separator = new JSeparator();
		MenuAS400.add(separator);

		MenuAS400Socly = new JMenuItem("SOCLY");
		final ImageIcon IconAS400Socly = new ImageIcon(getClass().getResource("/as400-icon.png"));
		MenuAS400Socly.setIcon(IconAS400Socly);
		MenuAS400Socly.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceAs400Socly() == true) {

					ZoneTextLog.append("Lancement de AS400SOCLY." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de AS400SOCLY: Consulter la log." + "\n");
				}
			}
		});
		MenuAS400.add(MenuAS400Socly);

		MenuSocmcsd = new JMenuItem("SOCMCSD");
		final ImageIcon IconAS400Socmscd = new ImageIcon(getClass().getResource("/as400-icon.png"));
		MenuSocmcsd.setIcon(IconAS400Socmscd);
		MenuSocmcsd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceAs400Socmcsd() == true) {

					ZoneTextLog.append("Lancement de AS400SOCMCSD." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de AS400SOCMCSD: Consulter la log." + "\n");
				}
			}
		});
		MenuAS400.add(MenuSocmcsd);

		JSeparator separator_1 = new JSeparator();
		MenuAS400.add(separator_1);

		MenuPfbcly = new JMenuItem("PFBCLY");
		final ImageIcon IconAS400Pfb = new ImageIcon(getClass().getResource("/as400-icon.png"));
		MenuPfbcly.setIcon(IconAS400Pfb);
		MenuPfbcly.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceAs400Pfb() == true) {

					ZoneTextLog.append("Lancement de AS400PFB." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de AS400PFB: Consulter la log." + "\n");
				}
			}
		});
		MenuAS400.add(MenuPfbcly);

		MenuGmvs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				if (LanceProduit.LanceGmvs() == true) {

					ZoneTextLog.append("Lancement de GMVS." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur au lancement de GMVS: Consulter la log." + "\n");
				}
			}
		});
		getContentPane().setLayout(null);

		JPanel PaneZoneConnexion = new JPanel();
		PaneZoneConnexion.setSize(new Dimension(10, 10));
		PaneZoneConnexion.setOpaque(false);
		PaneZoneConnexion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Connexion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 149, 237)));
		PaneZoneConnexion.setBounds(10, 2, 325, 201);
		getContentPane().add(PaneZoneConnexion);
		PaneZoneConnexion.setLayout(null);

		BoutonValideIp = new JButton("Ping");
		BoutonValideIp.setBounds(226, 16, 72, 23);
		PaneZoneConnexion.add(BoutonValideIp);

		BoutonValideTelnet = new JButton("Telnet");
		BoutonValideTelnet.setVisible(false);
		BoutonValideTelnet.setMargin(new Insets(0, 0, 0, 0));
		BoutonValideTelnet.setBounds(198, 145, 50, 23);
		PaneZoneConnexion.add(BoutonValideTelnet);

		BoutonValideSsh = new JButton("SSH");
		BoutonValideSsh.setVisible(false);
		BoutonValideSsh.setMargin(new Insets(0, 0, 0, 0));
		BoutonValideSsh.setBounds(258, 145, 37, 23);
		PaneZoneConnexion.add(BoutonValideSsh);

		MenuOdip = new JMenuItem("ODIP");

		final ImageIcon IconOdip = new ImageIcon(getClass().getResource("/odip-icon.png"));

		MenuFavorisCommuns = new JMenu("Favoris Communs");
		final ImageIcon IconBoutonRechargerFavoris2 = new ImageIcon(getClass().getResource("/rsz_1legendary-marker_1.png"));
		MenuFavorisCommuns.setIcon(IconBoutonRechargerFavoris2);
		MenuFavoris.add(MenuFavorisCommuns);
		MenuOdip.setIcon(IconOdip);
		MenuFavoris.add(MenuOdip);
		MenuOdip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				if (LanceProduit.LanceOdip() == true) {
					ZoneTextLog.append("Ouverture d'ODIP." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement d'ODIP : Consulter la log." + "\n");
				}

			}
		});

		MenuBbr = new JMenuItem("BBR(Buisness Bridge)");
		final ImageIcon IconBbr = new ImageIcon(getClass().getResource("/bbr-icon.png"));
		MenuBbr.setIcon(IconBbr);
		MenuBbr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (LanceProduit.LanceBbr() == true) {
					ZoneTextLog.append("Ouverture de BBR." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de BBR : Consulter la log." + "\n");
				}
			}
		});
		MenuFavoris.add(MenuBbr);

		MenuOseIp1 = new JMenuItem("OSE ip1");
		final ImageIcon IconOseIp1 = new ImageIcon(getClass().getResource("/ose-icon.png"));
		MenuOseIp1.setIcon(IconOseIp1);
		MenuOseIp1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceOseIp1() == true) {
					ZoneTextLog.append("Ouverture d'OSE IP1." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement D'OSE IP1 : Consulter la log." + "\n");
				}

			}
		});
		MenuFavoris.add(MenuOseIp1);

		MenuOseIp2 = new JMenuItem("OSE ip2");
		final ImageIcon IconOseip2 = new ImageIcon(getClass().getResource("/ose-icon.png"));
		MenuOseIp2.setIcon(IconOseip2);
		MenuOseIp2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceOseIp2() == true) {
					ZoneTextLog.append("Ouverture d'OSE IP2." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement d'OSE IP2 : Consulter la log." + "\n");
				}
			}
		});
		MenuFavoris.add(MenuOseIp2);

		MenuIpLabel = new JMenuItem("ip-Label");
		final ImageIcon IconIpLabel = new ImageIcon(getClass().getResource("/iplabel-icon.png"));
		MenuIpLabel.setIcon(IconIpLabel);
		MenuIpLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceIpLabel() == true) {
					ZoneTextLog.append("Ouverture d'Ip-Label." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement d'Ip-Label : Consulter la log." + "\n");
				}
			}
		});
		MenuFavoris.add(MenuIpLabel);

		MenuNewtest = new JMenuItem("Newtest");
		final ImageIcon IconNewtest = new ImageIcon(getClass().getResource("/newtest-icon.png"));
		MenuNewtest.setIcon(IconNewtest);
		MenuNewtest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceNewtest() == true) {
					ZoneTextLog.append("Ouverture de Newtest." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de Newtest : Consulter la log." + "\n");
				}
			}
		});
		MenuFavoris.add(MenuNewtest);

		MenuXguard = new JMenuItem("Xguard");
		final ImageIcon IconXguard = new ImageIcon(getClass().getResource("/xguard-icon.png"));
		MenuXguard.setIcon(IconXguard);
		MenuXguard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceXguard() == true) {
					ZoneTextLog.append("Ouverture d'Xguard" + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement d'Xguard : Consulter la log." + "\n");
				}
			}
		});
		MenuFavoris.add(MenuXguard);

		MenuHmc = new JMenuItem("HMC web1");
		final ImageIcon IconHmc = new ImageIcon(getClass().getResource("/hmc-icon.PNG"));
		MenuHmc.setIcon(IconHmc);
		MenuHmc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceHmc() == true) {
					ZoneTextLog.append("Ouverture de la HMC." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de la HMC : Consulter la log." + "\n");
				}
			}
		});
		MenuFavoris.add(MenuHmc);

		MenuKvm = new JMenuItem("KVM");
		final ImageIcon IconKvm = new ImageIcon(getClass().getResource("/kvm-icon.PNG"));
		MenuKvm.setIcon(IconKvm);
		MenuKvm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceKvm() == true) {
					ZoneTextLog.append("Ouverture de KVM." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de KVM : Consulter la log." + "\n");
				}
			}
		});
		MenuFavoris.add(MenuKvm);

		MenuTina5 = new JMenuItem("Tina web Cltec5");
		final ImageIcon IconTina = new ImageIcon(getClass().getResource("/tina-icon.jpg"));
		MenuTina5.setIcon(IconTina);
		MenuTina5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceTina5() == true) {
					ZoneTextLog.append("Ouverture de TINA 5" + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de TINA 5 : Consulter la log." + "\n");
				}
			}
		});
		MenuFavoris.add(MenuTina5);

		MenuTina6 = new JMenuItem("Tina web Cltec6");
		MenuTina6.setIcon(IconTina);
		MenuTina6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceTina6() == true) {
					ZoneTextLog.append("Ouverture de TINA 6." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de TINA 6 : Consulter la log." + "\n");
				}
			}
		});
		MenuFavoris.add(MenuTina6);

		MenuVcenter = new JMenuItem("Vcenter (VMware)");
		final ImageIcon IconVcenter = new ImageIcon(getClass().getResource("/vmware-icon.png"));
		MenuVcenter.setIcon(IconVcenter);
		MenuVcenter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceVcenter() == true) {
					ZoneTextLog.append("Ouverture de Vcenter." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de Vcenter : Consulter la log." + "\n");
				}
			}
		});
		MenuFavoris.add(MenuVcenter);

		MenuWebIas = new JMenuItem("Web IAS");
		final ImageIcon IconIas = new ImageIcon(getClass().getResource("/ias-icon.png"));
		MenuWebIas.setIcon(IconIas);
		MenuWebIas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (LanceProduit.LanceWebIas() == true) {
					ZoneTextLog.append("Ouverture de WebIAS." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de WebIAS : Consulter la log." + "\n");
				}
			}
		});
		MenuFavoris.add(MenuWebIas);

		JMenu mnSismo = new JMenu("Sismo");
		mnSismo.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		MenuFavoris.add(mnSismo);

		MenuSismoIp1 = new JMenuItem("Sismo/cd IP1");
		final ImageIcon IconSismo = new ImageIcon(getClass().getResource("/sismo-icon.jpg"));
		MenuSismoIp1.setIcon(IconSismo);
		MenuSismoIp1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceSismoIp1() == true) {
					ZoneTextLog.append("Ouverture de SISMO IP1." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de SISMO IP1 : Consulter la log." + "\n");
				}
			}
		});
		mnSismo.add(MenuSismoIp1);

		MenuSismoIp2 = new JMenuItem("Sismo/cd IP2");
		MenuSismoIp2.setIcon(IconSismo);
		MenuSismoIp2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceSismoIp2() == true) {
					ZoneTextLog.append("Ouverture de SISMO IP2." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de SISMO IP2 : Consulter la log." + "\n");
				}
			}
		});
		mnSismo.add(MenuSismoIp2);

		MenuSismoOceor = new JMenuItem("Sismo/cd Oceor");
		MenuSismoOceor.setIcon(IconSismo);
		MenuSismoOceor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceSismoOceor() == true) {
					ZoneTextLog.append("Ouverture de SISMO OCEOR." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de SISMO OCEOR : Consulter la log." + "\n");
				}
			}
		});
		mnSismo.add(MenuSismoOceor);

		MenuSismoPalatine = new JMenuItem("Sismo/cd Palatine");
		MenuSismoPalatine.setIcon(IconSismo);
		MenuSismoPalatine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (LanceProduit.LanceSismoPalatine() == true) {
					ZoneTextLog.append("Ouverture de SISMO Palatine." + "\n");
				}
				else {
					ZoneTextLog.append("Erreur lancement de SISMO Palatine: Consulter la log." + "\n");
				}

			}
		});
		mnSismo.add(MenuSismoPalatine);

		JMenu MenuGestion = new JMenu("Gestion");

		BarreMenuPrincipale.add(MenuGestion);

		JMenuItem MenuModifierFichierConfig = new JMenuItem("Gestion des acc\u00E8s");
		final ImageIcon IconEditionConfig = new ImageIcon(getClass().getResource("/password-icon.png"));
		MenuModifierFichierConfig.setIcon(IconEditionConfig);
		MenuModifierFichierConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				GainedFocus = true;
				UserInterfaceConfig PageConfig = new UserInterfaceConfig();

				PageConfig.setVisible(true);
				PageConfig.setSize(800, 580);
				PageConfig.setLocation(PositionFenetrePrincipale);

			}
		});
		// MenuModifierFichierConfig.setIcon(new
		// ImageIcon(UserInterface.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		MenuGestion.add(MenuModifierFichierConfig);

		JMenuItem MenuEditionMachines = new JMenuItem("Gestion des machines");
		final ImageIcon IconEditionMachine = new ImageIcon(getClass().getResource("/server-icon.png"));
		MenuEditionMachines.setIcon(IconEditionMachine);
		MenuEditionMachines.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				GainedFocus = true;

				// UserInterfaceEditionMachine PageEditionMachine = null;
				try {
					UserInterfaceEditionMachine PageEditionMachine = new UserInterfaceEditionMachine();
					PageEditionMachine.setVisible(true);
					PageEditionMachine.setSize(800, 600);
					PageEditionMachine.setLocation(PositionFenetrePrincipale);
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		MenuGestion.add(MenuEditionMachines);

		MenuEditionFavoris = new JMenuItem("Gestion des favoris");
		final ImageIcon IconEditionFavoris = new ImageIcon(getClass().getResource("/folder-fav-icon.png"));
		MenuEditionFavoris.setIcon(IconEditionFavoris);
		// mntmEditionDesFavoris.setIcon(new
		// ImageIcon(UserInterface.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		MenuEditionFavoris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				GainedFocus = true;
				UserInterfaceFavoris PageEditionFavoris = null;
				try {
					PageEditionFavoris = new UserInterfaceFavoris();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				PageEditionFavoris.setVisible(true);
				PageEditionFavoris.setSize(800, 550);
				PageEditionFavoris.setLocation(PositionFenetrePrincipale);

			}
		});
		MenuGestion.add(MenuEditionFavoris);

		MenuParametresHaut = new JMenu("Param\u00E8tres");
		BarreMenuPrincipale.add(MenuParametresHaut);

		JMenuItem mntmGnraux = new JMenuItem("G\u00E9n\u00E9raux");
		final ImageIcon IconParametreGeneraux = new ImageIcon(getClass().getResource("/icon-options.png"));
		mntmGnraux.setIcon(IconParametreGeneraux);
		mntmGnraux.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				GainedFocus = true;
				UserInterfaceParametresGeneraux PageParemtresGeneraux = new UserInterfaceParametresGeneraux();

				PageParemtresGeneraux.setVisible(true);
				PageParemtresGeneraux.setSize(390, 500);
				PageParemtresGeneraux.setLocation(PositionFenetrePrincipale);
			}
		});
		MenuParametresHaut.add(mntmGnraux);

		JMenuItem MenuParametres = new JMenuItem("Bouton lancement poste");
		MenuParametresHaut.add(MenuParametres);
		MenuParametres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				GainedFocus = true;
				UserInterfaceParametres PageParametres = new UserInterfaceParametres();

				PageParametres.setVisible(true);
				PageParametres.setSize(750, 550);
				PageParametres.setLocation(PositionFenetrePrincipale);
			}
		});
		MenuParametres.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/scene/web/skin/AlignJustified_16x16_JFX.png")));

		JMenuItem mntmParamtrerSesRacourcis = new JMenuItem("Attribuer les racourcis");
		final ImageIcon IconEditionRaccourcis = new ImageIcon(getClass().getResource("/shortcut-icon.png"));
		mntmParamtrerSesRacourcis.setIcon(IconEditionRaccourcis);
		mntmParamtrerSesRacourcis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				GainedFocus = true;
				UserInterfaceRaccourcis PageRaccourci = new UserInterfaceRaccourcis();

				PageRaccourci.setVisible(true);
				PageRaccourci.setSize(280, 500);
				PageRaccourci.setLocation(PositionFenetrePrincipale);
			}
		});

		MenuParametresHaut.add(mntmParamtrerSesRacourcis);

		separator_5 = new JSeparator();
		MenuParametresHaut.add(separator_5);

		JMenu MenuProfiles = new JMenu("Profiles");
		MenuParametresHaut.add(MenuProfiles);

		MenuItceParisBercy = new JCheckBoxMenuItem("IT-CE Paris Bercy");
		MenuItceParisBercy.setSelected(true);
		MenuItceParisBercy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Session = 1;
				MenuBourglareine.setSelected(false);
				MenuItceParisBercy.setSelected(true);
				GS.EcrireSession(Session);
				LabelProfile.setText("Profile: IT-CE Bercy");

			}
		});
		MenuProfiles.add(MenuItceParisBercy);

		MenuBourglareine = new JCheckBoxMenuItem("Bourg-la-reine");
		MenuBourglareine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Session = 2;
				MenuItceParisBercy.setSelected(false);
				MenuBourglareine.setSelected(true);
				GS.EcrireSession(Session);
				LabelProfile.setText("Profile: Bourg-la-reine");
			}
		});
		MenuProfiles.add(MenuBourglareine);

		JMenu MenuAPropos = new JMenu("Aide");
		BarreMenuPrincipale.add(MenuAPropos);

		JMenuItem MenuLogErreurs = new JMenuItem("Log d'erreurs");
		MenuLogErreurs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				GestionChemin RequeteChemin = new GestionChemin();

				try {
					ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "start ", "\"", RequeteChemin.DemandeChemin("CheminFichierLog"), "\"");
					builder.start();
				}
				catch (IOException e) {

					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement de la log : " + e);
					ZoneTextLog.append("Erreur lors de l'affichage de la log : Consulter la log.  lol =)" + "\n");

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
				}
				catch (IOException e1) {
					e1.printStackTrace();
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur lors de la génération de l'email : " + e);
					ZoneTextLog.append("Erreur lors de la génération du mail : Consulter la log." + "\n");

				}
			}
		});

		JMenuItem mntmRechargerConfig = new JMenuItem("Recharger config");
		mntmRechargerConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				new Thread(new ThreadRechargementConfigInterface()).start();
				ZoneTextLog.append("Profile rechargé correctement." + "\n");
			}
		});
		MenuAPropos.add(mntmRechargerConfig);

		JMenuItem mntmRechargerFavoris = new JMenuItem("Recharger favoris");
		mntmRechargerFavoris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				MenuFavorisCommuns.removeAll();
				new Thread(new ThreadChargementFavoris()).start();
				ZoneTextLog.append("Favoris communs rechargés." + "\n");
			}
		});
		MenuAPropos.add(mntmRechargerFavoris);

		JSeparator separator_6 = new JSeparator();
		MenuAPropos.add(separator_6);
		MenuAPropos.add(MenuSignalerUnBug);

		JMenuItem MenuInterrogation = new JMenuItem("A propos d'AlphaPilote");
		MenuInterrogation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "start ", "\"", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "\"", " \"",
						" file://fsitceti/entites/ITC%20PPR-EDC-PIL-724%20ETI/Pilotage%20Mutualise/Sauvegarde%20Olive&Pascal/Outils%20de%20pilotage/Alphapilote/Data/htm/index.html", " \"");
				try {
					builder.start();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		MenuAPropos.add(MenuInterrogation);

		JMenuItem mntmNewMenuItem = new JMenuItem("Version 1.1b");
		mntmNewMenuItem.setForeground(new Color(51, 153, 102));
		MenuAPropos.add(mntmNewMenuItem);

		JButton BoutonValideMstsc = new JButton("TS (mstsc)");
		BoutonValideMstsc.setMargin(new Insets(0, 0, 0, 0));
		BoutonValideMstsc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				GestionMachine MaMachine = new GestionMachine();
				String Resultatdemande = "";
				try {
					Resultatdemande = MaMachine.DemandeIpSQL(MachineDansMaComboBox);
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// String TextZoneIp = ZoneIp.getText();
				if (Resultatdemande == null) {
					Resultatdemande = MachineDansMaComboBox;
				}

				try {
					Runtime.getRuntime().exec(String.format("mstsc.exe /v:" + Resultatdemande));
					ZoneTextLog.append("Lancement mstsc pour " + Resultatdemande + "\n");

				}
				catch (IOException e1) {

					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement de la connexion mstsc : " + e1);
					ZoneTextLog.append("Erreur au lancement de la connexion mstsc : Consulter la log." + "\n");

					e1.printStackTrace();
				}

			}
		});
		BoutonValideMstsc.setBounds(226, 84, 89, 23);
		PaneZoneConnexion.add(BoutonValideMstsc);

		ResultatPing = new JLabel("");
		ResultatPing.setFont(new Font("Arial", Font.BOLD, 13));
		ResultatPing.setForeground(new Color(51, 153, 0));
		ResultatPing.setBounds(164, 17, 64, 20);
		PaneZoneConnexion.add(ResultatPing);

		JPanel ZoneConnexionAutoLogin = new JPanel();
		ZoneConnexionAutoLogin.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Auto login (SSH seulement)", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(72, 61, 139)));
		ZoneConnexionAutoLogin.setBounds(10, 54, 178, 136);
		PaneZoneConnexion.add(ZoneConnexionAutoLogin);
		ZoneConnexionAutoLogin.setLayout(null);

		BoutonRadioRoot = new JRadioButton("root");
		BoutonRadioRoot.setMargin(new Insets(0, 0, 0, 0));
		BoutonRadioRoot.setBounds(6, 18, 70, 23);
		ZoneConnexionAutoLogin.add(BoutonRadioRoot);

		BoutonRadioSalle = new JRadioButton("salle");
		BoutonRadioSalle.setMargin(new Insets(0, 0, 0, 0));
		BoutonRadioSalle.setBounds(6, 42, 70, 27);
		ZoneConnexionAutoLogin.add(BoutonRadioSalle);

		BoutonRadioUserPerso = new JRadioButton("j0*****");
		BoutonRadioUserPerso.setMargin(new Insets(0, 0, 0, 0));
		BoutonRadioUserPerso.setBounds(6, 74, 70, 18);
		ZoneConnexionAutoLogin.add(BoutonRadioUserPerso);

		// Ajout des bouton dans le ButtonGroup
		MesBoutonsLogin = new ButtonGroup();
		MesBoutonsLogin.add(BoutonRadioRoot);
		MesBoutonsLogin.add(BoutonRadioSalle);
		MesBoutonsLogin.add(BoutonRadioUserPerso);

		CheckBoxPassword = new Checkbox("+ pass");
		CheckBoxPassword.setBounds(82, 74, 63, 18);
		ZoneConnexionAutoLogin.add(CheckBoxPassword);

		JButton BoutonClearLogin = new JButton("x");
		BoutonClearLogin.setBounds(6, 100, 18, 14);
		ZoneConnexionAutoLogin.add(BoutonClearLogin);
		BoutonClearLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				MesBoutonsLogin.clearSelection();
				CheckBoxPassword.setState(false);
			}
		});
		BoutonClearLogin.setMargin(new Insets(0, 0, 0, 0));

		MaComboBox = new JComboBox();

		// -------------------LISTENER

		// remplir le panneau, lui mettre un layout, etc

		// ------------------------------FIN

		MaComboBox.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		MaComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		MaComboBox.setAutoscrolls(true);
		MaComboBox.setMaximumRowCount(20);
		MaComboBox.setBounds(10, 17, 128, 20);
		MaComboBox.setEditable(true);
		AutoCompleteDecorator.decorate(MaComboBox);
		PaneZoneConnexion.add(MaComboBox);
		MaComboBox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if (keyChar == KeyEvent.VK_ENTER) {
					new Thread(new LancePuttyConnexionAuto()).start();

				}
			}
		});

		BoutonConnexionTelnetOuSsh = new JButton("Telnet/SSH");
		BoutonConnexionTelnetOuSsh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// INIT CONNEXION AUTO (LancePuttyConnexionAuto)
				new Thread(new LancePuttyConnexionAuto()).start();

			}
		});
		BoutonConnexionTelnetOuSsh.setMargin(new Insets(1, 1, 1, 1));
		BoutonConnexionTelnetOuSsh.setBounds(224, 50, 91, 23);
		PaneZoneConnexion.add(BoutonConnexionTelnetOuSsh);

		MaComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {
				MachineDansMaComboBox = (String) MaComboBox.getSelectedItem();

			}

		});

		JProgressBar MaBarreProgression = new JProgressBar();
		MaBarreProgression.setFont(new Font("Tahoma", Font.PLAIN, 6));
		MaBarreProgression.setOpaque(true);
		MaBarreProgression.setBackground(Color.BLACK);
		MaBarreProgression.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		MaBarreProgression.setBounds(10, 503, 169, 14);
		getContentPane().add(MaBarreProgression);
		MaBarreProgression.setIndeterminate(true);
		MaBarreProgression.setForeground(new Color(178, 34, 34));
		new ImageIcon(getClass().getResource("/reload-icon.png"));
		new ImageIcon(getClass().getResource("/rsz_1legendary-marker_1.png"));

		JPanel PanelZoneTestFichier = new JPanel();
		PanelZoneTestFichier.setForeground(new Color(255, 69, 0));
		PanelZoneTestFichier.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Param\u00E8tres session", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 149, 237)));
		PanelZoneTestFichier.setBounds(544, 2, 189, 134);
		getContentPane().add(PanelZoneTestFichier);
		PanelZoneTestFichier.setLayout(null);

		LabelProfile = new JLabel("Profile: IT-CE Bercy");
		LabelProfile.setBounds(10, 45, 199, 23);
		PanelZoneTestFichier.add(LabelProfile);
		LabelProfile.setForeground(new Color(25, 25, 112));
		LabelProfile.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));

		JLabel lblUtilisateur = new JLabel("Utilisateur: " + UserNameStation);
		lblUtilisateur.setForeground(new Color(25, 25, 112));
		lblUtilisateur.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
		lblUtilisateur.setBounds(10, 20, 199, 23);
		PanelZoneTestFichier.add(lblUtilisateur);

		JLabel LabelRessources = new JLabel("Acc\u00E8s ressources: ");
		LabelRessources.setForeground(new Color(25, 25, 112));
		LabelRessources.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
		LabelRessources.setBounds(10, 100, 138, 23);
		PanelZoneTestFichier.add(LabelRessources);

		LabelImageRessources = new JLabel("");
		LabelImageRessources.setToolTipText("Base de donn\u00E9es = OK, \r\nFichier machines = OK, \r\nFichier favoris = OK, \r\nDossier profiles =OK, ");
		LabelImageRessources.setIcon(new ImageIcon(UserInterface.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		LabelImageRessources.setBounds(138, 100, 46, 23);
		PanelZoneTestFichier.add(LabelImageRessources);

		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(190, 0, 46, 23);
		PanelZoneTestFichier.add(tglbtnNewToggleButton);

		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("New toggle button");
		tglbtnNewToggleButton_1.setBounds(190, 0, 46, 23);
		PanelZoneTestFichier.add(tglbtnNewToggleButton_1);

		JPanel PaneZonePreparationPostePilotage = new JPanel();
		PaneZonePreparationPostePilotage.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pr\u00E9paration poste pilotage", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(100, 149, 237)));
		PaneZonePreparationPostePilotage.setBounds(345, 2, 189, 148);
		getContentPane().add(PaneZonePreparationPostePilotage);
		PaneZonePreparationPostePilotage.setLayout(null);

		JButton BoutonLancePostePilotageComplet = new JButton("Lancer poste complet");
		BoutonLancePostePilotageComplet.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// BLEA
				LanceAutoPostePilotage();

			}
		});
		final ImageIcon IconLancePostePilotageComplet = new ImageIcon(getClass().getResource("/activity_monitor.png"));
		BoutonLancePostePilotageComplet.setIcon(IconLancePostePilotageComplet);
		BoutonLancePostePilotageComplet.setBounds(6, 16, 173, 31);
		PaneZonePreparationPostePilotage.add(BoutonLancePostePilotageComplet);
		BoutonLancePostePilotageComplet.setMargin(new Insets(0, 0, 0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lancer tout ->", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(165, 42, 42)));
		panel.setBounds(6, 58, 173, 78);
		PaneZonePreparationPostePilotage.add(panel);
		panel.setLayout(null);

		JButton BoutonToutVtom = new JButton("Vtom");
		BoutonToutVtom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				try {

					LanceProduit.LanceVtomIp1q();
					Thread.sleep(10000);
					LanceProduit.LanceVtomIp1d();
					Thread.sleep(10000);
					LanceProduit.LanceVtomIp2q();
					Thread.sleep(10000);
					LanceProduit.LanceVtomIp2d();
				}
				catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		BoutonToutVtom.setBounds(6, 48, 71, 23);
		panel.add(BoutonToutVtom);
		BoutonToutVtom.setMargin(new Insets(0, 0, 0, 0));

		JButton BoutonToutMvs = new JButton("MVS (Prod)");
		BoutonToutMvs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				try {
					LanceProduit.LanceSysa();
					Thread.sleep(500);
					LanceProduit.LanceKmvs();
					Thread.sleep(500);
					LanceProduit.LanceSysg();
					Thread.sleep(500);
					LanceProduit.LanceZmvs();
					Thread.sleep(500);
					LanceProduit.LanceGmvs();
					Thread.sleep(500);
				}
				catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		BoutonToutMvs.setBounds(79, 16, 84, 23);
		panel.add(BoutonToutMvs);
		BoutonToutMvs.setMargin(new Insets(0, 0, 0, 0));

		JButton BoutonToutAs400 = new JButton("As400");
		BoutonToutAs400.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				try {

					LanceProduit.LanceAs400Br();
					Thread.sleep(500);
					LanceProduit.LanceAs400Bdi();
					Thread.sleep(500);
					LanceProduit.LanceAs400Bdaf();
					Thread.sleep(500);
					LanceProduit.LanceAs400Socly();
					Thread.sleep(500);
					LanceProduit.LanceAs400Socmcsd();
					Thread.sleep(500);
					LanceProduit.LanceAs400Pfb();
				}
				catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
		});
		BoutonToutAs400.setBounds(6, 16, 71, 23);
		panel.add(BoutonToutAs400);
		BoutonToutAs400.setMargin(new Insets(0, 0, 0, 0));

		ProgressBarExecutionGlobale = new JProgressBar();
		ProgressBarExecutionGlobale.setVisible(false);
		ProgressBarExecutionGlobale.setValue(0);
		ProgressBarExecutionGlobale.setStringPainted(true);
		ProgressBarExecutionGlobale.setMaximum(15000);
		ProgressBarExecutionGlobale.setBounds(264, 223, 270, 23);
		getContentPane().add(ProgressBarExecutionGlobale);

		LabelUtilisationMemoire = new JLabel("Utilisation m\u00E9moire : ");
		LabelUtilisationMemoire.setForeground(new Color(0, 0, 0));
		LabelUtilisationMemoire.setBounds(185, 503, 164, 14);
		getContentPane().add(LabelUtilisationMemoire);

		LabelNombreThread = new JLabel("Threads en cours :");
		LabelNombreThread.setForeground(new Color(0, 0, 0));
		LabelNombreThread.setBounds(361, 503, 127, 14);
		getContentPane().add(LabelNombreThread);

		LabelAdresseIp = new JLabel("Adresse IP :");
		LabelAdresseIp.setForeground(new Color(0, 0, 0));
		LabelAdresseIp.setBounds(488, 503, 156, 14);
		getContentPane().add(LabelAdresseIp);

		LabelDateHeure = new JLabel("Date/heure :");
		LabelDateHeure.setForeground(new Color(0, 0, 0));
		LabelDateHeure.setBounds(654, 503, 120, 14);
		getContentPane().add(LabelDateHeure);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Raccourcis", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 149, 237)));
		panel_1.setBounds(558, 358, 216, 134);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		LabelCapture = new JLabel("+  = Outil Capture");

		LabelCapture.setFont(new Font("Calibri", Font.PLAIN, 12));
		final ImageIcon IconWindows = new ImageIcon(getClass().getResource("/Windows-icon.png"));
		LabelCapture.setIcon(IconWindows);
		LabelCapture.setForeground(new Color(160, 82, 45));
		LabelCapture.setBounds(6, 17, 202, 24);
		panel_1.add(LabelCapture);

		LabelConnexion = new JLabel("+  = Putty sur s\u00E9lection souris");
		LabelConnexion.setIcon(IconWindows);
		LabelConnexion.setFont(new Font("Calibri", Font.PLAIN, 12));
		LabelConnexion.setForeground(new Color(160, 82, 45));
		LabelConnexion.setBounds(6, 52, 202, 24);
		panel_1.add(LabelConnexion);

		LabelConsignes = new JLabel("+  = Dossier Consignes");
		LabelConsignes.setIcon(IconWindows);
		LabelConsignes.setForeground(new Color(160, 82, 45));
		LabelConsignes.setFont(new Font("Calibri", Font.PLAIN, 12));
		LabelConsignes.setBounds(6, 87, 202, 24);
		panel_1.add(LabelConsignes);
		final ImageIcon IconWarning = new ImageIcon(getClass().getResource("/warning-icon.png"));

		LabelDetectionDoublon = new JLabel("Conflit dans les raccourcis");
		LabelDetectionDoublon.setVisible(false);
		LabelDetectionDoublon.setBounds(288, 248, 189, 24);
		getContentPane().add(LabelDetectionDoublon);
		LabelDetectionDoublon.setIcon(IconWarning);
		LabelDetectionDoublon.setForeground(new Color(220, 20, 60));
		LabelDetectionDoublon.setFont(new Font("Tahoma", Font.BOLD, 11));

		LabelChargementProfil = new JLabel("Chargement du profil en cours ....");
		LabelChargementProfil.setVisible(false);
		LabelChargementProfil.setForeground(new Color(60, 179, 113));
		LabelChargementProfil.setFont(new Font("Times New Roman", Font.BOLD, 18));
		LabelChargementProfil.setBounds(255, 230, 293, 56);
		getContentPane().add(LabelChargementProfil);

		JToggleButton BoutonAncre = new JToggleButton("");
		final ImageIcon IconAncre = new ImageIcon(getClass().getResource("/icon-ancre.png"));
		BoutonAncre.setIcon(IconAncre);
		BoutonAncre.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent Event) {
				if (Event.getStateChange() == ItemEvent.SELECTED) {
					setAlwaysOnTop(true);
					ZoneTextLog.append("La fenêtre est maintenant au dessus des autres." + "\n");
				}
				else if (Event.getStateChange() == ItemEvent.DESELECTED) {
					setAlwaysOnTop(false);
					ZoneTextLog.append("La fenêtre n'est plus au dessus des autres." + "\n");
				}
			}
		});
		BoutonAncre.setBounds(748, 2, 36, 31);
		getContentPane().add(BoutonAncre);

		LabelLancementAuto = new JLabel("Lancement automatique dans : ");
		LabelLancementAuto.setForeground(new Color(0, 0, 0));
		LabelLancementAuto.setFont(new Font("Verdana", Font.BOLD, 17));
		LabelLancementAuto.setBounds(191, 223, 388, 42);
		getContentPane().add(LabelLancementAuto);

		BoutonCancel = new JButton("Annuler Lancement");
		BoutonCancel.setVisible(false);
		BoutonCancel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				BoutonCancelVar = true;
				ZoneTextLog.append("Annulation du lancement automatique." + "\n");
			}
		});
		BoutonCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		BoutonCancel.setForeground(new Color(139, 0, 0));
		BoutonCancel.setBounds(589, 222, 169, 43);
		getContentPane().add(BoutonCancel);

		BoutonValideSsh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				try {
					LancePuttyConnexionSsh();
				}
				catch (AWTException | SQLException e1) {
					e1.printStackTrace();
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " + e1);
					ZoneTextLog.append("Erreur au lancement de putty pour une connexion ssh : Consulter la log." + "\n");

				}

			}
		});
		BoutonValideTelnet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				try {
					LancePuttyConnexionTelnet();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		BoutonValideIp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				new Thread(new ThreadPing()).start();

			}

		});

		/**
		 * @category Démarrage
		 */

		// ---------------------------------------------
		//
		//
		// DEMARRAGE FENETRE, INIT PRODUIT
		//
		//
		//
		// ----------------------------------------------
		new Thread(new InitialisationInterface()).start();

		// --------------------TEST SQL------------------
		//
		//
		//
		//
		// --------------------/TEST SQL------------------

		GestionSql LaBase = new GestionSql();
		Connection LaConnexion = LaBase.InitConnexion();
		String Retour = LaBase.TestUserExistant(LaConnexion, UserNameStation);
		if (Retour.equals("AUCUN") == true) {

			LaBase.AjoutNouveauPilote(LaConnexion, UserNameStation);
			LaBase.AjoutBrowserPilote(LaConnexion, "Mozilla Firefox");
			LaBase.AjoutDonneePilote(LaConnexion, "RaccourciCapture", "X");
			LaBase.AjoutDonneePilote(LaConnexion, "RaccourciConnexion", "V");
			LaBase.AjoutDonneePilote(LaConnexion, "RaccourciConsignes", "C");

		}

		LaBase.AjoutDonneeIntPilote(LaConnexion, "Session", LaBase.ConsulterDonneeIntPilote(LaConnexion, "SessionDefault"));
		int Session = LaBase.ConsulterDonneeIntPilote(LaConnexion, "SessionDefault");
		if (Session == 1) {
			LabelProfile.setText("Profile: IT-CE Bercy");
			MenuItceParisBercy.setSelected(true);
			MenuBourglareine.setSelected(false);
		}
		if (Session == 2) {
			LabelProfile.setText("Profile: Bourg-la-reine");
			MenuBourglareine.setSelected(true);
			MenuItceParisBercy.setSelected(false);
		}
		LaBase.FermerConnexion(LaConnexion);
		TestAccesFichier();
	}

	public class InitialisationInterface implements Runnable {

		@Override
		public void run() {
			try {
				LabelChargementProfil.setVisible(true);
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserNameStation = System.getProperty("user.name");

			new Thread(new ThreadEtatSysteme()).start();
			new Thread(new ThreadChargementFavoris()).start();
			new Thread(new ThreadGrabber()).start();

			try {

				MajAffichageRaccourcis();
			}
			catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			new Thread(new ThreadRechargementConfigInterface()).start();
			LabelChargementProfil.setVisible(false);
			new Thread(new ThreadLanceAutoPoste()).start();
		}

	}

	/**
	 * @category SystemInit
	 */
	public void TestAccesFichier() {
		GestionChemin RequeteChemin = new GestionChemin();
		GestionLog MaLog = new GestionLog();
		GestionSql LaBase = new GestionSql();
		int RessourcesPresentes = 0;

		if (LaBase.TestConnexion() == true) {
			RessourcesPresentes++;
		}
		else {
			ZoneTextLog.append("Problème d'accès à la base de donnée : " + RequeteChemin.DemandeChemin("BaseDeDonnée") + "\n");
			MaLog.EcrireDansFichierLog("Problème d'accès à la base de donnée dans : " + RequeteChemin.DemandeChemin("BaseDeDonnée"));
		}

		File FichierMachine = new File(RequeteChemin.DemandeChemin("CheminFichierMachine"));
		if (FichierMachine.exists()) {
			RessourcesPresentes++;
		}
		else {
			ZoneTextLog.append("Impossible de trouver le fichier machine : " + RequeteChemin.DemandeChemin("CheminFichierMachine") + "\n");
			MaLog.EcrireDansFichierLog("Erreur lors du test présence du fichier machine dans : " + RequeteChemin.DemandeChemin("CheminFichierFavoris"));
		}
		File FichierFavoris = new File(RequeteChemin.DemandeChemin("CheminFichierFavoris"));
		if (FichierFavoris.exists()) {
			RessourcesPresentes++;
		}
		else {
			ZoneTextLog.append("Impossible de trouver le fichier favoris : " + RequeteChemin.DemandeChemin("CheminFichierFavoris") + "\n");
			MaLog.EcrireDansFichierLog("Erreur lors du test présence du fichier favoris dans : " + RequeteChemin.DemandeChemin("CheminFichierFavoris"));
		}
		File FichierLog = new File(RequeteChemin.DemandeChemin("CheminFichierLog"));
		if (FichierLog.exists()) {
			RessourcesPresentes++;
		}
		else {
			ZoneTextLog.append("Impossible de trouver le fichier de log : " + RequeteChemin.DemandeChemin("CheminFichierLog") + "\n");
			MaLog.EcrireDansFichierLog("Erreur lors du test présence du fichier log dans : " + RequeteChemin.DemandeChemin("CheminFichierMachine"));

		}

		if (RessourcesPresentes == 4) {
			final ImageIcon IconImageRessources = new ImageIcon(getClass().getResource("/dot-green.png"));
			LabelImageRessources.setIcon(IconImageRessources);
			ZoneTextLog.append("Toutes les ressources sont présentes." + "\n");
		}

		if ((RessourcesPresentes == 3) || (RessourcesPresentes == 2) || (RessourcesPresentes == 1)) {
			final ImageIcon IconImageRessources = new ImageIcon(getClass().getResource("/dot-orange.gif"));
			LabelImageRessources.setIcon(IconImageRessources);
			ZoneTextLog.append("Problème d'accès à certaines ressources." + "\n");
		}
		if (RessourcesPresentes == 0) {
			final ImageIcon IconImageRessources = new ImageIcon(getClass().getResource("/dot-red.png"));
			LabelImageRessources.setIcon(IconImageRessources);
			ZoneTextLog.append("Aucun accès à toutes les ressources." + "\n");
		}

	}

	/**
	 * @category Lancement des Outils
	 */

	// --------------OUTILS RACCOURCIS
	// ---
	// ---

	// --------------------------------

	public class LanceTinaSiris1 implements Runnable {

		@Override
		public void run() {

			new GestionChemin();
			new GestionProfile();
			new GestionLog();
			GestionSql LaBase = new GestionSql();
			Connection ConnectionBase = LaBase.InitConnexion();

			GestionLog MaLog = new GestionLog();
			String UserUnix = "";
			String PassUnix = "";

			UserUnix = LaBase.ConsulterUserPilote(ConnectionBase, "Unix");
			PassUnix = LaBase.ConsulterPasswordPilote(ConnectionBase, "Unix");

			try {
				MonIp = InetAddress.getLocalHost().getHostAddress();
			}
			catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			AutomatedTelnetClient telnet = new AutomatedTelnetClient("126.196.230.13", UserUnix, PassUnix);
			try {
				ZoneTextLog.append("Ouverture de Tina UP2TS004 catalogue Siris1 en cours (Délais de 10-15sec)." + "\n");
				Thread.sleep(500);
				telnet.sendCommand("cd ~tina ");
				Thread.sleep(500);
				telnet.sendCommand(". .tina.sh ");
				Thread.sleep(500);
				telnet.sendCommand("cd Bin ");
				Thread.sleep(500);
				telnet.sendCommand("tina_adm -display " + MonIp + ":0.0 &");
				Thread.sleep(500);

			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				MaLog.EcrireDansFichierLog("Erreur au lancement de Tina UP2TS004 catalogue Siris1: " + e);
				ZoneTextLog.append("Erreur au lancement de Tina UP2TS004 catalogue Siris1: Consulter la log." + "\n");
			}
			LaBase.FermerConnexion(ConnectionBase);

		}
	}

	public class LanceTinaTinap203 implements Runnable {

		@Override
		public void run() {
			new GestionChemin();
			new GestionProfile();
			new GestionLog();
			GestionSql LaBase = new GestionSql();
			Connection ConnectionBase = LaBase.InitConnexion();

			GestionLog MaLog = new GestionLog();
			String UserUnix = "";
			String PassUnix = "";
			UserUnix = LaBase.ConsulterUserPilote(ConnectionBase, "Unix");
			PassUnix = LaBase.ConsulterPasswordPilote(ConnectionBase, "Unix");
			try {
				MonIp = InetAddress.getLocalHost().getHostAddress();
			}
			catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			AutomatedTelnetClient telnet = new AutomatedTelnetClient("126.196.230.13", UserUnix, PassUnix);
			try {
				ZoneTextLog.append("Ouverture de Tina UP2TS004 catalogue TINAP203 en cours (Délais de 10-15sec)." + "\n");
				Thread.sleep(500);
				telnet.sendCommand("cd /usr/tina_vecep/tina203 ");
				Thread.sleep(500);
				telnet.sendCommand(". .tina.sh ");
				Thread.sleep(500);
				telnet.sendCommand("cd Bin ");
				Thread.sleep(500);
				telnet.sendCommand("tina_adm -display " + MonIp + ":0.0 &");
				Thread.sleep(500);

			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				MaLog.EcrireDansFichierLog("Erreur au lancement de Tina UP2TS004 catalogue TINAP203: " + e);
				ZoneTextLog.append("Erreur au lancement de Tina UP2TS004 catalogue Siris1: Consulter la log." + "\n");
			}
			LaBase.FermerConnexion(ConnectionBase);
		}
	}

	public class LanceTinaTinap105103 implements Runnable {

		@Override
		public void run() {
			new GestionChemin();
			new GestionProfile();
			new GestionLog();
			GestionSql LaBase = new GestionSql();
			Connection ConnectionBase = LaBase.InitConnexion();
			new GestionLog();
			String UserUnix = "";
			String PassUnix = "";
			UserUnix = LaBase.ConsulterUserPilote(ConnectionBase, "Unix");
			PassUnix = LaBase.ConsulterPasswordPilote(ConnectionBase, "Unix");
			try {
				MonIp = InetAddress.getLocalHost().getHostAddress();
				AutomatedTelnetClient telnet = new AutomatedTelnetClient("126.40.230.119 ", UserUnix, PassUnix);
				ZoneTextLog.append("Ouverture de Tina UP1TS004 catalogue TINAP105 et 102 en cours (Délais de 10-15sec)." + "\n");
				Thread.sleep(500);
				telnet.sendCommand("cd ~tina ");
				Thread.sleep(500);
				telnet.sendCommand("cd tina104 ");
				Thread.sleep(500);
				telnet.sendCommand(". .tina.sh ");
				Thread.sleep(500);
				telnet.sendCommand("cd Bin ");
				Thread.sleep(500);
				telnet.sendCommand("tina_adm -display " + MonIp + ":0.0 &");
				Thread.sleep(500);
			}
			catch (UnknownHostException e1) {

				e1.printStackTrace();
			}
			catch (InterruptedException e) {

				e.printStackTrace();
			}
			LaBase.FermerConnexion(ConnectionBase);
		}
	}

	public String SelectionneNavigateur() {

		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();
		String Navigateur = "";
		Navigateur = LaBase.ConsulterBrowserPilote(ConnectionBase);
		switch (Navigateur) {
			case "Google Chrome":
				Navigateur = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
				break;
			case "Mozilla Firefox":
				Navigateur = "C:\\Users\\" + UserNameStation + "\\AppData\\Local\\Mozilla Firefox\\firefox.exe";
				break;
			case "Internet Explorer":
				Navigateur = "C:\\Program Files\\Internet Explorer\\iexplore.exe";
				break;
			default:
				Navigateur = "C:\\Users\\" + UserNameStation + "\\AppData\\Local\\Mozilla Firefox\\firefox.exe";
				break;

		}
		LaBase.FermerConnexion(ConnectionBase);
		return Navigateur;

	}

	// PRODUIT MVS ET AS400

	/**
	 * @category Lance MVS
	 */

	/**
	 * @category Lance AS400
	 */

	// LANCEMENT PUTTY

	/**
	 * @throws SQLException
	 * @category Lance Outils
	 */
	public void LancePuttyConnexionTelnet() throws SQLException

	{

		// final String CHEMIN = "D:\\";

		GestionMachine MaMachine = new GestionMachine();
		String Resultatdemande = MaMachine.DemandeIpSQL(MachineDansMaComboBox);
		GestionChemin RequeteChemin = new GestionChemin();

		if (Resultatdemande == null) {
			Resultatdemande = MachineDansMaComboBox;
		}

		// String TextZoneIp = ZoneIp.getText();

		try {

			Boolean LanceUneFois = true;

			if (BoutonRadioRoot.isSelected() == true && LanceUneFois == true) {

				Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande + " -telnet -l root"));
				ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande + " avec le user root" + "\n");

				LanceUneFois = false;
				MesBoutonsLogin.clearSelection();

			}

			if (BoutonRadioSalle.isSelected() == true && LanceUneFois == true) {

				Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande + " -telnet -l salle"));
				ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande + " avec le user salle" + "\n");

				LanceUneFois = false;
				MesBoutonsLogin.clearSelection();

			}

			if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == false) {

				String EtatBouton = BoutonRadioUserPerso.getText();
				Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande + " -telnet -l " + EtatBouton));
				ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande + " avec le user " + BoutonRadioUserPerso.getText() + "\n");

				LanceUneFois = false;
				MesBoutonsLogin.clearSelection();

			}

			if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == true) {

				String EtatBouton = BoutonRadioUserPerso.getText();
				Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande + " -telnet -l " + EtatBouton));
				ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande + " avec le user " + EtatBouton + " et le mot de passe" + "\n");

				LanceUneFois = false;
				MesBoutonsLogin.clearSelection();

				int CodeRetour = 0;
				String PasswordUnix = "";

				GestionSql LaBase = new GestionSql();
				Connection ConnectionBase = LaBase.InitConnexion();

				PasswordUnix = LaBase.ConsulterPasswordPilote(ConnectionBase, "Unix");
				if (CodeRetour == 0) {
					CheckBoxPassword.setState(false);
					SmartRobot SuperRobot = new SmartRobot();
					SuperRobot.delay(1500);
					SuperRobot.type(PasswordUnix);
					SuperRobot.keyPress(KeyEvent.VK_ENTER);

				}
				else {
					CheckBoxPassword.setState(false);
					ZoneTextLog.append("Problème lors de la demande du mot de passe" + "\n");

				}

			}

			if (LanceUneFois == true) {
				Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande + " -telnet"));
				ZoneTextLog.append("Lancement putty telnet vers " + Resultatdemande + "\n");

				LanceUneFois = false;
				MesBoutonsLogin.clearSelection();
			}

		}
		catch (IOException e) {
			e.printStackTrace();
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

		}
		catch (AWTException e) {
			e.printStackTrace();
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

		}

	}

	public void LancePuttyConnexionSsh() throws AWTException, SQLException {

		GestionMachine MaMachine = new GestionMachine();
		String Resultatdemande = MaMachine.DemandeIpSQL(MachineDansMaComboBox);
		GestionChemin RequeteChemin = new GestionChemin();
		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();

		if (Resultatdemande == null) {
			Resultatdemande = MachineDansMaComboBox;
		}

		try {

			Boolean LanceUneFois = true;

			if (BoutonRadioRoot.isSelected() == true && LanceUneFois == true) {

				// Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty")
				// + " -ssh" + " -l root" + "@" + Resultatdemande));
				Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande + " -ssh -l root"));
				ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande + " avec le user root" + "\n");

				LanceUneFois = false;
				MesBoutonsLogin.clearSelection();

			}

			if (BoutonRadioSalle.isSelected() == true && LanceUneFois == true) {

				Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande + " -ssh -l salle"));
				ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande + " avec le user salle" + "\n");

				LanceUneFois = false;
				MesBoutonsLogin.clearSelection();
			}

			if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == false) {

				String EtatBouton = BoutonRadioUserPerso.getText();
				Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande + " -ssh -l " + EtatBouton));
				ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande + " avec le user " + BoutonRadioUserPerso.getText() + "\n");

				LanceUneFois = false;
				MesBoutonsLogin.clearSelection();

			}

			if (BoutonRadioUserPerso.isSelected() == true && LanceUneFois == true && CheckBoxPassword.getState() == true) {

				String PasswordUnix = "";
				PasswordUnix = LaBase.ConsulterPasswordPilote(ConnectionBase, "Unix");
				String EtatBouton = BoutonRadioUserPerso.getText();
				Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " -ssh " + EtatBouton + "@" + Resultatdemande + " -pw " + PasswordUnix));
				ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande + " avec le user " + EtatBouton + " et le mot de passe" + "\n");

				LanceUneFois = false;
				MesBoutonsLogin.clearSelection();

			}

			if (LanceUneFois == true) {
				Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + Resultatdemande + " -ssh"));
				ZoneTextLog.append("Lancement putty ssh vers " + Resultatdemande + "\n");

				LanceUneFois = false;
				MesBoutonsLogin.clearSelection();

			}
			CheckBoxPassword.setState(false);
			LaBase.FermerConnexion(ConnectionBase);

		}
		catch (IOException e1) {

			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " + e1);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e1.printStackTrace();
		}

	}

	public class LancePuttyConnexionAuto implements Runnable {

		@Override
		public void run() {
			GestionSocket TestConnexionValideSurCible = new GestionSocket();
			GestionMachine MaMachine = new GestionMachine();
			String Resultatdemande = "";
			try {
				Resultatdemande = MaMachine.DemandeIpSQL(MachineDansMaComboBox);
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Boolean RetourTestConnexion = false;
			if (Resultatdemande == null) {
				Resultatdemande = MachineDansMaComboBox;
			}

			// Test le SSH en premier, puis le telnet si le retour SSH est à
			// false

			ZoneTextLog.append("En cours de connexion vers " + Resultatdemande + " en telnet(port23) ou ssh(port22)" + "\n");
			RetourTestConnexion = TestConnexionValideSurCible.InitSocket(Resultatdemande, 22);
			if (RetourTestConnexion == true) {
				try {
					LancePuttyConnexionSsh();
				}
				catch (AWTException | SQLException e) {
					e.printStackTrace();
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " + e);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

				}
			}
			else {
				RetourTestConnexion = TestConnexionValideSurCible.InitSocket(Resultatdemande, 23);
				if (RetourTestConnexion == true) {
					try {
						LancePuttyConnexionTelnet();
					}
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

			if (RetourTestConnexion == false) {
				ZoneTextLog.append("Impossible de trouver une connexion valide en telnet(port23) ou ssh(port22)" + "\n");
			}
		}
	}

	public class LancePuttyConnexionAutoRaccourci implements Runnable {

		@Override
		public void run() {
			SmartRobot SuperRobot = null;
			String IpDansLePressePapier = null;
			GestionChemin RequeteChemin = new GestionChemin();

			try {
				SuperRobot = new SmartRobot();
			}
			catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				IpDansLePressePapier = SuperRobot.GetClipboard();
			}
			catch (UnsupportedFlavorException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			GestionSocket TestConnexionValideSurCible = new GestionSocket();

			Boolean RetourTestConnexion = false;
			if (IpDansLePressePapier == null || IpDansLePressePapier.equals("") == true) {
				ZoneTextLog.append("Aucune sélection pour la cible de connexion" + "\n");
			}
			else {

				ZoneTextLog.append("Tentative de connexion vers " + IpDansLePressePapier + " en telnet, ssh ou mstsc " + "\n");
				RetourTestConnexion = TestConnexionValideSurCible.InitSocket(IpDansLePressePapier, 22);
				if (RetourTestConnexion == true) {
					try {
						Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + IpDansLePressePapier + " -ssh"));
						ZoneTextLog.append("Lancement ssh vers " + IpDansLePressePapier + "\n");
					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					RetourTestConnexion = TestConnexionValideSurCible.InitSocket(IpDansLePressePapier, 23);
					if (RetourTestConnexion == true) {
						try {
							Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " " + IpDansLePressePapier + " -telnet"));
							ZoneTextLog.append("Lancement telnet vers " + IpDansLePressePapier + "\n");
						}
						catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else {
						RetourTestConnexion = TestConnexionValideSurCible.InitSocket(IpDansLePressePapier, 3389);
						if (RetourTestConnexion == true) {
							try {
								Runtime.getRuntime().exec(String.format("mstsc.exe /v:" + IpDansLePressePapier));
								ZoneTextLog.append("Lancement mstsc vers " + IpDansLePressePapier + "\n");
								// MSTSC

							}
							catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}
				}
				if (RetourTestConnexion == false) {
					ZoneTextLog.append("Impossible de trouver une connexion valide en telnet(port23), ssh(port22) ou mstsc(port3389)" + "\n");
				}
			}
		}
	}

	/**
	 * @category Lancement Auto Outils
	 */

	public void LanceAutoPostePilotage() {

		// System.out.println("Je passe ici");
		new Thread(new ThreadBarProgress()).start();
		new Thread(new ThreadLancementProduitAuto()).start();

	}

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		}
		else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public class ThreadBarProgress implements Runnable {
		@Override
		public void run() {
			ProgressBarExecutionGlobale.setVisible(true);
			for (int i = 0; i <= 20000; i++) {
				ProgressBarExecutionGlobale.setValue(i);
				// ProgressBarExecutionGlobale.repaint();
				try {
					Thread.sleep(1);
				}
				catch (InterruptedException err) {
				}

			}
			ProgressBarExecutionGlobale.setVisible(false);
		}
	}

	public class ThreadLancementProduitAuto implements Runnable {

		@Override
		public void run() {
			GestionSql LaBase = new GestionSql();
			Connection ConnectionBase = LaBase.InitConnexion();
			LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Sysa");

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Sysa").equals("true") == true) {
					LanceProduit.LanceSysa();
					ZoneTextLog.append("Lancement de Sysa" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Kmvs").equals("true") == true) {
					LanceProduit.LanceKmvs();
					ZoneTextLog.append("Lancement de Kmvs" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Sysg").equals("true") == true) {
					LanceProduit.LanceSysg();
					ZoneTextLog.append("Lancement de Sysg" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Zmvs").equals("true") == true) {
					LanceProduit.LanceZmvs();
					ZoneTextLog.append("Lancement de Zmvs" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Gmvs").equals("true") == true) {
					LanceProduit.LanceGmvs();
					ZoneTextLog.append("Lancement de Gmvs" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Ip1").equals("true") == true) {
					LanceProduit.LanceIp1();
					ZoneTextLog.append("Lancement de Ip1" + "\n");
					Thread.sleep(500);

				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Ip2").equals("true") == true) {
					LanceProduit.LanceIp2();
					ZoneTextLog.append("Lancement de Ip2" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Ip3").equals("true") == true) {
					LanceProduit.LanceIp3();
					ZoneTextLog.append("Lancement de Ip3" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Bmvs").equals("true") == true) {
					LanceProduit.LanceBmvs();
					ZoneTextLog.append("Lancement de Bmvs" + "\n");
					Thread.sleep(500);
				}

				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Br").equals("true") == true) {
					LanceProduit.LanceAs400Br();
					ZoneTextLog.append("Lancement de Br" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Bdi").equals("true") == true) {
					LanceProduit.LanceAs400Bdi();
					ZoneTextLog.append("Lancement de Bdi" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Bdaf").equals("true") == true) {
					LanceProduit.LanceAs400Bdaf();
					ZoneTextLog.append("Lancement de Bdi" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Socly").equals("true") == true) {
					LanceProduit.LanceAs400Socly();
					ZoneTextLog.append("Lancement de Socly" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Socmcsd").equals("true") == true) {
					LanceProduit.LanceAs400Socmcsd();
					ZoneTextLog.append("Lancement de Socmcsd" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Pfb").equals("true") == true) {
					LanceProduit.LanceAs400Pfb();
					ZoneTextLog.append("Lancement de Pfb" + "\n");
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Controlm").equals("true") == true) {
					try {
						if (LanceProduit.LanceControlm() == true) {
							ZoneTextLog.append("Lancement de Control-m." + "\n");
						}
						else {
							ZoneTextLog.append("Erreur au lancement de control-m: Consulter la log." + "\n");
						}
					}
					catch (IOException e) {
						ZoneTextLog.append("Erreur au lancement de control-m: Consulter la log." + "\n");
						e.printStackTrace();
					}
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Outlook").equals("true") == true) {
					if (LanceProduit.LanceOutlook() == true) {
						ZoneTextLog.append("Lancement d'outlook." + "\n");
					}
					else {
						ZoneTextLog.append("Erreur au d'Outlook : Consulter la log." + "\n");
					}
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Arsv7").equals("true") == true) {
					if (LanceProduit.LanceArsRemedy() == true) {
						ZoneTextLog.append("Ouverture d'ARS Remedy v7." + "\n");
					}
					else {
						ZoneTextLog.append("Erreur lancement ARS Remedy v7 : Consulter la log." + "\n");
					}
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Iprox").equals("true") == true) {
					if (LanceProduit.LanceIprox() == true) {
						ZoneTextLog.append("Lancement d'Iprox." + "\n");
					}
					else {
						ZoneTextLog.append("Erreur au lancement d'Iprox : Consulter la log." + "\n");
					}
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Puttycm").equals("true") == true) {
					if (LanceProduit.LancePuttyCm() == true) {
						ZoneTextLog.append("Lancement de Putty CM." + "\n");
					}
					else {
						ZoneTextLog.append("Erreur au lancement de Putty Connection Manager: Consulter la log." + "\n");
					}
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Exceed").equals("true") == true) {
					if (LanceProduit.LanceExceed() == true) {
						ZoneTextLog.append("Lancement d'exceed." + "\n");
					}
					else {
						ZoneTextLog.append("Erreur au lancement d'exceed Manager: Consulter la log." + "\n");
					}
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Mremote").equals("true") == true) {
					if (LanceProduit.LanceMremote() == true) {
						ZoneTextLog.append("Lancement d'mRemote." + "\n");
					}
					else {
						ZoneTextLog.append("Erreur au lancement d'mRemote: Consulter la log." + "\n");
					}
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "PartageIprox").equals("true") == true) {
					if (LanceProduit.LancePartageIprox() == true) {
						ZoneTextLog.append("Lancement du partage Iprox." + "\n");
					}
					else {
						ZoneTextLog.append("Erreur au lancement du partage Iprox: Consulter la log." + "\n");
					}
					Thread.sleep(500);

				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "VtomIp1Jour").equals("true") == true) {
					LanceProduit.LanceVtomIp1q();
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "VtomIp1Desc").equals("true") == true) {
					LanceProduit.LanceVtomIp1d();
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "VtomIp2Jour").equals("true") == true) {
					LanceProduit.LanceVtomIp2q();
					Thread.sleep(500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "VtomIp1Desc").equals("true") == true) {
					LanceProduit.LanceVtomIp2d();
					Thread.sleep(500);
				}
				Thread.sleep(7500);
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Navigateur").equals("true") == true) {
					String Navigateur = SelectionneNavigateur();

					ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur);
					pb.start();
					Thread.sleep(8000);

				}

				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Odip").equals("true") == true) {
					LanceProduit.LanceOdip();
					Thread.sleep(1500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Bbr").equals("true") == true) {
					LanceProduit.LanceBbr();
					Thread.sleep(1500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "OseIp12").equals("true") == true) {
					LanceProduit.LanceOseIp1();
					Thread.sleep(1500);
					LanceProduit.LanceOseIp2();
					Thread.sleep(1500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Iplabel").equals("true") == true) {
					LanceProduit.LanceIpLabel();
					Thread.sleep(1500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Newtest").equals("true") == true) {
					LanceProduit.LanceNewtest();
					Thread.sleep(1500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Xguard").equals("true") == true) {
					LanceProduit.LanceXguard();
					Thread.sleep(1500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Hmc").equals("true") == true) {
					LanceProduit.LanceHmc();
					Thread.sleep(1500);
				}

				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Kvm").equals("true") == true) {
					LanceProduit.LanceKvm();
					Thread.sleep(1500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Tina5").equals("true") == true) {
					LanceProduit.LanceTina5();
					Thread.sleep(1500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Tina6").equals("true") == true) {
					LanceProduit.LanceTina6();
					Thread.sleep(1500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Vcenter").equals("true") == true) {
					LanceProduit.LanceVcenter();
					Thread.sleep(1500);
				}
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "SismoTous").equals("true") == true) {
					LanceProduit.LanceSismoIp1();
					Thread.sleep(1500);
					LanceProduit.LanceSismoIp2();
					Thread.sleep(1500);
					LanceProduit.LanceSismoOceor();
					Thread.sleep(1500);
					LanceProduit.LanceSismoPalatine();
					Thread.sleep(1500);
				}

			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LaBase.FermerConnexion(ConnectionBase);
		}

	}

	/**
	 * @category Threads
	 */
	public class ThreadPing implements Runnable {

		@Override
		public void run() {

			GestionMachine MaMachine = new GestionMachine();
			String ResultatDemandeTest = "";
			try {
				ResultatDemandeTest = MaMachine.DemandeIpSQL(MachineDansMaComboBox);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String ResultatdemandeSave = ResultatDemandeTest;

			ResultatPing.setForeground(Color.GRAY);

			if (ResultatDemandeTest == null) {
				ResultatDemandeTest = MachineDansMaComboBox;
				ResultatdemandeSave = MachineDansMaComboBox;

			}

			ZoneTextLog.append("Ping vers " + ResultatdemandeSave + " en cours ..." + "\n");

			try {

				ResultatPing.setForeground(Color.GRAY);

				ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", " ping " + ResultatDemandeTest + " -n 1");
				// pb.directory(new File(CHEMIN));

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

				if (resultping == true) {

					// ResultatPing.setEnabled(true);
					ResultatPing.setText("Ping OK");

					ResultatPing.setForeground(new Color(51, 153, 0));
				}

				if (resultping == false) {
					// ResultatPing.setEnabled(true);
					ResultatPing.setText("Ping KO");

					ResultatPing.setForeground(Color.RED);
				}

				String CharASupprimer = "ÿ";
				String LigneRetourPourAffichage = fluxSortie.LecteurDeFlux();
				LigneRetourPourAffichage = LigneRetourPourAffichage.replaceAll(CharASupprimer, " ");
				ZoneTextLog.append(LigneRetourPourAffichage);

			}
			catch (IOException e1) {
				e1.printStackTrace();
				ZoneTextLog.append("PING KO - Echec de la commande" + "\n");

				GestionLog MaLog = new GestionLog();
				MaLog.EcrireDansFichierLog("Erreur au lancement du ping : " + e1);

			}
			catch (InterruptedException e1) {
				e1.printStackTrace();
				ZoneTextLog.append("PING KO - Echec de la commande" + "\n");

				GestionLog MaLog = new GestionLog();
				MaLog.EcrireDansFichierLog("Erreur au lancement du ping : " + e1);

			}

		}
	}

	public void MajEtatSyteme() throws UnknownHostException

	{

		ManagementFactory.getThreadMXBean();
		OperatingSystemMXBean LeSysteme = ManagementFactory.getOperatingSystemMXBean();
		int NombreThread = Thread.activeCount();

		LeSysteme.getAvailableProcessors();
		LeSysteme.getSystemLoadAverage();

		Double MemoryUsage = (Runtime.getRuntime().totalMemory() * 0.0000001);
		DecimalFormat MemoryFormatDecimal = new DecimalFormat();
		MemoryFormatDecimal.setMaximumFractionDigits(1);
		MemoryFormatDecimal.format(MemoryUsage);
		MonIp = InetAddress.getLocalHost().getHostAddress();

		SimpleDateFormat SimpleDate = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		String LaDateHeure = SimpleDate.format(new java.util.Date());
		LabelDateHeure.setText(LaDateHeure);

		LabelUtilisationMemoire.setText("Utilisation mémoire: " + MemoryFormatDecimal.format(MemoryUsage) + "mo");
		LabelNombreThread.setText("Threads en cours: " + NombreThread);
		LabelAdresseIp.setText("Adresse Ip: " + MonIp);
	}

	public class ThreadRechargementConfigInterface implements Runnable {

		@Override
		public void run() {

			String UserUnix = "#Erreur#";

			GestionSql LaBase = new GestionSql();
			Connection ConnectionBase = LaBase.InitConnexion();
			// TestAccesFichier();
			UserUnix = LaBase.ConsulterUserPilote(ConnectionBase, "Unix");
			GestionMachine MaMachine = new GestionMachine();

			String[] ListeMachinePourComboBox = { "NO MACHINE" };
			try {
				ListeMachinePourComboBox = MaMachine.LireFichierGlossarySQL();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BoutonRadioUserPerso.setText(UserUnix);
			MaComboBox.removeAllItems();
			MaComboBox.setModel(new DefaultComboBoxModel(ListeMachinePourComboBox));

			int Session = LaBase.ConsulterDonneeIntPilote(ConnectionBase, "Session");
			if (Session == 1) {

				MenuItceParisBercy.setSelected(true);
				MenuBourglareine.setSelected(false);
			}
			if (Session == 2) {

				MenuBourglareine.setSelected(true);
				MenuItceParisBercy.setSelected(false);
			}

			// TestAccesFichier();

			LaBase.FermerConnexion(ConnectionBase);
		}

	}

	public void LanceRechargement() {
		new Thread(new ThreadRechargementConfigInterface()).start();
	}

	public class ThreadEtatSysteme implements Runnable {

		@Override
		public void run() {

			while (true) {
				try {
					MajEtatSyteme();
				}
				catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Thread.sleep(500);
				}
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public class ThreadChargementFavoris implements Runnable {

		@Override
		public void run() {

			GestionFavoris GF = new GestionFavoris();
			String Navigateur = SelectionneNavigateur();

			int NombreLigne = 0;
			String[] ListeFavoris = null;

			try {
				NombreLigne = GF.CompteLigneFichierFavoris();
				ListeFavoris = GF.LireFichierFavoris();
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			JMenuItem[] Favoris = new JMenuItem[NombreLigne];

			for (int i = 0; i < NombreLigne; i++) {
				String string = ListeFavoris[i];
				String[] parts = string.split("\t");
				String NomFavoris = parts[0]; // NomFavoris
				String urlFavoris = parts[1]; // UrlFavoris
				Favoris[i] = new JMenuItem(NomFavoris);
				MenuFavorisCommuns.add(Favoris[i]);
				Favoris[i].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {

						// System.out.println("je vais vers : " + urlFavoris);
						ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", urlFavoris);
						try {
							pb.start();
						}
						catch (IOException e) {
							e.printStackTrace();
						}

						ZoneTextLog.append("Ouverture de la page " + NomFavoris + "\n");

					}
				});

			}

		}
	}

	// --------------HOOK

	public class ThreadGrabber implements Runnable {
		SmartRobot SuperRobot;
		private boolean stopThread = false;

		@Override
		public void run() {
			boolean fin = false;
			try {

				SuperRobot = new SmartRobot();
			}
			catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			CK = new CatchKeyboardEvent();
			CK.installKeyGrabber();
			while (!fin) {
				if (CK.RaccourciCapture.equals("Capture") == true) {
					CK.RaccourciCapture = "Rien";
					LanceProduit.LanceCapture();
					ZoneTextLog.append("Raccourci vers l'outil \"Capture\" détecté." + "\n");
				}
				if (CK.RaccourciCapture.equals("Connexion") == true) {
					CK.RaccourciCapture = "Rien";
					ZoneTextLog.append("Raccourci vers Putty+IP détecté." + "\n");
					SuperRobot.writeToClipboard("");
					SuperRobot.EcrireDansClipboard();
					new Thread(new LancePuttyConnexionAutoRaccourci()).start();

				}
				if (CK.RaccourciCapture.equals("Consignes") == true) {
					CK.RaccourciCapture = "Rien";
					ZoneTextLog.append("Raccourci vers les consignes détecté." + "\n");
					ProcessBuilder pb = new ProcessBuilder("explorer.exe", "/select,\\\\fsgcepil\\pilotage\\Consignes de pilotage\\Consignes_Permanente\\");
					try {
						pb.start();
					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				try {
					Thread.sleep(200);
				}
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (this) {
					Thread.yield();

					fin = this.stopThread;
				}

			}

		}

		public synchronized void stop() {
			this.stopThread = true;
		}

	}

	public void ReloadRaccourcis() throws InterruptedException {
		CK.UninstallKeyboard();
		new Thread(new ThreadGrabber()).start();

	}

	public void MajAffichageRaccourcis() throws InterruptedException {

		GestionRaccourcis GC = new GestionRaccourcis();
		String[] TableauDoublon = new String[3];
		new HashSet<String>();

		TableauDoublon[0] = GC.DemandeRaccourci("Capture");
		TableauDoublon[1] = GC.DemandeRaccourci("Connexion");
		TableauDoublon[2] = GC.DemandeRaccourci("Consignes");

		LabelCapture.setText("+ " + TableauDoublon[0] + " = Outil Capture");
		LabelConnexion.setText("+ " + TableauDoublon[1] + " = Connexion s\u00E9lection");
		LabelConsignes.setText("+ " + TableauDoublon[2] + " = Dossier consignes");

		List<String> list = new LinkedList<String>();
		for (int i = 0; i < 3; i++) {
			list.add(TableauDoublon[i]);
		}

		Set<String> set1 = GC.RechercheDoublons(list);
		if (set1.isEmpty() != true) {
			LabelDetectionDoublon.setVisible(true);
		}
		else {
			LabelDetectionDoublon.setVisible(false);
		}
	}

	// ------------------
	public void MiseAjourPositionFenetre() {
		PositionFenetrePrincipale = this.getLocation();
		PositionInterfaceX = this.getX();
		PositionInterfaceY = this.getY();
	}

	public void LirePositionFenetreConfig() {
		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();
		String Retour = LaBase.ConsulterDonneePilote(ConnectionBase, "PositionFenetreDernierLancement");

		if (Retour.equals("true") == true) {
			int PositionInterfaceX = LaBase.ConsulterDonneeIntPilote(ConnectionBase, "PositionFenetreX");
			int PositionInterfaceY = LaBase.ConsulterDonneeIntPilote(ConnectionBase, "PositionFenetreY");

			this.setLocation(PositionInterfaceX, PositionInterfaceY);

		}
		else {
			setLocationRelativeTo(null);
		}
		LaBase.FermerConnexion(ConnectionBase);
	}

	public class ThreadLanceAutoPoste implements Runnable {

		@Override
		public void run() {

			GestionSql LaBase = new GestionSql();
			Connection ConnexionBase = LaBase.InitConnexion();

			if (LaBase.ConsulterDonneePilote(ConnexionBase, "LancementAutoPoste").equals("true") == true) {

				BoutonCancel.setVisible(true);
				int Temps = LaBase.ConsulterDonneeIntPilote(ConnexionBase, "LancementAutoTemps");

				LabelLancementAuto.setVisible(true);
				while (Temps >= 0 && BoutonCancelVar == false) {
					LabelLancementAuto.setText("Lancement automatique dans : " + Temps);
					Temps--;
					try {
						Thread.sleep(500);
						LabelLancementAuto.setForeground(new Color(0, 0, 0));
						Thread.sleep(500);
						LabelLancementAuto.setForeground(new Color(178, 34, 34));
					}
					catch (InterruptedException e) {

						e.printStackTrace();
					}

				}
				if (BoutonCancelVar == false) {
					LabelLancementAuto.setVisible(false);
					LanceAutoPostePilotage();
				}
			}

			if (LaBase.ConsulterDonneePilote(ConnexionBase, "LancementAutoPoste").equals("false") == true) {
				BoutonCancel.setVisible(false);
				LabelLancementAuto.setText("Pas de lancement automatique.");
				try {
					Thread.sleep(2000);
				}
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LabelLancementAuto.setVisible(false);
				BoutonCancel.setVisible(false);
			}
			LabelLancementAuto.setVisible(false);
			BoutonCancel.setVisible(false);

		}

	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}

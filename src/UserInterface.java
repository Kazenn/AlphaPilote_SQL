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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import org.apache.commons.io.FileUtils;
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
	private JLabel LabelTestFichierConfig;
	private JLabel LabelTestFichierMachine;
	private JLabel LabelTestFichierLog;
	private JLabel labelTestCouleurOk;
	private JLabel labelTestCouleurNok;
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
	private JButton BoutonChargerConfig;
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
	// private JMenuItem MenuFav1;
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
	private JButton BoutonChargerFavoris;
	private JMenu MenuParametresHaut;
	private JLabel LabelTestFichierFavoris;
	private JLabel LabelDateHeure;

	public UserInterface() {
		addWindowFocusListener(new WindowFocusListener() {
			@Override
			public void windowGainedFocus(WindowEvent arg0) {
				if (GainedFocus == true) {
					new Thread(new ThreadRechargementConfigInterface()).start();
					MenuFavorisCommuns.removeAll();
					new Thread(new ThreadChargementFavoris()).start();

				}

			}

			@Override
			public void windowLostFocus(WindowEvent arg0) {
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setIconImage(Toolkit.getDefaultToolkit().getImage(UserInterface.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		UserNameStation = System.getProperty("user.name");
		setTitle(" Projet AlphaPilote BETA_ - Prêt à demembrer pour " + UserNameStation + "");
		// setAlwaysOnTop(true);

		setSize(784, 565);
		setLocationRelativeTo(null);

		// PositionFenetrePrincipale = this.getLocation();

		// rootPane.setDefaultButton(BoutonValideIp);

		this.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentMoved(ComponentEvent e) {

				MiseAjoutPositionFenetre();
				// ZoneTextLog.append(MachineDansMaComboBox);
				// ZoneTextLog.setText (ZoneTextLog.getText() + "\n");

			}
		});

		// new GestionLog();
		// Boolean b = CreationProfileAlphaPilote(UserNameStation);

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

				int ResultatToutFichiersPresents = TestAccesFichier();
				if (ResultatToutFichiersPresents == 3) {
					ZoneTextLog.append("L'accès à tous les fichiers est valide" + "\n");

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

		MenuFavoris = new JMenu("Favoris web");
		BarreMenuPrincipale.add(MenuFavoris);

		JScrollPane ScrollZoneTextLog = new JScrollPane();
		ScrollZoneTextLog.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ScrollZoneTextLog.setViewportBorder(new TitledBorder(null, "Log", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		ScrollZoneTextLog.setBounds(10, 288, 478, 201);
		getContentPane().add(ScrollZoneTextLog);

		ZoneTextLog = new JTextArea();
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

				LancePutty();

			}
		});

		JMenuItem MenuOutlook = new JMenuItem("Outlook 2014");
		final ImageIcon IconOutlook = new ImageIcon(getClass().getResource("/Outlook-icon.png"));
		MenuOutlook.setIcon(IconOutlook);

		MenuOutlook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				LanceOutlook();

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
					LanceControlm();
				}
				catch (IOException e) {

					e.printStackTrace();

					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement de control-m : " + e);
					ZoneTextLog.append("Erreur au lancement de control-m: Consulter la log." + "\n");

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

				LanceIprox();

			}
		});
		MenuOutils.add(MenuIprox);

		MenuArsRemedy = new JMenuItem("ARSv7 Remedy");
		final ImageIcon IconArsRemedy = new ImageIcon(getClass().getResource("/ars-icon.png"));
		MenuArsRemedy.setIcon(IconArsRemedy);
		MenuArsRemedy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				LanceArsRemedy();

			}
		});
		MenuOutils.add(MenuArsRemedy);

		MenuArsV8 = new JMenuItem("ARSv8 (client l\u00E9ger)");
		MenuArsV8.setIcon(IconArsRemedy);
		MenuArsV8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				LanceArsV8();
			}
		});
		MenuOutils.add(MenuArsV8);

		MenuArsCff = new JMenuItem("ARS Cff");
		MenuArsCff.setIcon(IconArsRemedy);
		MenuArsCff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				LanceArsCff();
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

				LancePuttyCm();
			}
		});
		MenuOutils.add(MenuPuttyCm);
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

				LanceVtomIp1q();

			}
		});
		mnVtom.add(MenuVtomIp1q);

		JMenuItem MenuVtomIp1d = new JMenuItem("IP1 UP2TO003");
		MenuVtomIp1d.setIcon(IconVtom);
		MenuVtomIp1d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceVtomIp1d();
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
				LanceVtomIp2q();
			}
		});
		mnVtom.add(MenuVtomIp2q);

		JMenuItem MenuVtomIp2d = new JMenuItem("IP2 UP1TO003");
		MenuVtomIp2d.setIcon(IconVtom);
		MenuVtomIp2d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceVtomIp2d();
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

				LanceExceed();
			}
		});
		MenuTinaExceed.add(MenuExceed);

		JMenuItem MenuCltec5 = new JMenuItem("Tina Cltec5");
		final ImageIcon IconTina5 = new ImageIcon(getClass().getResource("/tina-icon.jpg"));
		MenuCltec5.setIcon(IconTina5);
		MenuCltec5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				LanceTinaCltec5();

			}
		});
		MenuTinaExceed.add(MenuCltec5);

		JMenuItem mntmTinaCltec = new JMenuItem("Tina Cltec6");
		mntmTinaCltec.setIcon(IconTina5);
		mntmTinaCltec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceTinaCltec6();
			}
		});
		MenuTinaExceed.add(mntmTinaCltec);

		MenuTinaIp1Siris = new JMenuItem("Tina UP2TS004 (IP1- Siris1)");
		MenuTinaIp1Siris.setIcon(IconTina5);
		MenuTinaIp1Siris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceTinaSiris1();
			}
		});
		MenuTinaExceed.add(MenuTinaIp1Siris);

		MenuTinaIp1Tinap203 = new JMenuItem("Tina UP2TS004 (IP1 - Tinap203)");
		MenuTinaIp1Tinap203.setIcon(IconTina5);
		MenuTinaIp1Tinap203.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				LanceTinaTinap203();
			}
		});
		MenuTinaExceed.add(MenuTinaIp1Tinap203);

		mntmTina = new JMenuItem("Tina UP1TS004 (IP2 - Tinap105 & 103)");
		mntmTina.setIcon(IconTina5);
		mntmTina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				LanceTinaTinap105103();
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
				LanceCfta();
			}
		});
		MenuCFT.add(MenuCfta);

		MenuCftacore = new JMenuItem("CFTACORE");
		MenuCftacore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceCftacore();
			}
		});
		MenuCFT.add(MenuCftacore);

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

				LanceZmvs();

			}
		});

		MenuSysa = new JMenuItem("Sysa");
		final ImageIcon IconSysa = new ImageIcon(getClass().getResource("/Letter-A-blue-icon.png"));
		MenuSysa.setIcon(IconSysa);
		MenuSysa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				LanceSysa();

			}
		});
		SousMenuConnexionMvs.add(MenuSysa);

		MenuKmvs = new JMenuItem("Kmvs (IP0)");
		final ImageIcon IconKmvs = new ImageIcon(getClass().getResource("/Letter-K-red-icon.png"));
		MenuKmvs.setIcon(IconKmvs);
		MenuKmvs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				LanceKmvs();

			}
		});

		MenuSysg = new JMenuItem("Sysg (XENOS)");
		final ImageIcon IconSysg = new ImageIcon(getClass().getResource("/g-icon.png"));
		MenuSysg.setIcon(IconSysg);
		MenuSysg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				LanceSysg();

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

				LanceIp1();
			}
		});
		SousMenuConnexionMvs.add(MenuIp1);

		MenuIp2 = new JMenuItem("IP2");
		final ImageIcon IconIp2 = new ImageIcon(getClass().getResource("/2-icon.png"));
		MenuIp2.setIcon(IconIp2);
		MenuIp2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceIp2();
			}
		});
		SousMenuConnexionMvs.add(MenuIp2);

		MenuIp3 = new JMenuItem("IP3");
		final ImageIcon IconIp3 = new ImageIcon(getClass().getResource("/3_icon.png"));
		MenuIp3.setIcon(IconIp3);
		MenuIp3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				LanceIp3();
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

				LanceBmvs();
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

				LanceAs400Br();
			}
		});
		MenuAS400.add(MenuAS400Br);

		MenuAS400Bdi = new JMenuItem("BDICLY");
		final ImageIcon IconAS400Bdi = new ImageIcon(getClass().getResource("/as400-icon.png"));
		MenuAS400Bdi.setIcon(IconAS400Bdi);
		MenuAS400Bdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				LanceAs400Bdi();
			}
		});
		MenuAS400.add(MenuAS400Bdi);

		MenuAS400Bdaf = new JMenuItem("BDAFCLY");
		final ImageIcon IconAS400Bdaf = new ImageIcon(getClass().getResource("/as400-icon.png"));
		MenuAS400Bdaf.setIcon(IconAS400Bdaf);
		MenuAS400Bdaf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				LanceAs400Bdaf();
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

				LanceAs400Socly();
			}
		});
		MenuAS400.add(MenuAS400Socly);

		MenuSocmcsd = new JMenuItem("SOCMCSD");
		final ImageIcon IconAS400Socmscd = new ImageIcon(getClass().getResource("/as400-icon.png"));
		MenuSocmcsd.setIcon(IconAS400Socmscd);
		MenuSocmcsd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceAs400Socmcsd();
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
				LanceAs400Pfb();
			}
		});
		MenuAS400.add(MenuPfbcly);

		MenuGmvs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				LanceGmvs();
			}
		});
		getContentPane().setLayout(null);

		JPanel PaneZoneConnexion = new JPanel();
		PaneZoneConnexion.setSize(new Dimension(10, 10));
		PaneZoneConnexion.setOpaque(false);
		PaneZoneConnexion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Connexion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 99, 71)));
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

		MenuBbr = new JMenuItem("BBR(Buisness Bridge)");
		final ImageIcon IconBbr = new ImageIcon(getClass().getResource("/bbr-icon.png"));
		MenuBbr.setIcon(IconBbr);
		MenuBbr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				LanceBbr();
			}
		});
		MenuFavoris.add(MenuBbr);

		MenuOseIp1 = new JMenuItem("OSE ip1");
		final ImageIcon IconOseIp1 = new ImageIcon(getClass().getResource("/ose-icon.png"));
		MenuOseIp1.setIcon(IconOseIp1);
		MenuOseIp1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceOseIp1();

			}
		});
		MenuFavoris.add(MenuOseIp1);

		MenuOseIp2 = new JMenuItem("OSE ip2");
		final ImageIcon IconOseip2 = new ImageIcon(getClass().getResource("/ose-icon.png"));
		MenuOseIp2.setIcon(IconOseip2);
		MenuOseIp2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceOseIp2();
			}
		});
		MenuFavoris.add(MenuOseIp2);

		MenuIpLabel = new JMenuItem("ip-Label");
		final ImageIcon IconIpLabel = new ImageIcon(getClass().getResource("/iplabel-icon.png"));
		MenuIpLabel.setIcon(IconIpLabel);
		MenuIpLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceIpLabel();
			}
		});
		MenuFavoris.add(MenuIpLabel);

		MenuNewtest = new JMenuItem("Newtest");
		final ImageIcon IconNewtest = new ImageIcon(getClass().getResource("/newtest-icon.png"));
		MenuNewtest.setIcon(IconNewtest);
		MenuNewtest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceNewtest();
			}
		});
		MenuFavoris.add(MenuNewtest);

		MenuXguard = new JMenuItem("Xguard");
		final ImageIcon IconXguard = new ImageIcon(getClass().getResource("/xguard-icon.png"));
		MenuXguard.setIcon(IconXguard);
		MenuXguard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceXguard();
			}
		});
		MenuFavoris.add(MenuXguard);

		MenuHmc = new JMenuItem("HMC web1");
		final ImageIcon IconHmc = new ImageIcon(getClass().getResource("/hmc-icon.PNG"));
		MenuHmc.setIcon(IconHmc);
		MenuHmc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				LanceHmc();
			}
		});
		MenuFavoris.add(MenuHmc);

		MenuKvm = new JMenuItem("KVM");
		final ImageIcon IconKvm = new ImageIcon(getClass().getResource("/kvm-icon.PNG"));
		MenuKvm.setIcon(IconKvm);
		MenuKvm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceKvm();
			}
		});
		MenuFavoris.add(MenuKvm);

		MenuTina5 = new JMenuItem("Tina web Cltec5");
		final ImageIcon IconTina = new ImageIcon(getClass().getResource("/tina-icon.jpg"));
		MenuTina5.setIcon(IconTina);
		MenuTina5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceTina5();
			}
		});
		MenuFavoris.add(MenuTina5);

		MenuTina6 = new JMenuItem("Tina web Cltec6");
		MenuTina6.setIcon(IconTina);
		MenuTina6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceTina6();
			}
		});
		MenuFavoris.add(MenuTina6);

		MenuVcenter = new JMenuItem("Vcenter (VMware)");
		final ImageIcon IconVcenter = new ImageIcon(getClass().getResource("/vmware-icon.png"));
		MenuVcenter.setIcon(IconVcenter);
		MenuVcenter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceVcenter();
			}
		});
		MenuFavoris.add(MenuVcenter);

		MenuWebIas = new JMenuItem("Web IAS");
		final ImageIcon IconIas = new ImageIcon(getClass().getResource("/ias-icon.png"));
		MenuWebIas.setIcon(IconIas);
		MenuWebIas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				LanceWebIas();
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
				LanceSismoIp1();
			}
		});
		mnSismo.add(MenuSismoIp1);

		MenuSismoIp2 = new JMenuItem("Sismo/cd IP2");
		MenuSismoIp2.setIcon(IconSismo);
		MenuSismoIp2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceSismoIp2();
			}
		});
		mnSismo.add(MenuSismoIp2);

		MenuSismoOceor = new JMenuItem("Sismo/cd Oceor");
		MenuSismoOceor.setIcon(IconSismo);
		MenuSismoOceor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceSismoOceor();
			}
		});
		mnSismo.add(MenuSismoOceor);

		MenuSismoPalatine = new JMenuItem("Sismo/cd Palatine");
		MenuSismoPalatine.setIcon(IconSismo);
		MenuSismoPalatine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				LanceSismoPalatine();

			}
		});
		mnSismo.add(MenuSismoPalatine);
		MenuOdip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				LanceOdip();

			}
		});

		JMenu MenuGestion = new JMenu("Gestion");

		BarreMenuPrincipale.add(MenuGestion);

		JMenuItem MenuModifierFichierConfig = new JMenuItem("Gestion des acc\u00E8s (UNIX/WIN/MVS/AS400)");
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

				UserInterfaceEditionMachine PageEditionMachine = null;
				try {
					PageEditionMachine = new UserInterfaceEditionMachine();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				PageEditionMachine.setVisible(true);
				PageEditionMachine.setSize(800, 600);
				PageEditionMachine.setLocation(PositionFenetrePrincipale);
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

		JMenuItem MenuParametres = new JMenuItem("Param\u00EAtres G\u00E9n\u00E9raux et bouton \"lancer poste complet\" ");
		MenuParametresHaut.add(MenuParametres);
		MenuParametres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				GainedFocus = true;
				UserInterfaceParametres PageParametres = new UserInterfaceParametres();

				PageParametres.setVisible(true);
				PageParametres.setSize(750, 480);
				PageParametres.setLocation(PositionFenetrePrincipale);
			}
		});
		MenuParametres.setIcon(new ImageIcon(UserInterface.class.getResource("/com/sun/javafx/scene/web/skin/AlignJustified_16x16_JFX.png")));

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
		MenuAPropos.add(MenuSignalerUnBug);

		JMenuItem MenuInterrogation = new JMenuItem("?");
		MenuAPropos.add(MenuInterrogation);

		JButton BoutonValideMstsc = new JButton("TS (mstsc)");
		BoutonValideMstsc.setMargin(new Insets(0, 0, 0, 0));
		BoutonValideMstsc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				GestionMachine MaMachine = new GestionMachine();
				String Resultatdemande = MaMachine.DemandeIp(MachineDansMaComboBox);
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
		ZoneConnexionAutoLogin.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Auto login (SSH seulement)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 102,
				204)));
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
		MaBarreProgression.setBounds(10, 491, 169, 14);
		getContentPane().add(MaBarreProgression);
		MaBarreProgression.setIndeterminate(true);
		MaBarreProgression.setForeground(new Color(178, 34, 34));

		JPanel ZoneConfig = new JPanel();
		ZoneConfig.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Raccourcis", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 99, 71)));
		ZoneConfig.setBounds(558, 2, 216, 146);
		getContentPane().add(ZoneConfig);
		ZoneConfig.setLayout(null);

		BoutonChargerConfig = new JButton("Recharger configuration");
		final ImageIcon IconBoutonRecharger = new ImageIcon(getClass().getResource("/reload-icon.png"));
		BoutonChargerConfig.setIcon(IconBoutonRecharger);
		BoutonChargerConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				// LECTURE USER UNIX
				// THREADCHARGECONFIG
				// --------------------------------------------------------
				new Thread(new ThreadRechargementConfigInterface()).start();
				ZoneTextLog.append("Profile rechargé correctement." + "\n");

			}
		});
		BoutonChargerConfig.setBounds(6, 16, 200, 23);
		ZoneConfig.add(BoutonChargerConfig);

		BoutonChargerFavoris = new JButton("Recharger les favoris");
		final ImageIcon IconBoutonRechargerFavoris = new ImageIcon(getClass().getResource("/rsz_1legendary-marker_1.png"));
		BoutonChargerFavoris.setIcon(IconBoutonRechargerFavoris);
		BoutonChargerFavoris.setMargin(new Insets(1, 1, 1, 1));
		BoutonChargerFavoris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				MenuFavorisCommuns.removeAll();

				new Thread(new ThreadChargementFavoris()).start();
				ZoneTextLog.append("Favoris communs rechargés." + "\n");
			}
		});
		BoutonChargerFavoris.setBounds(6, 50, 200, 23);
		ZoneConfig.add(BoutonChargerFavoris);

		JPanel PanelZoneTestFichier = new JPanel();
		PanelZoneTestFichier.setForeground(new Color(255, 69, 0));
		PanelZoneTestFichier.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acc\u00E8s aux fichiers", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 99, 71)));
		PanelZoneTestFichier.setBounds(604, 314, 164, 175);
		getContentPane().add(PanelZoneTestFichier);
		PanelZoneTestFichier.setLayout(null);

		LabelTestFichierConfig = new JLabel(" Fichier configuration");
		LabelTestFichierConfig.setBounds(6, 30, 122, 14);
		PanelZoneTestFichier.add(LabelTestFichierConfig);
		LabelTestFichierConfig.setOpaque(true);
		LabelTestFichierConfig.setBackground(new Color(192, 192, 192));
		LabelTestFichierConfig.setToolTipText("");

		LabelTestFichierMachine = new JLabel(" Fichier machine");
		LabelTestFichierMachine.setBounds(6, 80, 98, 14);
		PanelZoneTestFichier.add(LabelTestFichierMachine);
		LabelTestFichierMachine.setBackground(new Color(192, 192, 192));
		LabelTestFichierMachine.setOpaque(true);

		LabelTestFichierLog = new JLabel(" Fichier log");
		LabelTestFichierLog.setBounds(6, 105, 65, 14);
		PanelZoneTestFichier.add(LabelTestFichierLog);
		LabelTestFichierLog.setBackground(new Color(192, 192, 192));
		LabelTestFichierLog.setOpaque(true);

		LabelTestFichierFavoris = new JLabel(" Fichier favoris");
		LabelTestFichierFavoris.setBounds(6, 55, 90, 14);
		LabelTestFichierFavoris.setOpaque(true);
		LabelTestFichierFavoris.setBackground(new Color(192, 192, 192));
		PanelZoneTestFichier.add(LabelTestFichierFavoris);

		labelTestCouleurOk = new JLabel(" Acc\u00E8s OK");
		labelTestCouleurOk.setBounds(6, 150, 59, 14);
		PanelZoneTestFichier.add(labelTestCouleurOk);
		labelTestCouleurOk.setOpaque(true);
		labelTestCouleurOk.setBackground(new Color(60, 179, 113));

		labelTestCouleurNok = new JLabel(" Acc\u00E8s NOK");
		labelTestCouleurNok.setBounds(81, 150, 73, 14);
		PanelZoneTestFichier.add(labelTestCouleurNok);
		labelTestCouleurNok.setOpaque(true);
		labelTestCouleurNok.setBackground(new Color(178, 34, 34));

		JPanel PaneZonePreparationPostePilotage = new JPanel();
		PaneZonePreparationPostePilotage.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pr\u00E9paration poste pilotage", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(65, 105, 225)));
		PaneZonePreparationPostePilotage.setBounds(359, 2, 189, 180);
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
		panel.setBounds(6, 91, 173, 78);
		PaneZonePreparationPostePilotage.add(panel);
		panel.setLayout(null);

		JButton BoutonToutVtom = new JButton("Vtom");
		BoutonToutVtom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				try {

					LanceVtomIp1q();
					Thread.sleep(1000);
					LanceVtomIp1d();
					Thread.sleep(1000);
					LanceVtomIp2q();
					Thread.sleep(1000);
					LanceVtomIp2d();
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
					LanceSysa();
					Thread.sleep(500);
					LanceKmvs();
					Thread.sleep(500);
					LanceSysg();
					Thread.sleep(500);
					LanceZmvs();
					Thread.sleep(500);
					LanceGmvs();
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

					LanceAs400Br();
					Thread.sleep(500);
					LanceAs400Bdi();
					Thread.sleep(500);
					LanceAs400Bdaf();
					Thread.sleep(500);
					LanceAs400Socly();
					Thread.sleep(500);
					LanceAs400Socmcsd();
					Thread.sleep(500);
					LanceAs400Pfb();
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
		ProgressBarExecutionGlobale.setBounds(236, 227, 270, 23);
		getContentPane().add(ProgressBarExecutionGlobale);

		LabelUtilisationMemoire = new JLabel("Utilisation m\u00E9moire : ");
		LabelUtilisationMemoire.setForeground(new Color(205, 92, 92));
		LabelUtilisationMemoire.setBounds(189, 491, 164, 14);
		getContentPane().add(LabelUtilisationMemoire);

		LabelNombreThread = new JLabel("Threads en cours :");
		LabelNombreThread.setForeground(new Color(95, 158, 160));
		LabelNombreThread.setBounds(355, 491, 117, 14);
		getContentPane().add(LabelNombreThread);

		LabelAdresseIp = new JLabel("Adresse IP :");
		LabelAdresseIp.setForeground(new Color(100, 149, 237));
		LabelAdresseIp.setBounds(482, 491, 156, 14);
		getContentPane().add(LabelAdresseIp);

		LabelDateHeure = new JLabel("Date/heure :");
		LabelDateHeure.setBounds(648, 491, 120, 14);
		getContentPane().add(LabelDateHeure);

		BoutonValideSsh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				try {
					LancePuttyConnexionSsh();
				}
				catch (AWTException e1) {
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

				LancePuttyConnexionTelnet();

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

		// new Thread(new LanceWendyTelnet()).start();
		// ---------------------------------------------
		//
		//
		// DEMARRAGE FENETRE, INIT PRODUIT
		//
		//
		//
		// ----------------------------------------------
		UserNameStation = System.getProperty("user.name");
		CreationProfileAlphaPilote(UserNameStation);
		TestAccesFichier();
		new Thread(new ThreadEtatSysteme()).start();
		new Thread(new ThreadChargementFavoris()).start();

		// new Thread(new ThreadRechargementConfigInterface()).start();

		// LISTENNER KEYBOARD

		if (SuccesCreation == true) {
			ZoneTextLog.append("Le profile pour " + UserNameStation + " n'existait pas, il vient d'être créé avec tous les fichiers nécessaires." + "\n");
			ZoneTextLog.append("Rendez-vous sur la page de saisie des accès UNIX/MVS/AS00 (se trouvant dans le menu Gestion), valider une première fois à vide pour initialiser la clef d'encryption."
					+ "\n");
		}

		new Thread(new ThreadRechargementConfigInterface()).start();
	}

	/**
	 * @category SystemInit
	 */
	public int TestAccesFichier() {
		GestionChemin RequeteChemin = new GestionChemin();
		File FichierMachine = new File(RequeteChemin.DemandeChemin("CheminFichierMachine"));
		int ResultatToutFichiersPresents = 0;
		if (FichierMachine.exists()) {
			LabelTestFichierMachine.setBackground(new Color(60, 179, 113));
			LabelTestFichierMachine.setOpaque(true);
			ResultatToutFichiersPresents++;
		}
		else {
			ZoneTextLog.append("Impossible de trouver le fichier machine : " + RequeteChemin.DemandeChemin("CheminFichierMachine") + "\n");
			LabelTestFichierMachine.setBackground(new Color(178, 34, 34));
			LabelTestFichierConfig.setOpaque(true);
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur lors du test présence du fichier machine dans : " + RequeteChemin.DemandeChemin("CheminFichierFavoris"));
		}
		File FichierFavoris = new File(RequeteChemin.DemandeChemin("CheminFichierFavoris"));
		if (FichierFavoris.exists()) {
			LabelTestFichierFavoris.setBackground(new Color(60, 179, 113));
			LabelTestFichierFavoris.setOpaque(true);
			ResultatToutFichiersPresents++;
		}
		else {
			ZoneTextLog.append("Impossible de trouver le fichier favoris : " + RequeteChemin.DemandeChemin("CheminFichierFavoris") + "\n");
			LabelTestFichierFavoris.setBackground(new Color(178, 34, 34));
			LabelTestFichierFavoris.setOpaque(true);
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur lors du test présence du fichier favoris dans : " + RequeteChemin.DemandeChemin("CheminFichierFavoris"));
		}
		File FichierConfig = new File(RequeteChemin.DemandeChemin("CheminFichierConfig"));
		if (FichierConfig.exists()) {
			LabelTestFichierConfig.setBackground(new Color(60, 179, 113));
			LabelTestFichierConfig.setOpaque(true);
			ResultatToutFichiersPresents++;
		}
		else {
			ZoneTextLog.append("Impossible de trouver le fichier de config : " + RequeteChemin.DemandeChemin("CheminFichierConfig") + "\n");
			LabelTestFichierConfig.setBackground(new Color(178, 34, 34));
			LabelTestFichierConfig.setOpaque(true);
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur lors du test présence du fichier config dans : " + RequeteChemin.DemandeChemin("CheminFichierMachine"));
		}
		File FichierLog = new File(RequeteChemin.DemandeChemin("CheminFichierLog"));
		if (FichierLog.exists()) {
			LabelTestFichierLog.setBackground(new Color(60, 179, 113));
			LabelTestFichierLog.setOpaque(true);
			ResultatToutFichiersPresents++;
		}
		else {
			ZoneTextLog.append("Impossible de trouver le fichier de log : " + RequeteChemin.DemandeChemin("CheminFichierLog") + "\n");
			ZoneTextLog.append("Création d'un nouveau fichier de log" + "\n");
			// ZoneTextLog.append("Consulter la log dans le menu aide pour avoir plus d'informations"+"\n");
			LabelTestFichierLog.setBackground(new Color(60, 179, 113));
			LabelTestFichierLog.setOpaque(true);
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur lors du test présence du fichier log dans : " + RequeteChemin.DemandeChemin("CheminFichierMachine"));
			ResultatToutFichiersPresents++;

		}
		return ResultatToutFichiersPresents;
	}

	public Boolean CreationProfileAlphaPilote(String UserNameStation) {
		GestionChemin GC = new GestionChemin();
		File DossierProfileStation = new File(GC.DemandeChemin("CheminProfileStationGeneral"));

		if (DossierProfileStation.exists()) {
			// System.out.println(GC.DemandeChemin("CheminProfileIprox"));
		}
		else {
			SuccesCreation = DossierProfileStation.mkdir();
			File Source = new File(GC.DemandeChemin("CheminProfileStationVierge"));

			if (SuccesCreation == true) {
				try {
					FileUtils.copyDirectory(Source, DossierProfileStation);
				}
				catch (IOException e) {

					e.printStackTrace();
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur lors de la copie du profile de base vers le nouveau : " + e);
					ZoneTextLog.append("Erreur lors de la copie du profile de base vers le nouveau : Consulter la log." + "\n");

				}
			}

		}

		return false;

	}

	/**
	 * @category Lancement des Outils
	 */
	public void LancePutty() {
		GestionLog MaLog = new GestionLog();
		GestionChemin Chemin = new GestionChemin();

		ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminPutty") });
		try {
			builder.start();
		}
		catch (IOException e) {

			e.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

		}
	}

	public void LanceOutlook() {
		GestionLog MaLog = new GestionLog();
		GestionChemin Chemin = new GestionChemin();

		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminOutlook") + " /recycle"));
			ZoneTextLog.append("Ouverture d'Outlook" + "\n");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'Outlook: " + e);
			ZoneTextLog.append("Erreur au d'Outlook : Consulter la log." + "\n");

		}

	}

	public void LanceControlm() throws IOException {

		GestionChemin Chemin = new GestionChemin();
		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminControlm") + " -u PiloteGo -p goatos -m kaji -vp \"All Jobs\""));
			ZoneTextLog.append("Ouverture de Control-m" + "\n");
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void LanceIprox() {
		GestionChemin Chemin = new GestionChemin();

		// Runtime.getRuntime().exec(String.format("cmd.exe"+" start "+"\""+Chemin.DemandeChemin("CheminIprox")+"\""));
		ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Chemin.DemandeChemin("CheminIprox"));
		try {
			pb.start();
			ZoneTextLog.append("Ouverture du portail Iprox" + "\n");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'Iprox : " + e);
			ZoneTextLog.append("Erreur au lancement d'Iprox : Consulter la log." + "\n");

		}

	}

	public void LanceArsRemedy() {
		GestionChemin Chemin = new GestionChemin();
		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminArsRemedy")));
			ZoneTextLog.append("Ouverture d'ARS Remedy v7" + "\n");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'ARS-Remedy v7 : " + e);
			ZoneTextLog.append("Erreur au lancement d'ARS-Remedy v7 : Consulter la log." + "\n");

		}

	}

	public void LancePuttyCm() {
		GestionChemin Chemin = new GestionChemin();
		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminPuttyCm")));
			ZoneTextLog.append("Ouverture de Putty Connection Manager." + "\n");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Putty Connection Manager : " + e);
			ZoneTextLog.append("Erreur au lancement de Putty Connection Manager: Consulter la log." + "\n");

		}

	}

	public void LanceExceed() {
		GestionChemin Chemin = new GestionChemin();
		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminExceed")));
			ZoneTextLog.append("Ouverture d'Exceed." + "\n");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'exceed : " + e);
			ZoneTextLog.append("Erreur au lancement d'exceed Manager: Consulter la log." + "\n");

		}

	}

	public void LanceTinaCltec5() {
		GestionChemin RequeteChemin = new GestionChemin();
		GestionProfile ModifProfileTina = new GestionProfile();
		try {
			ModifProfileTina.ModifierIpTina("tina.txt");
			Runtime.getRuntime()
					.exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " -ssh root@126.40.230.16 -pw cpnonart -m " + "\"" + RequeteChemin.DemandeChemin("CheminTinaMacro") + "tina.txt"
							+ "\""));
			ZoneTextLog.append("Ouverture de Tina Cltec5. " + "\n");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Tina Cltec5: " + e);
			ZoneTextLog.append("Erreur au lancement de Tina Cltec5: Consulter la log." + "\n");

		}

	}

	public void LanceTinaCltec6() {
		GestionChemin RequeteChemin = new GestionChemin();
		GestionProfile ModifProfileTina = new GestionProfile();
		try {
			ModifProfileTina.ModifierIpTina("tina.txt");
			Runtime.getRuntime()
					.exec(String.format(RequeteChemin.DemandeChemin("CheminPutty") + " -ssh root@126.196.96.22 -pw bullbull -m " + "\"" + RequeteChemin.DemandeChemin("CheminTinaMacro") + "tina.txt"
							+ "\""));
			ZoneTextLog.append("Ouverture de Tina Cltec6." + "\n");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Tina Cltec6: " + e);
			ZoneTextLog.append("Erreur au lancement de Tina Cltec6: Consulter la log." + "\n");

		}
	}

	public void LanceTinaSiris1() {
		GestionChemin RequeteChemin = new GestionChemin();
		GestionProfile ModifProfileTina = new GestionProfile();
		try {
			ModifProfileTina.ModifierIpTina("tina_UP2TS004_SIRIS1.txt");
			Runtime.getRuntime().exec(
					String.format(RequeteChemin.DemandeChemin("CheminPutty") + " -ssh root@126.196.230.13 -pw bullbull -m " + "\"" + RequeteChemin.DemandeChemin("CheminTinaMacro")
							+ "tina_UP2TS004_SIRIS1.txt" + "\""));
			ZoneTextLog.append("Ouverture de Tina UP2TS004 catalogue Siris1." + "\n");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Tina UP2TS004 catalogue Siris1: " + e);
			ZoneTextLog.append("Erreur au lancement de Tina UP2TS004 catalogue Siris1: Consulter la log." + "\n");

		}
	}

	public void LanceTinaTinap203() {
		GestionChemin RequeteChemin = new GestionChemin();
		GestionProfile ModifProfileTina = new GestionProfile();
		try {
			ModifProfileTina.ModifierIpTina("tina_UP2TS004_TINAP203.txt");
			Runtime.getRuntime().exec(
					String.format(RequeteChemin.DemandeChemin("CheminPutty") + " -ssh root@126.196.230.13 -pw bullbull -m " + "\"" + RequeteChemin.DemandeChemin("CheminTinaMacro")
							+ "tina_UP2TS004_TINAP203.txt" + "\""));
			ZoneTextLog.append("Ouverture de Tina UP2TS004 catalogue TINAP203." + "\n");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Tina UP2TS004 catalogue TINAP203: " + e);
			ZoneTextLog.append("Erreur au lancement de Tina UP2TS004 catalogue TINAP203: Consulter la log." + "\n");

		}
	}

	public void LanceTinaTinap105103() {
		GestionChemin RequeteChemin = new GestionChemin();
		GestionProfile ModifProfileTina = new GestionProfile();
		try {
			ModifProfileTina.ModifierIpTina("tina_UP1TS004.txt");
			Runtime.getRuntime().exec(
					String.format(RequeteChemin.DemandeChemin("CheminPutty") + " -ssh root@126.40.230.119 -pw bullbull -m " + "\"" + RequeteChemin.DemandeChemin("CheminTinaMacro")
							+ "tina_UP1TS004.txt" + "\""));
			ZoneTextLog.append("Ouverture de Tina UP2TS004 catalogue TINAP105 et 103" + "\n");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Tina UP2TS004 catalogue TINAP105 et 103: " + e);
			ZoneTextLog.append("Erreur au lancement de Tina UP2TS004 catalogue TINAP105 et 103: Consulter la log." + "\n");

		}
	}

	public String SelectionneNavigateur() {

		GestionConfig AccesConfig = new GestionConfig();
		String Navigateur = "";
		Navigateur = AccesConfig.DemandeDefaultBrowser();
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

		}
		return Navigateur;
	}

	public void LanceOdip() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuOdip.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'ODIP : " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceBbr() {
		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "",
					"http://hypervision-presentation.sigce.caisse-epargne.fr:8080/MeteoServices/faces/custom/pages/moduleWVA/sd_macroView.jsp?wall=false");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuBbr.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de BBR : " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}
	}

	public void LanceIpLabel() {
		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://gx.ip-label.net/client/Section3_1/");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuIpLabel.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'Ip-Label: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}
	}

	public void LanceNewtest() {
		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://newtest_prod/NMC/Supervision/StatusMonitoring.aspx");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuNewtest.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Newtest: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}
	}

	public void LanceOseIp1() {
		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://oseserv.siris.caisse-epargne.fr:8080/cgi-bin/etatserv.exe?sit=MAIL&totm=oui&pag=MA_ALL11&rfh=oui");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuOseIp1.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'OSE ip1: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}
	}

	public void LanceOseIp2() {
		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://oseserv.sigce.caisse-epargne.fr:8080/cgi-bin/etatserv.exe?sit=MAIL&totm=oui&pag=MA_ALL11&rfh=oui");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuOseIp2.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'OSE ip2: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}
	}

	public void LanceXguard() {
		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://pilotage-xg.supragrp.caisse-epargne.fr/ihmxgd/web/app.php");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuXguard.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'Xguard: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}
	}

	public void LanceHmc() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "https://126.199.169.23/preloginmonitor/index.jsp");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuHmc.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de la HMC : " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceKvm() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "https://dsview.gtm.caisse-epargne.fr/dsview/protected/login.do");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuKvm.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de la page KVM: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceTina5() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://126.40.230.16:25088/tina");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuTina5.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de la page TINA Cltec5: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceTina6() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://126.196.96.22:25088/tina");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuTina6.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de la page TINA Cltec6: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceVcenter() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "https://vcenterweb.sigce.caisse-epargne.fr:9443/vsphere-client/?locale=en_US");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuVcenter.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Vcenter (VM): " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceSismoIp1() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://126.196.230.23/env1.etat.technique.php");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuSismoIp1.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Sismo IP1: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceSismoIp2() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://126.196.224.12/env1.etat.technique.php");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuSismoIp2.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Sismo IP2: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceSismoOceor() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://126.196.230.61/env1.etat.technique.php");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuSismoOceor.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Sismo Oceor: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceSismoPalatine() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://up5bd010/sismocdFIL.php");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuSismoPalatine.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Sismo Palatine: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceArsV8() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "",
					"http://arsv8.sigce.caisse-epargne.fr/arsys/forms/arsv8-ppr/SHR%3ALandingConsole/Default+Administrator+View/?cacheid=28c87c35");
			pb.start();

			ZoneTextLog.append("Ouverture de la page " + MenuArsV8.getText() + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'ARS v8: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceWebIas() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://ias3.supragrp.caisse-epargne.fr");
			pb.start();

			ZoneTextLog.append("Ouverture de la page Web IAS" + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Web IAS: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceCfta() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://sysa:3578/");
			pb.start();

			ZoneTextLog.append("Ouverture de la page CFTA" + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de CFTA: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceCftacore() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://sysa:3579/");
			pb.start();

			ZoneTextLog.append("Ouverture de la page CFTACORE" + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de CFTACORE: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceArsCff() {

		String Navigateur = SelectionneNavigateur();

		try {
			// Runtime.getRuntime().exec(String.format(Navigateur + " " +
			// "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action"));
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://126.238.65.2:8080/arsys/shared/login.jsp?/arsys/");
			pb.start();

			ZoneTextLog.append("Ouverture de la page Ars CFF" + "\n");

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de l'ARS CFF: " + e);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

			e.printStackTrace();
		}

	}

	public void LanceVtomIp1q() {

		GestionConfig FichierConfig = new GestionConfig();
		GestionChemin RequeteChemin = new GestionChemin();
		String UserWindows = "";
		String PassWindows = "";
		UserWindows = FichierConfig.DemandeUser("Windows");
		PassWindows = FichierConfig.DemandePassword("Windows");

		try {
			Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminVtom") + " -u " + UserWindows + " -p " + PassWindows + " -s UP2TO002:30017 " + " -d Pilote"));
			ZoneTextLog.append("Ouverture de VTOM IP1 journalier sur UP2TO002:30017" + "\n");

		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void LanceVtomIp1d() {

		GestionConfig FichierConfig = new GestionConfig();
		GestionChemin RequeteChemin = new GestionChemin();
		String UserWindows = "";
		String PassWindows = "";
		UserWindows = FichierConfig.DemandeUser("Windows");
		PassWindows = FichierConfig.DemandePassword("Windows");

		try {
			Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminVtom") + " -u " + UserWindows + " -p " + PassWindows + " -s UP2TO003:30017 " + " -d Pilote"));
			ZoneTextLog.append("Ouverture de VTOM IP1 décisionnel sur UP2TO003:30017" + "\n");

		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void LanceVtomIp2q() {

		GestionConfig FichierConfig = new GestionConfig();
		GestionChemin RequeteChemin = new GestionChemin();
		String UserWindows = "";
		String PassWindows = "";
		UserWindows = FichierConfig.DemandeUser("Windows");
		PassWindows = FichierConfig.DemandePassword("Windows");

		try {
			Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminVtom") + " -u " + UserWindows + " -p " + PassWindows + " -s UP1TO002:30117 " + " -d Pilote"));
			ZoneTextLog.append("Ouverture de VTOM IP2 quotidien sur UP2TO002:30117" + "\n");

		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void LanceVtomIp2d() {

		GestionConfig FichierConfig = new GestionConfig();
		GestionChemin RequeteChemin = new GestionChemin();
		String UserWindows = "";
		String PassWindows = "";
		UserWindows = FichierConfig.DemandeUser("Windows");
		PassWindows = FichierConfig.DemandePassword("Windows");

		try {
			Runtime.getRuntime().exec(String.format(RequeteChemin.DemandeChemin("CheminVtom") + " -u " + UserWindows + " -p " + PassWindows + " -s UP1TO003:30117 " + " -d Pilote"));
			ZoneTextLog.append("Ouverture de VTOM IP2 décisionnel sur UP2TO003:30117" + "\n");

		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// PRODUIT MVS ET AS400

	/**
	 * @category Lance MVS
	 */
	public void LanceSysa() {

		GestionLog MaLog = new GestionLog();
		GestionConfig GC = new GestionConfig();
		GestionChemin RequeteChemin = new GestionChemin();
		try {

			if (GC.DemandeAutoConnect("Sysa").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileSysa") });
				builder.start();

				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuSysa.getText() + " AUTOLOGIN" + "\n");

			}

			if (GC.DemandeAutoConnect("Sysa").equals("true") == false) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileSysa_no_auto_login") });
				builder.start();

				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuSysa.getText());
				ZoneTextLog.setText(ZoneTextLog.getText() + "\n" + "\n");

			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Quick3270 pour Sysa : " + e1);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

		}

	}

	public void LanceKmvs() {

		GestionLog MaLog = new GestionLog();
		GestionConfig GC = new GestionConfig();
		GestionChemin RequeteChemin = new GestionChemin();
		try {

			if (GC.DemandeAutoConnect("Kmvs").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileKmvs") });
				builder.start();

				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuKmvs.getText() + " AUTOLOGIN" + "\n");

			}

			if (GC.DemandeAutoConnect("Kmvs").equals("true") == false) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileKmvs_no_auto_login") });
				builder.start();
				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuKmvs.getText() + "\n");

			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour KMVS : " + e1);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

		}

	}

	public void LanceZmvs() {

		GestionLog MaLog = new GestionLog();
		GestionConfig GC = new GestionConfig();
		GestionChemin RequeteChemin = new GestionChemin();

		try {

			if (GC.DemandeAutoConnect("Zmvs").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileZmvs") });
				builder.start();

				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuZmvs.getText() + " AUTOLOGIN" + "\n");

			}

			if (GC.DemandeAutoConnect("Zmvs").equals("true") == false) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileZmvs_no_auto_login") });
				builder.start();

				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuZmvs.getText() + "\n");

			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour ZMVS : " + e1);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

		}

	}

	public void LanceSysg()

	{
		GestionLog MaLog = new GestionLog();
		GestionConfig GC = new GestionConfig();
		GestionChemin RequeteChemin = new GestionChemin();
		try {

			if (GC.DemandeAutoConnect("Sysa").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileSysg") });
				builder.start();
				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuSysg.getText() + " AUTOLOGIN" + "\n");

			}

			if (GC.DemandeAutoConnect("Sysa").equals("true") == false) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileSysg_no_auto_login") });
				builder.start();

				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuSysg.getText() + "\n");

			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour Sysg : " + e1);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

		}
	}

	public void LanceGmvs() {

		GestionLog MaLog = new GestionLog();
		GestionConfig GC = new GestionConfig();
		GestionChemin RequeteChemin = new GestionChemin();

		try {

			if (GC.DemandeAutoConnect("Gmvs").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileGmvs") });
				builder.start();
				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuGmvs.getText() + " AUTOLOGIN" + "\n");

			}

			if (GC.DemandeAutoConnect("Gmvs").equals("true") == false) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileGmvs_no_auto_login") });
				builder.start();

				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuGmvs.getText() + "\n");

			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour GMVS : " + e1);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

		}

	}

	public void LanceBmvs() {

		GestionLog MaLog = new GestionLog();
		GestionConfig GC = new GestionConfig();
		GestionChemin RequeteChemin = new GestionChemin();
		try {

			if (GC.DemandeAutoConnect("Bmvs").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileBmvs") });
				builder.start();

				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuBmvs.getText() + " AUTOLOGIN");
				ZoneTextLog.setText(ZoneTextLog.getText() + "\n" + "\n");

			}

			if (GC.DemandeAutoConnect("Bmvs").equals("false") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileBmvs_no_auto_login") });
				builder.start();
				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuBmvs.getText() + "\n");

			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour Bmvs : " + e1);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

		}

	}

	public void LanceIp1() {

		GestionLog MaLog = new GestionLog();
		GestionConfig GC = new GestionConfig();

		GestionChemin RequeteChemin = new GestionChemin();
		try {

			if (GC.DemandeAutoConnect("Ip1").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileIp1") });
				builder.start();

				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuIp1.getText() + " AUTOLOGIN" + "\n");

			}

			if (GC.DemandeAutoConnect("Ip1").equals("false") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileIp1_no_auto_login") });
				builder.start();
				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuIp1.getText() + "\n");

			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour Ip1 : " + e1);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

		}

	}

	public void LanceIp3() {

		GestionLog MaLog = new GestionLog();
		GestionConfig GC = new GestionConfig();
		GestionChemin RequeteChemin = new GestionChemin();
		try {

			if (GC.DemandeAutoConnect("Ip3").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileIp3") });
				builder.start();

				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuIp3.getText() + " AUTOLOGIN" + "\n");

			}

			if (GC.DemandeAutoConnect("Ip3").equals("false") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileIp3_no_auto_login") });
				builder.start();
				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuIp3.getText());

			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour Ip3 : " + e1);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

		}

	}

	public void LanceIp2() {

		GestionLog MaLog = new GestionLog();
		GestionConfig GC = new GestionConfig();
		GestionChemin RequeteChemin = new GestionChemin();
		try {

			if (GC.DemandeAutoConnect("Ip2").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileIp2") });
				builder.start();

				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuIp2.getText() + " AUTOLOGIN" + "\n");

			}

			if (GC.DemandeAutoConnect("Ip2").equals("false") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileIp2_no_auto_login") });
				builder.start();
				ZoneTextLog.append("Ouverture connexion 3270 vers " + MenuIp2.getText() + "\n");

			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour Ip2 : " + e1);
			ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

		}

	}

	/**
	 * @category Lance AS400
	 */
	public void LanceAs400Br() {
		GestionLog MaLog = new GestionLog();
		new UserInterfaceConfig();
		GestionChemin RequeteChemin = new GestionChemin();

		try {
			ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileBr") });
			builder.start();

			ZoneTextLog.append("Ouverture connexion 5250 vers " + MenuAS400Br.getText() + " AUTOLOGIN + dspmsg qsysopr" + "\n");

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour BRCLY : " + e1);
			ZoneTextLog.append("Erreur au lancement de quick3270 pour BRCLY : Consulter la log." + "\n");

		}
	}

	public void LanceAs400Bdi() {
		GestionLog MaLog = new GestionLog();
		new UserInterfaceConfig();
		GestionChemin RequeteChemin = new GestionChemin();

		try {
			ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileBdi") });
			builder.start();

			ZoneTextLog.append("Ouverture connexion 5250 vers " + MenuAS400Bdi.getText() + " AUTOLOGIN + dspmsg qsysopr" + "\n");

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour BDICLY : " + e1);
			ZoneTextLog.append("Erreur au lancement de quick3270 pour BDICLY : Consulter la log." + "\n");

		}
	}

	public void LanceAs400Bdaf() {
		GestionLog MaLog = new GestionLog();
		new UserInterfaceConfig();
		GestionChemin RequeteChemin = new GestionChemin();

		try {
			ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileBdaf") });
			builder.start();

			ZoneTextLog.append("Ouverture connexion 5250 vers " + MenuAS400Bdaf.getText() + " AUTOLOGIN + dspmsg qsysopr" + "\n");

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour BDAFCLY : " + e1);
			ZoneTextLog.append("Erreur au lancement de quick3270 pour BDAFCLY : Consulter la log." + "\n");

		}
	}

	public void LanceAs400Pfb() {
		GestionLog MaLog = new GestionLog();
		new UserInterfaceConfig();
		GestionChemin RequeteChemin = new GestionChemin();

		try {
			ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfilePfb") });
			builder.start();

			ZoneTextLog.append("Ouverture connexion 5250 vers " + MenuPfbcly.getText() + " AUTOLOGIN + dspmsg qsysopr" + "\n");

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour PFBCLY : " + e1);
			ZoneTextLog.append("Erreur au lancement de quick3270 pour PFBCLY : Consulter la log." + "\n");

		}
	}

	public void LanceAs400Socly() {
		GestionLog MaLog = new GestionLog();
		new UserInterfaceConfig();
		GestionChemin RequeteChemin = new GestionChemin();

		try {
			ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileSocly") });
			builder.start();

			ZoneTextLog.append("Ouverture connexion 5250 vers " + MenuAS400Socly.getText() + " AUTOLOGIN + dspmsg qsysopr" + "\n");

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour SOCLY : " + e1);
			ZoneTextLog.append("Erreur au lancement de quick3270 pour SOCLY : Consulter la log." + "\n");

		}
	}

	public void LanceAs400Socmcsd() {
		GestionLog MaLog = new GestionLog();
		new UserInterfaceConfig();
		GestionChemin RequeteChemin = new GestionChemin();

		try {
			ProcessBuilder builder = new ProcessBuilder(new String[] { RequeteChemin.DemandeChemin("CheminQuick3270"), RequeteChemin.DemandeChemin("CheminQuick3270ProfileSocmcsd") });
			builder.start();

			ZoneTextLog.append("Ouverture connexion 5250 vers " + MenuSocmcsd.getText() + " AUTOLOGIN + dspmsg qsysopr" + "\n");

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour SOCMCSD : " + e1);
			ZoneTextLog.append("Erreur au lancement de quick3270 pour SOCMCSD : Consulter la log." + "\n");

		}
	}

	// LANCEMENT PUTTY

	/**
	 * @category Lance Outils
	 */
	public void LancePuttyConnexionTelnet()

	{

		// final String CHEMIN = "D:\\";

		GestionMachine MaMachine = new GestionMachine();
		String Resultatdemande = MaMachine.DemandeIp(MachineDansMaComboBox);
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
				GestionConfig MaConfig = new GestionConfig();

				PasswordUnix = MaConfig.DemandePassword("Unix");
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

	public void LancePuttyConnexionSsh() throws AWTException {

		GestionMachine MaMachine = new GestionMachine();
		String Resultatdemande = MaMachine.DemandeIp(MachineDansMaComboBox);
		GestionChemin RequeteChemin = new GestionChemin();

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

				GestionConfig MaConfig = new GestionConfig();
				String PasswordUnix = "";
				PasswordUnix = MaConfig.DemandePassword("Unix");
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
			String Resultatdemande = MaMachine.DemandeIp(MachineDansMaComboBox);
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
				catch (AWTException e) {
					e.printStackTrace();
					GestionLog MaLog = new GestionLog();
					MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " + e);
					ZoneTextLog.append("Erreur au lancement : Consulter la log." + "\n");

				}
			}
			else {
				RetourTestConnexion = TestConnexionValideSurCible.InitSocket(Resultatdemande, 23);
				if (RetourTestConnexion == true) {
					LancePuttyConnexionTelnet();
				}

			}

			if (RetourTestConnexion == false) {
				ZoneTextLog.append("Impossible de trouver une connexion valide en telnet(port23) ou ssh(port22)" + "\n");
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
			GestionConfig FichierGestion = new GestionConfig();

			try {
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Sysa").equals("true") == true) {
					LanceSysa();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Kmvs").equals("true") == true) {
					LanceKmvs();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Sysg").equals("true") == true) {
					LanceSysg();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Zmvs").equals("true") == true) {
					LanceZmvs();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Gmvs").equals("true") == true) {
					LanceGmvs();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Ip1").equals("true") == true) {
					LanceIp1();
					Thread.sleep(500);

				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Ip2").equals("true") == true) {
					LanceIp2();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Ip3").equals("true") == true) {
					LanceIp3();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Bmvs").equals("true") == true) {
					LanceBmvs();
					Thread.sleep(500);
				}

				if (FichierGestion.DemandeChoixBoutonPosteComplet("Br").equals("true") == true) {
					LanceAs400Br();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Bdi").equals("true") == true) {
					LanceAs400Bdi();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Bdaf").equals("true") == true) {
					LanceAs400Bdaf();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Socly").equals("true") == true) {
					LanceAs400Socly();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Socmcsd").equals("true") == true) {
					LanceAs400Socmcsd();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Pfb").equals("true") == true) {
					LanceAs400Pfb();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Controlm").equals("true") == true) {
					LanceControlm();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Outlook").equals("true") == true) {
					LanceOutlook();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Arsv7").equals("true") == true) {
					LanceArsRemedy();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Iprox").equals("true") == true) {
					LanceIprox();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Puttycm").equals("true") == true) {
					LancePuttyCm();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Exceed").equals("true") == true) {
					LanceExceed();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("VtomIp1Jour").equals("true") == true) {
					LanceVtomIp1q();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("VtomIp1Desc").equals("true") == true) {
					LanceVtomIp1d();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("VtomIp2Jour").equals("true") == true) {
					LanceVtomIp2q();
					Thread.sleep(500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("VtomIp1Desc").equals("true") == true) {
					LanceVtomIp2d();
					Thread.sleep(500);
				}

				String Navigateur = SelectionneNavigateur();

				ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur);
				pb.start();
				Thread.sleep(5000);

				if (FichierGestion.DemandeChoixBoutonPosteComplet("Odip").equals("true") == true) {
					LanceOdip();
					Thread.sleep(1500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Bbr").equals("true") == true) {
					LanceBbr();
					Thread.sleep(1500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("OseIp12").equals("true") == true) {
					LanceOseIp1();
					Thread.sleep(1500);
					LanceOseIp2();
					Thread.sleep(1500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Iplabel").equals("true") == true) {
					LanceIpLabel();
					Thread.sleep(1500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Newtest").equals("true") == true) {
					LanceNewtest();
					Thread.sleep(1500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Xguard").equals("true") == true) {
					LanceXguard();
					Thread.sleep(1500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Hmc").equals("true") == true) {
					LanceHmc();
					Thread.sleep(1500);
				}

				if (FichierGestion.DemandeChoixBoutonPosteComplet("Kvm").equals("true") == true) {
					LanceKvm();
					Thread.sleep(1500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Tina5").equals("true") == true) {
					LanceTina5();
					Thread.sleep(1500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Tina6").equals("true") == true) {
					LanceTina6();
					Thread.sleep(1500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("Vcenter").equals("true") == true) {
					LanceVcenter();
					Thread.sleep(1500);
				}
				if (FichierGestion.DemandeChoixBoutonPosteComplet("SismoTous").equals("true") == true) {
					LanceSismoIp1();
					Thread.sleep(1500);
					LanceSismoIp2();
					Thread.sleep(1500);
					LanceSismoOceor();
					Thread.sleep(1500);
					LanceSismoPalatine();
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

		}

	}

	/**
	 * @category Threads
	 */
	public class ThreadPing implements Runnable {

		@Override
		public void run() {

			GestionMachine MaMachine = new GestionMachine();
			String ResultatDemandeTest = MaMachine.DemandeIp(MachineDansMaComboBox);
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

			int CodeRetour = 5;
			String UserUnix = "#Erreur#";
			GestionConfig MaConfig = new GestionConfig();
			CodeRetour = MaConfig.LireConfig();

			BoutonChargerConfig.setEnabled(false);
			BoutonChargerFavoris.setEnabled(false);
			TestAccesFichier();

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

			// FIN LECTURE USER
			// UNIX--------------------------------------------------------

			GestionMachine MaMachine = new GestionMachine();

			// ArrayList<String> ReturnLigne = null;
			String[] ListeMachinePourComboBox = { "NO MACHINE" };
			try {
				ListeMachinePourComboBox = MaMachine.LireFichierGlossary();

			}
			catch (IOException e) {
				e.printStackTrace();
				GestionLog MaLog = new GestionLog();
				MaLog.EcrireDansFichierLog("Erreur dans la saisie machine(ip) : " + e);
				ZoneTextLog.append("Erreur de l'alimentation de la zone saisie machine(ip) : Consulter la log." + "\n");
				ZoneTextLog.append("Essayez de faire un rechargement de la config." + "\n");

			}
			MaComboBox.removeAllItems();
			MaComboBox.setModel(new DefaultComboBoxModel(ListeMachinePourComboBox));

			// LECTURE USER
			// PROFILE--------------------------------------------------------

			GestionProfile GP = new GestionProfile();
			try {
				GP.ModifierPasswordProfile("Gmvs", MaConfig.DemandePassword("Gmvs"));
				GP.ModifierUserProfile("Gmvs", MaConfig.DemandeUser("Gmvs"));

				GP.ModifierPasswordProfile("Sysg", MaConfig.DemandePassword("Sysg"));
				GP.ModifierUserProfile("Sysg", MaConfig.DemandeUser("Sysg"));

				GP.ModifierPasswordProfile("Zmvs", MaConfig.DemandePassword("Zmvs"));
				GP.ModifierUserProfile("Zmvs", MaConfig.DemandeUser("Zmvs"));

				GP.ModifierPasswordProfile("Kmvs", MaConfig.DemandePassword("Kmvs"));
				GP.ModifierUserProfile("Kmvs", MaConfig.DemandeUser("Kmvs"));

				GP.ModifierPasswordProfile("Sysa", MaConfig.DemandePassword("Sysa"));
				GP.ModifierUserProfile("Sysa", MaConfig.DemandeUser("Sysa"));

			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				GestionLog MaLog = new GestionLog();
				MaLog.EcrireDansFichierLog("Erreur lors du chargement des macros : " + e);
				ZoneTextLog.append("Erreur lors du chargement des macros : Consulter la log." + "\n");

			}

			if (CodeRetour == 0) {

				BoutonRadioUserPerso.setText(UserUnix);

			}
			if (CodeRetour == 1) {
				ZoneTextLog.append("Problème rechargement config" + "\n");

				BoutonRadioUserPerso.setText("#Erreur");

			}
			BoutonChargerConfig.setEnabled(true);
			BoutonChargerFavoris.setEnabled(true);

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

	public void MiseAjoutPositionFenetre() {
		PositionFenetrePrincipale = this.getLocation();

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

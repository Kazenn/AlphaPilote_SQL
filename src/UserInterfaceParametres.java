import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class UserInterfaceParametres extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// new UserInterface();
	private String NavigateurDansCombox;
	private JComboBox ComboxNavigateur;
	private JCheckBox BoxChoixAutoSysa;
	private JCheckBox BoxChoixAutoSysg;
	private JCheckBox BoxChoixAutoIp1;
	private JCheckBox BoxChoixAutoIp2;
	private JCheckBox BoxChoixAutoIp3;
	private JCheckBox BoxChoixAutoKmvs;
	private JCheckBox BoxChoixAutoZmvs;
	private JCheckBox BoxChoixAutoGmvs;
	private JCheckBox BoxChoixAutoBmvs;
	private JCheckBox BoxChoixAutoBr;
	private JCheckBox BoxChoixAutoBdi;
	private JCheckBox BoxChoixAutoBdaf;
	private JCheckBox BoxChoixAutoSocly;
	private JCheckBox BoxChoixAutoSocmcsd;
	private JCheckBox BoxChoixAutoPfb;
	private JCheckBox BoxChoixAutoControlm;
	private JCheckBox BoxChoixAutoIprox;
	private JCheckBox BoxChoixAutoOutlook;
	private JCheckBox BoxChoixAutoPuttycm;
	private JCheckBox BoxChoixAutoVtomIp1Jour;
	private JCheckBox BoxChoixAutoVtomIp1Desc;
	private JCheckBox BoxChoixAutoVtomIp2Jour;
	private JCheckBox BoxChoixAutoVtomIp2Desc;
	private JCheckBox BoxChoixAutoArsv7;
	private JCheckBox BoxChoixAutoOdip;
	private JCheckBox BoxChoixAutoHmc;
	private JCheckBox BoxChoixAutoKvm;
	private JCheckBox BoxChoixAutoTina5;
	private JCheckBox BoxChoixAutoTina6;
	private JCheckBox BoxChoixAutoSismoTous;
	private JCheckBox BoxChoixAutoBbr;
	private JCheckBox BoxChoixAutoOseIp12;
	private JCheckBox BoxChoixAutoXguard;
	private JCheckBox BoxChoixAutoNewtest;
	private JCheckBox BoxChoixAutoIplabel;
	private JCheckBox BoxChoixAutoVcenter;
	private JCheckBox BoxChoixAutoExceed;
	private JCheckBox BoxChoixAutoNavigateur;
	private JLabel LabelSaveEnCours;

	public UserInterfaceParametres() {
		setType(Type.UTILITY);

		setTitle("Paramètres généraux");
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel ZoneNavigateur = new JPanel();
		ZoneNavigateur.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Navigateur pour favoris web", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneNavigateur.setBounds(4, 10, 180, 50);
		getContentPane().add(ZoneNavigateur);
		ZoneNavigateur.setLayout(null);

		ComboxNavigateur = new JComboBox();
		ComboxNavigateur.setBounds(10, 21, 139, 20);
		ZoneNavigateur.add(ComboxNavigateur);
		// ComboxNavigateur.addItemListener(new ItemListener() {
		// @Override
		// public void itemStateChanged(ItemEvent arg0) {

		// NavigateurDansCombox = (String) ComboxNavigateur.getSelectedItem();
		// SetNavigateurFichierConfig();
		// }
		// });
		ComboxNavigateur.setModel(new DefaultComboBoxModel(new String[] { "Google Chrome", "Mozilla Firefox", "Internet Explorer" }));
		ComboxNavigateur.setSelectedIndex(1);

		JButton BoutonValiderParametres = new JButton("Valider et quitter");
		final ImageIcon IconValider = new ImageIcon(getClass().getResource("/Ok-icon.png"));
		BoutonValiderParametres.setIcon(IconValider);
		BoutonValiderParametres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				new Thread(new ThreadLancementProduitAuto()).start();
				// dispose();
			}
		});
		BoutonValiderParametres.setBounds(4, 476, 161, 39);
		getContentPane().add(BoutonValiderParametres);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "MVS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(177, 75, 124, 283);
		getContentPane().add(panel);
		panel.setLayout(null);

		BoxChoixAutoSysa = new JCheckBox("Sysa");
		BoxChoixAutoSysa.setBounds(6, 16, 97, 23);
		panel.add(BoxChoixAutoSysa);

		BoxChoixAutoSysg = new JCheckBox("Sysg (Xenos)");
		BoxChoixAutoSysg.setBounds(6, 42, 112, 23);
		panel.add(BoxChoixAutoSysg);

		BoxChoixAutoKmvs = new JCheckBox("Kmvs (Ip0)");
		BoxChoixAutoKmvs.setBounds(6, 68, 97, 23);
		panel.add(BoxChoixAutoKmvs);

		BoxChoixAutoZmvs = new JCheckBox("Zmvs (CFF)");
		BoxChoixAutoZmvs.setBounds(6, 94, 97, 23);
		panel.add(BoxChoixAutoZmvs);

		BoxChoixAutoIp1 = new JCheckBox("Ip1");
		BoxChoixAutoIp1.setBounds(6, 135, 97, 23);
		panel.add(BoxChoixAutoIp1);

		BoxChoixAutoIp2 = new JCheckBox("Ip2");
		BoxChoixAutoIp2.setBounds(6, 161, 97, 23);
		panel.add(BoxChoixAutoIp2);

		BoxChoixAutoIp3 = new JCheckBox("Ip3");
		BoxChoixAutoIp3.setBounds(6, 187, 97, 23);
		panel.add(BoxChoixAutoIp3);

		BoxChoixAutoGmvs = new JCheckBox("Gmvs");
		BoxChoixAutoGmvs.setBounds(6, 227, 97, 23);
		panel.add(BoxChoixAutoGmvs);

		BoxChoixAutoBmvs = new JCheckBox("Bmvs");
		BoxChoixAutoBmvs.setBounds(6, 253, 97, 23);
		panel.add(BoxChoixAutoBmvs);

		JLabel lblNewLabel = new JLabel("<html>S\u00E9lectionner les consoles, outils et pages web qui seront lanc\u00E9s<br>lors de l'appui sur le bouton \"Lancer poste complet\" :</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(282, 10, 382, 50);
		getContentPane().add(lblNewLabel);

		JPanel ZoneAutoAs400 = new JPanel();
		ZoneAutoAs400.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "AS400", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneAutoAs400.setBounds(311, 75, 109, 225);
		getContentPane().add(ZoneAutoAs400);
		ZoneAutoAs400.setLayout(null);

		BoxChoixAutoBr = new JCheckBox("BR");
		BoxChoixAutoBr.setBounds(6, 16, 97, 23);
		ZoneAutoAs400.add(BoxChoixAutoBr);

		BoxChoixAutoBdi = new JCheckBox("BDI");
		BoxChoixAutoBdi.setBounds(6, 42, 97, 23);
		ZoneAutoAs400.add(BoxChoixAutoBdi);

		BoxChoixAutoBdaf = new JCheckBox("BDAF");
		BoxChoixAutoBdaf.setBounds(6, 68, 97, 23);
		ZoneAutoAs400.add(BoxChoixAutoBdaf);

		BoxChoixAutoSocly = new JCheckBox("SOCLY");
		BoxChoixAutoSocly.setBounds(6, 109, 97, 23);
		ZoneAutoAs400.add(BoxChoixAutoSocly);

		BoxChoixAutoSocmcsd = new JCheckBox("SOCMCSD");
		BoxChoixAutoSocmcsd.setBounds(6, 135, 97, 23);
		ZoneAutoAs400.add(BoxChoixAutoSocmcsd);

		BoxChoixAutoPfb = new JCheckBox("PFB");
		BoxChoixAutoPfb.setBounds(6, 173, 97, 23);
		ZoneAutoAs400.add(BoxChoixAutoPfb);

		JPanel ZoneAutoOutils = new JPanel();
		ZoneAutoOutils.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Outils", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneAutoOutils.setBounds(430, 75, 134, 323);
		getContentPane().add(ZoneAutoOutils);
		ZoneAutoOutils.setLayout(null);

		BoxChoixAutoControlm = new JCheckBox("Control-m");
		BoxChoixAutoControlm.setBounds(6, 16, 97, 23);
		ZoneAutoOutils.add(BoxChoixAutoControlm);

		BoxChoixAutoOutlook = new JCheckBox("Outlook");
		BoxChoixAutoOutlook.setBounds(6, 42, 97, 23);
		ZoneAutoOutils.add(BoxChoixAutoOutlook);

		BoxChoixAutoArsv7 = new JCheckBox("Ars v7");
		BoxChoixAutoArsv7.setBounds(6, 68, 97, 23);
		ZoneAutoOutils.add(BoxChoixAutoArsv7);

		BoxChoixAutoIprox = new JCheckBox("Iprox");
		BoxChoixAutoIprox.setBounds(6, 94, 97, 23);
		ZoneAutoOutils.add(BoxChoixAutoIprox);

		BoxChoixAutoVtomIp1Jour = new JCheckBox("Vtom Ip1 Jour.");
		BoxChoixAutoVtomIp1Jour.setBounds(6, 138, 122, 23);
		ZoneAutoOutils.add(BoxChoixAutoVtomIp1Jour);

		BoxChoixAutoVtomIp1Desc = new JCheckBox("Vtom Ip1 Desc.");
		BoxChoixAutoVtomIp1Desc.setBounds(6, 164, 122, 23);
		ZoneAutoOutils.add(BoxChoixAutoVtomIp1Desc);

		BoxChoixAutoVtomIp2Jour = new JCheckBox("Vtom Ip2 Jour.");
		BoxChoixAutoVtomIp2Jour.setBounds(6, 190, 122, 23);
		ZoneAutoOutils.add(BoxChoixAutoVtomIp2Jour);

		BoxChoixAutoVtomIp2Desc = new JCheckBox("Vtom Ip2 Desc.");
		BoxChoixAutoVtomIp2Desc.setBounds(6, 216, 122, 23);
		ZoneAutoOutils.add(BoxChoixAutoVtomIp2Desc);

		BoxChoixAutoPuttycm = new JCheckBox("Putty CM");
		BoxChoixAutoPuttycm.setBounds(6, 257, 97, 23);
		ZoneAutoOutils.add(BoxChoixAutoPuttycm);

		BoxChoixAutoExceed = new JCheckBox("Exceed");
		BoxChoixAutoExceed.setBounds(6, 283, 97, 23);
		ZoneAutoOutils.add(BoxChoixAutoExceed);

		JPanel ZoneWeb = new JPanel();
		ZoneWeb.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Favoris web", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneWeb.setBounds(574, 148, 160, 335);
		getContentPane().add(ZoneWeb);
		ZoneWeb.setLayout(null);

		BoxChoixAutoOdip = new JCheckBox("Odip");
		BoxChoixAutoOdip.setBounds(6, 16, 97, 23);
		ZoneWeb.add(BoxChoixAutoOdip);

		BoxChoixAutoBbr = new JCheckBox("BBR");
		BoxChoixAutoBbr.setBounds(6, 42, 97, 23);
		ZoneWeb.add(BoxChoixAutoBbr);

		BoxChoixAutoOseIp12 = new JCheckBox("OSE IP1-IP2");
		BoxChoixAutoOseIp12.setBounds(6, 68, 97, 23);
		ZoneWeb.add(BoxChoixAutoOseIp12);

		BoxChoixAutoIplabel = new JCheckBox("ip-Label");
		BoxChoixAutoIplabel.setBounds(6, 94, 97, 23);
		ZoneWeb.add(BoxChoixAutoIplabel);

		BoxChoixAutoNewtest = new JCheckBox("Newtest");
		BoxChoixAutoNewtest.setBounds(6, 120, 97, 23);
		ZoneWeb.add(BoxChoixAutoNewtest);

		BoxChoixAutoXguard = new JCheckBox("Xguard");
		BoxChoixAutoXguard.setBounds(6, 146, 97, 23);
		ZoneWeb.add(BoxChoixAutoXguard);

		BoxChoixAutoHmc = new JCheckBox("HMC web1");
		BoxChoixAutoHmc.setBounds(6, 171, 97, 23);
		ZoneWeb.add(BoxChoixAutoHmc);

		BoxChoixAutoKvm = new JCheckBox("KVM");
		BoxChoixAutoKvm.setBounds(6, 197, 97, 23);
		ZoneWeb.add(BoxChoixAutoKvm);

		BoxChoixAutoTina5 = new JCheckBox("Tina Cltec5 web");
		BoxChoixAutoTina5.setMargin(new Insets(2, 2, 0, 2));
		BoxChoixAutoTina5.setBounds(6, 223, 129, 23);
		ZoneWeb.add(BoxChoixAutoTina5);

		BoxChoixAutoTina6 = new JCheckBox("Tina Cltec6 web");
		BoxChoixAutoTina6.setBounds(6, 249, 129, 23);
		ZoneWeb.add(BoxChoixAutoTina6);

		BoxChoixAutoSismoTous = new JCheckBox("Sismo (Tous)");
		BoxChoixAutoSismoTous.setBounds(6, 275, 105, 23);
		ZoneWeb.add(BoxChoixAutoSismoTous);

		BoxChoixAutoVcenter = new JCheckBox("Vcenter");
		BoxChoixAutoVcenter.setBounds(6, 301, 97, 23);
		ZoneWeb.add(BoxChoixAutoVcenter);

		JPanel ZoneNavigateurAuto = new JPanel();
		ZoneNavigateurAuto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Navigateur par d\u00E9faut", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneNavigateurAuto.setBounds(574, 75, 160, 46);
		getContentPane().add(ZoneNavigateurAuto);
		ZoneNavigateurAuto.setLayout(null);

		BoxChoixAutoNavigateur = new JCheckBox("Navigateur");
		BoxChoixAutoNavigateur.setBounds(6, 16, 97, 23);
		ZoneNavigateurAuto.add(BoxChoixAutoNavigateur);

		LabelSaveEnCours = new JLabel("Enregistrement des param\u00E8tres dans la configuration en cours ...");
		LabelSaveEnCours.setVisible(false);
		LabelSaveEnCours.setForeground(new Color(106, 90, 205));
		LabelSaveEnCours.setBounds(10, 451, 361, 14);
		getContentPane().add(LabelSaveEnCours);

		// --------------------------------------------------
		// -----------LANCER AU CHARGEMENT PAGE
		// --------------------------------------------------

		// new Thread(new ThreadChargementParametres()).start();
		new Thread(new ThreadChargementProduitAutoEtParametres()).start();

		// --------------------------------------------------
		// -----------FIN LANCER AU CHARGEMENT PAGE
		// --------------------------------------------------

	}

	public void SetNavigateurFichierConfig() {
		GestionConfig FichierGestion = new GestionConfig();
		FichierGestion.EcrireDefaultBrower(NavigateurDansCombox);

	}

	public class ThreadChargementParametres implements Runnable {

		@Override
		public void run() {
			GestionConfig FichierGestion = new GestionConfig();
			String Navigateur = "";
			Navigateur = FichierGestion.DemandeDefaultBrowser();

			switch (Navigateur) {
				case "Google Chrome":
					ComboxNavigateur.setSelectedIndex(0);
					break;
				case "Mozilla Firefox":
					ComboxNavigateur.setSelectedIndex(1);
					break;
				case "Internet Explorer":
					ComboxNavigateur.setSelectedIndex(2);
					break;
			}

		}
	}

	public class ThreadLancementProduitAuto implements Runnable {

		@Override
		public void run() {
			GestionConfig FichierGestion = new GestionConfig();
			String Choix = "";

			LabelSaveEnCours.setVisible(true);

			if (BoxChoixAutoSysa.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Sysa", Choix);

			if (BoxChoixAutoSysg.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Sysg", Choix);

			if (BoxChoixAutoKmvs.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Kmvs", Choix);

			if (BoxChoixAutoZmvs.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Zmvs", Choix);

			if (BoxChoixAutoGmvs.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Gmvs", Choix);

			if (BoxChoixAutoBmvs.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Bmvs", Choix);

			if (BoxChoixAutoIp1.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Ip1", Choix);

			if (BoxChoixAutoIp2.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Ip2", Choix);

			if (BoxChoixAutoIp3.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Ip3", Choix);

			if (BoxChoixAutoBr.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Br", Choix);

			if (BoxChoixAutoBdi.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Bdi", Choix);

			if (BoxChoixAutoBdaf.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Bdaf", Choix);

			if (BoxChoixAutoSocly.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Socly", Choix);

			if (BoxChoixAutoSocmcsd.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Socmcsd", Choix);

			if (BoxChoixAutoPfb.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Pfb", Choix);

			if (BoxChoixAutoOutlook.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Outlook", Choix);

			if (BoxChoixAutoControlm.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Controlm", Choix);

			if (BoxChoixAutoArsv7.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Arsv7", Choix);

			if (BoxChoixAutoIprox.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Iprox", Choix);

			if (BoxChoixAutoPuttycm.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Puttycm", Choix);

			if (BoxChoixAutoExceed.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Exceed", Choix);

			if (BoxChoixAutoVtomIp1Jour.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("VtomIp1Jour", Choix);

			if (BoxChoixAutoVtomIp1Desc.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("VtomIp1Desc", Choix);

			if (BoxChoixAutoVtomIp2Jour.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("VtomIp2Jour", Choix);

			if (BoxChoixAutoVtomIp2Desc.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("VtomIp2Desc", Choix);

			// -----------------------------------------------------------------
			//
			//
			// --------------------------------------------------------------

			NavigateurDansCombox = (String) ComboxNavigateur.getSelectedItem();
			SetNavigateurFichierConfig();

			// -----------------------------------------------------------------
			//
			//
			// --------------------------------------------------------------

			if (BoxChoixAutoNavigateur.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Navigateur", Choix);

			if (BoxChoixAutoOdip.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Odip", Choix);

			if (BoxChoixAutoBbr.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Bbr", Choix);

			if (BoxChoixAutoOseIp12.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("OseIp12", Choix);

			if (BoxChoixAutoIplabel.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Iplabel", Choix);

			if (BoxChoixAutoNewtest.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Newtest", Choix);

			if (BoxChoixAutoXguard.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Xguard", Choix);

			if (BoxChoixAutoHmc.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Hmc", Choix);

			if (BoxChoixAutoKvm.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}

			FichierGestion.EcrireChoixBoutonPosteComplet("Kvm", Choix);

			if (BoxChoixAutoTina5.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Tina5", Choix);

			if (BoxChoixAutoTina6.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Tina6", Choix);

			if (BoxChoixAutoSismoTous.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("SismoTous", Choix);

			if (BoxChoixAutoVcenter.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			FichierGestion.EcrireChoixBoutonPosteComplet("Vcenter", Choix);

			// ----Attente fin d'enregistrement pour fermer la fenêtre des
			// paramêtres.
			dispose();

		}
	}

	public class ThreadChargementProduitAutoEtParametres implements Runnable {

		@Override
		public void run() {
			GestionConfig FichierGestion = new GestionConfig();
			String Navigateur = "";
			Navigateur = FichierGestion.DemandeDefaultBrowser();

			switch (Navigateur) {
				case "Google Chrome":
					ComboxNavigateur.setSelectedIndex(0);
					break;
				case "Mozilla Firefox":
					ComboxNavigateur.setSelectedIndex(1);
					break;
				case "Internet Explorer":
					ComboxNavigateur.setSelectedIndex(2);
					break;

			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Sysa").equals("true") == true) {
				BoxChoixAutoSysa.setSelected(true);
			}
			else {
				BoxChoixAutoSysa.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Sysg").equals("true") == true) {
				BoxChoixAutoSysg.setSelected(true);
			}
			else {
				BoxChoixAutoSysg.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Kmvs").equals("true") == true) {
				BoxChoixAutoKmvs.setSelected(true);
			}
			else {
				BoxChoixAutoKmvs.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Zmvs").equals("true") == true) {
				BoxChoixAutoZmvs.setSelected(true);
			}
			else {
				BoxChoixAutoZmvs.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Gmvs").equals("true") == true) {
				BoxChoixAutoGmvs.setSelected(true);
			}
			else {
				BoxChoixAutoGmvs.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Bmvs").equals("true") == true) {
				BoxChoixAutoBmvs.setSelected(true);
			}
			else {
				BoxChoixAutoBmvs.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Ip1").equals("true") == true) {
				BoxChoixAutoIp1.setSelected(true);
			}
			else {
				BoxChoixAutoIp1.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Ip2").equals("true") == true) {
				BoxChoixAutoIp2.setSelected(true);
			}
			else {
				BoxChoixAutoIp2.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Ip3").equals("true") == true) {
				BoxChoixAutoIp3.setSelected(true);
			}
			else {
				BoxChoixAutoIp3.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Br").equals("true") == true) {
				BoxChoixAutoBr.setSelected(true);
			}
			else {
				BoxChoixAutoBr.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Bdi").equals("true") == true) {
				BoxChoixAutoBdi.setSelected(true);
			}
			else {
				BoxChoixAutoBdi.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Bdaf").equals("true") == true) {
				BoxChoixAutoBdaf.setSelected(true);
			}
			else {
				BoxChoixAutoBdaf.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Socly").equals("true") == true) {
				BoxChoixAutoSocly.setSelected(true);
			}
			else {
				BoxChoixAutoSocly.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Socmcsd").equals("true") == true) {
				BoxChoixAutoSocmcsd.setSelected(true);
			}
			else {
				BoxChoixAutoSocmcsd.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Pfb").equals("true") == true) {
				BoxChoixAutoPfb.setSelected(true);
			}
			else {
				BoxChoixAutoPfb.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Controlm").equals("true") == true) {
				BoxChoixAutoControlm.setSelected(true);
			}
			else {
				BoxChoixAutoControlm.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Outlook").equals("true") == true) {
				BoxChoixAutoOutlook.setSelected(true);
			}
			else {
				BoxChoixAutoOutlook.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Iprox").equals("true") == true) {
				BoxChoixAutoIprox.setSelected(true);
			}
			else {
				BoxChoixAutoIprox.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Arsv7").equals("true") == true) {
				BoxChoixAutoArsv7.setSelected(true);
			}
			else {
				BoxChoixAutoArsv7.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Puttycm").equals("true") == true) {
				BoxChoixAutoPuttycm.setSelected(true);
			}
			else {
				BoxChoixAutoPuttycm.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Exceed").equals("true") == true) {
				BoxChoixAutoExceed.setSelected(true);
			}
			else {
				BoxChoixAutoExceed.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("VtomIp1Jour").equals("true") == true) {
				BoxChoixAutoVtomIp1Jour.setSelected(true);
			}
			else {
				BoxChoixAutoVtomIp1Jour.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("VtomIp1Desc").equals("true") == true) {
				BoxChoixAutoVtomIp1Desc.setSelected(true);
			}
			else {
				BoxChoixAutoVtomIp1Desc.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("VtomIp2Jour").equals("true") == true) {
				BoxChoixAutoVtomIp2Jour.setSelected(true);
			}
			else {
				BoxChoixAutoVtomIp2Jour.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("VtomIp2Desc").equals("true") == true) {
				BoxChoixAutoVtomIp2Desc.setSelected(true);
			}
			else {
				BoxChoixAutoVtomIp2Desc.setSelected(false);
			}

			// ---------------------------------------
			//
			// -------------WEB------------------------
			//
			// ---------------------------------------

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Navigateur").equals("true") == true) {
				BoxChoixAutoNavigateur.setSelected(true);
			}
			else {
				BoxChoixAutoNavigateur.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Odip").equals("true") == true) {
				BoxChoixAutoOdip.setSelected(true);
			}
			else {
				BoxChoixAutoOdip.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Bbr").equals("true") == true) {
				BoxChoixAutoBbr.setSelected(true);
			}
			else {
				BoxChoixAutoBbr.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("OseIp12").equals("true") == true) {
				BoxChoixAutoOseIp12.setSelected(true);
			}
			else {
				BoxChoixAutoOseIp12.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Iplabel").equals("true") == true) {
				BoxChoixAutoIplabel.setSelected(true);
			}
			else {
				BoxChoixAutoIplabel.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Newtest").equals("true") == true) {
				BoxChoixAutoNewtest.setSelected(true);
			}
			else {
				BoxChoixAutoNewtest.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Xguard").equals("true") == true) {
				BoxChoixAutoXguard.setSelected(true);
			}
			else {
				BoxChoixAutoXguard.setSelected(false);
			}

			if (FichierGestion.DemandeChoixBoutonPosteComplet("Hmc").equals("true") == true) {
				BoxChoixAutoHmc.setSelected(true);
			}
			else {
				BoxChoixAutoHmc.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Kvm").equals("true") == true) {
				BoxChoixAutoKvm.setSelected(true);
			}
			else {
				BoxChoixAutoKvm.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Tina5").equals("true") == true) {
				BoxChoixAutoTina5.setSelected(true);
			}
			else {
				BoxChoixAutoTina5.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Tina6").equals("true") == true) {
				BoxChoixAutoTina6.setSelected(true);
			}
			else {
				BoxChoixAutoTina6.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("Vcenter").equals("true") == true) {
				BoxChoixAutoVcenter.setSelected(true);
			}
			else {
				BoxChoixAutoVcenter.setSelected(false);
			}
			if (FichierGestion.DemandeChoixBoutonPosteComplet("SismoTous").equals("true") == true) {
				BoxChoixAutoSismoTous.setSelected(true);
			}
			else {
				BoxChoixAutoSismoTous.setSelected(false);
			}
		}
	}
}

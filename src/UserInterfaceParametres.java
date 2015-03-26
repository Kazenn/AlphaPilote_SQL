import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

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
	private JCheckBox BoxChoixAutoMremote;
	private JCheckBox BoxChoixAutoPartageIprox;
	private JCheckBox BoxChoixAutoNavigateur;
	private JLabel LabelSaveEnCours;
	private JButton BoutonAnnuler;

	public UserInterfaceParametres() {
		setType(Type.UTILITY);

		setTitle("Paramètres généraux");
		setResizable(false);
		getContentPane().setLayout(null);
		setAlwaysOnTop(true);

		JPanel ZoneNavigateur = new JPanel();
		ZoneNavigateur.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Navigateur pour favoris web", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneNavigateur.setBounds(4, 10, 180, 50);
		getContentPane().add(ZoneNavigateur);
		ZoneNavigateur.setLayout(null);

		ComboxNavigateur = new JComboBox();
		ComboxNavigateur.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {

			}
		});
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
		panel.setBounds(208, 75, 124, 283);
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
		ZoneAutoAs400.setBounds(331, 75, 109, 225);
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
		ZoneAutoOutils.setBounds(440, 75, 134, 344);
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

		BoxChoixAutoMremote = new JCheckBox("mRemote");
		BoxChoixAutoMremote.setBounds(6, 309, 97, 23);
		ZoneAutoOutils.add(BoxChoixAutoMremote);

		JPanel ZoneWeb = new JPanel();
		ZoneWeb.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Favoris web", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneWeb.setBounds(584, 132, 160, 335);
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
		ZoneNavigateurAuto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Navigateur", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneNavigateurAuto.setBounds(574, 75, 160, 46);
		getContentPane().add(ZoneNavigateurAuto);
		ZoneNavigateurAuto.setLayout(null);

		BoxChoixAutoNavigateur = new JCheckBox("Navigateur");
		BoxChoixAutoNavigateur.setBounds(6, 16, 148, 23);
		ZoneNavigateurAuto.add(BoxChoixAutoNavigateur);

		LabelSaveEnCours = new JLabel("Enregistrement des param\u00E8tres dans la configuration en cours ...");
		LabelSaveEnCours.setVisible(false);
		LabelSaveEnCours.setForeground(new Color(106, 90, 205));
		LabelSaveEnCours.setBounds(10, 451, 413, 14);
		getContentPane().add(LabelSaveEnCours);

		BoutonAnnuler = new JButton("Annuler");
		BoutonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		final ImageIcon IconAnnuler = new ImageIcon(getClass().getResource("/cancel-icon.png"));
		BoutonAnnuler.setIcon(IconAnnuler);
		BoutonAnnuler.setBounds(188, 476, 113, 39);
		getContentPane().add(BoutonAnnuler);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Divers", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(437, 421, 137, 46);
		getContentPane().add(panel_2);

		BoxChoixAutoPartageIprox = new JCheckBox("Partage doc Iprox");
		BoxChoixAutoPartageIprox.setBounds(6, 16, 148, 23);
		panel_2.add(BoxChoixAutoPartageIprox);

		// --------------------------------------------------
		// -----------LANCER AU CHARGEMENT PAGE
		// --------------------------------------------------

		// new Thread(new ThreadChargementParametres()).start();
		new Thread(new ThreadChargementProduitAutoEtParametres()).start();

		// --------------------------------------------------
		// -----------FIN LANCER AU CHARGEMENT PAGE
		// --------------------------------------------------

	}

	public void SetNavigateurFichierConfig() throws SQLException {

		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();
		LaBase.AjoutBrowserPilote(ConnectionBase, NavigateurDansCombox);
		LaBase.FermerConnexion(ConnectionBase);

	}

	public class ThreadChargementParametres implements Runnable {

		@Override
		public void run() {
			String Navigateur = "";
			GestionSql LaBase = new GestionSql();
			Connection ConnectionBase = LaBase.InitConnexion();
			try {
				Navigateur = LaBase.ConsulterBrowserPilote(ConnectionBase);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
			LaBase.FermerConnexion(ConnectionBase);
		}
	}

	public class ThreadLancementProduitAuto implements Runnable {

		@Override
		public void run() {

			String Choix = "";
			GestionSql LaBase = new GestionSql();
			Connection ConnectionBase = LaBase.InitConnexion();

			LabelSaveEnCours.setVisible(true);
			;

			if (BoxChoixAutoSysa.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Sysa", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoSysg.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}

			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Sysg", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoKmvs.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Kmvs", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoZmvs.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Zmvs", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoGmvs.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Gmvs", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoBmvs.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Bmvs", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoIp1.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Ip1", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoIp2.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Ip2", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoIp3.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Ip3", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoBr.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Br", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoBdi.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Bdi", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoBdaf.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Bdaf", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoSocly.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Socly", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoSocmcsd.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Socmcsd", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoPfb.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Pfb", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoOutlook.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Outlook", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoControlm.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Controlm", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoArsv7.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Arsv7", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoIprox.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Iprox", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoPuttycm.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Puttycm", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoExceed.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Exceed", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoMremote.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Mremote", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoPartageIprox.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "PartageIprox", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// BoxChoixAutoPartageIprox

			if (BoxChoixAutoVtomIp1Jour.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "VtomIp1Jour", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoVtomIp1Desc.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "VtomIp1Desc", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoVtomIp2Jour.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "VtomIp2Jour", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoVtomIp2Desc.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "VtomIp2Desc", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// -----------------------------------------------------------------
			//
			//
			// --------------------------------------------------------------

			NavigateurDansCombox = (String) ComboxNavigateur.getSelectedItem();
			try {
				SetNavigateurFichierConfig();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Navigateur", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoOdip.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Odip", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoBbr.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Bbr", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoOseIp12.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "OseIp12", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoIplabel.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Iplabel", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoNewtest.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Newtest", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoXguard.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Xguard", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoHmc.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Hmc", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoKvm.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}

			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Kvm", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoTina5.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Tina5", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoTina6.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Tina6", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoSismoTous.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "SismoTous", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxChoixAutoVcenter.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutLancementAutoPilote(ConnectionBase, "Vcenter", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ----Attente fin d'enregistrement pour fermer la fenêtre des
			// paramêtres.
			LaBase.FermerConnexion(ConnectionBase);
			dispose();

		}
	}

	public class ThreadChargementProduitAutoEtParametres implements Runnable {

		@Override
		public void run() {

			String Navigateur = "";

			GestionSql LaBase = new GestionSql();
			Connection ConnectionBase = LaBase.InitConnexion();
			try {
				Navigateur = LaBase.ConsulterBrowserPilote(ConnectionBase);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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

			BoxChoixAutoNavigateur.setText(Navigateur);

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Sysa").equals("true") == true) {
					BoxChoixAutoSysa.setSelected(true);
				}
				else {
					BoxChoixAutoSysa.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Sysg").equals("true") == true) {
					BoxChoixAutoSysg.setSelected(true);
				}
				else {
					BoxChoixAutoSysg.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Kmvs").equals("true") == true) {
					BoxChoixAutoKmvs.setSelected(true);
				}
				else {
					BoxChoixAutoKmvs.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Zmvs").equals("true") == true) {
					BoxChoixAutoZmvs.setSelected(true);
				}
				else {
					BoxChoixAutoZmvs.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Gmvs").equals("true") == true) {
					BoxChoixAutoGmvs.setSelected(true);
				}
				else {
					BoxChoixAutoGmvs.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Bmvs").equals("true") == true) {
					BoxChoixAutoBmvs.setSelected(true);
				}
				else {
					BoxChoixAutoBmvs.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Ip1").equals("true") == true) {
					BoxChoixAutoIp1.setSelected(true);
				}
				else {
					BoxChoixAutoIp1.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Ip2").equals("true") == true) {
					BoxChoixAutoIp2.setSelected(true);
				}
				else {
					BoxChoixAutoIp2.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Ip3").equals("true") == true) {
					BoxChoixAutoIp3.setSelected(true);
				}
				else {
					BoxChoixAutoIp3.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Br").equals("true") == true) {
					BoxChoixAutoBr.setSelected(true);
				}
				else {
					BoxChoixAutoBr.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Bdi").equals("true") == true) {
					BoxChoixAutoBdi.setSelected(true);
				}
				else {
					BoxChoixAutoBdi.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Bdaf").equals("true") == true) {
					BoxChoixAutoBdaf.setSelected(true);
				}
				else {
					BoxChoixAutoBdaf.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Socly").equals("true") == true) {
					BoxChoixAutoSocly.setSelected(true);
				}
				else {
					BoxChoixAutoSocly.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Socmcsd").equals("true") == true) {
					BoxChoixAutoSocmcsd.setSelected(true);
				}
				else {
					BoxChoixAutoSocmcsd.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Pfb").equals("true") == true) {
					BoxChoixAutoPfb.setSelected(true);
				}
				else {
					BoxChoixAutoPfb.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Controlm").equals("true") == true) {
					BoxChoixAutoControlm.setSelected(true);
				}
				else {
					BoxChoixAutoControlm.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Outlook").equals("true") == true) {
					BoxChoixAutoOutlook.setSelected(true);
				}
				else {
					BoxChoixAutoOutlook.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Iprox").equals("true") == true) {
					BoxChoixAutoIprox.setSelected(true);
				}
				else {
					BoxChoixAutoIprox.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Arsv7").equals("true") == true) {
					BoxChoixAutoArsv7.setSelected(true);
				}
				else {
					BoxChoixAutoArsv7.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Puttycm").equals("true") == true) {
					BoxChoixAutoPuttycm.setSelected(true);
				}
				else {
					BoxChoixAutoPuttycm.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Exceed").equals("true") == true) {
					BoxChoixAutoExceed.setSelected(true);
				}
				else {
					BoxChoixAutoExceed.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "PartageIprox").equals("true") == true) {
					BoxChoixAutoPartageIprox.setSelected(true);
				}
				else {
					BoxChoixAutoPartageIprox.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "VtomIp1Jour").equals("true") == true) {
					BoxChoixAutoVtomIp1Jour.setSelected(true);
				}
				else {
					BoxChoixAutoVtomIp1Jour.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "VtomIp1Desc").equals("true") == true) {
					BoxChoixAutoVtomIp1Desc.setSelected(true);
				}
				else {
					BoxChoixAutoVtomIp1Desc.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "VtomIp2Jour").equals("true") == true) {
					BoxChoixAutoVtomIp2Jour.setSelected(true);
				}
				else {
					BoxChoixAutoVtomIp2Jour.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "VtomIp2Desc").equals("true") == true) {
					BoxChoixAutoVtomIp2Desc.setSelected(true);
				}
				else {
					BoxChoixAutoVtomIp2Desc.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Mremote").equals("true") == true) {
					BoxChoixAutoMremote.setSelected(true);
				}
				else {
					BoxChoixAutoMremote.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ---------------------------------------
			//
			// -------------WEB------------------------
			//
			// ---------------------------------------

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Navigateur").equals("true") == true) {
					BoxChoixAutoNavigateur.setSelected(true);
				}
				else {
					BoxChoixAutoNavigateur.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Odip").equals("true") == true) {
					BoxChoixAutoOdip.setSelected(true);
				}
				else {
					BoxChoixAutoOdip.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Bbr").equals("true") == true) {
					BoxChoixAutoBbr.setSelected(true);
				}
				else {
					BoxChoixAutoBbr.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "OseIp12").equals("true") == true) {
					BoxChoixAutoOseIp12.setSelected(true);
				}
				else {
					BoxChoixAutoOseIp12.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Iplabel").equals("true") == true) {
					BoxChoixAutoIplabel.setSelected(true);
				}
				else {
					BoxChoixAutoIplabel.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Newtest").equals("true") == true) {
					BoxChoixAutoNewtest.setSelected(true);
				}
				else {
					BoxChoixAutoNewtest.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Xguard").equals("true") == true) {
					BoxChoixAutoXguard.setSelected(true);
				}
				else {
					BoxChoixAutoXguard.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Hmc").equals("true") == true) {
					BoxChoixAutoHmc.setSelected(true);
				}
				else {
					BoxChoixAutoHmc.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Kvm").equals("true") == true) {
					BoxChoixAutoKvm.setSelected(true);
				}
				else {
					BoxChoixAutoKvm.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Tina5").equals("true") == true) {
					BoxChoixAutoTina5.setSelected(true);
				}
				else {
					BoxChoixAutoTina5.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Tina6").equals("true") == true) {
					BoxChoixAutoTina6.setSelected(true);
				}
				else {
					BoxChoixAutoTina6.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "Vcenter").equals("true") == true) {
					BoxChoixAutoVcenter.setSelected(true);
				}
				else {
					BoxChoixAutoVcenter.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (LaBase.ConsulterLancementAutoPilote(ConnectionBase, "SismoTous").equals("true") == true) {
					BoxChoixAutoSismoTous.setSelected(true);
				}
				else {
					BoxChoixAutoSismoTous.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LaBase.FermerConnexion(ConnectionBase);
		}
	}
}

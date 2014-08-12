import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class UserInterfaceConfig extends JFrame {

	public UserInterfaceConfig() {
		getContentPane().setEnabled(false);
		new UserInterface();

		setTitle("Page de configuration des logins et mots de passe");
		setResizable(false);
		getContentPane().setLayout(null);

		ZoneConfigUnix = new JPanel();
		ZoneConfigUnix.setBounds(0, 0, 145, 101);
		ZoneConfigUnix.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Unix", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigUnix);
		ZoneConfigUnix.setLayout(null);

		TextConfigUnixUser = new JTextField();
		TextConfigUnixUser.setText("User unix");
		TextConfigUnixUser.setBounds(54, 16, 86, 20);
		ZoneConfigUnix.add(TextConfigUnixUser);
		TextConfigUnixUser.setColumns(10);

		LabelConfigUnixUser = new JLabel("User");
		LabelConfigUnixUser.setBounds(6, 19, 38, 14);
		ZoneConfigUnix.add(LabelConfigUnixUser);

		LabelConfigUnixPassword = new JLabel("Pass");
		LabelConfigUnixPassword.setBounds(6, 50, 38, 14);
		ZoneConfigUnix.add(LabelConfigUnixPassword);

		TextConfigUnixPassword = new JPasswordField();
		TextConfigUnixPassword.setText("pass");
		TextConfigUnixPassword.setBounds(54, 47, 86, 20);
		ZoneConfigUnix.add(TextConfigUnixPassword);

		JPanel ZoneConfigGmvs = new JPanel();
		ZoneConfigGmvs.setBounds(186, 233, 150, 105);
		ZoneConfigGmvs.setLayout(null);
		ZoneConfigGmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "TPX Gmvs", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigGmvs);

		TextConfigGmvsUser = new JTextField();
		TextConfigGmvsUser.setText("User gmvs");
		TextConfigGmvsUser.setColumns(10);
		TextConfigGmvsUser.setBounds(47, 16, 86, 20);
		ZoneConfigGmvs.add(TextConfigGmvsUser);

		LabelConfigGmvsUser = new JLabel("User");
		LabelConfigGmvsUser.setBounds(6, 19, 38, 14);
		ZoneConfigGmvs.add(LabelConfigGmvsUser);

		LabelConfigGmvsPassword = new JLabel("Pass");
		LabelConfigGmvsPassword.setBounds(6, 50, 38, 14);
		ZoneConfigGmvs.add(LabelConfigGmvsPassword);

		CheckBoxAutoGmvs = new JCheckBox("Auto connect");
		CheckBoxAutoGmvs.setSelected(true);
		CheckBoxAutoGmvs.setMargin(new Insets(0, 0, 0, 0));
		CheckBoxAutoGmvs.setBounds(6, 82, 97, 14);
		ZoneConfigGmvs.add(CheckBoxAutoGmvs);

		TextConfigGmvsPassword = new JPasswordField();
		TextConfigGmvsPassword.setText("pass");
		TextConfigGmvsPassword.setBounds(47, 47, 86, 20);
		ZoneConfigGmvs.add(TextConfigGmvsPassword);

		ZoneConfigSysa = new JPanel();
		ZoneConfigSysa.setBounds(186, 0, 150, 105);
		ZoneConfigSysa.setLayout(null);
		ZoneConfigSysa.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Sysa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigSysa);

		TextConfigSysaUser = new JTextField();
		TextConfigSysaUser.setText("User sysa");
		TextConfigSysaUser.setColumns(10);
		TextConfigSysaUser.setBounds(54, 16, 86, 20);
		ZoneConfigSysa.add(TextConfigSysaUser);

		LabelConfigSysaUser = new JLabel("User");
		LabelConfigSysaUser.setBounds(6, 19, 38, 14);
		ZoneConfigSysa.add(LabelConfigSysaUser);

		LabelConfigSysaPassword = new JLabel("Pass");
		LabelConfigSysaPassword.setBounds(6, 50, 38, 14);
		ZoneConfigSysa.add(LabelConfigSysaPassword);

		CheckBoxAutoSysa = new JCheckBox("Auto connect");
		CheckBoxAutoSysa.setSelected(true);
		CheckBoxAutoSysa.setMargin(new Insets(0, 0, 0, 0));
		CheckBoxAutoSysa.setBounds(6, 82, 97, 14);
		ZoneConfigSysa.add(CheckBoxAutoSysa);

		TextConfigSysaPassword = new JPasswordField();
		TextConfigSysaPassword.setText("pass");
		TextConfigSysaPassword.setBounds(54, 47, 86, 20);
		ZoneConfigSysa.add(TextConfigSysaPassword);

		ZoneConfigZmvs = new JPanel();
		ZoneConfigZmvs.setBounds(186, 116, 150, 101);
		ZoneConfigZmvs.setLayout(null);
		ZoneConfigZmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Zmvs (CFF)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigZmvs);

		TextConfigZmvsUser = new JTextField();
		TextConfigZmvsUser.setText("User zmvs");
		TextConfigZmvsUser.setColumns(10);
		TextConfigZmvsUser.setBounds(54, 16, 86, 20);
		ZoneConfigZmvs.add(TextConfigZmvsUser);

		LabelConfigZmvsUser = new JLabel("User");
		LabelConfigZmvsUser.setBounds(6, 19, 38, 14);
		ZoneConfigZmvs.add(LabelConfigZmvsUser);

		LabelConfigZmvsPassword = new JLabel("Pass");
		LabelConfigZmvsPassword.setBounds(6, 50, 38, 14);
		ZoneConfigZmvs.add(LabelConfigZmvsPassword);

		CheckBoxAutoZmvs = new JCheckBox("Auto connect");
		CheckBoxAutoZmvs.setSelected(true);
		CheckBoxAutoZmvs.setMargin(new Insets(0, 0, 0, 0));
		CheckBoxAutoZmvs.setBounds(6, 80, 97, 14);
		ZoneConfigZmvs.add(CheckBoxAutoZmvs);

		TextConfigZmvsPassword = new JPasswordField();
		TextConfigZmvsPassword.setText("pass");
		TextConfigZmvsPassword.setBounds(54, 47, 86, 20);
		ZoneConfigZmvs.add(TextConfigZmvsPassword);

		ZoneConfigKmvs = new JPanel();
		ZoneConfigKmvs.setBounds(346, 116, 150, 101);
		ZoneConfigKmvs.setLayout(null);
		ZoneConfigKmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Kmvs (IP0)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigKmvs);

		TextConfigKmvsUser = new JTextField();
		TextConfigKmvsUser.setText("User kmvs");
		TextConfigKmvsUser.setColumns(10);
		TextConfigKmvsUser.setBounds(54, 16, 86, 20);
		ZoneConfigKmvs.add(TextConfigKmvsUser);

		LabelConfigKmvsUser = new JLabel("User");
		LabelConfigKmvsUser.setBounds(6, 19, 38, 14);
		ZoneConfigKmvs.add(LabelConfigKmvsUser);

		LabelConfigKmvsPassword = new JLabel("Pass");
		LabelConfigKmvsPassword.setBounds(6, 50, 38, 14);
		ZoneConfigKmvs.add(LabelConfigKmvsPassword);

		CheckBoxAutoKmvs = new JCheckBox("Auto connect");
		CheckBoxAutoKmvs.setSelected(true);
		CheckBoxAutoKmvs.setMargin(new Insets(0, 0, 0, 0));
		CheckBoxAutoKmvs.setBounds(6, 78, 97, 14);
		ZoneConfigKmvs.add(CheckBoxAutoKmvs);

		TextConfigKmvsPassword = new JPasswordField();
		TextConfigKmvsPassword.setText("pass");
		TextConfigKmvsPassword.setBounds(54, 47, 86, 20);
		ZoneConfigKmvs.add(TextConfigKmvsPassword);

		JPanel ZoneConfigXenos = new JPanel();
		ZoneConfigXenos.setLayout(null);
		ZoneConfigXenos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Sysg (Xenos)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigXenos.setBounds(346, 0, 150, 105);
		getContentPane().add(ZoneConfigXenos);

		TextConfigSysgUser = new JTextField();
		TextConfigSysgUser.setText("User sysg");
		TextConfigSysgUser.setColumns(10);
		TextConfigSysgUser.setBounds(47, 16, 86, 20);
		ZoneConfigXenos.add(TextConfigSysgUser);

		LabelConfigSysgUser = new JLabel("User");
		LabelConfigSysgUser.setBounds(6, 19, 38, 14);
		ZoneConfigXenos.add(LabelConfigSysgUser);

		LabelConfigSysgPassword = new JLabel("Pass");
		LabelConfigSysgPassword.setBounds(6, 50, 38, 14);
		ZoneConfigXenos.add(LabelConfigSysgPassword);

		CheckBoxAutoSysg = new JCheckBox("Auto connect");
		CheckBoxAutoSysg.setMargin(new Insets(0, 0, 0, 0));
		CheckBoxAutoSysg.setSelected(true);
		CheckBoxAutoSysg.setBounds(6, 82, 97, 14);
		ZoneConfigXenos.add(CheckBoxAutoSysg);

		TextConfigSysgPassword = new JPasswordField();
		TextConfigSysgPassword.setText("pass");
		TextConfigSysgPassword.setBounds(47, 47, 86, 20);
		ZoneConfigXenos.add(TextConfigSysgPassword);

		LabelConfigValide = new JLabel("");
		LabelConfigValide.setBounds(10, 439, 145, 19);
		LabelConfigValide.setForeground(new Color(60, 179, 113));
		LabelConfigValide.setFont(new Font("Verdana", Font.PLAIN, 12));
		getContentPane().add(LabelConfigValide);

		LabelConfigValide.setForeground(Color.GRAY);

		ProgressBarValideConfig = new JProgressBar();
		ProgressBarValideConfig.setBounds(10, 469, 175, 19);
		ProgressBarValideConfig.setStringPainted(true);
		ProgressBarValideConfig.setForeground(new Color(34, 139, 34));
		getContentPane().add(ProgressBarValideConfig);

		ProgressBarValideConfig.setValue(0);

		BoutonValiderConfig = new JButton("Valider la configuration");
		final ImageIcon IconValider = new ImageIcon(getClass().getResource("/Ok-icon.png"));
		BoutonValiderConfig.setIcon(IconValider);

		BoutonValiderConfig.setBounds(10, 499, 175, 51);
		BoutonValiderConfig.setMargin(new Insets(1, 1, 1, 1));
		getContentPane().add(BoutonValiderConfig);
		BoutonValiderConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				new Thread(new ThreadValidationConfig()).start();

			}
		});

		BoutonRechargerConfig = new JButton("Recharger la configuration");
		BoutonRechargerConfig.setBounds(186, 499, 175, 51);
		BoutonRechargerConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				// THREAD RELOAD
				//
				//
				new Thread(new ThreadChargerConfig()).start();
				//
				//
				// -------------------------------------------------------
				// -------------------------------------------------------

			}
		});
		BoutonRechargerConfig.setIcon(new ImageIcon(UserInterfaceConfig.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		BoutonRechargerConfig.setMargin(new Insets(1, 1, 1, 1));
		getContentPane().add(BoutonRechargerConfig);

		JPanel ZoneConfigWindows = new JPanel();
		ZoneConfigWindows.setLayout(null);
		ZoneConfigWindows.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Windows*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigWindows.setBounds(0, 112, 145, 105);
		getContentPane().add(ZoneConfigWindows);

		TextConfigWindowsUser = new JTextField();
		TextConfigWindowsUser.setText("User Windows");
		// TextConfigWindowsUser.setEnable(true);
		TextConfigWindowsUser.setBounds(39, 16, 86, 20);
		ZoneConfigWindows.add(TextConfigWindowsUser);

		JLabel LabelConfigWindowsUser = new JLabel("User");
		LabelConfigWindowsUser.setBounds(6, 19, 38, 14);
		ZoneConfigWindows.add(LabelConfigWindowsUser);

		JLabel LabelConfigWindowsPassword = new JLabel("Pass");
		LabelConfigWindowsPassword.setBounds(6, 50, 38, 14);
		ZoneConfigWindows.add(LabelConfigWindowsPassword);

		TextConfigWindowsPass = new JPasswordField();
		TextConfigWindowsPass.setText("pass");
		TextConfigWindowsPass.setEnabled(true);
		ZoneConfigWindows.add(TextConfigWindowsPass);

		TextConfigWindowsPassword = new JPasswordField();
		TextConfigWindowsPassword.setText("pass");
		TextConfigWindowsPassword.setBounds(39, 47, 86, 20);
		ZoneConfigWindows.add(TextConfigWindowsPassword);

		JLabel lblUtilisPar = new JLabel("* Utilis\u00E9 par Vtom");
		lblUtilisPar.setBounds(26, 80, 109, 14);
		ZoneConfigWindows.add(lblUtilisPar);

		ZoneConfigAs400 = new JPanel();
		ZoneConfigAs400.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "AS400 Device name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigAs400.setBounds(0, 233, 157, 189);
		getContentPane().add(ZoneConfigAs400);
		ZoneConfigAs400.setLayout(null);

		lblBr = new JLabel("BR");
		lblBr.setBounds(6, 19, 38, 14);
		ZoneConfigAs400.add(lblBr);

		TextConfigAs400DeviceBr = new JTextField();
		TextConfigAs400DeviceBr.setBounds(65, 16, 86, 20);
		ZoneConfigAs400.add(TextConfigAs400DeviceBr);
		TextConfigAs400DeviceBr.setColumns(10);

		JLabel lblBdi = new JLabel("BDI");
		lblBdi.setBounds(6, 47, 49, 14);
		ZoneConfigAs400.add(lblBdi);

		TextConfigAs400DeviceBdi = new JTextField();
		TextConfigAs400DeviceBdi.setBounds(65, 44, 86, 20);
		ZoneConfigAs400.add(TextConfigAs400DeviceBdi);
		TextConfigAs400DeviceBdi.setColumns(10);

		JLabel lblBdaf = new JLabel("BDAF");
		lblBdaf.setBounds(6, 78, 38, 14);
		ZoneConfigAs400.add(lblBdaf);

		TextConfigAs400DeviceBdaf = new JTextField();
		TextConfigAs400DeviceBdaf.setBounds(65, 75, 86, 20);
		ZoneConfigAs400.add(TextConfigAs400DeviceBdaf);
		TextConfigAs400DeviceBdaf.setColumns(10);

		JLabel lblSocly = new JLabel("SOCLY");
		lblSocly.setBounds(6, 109, 49, 14);
		ZoneConfigAs400.add(lblSocly);

		TextConfigAs400DeviceSocly = new JTextField();
		TextConfigAs400DeviceSocly.setBounds(65, 106, 86, 20);
		ZoneConfigAs400.add(TextConfigAs400DeviceSocly);
		TextConfigAs400DeviceSocly.setColumns(10);

		JLabel lblSocmcsd = new JLabel("SOCMCSD");
		lblSocmcsd.setBounds(6, 137, 59, 14);
		ZoneConfigAs400.add(lblSocmcsd);

		TextConfigAs400DeviceSocmcsd = new JTextField();
		TextConfigAs400DeviceSocmcsd.setBounds(65, 134, 86, 20);
		ZoneConfigAs400.add(TextConfigAs400DeviceSocmcsd);
		TextConfigAs400DeviceSocmcsd.setColumns(10);

		JLabel lblPfbcly = new JLabel("PFBCLY");
		lblPfbcly.setBounds(6, 165, 49, 14);
		ZoneConfigAs400.add(lblPfbcly);

		TextConfigAs400DevicePfb = new JTextField();
		TextConfigAs400DevicePfb.setBounds(65, 162, 86, 20);
		ZoneConfigAs400.add(TextConfigAs400DevicePfb);
		TextConfigAs400DevicePfb.setColumns(10);

		// Fin

		// D�but du chargement de la page de config

		// ----------------------------------------------------------------------------------------------

		new Thread(new ThreadChargerConfig()).start();

	}

	public Boolean DemandeEtatAutoLoginGmvs() {
		return CheckBoxAutoGmvs.isSelected();
	}

	public Boolean DemandeEtatAutoLoginZmvs() {
		return CheckBoxAutoZmvs.isSelected();
	}

	public Boolean DemandeEtatAutoLoginKmvs() {
		return CheckBoxAutoKmvs.isSelected();
	}

	public Boolean DemandeEtatAutoLoginSysa() {
		return CheckBoxAutoSysa.isSelected();
	}

	public Boolean DemandeEtatAutoLoginSysg() {
		return CheckBoxAutoSysg.isSelected();
	}

	public class ThreadValidationConfig implements Runnable {

		@Override
		public void run() {
			EnableDisableTouteZonesSaisies(false);
			BoutonValiderConfig.setEnabled(false);
			BoutonRechargerConfig.setEnabled(false);
			String UserUnix = TextConfigUnixUser.getText().toLowerCase();
			TextConfigUnixUser.setText(UserUnix);
			@SuppressWarnings("deprecation")
			String PassUnix = TextConfigUnixPassword.getText();

			String UserWindows = TextConfigWindowsUser.getText();
			@SuppressWarnings("deprecation")
			String PassWindows = TextConfigWindowsPassword.getText();

			String UserGmvs = TextConfigGmvsUser.getText();
			@SuppressWarnings("deprecation")
			String PassGmvs = TextConfigGmvsPassword.getText();
			Boolean EtatAutoConnectGmvs = CheckBoxAutoGmvs.isSelected();

			String UserSysa = TextConfigSysaUser.getText();
			@SuppressWarnings("deprecation")
			String PassSysa = TextConfigSysaPassword.getText();
			Boolean EtatAutoConnectSysa = CheckBoxAutoSysa.isSelected();

			String UserKmvs = TextConfigKmvsUser.getText();
			@SuppressWarnings("deprecation")
			String PassKmvs = TextConfigKmvsPassword.getText();
			Boolean EtatAutoConnectKmvs = CheckBoxAutoKmvs.isSelected();

			String UserZmvs = TextConfigZmvsUser.getText();
			@SuppressWarnings("deprecation")
			String PassZmvs = TextConfigZmvsPassword.getText();
			Boolean EtatAutoConnectZmvs = CheckBoxAutoZmvs.isSelected();

			String UserSysg = TextConfigSysgUser.getText();
			@SuppressWarnings("deprecation")
			String PassSysg = TextConfigSysgPassword.getText();
			Boolean EtatAutoConnectSysg = CheckBoxAutoSysg.isSelected();

			String DeviceAs400Br = TextConfigAs400DeviceBr.getText().toUpperCase();
			TextConfigAs400DeviceBr.setText(DeviceAs400Br);
			String DeviceAs400Bdi = TextConfigAs400DeviceBdi.getText().toUpperCase();
			TextConfigAs400DeviceBdi.setText(DeviceAs400Bdi);
			String DeviceAs400Bdaf = TextConfigAs400DeviceBdaf.getText().toUpperCase();
			TextConfigAs400DeviceBdaf.setText(DeviceAs400Bdaf);
			String DeviceAs400Socly = TextConfigAs400DeviceSocly.getText().toUpperCase();
			TextConfigAs400DeviceSocly.setText(DeviceAs400Socly);
			String DeviceAs400Socmcsd = TextConfigAs400DeviceSocmcsd.getText().toUpperCase();
			TextConfigAs400DeviceSocmcsd.setText(DeviceAs400Socmcsd);
			String DeviceAs400Pfb = TextConfigAs400DevicePfb.getText().toUpperCase();
			TextConfigAs400DevicePfb.setText(DeviceAs400Pfb);

			LabelConfigValide.setForeground(Color.GRAY);
			LabelConfigValide.setText("");
			GestionConfig MaConfig = new GestionConfig();

			MaConfig.EcrireUser("user", "Unix", UserUnix);
			ProgressBarValideConfig.setValue(10);
			MaConfig.EcrireUser("user", "Windows", UserWindows);
			ProgressBarValideConfig.setValue(15);
			MaConfig.EcrireUser("user", "Gmvs", UserGmvs);
			ProgressBarValideConfig.setValue(20);
			MaConfig.EcrireUser("user", "Sysa", UserSysa);
			ProgressBarValideConfig.setValue(30);
			MaConfig.EcrireUser("user", "Kmvs", UserKmvs);
			ProgressBarValideConfig.setValue(40);
			MaConfig.EcrireUser("user", "Zmvs", UserZmvs);
			ProgressBarValideConfig.setValue(50);
			MaConfig.EcrireUser("user", "Sysg", UserSysg);

			MaConfig.EcrirePassword("password", "Unix", PassUnix);
			ProgressBarValideConfig.setValue(60);
			MaConfig.EcrirePassword("password", "Windows", PassWindows);
			ProgressBarValideConfig.setValue(65);
			MaConfig.EcrirePassword("password", "Gmvs", PassGmvs);
			ProgressBarValideConfig.setValue(70);
			MaConfig.EcrirePassword("password", "Sysa", PassSysa);
			ProgressBarValideConfig.setValue(80);
			MaConfig.EcrirePassword("password", "Kmvs", PassKmvs);
			ProgressBarValideConfig.setValue(90);
			MaConfig.EcrirePassword("password", "Zmvs", PassZmvs);
			ProgressBarValideConfig.setValue(95);
			MaConfig.EcrirePassword("password", "Sysg", PassSysg);
			ProgressBarValideConfig.setValue(100);

			MaConfig.EcrireUser("DeviceName", "Br", DeviceAs400Br);
			MaConfig.EcrireUser("DeviceName", "Bdi", DeviceAs400Bdi);
			MaConfig.EcrireUser("DeviceName", "Bdaf", DeviceAs400Bdaf);
			MaConfig.EcrireUser("DeviceName", "Socly", DeviceAs400Socly);
			MaConfig.EcrireUser("DeviceName", "Socmcsd", DeviceAs400Socmcsd);
			MaConfig.EcrireUser("DeviceName", "Pfb", DeviceAs400Pfb);

			if (EtatAutoConnectGmvs == true) {
				MaConfig.EcrireAutoConnect("autoconnect", "Gmvs", "true");
			}
			if (EtatAutoConnectGmvs == false) {
				MaConfig.EcrireAutoConnect("autoconnect", "Gmvs", "false");
			}

			if (EtatAutoConnectSysa == true) {
				MaConfig.EcrireAutoConnect("autoconnect", "Sysa", "true");
			}
			if (EtatAutoConnectSysa == false) {
				MaConfig.EcrireAutoConnect("autoconnect", "Sysa", "false");
			}

			if (EtatAutoConnectSysg == true) {
				MaConfig.EcrireAutoConnect("autoconnect", "Sysg", "true");
			}
			if (EtatAutoConnectSysg == false) {
				MaConfig.EcrireAutoConnect("autoconnect", "Sysg", "false");
			}

			if (EtatAutoConnectKmvs == true) {
				MaConfig.EcrireAutoConnect("autoconnect", "Kmvs", "true");
			}
			if (EtatAutoConnectKmvs == false) {
				MaConfig.EcrireAutoConnect("autoconnect", "Kmvs", "false");
			}

			if (EtatAutoConnectZmvs == true) {
				MaConfig.EcrireAutoConnect("autoconnect", "Zmvs", "true");
			}
			if (EtatAutoConnectZmvs == false) {
				MaConfig.EcrireAutoConnect("autoconnect", "Zmvs", "false");
			}

			// System.out.println(EcritureValideOuErreur);
			LabelConfigValide.setText("Config sauvegard\u00E9e!");
			LabelConfigValide.setForeground(new Color(60, 179, 113));

			GestionProfile GP = new GestionProfile();

			try {
				GP.ModifierPasswordProfile("Gmvs", MaConfig.DemandePassword("Gmvs"));
				GP.ModifierUserProfile("Gmvs", MaConfig.DemandeUser("Gmvs"));
				GP.ModifierUserNameStationProfile("GMVS");

				GP.ModifierPasswordProfile("Sysg", MaConfig.DemandePassword("Sysg"));
				GP.ModifierUserProfile("Sysg", MaConfig.DemandeUser("Sysg"));
				GP.ModifierUserNameStationProfile("Sysg");

				GP.ModifierPasswordProfile("Zmvs", MaConfig.DemandePassword("Zmvs"));
				GP.ModifierUserProfile("Zmvs", MaConfig.DemandeUser("Zmvs"));
				GP.ModifierUserNameStationProfile("ZMVS");

				GP.ModifierPasswordProfile("Kmvs", MaConfig.DemandePassword("Kmvs"));
				GP.ModifierUserProfile("Kmvs", MaConfig.DemandeUser("Kmvs"));
				GP.ModifierUserNameStationProfile("KMVS");

				GP.ModifierPasswordProfile("Sysa", MaConfig.DemandePassword("Sysa"));
				GP.ModifierUserProfile("Sysa", MaConfig.DemandeUser("Sysa"));
				GP.ModifierUserNameStationProfile("Sysa");

				// AS400

				GP.ModifierUserNameStationProfile("BRCLY");
				GP.ModifierUserNameStationProfile("BDAFCLY");
				GP.ModifierUserNameStationProfile("BDICLY");

				GP.ModifierUserNameStationProfile("SOCLY");
				GP.ModifierUserNameStationProfile("SOCMCSD");

				GP.ModifierUserNameStationProfile("PFBCLY");

				GP.ModifierDeviceName("BRCLY", DeviceAs400Br);
				GP.ModifierDeviceName("BDICLY", DeviceAs400Bdi);
				GP.ModifierDeviceName("BDAFCLY", DeviceAs400Bdaf);
				GP.ModifierDeviceName("SOCLY", DeviceAs400Socly);
				GP.ModifierDeviceName("SOCMCSD", DeviceAs400Socmcsd);
				GP.ModifierDeviceName("PFBCLY", DeviceAs400Pfb);

			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			EnableDisableTouteZonesSaisies(true);
			BoutonValiderConfig.setEnabled(true);
			BoutonRechargerConfig.setEnabled(true);
		}

	}

	public class ThreadChargerConfig implements Runnable {

		@Override
		public void run() {

			EnableDisableTouteZonesSaisies(false);
			BoutonRechargerConfig.setEnabled(false);
			int CodeRetour = 5;

			String UserUnix = "#erreur";
			String PassUnix = "#erreur";

			String UserWindows = "#erreur";
			String PassWindows = "#erreur";

			String UserGmvs = "#erreur";
			String PassGmvs = "#erreur";
			String ResultatDemandeAutoConnectGmvs = null;

			String UserSysa = "#erreur";
			String PassSysa = "#erreur";
			String ResultatDemandeAutoConnectSysa = null;

			String UserKmvs = "#erreur";
			String PassKmvs = "#erreur";
			String ResultatDemandeAutoConnectKmvs = null;

			String UserZmvs = "#erreur";
			String PassZmvs = "#erreur";
			String ResultatDemandeAutoConnectZmvs = null;

			String UserSysg = "#erreur";
			String PassSysg = "#erreur";
			String ResultatDemandeAutoConnectSysg = null;

			String DeviceBr = "#erreur";
			String DeviceBdi = "#erreur";
			String DeviceBdaf = "#erreur";
			String DeviceSocly = "#erreur";
			String DeviceSocmcsd = "#erreur";
			String DevicePfb = "#erreur";

			ProgressBarValideConfig.setValue(0);
			LabelConfigValide.setForeground(Color.GRAY);
			LabelConfigValide.setText("Config recharg�e");
			GestionConfig MaConfig = new GestionConfig();
			CodeRetour = MaConfig.LireConfig();
			// UserG = MaConfig.DemandeUser("G");
			// UserUnix = MaConfig.DemandeUser("Unix");
			if (CodeRetour == 0) {

				// LOAD AS4000

				DeviceBr = MaConfig.DemandeDevice("Br");
				TextConfigAs400DeviceBr.setText(DeviceBr);

				DeviceBdi = MaConfig.DemandeDevice("Bdi");
				TextConfigAs400DeviceBdi.setText(DeviceBdi);

				DeviceBdaf = MaConfig.DemandeDevice("Bdaf");
				TextConfigAs400DeviceBdaf.setText(DeviceBdaf);

				DeviceSocly = MaConfig.DemandeDevice("Socly");
				TextConfigAs400DeviceSocly.setText(DeviceSocly);

				DeviceSocmcsd = MaConfig.DemandeDevice("Socmcsd");
				TextConfigAs400DeviceSocmcsd.setText(DeviceSocmcsd);

				DevicePfb = MaConfig.DemandeDevice("Pfb");
				TextConfigAs400DevicePfb.setText(DevicePfb);

				// ---------

				UserUnix = MaConfig.DemandeUser("Unix");
				PassUnix = MaConfig.DemandePassword("Unix");
				TextConfigUnixUser.setText(UserUnix);
				TextConfigUnixPassword.setText(PassUnix);

				UserWindows = MaConfig.DemandeUser("Windows");
				PassWindows = MaConfig.DemandePassword("Windows");
				TextConfigWindowsUser.setText(UserWindows);
				TextConfigWindowsPassword.setText(PassWindows);

				UserGmvs = MaConfig.DemandeUser("Gmvs");
				PassGmvs = MaConfig.DemandePassword("Gmvs");
				TextConfigGmvsUser.setText(UserGmvs);
				TextConfigGmvsPassword.setText(PassGmvs);
				ResultatDemandeAutoConnectGmvs = MaConfig.DemandeAutoConnect("Gmvs");
				if (ResultatDemandeAutoConnectGmvs.equals("true")) {
					CheckBoxAutoGmvs.setSelected(true);
				}
				if (ResultatDemandeAutoConnectGmvs.equals("false")) {
					CheckBoxAutoGmvs.setSelected(false);
				}

				UserSysa = MaConfig.DemandeUser("Sysa");
				PassSysa = MaConfig.DemandePassword("Sysa");
				TextConfigSysaUser.setText(UserSysa);
				TextConfigSysaPassword.setText(PassSysa);
				ResultatDemandeAutoConnectSysa = MaConfig.DemandeAutoConnect("Sysa");
				if (ResultatDemandeAutoConnectSysa.equals("true")) {
					CheckBoxAutoSysa.setSelected(true);
				}
				if (ResultatDemandeAutoConnectSysa.equals("false")) {
					CheckBoxAutoSysa.setSelected(false);
				}
				;

				UserKmvs = MaConfig.DemandeUser("Kmvs");
				PassKmvs = MaConfig.DemandePassword("Kmvs");
				TextConfigKmvsUser.setText(UserKmvs);
				TextConfigKmvsPassword.setText(PassKmvs);
				ResultatDemandeAutoConnectKmvs = MaConfig.DemandeAutoConnect("Kmvs");
				if (ResultatDemandeAutoConnectKmvs.equals("true")) {
					CheckBoxAutoKmvs.setSelected(true);
				}
				if (ResultatDemandeAutoConnectKmvs.equals("false")) {
					CheckBoxAutoKmvs.setSelected(false);
				}

				UserZmvs = MaConfig.DemandeUser("Zmvs");
				PassZmvs = MaConfig.DemandePassword("Zmvs");
				TextConfigZmvsUser.setText(UserZmvs);
				TextConfigZmvsPassword.setText(PassZmvs);
				ResultatDemandeAutoConnectZmvs = MaConfig.DemandeAutoConnect("Zmvs");
				if (ResultatDemandeAutoConnectZmvs.equals("true")) {
					CheckBoxAutoZmvs.setSelected(true);
				}
				if (ResultatDemandeAutoConnectZmvs.equals("false")) {
					CheckBoxAutoZmvs.setSelected(false);
				}

				UserSysg = MaConfig.DemandeUser("Sysg");
				PassSysg = MaConfig.DemandePassword("Sysg");
				TextConfigSysgUser.setText(UserSysg);
				TextConfigSysgPassword.setText(PassSysg);
				ResultatDemandeAutoConnectSysg = MaConfig.DemandeAutoConnect("Sysg");
				if (ResultatDemandeAutoConnectSysg.equals("true")) {
					CheckBoxAutoSysg.setSelected(true);
				}
				if (ResultatDemandeAutoConnectSysg.equals("false")) {
					CheckBoxAutoSysg.setSelected(false);
				}

			}
			if (CodeRetour == 1) {

			}
			EnableDisableTouteZonesSaisies(true);
			BoutonRechargerConfig.setEnabled(true);

		}
	}

	public void EnableDisableTouteZonesSaisies(Boolean ChoixEtat) {
		CheckBoxAutoGmvs.setEnabled(ChoixEtat);
		CheckBoxAutoZmvs.setEnabled(ChoixEtat);
		CheckBoxAutoKmvs.setEnabled(ChoixEtat);
		CheckBoxAutoSysa.setEnabled(ChoixEtat);
		CheckBoxAutoSysg.setEnabled(ChoixEtat);

		TextConfigUnixUser.setEnabled(ChoixEtat);
		TextConfigWindowsUser.setEnabled(ChoixEtat);
		TextConfigKmvsUser.setEnabled(ChoixEtat);
		TextConfigGmvsUser.setEnabled(ChoixEtat);
		TextConfigSysgUser.setEnabled(ChoixEtat);
		TextConfigSysaUser.setEnabled(ChoixEtat);
		TextConfigZmvsUser.setEnabled(ChoixEtat);

		TextConfigAs400DeviceBr.setEnabled(ChoixEtat);
		TextConfigAs400DeviceBdi.setEnabled(ChoixEtat);
		TextConfigAs400DeviceBdaf.setEnabled(ChoixEtat);
		TextConfigAs400DeviceSocly.setEnabled(ChoixEtat);
		TextConfigAs400DeviceSocmcsd.setEnabled(ChoixEtat);
		TextConfigAs400DevicePfb.setEnabled(ChoixEtat);

		TextConfigUnixPassword.setEnabled(ChoixEtat);
		TextConfigWindowsPassword.setEnabled(ChoixEtat);
		TextConfigKmvsPassword.setEnabled(ChoixEtat);
		TextConfigGmvsPassword.setEnabled(ChoixEtat);
		TextConfigZmvsPassword.setEnabled(ChoixEtat);
		TextConfigSysaPassword.setEnabled(ChoixEtat);
		TextConfigSysgPassword.setEnabled(ChoixEtat);
	}

	private static final long serialVersionUID = 1L;
	private JCheckBox CheckBoxAutoGmvs;
	private JCheckBox CheckBoxAutoZmvs;
	private JCheckBox CheckBoxAutoKmvs;
	private JCheckBox CheckBoxAutoSysa;
	private JCheckBox CheckBoxAutoSysg;
	private JTextField TextConfigUnixUser;
	// private JTextField TextConfigUnixPassword;
	private JPanel ZoneConfigUnix;
	private JTextField TextConfigGmvsUser;

	private JPanel ZoneConfigSysa;
	private JTextField TextConfigSysaUser;

	private JLabel LabelConfigSysaUser;
	private JLabel LabelConfigSysaPassword;
	private JPanel ZoneConfigKmvs;
	private JTextField TextConfigKmvsUser;

	private JLabel LabelConfigKmvsUser;
	private JLabel LabelConfigKmvsPassword;
	private JPanel ZoneConfigZmvs;
	private JTextField TextConfigZmvsUser;

	private JLabel LabelConfigZmvsUser;
	private JLabel LabelConfigZmvsPassword;

	private JButton BoutonRechargerConfig;
	private JTextField TextConfigSysgUser;

	private JPasswordField TextConfigGmvsPassword;
	private JPasswordField TextConfigSysaPassword;
	private JPasswordField TextConfigZmvsPassword;
	private JPasswordField TextConfigKmvsPassword;
	private JPasswordField TextConfigSysgPassword;
	private JPasswordField TextConfigUnixPassword;

	private JLabel LabelConfigSysgUser;
	private JLabel LabelConfigSysgPassword;
	private JLabel LabelConfigValide;
	private JProgressBar ProgressBarValideConfig;
	private JButton BoutonValiderConfig;
	private JLabel LabelConfigUnixUser;
	private JLabel LabelConfigUnixPassword;
	private JLabel LabelConfigGmvsUser;
	private JLabel LabelConfigGmvsPassword;
	private JTextField TextConfigWindowsUser;
	private JPasswordField TextConfigWindowsPass;
	private JPasswordField TextConfigWindowsPassword;
	private JLabel lblBr;
	private JTextField TextConfigAs400DeviceBr;
	private JTextField TextConfigAs400DeviceBdi;
	private JTextField TextConfigAs400DeviceBdaf;
	private JTextField TextConfigAs400DeviceSocly;
	private JTextField TextConfigAs400DeviceSocmcsd;
	private JTextField TextConfigAs400DevicePfb;
	private JPanel ZoneConfigAs400;
}

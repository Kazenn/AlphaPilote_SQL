import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class UserInterfaceConfig extends JFrame {

	public UserInterfaceConfig() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// new Thread(new ThreadValidationConfig()).start();
			}
		});
		setType(Type.UTILITY);
		getContentPane().setEnabled(false);

		setTitle("Configuration des logins et passwords");
		setResizable(false);
		getContentPane().setLayout(null);

		ZoneConfigUnix = new JPanel();
		ZoneConfigUnix.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		ZoneConfigUnix.setBackground(new Color(255, 228, 196));
		ZoneConfigUnix.setBounds(0, 0, 145, 101);
		ZoneConfigUnix.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Unix", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigUnix);
		ZoneConfigUnix.setLayout(null);

		TextConfigUnixUser = new JTextField();

		TextConfigUnixUser.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
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
		TextConfigUnixPassword.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		TextConfigUnixPassword.setBounds(54, 47, 86, 20);
		ZoneConfigUnix.add(TextConfigUnixPassword);

		JPanel ZoneConfigGmvs = new JPanel();
		ZoneConfigGmvs.setBackground(new Color(255, 228, 196));
		ZoneConfigGmvs.setBounds(524, 0, 150, 105);
		ZoneConfigGmvs.setLayout(null);
		ZoneConfigGmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "TPX Gmvs", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigGmvs);

		TextConfigGmvsUser = new JTextField();
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
		TextConfigGmvsPassword.setBounds(47, 47, 86, 20);
		ZoneConfigGmvs.add(TextConfigGmvsPassword);

		ZoneConfigSysa = new JPanel();
		ZoneConfigSysa.setBackground(new Color(173, 216, 230));
		ZoneConfigSysa.setBounds(186, 0, 150, 105);
		ZoneConfigSysa.setLayout(null);
		ZoneConfigSysa.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Sysa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigSysa);

		TextConfigSysaUser = new JTextField();
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
		TextConfigSysaPassword.setBounds(54, 47, 86, 20);
		ZoneConfigSysa.add(TextConfigSysaPassword);

		ZoneConfigZmvs = new JPanel();
		ZoneConfigZmvs.setBackground(new Color(173, 216, 230));
		ZoneConfigZmvs.setBounds(186, 116, 150, 101);
		ZoneConfigZmvs.setLayout(null);
		ZoneConfigZmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Zmvs (CFF)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigZmvs);

		TextConfigZmvsUser = new JTextField();
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
		TextConfigZmvsPassword.setBounds(54, 47, 86, 20);
		ZoneConfigZmvs.add(TextConfigZmvsPassword);

		ZoneConfigKmvs = new JPanel();
		ZoneConfigKmvs.setBackground(new Color(173, 216, 230));
		ZoneConfigKmvs.setBounds(346, 116, 150, 101);
		ZoneConfigKmvs.setLayout(null);
		ZoneConfigKmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Kmvs (IP0)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigKmvs);

		TextConfigKmvsUser = new JTextField();
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
		TextConfigKmvsPassword.setBounds(54, 47, 86, 20);
		ZoneConfigKmvs.add(TextConfigKmvsPassword);

		JPanel ZoneConfigXenos = new JPanel();
		ZoneConfigXenos.setBackground(new Color(173, 216, 230));
		ZoneConfigXenos.setLayout(null);
		ZoneConfigXenos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Sysg (Xenos)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigXenos.setBounds(346, 0, 150, 105);
		getContentPane().add(ZoneConfigXenos);

		TextConfigSysgUser = new JTextField();
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
		ZoneConfigWindows.setBackground(new Color(255, 140, 0));
		ZoneConfigWindows.setLayout(null);
		ZoneConfigWindows.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Windows*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigWindows.setBounds(0, 112, 145, 105);
		getContentPane().add(ZoneConfigWindows);

		TextConfigWindowsUser = new JTextField();
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
		TextConfigWindowsPassword.setBounds(39, 47, 86, 20);
		ZoneConfigWindows.add(TextConfigWindowsPassword);

		JLabel lblUtilisPar = new JLabel("* Utilis\u00E9 par Vtom");
		lblUtilisPar.setBounds(26, 80, 109, 14);
		ZoneConfigWindows.add(lblUtilisPar);

		ZoneConfigAs400 = new JPanel();
		ZoneConfigAs400.setBackground(new Color(127, 255, 212));
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

		ZoneConfigBmvs = new JPanel();
		ZoneConfigBmvs.setBackground(new Color(255, 228, 196));
		ZoneConfigBmvs.setLayout(null);
		ZoneConfigBmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Bmvs", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigBmvs.setBounds(524, 116, 150, 101);
		getContentPane().add(ZoneConfigBmvs);

		TextConfigBmvsUser = new JTextField();
		TextConfigBmvsUser.setColumns(10);
		TextConfigBmvsUser.setBounds(54, 16, 86, 20);
		ZoneConfigBmvs.add(TextConfigBmvsUser);

		LabelConfigBmvsUser = new JLabel("User");
		LabelConfigBmvsUser.setBounds(6, 19, 38, 14);
		ZoneConfigBmvs.add(LabelConfigBmvsUser);

		LabelConfigBmvsPassword = new JLabel("Pass");
		LabelConfigBmvsPassword.setBounds(6, 50, 38, 14);
		ZoneConfigBmvs.add(LabelConfigBmvsPassword);

		CheckBoxAutoBmvs = new JCheckBox("Auto connect");
		CheckBoxAutoBmvs.setSelected(true);
		CheckBoxAutoBmvs.setMargin(new Insets(0, 0, 0, 0));
		CheckBoxAutoBmvs.setBounds(6, 78, 97, 14);
		ZoneConfigBmvs.add(CheckBoxAutoBmvs);

		TextConfigBmvsPassword = new JPasswordField();
		TextConfigBmvsPassword.setBounds(54, 47, 86, 20);
		ZoneConfigBmvs.add(TextConfigBmvsPassword);

		ZoneConfigIp1 = new JPanel();
		ZoneConfigIp1.setBackground(new Color(173, 216, 230));
		ZoneConfigIp1.setLayout(null);
		ZoneConfigIp1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Ip1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigIp1.setBounds(186, 228, 150, 101);
		getContentPane().add(ZoneConfigIp1);

		TextConfigIp1User = new JTextField();
		TextConfigIp1User.setColumns(10);
		TextConfigIp1User.setBounds(54, 16, 86, 20);
		ZoneConfigIp1.add(TextConfigIp1User);

		LabelConfigIp1User = new JLabel("User");
		LabelConfigIp1User.setBounds(6, 19, 38, 14);
		ZoneConfigIp1.add(LabelConfigIp1User);

		LabelConfigIp1Password = new JLabel("Pass");
		LabelConfigIp1Password.setBounds(6, 50, 38, 14);
		ZoneConfigIp1.add(LabelConfigIp1Password);

		CheckBoxAutoIp1 = new JCheckBox("Auto connect");
		CheckBoxAutoIp1.setSelected(true);
		CheckBoxAutoIp1.setMargin(new Insets(0, 0, 0, 0));
		CheckBoxAutoIp1.setBounds(6, 78, 97, 14);
		ZoneConfigIp1.add(CheckBoxAutoIp1);

		TextConfigIp1Password = new JPasswordField();
		TextConfigIp1Password.setBounds(54, 47, 86, 20);
		ZoneConfigIp1.add(TextConfigIp1Password);

		ZoneConfigIp2 = new JPanel();
		ZoneConfigIp2.setBackground(new Color(173, 216, 230));
		ZoneConfigIp2.setLayout(null);
		ZoneConfigIp2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Ip2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigIp2.setBounds(346, 228, 150, 101);
		getContentPane().add(ZoneConfigIp2);

		TextConfigIp2User = new JTextField();
		TextConfigIp2User.setColumns(10);
		TextConfigIp2User.setBounds(54, 16, 86, 20);
		ZoneConfigIp2.add(TextConfigIp2User);

		LabelConfigIp2User = new JLabel("User");
		LabelConfigIp2User.setBounds(6, 19, 38, 14);
		ZoneConfigIp2.add(LabelConfigIp2User);

		LabelConfigIp2Password = new JLabel("Pass");
		LabelConfigIp2Password.setBounds(6, 50, 38, 14);
		ZoneConfigIp2.add(LabelConfigIp2Password);

		CheckBoxAutoIp2 = new JCheckBox("Auto connect");
		CheckBoxAutoIp2.setSelected(true);
		CheckBoxAutoIp2.setMargin(new Insets(0, 0, 0, 0));
		CheckBoxAutoIp2.setBounds(6, 78, 97, 14);
		ZoneConfigIp2.add(CheckBoxAutoIp2);

		TextConfigIp2Password = new JPasswordField();
		TextConfigIp2Password.setBounds(54, 47, 86, 20);
		ZoneConfigIp2.add(TextConfigIp2Password);

		ZoneConfigIp3 = new JPanel();
		ZoneConfigIp3.setBackground(new Color(173, 216, 230));
		ZoneConfigIp3.setLayout(null);
		ZoneConfigIp3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Ip3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigIp3.setBounds(186, 340, 150, 101);
		getContentPane().add(ZoneConfigIp3);

		TextConfigIp3User = new JTextField();
		TextConfigIp3User.setColumns(10);
		TextConfigIp3User.setBounds(54, 16, 86, 20);
		ZoneConfigIp3.add(TextConfigIp3User);

		LabelConfigIp3User = new JLabel("User");
		LabelConfigIp3User.setBounds(6, 19, 38, 14);
		ZoneConfigIp3.add(LabelConfigIp3User);

		LabelConfigIp3Password = new JLabel("Pass");
		LabelConfigIp3Password.setBounds(6, 50, 38, 14);
		ZoneConfigIp3.add(LabelConfigIp3Password);

		CheckBoxAutoIp3 = new JCheckBox("Auto connect");
		CheckBoxAutoIp3.setSelected(true);
		CheckBoxAutoIp3.setMargin(new Insets(0, 0, 0, 0));
		CheckBoxAutoIp3.setBounds(6, 78, 97, 14);
		ZoneConfigIp3.add(CheckBoxAutoIp3);

		TextConfigIp3Password = new JPasswordField();
		TextConfigIp3Password.setBounds(54, 47, 86, 20);
		ZoneConfigIp3.add(TextConfigIp3Password);

		LabelEnregistrement = new JLabel("Enregistrement en cours :");
		LabelEnregistrement.setBounds(575, 531, 211, 19);
		getContentPane().add(LabelEnregistrement);

		JToggleButton BoutonReveler = new JToggleButton("R\u00E9v\u00E9ler");
		BoutonReveler.setForeground(Color.GREEN);
		BoutonReveler.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {

				if (BoutonReveler.isSelected() == true) {
					BoutonReveler.setForeground(Color.RED);
					TextConfigUnixPassword.setEchoChar((char) 0);
					TextConfigWindowsPassword.setEchoChar((char) 0);
					TextConfigSysaPassword.setEchoChar((char) 0);
					TextConfigSysgPassword.setEchoChar((char) 0);
					TextConfigKmvsPassword.setEchoChar((char) 0);
					TextConfigZmvsPassword.setEchoChar((char) 0);
					TextConfigIp1Password.setEchoChar((char) 0);
					TextConfigIp2Password.setEchoChar((char) 0);
					TextConfigIp3Password.setEchoChar((char) 0);
					TextConfigBmvsPassword.setEchoChar((char) 0);
					TextConfigGmvsPassword.setEchoChar((char) 0);

				}
				else {
					BoutonReveler.setForeground(Color.GREEN);
					TextConfigUnixPassword.setEchoChar('\u2022');
					TextConfigWindowsPassword.setEchoChar('\u2022');
					TextConfigSysaPassword.setEchoChar('\u2022');
					TextConfigSysgPassword.setEchoChar('\u2022');
					TextConfigKmvsPassword.setEchoChar('\u2022');
					TextConfigZmvsPassword.setEchoChar('\u2022');
					TextConfigIp1Password.setEchoChar('\u2022');
					TextConfigIp2Password.setEchoChar('\u2022');
					TextConfigIp3Password.setEchoChar('\u2022');
					TextConfigBmvsPassword.setEchoChar('\u2022');
					TextConfigGmvsPassword.setEchoChar('\u2022');
				}

			}
		});
		BoutonReveler.setBounds(413, 527, 121, 23);
		getContentPane().add(BoutonReveler);

		// Fin

		// Début du chargement de la page de config

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

	public Boolean DemandeEtatAutoLoginBmvs() {
		return CheckBoxAutoBmvs.isSelected();
	}

	public Boolean DemandeEtatAutoLoginIp1() {
		return CheckBoxAutoIp1.isSelected();
	}

	public Boolean DemandeEtatAutoLoginIp2() {
		return CheckBoxAutoIp2.isSelected();
	}

	public Boolean DemandeEtatAutoLoginIp3() {
		return CheckBoxAutoIp3.isSelected();
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

			String UserWindows = TextConfigWindowsUser.getText().toLowerCase();
			TextConfigWindowsUser.setText(UserWindows);
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

			String UserBmvs = TextConfigBmvsUser.getText();
			@SuppressWarnings("deprecation")
			String PassBmvs = TextConfigBmvsPassword.getText();
			Boolean EtatAutoConnectBmvs = CheckBoxAutoBmvs.isSelected();

			String UserIp1 = TextConfigIp1User.getText();
			@SuppressWarnings("deprecation")
			String PassIp1 = TextConfigIp1Password.getText();
			Boolean EtatAutoConnectIp1 = CheckBoxAutoIp1.isSelected();

			String UserIp2 = TextConfigIp2User.getText();
			@SuppressWarnings("deprecation")
			String PassIp2 = TextConfigIp2Password.getText();
			Boolean EtatAutoConnectIp2 = CheckBoxAutoIp2.isSelected();

			String UserIp3 = TextConfigIp3User.getText();
			@SuppressWarnings("deprecation")
			String PassIp3 = TextConfigIp3Password.getText();
			Boolean EtatAutoConnectIp3 = CheckBoxAutoIp3.isSelected();

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
			ProgressBarValideConfig.setValue(5);
			LabelEnregistrement.setText("Enregistrement User Unix");
			MaConfig.EcrireUser("user", "Windows", UserWindows);
			ProgressBarValideConfig.setValue(10);
			LabelEnregistrement.setText("Enregistrement User Windows");
			MaConfig.EcrireUser("user", "Gmvs", UserGmvs);
			ProgressBarValideConfig.setValue(15);
			LabelEnregistrement.setText("Enregistrement User Gmvs");
			MaConfig.EcrireUser("user", "Sysa", UserSysa);
			ProgressBarValideConfig.setValue(20);
			LabelEnregistrement.setText("Enregistrement User Sysa");
			MaConfig.EcrireUser("user", "Kmvs", UserKmvs);
			ProgressBarValideConfig.setValue(25);
			LabelEnregistrement.setText("Enregistrement User Kmvs");
			MaConfig.EcrireUser("user", "Zmvs", UserZmvs);
			ProgressBarValideConfig.setValue(30);
			LabelEnregistrement.setText("Enregistrement User Zmvs");
			MaConfig.EcrireUser("user", "Sysg", UserSysg);
			LabelEnregistrement.setText("Enregistrement User Sysg");
			MaConfig.EcrireUser("user", "Bmvs", UserBmvs);
			LabelEnregistrement.setText("Enregistrement User Bmvs");
			MaConfig.EcrireUser("user", "Ip1", UserIp1);
			LabelEnregistrement.setText("Enregistrement User IP1");
			MaConfig.EcrireUser("user", "Ip2", UserIp2);
			LabelEnregistrement.setText("Enregistrement User IP2");
			MaConfig.EcrireUser("user", "Ip3", UserIp3);
			LabelEnregistrement.setText("Enregistrement User IP3");

			MaConfig.EcrirePassword("password", "Unix", PassUnix);
			ProgressBarValideConfig.setValue(35);
			LabelEnregistrement.setText("Enregistrement passwword Unix");
			MaConfig.EcrirePassword("password", "Windows", PassWindows);
			ProgressBarValideConfig.setValue(40);
			LabelEnregistrement.setText("Enregistrement passwword Windows");
			MaConfig.EcrirePassword("password", "Gmvs", PassGmvs);
			ProgressBarValideConfig.setValue(45);
			LabelEnregistrement.setText("Enregistrement passwword Gmvs");
			MaConfig.EcrirePassword("password", "Sysa", PassSysa);
			ProgressBarValideConfig.setValue(50);
			LabelEnregistrement.setText("Enregistrement passwword Sysa");
			MaConfig.EcrirePassword("password", "Kmvs", PassKmvs);
			ProgressBarValideConfig.setValue(55);
			LabelEnregistrement.setText("Enregistrement passwword Kmvs");
			MaConfig.EcrirePassword("password", "Zmvs", PassZmvs);
			ProgressBarValideConfig.setValue(60);
			LabelEnregistrement.setText("Enregistrement passwword Zmvs");
			MaConfig.EcrirePassword("password", "Sysg", PassSysg);
			ProgressBarValideConfig.setValue(65);
			LabelEnregistrement.setText("Enregistrement passwword Sysg");
			MaConfig.EcrirePassword("password", "Bmvs", PassBmvs);
			LabelEnregistrement.setText("Enregistrement passwword Bmvs");
			MaConfig.EcrirePassword("password", "Ip1", PassIp1);
			LabelEnregistrement.setText("Enregistrement passwword Ip1");
			MaConfig.EcrirePassword("password", "Ip2", PassIp2);
			LabelEnregistrement.setText("Enregistrement passwword Ip2");
			MaConfig.EcrirePassword("password", "Ip3", PassIp3);
			LabelEnregistrement.setText("Enregistrement passwword Ip3");

			MaConfig.EcrireUser("DeviceName", "Br", DeviceAs400Br);
			ProgressBarValideConfig.setValue(70);
			LabelEnregistrement.setText("Enregistrement macro BR");
			MaConfig.EcrireUser("DeviceName", "Bdi", DeviceAs400Bdi);
			ProgressBarValideConfig.setValue(75);
			LabelEnregistrement.setText("Enregistrement macro BDI");
			MaConfig.EcrireUser("DeviceName", "Bdaf", DeviceAs400Bdaf);
			ProgressBarValideConfig.setValue(80);
			LabelEnregistrement.setText("Enregistrement macro BDAF");
			MaConfig.EcrireUser("DeviceName", "Socly", DeviceAs400Socly);
			ProgressBarValideConfig.setValue(85);
			LabelEnregistrement.setText("Enregistrement macro SOCLY");
			MaConfig.EcrireUser("DeviceName", "Socmcsd", DeviceAs400Socmcsd);
			LabelEnregistrement.setText("Enregistrement macro SOCMCSD");
			MaConfig.EcrireUser("DeviceName", "Pfb", DeviceAs400Pfb);
			LabelEnregistrement.setText("Enregistrement macro PFB");

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

			if (EtatAutoConnectBmvs == true) {
				MaConfig.EcrireAutoConnect("autoconnect", "Bmvs", "true");
			}
			if (EtatAutoConnectBmvs == false) {
				MaConfig.EcrireAutoConnect("autoconnect", "Bmvs", "false");
			}

			if (EtatAutoConnectIp1 == true) {
				MaConfig.EcrireAutoConnect("autoconnect", "Ip1", "true");
			}
			if (EtatAutoConnectIp1 == false) {
				MaConfig.EcrireAutoConnect("autoconnect", "Ip1", "false");
			}

			if (EtatAutoConnectIp2 == true) {
				MaConfig.EcrireAutoConnect("autoconnect", "Ip2", "true");
			}
			if (EtatAutoConnectIp2 == false) {
				MaConfig.EcrireAutoConnect("autoconnect", "Ip2", "false");
			}

			if (EtatAutoConnectIp3 == true) {
				MaConfig.EcrireAutoConnect("autoconnect", "Ip3", "true");
			}
			if (EtatAutoConnectIp3 == false) {
				MaConfig.EcrireAutoConnect("autoconnect", "Ip3", "false");
			}

			// System.out.println(EcritureValideOuErreur);
			ProgressBarValideConfig.setValue(100);
			LabelConfigValide.setText("Config sauvegard\u00E9e!");
			LabelConfigValide.setForeground(new Color(60, 179, 113));
			ProgressBarValideConfig.setValue(90);
			GestionProfile GP = new GestionProfile();

			try {
				LabelEnregistrement.setText("Enregistrement macro GMVS");
				GP.ModifierPasswordProfile("Gmvs", MaConfig.DemandePassword("Gmvs"));
				GP.ModifierUserProfile("Gmvs", MaConfig.DemandeUser("Gmvs"));
				GP.ModifierUserNameStationProfile("GMVS");

				LabelEnregistrement.setText("Enregistrement macro SYSG");
				GP.ModifierPasswordProfile("Sysg", MaConfig.DemandePassword("Sysg"));
				GP.ModifierUserProfile("Sysg", MaConfig.DemandeUser("Sysg"));
				GP.ModifierUserNameStationProfile("Sysg");

				LabelEnregistrement.setText("Enregistrement macro ZMVS");
				GP.ModifierPasswordProfile("Zmvs", MaConfig.DemandePassword("Zmvs"));
				GP.ModifierUserProfile("Zmvs", MaConfig.DemandeUser("Zmvs"));
				GP.ModifierUserNameStationProfile("ZMVS");

				LabelEnregistrement.setText("Enregistrement macro KMVS");
				GP.ModifierPasswordProfile("Kmvs", MaConfig.DemandePassword("Kmvs"));
				GP.ModifierUserProfile("Kmvs", MaConfig.DemandeUser("Kmvs"));
				GP.ModifierUserNameStationProfile("KMVS");

				LabelEnregistrement.setText("Enregistrement macro SYSA");
				GP.ModifierPasswordProfile("Sysa", MaConfig.DemandePassword("Sysa"));
				GP.ModifierUserProfile("Sysa", MaConfig.DemandeUser("Sysa"));
				GP.ModifierUserNameStationProfile("Sysa");

				LabelEnregistrement.setText("Enregistrement macro BMVS");
				GP.ModifierPasswordProfile("Bmvs", MaConfig.DemandePassword("Bmvs"));
				GP.ModifierUserProfile("Bmvs", MaConfig.DemandeUser("Bmvs"));
				GP.ModifierUserNameStationProfile("BMVS");

				LabelEnregistrement.setText("Enregistrement macro IP1");
				GP.ModifierPasswordProfile("Ip1", MaConfig.DemandePassword("Ip1"));
				GP.ModifierUserProfile("Ip1", MaConfig.DemandeUser("Ip1"));
				GP.ModifierUserNameStationProfile("IP1");

				LabelEnregistrement.setText("Enregistrement macro IP2");
				GP.ModifierPasswordProfile("Ip2", MaConfig.DemandePassword("Ip2"));
				GP.ModifierUserProfile("Ip2", MaConfig.DemandeUser("Ip2"));
				GP.ModifierUserNameStationProfile("IP2");

				LabelEnregistrement.setText("Enregistrement macro IP3");
				GP.ModifierPasswordProfile("Ip3", MaConfig.DemandePassword("Ip3"));
				GP.ModifierUserProfile("Ip3", MaConfig.DemandeUser("Ip3"));
				GP.ModifierUserNameStationProfile("IP3");

				// AS400
				ProgressBarValideConfig.setValue(95);
				LabelEnregistrement.setText("Enregistrement Profile AS400");
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

				// GP.ModifierTempsRefresh("BDAFCLY", 6584521);

				ProgressBarValideConfig.setValue(100);
				LabelConfigValide.setText("Config sauvegard\u00E9e!");

			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			EnableDisableTouteZonesSaisies(true);
			BoutonValiderConfig.setEnabled(true);
			BoutonRechargerConfig.setEnabled(true);
			dispose();
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

			String UserBmvs = "#erreur";
			String PassBmvs = "#erreur";
			String ResultatDemandeAutoConnectBmvs = null;

			String UserIp1 = "#erreur";
			String PassIp1 = "#erreur";
			String ResultatDemandeAutoConnectIp1 = null;

			String UserIp2 = "#erreur";
			String PassIp2 = "#erreur";
			String ResultatDemandeAutoConnectIp2 = null;

			String UserIp3 = "#erreur";
			String PassIp3 = "#erreur";
			String ResultatDemandeAutoConnectIp3 = null;

			String DeviceBr = "#erreur";
			String DeviceBdi = "#erreur";
			String DeviceBdaf = "#erreur";
			String DeviceSocly = "#erreur";
			String DeviceSocmcsd = "#erreur";
			String DevicePfb = "#erreur";

			ProgressBarValideConfig.setValue(0);
			LabelConfigValide.setForeground(Color.GRAY);
			LabelConfigValide.setText("Config rechargée");
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

				UserBmvs = MaConfig.DemandeUser("Bmvs");
				PassBmvs = MaConfig.DemandePassword("Bmvs");
				TextConfigBmvsUser.setText(UserBmvs);
				TextConfigBmvsPassword.setText(PassBmvs);
				ResultatDemandeAutoConnectBmvs = MaConfig.DemandeAutoConnect("Bmvs");
				if (ResultatDemandeAutoConnectBmvs.equals("true")) {
					CheckBoxAutoBmvs.setSelected(true);
				}
				if (ResultatDemandeAutoConnectBmvs.equals("false")) {
					CheckBoxAutoBmvs.setSelected(false);
				}

				UserIp1 = MaConfig.DemandeUser("Ip1");
				PassIp1 = MaConfig.DemandePassword("Ip1");
				TextConfigIp1User.setText(UserIp1);
				TextConfigIp1Password.setText(PassIp1);
				ResultatDemandeAutoConnectIp1 = MaConfig.DemandeAutoConnect("Ip1");
				if (ResultatDemandeAutoConnectIp1.equals("true")) {
					CheckBoxAutoIp1.setSelected(true);
				}
				if (ResultatDemandeAutoConnectIp1.equals("false")) {
					CheckBoxAutoIp1.setSelected(false);
				}

				UserIp2 = MaConfig.DemandeUser("Ip2");
				PassIp2 = MaConfig.DemandePassword("Ip2");
				TextConfigIp2User.setText(UserIp2);
				TextConfigIp2Password.setText(PassIp2);
				ResultatDemandeAutoConnectIp2 = MaConfig.DemandeAutoConnect("Ip2");
				if (ResultatDemandeAutoConnectIp2.equals("true")) {
					CheckBoxAutoIp2.setSelected(true);
				}
				if (ResultatDemandeAutoConnectIp2.equals("false")) {
					CheckBoxAutoIp2.setSelected(false);
				}

				UserIp3 = MaConfig.DemandeUser("Ip3");
				PassIp3 = MaConfig.DemandePassword("Ip3");
				TextConfigIp3User.setText(UserIp3);
				TextConfigIp3Password.setText(PassIp3);
				ResultatDemandeAutoConnectIp3 = MaConfig.DemandeAutoConnect("Ip3");
				if (ResultatDemandeAutoConnectIp3.equals("true")) {
					CheckBoxAutoIp3.setSelected(true);
				}
				if (ResultatDemandeAutoConnectIp3.equals("false")) {
					CheckBoxAutoIp3.setSelected(false);
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
		CheckBoxAutoBmvs.setEnabled(ChoixEtat);
		CheckBoxAutoIp1.setEnabled(ChoixEtat);
		CheckBoxAutoIp2.setEnabled(ChoixEtat);
		CheckBoxAutoIp3.setEnabled(ChoixEtat);

		TextConfigUnixUser.setEnabled(ChoixEtat);
		TextConfigWindowsUser.setEnabled(ChoixEtat);
		TextConfigKmvsUser.setEnabled(ChoixEtat);
		TextConfigGmvsUser.setEnabled(ChoixEtat);
		TextConfigSysgUser.setEnabled(ChoixEtat);
		TextConfigSysaUser.setEnabled(ChoixEtat);
		TextConfigZmvsUser.setEnabled(ChoixEtat);
		TextConfigBmvsUser.setEnabled(ChoixEtat);
		TextConfigIp1User.setEnabled(ChoixEtat);
		TextConfigIp2User.setEnabled(ChoixEtat);
		TextConfigIp3User.setEnabled(ChoixEtat);

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
		TextConfigBmvsPassword.setEnabled(ChoixEtat);
		TextConfigIp1Password.setEnabled(ChoixEtat);
		TextConfigIp2Password.setEnabled(ChoixEtat);
		TextConfigIp3Password.setEnabled(ChoixEtat);

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
	private JPanel ZoneConfigBmvs;
	private JTextField TextConfigBmvsUser;
	private JLabel LabelConfigBmvsUser;
	private JLabel LabelConfigBmvsPassword;
	private JCheckBox CheckBoxAutoBmvs;
	private JPasswordField TextConfigBmvsPassword;
	private JPanel ZoneConfigIp1;
	private JTextField TextConfigIp1User;
	private JLabel LabelConfigIp1User;
	private JLabel LabelConfigIp1Password;
	private JCheckBox CheckBoxAutoIp1;
	private JPasswordField TextConfigIp1Password;
	private JPanel ZoneConfigIp2;
	private JTextField TextConfigIp2User;
	private JLabel LabelConfigIp2User;
	private JLabel LabelConfigIp2Password;
	private JCheckBox CheckBoxAutoIp2;
	private JPasswordField TextConfigIp2Password;
	private JPanel ZoneConfigIp3;
	private JTextField TextConfigIp3User;
	private JLabel LabelConfigIp3User;
	private JLabel LabelConfigIp3Password;
	private JCheckBox CheckBoxAutoIp3;
	private JPasswordField TextConfigIp3Password;
	private JLabel LabelEnregistrement;
}

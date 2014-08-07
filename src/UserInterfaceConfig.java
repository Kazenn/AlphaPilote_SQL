import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.SystemColor;
import java.io.IOException;


public class UserInterfaceConfig extends JFrame{
	public UserInterfaceConfig() {
		setTitle("Page de configuration des logins et mots de passe");
		getContentPane().setLayout(null);
		
		ZoneConfigUnix = new JPanel();
		ZoneConfigUnix.setBounds(0, 0, 145, 101);
		ZoneConfigUnix.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Unix", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigUnix);
		ZoneConfigUnix.setLayout(null);
		
		TextConfigUnixUser = new JTextField();
		TextConfigUnixUser.setBounds(54, 16, 86, 20);
		ZoneConfigUnix.add(TextConfigUnixUser);
		TextConfigUnixUser.setColumns(10);
		
		TextConfigUnixPassword = new JTextField();
		TextConfigUnixPassword.setBounds(54, 47, 86, 20);
		ZoneConfigUnix.add(TextConfigUnixPassword);
		TextConfigUnixPassword.setColumns(10);
		
		JLabel LabelConfigUnixUser = new JLabel("User");
		LabelConfigUnixUser.setBounds(6, 19, 38, 14);
		ZoneConfigUnix.add(LabelConfigUnixUser);
		
		JLabel LabelConfigUnixPassword = new JLabel("Pass");
		LabelConfigUnixPassword.setBounds(6, 50, 38, 14);
		ZoneConfigUnix.add(LabelConfigUnixPassword);
		
		JPanel ZoneConfigGmvs = new JPanel();
		ZoneConfigGmvs.setBounds(186, 233, 150, 105);
		ZoneConfigGmvs.setLayout(null);
		ZoneConfigGmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "TPX Gmvs", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigGmvs);
		
		TextConfigGmvsUser = new JTextField();
		TextConfigGmvsUser.setColumns(10);
		TextConfigGmvsUser.setBounds(47, 16, 86, 20);
		ZoneConfigGmvs.add(TextConfigGmvsUser);
		
		TextConfigGmvsPassword = new JTextField();
		TextConfigGmvsPassword.setColumns(10);
		TextConfigGmvsPassword.setBounds(47, 47, 86, 20);
		ZoneConfigGmvs.add(TextConfigGmvsPassword);
		
		JLabel LabelConfigGmvsUser = new JLabel("User");
		LabelConfigGmvsUser.setBounds(6, 19, 38, 14);
		ZoneConfigGmvs.add(LabelConfigGmvsUser);
		
		JLabel LabelConfigGmvsPassword = new JLabel("Pass");
		LabelConfigGmvsPassword.setBounds(6, 50, 38, 14);
		ZoneConfigGmvs.add(LabelConfigGmvsPassword);
		
		CheckBoxAutoGmvs = new JCheckBox("Auto connect");
		CheckBoxAutoGmvs.setSelected(true);
		CheckBoxAutoGmvs.setMargin(new Insets(0, 0, 0, 0));
		CheckBoxAutoGmvs.setBounds(6, 82, 97, 14);
		ZoneConfigGmvs.add(CheckBoxAutoGmvs);
		
					
		ZoneConfigSysa = new JPanel();
		ZoneConfigSysa.setBounds(186, 0, 150, 105);
		ZoneConfigSysa.setLayout(null);
		ZoneConfigSysa.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Sysa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigSysa);
		
		TextConfigSysaUser = new JTextField();
		TextConfigSysaUser.setColumns(10);
		TextConfigSysaUser.setBounds(54, 16, 86, 20);
		ZoneConfigSysa.add(TextConfigSysaUser);
		
		TextConfigSysaPassword = new JTextField();
		TextConfigSysaPassword.setColumns(10);
		TextConfigSysaPassword.setBounds(54, 47, 86, 20);
		ZoneConfigSysa.add(TextConfigSysaPassword);
		
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
		
		
		ZoneConfigZmvs = new JPanel();
		ZoneConfigZmvs.setBounds(186, 116, 150, 101);
		ZoneConfigZmvs.setLayout(null);
		ZoneConfigZmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Zmvs (CFF)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigZmvs);
		
		TextConfigZmvsUser = new JTextField();
		TextConfigZmvsUser.setColumns(10);
		TextConfigZmvsUser.setBounds(54, 16, 86, 20);
		ZoneConfigZmvs.add(TextConfigZmvsUser);
		
		TextConfigZmvsPassword = new JTextField();
		TextConfigZmvsPassword.setColumns(10);
		TextConfigZmvsPassword.setBounds(54, 47, 86, 20);
		ZoneConfigZmvs.add(TextConfigZmvsPassword);
		
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
		
		ZoneConfigKmvs = new JPanel();
		ZoneConfigKmvs.setBounds(346, 116, 150, 101);
		ZoneConfigKmvs.setLayout(null);
		ZoneConfigKmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Kmvs (IP0)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(ZoneConfigKmvs);
		
		TextConfigKmvsUser = new JTextField();
		TextConfigKmvsUser.setColumns(10);
		TextConfigKmvsUser.setBounds(54, 16, 86, 20);
		ZoneConfigKmvs.add(TextConfigKmvsUser);
		
		TextConfigKmvsPassword = new JTextField();
		TextConfigKmvsPassword.setColumns(10);
		TextConfigKmvsPassword.setBounds(54, 47, 86, 20);
		ZoneConfigKmvs.add(TextConfigKmvsPassword);
		
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
		
		JPanel ZoneConfigXenos = new JPanel();
		ZoneConfigXenos.setLayout(null);
		ZoneConfigXenos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Sysg (Xenos)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigXenos.setBounds(346, 0, 150, 105);
		getContentPane().add(ZoneConfigXenos);
		
		TextConfigSysgUser = new JTextField();
		TextConfigSysgUser.setColumns(10);
		TextConfigSysgUser.setBounds(47, 16, 86, 20);
		ZoneConfigXenos.add(TextConfigSysgUser);
		
		TextConfigSysgPassword = new JTextField();
		TextConfigSysgPassword.setColumns(10);
		TextConfigSysgPassword.setBounds(47, 47, 86, 20);
		ZoneConfigXenos.add(TextConfigSysgPassword);
		
		JLabel LabelConfigSysgUser = new JLabel("User");
		LabelConfigSysgUser.setBounds(6, 19, 38, 14);
		ZoneConfigXenos.add(LabelConfigSysgUser);
		
		JLabel LabelConfigSysgPassword = new JLabel("Pass");
		LabelConfigSysgPassword.setBounds(6, 50, 38, 14);
		ZoneConfigXenos.add(LabelConfigSysgPassword);
		
		CheckBoxAutoSysg = new JCheckBox("Auto connect");
		CheckBoxAutoSysg.setMargin(new Insets(0, 0, 0, 0));
		CheckBoxAutoSysg.setSelected(true);
		CheckBoxAutoSysg.setBounds(6, 82, 97, 14);
		ZoneConfigXenos.add(CheckBoxAutoSysg);
		
		JLabel LabelConfigValide = new JLabel("");
		LabelConfigValide.setBounds(10, 319, 145, 19);
		LabelConfigValide.setForeground(new Color(60, 179, 113));
		LabelConfigValide.setFont(new Font("Verdana", Font.PLAIN, 12));
		getContentPane().add(LabelConfigValide);
		
		LabelConfigValide.setForeground(Color.GRAY);
		
		
		
		JProgressBar ProgressBarValideConfig = new JProgressBar();
		ProgressBarValideConfig.setBounds(10, 350, 175, 19);
		ProgressBarValideConfig.setStringPainted(true);
		ProgressBarValideConfig.setForeground(new Color(34, 139, 34));
		getContentPane().add(ProgressBarValideConfig);
		
		ProgressBarValideConfig.setValue(0);
		
		JButton BoutonValiderConfig = new JButton("Valider la configuration");
		BoutonValiderConfig.setBounds(10, 380, 175, 51);
		BoutonValiderConfig.setMargin(new Insets(1, 1, 1, 1));
		getContentPane().add(BoutonValiderConfig);
		BoutonValiderConfig.setIcon(new ImageIcon(UserInterfaceConfig.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		BoutonValiderConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				int CodeRetour = 5;
				String EcritureValideOuErreur = "";
				String UserUnix = TextConfigUnixUser.getText();
				String PassUnix = TextConfigUnixPassword.getText();
				
				String UserGmvs = TextConfigGmvsUser.getText();
				String PassGmvs = TextConfigGmvsPassword.getText();
				Boolean EtatAutoConnectGmvs = CheckBoxAutoGmvs.isSelected();
				
				String UserSysa = TextConfigSysaUser.getText();
				String PassSysa = TextConfigSysaPassword.getText();
				Boolean EtatAutoConnectSysa = CheckBoxAutoSysa.isSelected();
				
				String UserKmvs = TextConfigKmvsUser.getText();
				String PassKmvs = TextConfigKmvsPassword.getText();
				Boolean EtatAutoConnectKmvs = CheckBoxAutoKmvs.isSelected();
				
				String UserZmvs = TextConfigZmvsUser.getText();
				String PassZmvs = TextConfigZmvsPassword.getText();
				Boolean EtatAutoConnectZmvs = CheckBoxAutoZmvs.isSelected();
				
				String UserSysg = TextConfigSysgUser.getText();
				String PassSysg = TextConfigSysgPassword.getText();
				Boolean EtatAutoConnectSysg = CheckBoxAutoSysg.isSelected();
				
				
				LabelConfigValide.setForeground(Color.GRAY);
				LabelConfigValide.setText("");
				GestionConfig MaConfig = new GestionConfig();
				
				EcritureValideOuErreur = MaConfig.EcrireUser("user", "Unix" , UserUnix);
				ProgressBarValideConfig.setValue(10);
				EcritureValideOuErreur = MaConfig.EcrireUser("user", "Gmvs" , UserGmvs);
				ProgressBarValideConfig.setValue(20);
				EcritureValideOuErreur = MaConfig.EcrireUser("user", "Sysa" , UserSysa);
				ProgressBarValideConfig.setValue(30);
				EcritureValideOuErreur = MaConfig.EcrireUser("user", "Kmvs" , UserKmvs);
				ProgressBarValideConfig.setValue(40);
				EcritureValideOuErreur = MaConfig.EcrireUser("user", "Zmvs" , UserZmvs);
				ProgressBarValideConfig.setValue(50);
				EcritureValideOuErreur = MaConfig.EcrireUser("user", "Sysg" , UserSysg);
				
				
				EcritureValideOuErreur = MaConfig.EcrirePassword("password", "Unix", PassUnix);
				ProgressBarValideConfig.setValue(60);
				EcritureValideOuErreur = MaConfig.EcrirePassword("password", "Gmvs", PassGmvs);
				ProgressBarValideConfig.setValue(70);
				EcritureValideOuErreur = MaConfig.EcrirePassword("password", "Sysa", PassSysa);
				ProgressBarValideConfig.setValue(80);
				EcritureValideOuErreur = MaConfig.EcrirePassword("password", "Kmvs", PassKmvs);
				ProgressBarValideConfig.setValue(90);
				EcritureValideOuErreur = MaConfig.EcrirePassword("password", "Zmvs", PassZmvs);
				ProgressBarValideConfig.setValue(95);
				EcritureValideOuErreur = MaConfig.EcrirePassword("password", "Sysg", PassSysg);
				ProgressBarValideConfig.setValue(100);
				
				
				if (EtatAutoConnectGmvs == true)
				MaConfig.EcrireAutoConnect("autoconnect", "Gmvs", "true");
				if (EtatAutoConnectGmvs == false)
				MaConfig.EcrireAutoConnect("autoconnect", "Gmvs", "false");
				
				if (EtatAutoConnectSysa == true)
				MaConfig.EcrireAutoConnect("autoconnect", "Sysa", "true");
				if (EtatAutoConnectSysa == false)
				MaConfig.EcrireAutoConnect("autoconnect", "Sysa", "false");
					
				if (EtatAutoConnectSysg == true)
				MaConfig.EcrireAutoConnect("autoconnect", "Sysg", "true");
				if (EtatAutoConnectSysg == false)
				MaConfig.EcrireAutoConnect("autoconnect", "Sysg", "false");
						
				if (EtatAutoConnectKmvs == true)
				MaConfig.EcrireAutoConnect("autoconnect", "Kmvs", "true");
				if (EtatAutoConnectKmvs == false)
				MaConfig.EcrireAutoConnect("autoconnect", "Kmvs", "false");
							
				if (EtatAutoConnectZmvs == true)
				MaConfig.EcrireAutoConnect("autoconnect", "Zmvs", "true");
				if (EtatAutoConnectZmvs == false)
				MaConfig.EcrireAutoConnect("autoconnect", "Zmvs", "false");
				
				
				System.out.println(EcritureValideOuErreur);
				LabelConfigValide.setText("Config sauvegard\u00E9e!");
				LabelConfigValide.setForeground(new Color(60, 179, 113));
				
				
				
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
					
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				
			}
		});
		
		BoutonRechargerConfig = new JButton("Recharger la configuration");
		BoutonRechargerConfig.setBounds(201, 380, 153, 51);
		BoutonRechargerConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				int CodeRetour = 5;
				String UserGmvs = "#erreur";
				String PassGmvs = "#erreur";
				String ResultatDemandeAutoConnectGmvs = null ;
				
				String UserUnix = "#erreur";
				String PassUnix = "#erreur";
				
				
				
				String UserSysa = "#erreur";
				String PassSysa = "#erreur";
				String ResultatDemandeAutoConnectSysa = null ;
				
				String UserKmvs = "#erreur";
				String PassKmvs = "#erreur";
				String ResultatDemandeAutoConnectKmvs = null ;
				
				String UserZmvs = "#erreur";
				String PassZmvs = "#erreur";
				String ResultatDemandeAutoConnectZmvs = null ;
				
				String UserSysg = "#erreur";
				String PassSysg = "#erreur";
				String ResultatDemandeAutoConnectSysg = null ;
				
				ProgressBarValideConfig.setValue(0);
				LabelConfigValide.setForeground(Color.GRAY);
				LabelConfigValide.setText("Config rechargée");
				GestionConfig MaConfig = new GestionConfig();
				CodeRetour = MaConfig.LireConfig();
				//UserG = MaConfig.DemandeUser("G");
				//UserUnix = MaConfig.DemandeUser("Unix");
				if (CodeRetour == 0)
				{
					UserUnix = MaConfig.DemandeUser("Unix");
					PassUnix = MaConfig.DemandePassword("Unix");
					TextConfigUnixUser.setText(UserUnix);
					TextConfigUnixPassword.setText(PassUnix);
					
					UserGmvs = MaConfig.DemandeUser("Gmvs");
					PassGmvs = MaConfig.DemandePassword("Gmvs");
					TextConfigGmvsUser.setText(UserGmvs);
					TextConfigGmvsPassword.setText(PassGmvs);
					ResultatDemandeAutoConnectGmvs = MaConfig.DemandeAutoConnect("Gmvs");
					if (ResultatDemandeAutoConnectGmvs.equals("true"))
						CheckBoxAutoGmvs.setSelected(true);
					if (ResultatDemandeAutoConnectGmvs.equals("false"))
						CheckBoxAutoGmvs.setSelected(false);
						
					
					
					UserSysa = MaConfig.DemandeUser("Sysa");
					PassSysa = MaConfig.DemandePassword("Sysa");
					TextConfigSysaUser.setText(UserSysa);
					TextConfigSysaPassword.setText(PassSysa);
					ResultatDemandeAutoConnectSysa = MaConfig.DemandeAutoConnect("Sysa");
					if (ResultatDemandeAutoConnectSysa.equals("true"))
						CheckBoxAutoSysa.setSelected(true);
					if (ResultatDemandeAutoConnectSysa.equals("false"))
						CheckBoxAutoSysa.setSelected(false);;
					
					
					UserKmvs = MaConfig.DemandeUser("Kmvs");
					PassKmvs = MaConfig.DemandePassword("Kmvs");
					TextConfigKmvsUser.setText(UserKmvs);
					TextConfigKmvsPassword.setText(PassKmvs);
					ResultatDemandeAutoConnectKmvs = MaConfig.DemandeAutoConnect("Kmvs");
					if (ResultatDemandeAutoConnectKmvs.equals("true"))
						CheckBoxAutoKmvs.setSelected(true);
					if (ResultatDemandeAutoConnectKmvs.equals("false"))
						CheckBoxAutoKmvs.setSelected(false);
					
					
					UserZmvs = MaConfig.DemandeUser("Zmvs");
					PassZmvs = MaConfig.DemandePassword("Zmvs");
					TextConfigZmvsUser.setText(UserZmvs);
					TextConfigZmvsPassword.setText(PassZmvs);
					ResultatDemandeAutoConnectZmvs = MaConfig.DemandeAutoConnect("Zmvs");
					if (ResultatDemandeAutoConnectZmvs.equals("true"))
						CheckBoxAutoZmvs.setSelected(true);
					if (ResultatDemandeAutoConnectZmvs.equals("false"))
						CheckBoxAutoZmvs.setSelected(false);
					
					
					UserSysg = MaConfig.DemandeUser("Sysg");
					PassSysg = MaConfig.DemandePassword("Sysg");
					TextConfigSysgUser.setText(UserSysg);
					TextConfigSysgPassword.setText(PassSysg);
					ResultatDemandeAutoConnectSysg = MaConfig.DemandeAutoConnect("Sysg");
					if (ResultatDemandeAutoConnectSysg.equals("true"))
						CheckBoxAutoSysg.setSelected(true);
					if (ResultatDemandeAutoConnectSysg.equals("false"))
						CheckBoxAutoSysg.setSelected(false);
					
					
				}
				if (CodeRetour == 1)
				{
					
					
				}
				
			}
		});
		BoutonRechargerConfig.setIcon(new ImageIcon(UserInterfaceConfig.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		BoutonRechargerConfig.setMargin(new Insets(1, 1, 1, 1));
		getContentPane().add(BoutonRechargerConfig);
		
		
		//Fin Déclarations des objets et composants
		
		
		
		//Début du chargement de la page de config
		
		int CodeRetour = 5;
		String UserGmvs = "#erreur";
		String PassGmvs = "#erreur";
		String ResultatDemandeAutoConnectGmvs = null ;
		
		String UserUnix = "#erreur";
		String PassUnix = "#erreur";
		
		
		
		String UserSysa = "#erreur";
		String PassSysa = "#erreur";
		String ResultatDemandeAutoConnectSysa = null ;
		
		String UserKmvs = "#erreur";
		String PassKmvs = "#erreur";
		String ResultatDemandeAutoConnectKmvs = null ;
		
		String UserZmvs = "#erreur";
		String PassZmvs = "#erreur";
		String ResultatDemandeAutoConnectZmvs = null ;
		
		String UserSysg = "#erreur";
		String PassSysg = "#erreur";
		String ResultatDemandeAutoConnectSysg = null ;
		
		GestionConfig MaConfig = new GestionConfig();
		CodeRetour = MaConfig.LireConfig();
		//UserG = MaConfig.DemandeUser("G");
		//UserUnix = MaConfig.DemandeUser("Unix");
		if (CodeRetour == 0)
		{
			UserUnix = MaConfig.DemandeUser("Unix");
			PassUnix = MaConfig.DemandePassword("Unix");
			TextConfigUnixUser.setText(UserUnix);
			TextConfigUnixPassword.setText(PassUnix);
			
			UserGmvs = MaConfig.DemandeUser("Gmvs");
			PassGmvs = MaConfig.DemandePassword("Gmvs");
			TextConfigGmvsUser.setText(UserGmvs);
			TextConfigGmvsPassword.setText(PassGmvs);
			ResultatDemandeAutoConnectGmvs = MaConfig.DemandeAutoConnect("Gmvs");
			if (ResultatDemandeAutoConnectGmvs.equals("true"))
				CheckBoxAutoGmvs.setSelected(true);
			if (ResultatDemandeAutoConnectGmvs.equals("false"))
				CheckBoxAutoGmvs.setSelected(false);
				
			
			
			UserSysa = MaConfig.DemandeUser("Sysa");
			PassSysa = MaConfig.DemandePassword("Sysa");
			TextConfigSysaUser.setText(UserSysa);
			TextConfigSysaPassword.setText(PassSysa);
			ResultatDemandeAutoConnectSysa = MaConfig.DemandeAutoConnect("Sysa");
			if (ResultatDemandeAutoConnectSysa.equals("true"))
				CheckBoxAutoSysa.setSelected(true);
			if (ResultatDemandeAutoConnectSysa.equals("false"))
				CheckBoxAutoSysa.setSelected(false);;
			
			
			UserKmvs = MaConfig.DemandeUser("Kmvs");
			PassKmvs = MaConfig.DemandePassword("Kmvs");
			TextConfigKmvsUser.setText(UserKmvs);
			TextConfigKmvsPassword.setText(PassKmvs);
			ResultatDemandeAutoConnectKmvs = MaConfig.DemandeAutoConnect("Kmvs");
			if (ResultatDemandeAutoConnectKmvs.equals("true"))
				CheckBoxAutoKmvs.setSelected(true);
			if (ResultatDemandeAutoConnectKmvs.equals("false"))
				CheckBoxAutoKmvs.setSelected(false);
			
			
			UserZmvs = MaConfig.DemandeUser("Zmvs");
			PassZmvs = MaConfig.DemandePassword("Zmvs");
			TextConfigZmvsUser.setText(UserZmvs);
			TextConfigZmvsPassword.setText(PassZmvs);
			ResultatDemandeAutoConnectZmvs = MaConfig.DemandeAutoConnect("Zmvs");
			if (ResultatDemandeAutoConnectZmvs.equals("true"))
				CheckBoxAutoZmvs.setSelected(true);
			if (ResultatDemandeAutoConnectZmvs.equals("false"))
				CheckBoxAutoZmvs.setSelected(false);
			
			
			
			UserSysg = MaConfig.DemandeUser("Sysg");
			PassSysg = MaConfig.DemandePassword("Sysg");
			TextConfigSysgUser.setText(UserSysg);
			TextConfigSysgPassword.setText(PassSysg);
			ResultatDemandeAutoConnectSysg = MaConfig.DemandeAutoConnect("Sysg");
			if (ResultatDemandeAutoConnectSysg.equals("true"))
				CheckBoxAutoSysg.setSelected(true);
			if (ResultatDemandeAutoConnectSysg.equals("false"))
				CheckBoxAutoSysg.setSelected(false);
			
			
		}
		if (CodeRetour == 1)
		{
			
			
		}
		
	}
	
	
	public Boolean DemandeEtatAutoLoginGmvs() 
	{
		return CheckBoxAutoGmvs.isSelected();
	}
	public Boolean DemandeEtatAutoLoginZmvs() 
	{
		return CheckBoxAutoZmvs.isSelected();
	}
	public Boolean DemandeEtatAutoLoginKmvs() 
	{
		return CheckBoxAutoKmvs.isSelected();
	}
	public Boolean DemandeEtatAutoLoginSysa() 
	{
		return CheckBoxAutoSysa.isSelected();
	}
	public Boolean DemandeEtatAutoLoginSysg() 
	{
		return CheckBoxAutoSysg.isSelected();
	}


	private static final long serialVersionUID = 1L;
	private JCheckBox CheckBoxAutoGmvs;
	private JCheckBox CheckBoxAutoZmvs;
	private JCheckBox CheckBoxAutoKmvs;
	private JCheckBox CheckBoxAutoSysa;
	private JCheckBox CheckBoxAutoSysg;
	private JTextField TextConfigUnixUser;
	private JTextField TextConfigUnixPassword;
	private JPanel ZoneConfigUnix;
	private JTextField TextConfigGmvsUser;
	private JTextField TextConfigGmvsPassword;
	private JPanel ZoneConfigSysa;
	private JTextField TextConfigSysaUser;
	private JTextField TextConfigSysaPassword;
	private JLabel LabelConfigSysaUser;
	private JLabel LabelConfigSysaPassword;
	private JPanel ZoneConfigKmvs;
	private JTextField TextConfigKmvsUser;
	private JTextField TextConfigKmvsPassword;
	private JLabel LabelConfigKmvsUser;
	private JLabel LabelConfigKmvsPassword;
	private JPanel ZoneConfigZmvs;
	private JTextField TextConfigZmvsUser;
	private JTextField TextConfigZmvsPassword;
	private JLabel LabelConfigZmvsUser;
	private JLabel LabelConfigZmvsPassword;
	
	
	private JButton BoutonRechargerConfig;
	private JTextField TextConfigSysgUser;
	private JTextField TextConfigSysgPassword;
	
}



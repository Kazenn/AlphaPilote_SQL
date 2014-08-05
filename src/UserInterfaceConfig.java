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


public class UserInterfaceConfig extends JFrame{
	public UserInterfaceConfig() {
		setTitle("Page de configuration des logins et mots de passe");
		getContentPane().setLayout(null);
		
		ZoneConfigUnix = new JPanel();
		ZoneConfigUnix.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Unix", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigUnix.setBounds(6, 0, 150, 106);
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
		ZoneConfigGmvs.setLayout(null);
		ZoneConfigGmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "TPX Gmvs", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigGmvs.setBounds(166, 0, 150, 106);
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
		CheckBoxAutoGmvs.setBackground(new Color(169, 169, 169));
		CheckBoxAutoGmvs.setSelected(true);
		CheckBoxAutoGmvs.setBounds(16, 74, 97, 25);
		ZoneConfigGmvs.add(CheckBoxAutoGmvs);
		
					
		ZoneConfigSysa = new JPanel();
		ZoneConfigSysa.setLayout(null);
		ZoneConfigSysa.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Sysa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigSysa.setBounds(326, 0, 150, 106);
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
		
		ZoneConfigKmvs = new JPanel();
		ZoneConfigKmvs.setLayout(null);
		ZoneConfigKmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Kmvs (IP0)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigKmvs.setBounds(326, 117, 150, 106);
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
		
		
		ZoneConfigZmvs = new JPanel();
		ZoneConfigZmvs.setLayout(null);
		ZoneConfigZmvs.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Zmvs (CFF)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneConfigZmvs.setBounds(166, 117, 150, 106);
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
				
		JButton BoutonValiderConfig = new JButton("Valider la configuration");
		BoutonValiderConfig.setMargin(new Insets(1, 1, 1, 1));
		BoutonValiderConfig.setBounds(6, 380, 180, 51);
		getContentPane().add(BoutonValiderConfig);
		BoutonValiderConfig.setIcon(new ImageIcon(UserInterfaceConfig.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		
		
		
		JProgressBar ProgressBarValideConfig = new JProgressBar();
		ProgressBarValideConfig.setStringPainted(true);
		ProgressBarValideConfig.setForeground(new Color(34, 139, 34));
		ProgressBarValideConfig.setBounds(6, 345, 180, 24);
		getContentPane().add(ProgressBarValideConfig);
		
		ProgressBarValideConfig.setValue(0);
		
		JLabel LabelConfigValide = new JLabel("");
		LabelConfigValide.setForeground(new Color(60, 179, 113));
		LabelConfigValide.setFont(new Font("Verdana", Font.PLAIN, 12));
		LabelConfigValide.setBounds(6, 320, 150, 14);
		getContentPane().add(LabelConfigValide);
		BoutonValiderConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				int CodeRetour = 5;
				String EcritureValideOuErreur = "";
				String UserUnix = TextConfigUnixUser.getText();
				String PassUnix = TextConfigUnixPassword.getText();
				String UserGmvs = TextConfigGmvsUser.getText();
				String PassGmvs = TextConfigGmvsPassword.getText();
				String UserSysa = TextConfigSysaUser.getText();
				String PassSysa = TextConfigSysaPassword.getText();
				String UserKmvs = TextConfigKmvsUser.getText();
				String PassKmvs = TextConfigKmvsPassword.getText();
				String UserZmvs = TextConfigZmvsUser.getText();
				String PassZmvs = TextConfigZmvsPassword.getText();
				
				
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
				
				EcritureValideOuErreur = MaConfig.EcrirePassword("password", "Unix", PassUnix);
				ProgressBarValideConfig.setValue(60);
				EcritureValideOuErreur = MaConfig.EcrirePassword("password", "Gmvs", PassGmvs);
				ProgressBarValideConfig.setValue(70);
				EcritureValideOuErreur = MaConfig.EcrirePassword("password", "Sysa", PassSysa);
				ProgressBarValideConfig.setValue(80);
				
				EcritureValideOuErreur = MaConfig.EcrirePassword("password", "Kmvs", PassKmvs);
				ProgressBarValideConfig.setValue(90);
				EcritureValideOuErreur = MaConfig.EcrirePassword("password", "Zmvs", PassZmvs);
				ProgressBarValideConfig.setValue(100);
				
				System.out.println(EcritureValideOuErreur);
				LabelConfigValide.setText("Config sauvegard\u00E9e!");
				LabelConfigValide.setForeground(new Color(60, 179, 113));
				
				
			}
		});
		
		
		//Fin Déclarations des objets et composants
		
		
		
		//Début du chargement de la page de config
		
		int CodeRetour = 5;
		String UserGmvs = "#erreur";
		String PassGmvs = "#erreur";
		String UserUnix = "#erreur";
		String PassUnix = "#erreur";
		String UserSysa = "#erreur";
		String PassSysa = "#erreur";
		String UserKmvs = "#erreur";
		String PassKmvs = "#erreur";
		String UserZmvs = "#erreur";
		String PassZmvs = "#erreur";
		
		LabelConfigValide.setForeground(Color.GRAY);
		
		BoutonRechargerConfig = new JButton("Recharger la configuration");
		BoutonRechargerConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				int CodeRetour = 5;
				String UserGmvs = "#erreur";
				String PassGmvs = "#erreur";
				String UserUnix = "#erreur";
				String PassUnix = "#erreur";
				String UserSysa = "#erreur";
				String PassSysa = "#erreur";
				String UserKmvs = "#erreur";
				String PassKmvs = "#erreur";
				String UserZmvs = "#erreur";
				String PassZmvs = "#erreur";
				
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
					
					UserSysa = MaConfig.DemandeUser("Sysa");
					PassSysa = MaConfig.DemandePassword("Sysa");
					TextConfigSysaUser.setText(UserSysa);
					TextConfigSysaPassword.setText(PassSysa);
					
					UserKmvs = MaConfig.DemandeUser("Kmvs");
					PassKmvs = MaConfig.DemandePassword("Kmvs");
					TextConfigKmvsUser.setText(UserKmvs);
					TextConfigKmvsPassword.setText(PassKmvs);
					
					UserZmvs = MaConfig.DemandeUser("Zmvs");
					PassZmvs = MaConfig.DemandePassword("Zmvs");
					TextConfigZmvsUser.setText(UserZmvs);
					TextConfigZmvsPassword.setText(PassZmvs);
					
				}
				if (CodeRetour == 1)
				{
					
					
				}
				
			}
		});
		BoutonRechargerConfig.setIcon(new ImageIcon(UserInterfaceConfig.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		BoutonRechargerConfig.setMargin(new Insets(1, 1, 1, 1));
		BoutonRechargerConfig.setBounds(196, 380, 180, 51);
		getContentPane().add(BoutonRechargerConfig);
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
			
			UserSysa = MaConfig.DemandeUser("Sysa");
			PassSysa = MaConfig.DemandePassword("Sysa");
			TextConfigSysaUser.setText(UserSysa);
			TextConfigSysaPassword.setText(PassSysa);
			
			UserKmvs = MaConfig.DemandeUser("Kmvs");
			PassKmvs = MaConfig.DemandePassword("Kmvs");
			TextConfigKmvsUser.setText(UserKmvs);
			TextConfigKmvsPassword.setText(PassKmvs);
			
			UserZmvs = MaConfig.DemandeUser("Zmvs");
			PassZmvs = MaConfig.DemandePassword("Zmvs");
			TextConfigZmvsUser.setText(UserZmvs);
			TextConfigZmvsPassword.setText(PassZmvs);
			
		}
		if (CodeRetour == 1)
		{
			
			
		}
		
	}
	
	
	public Boolean DemandeEtatAutoLoginGmvs() 
	{
		return CheckBoxAutoGmvs.isSelected();
	}


	private static final long serialVersionUID = 1L;
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
	private JCheckBox CheckBoxAutoGmvs;
	private JButton BoutonRechargerConfig;
}



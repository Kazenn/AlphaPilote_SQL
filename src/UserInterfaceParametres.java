import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class UserInterfaceParametres extends JFrame {
	// new UserInterface();
	private String NavigateurDansCombox;
	private JComboBox ComboxNavigateur;

	public UserInterfaceParametres() {

		setTitle("Paramètres généraux");
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel ZoneNavigateur = new JPanel();
		ZoneNavigateur.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Navigateur", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ZoneNavigateur.setBounds(4, 10, 180, 50);
		getContentPane().add(ZoneNavigateur);
		ZoneNavigateur.setLayout(null);

		ComboxNavigateur = new JComboBox();
		ComboxNavigateur.setBounds(10, 21, 139, 20);
		ZoneNavigateur.add(ComboxNavigateur);
		ComboxNavigateur.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {

				NavigateurDansCombox = (String) ComboxNavigateur.getSelectedItem();
				SetNavigateurFichierConfig();
			}
		});
		ComboxNavigateur.setModel(new DefaultComboBoxModel(new String[] { "Google Chrome", "Mozilla Firefox", "Internet Explorer" }));

		JButton BoutonValiderParametres = new JButton("Valider et quitter");
		final ImageIcon IconValider = new ImageIcon(getClass().getResource("/Ok-icon.png"));
		BoutonValiderParametres.setIcon(IconValider);
		BoutonValiderParametres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				dispose();
			}
		});
		BoutonValiderParametres.setBounds(10, 402, 161, 39);
		getContentPane().add(BoutonValiderParametres);

		// --------------------------------------------------
		// -----------LANCER AU CHARGEMENT PAGE
		// --------------------------------------------------

		new Thread(new ThreadChargementParametres()).start();

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
			String Navigateur = "";
			GestionConfig FichierGestion = new GestionConfig();
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
}
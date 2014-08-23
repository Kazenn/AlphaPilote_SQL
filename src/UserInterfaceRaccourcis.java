import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class UserInterfaceRaccourcis extends JFrame {
	public UserInterfaceRaccourcis() {
		setTitle("Configuration des raccourcis");
		setType(Type.UTILITY);
		getContentPane().setLayout(null);
		final ImageIcon IconWindows = new ImageIcon(getClass().getResource("/Windows-icon.png"));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Outil de capture", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBounds(6, 11, 228, 59);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel LabelIconeWindows = new JLabel("");
		LabelIconeWindows.setBounds(10, 27, 34, 20);
		panel.add(LabelIconeWindows);
		LabelIconeWindows.setIcon(IconWindows);

		JLabel label = new JLabel("+");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(54, 27, 18, 20);
		panel.add(label);

		ComboBoxCapture = new JComboBox();
		ComboBoxCapture.setBounds(86, 27, 50, 20);
		panel.add(ComboBoxCapture);
		ComboBoxCapture.setModel(new DefaultComboBoxModel(new String[] { "-", "W", "X", "C", "V", "H", "Q", "S", "G" }));
		ComboBoxCapture.setMaximumRowCount(8);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Connexion sur s\u00E9lection souris", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_1.setBounds(6, 81, 228, 59);
		getContentPane().add(panel_1);

		JLabel LabelIconeWindows2 = new JLabel("");
		LabelIconeWindows2.setIcon(IconWindows);
		LabelIconeWindows2.setBounds(10, 27, 34, 20);
		panel_1.add(LabelIconeWindows2);

		JLabel label_2 = new JLabel("+");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(54, 27, 18, 20);
		panel_1.add(label_2);

		ComboBoxConnexion = new JComboBox();
		ComboBoxConnexion.setModel(new DefaultComboBoxModel(new String[] { "-", "W", "X", "C", "V", "H", "Q", "S", "G" }));
		ComboBoxConnexion.setMaximumRowCount(8);
		ComboBoxConnexion.setBounds(86, 27, 50, 20);
		panel_1.add(ComboBoxConnexion);

		JButton BoutonValiderRaccourcis = new JButton("Valider");
		final ImageIcon IconValider = new ImageIcon(getClass().getResource("/Ok-icon.png"));
		BoutonValiderRaccourcis.setIcon(IconValider);
		BoutonValiderRaccourcis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String Raccourci = "";
				GestionRaccourcis MesRaccourcis = new GestionRaccourcis();

				Raccourci = (String) ComboBoxCapture.getSelectedItem();
				MesRaccourcis.EcrireRaccourcis("Capture", Raccourci);

				Raccourci = (String) ComboBoxConnexion.getSelectedItem();
				MesRaccourcis.EcrireRaccourcis("Connexion", Raccourci);

				Raccourci = (String) ComboBoxConsignes.getSelectedItem();
				MesRaccourcis.EcrireRaccourcis("Consignes", Raccourci);

				dispose();

			}
		});
		BoutonValiderRaccourcis.setBounds(6, 419, 105, 35);
		getContentPane().add(BoutonValiderRaccourcis);

		JButton BoutonAnnuler = new JButton("Annuler");
		final ImageIcon IconAnnuler = new ImageIcon(getClass().getResource("/cancel-icon.png"));
		BoutonAnnuler.setIcon(IconAnnuler);
		BoutonAnnuler.setBounds(138, 419, 118, 35);
		getContentPane().add(BoutonAnnuler);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dossier des consignes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_2.setBounds(6, 150, 228, 59);
		getContentPane().add(panel_2);

		JLabel LabelIconeWindows3 = new JLabel("");
		LabelIconeWindows3.setBounds(10, 27, 34, 20);
		LabelIconeWindows3.setIcon(IconWindows);
		panel_2.add(LabelIconeWindows3);

		JLabel label_3 = new JLabel("+");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(54, 27, 18, 20);
		panel_2.add(label_3);

		ComboBoxConsignes = new JComboBox();
		ComboBoxConsignes.setModel(new DefaultComboBoxModel(new String[] { "-", "W", "X", "C", "V", "H", "Q", "S", "G" }));
		ComboBoxConsignes.setMaximumRowCount(8);
		ComboBoxConsignes.setBounds(86, 27, 50, 20);
		panel_2.add(ComboBoxConsignes);

		ThreadChargementRaccourcis ChargementRaccourci = new ThreadChargementRaccourcis();
		ChargementRaccourci.run();
	}

	public void SetComboBox(JComboBox<?> LaBox, Object Raccourci) {

		switch ((String) Raccourci) {
			case "-":
				LaBox.setSelectedIndex(0);
				break;
			case "W":
				LaBox.setSelectedIndex(1);
				break;
			case "X":
				LaBox.setSelectedIndex(2);
				break;
			case "C":
				LaBox.setSelectedIndex(3);
				break;
			case "V":
				LaBox.setSelectedIndex(4);
				break;
			case "H":
				LaBox.setSelectedIndex(5);
				break;
			case "Q":
				LaBox.setSelectedIndex(6);
				break;
			case "S":
				LaBox.setSelectedIndex(7);
				break;
			case "D":
				LaBox.setSelectedIndex(8);
				break;

		}

	}

	public class ThreadChargementRaccourcis implements Runnable {

		@Override
		public void run() {

			GestionRaccourcis GR = new GestionRaccourcis();
			String RaccourciCapture;
			String RaccourciConnexion;
			String RaccourciConsignes;
			RaccourciCapture = GR.DemandeRaccourci("Capture");
			RaccourciConnexion = GR.DemandeRaccourci("Connexion");
			RaccourciConsignes = GR.DemandeRaccourci("Consignes");

			SetComboBox(ComboBoxCapture, RaccourciCapture);
			SetComboBox(ComboBoxConnexion, RaccourciConnexion);
			SetComboBox(ComboBoxConsignes, RaccourciConsignes);

		}
	}

	private static final long serialVersionUID = 1L;
	private JComboBox ComboBoxConnexion;
	private JComboBox ComboBoxCapture;
	private JComboBox ComboBoxConsignes;
}

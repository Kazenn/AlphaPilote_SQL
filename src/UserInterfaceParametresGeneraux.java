import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class UserInterfaceParametresGeneraux extends JFrame {
	private static final long serialVersionUID = 1L;
	private JCheckBox CheckBoxRestaurePosition;
	private JCheckBox BoxLancementAutomatiquePoste;
	private JTextField TextTemps;
	private JComboBox ComboBoxSession;
	GestionSql LaBase = new GestionSql();

	public UserInterfaceParametresGeneraux() {

		setTitle("Options g\u00E9n\u00E9rales");
		setType(Type.UTILITY);
		getContentPane().setLayout(null);
		setAlwaysOnTop(true);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Position d'AlphaPilote", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 180, 50);
		getContentPane().add(panel);

		CheckBoxRestaurePosition = new JCheckBox("Restaurer au d\u00E9marrage");
		CheckBoxRestaurePosition.setBounds(6, 20, 168, 23);
		panel.add(CheckBoxRestaurePosition);

		JButton BoutonValider = new JButton("Valider");
		BoutonValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new Thread(new ThreadValideParametres()).start();
			}
		});
		BoutonValider.setBounds(10, 400, 109, 41);
		getContentPane().add(BoutonValider);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lancement automatique du poste", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 72, 266, 156);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		BoxLancementAutomatiquePoste = new JCheckBox("Lance auto");
		BoxLancementAutomatiquePoste.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent Event) {
				if (Event.getStateChange() == Event.SELECTED) {
					TextTemps.setEnabled(true);
				}
				if (Event.getStateChange() == Event.DESELECTED) {
					TextTemps.setEnabled(false);
				}
			}
		});
		BoxLancementAutomatiquePoste.setBounds(6, 16, 180, 23);
		panel_1.add(BoxLancementAutomatiquePoste);

		TextTemps = new JTextField();
		TextTemps.setText("10");
		TextTemps.setBounds(6, 49, 29, 20);
		panel_1.add(TextTemps);
		TextTemps.setColumns(10);

		JLabel lblTempsEnSecondes = new JLabel("temps en secondes");
		lblTempsEnSecondes.setBounds(45, 52, 124, 14);
		panel_1.add(lblTempsEnSecondes);

		JLabel lblPermetDeLancer = new JLabel("Permet de lancer son poste ");
		lblPermetDeLancer.setBounds(6, 80, 180, 14);
		panel_1.add(lblPermetDeLancer);

		JLabel lblNewLabel = new JLabel("au bout de X secondes apr\u00E8s ");
		lblNewLabel.setBounds(6, 93, 180, 14);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("le d\u00E9marrage d'AlphaPilote");
		lblNewLabel_1.setBounds(6, 105, 180, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblsInstan = new JLabel("0s = instantan\u00E9 , 10s = temps recommand\u00E9");
		lblsInstan.setBounds(6, 130, 288, 14);
		panel_1.add(lblsInstan);
		lblsInstan.setFont(new Font("Tahoma", Font.BOLD, 11));

		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(161, 400, 109, 41);
		getContentPane().add(btnNewButton);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Profile par d\u00E9faut", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(200, 11, 163, 50);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		ComboBoxSession = new JComboBox();
		ComboBoxSession.setModel(new DefaultComboBoxModel(new String[] { "-", "IT-CE Bercy", "Bourg-la-reine", "Centrale IP1 & IP2", "Centrale QPA" }));
		ComboBoxSession.setSelectedIndex(1);
		ComboBoxSession.setBounds(6, 16, 131, 20);
		panel_2.add(ComboBoxSession);
		// --------INIT----------
		// ----------------------
		// ----------------------
		new Thread(new ThreadChargementParametres()).start();
	}

	public class ThreadChargementParametres implements Runnable {

		@Override
		public void run() {
			Connection ConnexionBase = LaBase.InitConnexion();

			try {
				if (LaBase.ConsulterDonneePilote(ConnexionBase, "PositionFenetreDernierLancement").equals("true") == true) {
					CheckBoxRestaurePosition.setSelected(true);
				}
				else {
					CheckBoxRestaurePosition.setSelected(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (LaBase.ConsulterDonneePilote(ConnexionBase, "LancementAutoPoste").equals("true") == true) {
					BoxLancementAutomatiquePoste.setSelected(true);
					int Temps = (LaBase.ConsulterDonneeIntPilote(ConnexionBase, "LancementAutoTemps"));
					TextTemps.setText(Integer.toString(Temps));

				}
				else {
					BoxLancementAutomatiquePoste.setSelected(false);
					TextTemps.setEnabled(false);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int Session = 0;

			try {
				Session = LaBase.ConsulterDonneeIntPilote(ConnexionBase, "SessionDefault");
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch (Session) {
				case 1:
					ComboBoxSession.setSelectedIndex(1);
					break;
				case 2:
					ComboBoxSession.setSelectedIndex(2);
					break;
				case 3:
					ComboBoxSession.setSelectedIndex(3);
					break;
				case 4:
					ComboBoxSession.setSelectedIndex(4);
					break;

			}
			LaBase.FermerConnexion(ConnexionBase);

		}

	}

	public class ThreadValideParametres implements Runnable {

		@Override
		public void run() {
			String Choix = null;
			Connection ConnexionBase = LaBase.InitConnexion();

			if (CheckBoxRestaurePosition.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutDonneePilote(ConnexionBase, "PositionFenetreDernierLancement", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (BoxLancementAutomatiquePoste.isSelected() == true) {
				Choix = "true";
			}
			else {
				Choix = "false";
			}
			try {
				LaBase.AjoutDonneePilote(ConnexionBase, "LancementAutoPoste", Choix);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				LaBase.AjoutDonneeIntPilote(ConnexionBase, "LancementAutoTemps", Integer.parseInt(TextTemps.getText()));
			}
			catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				LaBase.AjoutDonneeIntPilote(ConnexionBase, "SessionDefault", ComboBoxSession.getSelectedIndex());
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			dispose();

		}

	}
}

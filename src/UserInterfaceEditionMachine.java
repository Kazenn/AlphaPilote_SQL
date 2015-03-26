import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;

public class UserInterfaceEditionMachine extends JFrame {
	private JTable table;
	private JScrollPane scrollPane;
	GestionMachine GM = new GestionMachine();
	private JTextField TextMachine;
	private JTextField TextIp;
	private JButton BoutonAjouter;
	private JLabel lblMachine;
	private JLabel lblAdresseIp;
	private JPanel panel;
	private JLabel LabelMachineLog;
	private JLabel LabelNombreMachine;
	private JTextField TextSuppression;
	private JTextField TextRechercheMachine;
	private JButton BoutonRechercher;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblAttentionVa;
	private int PositionInterfaceX;
	private int PositionInterfaceY;

	public UserInterfaceEditionMachine() throws SQLException {
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserInterfaceEditionMachine.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("Gestion des machines");
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);

		table = new JTable();
		table = GM.buildTableModel();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 413, 532);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Recharger");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				RefeshTable();
			}
		});
		btnNewButton.setBounds(684, 11, 95, 23);
		getContentPane().add(btnNewButton);

		JButton BoutonValider = new JButton("Valider");
		BoutonValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		final ImageIcon IconValider = new ImageIcon(getClass().getResource("/Ok-icon.png"));
		BoutonValider.setIcon(IconValider);

		BoutonValider.setBounds(433, 505, 123, 38);
		getContentPane().add(BoutonValider);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ajouter une machine", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel.setBounds(432, 146, 234, 143);
		getContentPane().add(panel);
		panel.setLayout(null);

		TextMachine = new JTextField();
		TextMachine.setBounds(113, 16, 111, 23);
		panel.add(TextMachine);
		TextMachine.setColumns(10);

		TextIp = new JTextField();
		TextIp.setBounds(113, 46, 111, 23);
		panel.add(TextIp);
		TextIp.setColumns(10);

		BoutonAjouter = new JButton("Ajouter");
		BoutonAjouter.setBounds(123, 109, 101, 23);
		final ImageIcon IconAjouter = new ImageIcon(getClass().getResource("/add2-icon.png"));
		BoutonAjouter.setIcon(IconAjouter);
		panel.add(BoutonAjouter);

		lblMachine = new JLabel("Nom :");
		lblMachine.setBounds(53, 16, 38, 23);
		panel.add(lblMachine);

		lblAdresseIp = new JLabel("Adresse IP :");
		lblAdresseIp.setBounds(23, 46, 80, 23);
		panel.add(lblAdresseIp);

		JComboBox ComboBoxOs = new JComboBox();
		ComboBoxOs.setModel(new DefaultComboBoxModel(new String[] { "Unix", "Windows" }));
		ComboBoxOs.setBounds(113, 75, 111, 23);
		panel.add(ComboBoxOs);

		JLabel lblSystme = new JLabel("Syst\u00E8me :");
		lblSystme.setBounds(33, 84, 70, 14);
		panel.add(lblSystme);

		LabelMachineLog = new JLabel("");
		LabelMachineLog.setForeground(new Color(0, 100, 0));
		LabelMachineLog.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelMachineLog.setBounds(433, 462, 334, 32);
		getContentPane().add(LabelMachineLog);

		LabelNombreMachine = new JLabel("New label");
		LabelNombreMachine.setForeground(new Color(25, 25, 112));
		LabelNombreMachine.setFont(new Font("Tahoma", Font.BOLD, 11));
		LabelNombreMachine.setBounds(433, 6, 225, 32);
		getContentPane().add(LabelNombreMachine);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Suppression d\u00E9finitive", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(165, 42, 42)));
		panel_2.setBounds(433, 300, 234, 150);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		TextSuppression = new JTextField();
		TextSuppression.setBounds(111, 82, 113, 23);
		panel_2.add(TextSuppression);
		TextSuppression.setColumns(10);

		JButton BoutonSupprimer = new JButton("Supprimer");
		BoutonSupprimer.setMargin(new Insets(1, 1, 1, 1));
		final ImageIcon IconSupprimer = new ImageIcon(getClass().getResource("/poubelle-icon.png"));
		BoutonSupprimer.setIcon(IconSupprimer);
		BoutonSupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean Suppresion = false;

				try {
					Suppresion = GM.SupprimerMachine(TextSuppression.getText());
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (Suppresion == true) {
					LabelMachineLog.setText("La machine " + TextSuppression.getText() + " a été correctement supprimé.");
				}
				if (Suppresion == false) {
					LabelMachineLog.setText("La machine " + TextSuppression.getText() + " n'a pas été supprimé.");
				}
				TextSuppression.setText("");
				RefeshTable();

			}
		});
		BoutonSupprimer.setBounds(121, 116, 103, 23);
		panel_2.add(BoutonSupprimer);

		JLabel label = new JLabel("Nom :");
		label.setBounds(47, 82, 38, 23);
		panel_2.add(label);

		lblAttentionVa = new JLabel("<html>Vous pouvez d\u00E9sactiver une machine<br>en d\u00E9cochant la case \"Utilis\u00E9e\",<br> plut\u00F4t que de la supprimer.</html>\r\n");
		lblAttentionVa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblAttentionVa.setBounds(10, 21, 214, 50);
		panel_2.add(lblAttentionVa);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rechercher une machine", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panel_1.setBounds(432, 49, 234, 89);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		TextRechercheMachine = new JTextField();
		TextRechercheMachine.setBounds(94, 20, 130, 23);
		panel_1.add(TextRechercheMachine);
		TextRechercheMachine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String value = TextRechercheMachine.getText();
				table.repaint();
				// Object text = TableMachine.getValueAt(row, col);
				if (value != null && value.toString().matches(".*" + Pattern.quote(value) + ".*")) {

					for (int row = 0; row <= table.getRowCount() - 1; row++) {

						for (int col = 0; col <= table.getColumnCount() - 1; col++) {

							if (value.equals(table.getValueAt(row, col))) {

								// this will automatically set the view of the
								// scroll in the location of the value
								table.scrollRectToVisible(table.getCellRect(row, 0, true));

								// this will automatically set the focus of the
								// searched/selected row/value
								table.setRowSelectionInterval(row, row);

								for (int i = 0; i <= table.getColumnCount() - 1; i++) {

									// TableMachine.getColumnModel().getColumn(i).setCellRenderer(new
									// HighlightRenderer());
								}
							}
						}

					}
				}
			}
		});
		TextRechercheMachine.setColumns(10);

		JLabel lblNomOuIp = new JLabel("Nom ou IP :");
		lblNomOuIp.setBounds(16, 19, 68, 23);
		panel_1.add(lblNomOuIp);

		BoutonRechercher = new JButton("Rechercher");
		BoutonRechercher.setMargin(new Insets(1, 1, 1, 1));
		final ImageIcon IconRechercher = new ImageIcon(getClass().getResource("/loupe-icon.png"));
		BoutonRechercher.setIcon(IconRechercher);
		BoutonRechercher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String value = TextRechercheMachine.getText();
				table.repaint();
				// Object text = TableMachine.getValueAt(row, col);
				if (value != null && value.toString().matches(".*" + Pattern.quote(value) + ".*")) {

					for (int row = 0; row <= table.getRowCount() - 1; row++) {

						for (int col = 0; col <= table.getColumnCount() - 1; col++) {

							if (value.equals(table.getValueAt(row, col))) {

								// this will automatically set the view of the
								// scroll in the location of the value
								table.scrollRectToVisible(table.getCellRect(row, 0, true));

								// this will automatically set the focus of the
								// searched/selected row/value
								table.setRowSelectionInterval(row, row);

								for (int i = 0; i <= table.getColumnCount() - 1; i++) {

									// TableMachine.getColumnModel().getColumn(i).setCellRenderer(new
									// HighlightRenderer());
								}
							}
						}

					}
				}

			}
		});
		BoutonRechercher.setBounds(117, 54, 107, 23);
		panel_1.add(BoutonRechercher);

		JButton BoutonAnnuler = new JButton("Annuler");
		BoutonAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		BoutonAnnuler.setBounds(656, 505, 123, 38);
		final ImageIcon IconAnnuler = new ImageIcon(getClass().getResource("/cancel-icon.png"));
		BoutonAnnuler.setIcon(IconAnnuler);
		getContentPane().add(BoutonAnnuler);
		BoutonAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String Os = "";
				if (ComboBoxOs.getSelectedIndex() == 0) {
					Os = "Unix";
				}
				if (ComboBoxOs.getSelectedIndex() == 1) {
					Os = "Windows";
				}

				try {
					Boolean ExisteDeja = GM.AjouterMachine(table, TextMachine.getText(), TextIp.getText(), Os);

					if (ExisteDeja == true) {
						LabelMachineLog.setText("La machine " + TextMachine.getText().toLowerCase() + " existe déjà, elle n'est pas ajoutée.");
						LabelMachineLog.setForeground(Color.RED);
					}
					if (ExisteDeja == false) {
						LabelMachineLog.setText("La machine " + TextMachine.getText().toLowerCase() + " est ajoutée.");
						LabelMachineLog.setForeground(new Color(0, 100, 0));
						TextMachine.setText("");
						TextIp.setText("");
					}

				}

				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RefeshTable();

			}
		});

		// INIT
		CustumizeTable();
		// FIN INIT

	}

	public void RefeshTable() {
		try {
			GM.buildTableModel();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(GM.GetTableModel());
		CustumizeTable();
		table.repaint();
	}

	public void CustumizeTable() {

		TableColumn tc0 = table.getColumnModel().getColumn(0);
		TableColumn tc1 = table.getColumnModel().getColumn(1);
		TableColumn tc2 = table.getColumnModel().getColumn(2);
		TableColumn tc3 = table.getColumnModel().getColumn(3);
		TableColumn tc4 = table.getColumnModel().getColumn(4);

		tc0.setResizable(false);
		tc4.setResizable(false);
		tc0.setPreferredWidth(5);
		tc1.setPreferredWidth(45);
		tc2.setPreferredWidth(55);
		tc3.setPreferredWidth(35);
		tc4.setPreferredWidth(13);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Unix");
		comboBox.addItem("Windows");
		tc3.setCellEditor(new DefaultCellEditor(comboBox));

		tc4.setCellEditor(table.getDefaultEditor(Boolean.class));
		tc4.setCellRenderer(table.getDefaultRenderer(Boolean.class));

		LabelNombreMachine.setText("La base contient " + GM.getCompteur() + " enregistements");

	}

	public void VersDB(JTable table) throws SQLException {
		// new Thread(new ThreadVersDB()).start();
		GM.ExtractTableVersDatabase(table);
		dispose();
	}

	public class ThreadVersDB implements Runnable {

		@Override
		public void run() {
			try {
				GM.ExtractTableVersDatabase(table);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

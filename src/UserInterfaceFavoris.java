import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;

import org.apache.commons.io.FilenameUtils;

public class UserInterfaceFavoris extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String line;
	ArrayList<String> strings = new ArrayList<String>();
	private JTable TableFavoris;
	GestionFavoris GF = new GestionFavoris();

	String s = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Data\\icon";
	ImageIcon[] images = new ImageIcon[new File(s).listFiles().length];
	String[] description = new String[images.length];
	Integer[] imageIndex = new Integer[images.length];
	int IndexPourFin = 0;
	private JTextField TextNom;
	private JTextField TextUrl;
	private JTextField TextAide;
	JComboBox<String> BoxCategorie;
	JComboBox<String> BoxSousCategorie;
	JComboBox BoxIcone;
	int IconeSelected = 0;
	int PositionInterfaceX = 0;
	int PositionInterfaceY = 0;
	private JPanel panel;
	private JLabel LabelAjoutValide;
	private JTextField TextId;

	public ImageIcon[] getImages() {
		return images;
	}

	public Integer[] getImageIndex() {
		return imageIndex;
	}

	public void GenerationImages() {

		final JDialog loading = new JDialog();
		JPanel p1 = new JPanel(new BorderLayout());
		p1.add(new JLabel("Veuillez patienter, génération des favoris en cours..."), BorderLayout.CENTER);
		loading.setUndecorated(false);
		loading.setSize(400, 200);
		loading.setBackground(Color.ORANGE);
		loading.getContentPane().add(p1);
		loading.pack();
		loading.setLocation(null);
		// loading.setLocation(PositionInterfaceX, PositionInterfaceY);

		loading.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		loading.setModal(true);

		SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {
			@Override
			protected String doInBackground() throws InterruptedException {

				/** Execute some operation */
				CoreGenerationImages();
				return line;
			}

			@Override
			protected void done() {
				loading.dispose();
			}
		};
		worker.execute();
		loading.setVisible(true);
		try {
			worker.get();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void CoreGenerationImages() {

		File f = new File(s.toString());
		File[] fa = f.listFiles();
		Arrays.sort(fa);
		if (fa != null && fa.length > 0) {
			for (int i = 0; i < fa.length; i++) {
				try {
					IndexPourFin = i;
					fa[i].toURL();
					java.net.URL UrlImage = fa[i].toURL();
					ImageIcon IconImage = new ImageIcon(UrlImage);
					images[i] = IconImage;
					description[i] = FilenameUtils.removeExtension(fa[i].getName());

				}
				catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	class ComboBoxRenderer extends JLabel implements ListCellRenderer {
		public ComboBoxRenderer() {
			setOpaque(false);
			setHorizontalAlignment(LEFT);
			setVerticalAlignment(CENTER);
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

			int selectedIndex = ((Integer) value).intValue();

			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			}
			else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}

			// Set the icon and text.
			ImageIcon icon = images[selectedIndex];
			String language = description[selectedIndex];
			setIcon(icon);
			if (icon != null) {
				setText(language);
				setFont(list.getFont());
			}

			return this;
		}
	}

	public UserInterfaceFavoris() throws SQLException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				UserInterface UI;
				try {
					UI = new UserInterface();
					UI.setGainedFocus(true);
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		requestFocus();
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setFocusable(true);

		//
		// ----- FIN DECLARATION
		//
		setTitle("Gestion des favoris");
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 985, 473);
		getContentPane().add(scrollPane);

		TableFavoris = new JTable();
		TableFavoris = GF.buildTableModel();
		scrollPane.setViewportView(TableFavoris);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ajout favori ou lien", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel.setBounds(10, 495, 431, 200);
		getContentPane().add(panel);
		panel.setLayout(null);

		TextNom = new JTextField();
		TextNom.setBounds(135, 14, 134, 20);
		panel.add(TextNom);
		TextNom.setColumns(10);

		TextUrl = new JTextField();
		TextUrl.setBounds(135, 45, 220, 20);
		panel.add(TextUrl);
		TextUrl.setColumns(10);

		TextAide = new JTextField();
		TextAide.setBounds(135, 76, 134, 20);
		panel.add(TextAide);
		TextAide.setColumns(10);

		BoxCategorie = new JComboBox();
		BoxCategorie.setBounds(135, 107, 162, 20);
		panel.add(BoxCategorie);

		BoxSousCategorie = new JComboBox();
		BoxSousCategorie.setBounds(135, 138, 134, 20);
		panel.add(BoxSousCategorie);

		JButton BoutonValider = new JButton("Ajouter");
		BoutonValider.setBounds(314, 168, 107, 23);
		final ImageIcon IconAjouter = new ImageIcon(getClass().getResource("/add2-icon.png"));
		BoutonValider.setIcon(IconAjouter);
		panel.add(BoutonValider);

		JLabel lblNom = new JLabel("Nom ");
		lblNom.setBounds(74, 17, 36, 14);
		panel.add(lblNom);

		JLabel lblUrl = new JLabel("Url (ou lien complet)");
		lblUrl.setBounds(10, 48, 115, 14);
		panel.add(lblUrl);

		JLabel lblAide = new JLabel("Aide");
		lblAide.setBounds(74, 79, 36, 14);
		panel.add(lblAide);

		JLabel lblCatgorie = new JLabel("Cat\u00E9gorie");
		lblCatgorie.setBounds(50, 110, 60, 14);
		panel.add(lblCatgorie);

		JLabel lblSousCatgorie = new JLabel("Sous cat\u00E9gorie");
		lblSousCatgorie.setBounds(25, 141, 100, 14);
		panel.add(lblSousCatgorie);

		JLabel lblNewLabel = new JLabel("Ic\u00F4ne");
		lblNewLabel.setBounds(71, 172, 46, 14);
		panel.add(lblNewLabel);

		// BoxIcone = new JComboBox();

		LabelAjoutValide = new JLabel("");
		LabelAjoutValide.setEnabled(false);
		LabelAjoutValide.setForeground(new Color(0, 0, 0));
		LabelAjoutValide.setBounds(467, 495, 426, 37);
		getContentPane().add(LabelAjoutValide);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Suppression favori ou lien", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(165, 42, 42)));
		panel_1.setBounds(451, 563, 221, 132);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		TextId = new JTextField();
		TextId.setBounds(32, 101, 55, 20);
		panel_1.add(TextId);
		TextId.setColumns(10);

		JButton BoutonSupprimer = new JButton("Supprimer");
		final ImageIcon IconSupprimer = new ImageIcon(getClass().getResource("/poubelle-icon.png"));
		BoutonSupprimer.setIcon(IconSupprimer);
		BoutonSupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GestionFavoris GF = new GestionFavoris();
				String ID = TextId.getText();
				Boolean RetourValide = GF.SupprimerFavoris(ID);

				if (RetourValide == true) {
					LabelAjoutValide.setEnabled(true);
					LabelAjoutValide.setText("Suppresion du favori avec succès.");
					LabelAjoutValide.setForeground(new Color(0, 128, 128));
					LabelAjoutValide.setFont(new Font("Tahoma", Font.PLAIN, 15));

				}
				if (RetourValide == false) {
					LabelAjoutValide.setEnabled(true);
					LabelAjoutValide.setText("Erreur dans la suppression du favori.");
					LabelAjoutValide.setFont(new Font("Tahoma", Font.PLAIN, 15));
					LabelAjoutValide.setForeground(new Color(102, 0, 0));

				}
				try {
					GF.buildTableModel();
					TableFavoris.setModel(GF.getMonModele());
					CustumizeTable();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		BoutonSupprimer.setBounds(97, 100, 114, 23);
		panel_1.add(BoutonSupprimer);

		JLabel ZoneId = new JLabel("ID");
		ZoneId.setBounds(10, 104, 29, 14);
		panel_1.add(ZoneId);

		JLabel lblNewLabel_1 = new JLabel("<html>Vous pouvez d\u00E9sactiver un favoris <br>en d\u00E9cochant la case \"Utilis\u00E9\",<br> plut\u00F4t que de le supprimer.</html>\r\n");
		lblNewLabel_1.setBounds(10, 11, 201, 58);
		panel_1.add(lblNewLabel_1);

		JButton BoutonQuitter = new JButton("Quitter");
		BoutonQuitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		BoutonQuitter.setBounds(842, 650, 125, 45);
		final ImageIcon IconPorte = new ImageIcon(getClass().getResource("/door-icon.png"));
		BoutonQuitter.setIcon(IconPorte);

		getContentPane().add(BoutonQuitter);

		BoutonValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				GestionFavoris GF = new GestionFavoris();

				String Nom = TextNom.getText();
				String Url = TextUrl.getText();
				String Aide = TextAide.getText();
				String Categorie = (String) BoxCategorie.getSelectedItem();
				String SousCategorie = (String) BoxSousCategorie.getSelectedItem();
				int Icone = IconeSelected;
				Boolean RetourValide = false;

				try {
					RetourValide = GF.AjouterFavoris(Nom, Url, Categorie, SousCategorie, Aide, Icone);
					GF.buildTableModel();
					TableFavoris.setModel(GF.getMonModele());
					CustumizeTable();

				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (RetourValide == true) {
					LabelAjoutValide.setEnabled(true);
					LabelAjoutValide.setText("Ajout du favori avec succès.");
					LabelAjoutValide.setForeground(new Color(0, 128, 128));
					LabelAjoutValide.setFont(new Font("Tahoma", Font.PLAIN, 15));

				}
				if (RetourValide == false) {
					LabelAjoutValide.setEnabled(true);
					LabelAjoutValide.setText("Erreur dans l'ajout du favori.");
					LabelAjoutValide.setFont(new Font("Tahoma", Font.PLAIN, 15));
					LabelAjoutValide.setForeground(new Color(102, 0, 0));

				}

			}
		});
		//
		// ----- FIN DESCRIPTION
		//
		CustumizeTable();
		CustumizeComboxBox();

		// PositionInterfaceX = this.getX();
		// PositionInterfaceY = this.getY();

	}

	public void CustumizeTable() {

		TableColumn tc0 = TableFavoris.getColumnModel().getColumn(0);
		TableColumn tc1 = TableFavoris.getColumnModel().getColumn(1);
		TableColumn tc2 = TableFavoris.getColumnModel().getColumn(2);
		TableColumn tc3 = TableFavoris.getColumnModel().getColumn(3);
		TableColumn tc4 = TableFavoris.getColumnModel().getColumn(4);
		TableColumn tc5 = TableFavoris.getColumnModel().getColumn(5);
		TableColumn tc6 = TableFavoris.getColumnModel().getColumn(6);
		TableColumn tc7 = TableFavoris.getColumnModel().getColumn(7);

		tc0.setPreferredWidth(10);
		tc1.setPreferredWidth(45);
		tc2.setPreferredWidth(110);
		tc3.setPreferredWidth(55);
		tc4.setPreferredWidth(35);
		tc5.setPreferredWidth(35);
		tc6.setPreferredWidth(35);
		tc7.setPreferredWidth(5);
		tc0.setResizable(false);
		tc4.setResizable(false);
		tc7.setResizable(false);

		JComboBox<String> BoxCategories = new JComboBox<String>();
		BoxCategories.addItem("Pilotage");
		BoxCategories.addItem("MVS");
		BoxCategories.addItem("AS 400");
		BoxCategories.addItem("CFF");
		BoxCategories.addItem("MySys Distribués");
		BoxCategories.addItem("MySys Centrale");
		BoxCategories.addItem("Canaux directs (BAD)");
		BoxCategories.addItem("Monétique");
		BoxCategories.addItem("Surveillances");
		BoxCategories.addItem("Outils");
		BoxCategories.addItem("Divers");
		tc3.setCellEditor(new DefaultCellEditor(BoxCategories));
		tc3.setCellRenderer(TableFavoris.getDefaultRenderer(JComboBox.class));

		JComboBox<String> BoxSCategories = new JComboBox<String>();
		BoxSCategories.addItem("Url");
		BoxSCategories.addItem("Documents");
		tc4.setCellEditor(new DefaultCellEditor(BoxSCategories));

		JComboBox<String> BoxType = new JComboBox<String>();
		BoxType.addItem("Url");
		BoxType.addItem("Document");
		tc5.setCellEditor(new DefaultCellEditor(BoxType));

		tc7.setCellEditor(TableFavoris.getDefaultEditor(Boolean.class));
		tc7.setCellRenderer(TableFavoris.getDefaultRenderer(Boolean.class));

		// COMBOBOX IMAGES------
		// ---------------------
		// ---------------------

		CoreGenerationImages();

		// ----------------------

		for (int i = 0; i < imageIndex.length; i++) {
			imageIndex[i] = i;
		}

		JComboBox jComboBoxIcone = new JComboBox(imageIndex);
		JComboBox BoxIcone = new JComboBox(imageIndex);
		BoxIcone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				IconeSelected = BoxIcone.getSelectedIndex();

			}
		});
		ComboBoxRenderer renderer = new ComboBoxRenderer();
		jComboBoxIcone.setRenderer(renderer);
		BoxIcone.setRenderer(renderer);
		BoxIcone.setBounds(135, 169, 134, 20);
		panel.add(BoxIcone);
		jComboBoxIcone.setMaximumRowCount(20);

		tc5.setCellEditor(new DefaultCellEditor(jComboBoxIcone));

	}

	private void CustumizeComboxBox() {
		BoxCategorie.addItem("Pilotage");
		BoxCategorie.addItem("MVS");
		BoxCategorie.addItem("AS 400");
		BoxCategorie.addItem("CFF");
		BoxCategorie.addItem("MySys Distribués");
		BoxCategorie.addItem("MySys Centrale");
		BoxCategorie.addItem("Canaux directs (BAD)");
		BoxCategorie.addItem("Monétique");
		BoxCategorie.addItem("Surveillances");
		BoxCategorie.addItem("Outils");
		BoxCategorie.addItem("Divers");

		BoxSousCategorie.addItem("Url");
		BoxSousCategorie.addItem("Documents");

	}
}

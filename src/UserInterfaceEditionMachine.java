import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.commons.lang3.StringUtils;

public class UserInterfaceEditionMachine extends JFrame {
	private JTable TableMachine;

	String line;
	Vector NomMachine;
	Vector IpMachine;
	ArrayList<String> strings = new ArrayList<String>();
	private DefaultTableModel ModeleTableMachine;
	private String PathToMachine = "Chemin Vide";
	private String PathToMachineTemp = "Chemin Vide";
	private JScrollPane ScrollZoneTablemachine;
	private JLabel LabelNombreMachines;
	private JPanel panel;
	private JLabel LabelAjout;
	private JLabel LabelDoublon;
	private JLabel LabelReorg;
	private JLabel LabelValidation;
	private JTextField TextRechercheMachine;
	private JPanel panel_1;

	public UserInterfaceEditionMachine() throws IOException {
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserInterfaceEditionMachine.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("Gestion des machines");
		getContentPane().setLayout(null);
		ScrollZoneTablemachine = new JScrollPane();
		ScrollZoneTablemachine.setBounds(10, 11, 473, 442);
		ScrollZoneTablemachine.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(ScrollZoneTablemachine);

		NomMachine = new Vector();
		IpMachine = new Vector();
		GestionEditionFichierMachine EditionMachine = new GestionEditionFichierMachine();
		GestionChemin GC = new GestionChemin();
		PathToMachine = GC.DemandeChemin("CheminFichierMachine");
		PathToMachineTemp = GC.DemandeChemin("CheminFichierTemp2");
		strings = EditionMachine.ArrayFichierMachine();
		//
		// ----- FIN DECLARATION
		//

		//
		// ----- FIN DESCRIPTION
		//
		String col[] = { "Nom machine", "IP machine", "Decocher pour supprimer" };
		ModeleTableMachine = new DefaultTableModel(col, 0);
		TableMachine = new JTable();
		ScrollZoneTablemachine.setViewportView(TableMachine);
		TableMachine.setModel(ModeleTableMachine);

		JButton BoutonValider = new JButton("Valider et quitter");

		final ImageIcon IconBoutonValiderFavoris = new ImageIcon(getClass().getResource("/Ok-icon.png"));
		BoutonValider.setIcon(IconBoutonValiderFavoris);
		BoutonValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				new Thread(new ExtractTableMachineVersFichier()).start();
			}
		});
		BoutonValider.setBounds(10, 482, 181, 66);
		getContentPane().add(BoutonValider);

		JButton BoutonAjouter = new JButton("Ajouter");
		final ImageIcon IconBoutonAjouterFavoris = new ImageIcon(getClass().getResource("/add-icon.png"));
		BoutonAjouter.setIcon(IconBoutonAjouterFavoris);
		BoutonAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				RefreshTable();
			}
		});
		BoutonAjouter.setBounds(493, 226, 111, 38);
		getContentPane().add(BoutonAjouter);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(493, 24, 210, 54);
		getContentPane().add(panel);
		panel.setLayout(null);

		LabelNombreMachines = new JLabel("Le fichier machine compte XXX machines.");
		LabelNombreMachines.setBounds(10, 11, 189, 31);
		panel.add(LabelNombreMachines);
		LabelNombreMachines.setForeground(new Color(210, 105, 30));
		LabelNombreMachines.setFont(new Font("Verdana", Font.PLAIN, 13));
		int NombreMachine = EditionMachine.CompteLigneFichierMachine();
		LabelNombreMachines.setText(NombreMachine + " machines enregistrées");

		LabelAjout = new JLabel("     Ajout des nouvelles entr\u00E9es...");
		LabelAjout.setEnabled(false);
		LabelAjout.setIcon(new ImageIcon(UserInterfaceEditionMachine.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		LabelAjout.setBounds(508, 388, 220, 22);
		getContentPane().add(LabelAjout);

		LabelDoublon = new JLabel("     Recherche de doublons...");
		LabelDoublon.setEnabled(false);
		LabelDoublon.setIcon(new ImageIcon(UserInterfaceEditionMachine.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		LabelDoublon.setBounds(508, 421, 220, 22);
		getContentPane().add(LabelDoublon);

		LabelReorg = new JLabel("     R\u00E9oganisation du fichier...");
		LabelReorg.setEnabled(false);
		LabelReorg.setIcon(new ImageIcon(UserInterfaceEditionMachine.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		LabelReorg.setBounds(508, 454, 220, 22);
		getContentPane().add(LabelReorg);

		LabelValidation = new JLabel("     Validation du nouveau fichier...");
		LabelValidation.setEnabled(false);
		LabelValidation.setIcon(new ImageIcon(UserInterfaceEditionMachine.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		LabelValidation.setBounds(508, 491, 220, 22);
		getContentPane().add(LabelValidation);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rechercher une machine", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(493, 93, 156, 54);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		TextRechercheMachine = new JTextField();
		TextRechercheMachine.setBounds(10, 24, 121, 20);
		panel_1.add(TextRechercheMachine);
		TextRechercheMachine.setText("...");
		TextRechercheMachine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Action performed");
				String value = TextRechercheMachine.getText();
				TableMachine.repaint();
				// Object text = TableMachine.getValueAt(row, col);
				if (value != null && value.toString().matches(".*" + Pattern.quote(value) + ".*")) {

					for (int row = 0; row <= TableMachine.getRowCount() - 1; row++) {

						for (int col = 0; col <= TableMachine.getColumnCount() - 1; col++) {

							if (value.equals(TableMachine.getValueAt(row, col))) {

								// this will automatically set the view of the
								// scroll in the location of the value
								TableMachine.scrollRectToVisible(TableMachine.getCellRect(row, 0, true));

								// this will automatically set the focus of the
								// searched/selected row/value
								TableMachine.setRowSelectionInterval(row, row);

								for (int i = 0; i <= TableMachine.getColumnCount() - 1; i++) {

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

		TableColumn tc = TableMachine.getColumnModel().getColumn(2);
		tc.setCellEditor(TableMachine.getDefaultEditor(Boolean.class));
		tc.setCellRenderer(TableMachine.getDefaultRenderer(Boolean.class));

		AlimentationTableMachine();

		TableMachine.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				for (int i = 0; i < TableMachine.getModel().getRowCount(); i++) {
					if ((Boolean) TableMachine.getModel().getValueAt(i, 2)) {
						System.out.println(">\t" + TableMachine.getSelectedRow());

						break;
					}
				}
			}
		});

	}

	public void AlimentationTableMachine() throws IOException {

		for (int i = 0; i < strings.size(); i++) {

			String string = strings.get(i);
			String[] parts = string.split("=");
			String NomMachine = parts[0];
			String IpMachine = parts[1];

			Object[] Donnees = { NomMachine, IpMachine, new Boolean(true) };
			ModeleTableMachine.addRow(Donnees);

		}
	}

	public class ExtractTableMachineVersFichier implements Runnable {

		@Override
		public void run() {
			final ImageIcon IconLabelFleche = new ImageIcon(getClass().getResource("/fleche-icon.png"));
			final ImageIcon IconLabelCheck = new ImageIcon(getClass().getResource("/ok-apply-icon.png"));
			LabelAjout.setEnabled(true);
			LabelAjout.setIcon(IconLabelFleche);

			GestionMachine GC = new GestionMachine();
			BufferedWriter bfw;
			try {
				bfw = new BufferedWriter(new FileWriter(PathToMachine));
				for (int i = 0; i < TableMachine.getRowCount(); i++) {
					bfw.newLine();
					for (int j = 0; j < 2; j++) {
						if ((Boolean) TableMachine.getModel().getValueAt(i, 2) == true) {
							if (TableMachine.getModel().getValueAt(i, 0) != null && TableMachine.getModel().getValueAt(i, 1) != null) {
								bfw.write((String) (TableMachine.getValueAt(i, j)));
							}
						}
						bfw.write("=");

					}
				}
				bfw.close();
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			LabelAjout.setIcon(IconLabelCheck);
			LabelDoublon.setEnabled(true);
			LabelDoublon.setIcon(IconLabelFleche);

			File temporaire = new File(PathToMachineTemp);
			File FichierSortieMachine = new File(PathToMachine);
			try {
				Scanner scanner = new Scanner(FichierSortieMachine);
				BufferedWriter bw = new BufferedWriter(new FileWriter(temporaire));
				while (scanner.hasNextLine()) {
					String line = StringUtils.stripEnd(scanner.nextLine(), null);
					if (StringUtils.isNotBlank(line)) {
						int Lastchar = line.length();
						line = line.substring(0, Lastchar - 1);
						if (line.equals("=") == false) {
							bw.write(line); // Keep the line only if not blank
											// et
											// pas egal à "="
						}

						if (scanner.hasNextLine()) {
							// Go to next line (Win,Mac,Unix) if there is one
							bw.write(System.getProperty("line.separator"));
						}
					}
					bw.flush();
				}
				scanner.close();
				bw.close();
				FichierSortieMachine.delete();
				temporaire.renameTo(FichierSortieMachine);

			}
			catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}

			LabelDoublon.setIcon(IconLabelCheck);
			LabelReorg.setEnabled(true);
			LabelReorg.setIcon(IconLabelFleche);

			try {
				Scanner scanner = new Scanner(FichierSortieMachine);
				BufferedWriter bw = new BufferedWriter(new FileWriter(temporaire));
				while (scanner.hasNextLine()) {
					String line = StringUtils.stripEnd(scanner.nextLine(), null);
					if (StringUtils.isNotBlank(line)) {
						bw.write(line); // Keep the line only if not blank
						if (scanner.hasNextLine()) {
							// Go to next line (Win,Mac,Unix) if there is one
							bw.write(System.getProperty("line.separator"));
						}
					}
					bw.flush();
				}
				scanner.close();
				bw.close();
				FichierSortieMachine.delete();
				temporaire.renameTo(FichierSortieMachine);

			}
			catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}

			LabelReorg.setIcon(IconLabelCheck);
			LabelValidation.setEnabled(true);
			LabelValidation.setIcon(IconLabelFleche);
			try {
				GC.EliminationDoublons();
				GC.ReorderFichierMachine();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LabelValidation.setIcon(IconLabelCheck);
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();

		}

	}

	public void RefreshTable() {
		ScrollZoneTablemachine.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		DefaultTableModel dm = (DefaultTableModel) TableMachine.getModel();
		dm.addRow(new Object[] { null, null, Boolean.TRUE });
		dm.fireTableDataChanged();
		dm.fireTableRowsInserted(0, TableMachine.getRowCount());
		// dm.fireTableRowsInserted(rows.size()-1,rows.size()-1);
		TableMachine.repaint();
		TableMachine.scrollRectToVisible(TableMachine.getCellRect(TableMachine.getRowCount(), 0, true));
		TableMachine.scrollRectToVisible(TableMachine.getCellRect(TableMachine.getRowCount() + 1, 0, true));
	}

	private class HighlightRenderer extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

			// everything as usual
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

			// added behavior
			if (row == table.getSelectedRow()) {

				// this will customize that kind of border that will be use to
				// highlight a row
				setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
			}

			return this;
		}
	}

}

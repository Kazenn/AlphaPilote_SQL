import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.commons.lang3.StringUtils;

public class UserInterfaceFavoris extends JFrame {
	private JTable TableFavoris;
	String line;
	Vector NomFavoris;
	Vector UrlFavoris;
	ArrayList<String> strings = new ArrayList<String>();
	private DefaultTableModel ModeleTableFavoris;
	private String PathToFavoris = "Chemin Vide";
	private String PathToFavorisTemp = "Chemin Vide";

	public UserInterfaceFavoris() throws IOException {
		setType(Type.UTILITY);

		NomFavoris = new Vector();
		UrlFavoris = new Vector();
		GestionFavoris GF = new GestionFavoris();
		GestionChemin GC = new GestionChemin();
		PathToFavoris = GC.DemandeChemin("CheminFichierFavoris");
		PathToFavorisTemp = GC.DemandeChemin("CheminFichierTemp");
		strings = GF.ArrayFichierFavoris();
		//
		// ----- FIN DECLARATION
		//
		setTitle("Gestion des favoris");
		getContentPane().setLayout(null);
		//
		// ----- FIN DESCRIPTION
		//
		String col[] = { "Nom du favoris", "URL du favoris", "Decocher pour supprimer" };
		ModeleTableFavoris = new DefaultTableModel(col, 0);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 553, 414);
		getContentPane().add(scrollPane);
		TableFavoris = new JTable();
		scrollPane.setViewportView(TableFavoris);
		TableFavoris.setModel(ModeleTableFavoris);

		JButton BoutonExtactEtValideTable = new JButton("Valider les favoris");
		final ImageIcon IconBoutonValiderFavoris = new ImageIcon(getClass().getResource("/Ok-icon.png"));
		BoutonExtactEtValideTable.setIcon(IconBoutonValiderFavoris);
		BoutonExtactEtValideTable.setMargin(new Insets(1, 1, 1, 1));
		BoutonExtactEtValideTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				try {
					ExtractTableFavorisVersFichier();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		BoutonExtactEtValideTable.setBounds(10, 449, 201, 58);
		getContentPane().add(BoutonExtactEtValideTable);

		JButton btnRefresh = new JButton("Ajouter");
		btnRefresh.setMargin(new Insets(1, 1, 1, 1));
		final ImageIcon IconBoutonAjouterFavoris = new ImageIcon(getClass().getResource("/add-icon.png"));
		btnRefresh.setIcon(IconBoutonAjouterFavoris);
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				RefreshTable();
				TableFavoris.repaint();

			}
		});
		btnRefresh.setBounds(588, 194, 125, 41);
		getContentPane().add(btnRefresh);

		JLabel lblAttentionLa = new JLabel("Attention : La gestion de ces favoris est commune.");
		lblAttentionLa.setForeground(new Color(165, 42, 42));
		lblAttentionLa.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAttentionLa.setBounds(258, 456, 430, 41);
		getContentPane().add(lblAttentionLa);
		TableColumn tc = TableFavoris.getColumnModel().getColumn(2);
		tc.setCellEditor(TableFavoris.getDefaultEditor(Boolean.class));
		tc.setCellRenderer(TableFavoris.getDefaultRenderer(Boolean.class));

		AlimentationTableFavoris();

		TableFavoris.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				for (int i = 0; i < TableFavoris.getModel().getRowCount(); i++) {
					if ((Boolean) TableFavoris.getModel().getValueAt(i, 2)) {
						// System.out.println(">\t" +
						// TableFavoris.getSelectedRow());

						break;
					}
				}
			}
		});

		// ExtractTableFavorisVersFichier();

	}

	public void AlimentationTableFavoris() throws IOException {

		for (int i = 0; i < strings.size(); i++) {

			String string = strings.get(i);
			String[] parts = string.split("\t");
			String NomFavoris = parts[0]; // NomFavoris
			String UrlFavoris = parts[1]; // UrlFavoris

			Object[] Donnees = { NomFavoris, UrlFavoris, new Boolean(true) };
			ModeleTableFavoris.addRow(Donnees);

		}
	}

	public void ExtractTableFavorisVersFichier() throws IOException {

		BufferedWriter bfw = new BufferedWriter(new FileWriter(PathToFavoris));

		for (int i = 0; i < TableFavoris.getRowCount(); i++) {
			bfw.newLine();
			for (int j = 0; j < 2; j++) {
				if ((Boolean) TableFavoris.getModel().getValueAt(i, 2) == true) {
					if (TableFavoris.getModel().getValueAt(i, 0) != null && TableFavoris.getModel().getValueAt(i, 1) != null) {
						bfw.write((String) (TableFavoris.getValueAt(i, j)));
					}
				}
				bfw.write("\t");

			}
		}
		bfw.close();

		File temporaire = new File(PathToFavorisTemp);
		File FichierSortieFavoris = new File(PathToFavoris);
		try {
			Scanner scanner = new Scanner(FichierSortieFavoris);
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
			FichierSortieFavoris.delete();
			temporaire.renameTo(FichierSortieFavoris);

		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void RefreshTable() {

		TableFavoris.repaint();
		DefaultTableModel dm = (DefaultTableModel) TableFavoris.getModel();
		dm.addRow(new Object[] { null, null, Boolean.TRUE });
		dm.fireTableDataChanged();
		TableFavoris.repaint();

	}
}

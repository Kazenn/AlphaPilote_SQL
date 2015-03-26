import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class GestionFavoris extends DefaultTableModel {

	public GestionFavoris MonModele;

	public GestionFavoris getMonModele() {
		return MonModele;
	}

	public JTable buildTableModel() throws SQLException {

		int ID;
		String Nom = "";
		String Url = "";
		String Categorie = "";
		String SousCategorie = "";
		int Icone = 0;
		String Help = "";
		String Utilisée = "";

		MonModele = new GestionFavoris();
		JTable TableFavoris = new JTable();
		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();
		Statement stmt = null;
		stmt = ConnectionBase.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Favoris order by Categorie ASC");
		MonModele.addColumn("ID");
		MonModele.addColumn("Nom");
		MonModele.addColumn("Url");
		MonModele.addColumn("Catégorie");
		MonModele.addColumn("Sous-catégorie");
		MonModele.addColumn("Icône");
		MonModele.addColumn("Aide");
		MonModele.addColumn("Utilisé");

		while (rs.next()) {

			ID = rs.getInt("ID");
			Nom = rs.getString("Nom");
			Url = rs.getString("Url");
			Categorie = rs.getString("Categorie");
			SousCategorie = rs.getString("SCategorie");
			Icone = rs.getInt("Icone");
			Help = rs.getString("Help");
			Utilisée = rs.getString("Utilisee");
			if (Utilisée.equals("true") == true) {
				MonModele.addRow(new Object[] { ID, Nom, Url, Categorie, SousCategorie, Icone, Help, new Boolean(true) });
			}
			else {
				MonModele.addRow(new Object[] { ID, Nom, Url, Categorie, SousCategorie, Icone, Help, new Boolean(false) });
			}
		}

		TableFavoris.setModel(MonModele);

		MonModele.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent tme) {
				if (tme.getType() == TableModelEvent.UPDATE) {

					Statement stmt = null;
					ResultSet rs = null;
					int i = tme.getFirstRow();

					int used = (int) MonModele.getValueAt(i, 0);
					try {
						stmt = ConnectionBase.createStatement();

						rs = stmt.executeQuery("select * from Favoris where ID=" + used);
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					try {
						while (rs.next()) {
							int ID = (int) MonModele.getValueAt(i, 0);
							String Nom = (String) MonModele.getValueAt(i, 1);
							String Url = (String) MonModele.getValueAt(i, 2);
							String Categorie = (String) MonModele.getValueAt(i, 3);
							String SousCategorie = (String) MonModele.getValueAt(i, 4);
							int Icone = (int) MonModele.getValueAt(i, 5);
							String Help = (String) MonModele.getValueAt(i, 6);
							Boolean Bool = (Boolean) MonModele.getValueAt(i, 7);
							String Utilisée = "";

							if (Bool == true) {
								Utilisée = "true";
							}
							if (Bool == false) {
								Utilisée = "false";
							}
							String Query = "UPDATE Favoris SET 'Nom'='" + Nom + "','Url'='" + Url + "','Categorie'='" + Categorie + "','SCategorie'='" + SousCategorie + "','Icone'='" + Icone
									+ "','Help'='" + Help + "','Utilisee'='" + Utilisée + "' where ID='" + ID + "'";
							try {
								stmt.executeUpdate(Query);
							}
							catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});

		return TableFavoris;

	}

	@Override
	public boolean isCellEditable(int row, int cols) {
		if (cols == 0) {
			return false;
		}
		return true;

	}

	public Boolean AjouterFavoris(String Nom, String Url, String Categorie, String SousCategorie, String Aide, int Icone) {
		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();
		Statement stmt = null;
		String BoolTrue = "true";
		Boolean AjoutValide = false;
		try {
			stmt = ConnectionBase.createStatement();
			String sql = "INSERT INTO `Favoris`(`ID`,`Nom`,`Url`,`Categorie`,`SCategorie`,`Icone`,`Help`,`Utilisee`) VALUES (NULL,'" + Nom + "','" + Url + "','" + Categorie + "','" + SousCategorie
					+ "','" + Icone + "','" + Aide + "','" + BoolTrue + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			AjoutValide = true;
		}
		catch (SQLException e) {
			LaBase.FermerConnexion(ConnectionBase);
			AjoutValide = false;
			e.printStackTrace();
		}

		LaBase.FermerConnexion(ConnectionBase);

		return AjoutValide;

	}

	public Boolean SupprimerFavoris(String ID) {
		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();
		Statement stmt = null;
		Boolean Suppresion = false;
		try {
			stmt = ConnectionBase.createStatement();
			String query = "Select * from Favoris where ID='" + ID + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String sql = "DELETE from Favoris where ID='" + ID + "';";
				stmt.executeUpdate(sql);
				Suppresion = true;

			}

		}
		catch (SQLException e) {
			Suppresion = false;
			LaBase.FermerConnexion(ConnectionBase);
			e.printStackTrace();
		}
		LaBase.FermerConnexion(ConnectionBase);
		return Suppresion;

	}
}

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class GestionMachine extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public GestionMachine MonModele;

	GestionChemin RequeteChemin = new GestionChemin();
	int compteur = 0;

	public int getCompteur() {
		return compteur;
	}

	public String DemandeIpSQL(String Machine) throws SQLException {
		String AdresseIp = "";
		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();
		Statement stmt = null;
		stmt = ConnectionBase.createStatement();
		ResultSet rs = stmt.executeQuery("select AdresseIP from Machine where Machine='" + Machine + "'");
		while (rs.next()) {
			AdresseIp = rs.getString("AdresseIP");
		}

		LaBase.FermerConnexion(ConnectionBase);
		return AdresseIp;

	}

	public String[] LireFichierGlossarySQL() throws SQLException {
		ArrayList<String> strings = new ArrayList<String>();
		String[] ListeMachinePourComboBox;
		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();
		Statement stmt = null;
		stmt = ConnectionBase.createStatement();
		ResultSet rs = stmt.executeQuery("select Machine from Machine where Utilisée='true' order by Machine ASC");
		while (rs.next()) {
			strings.add(rs.getString("Machine"));
		}
		ListeMachinePourComboBox = strings.toArray(new String[0]);
		LaBase.FermerConnexion(ConnectionBase);
		return ListeMachinePourComboBox;

	}

	public JTable buildTableModel() throws SQLException {
		int ID;
		String Machine = "";
		String AdresseIP = "";
		String Os = "";
		String Utilisée = "";

		compteur = 0;
		MonModele = new GestionMachine();
		JTable TableMachine = new JTable();
		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();
		Statement stmt = null;
		stmt = ConnectionBase.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Machine order by Machine ASC");

		MonModele.addColumn("ID");
		MonModele.addColumn("Machine");
		MonModele.addColumn("Adresse IP");
		MonModele.addColumn("Système(OS)");
		MonModele.addColumn("Utilisé");

		while (rs.next()) {
			compteur++;
			ID = rs.getInt("ID");
			Machine = rs.getString("Machine");
			AdresseIP = rs.getString("AdresseIP");
			Os = rs.getString("Os");
			Utilisée = rs.getString("Utilisée");
			if (Utilisée.equals("true") == true) {
				MonModele.addRow(new Object[] { ID, Machine, AdresseIP, Os, new Boolean(true) });
			}
			else {
				MonModele.addRow(new Object[] { ID, Machine, AdresseIP, Os, new Boolean(false) });
			}
		}

		TableMachine.setModel(MonModele);

		MonModele.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent tme) {
				if (tme.getType() == TableModelEvent.UPDATE) {

					// System.out.println("Cell " + tme.getFirstRow() + ", " +
					// tme.getColumn() + " changed. The new value: " +
					// MonModele.getValueAt(tme.getFirstRow(),
					// tme.getColumn()));
					Statement stmt = null;
					ResultSet rs = null;
					int i = tme.getFirstRow();
					int used = (int) MonModele.getValueAt(i, 0);
					try {
						stmt = ConnectionBase.createStatement();

						rs = stmt.executeQuery("select * from Machine where ID=" + used);
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					try {
						while (rs.next()) {
							int ID = (int) MonModele.getValueAt(i, 0);
							String Machine = (String) MonModele.getValueAt(i, 1);
							String AdresseIP = (String) MonModele.getValueAt(i, 2);
							String Os = (String) MonModele.getValueAt(i, 3);
							Boolean Bool = (Boolean) MonModele.getValueAt(i, 4);
							String Utilisée = "";
							if (Bool == true) {
								Utilisée = "true";
							}
							if (Bool == false) {
								Utilisée = "false";
							}
							String Query = "UPDATE Machine SET 'Machine'='" + Machine + "','AdresseIP'='" + AdresseIP + "','Os'='" + Os + "','Utilisée'='" + Utilisée + "' where ID='" + ID + "'";
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

		// LaBase.FermerConnexion(ConnectionBase);

		return TableMachine;
	}

	public GestionMachine GetTableModel() {

		return MonModele;

	}

	public void ExtractTableVersDatabase(JTable table) throws SQLException {
		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();
		Statement stmt = null;
		stmt = ConnectionBase.createStatement();

		for (int i = 0; i < table.getRowCount(); i++) {
			int used = (int) table.getModel().getValueAt(i, 0);
			ResultSet rs = stmt.executeQuery("select * from Machine where ID=" + used);
			while (rs.next()) {
				int ID = (int) table.getModel().getValueAt(i, 0);
				String Machine = (String) table.getModel().getValueAt(i, 1);
				String AdresseIP = (String) table.getModel().getValueAt(i, 2);
				String Os = (String) MonModele.getValueAt(i, 3);
				Boolean Bool = (Boolean) table.getModel().getValueAt(i, 4);
				String Utilisée = "";
				if (Bool == true) {
					Utilisée = "true";
				}
				if (Bool == false) {
					Utilisée = "false";
				}
				String Query = "UPDATE Machine SET 'Machine'='" + Machine + "','AdresseIP'='" + AdresseIP + "','Os'='" + Os + "','Utilisée'='" + Utilisée + "' where ID='" + ID + "'";
				stmt.executeUpdate(Query);
			}

		}
		LaBase.FermerConnexion(ConnectionBase);
	}

	public Boolean AjouterMachine(JTable table, String Machine, String AdresseIp, String Os) throws SQLException {
		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();
		Statement stmt = null;
		stmt = ConnectionBase.createStatement();
		String BoolTrue = "true";
		Boolean ExisteDeja = false;

		String query = "Select Machine from Machine where Machine='" + Machine + "'";
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {

			ExisteDeja = true;
		}
		if (ExisteDeja == false) {
			String sql = "INSERT INTO `Machine`(`ID`,`Machine`,`AdresseIP`,`Os`,`Utilisée`) VALUES (NULL,'" + Machine + "','" + AdresseIp + "','" + Os + "','" + BoolTrue + "');";
			stmt.executeUpdate(sql);
			stmt.close();

		}
		LaBase.FermerConnexion(ConnectionBase);
		return ExisteDeja;

	}

	public Boolean SupprimerMachine(String Machine) throws SQLException {
		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();
		Statement stmt = null;
		Boolean Suppresion = false;
		stmt = ConnectionBase.createStatement();
		String query = "Select * from Machine where Machine='" + Machine + "'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			String sql = "DELETE from Machine where Machine='" + Machine + "';";
			stmt.executeUpdate(sql);
			Suppresion = true;

		}

		LaBase.FermerConnexion(ConnectionBase);
		return Suppresion;

	}

	@Override
	public boolean isCellEditable(int row, int cols) {
		if (cols == 0) {
			return false;
		}
		return true;

	}

}

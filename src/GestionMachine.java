import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
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
		System.out.println(AdresseIp);
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
		MonModele.addColumn("Utilisée");

		while (rs.next()) {
			compteur++;
			ID = rs.getInt("ID");
			Machine = rs.getString("Machine");
			AdresseIP = rs.getString("AdresseIP");
			Utilisée = rs.getString("Utilisée");
			if (Utilisée.equals("true") == true) {
				MonModele.addRow(new Object[] { ID, Machine, AdresseIP, new Boolean(true) });
			}
			else {
				MonModele.addRow(new Object[] { ID, Machine, AdresseIP, new Boolean(false) });
			}
		}

		TableMachine.setModel(MonModele);
		LaBase.FermerConnexion(ConnectionBase);
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
				Boolean Bool = (Boolean) table.getModel().getValueAt(i, 3);
				String Utilisée = "";
				if (Bool == true) {
					Utilisée = "true";
				}
				if (Bool == false) {
					Utilisée = "false";
				}
				String Query = "UPDATE Machine SET 'Machine'='" + Machine + "','AdresseIP'='" + AdresseIP + "','Utilisée'='" + Utilisée + "' where ID='" + ID + "'";
				stmt.executeUpdate(Query);
			}

		}
		LaBase.FermerConnexion(ConnectionBase);
	}

	public Boolean AjouterMachine(JTable table, String Machine, String AdresseIp) throws SQLException {
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
			String sql = "INSERT INTO `Machine`(`ID`,`Machine`,`AdresseIP`,`Utilisée`) VALUES (NULL,'" + Machine + "','" + AdresseIp + "','" + BoolTrue + "');";
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

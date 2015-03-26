import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionSql {
	String BaseDonnee = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Data\\BaseProfile.db";
	String UserNameStation = System.getProperty("user.name").toUpperCase();
	GestionEncryption SecuriteFichierConfig = new GestionEncryption();

	public Connection InitConnexion() {
		Connection c = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + BaseDonnee);

			return c;

		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;

		}

	}

	public void FermerConnexion(Connection c) {
		try {
			c.close();
		}
		catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public Boolean TestConnexion() {

		try {
			Class.forName("org.sqlite.JDBC");
			DriverManager.getConnection("jdbc:sqlite:" + BaseDonnee);

			return true;

		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;

		}

	}

	public String TestUserExistant(Connection c, String User) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		String RetourUser = "AUCUN";

		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select User from Pilote where User='" + User.toUpperCase() + "';");
			while (rs.next()) {
				RetourUser = "EXISTE";
			}

			stmt.close();
			c.commit();

		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();

		}
		return RetourUser;

	}

	public Boolean AjoutNouveauPilote(Connection c, String User) throws SQLException {
		Statement stmt = null;
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "INSERT INTO `Pilote`(`ID`,`User`,`PositionFenetreDernierLancement`,`Session`,`SessionDefault`,`LancementAutoPoste`,`LancementAutoTemps`) VALUES (NULL," + "'" + User + "'"
					+ ",'false','1','1','false','10');";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();

		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();

		}

		return null;

	}

	public String ConsulterUserPilote(Connection c, String Data) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		String LaDonnee = "VIDE";
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select user" + Data + " from Pilote where User='" + UserNameStation + "';");
			while (rs.next()) {
				LaDonnee = rs.getString("user" + Data);
			}
			stmt.close();
			c.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();
		}
		return LaDonnee;
	}

	public String ConsulterPasswordPilote(Connection c, String Data) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		String LaDonnee = "VIDE";
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select password" + Data + " from Pilote where User='" + UserNameStation + "';");
			while (rs.next()) {
				LaDonnee = rs.getString("password" + Data);
				LaDonnee = SecuriteFichierConfig.DemandeDecryption(LaDonnee);
			}
			stmt.close();
			c.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();
		}
		return LaDonnee;
	}

	public Boolean AjoutUserPilote(Connection c, String Entree, String Data) throws SQLException {
		Statement stmt = null;
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "UPDATE Pilote SET user" + Entree + "=" + "'" + Data + "'" + " WHERE User=" + "'" + UserNameStation + "'" + ";";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();

		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();

		}

		return null;

	}

	public String AjoutPasswordPilote(Connection c, String Entree, String Data) throws SQLException {

		Statement stmt = null;
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			Data = SecuriteFichierConfig.DemandeEncryption(Data);
			String sql = "UPDATE Pilote SET password" + Entree + "=" + "'" + Data + "'" + " WHERE User=" + "'" + UserNameStation + "'" + ";";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();
		}
		return null;
	}

	public String ConsulterDeviceNamePilote(Connection c, String Data) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		String LaDonnee = "VIDE";
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select DeviceName" + Data + " from Pilote where User='" + UserNameStation + "';");
			while (rs.next()) {
				LaDonnee = rs.getString("DeviceName" + Data);

			}
			stmt.close();
			c.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();
		}
		return LaDonnee;
	}

	public Boolean AjoutDeviceNamePilote(Connection c, String Entree, String Data) throws SQLException {
		Statement stmt = null;
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "UPDATE Pilote SET DeviceName" + Entree + "=" + "'" + Data + "'" + " WHERE User=" + "'" + UserNameStation + "'" + ";";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();

		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();

		}

		return null;

	}

	public String ConsulterAutoconnectPilote(Connection c, String Data) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		String LaDonnee = "VIDE";
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select autoconnect" + Data + " from Pilote where User='" + UserNameStation + "';");
			while (rs.next()) {
				LaDonnee = rs.getString("autoconnect" + Data);

			}
			stmt.close();
			c.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();
		}
		return LaDonnee;
	}

	public Boolean AjoutAutoconnectPilote(Connection c, String Entree, String Data) throws SQLException {
		Statement stmt = null;
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "UPDATE Pilote SET autoconnect" + Entree + "=" + "'" + Data + "'" + " WHERE User=" + "'" + UserNameStation + "'" + ";";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();

		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();

		}

		return null;

	}

	public String ConsulterBrowserPilote(Connection c) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		String LaDonnee = "VIDE";
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select DefaultBrowser from Pilote where User='" + UserNameStation + "';");
			while (rs.next()) {
				LaDonnee = rs.getString("DefaultBrowser");

			}
			stmt.close();
			c.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();
		}
		return LaDonnee;
	}

	public Boolean AjoutBrowserPilote(Connection c, String Data) throws SQLException {
		Statement stmt = null;
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "UPDATE Pilote SET DefaultBrowser=" + "'" + Data + "'" + " WHERE User=" + "'" + UserNameStation + "'" + ";";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();

		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();

		}

		return null;

	}

	public String ConsulterLancementAutoPilote(Connection c, String Data) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		String LaDonnee = "VIDE";
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select BoutonLancePoste" + Data + " from Pilote where User='" + UserNameStation + "';");
			while (rs.next()) {
				LaDonnee = rs.getString("BoutonLancePoste" + Data);

			}
			stmt.close();
			c.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();
		}
		return LaDonnee;
	}

	public Boolean AjoutLancementAutoPilote(Connection c, String Entree, String Data) throws SQLException {
		Statement stmt = null;
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "UPDATE Pilote SET BoutonLancePoste" + Entree + "=" + "'" + Data + "'" + " WHERE User=" + "'" + UserNameStation + "'" + ";";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();

		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();

		}

		return null;

	}

	public String ConsulterDonneePilote(Connection c, String Entree) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		String LaDonnee = "VIDE";
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select " + Entree + " from Pilote where User='" + UserNameStation + "';");
			while (rs.next()) {
				LaDonnee = rs.getString(Entree);

			}
			stmt.close();
			c.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();
		}
		return LaDonnee;
	}

	public int ConsulterDonneeIntPilote(Connection c, String Entree) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		int LaDonnee = 0;
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select " + Entree + " from Pilote where User='" + UserNameStation + "';");
			while (rs.next()) {
				LaDonnee = rs.getInt(Entree);

			}
			stmt.close();
			c.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();
		}
		return LaDonnee;
	}

	public Boolean AjoutDonneePilote(Connection c, String Entree, String Data) throws SQLException {
		Statement stmt = null;
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "UPDATE Pilote SET " + Entree + "=" + "'" + Data + "'" + " WHERE User=" + "'" + UserNameStation + "'" + ";";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();

		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();

		}

		return null;

	}

	public Boolean AjoutDonneeIntPilote(Connection c, String Entree, int Data) throws SQLException {
		Statement stmt = null;
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "UPDATE Pilote SET " + Entree + "=" + "'" + Data + "'" + " WHERE User=" + "'" + UserNameStation + "'" + ";";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();

		}
		catch (SQLException e) {
			e.printStackTrace();
			this.FermerConnexion(c);
			stmt.close();

		}

		return null;

	}

}

import java.sql.Connection;
import java.sql.SQLException;

public class GestionSessions {

	GestionSql LaBase = new GestionSql();

	public void InitSession() {

	}

	public int LireSession() throws SQLException {
		Connection ConnexionSql = LaBase.InitConnexion();
		int Session = LaBase.ConsulterDonneeIntPilote(ConnexionSql, "Session");
		LaBase.FermerConnexion(ConnexionSql);
		return Session;

	}

	public void EcrireSession(int Session_Menu) throws SQLException {
		Connection ConnexionSql = LaBase.InitConnexion();
		LaBase.AjoutDonneeIntPilote(ConnexionSql, "Session", Session_Menu);
		LaBase.FermerConnexion(ConnexionSql);

	}

}

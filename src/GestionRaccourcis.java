import java.sql.Connection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestionRaccourcis {

	public String EcrireRaccourcis(String NomRaccourci, String LettreRaccourci) {
		String ValidationEcriture = "";

		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();

		LaBase.AjoutDonneePilote(ConnectionBase, "Raccourci" + NomRaccourci, LettreRaccourci);

		return ValidationEcriture;

	}

	public String DemandeRaccourci(String NomRaccourci) {

		String ResultatDemandeRaccourci = "";
		GestionSql LaBase = new GestionSql();
		Connection ConnectionBase = LaBase.InitConnexion();

		ResultatDemandeRaccourci = LaBase.ConsulterDonneePilote(ConnectionBase, "Raccourci" + NomRaccourci);

		return ResultatDemandeRaccourci;

	}

	public Set<String> RechercheDoublons(List<String> listContainingDuplicates) {

		final Set<String> setToReturn = new HashSet<String>();
		final Set<String> set1 = new HashSet<String>();

		for (String yourInt : listContainingDuplicates) {
			if (!set1.add(yourInt)) {
				setToReturn.add(yourInt);
			}
		}
		return setToReturn;
	}

}

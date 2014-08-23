import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class GestionRaccourcis {
	GestionChemin RequeteChemin = new GestionChemin();

	public String EcrireRaccourcis(String NomRaccourci, String LettreRaccourci) {
		String ValidationEcriture = "";
		Properties properties = new Properties();
		new File(RequeteChemin.DemandeChemin("CheminFichierConfig"));
		FileInputStream stream;
		try {

			stream = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(stream);
			properties.setProperty("Raccourci" + NomRaccourci, LettreRaccourci);
			FileOutputStream oStream = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.store(oStream, "Fichier de configuration User/Pass/Paramètres est correctement enregistré");
			ValidationEcriture = "Fichier correctement enregistré";
			oStream.close();
		}
		catch (FileNotFoundException e) {

			e.printStackTrace();
			ValidationEcriture = "Impossible de trouver le fichier : " + e;
		}
		catch (IOException e) {

			e.printStackTrace();
			ValidationEcriture = "Erreur lors de l'écriture du fichier : " + e;
		}

		return ValidationEcriture;

	}

	public String DemandeRaccourci(String NomRaccourci) {

		String ResultatDemandeRaccourci = "";

		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(in);
			in.close();
			ResultatDemandeRaccourci = properties.getProperty("Raccourci" + NomRaccourci);

		}
		catch (IOException e) {

		}

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

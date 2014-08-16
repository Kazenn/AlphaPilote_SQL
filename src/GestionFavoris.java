import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestionFavoris {
	private String PathToFavoris = "Chemin Vide";

	public String[] LireFichierFavoris() throws IOException {

		GestionChemin GC = new GestionChemin();
		PathToFavoris = GC.DemandeChemin("CheminFichierFavoris");
		ArrayList<String> strings = new ArrayList<String>();
		String[] ListeFavoris = null;
		String line = "vide";
		BufferedReader input = new BufferedReader(new FileReader(PathToFavoris));
		while ((line = input.readLine()) != null) {

			strings.add(line);

		}
		ListeFavoris = strings.toArray(new String[0]);
		input.close();

		return ListeFavoris;

	}

	public int CompteLigneFichierFavoris() throws IOException {
		GestionChemin GC = new GestionChemin();
		PathToFavoris = GC.DemandeChemin("CheminFichierFavoris");
		BufferedReader input = new BufferedReader(new FileReader(PathToFavoris));
		int NombreLigneFichierFavoris = 0;
		while ((input.readLine()) != null) {
			NombreLigneFichierFavoris = NombreLigneFichierFavoris + 1;

		}
		input.close();
		return NombreLigneFichierFavoris;

	}

	public ArrayList<String> ArrayFichierFavoris() throws IOException {
		GestionChemin GC = new GestionChemin();
		PathToFavoris = GC.DemandeChemin("CheminFichierFavoris");

		ArrayList<String> strings = new ArrayList<String>();
		// String[] ListeFavoris = null;
		String line = "vide";
		BufferedReader input = new BufferedReader(new FileReader(PathToFavoris));
		while ((line = input.readLine()) != null) {

			strings.add(line);

		}
		// ListeFavoris = strings.toArray(new String[0]);
		input.close();

		return strings;

	}
}

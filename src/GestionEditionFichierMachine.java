import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestionEditionFichierMachine {

	private String PathToMachine = "Chemin Vide";

	public String[] LireFichierMachine() throws IOException {

		GestionChemin GC = new GestionChemin();
		PathToMachine = GC.DemandeChemin("CheminFichierMachine");
		ArrayList<String> strings = new ArrayList<String>();
		String[] ListeMachine = null;
		String line = "vide";
		BufferedReader input = new BufferedReader(new FileReader(PathToMachine));
		while ((line = input.readLine()) != null) {

			strings.add(line);

		}
		ListeMachine = strings.toArray(new String[0]);
		input.close();

		return ListeMachine;

	}

	public int CompteLigneFichierMachine() throws IOException {
		GestionChemin GC = new GestionChemin();
		PathToMachine = GC.DemandeChemin("CheminFichierMachine");
		BufferedReader input = new BufferedReader(new FileReader(PathToMachine));
		int NombreLigneFichierMachine = 0;
		while ((input.readLine()) != null) {
			NombreLigneFichierMachine = NombreLigneFichierMachine + 1;

		}
		input.close();
		return NombreLigneFichierMachine;

	}

	public ArrayList<String> ArrayFichierMachine() throws IOException {
		GestionChemin GC = new GestionChemin();
		PathToMachine = GC.DemandeChemin("CheminFichierMachine");

		ArrayList<String> strings = new ArrayList<String>();

		String line = "vide";
		BufferedReader input = new BufferedReader(new FileReader(PathToMachine));
		while ((line = input.readLine()) != null) {

			strings.add(line);

		}

		input.close();

		return strings;

	}

}

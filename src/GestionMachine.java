import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

public class GestionMachine {

	String CheminFichierMachine = "D:\\AlphaPilote\\machine.txt";
	GestionChemin RequeteChemin = new GestionChemin();

	public int LireFichierMachine() throws URISyntaxException {
		int CodeRetour = 0;
		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierMachine"));
			properties.load(in);
			in.close();

			CodeRetour = 0;
		}
		catch (IOException e) {

			CodeRetour = 1;
		}

		return CodeRetour;

	}

	public String DemandeIp(String Machine) {
		// UserInterface UI = new UserInterface();
		String AdresseIp = "";
		// CheminFichierMachine = UI.DemandeCheminConfig();
		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierMachine"));
			properties.load(in);
			in.close();
			AdresseIp = properties.getProperty(Machine);

		}
		catch (IOException e) {

		}

		return AdresseIp;

	}

	public String[] LireFichierGlossary() throws IOException {
		ArrayList<String> strings = new ArrayList<String>();
		BufferedReader input = new BufferedReader(new FileReader(RequeteChemin.DemandeChemin("CheminFichierMachine")));
		String[] ListeMachinePourComboBox;
		String line = "vide class";
		// UserInterface UI = new UserInterface();
		// CheminFichierMachine = UI.DemandeCheminConfig();
		try {
			while ((line = input.readLine()) != null) {
				line = line.split("=")[0];
				strings.add(line);

			}
			// return line;
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListeMachinePourComboBox = strings.toArray(new String[0]);
		input.close();
		return ListeMachinePourComboBox;

	}

	public Boolean ReorderFichierMachine() {

		String inputFile = RequeteChemin.DemandeChemin("CheminFichierMachine");
		String outputFile = RequeteChemin.DemandeChemin("CheminFichierMachine");
		Boolean ValideOrder = false;

		try {
			FileReader fileReader;
			fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String inputLine;
			ArrayList<String> lineList = new ArrayList<String>();
			while ((inputLine = bufferedReader.readLine()) != null) {
				lineList.add(inputLine);
			}
			fileReader.close();

			Collections.sort(lineList);

			FileWriter fileWriter = new FileWriter(outputFile);
			PrintWriter out = new PrintWriter(fileWriter);
			for (String outputLine : lineList) {
				out.println(outputLine);
			}
			out.flush();
			out.close();
			fileWriter.close();
			ValideOrder = true;
		}
		catch (FileNotFoundException e) {
			ValideOrder = false;
			e.printStackTrace();
		}
		catch (IOException e) {
			ValideOrder = false;
			e.printStackTrace();
		}

		return ValideOrder;

	}

}

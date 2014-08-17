import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

public class GestionLog {
	// String CheminLog="D:\\AlphaPilote\\log.txt";
	GestionChemin RequeteChemin = new GestionChemin();

	public void EcrireDansFichierLog(String ChaineDansFichier) {
		// UserInterface UI = new UserInterface();
		// CheminLog = UI.DemandeCheminConfig();
		FileOutputStream FichierSortie; // declare a file output object
		PrintStream FluxEcriture; // declare a print stream object

		SimpleDateFormat SimpleDate = new SimpleDateFormat("dd/MM/yyyy à HH:mm:ss");
		String LaDateHeure = SimpleDate.format(new java.util.Date());
		// System.out.println(RequeteChemin.DemandeChemin("CheminFichierLog"));

		try {
			FichierSortie = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierLog"), true);

			FluxEcriture = new PrintStream(FichierSortie, true);
			FluxEcriture.println("[" + LaDateHeure + "] " + ChaineDansFichier);
			FluxEcriture.close();

		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

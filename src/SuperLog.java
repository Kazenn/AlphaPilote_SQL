import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

public class SuperLog {

	GestionChemin RequeteChemin = new GestionChemin();
	String UserNameStation = System.getProperty("user.name");

	public void EcrireSuperLog(String ChaineDansFichier) {

		FileOutputStream FichierSortie;
		PrintStream FluxEcriture;

		SimpleDateFormat SimpleDate = new SimpleDateFormat("dd/MM/yyyy à HH:mm:ss");
		String LaDateHeure = SimpleDate.format(new java.util.Date());

		try {
			FichierSortie = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierSuperLog"), true);

			FluxEcriture = new PrintStream(FichierSortie, true);
			FluxEcriture.println(UserNameStation + " à " + "[" + LaDateHeure + "] " + " a lancé = " + ChaineDansFichier);
			FluxEcriture.close();

		}
		catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
}
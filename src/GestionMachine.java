import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Properties;


public class GestionMachine {
	
	
	
	String CheminFichierMachine="D:\\AlphaPilote\\machine.txt";
	GestionChemin RequeteChemin = new GestionChemin();
	
	public int LireFichierMachine() throws URISyntaxException 
	{
		 int CodeRetour = 0;
		 Properties properties=new Properties();
		 try 
		 {
		 FileInputStream in =new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierMachine"));
		 properties.load(in);
		 in.close();
				 
		 CodeRetour = 0;
		 } 
		 catch (IOException e) {
		 
		 CodeRetour = 1;
		 }
		
		return CodeRetour;
		 
		}
	
	
	public String DemandeIp(String Machine)
	{
		//UserInterface UI = new UserInterface();
		String AdresseIp = "";
		int CodeRetour = 5;
		//CheminFichierMachine = UI.DemandeCheminConfig();
		Properties properties=new Properties();
		try 
		{
			FileInputStream in =new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierMachine"));
			properties.load(in);
			in.close();
			AdresseIp = properties.getProperty(Machine);
			CodeRetour = 0;

		} 
		catch (IOException e) {
			//System.out.println("Impssible de trouver le fichier de configuration");
			CodeRetour = 1;

		}

		return AdresseIp;
	
	}
	
	public String[] LireFichierGlossary() throws IOException
	{
		ArrayList<String> strings = new ArrayList<String>();
		BufferedReader input = new BufferedReader(new FileReader(RequeteChemin.DemandeChemin("CheminFichierMachine")));
		String[] ListeMachinePourComboBox;
		String line = "vide class";
		//UserInterface UI = new UserInterface();
		//CheminFichierMachine = UI.DemandeCheminConfig();
		try {
			while (( line = input.readLine()) != null)
			{
				line = line.split("=")[0];
			    strings.add(line);
		  
			}
				//return line;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListeMachinePourComboBox = (String[]) strings.toArray(new String[0]);
		input.close();
		return ListeMachinePourComboBox;
	
}
}


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;


public class GestionMachine {
	
	
	
	String configPath="D:\\AlphaPilote\\machine.txt";
	
	public int LireFichierMachine() 
	{
		 int CodeRetour = 0;
		 
		 Properties properties=new Properties();
		 try 
		 {
		 FileInputStream in =new FileInputStream(configPath);
		 properties.load(in);
		 in.close();
		 //System.out.println(properties.getProperty("user"));
		 //System.out.println(properties.getProperty("password"));
		 
		 CodeRetour = 0;
		 } 
		 catch (IOException e) {
		 //System.out.println("Impssible de trouver le fichier de configuration");
		 CodeRetour = 1;
		 }
		 
		 //let's do the magic
		 
		return CodeRetour;
		 
		}
	
	
	public String DemandeIp(String Machine)
	{
		String AdresseIp = "";
		int CodeRetour = 5;
		
		Properties properties=new Properties();
		try 
		{
			FileInputStream in =new FileInputStream(configPath);
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
		BufferedReader input = new BufferedReader(new FileReader(configPath));
		String[] ListeMachinePourComboBox;
		String line = "vide class";
		
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


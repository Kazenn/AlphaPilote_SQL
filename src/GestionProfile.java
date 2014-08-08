import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class GestionProfile {
	
	public int ModifierPasswordProfile(String Machine, String Password) throws IOException
	
	{
		int CodeRetour = 5;
		String ConfigPath = "D:\\AlphaPilote\\Quick3270\\Macro\\"+Machine+".qmc";
		
		String LignePassword = "SendKeys "+"\""+Password+"<"+"Enter"+">"+"\"";
		//BufferedWriter bw = new BufferedWriter(new FileWriter(ConfigPath));
		ArrayList<String> TableauArray = new ArrayList<String>();
		BufferedReader input = new BufferedReader(new FileReader(ConfigPath));
		String[] TableauTempo;
		String line = "vide class";
		
		try {
			while (( line = input.readLine()) != null)
			{
			
				TableauArray.add(line);
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TableauTempo = (String[]) TableauArray.toArray(new String[0]);
		TableauTempo[10] = LignePassword;
				File file = new File(ConfigPath);
				PrintWriter out = new PrintWriter(new FileWriter(file));

				for (String LaLigne : TableauTempo) {
				    out.println(LaLigne);
				}

				out.close();
				input.close();
		return CodeRetour;
		
		
		
		
	}

public int ModifierUserProfile(String Machine, String User) throws IOException
	
	{
		int CodeRetour = 5;
		String ConfigPath = "D:\\AlphaPilote\\Quick3270\\Macro\\"+Machine+".qmc";
		
		String LignePassword = "SendKeys "+"\""+User+"<"+"Enter"+">"+"\"";
		
		ArrayList<String> TableauArray = new ArrayList<String>();
		BufferedReader input = new BufferedReader(new FileReader(ConfigPath));
		String[] TableauTempo;
		String line = "vide class";
		
		try {
			while (( line = input.readLine()) != null)
			{
			
				TableauArray.add(line);
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TableauTempo = (String[]) TableauArray.toArray(new String[0]);
		TableauTempo[8] = LignePassword;
				File file = new File(ConfigPath);
				PrintWriter out = new PrintWriter(new FileWriter(file));

				for (String LaLigne : TableauTempo) {
				    out.println(LaLigne);
				}

				out.close();

		return CodeRetour;
		
		
		
		
	}
	
	
}

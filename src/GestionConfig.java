import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class GestionConfig {

	
	public int LireConfig() 
	{
		 int CodeRetour = 0;
		 String configPath="D:\\AlphaPilote\\config.txt";
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
	
	public String DemandeUser(String Machine)
		{
	 String User = "";
	 int CodeRetour = 5;
	 String configPath="D:\\AlphaPilote\\config.txt";
	 Properties properties=new Properties();
	 try 
	 {
	 FileInputStream in =new FileInputStream(configPath);
	 properties.load(in);
	 in.close();
	 User = properties.getProperty("user" + Machine);
	 CodeRetour = 0;
	
	 } 
	 catch (IOException e) {
	 //System.out.println("Impssible de trouver le fichier de configuration");
	 CodeRetour = 1;
	
	 }
	
		return User;
		
	}

	
	public String DemandePassword(String Machine)
	{
		String Password = "";
		int CodeRetour = 5;
		String configPath="D:\\AlphaPilote\\config.txt";
		Properties properties=new Properties();
		try 
		{
			FileInputStream in =new FileInputStream(configPath);
			properties.load(in);
			in.close();
			Password = properties.getProperty("password" + Machine);
			CodeRetour = 0;

		} 
		catch (IOException e) {
			//System.out.println("Impssible de trouver le fichier de configuration");
			CodeRetour = 1;

		}

	return Password;
	
}
	
	
}

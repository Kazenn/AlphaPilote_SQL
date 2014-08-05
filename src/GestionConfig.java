import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

	public String EcrireUser(String User , String Machine , String UserAEcrire)
	{
		 
		 String ValidationEcriture = "";
		 int CodeRetour = 5;
		 String configPath="D:\\AlphaPilote\\config.txt";
		 Properties properties=new Properties();
		 File FichierConfig = new File(configPath);
		 FileInputStream stream;
		try {
			 
			 stream = new FileInputStream(FichierConfig);
			 properties.load(stream);
			 properties.setProperty(User + Machine , UserAEcrire);
			 FileOutputStream oStream = new FileOutputStream(FichierConfig) ;
			 properties.store(oStream, "Fichier de configuration des users et password");
			 ValidationEcriture = "User pour " + Machine +" est correctement enregistré";
			 CodeRetour = 0;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ValidationEcriture = "Impossible de trouver le fichier : " + e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ValidationEcriture = "Erreur lors de l'écriture du fichier : " + e;
		}
		 
		 CodeRetour = 1;
		 
	return ValidationEcriture;
	
	}
	
	public String EcrirePassword(String Password , String Machine , String PasswordAEcrire)
	{
		 
		 String ValidationEcriture = "";
		 int CodeRetour = 5;
		 String configPath="D:\\AlphaPilote\\config.txt";
		 Properties properties=new Properties();
		 File FichierConfig = new File(configPath);
		 FileInputStream stream;
		try {
			 
			 stream = new FileInputStream(FichierConfig);
			 properties.load(stream);
			 properties.setProperty(Password + Machine , PasswordAEcrire);
			 FileOutputStream oStream = new FileOutputStream(FichierConfig) ;
			 properties.store(oStream, "Fichier de configuration des users et password");
			 ValidationEcriture = "Fichier correctement enregistré";
			 CodeRetour = 0;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ValidationEcriture = "Impossible de trouver le fichier : " + e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ValidationEcriture = "Erreur lors de l'écriture du fichier : " + e;
		}
		 
		 CodeRetour = 1;
		 
	return ValidationEcriture;
	
	}
	
	
}

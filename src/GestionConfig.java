import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class GestionConfig {

	String CheminFichierConfig= "CheminVide";
	GestionChemin RequeteChemin = new GestionChemin();
	
	
	
	public int LireConfig() 
	{
		
		//UserInterface UI = new UserInterface();
		// CheminFichierConfig = UI.DemandeCheminConfig();
		 
		 int CodeRetour = 0;
		 //String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
		 Properties properties=new Properties();
		 try 
		 {
		 FileInputStream in =new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
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
		//UserInterface UI = new UserInterface();
		//CheminFichierConfig = UI.DemandeCheminConfig();
		
	 String User = "";
	 int CodeRetour = 5;
	 //String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
	 Properties properties=new Properties();
	 try 
	 {
	 FileInputStream in =new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
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
		//UserInterface UI = new UserInterface();
		//CheminFichierConfig = UI.DemandeCheminConfig();
		String Password = "";
		int CodeRetour = 5;
		//String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
		Properties properties=new Properties();
		try 
		{
			
			FileInputStream in =new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(in);
			in.close();
			Password = properties.getProperty("password" + Machine);
			GestionEncryption SecuriteFichierConfig = new GestionEncryption();
			Password = SecuriteFichierConfig.DemandeDecryption(Password);
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
		//UserInterface UI = new UserInterface(); 
		//CheminFichierConfig = UI.DemandeCheminConfig();
		 String ValidationEcriture = "";
		 int CodeRetour = 5;
		 //String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
		 Properties properties=new Properties();
		 File FichierConfig = new File(CheminFichierConfig);
		 FileInputStream stream;
		try {
			 
			 stream = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			 properties.load(stream);
			 properties.setProperty(User + Machine , UserAEcrire);
			 FileOutputStream oStream = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierConfig")) ;
			 properties.store(oStream, "Fichier de configuration des users et password");
			 ValidationEcriture = "User pour " + Machine +" est correctement enregistré";
			 CodeRetour = 0;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			ValidationEcriture = "Impossible de trouver le fichier : " + e;
		} catch (IOException e) {

			e.printStackTrace();
			ValidationEcriture = "Erreur lors de l'écriture du fichier : " + e;
		}
		 
		 CodeRetour = 1;
		 
	return ValidationEcriture;
	
	}
	
	public String EcrirePassword(String Password , String Machine , String PasswordAEcrire)
	{
		//UserInterface UI = new UserInterface();
		//CheminFichierConfig = UI.DemandeCheminConfig();
		 String ValidationEcriture = "";
		 int CodeRetour = 5;
		 //String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
		 Properties properties=new Properties();
		 File FichierConfig = new File(RequeteChemin.DemandeChemin("CheminFichierConfig"));
		 FileInputStream stream;
		try {
			 GestionEncryption SecuriteFichierConfig = new GestionEncryption();
			 PasswordAEcrire = SecuriteFichierConfig.DemandeEncryption(PasswordAEcrire);
			 stream = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			 properties.load(stream);
			 properties.setProperty(Password + Machine , PasswordAEcrire);
			 FileOutputStream oStream = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierConfig")) ;
			 properties.store(oStream, "Fichier de configuration des users et password");
			 ValidationEcriture = "Fichier correctement enregistré";
			 CodeRetour = 0;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			ValidationEcriture = "Impossible de trouver le fichier : " + e;
		} catch (IOException e) {

			e.printStackTrace();
			ValidationEcriture = "Erreur lors de l'écriture du fichier : " + e;
		}
		 
		 CodeRetour = 1;
		 
	return ValidationEcriture;
	
	}
	
	public String DemandeAutoConnect(String Machine)
	{
		
		String ResultatDemandeAutoConnect = "";
		
		int CodeRetour = 5;
		
		Properties properties=new Properties();
		try 
		{
			FileInputStream in =new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(in);
			in.close();
			ResultatDemandeAutoConnect = properties.getProperty("autoconnect" + Machine);
			CodeRetour = 0;

		} 
		catch (IOException e) {
			//System.out.println("Impssible de trouver le fichier de configuration");
			CodeRetour = 1;

		}

	return ResultatDemandeAutoConnect;
	
	}	
	
	
	public String EcrireAutoConnect(String autoconnect , String Machine , String AutoConnectAEcrire)
	{
		//UserInterface UI = new UserInterface();
		//CheminFichierConfig = UI.DemandeCheminConfig();
		 String ValidationEcriture = "";
		 int CodeRetour = 5;
		 //String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
		 Properties properties=new Properties();
		 File FichierConfig = new File(RequeteChemin.DemandeChemin("CheminFichierConfig"));
		 FileInputStream stream;
		try {
			 
			 stream = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			 properties.load(stream);
			 properties.setProperty(autoconnect + Machine , AutoConnectAEcrire);
			 FileOutputStream oStream = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierConfig")) ;
			 properties.store(oStream, "Fichier de configuration des users et password");
			 ValidationEcriture = "Fichier correctement enregistré";
			 CodeRetour = 0;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			ValidationEcriture = "Impossible de trouver le fichier : " + e;
		} catch (IOException e) {

			e.printStackTrace();
			ValidationEcriture = "Erreur lors de l'écriture du fichier : " + e;
		}
		 
		 CodeRetour = 1;
		 
	return ValidationEcriture;
	
	}
	
	
}

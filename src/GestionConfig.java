import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

public class GestionConfig extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String CheminFichierConfig = "CheminVide";
	GestionChemin RequeteChemin = new GestionChemin();

	public int LireConfig() {

		// UserInterface UI = new UserInterface();
		// CheminFichierConfig = UI.DemandeCheminConfig();

		int CodeRetour = 0;
		// String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(in);
			in.close();
			// System.out.println(properties.getProperty("user"));
			// System.out.println(properties.getProperty("password"));

			CodeRetour = 0;
		}
		catch (IOException e) {
			// System.out.println("Impssible de trouver le fichier de configuration");
			CodeRetour = 1;
		}

		// let's do the magic

		return CodeRetour;

	}

	public String DemandeUser(String Machine) {
		// UserInterface UI = new UserInterface();
		// CheminFichierConfig = UI.DemandeCheminConfig();

		String User = "";
		// String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(in);
			in.close();
			User = properties.getProperty("user" + Machine);

		}
		catch (IOException e) {

		}

		return User;

	}

	public String DemandeDevice(String Machine) {
		// UserInterface UI = new UserInterface();
		// CheminFichierConfig = UI.DemandeCheminConfig();

		String Device = "";
		// String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(in);
			in.close();
			Device = properties.getProperty("DeviceName" + Machine);

		}
		catch (IOException e) {

		}

		return Device;

	}

	public String DemandePassword(String Machine) {
		// UserInterface UI = new UserInterface();
		// CheminFichierConfig = UI.DemandeCheminConfig();
		String Password = "";
		// String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
		Properties properties = new Properties();
		try {

			FileInputStream in = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(in);
			in.close();
			Password = properties.getProperty("password" + Machine);
			GestionEncryption SecuriteFichierConfig = new GestionEncryption();
			Password = SecuriteFichierConfig.DemandeDecryption(Password);

		}
		catch (IOException e) {
			e.getMessage();
			System.out.println("Erreur Encryption = " + e);
			// UserInterfaceConfig UicThreadvalidation = new
			// UserInterfaceConfig();
			// UicThreadvalidation.new ThreadValidationConfig().run();

		}

		return Password;

	}

	public String EcrireUser(String User, String Machine, String UserAEcrire) {
		// UserInterface UI = new UserInterface();
		// CheminFichierConfig = UI.DemandeCheminConfig();
		String ValidationEcriture = "";
		// String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
		Properties properties = new Properties();
		new File(CheminFichierConfig);
		FileInputStream stream;
		try {

			stream = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(stream);
			properties.setProperty(User + Machine, UserAEcrire);
			FileOutputStream oStream = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.store(oStream, "Fichier de configuration User/Pass/Paramètres est correctement enregistré");
			ValidationEcriture = "User pour " + Machine + " est correctement enregistré";
			oStream.close();
		}
		catch (FileNotFoundException e) {

			e.printStackTrace();
			ValidationEcriture = "Impossible de trouver le fichier : " + e;
		}
		catch (IOException e) {

			e.printStackTrace();
			ValidationEcriture = "Erreur lors de l'écriture du fichier : " + e;
		}

		return ValidationEcriture;

	}

	public String EcrirePassword(String Password, String Machine, String PasswordAEcrire) {
		// UserInterface UI = new UserInterface();
		// CheminFichierConfig = UI.DemandeCheminConfig();
		String ValidationEcriture = "";
		// String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
		Properties properties = new Properties();
		new File(RequeteChemin.DemandeChemin("CheminFichierConfig"));
		FileInputStream stream;
		try {
			GestionEncryption SecuriteFichierConfig = new GestionEncryption();
			PasswordAEcrire = SecuriteFichierConfig.DemandeEncryption(PasswordAEcrire);
			stream = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(stream);
			properties.setProperty(Password + Machine, PasswordAEcrire);
			FileOutputStream oStream = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.store(oStream, "Fichier de configuration User/Pass/Paramètres est correctement enregistré");
			ValidationEcriture = "Fichier correctement enregistré";
			oStream.close();
		}
		catch (FileNotFoundException e) {

			e.printStackTrace();
			ValidationEcriture = "Impossible de trouver le fichier : " + e;
		}
		catch (IOException e) {

			e.printStackTrace();
			ValidationEcriture = "Erreur lors de l'écriture du fichier : " + e;
		}

		return ValidationEcriture;

	}

	public String DemandeAutoConnect(String Machine) {

		String ResultatDemandeAutoConnect = "";

		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(in);
			in.close();
			ResultatDemandeAutoConnect = properties.getProperty("autoconnect" + Machine);

		}
		catch (IOException e) {

		}

		return ResultatDemandeAutoConnect;

	}

	public String EcrireAutoConnect(String autoconnect, String Machine, String AutoConnectAEcrire) {
		// UserInterface UI = new UserInterface();
		// CheminFichierConfig = UI.DemandeCheminConfig();
		String ValidationEcriture = "";
		// String CheminFichierConfig="D:\\AlphaPilote\\config.txt";
		Properties properties = new Properties();
		new File(RequeteChemin.DemandeChemin("CheminFichierConfig"));
		FileInputStream stream;
		try {

			stream = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(stream);
			properties.setProperty(autoconnect + Machine, AutoConnectAEcrire);
			FileOutputStream oStream = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.store(oStream, "Fichier de configuration User/Pass/Paramètres est correctement enregistré");
			ValidationEcriture = "Fichier correctement enregistré";
			oStream.close();
		}
		catch (FileNotFoundException e) {

			e.printStackTrace();
			ValidationEcriture = "Impossible de trouver le fichier : " + e;
		}
		catch (IOException e) {

			e.printStackTrace();
			ValidationEcriture = "Erreur lors de l'écriture du fichier : " + e;
		}

		return ValidationEcriture;

	}

	public String EcrireDefaultBrower(String Navigateur) {

		String ValidationEcriture = "";
		Properties properties = new Properties();
		new File(CheminFichierConfig);
		FileInputStream stream;
		try {

			stream = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(stream);
			properties.setProperty("DefaultBrowser", Navigateur);
			FileOutputStream oStream = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.store(oStream, "Fichier de configuration User/Pass/Paramètres est correctement enregistré");
			ValidationEcriture = "Le navigateur par défault " + Navigateur + " est correctement enregistré";
			oStream.close();
		}
		catch (FileNotFoundException e) {

			e.printStackTrace();
			ValidationEcriture = "Impossible de trouver le fichier : " + e;
		}
		catch (IOException e) {

			e.printStackTrace();
			ValidationEcriture = "Erreur lors de l'écriture du fichier : " + e;
		}

		return ValidationEcriture;

	}

	public String DemandeDefaultBrowser() {

		String ResultatDemande = "";
		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(in);
			in.close();
			ResultatDemande = properties.getProperty("DefaultBrowser");

		}
		catch (IOException e) {

		}

		return ResultatDemande;

	}

	public String EcrireChoixBoutonPosteComplet(String Produit, String Choix) {

		String ValidationEcriture = "";
		Properties properties = new Properties();
		new File(CheminFichierConfig);
		FileInputStream stream;
		try {

			stream = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(stream);
			properties.setProperty("BoutonLancePoste" + Produit, Choix);
			FileOutputStream oStream = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.store(oStream, "Fichier de configuration User/Pass/Paramètres est correctement enregistré");
			ValidationEcriture = "Le choix = " + Choix + " est correctement enregistré";
			oStream.close();
		}
		catch (FileNotFoundException e) {

			e.printStackTrace();
			ValidationEcriture = "Impossible de trouver le fichier : " + e;
		}
		catch (IOException e) {

			e.printStackTrace();
			ValidationEcriture = "Erreur lors de l'écriture du fichier : " + e;
		}

		return ValidationEcriture;

	}

	public String DemandeChoixBoutonPosteComplet(String Produit) {

		String ResultatDemande = "";
		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(in);
			in.close();
			ResultatDemande = properties.getProperty("BoutonLancePoste" + Produit);

		}
		catch (IOException e) {

		}

		return ResultatDemande;

	}

	public String DemandePremierLancement() {

		String ResultatDemande = "";
		Properties properties = new Properties();

		try {
			FileInputStream in = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(in);
			in.close();
			ResultatDemande = properties.getProperty("FirstLaunch");

		}
		catch (IOException e) {

		}

		return ResultatDemande;

	}

	public void ReOrderFichierConfig() {
		String inputFile = RequeteChemin.DemandeChemin("CheminFichierConfig");
		String outputFile = RequeteChemin.DemandeChemin("CheminFichierConfig");
		// Boolean ValideOrder = false;

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

		}
		catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void CheckPropertiesRaccourcis() throws IOException {

		Properties properties = new Properties();
		new File(CheminFichierConfig);

		try {
			FileInputStream in = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
			properties.load(in);

			in.close();
			if (properties.getProperty("RaccourciCapture") == null) {
				FileInputStream stream;
				stream = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
				properties.load(stream);
				properties.setProperty("RaccourciCapture", "x");
				FileOutputStream oStream = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
				properties.store(oStream, "Fichier de configuration User/Pass/Paramètres est correctement enregistré");
				stream.close();
				oStream.close();

			}
			if (properties.getProperty("RaccourciConnexion") == null) {
				FileInputStream stream;
				stream = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
				properties.load(stream);
				properties.setProperty("RaccourciConnexion", "v");
				FileOutputStream oStream = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
				properties.store(oStream, "Fichier de configuration User/Pass/Paramètres est correctement enregistré");
				stream.close();
				oStream.close();

			}
			if (properties.getProperty("RaccourciConsignes") == null) {
				FileInputStream stream;
				stream = new FileInputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
				properties.load(stream);
				properties.setProperty("RaccourciConsignes", "c");
				FileOutputStream oStream = new FileOutputStream(RequeteChemin.DemandeChemin("CheminFichierConfig"));
				properties.store(oStream, "Fichier de configuration User/Pass/Paramètres est correctement enregistré");
				stream.close();
				oStream.close();
			}
		}
		catch (IOException e) {

		}

	}

}

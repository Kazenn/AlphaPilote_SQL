
public class GestionChemin {
	
	

		
		public String DemandeChemin(String NomDemande)
		{
			
			String UserNameStation = "Username non reconnu";
			UserNameStation = System.getProperty("user.name");
			String CheminQuick3270 = "D:\\AlphaPilote\\Outils\\Quick3270\\Quick3270.exe";
			 String CheminPutty = "D:\\AlphaPilote\\Outils\\Putty\\Putty.exe";
			
			 String CheminFichierConfig ="D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\config.txt";
			 String CheminFichierLog ="D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\log.txt";
			 String CheminFichierMachine ="D:\\AlphaPilote\\Data\\machine.txt";
			
			 String CheminQuick3270ProfileGmvs = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\GMVS.ecf";
			 String CheminQuick3270MacroGmvs = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\GMVS.qmc";
			 String CheminQuick3270ProfileGmvs_no_auto_login = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\GMVS_no_auto_login.ecf";
			
			 String CheminQuick3270ProfileKmvs = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\KMVS.ecf";
			 String CheminQuick3270MacroKmvs = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\KMVS.qmc";
			 String CheminQuick3270ProfileKmvs_no_auto_login = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\KMVS_no_auto_login.ecf";
			
			 String CheminQuick3270ProfileZmvs = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\ZMVS.ecf";
			 String CheminQuick3270MacroZmvs = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\Zmvs.qmc";
			 String CheminQuick3270ProfileZmvs_no_auto_login = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\ZMVS_no_auto_login.ecf";
			
			 String CheminQuick3270ProfileSysa = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\Sysa.ecf";
			 String CheminQuick3270MacroSysa = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\Sysa.qmc";
			 String CheminQuick3270ProfileSysa_no_auto_login = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\Sysa_no_auto_login.ecf";
			
			 String CheminQuick3270ProfileSysg = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\Sysg.ecf";
			 String CheminQuick3270MacroSysg = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\Sysg.qmc";
			 String CheminQuick3270ProfileSysg_no_auto_login = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\Sysg_no_auto_login.ecf";
			
			 String CheminQuick3270ProfileGeneral = "D:\\AlphaPilote\\Profiles\\"+UserNameStation+"\\";
	
			String ResultatChemin = "Impossible de trouver le chemin";
			
			String Chemin = NomDemande;
			switch (Chemin)
			{
			case "CheminQuick3270":
				ResultatChemin = CheminQuick3270;
				break;
			case "CheminPutty":
				ResultatChemin = CheminPutty;
				break;
				
			case "CheminFichierConfig":
				ResultatChemin = CheminFichierConfig;
				break;
			case "CheminFichierLog":
				ResultatChemin = CheminFichierLog;
				break;
			case "CheminFichierMachine":
				ResultatChemin = CheminFichierMachine;
			    break;
			    
			case "CheminQuick3270ProfileGmvs":
				ResultatChemin = CheminQuick3270ProfileGmvs;
				break;
			case "CheminQuick3270MacroGmvs":
				ResultatChemin = CheminQuick3270MacroGmvs;
				break;
			case "CheminQuick3270ProfileGmvs_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileGmvs_no_auto_login;
				break;
				
			case "CheminQuick3270ProfileKmvs":
				ResultatChemin = CheminQuick3270ProfileKmvs;
				break;
			case "CheminQuick3270MacroKmvs":
				ResultatChemin = CheminQuick3270MacroKmvs;
				break;
			case "CheminQuick3270ProfileKmvs_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileKmvs_no_auto_login;
				break;
			case "CheminQuick3270ProfileZmvs":
				ResultatChemin = CheminQuick3270ProfileZmvs;
				break;
			case "CheminQuick3270MacroZmvs":
				ResultatChemin = CheminQuick3270MacroZmvs;
				break;
			case "CheminQuick3270ProfileZmvs_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileZmvs_no_auto_login;
				break;
			
			case "CheminQuick3270ProfileSysa":
				ResultatChemin = CheminQuick3270ProfileSysa;
				break;
			case "CheminQuick3270MacroSysa":
				ResultatChemin = CheminQuick3270MacroSysa;
				break;
			case "CheminQuick3270ProfileSysa_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileSysa_no_auto_login;
				break;
			
			case "CheminQuick3270ProfileSysg":
				ResultatChemin = CheminQuick3270ProfileSysg;
				break;
			case "CheminQuick3270MacroSysg":
				ResultatChemin = CheminQuick3270MacroSysg;
				break;
			case "CheminQuick3270ProfileSysg_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileSysg_no_auto_login;
				break;
			case "CheminQuick3270ProfileGeneral":
				ResultatChemin = CheminQuick3270ProfileGeneral;
				break;
			
			}
	
			return ResultatChemin;
			 
		}

}

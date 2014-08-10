import java.io.File;
import java.net.URISyntaxException;
import java.net.URLDecoder;


public class GestionChemin {
	
	

		
		public String DemandeChemin(String NomDemande)
		{
			
			String UserNameStation = "Username non reconnu";
			UserNameStation = System.getProperty("user.name");
			
			 String CheminQuick3270 = "C:\\Program Files (x86)\\Quick3270 Secure\\Quick3270.exe";
			 String CheminPutty = "C:\\APPLI_OPT\\Putty\\Putty.exe";
			 String CheminOutlook = "C:\\Program Files (x86)\\Microsoft Office\\Office14\\OUTLOOK.EXE";
			 String CheminControlm ="C:\\Program Files (x86)\\BMC Software\\CONTROL-M EM 6.4.01\\Default\\bin\\emgui.exe";
			 String CheminIprox = "C:\\Users\\"+UserNameStation+"\\Desktop\\Portail IPROX GCT.ica";
			 String CheminAutomator = "C:\\Program Files (x86)\\AUTOMATOR_IHM_350\\GUI\\OPSchedule.bat";
			 String CheminArsRemedy = "C:\\Program Files (x86)\\AR System\\User\\aruser.exe";
			 
			 
			 
			 String CheminGeneralProjet = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Profiles\\";
			
			 String CheminFichierConfig =CheminGeneralProjet+UserNameStation+"\\config.txt";
			 String CheminFichierLog =CheminGeneralProjet+UserNameStation+"\\log.txt";
			 String CheminFichierMachine = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Data\\machine.txt";
			 //String CheminFichierMachine = "D:\\AlphaPilote\\Data\\machine.txt";
			 
			 String CheminQuick3270ProfileGmvs = CheminGeneralProjet+UserNameStation+"\\GMVS.ecf";
			 String CheminQuick3270MacroGmvs = CheminGeneralProjet+UserNameStation+"\\GMVS.qmc";
			 String CheminQuick3270ProfileGmvs_no_auto_login = CheminGeneralProjet+UserNameStation+"\\GMVS_no_auto_login.ecf";
			
			 String CheminQuick3270ProfileKmvs = CheminGeneralProjet+UserNameStation+"\\KMVS.ecf";
			 String CheminQuick3270MacroKmvs = CheminGeneralProjet+UserNameStation+"\\KMVS.qmc";
			 String CheminQuick3270ProfileKmvs_no_auto_login = CheminGeneralProjet+UserNameStation+"\\KMVS_no_auto_login.ecf";
			
			 String CheminQuick3270ProfileZmvs = CheminGeneralProjet+UserNameStation+"\\ZMVS.ecf";
			 String CheminQuick3270MacroZmvs = CheminGeneralProjet+UserNameStation+"\\Zmvs.qmc";
			 String CheminQuick3270ProfileZmvs_no_auto_login = CheminGeneralProjet+UserNameStation+"\\ZMVS_no_auto_login.ecf";
			
			 String CheminQuick3270ProfileSysa = CheminGeneralProjet+UserNameStation+"\\Sysa.ecf";
			 String CheminQuick3270MacroSysa = CheminGeneralProjet+UserNameStation+"\\Sysa.qmc";
			 String CheminQuick3270ProfileSysa_no_auto_login = CheminGeneralProjet+UserNameStation+"\\Sysa_no_auto_login.ecf";
			
			 String CheminQuick3270ProfileSysg = CheminGeneralProjet+UserNameStation+"\\Sysg.ecf";
			 String CheminQuick3270MacroSysg = CheminGeneralProjet+UserNameStation+"\\Sysg.qmc";
			 String CheminQuick3270ProfileSysg_no_auto_login = CheminGeneralProjet+UserNameStation+"\\Sysg_no_auto_login.ecf";
			
			 String CheminQuick3270ProfileGeneral = CheminGeneralProjet+UserNameStation+"\\";
			 String CheminProfileStationGeneral= CheminGeneralProjet+UserNameStation+"\\";
			 
			 String CheminProfileStationVierge = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Profiles\\Config_New_Profile";
			 //String CheminProfileIprox = CheminGeneralProjet+UserNameStation;
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
				ResultatChemin = CheminFichierMachine ;
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
			case "CheminProfileStationGeneral":
				ResultatChemin = CheminProfileStationGeneral;
				break;
			case "CheminProfileStationVierge":
				ResultatChemin = CheminProfileStationVierge;
				break;
			case "CheminIprox":
				ResultatChemin = CheminIprox;
				break;
			case "CheminControlm":
				ResultatChemin = CheminControlm;
				break;
			case "CheminOutlook":
				ResultatChemin = CheminOutlook;
				break;
			case "CheminArsRemedy":
				ResultatChemin = CheminArsRemedy;
				break;
				
			
			
			}
	
			return ResultatChemin;
			 
		}

}

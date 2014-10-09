import java.io.IOException;
import java.sql.Connection;

public class GestionProduits {
	GestionLog MaLog = new GestionLog();
	GestionChemin Chemin = new GestionChemin();
	GestionSql LaBase = new GestionSql();
	Connection ConnectionBase = LaBase.InitConnexion();
	GestionProfile Profile = new GestionProfile();
	SuperLog SL = new SuperLog();
	String UserNameStation = System.getProperty("user.name");
	String Navigateur = "";
	Boolean RetourLancement = null;
	GestionSessions Session = new GestionSessions();

	public String SelectionneNavigateur() {

		Navigateur = LaBase.ConsulterBrowserPilote(ConnectionBase);
		switch (Navigateur) {
			case "Google Chrome":
				Navigateur = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
				break;
			case "Mozilla Firefox":
				Navigateur = "C:\\Users\\" + UserNameStation + "\\AppData\\Local\\Mozilla Firefox\\firefox.exe";
				break;
			case "Internet Explorer":
				Navigateur = "C:\\Program Files\\Internet Explorer\\iexplore.exe";
				break;
			default:
				Navigateur = "C:\\Users\\" + UserNameStation + "\\AppData\\Local\\Mozilla Firefox\\firefox.exe";
				break;

		}
		return Navigateur;
	}

	public Boolean LanceCapture() {
		SL.EcrireSuperLog("Capture");

		ProcessBuilder builder = new ProcessBuilder(new String[] { "C:\\Windows\\system32\\SnippingTool.exe" });
		try {
			builder.start();
			RetourLancement = true;
		}
		catch (IOException e) {

			e.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de l'outil Capture : " + e);
			RetourLancement = false;

		}
		return RetourLancement;

	}

	public Boolean LancePutty() {
		SL.EcrireSuperLog("Putty");
		ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminPutty") });
		try {
			builder.start();
			RetourLancement = true;
		}
		catch (IOException e) {

			e.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de putty : " + e);
			RetourLancement = false;

		}
		return RetourLancement;
	}

	public Boolean LanceOutlook() {
		SL.EcrireSuperLog("Outlook");

		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminOutlook") + " /recycle"));
			RetourLancement = true;
		}
		catch (IOException e) {

			e.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'Outlook: " + e);
			RetourLancement = false;

		}
		return RetourLancement;

	}

	public Boolean LanceControlm() throws IOException {
		SL.EcrireSuperLog("Controlm");
		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminControlm") + " -u PiloteGo -p goatos -m kaji -vp \"All Jobs\""));
			RetourLancement = true;
		}
		catch (IOException e) {
			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceIprox() {
		SL.EcrireSuperLog("Iprox");

		ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Chemin.DemandeChemin("CheminIprox"));
		try {
			pb.start();
			RetourLancement = true;
		}
		catch (IOException e) {

			e.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'Iprox : " + e);
			RetourLancement = false;

		}
		return RetourLancement;
	}

	public Boolean LanceArsRemedy() {
		SL.EcrireSuperLog("Ars Remedy v7");

		try {
			String UserWindows = LaBase.ConsulterUserPilote(ConnectionBase, "Windows");
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminArsRemedy") + " -user=\"" + UserWindows.toUpperCase() + "\""));
			RetourLancement = true;
		}
		catch (IOException e) {

			e.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'ARS-Remedy v7 : " + e);
			RetourLancement = false;

		}
		return RetourLancement;
	}

	public Boolean LancePuttyCm() {
		SL.EcrireSuperLog("Putty CM");

		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminPuttyCm")));
			RetourLancement = true;
		}
		catch (IOException e) {
			e.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Putty Connection Manager : " + e);
			RetourLancement = false;

		}
		return RetourLancement;

	}

	public Boolean LanceExceed() {
		SL.EcrireSuperLog("Exceed");

		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminExceed")));
			RetourLancement = true;
		}
		catch (IOException e) {
			e.printStackTrace();

			MaLog.EcrireDansFichierLog("Erreur au lancement d'exceed : " + e);
			RetourLancement = false;

		}
		return RetourLancement;

	}

	public Boolean LanceMremote() {
		SL.EcrireSuperLog("mremote");

		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminMremote")));
			RetourLancement = true;
		}
		catch (IOException e) {
			e.printStackTrace();

			MaLog.EcrireDansFichierLog("Erreur au lancement d'mremote : " + e);
			RetourLancement = false;

		}
		return RetourLancement;
	}

	public Boolean LancePartageIprox() {
		SL.EcrireSuperLog("Partage Iprox");

		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminPartageIprox")));
			RetourLancement = true;
		}
		catch (IOException e) {
			e.printStackTrace();

			MaLog.EcrireDansFichierLog("Erreur au lancement du partage Iprox : " + e);
			RetourLancement = false;

		}
		return RetourLancement;
	}

	public Boolean LanceTinaCltec5() {
		SL.EcrireSuperLog("Tina web cltec 5");

		GestionProfile ModifProfileTina = new GestionProfile();
		try {
			ModifProfileTina.ModifierIpTina("tina.txt");
			Runtime.getRuntime().exec(
					String.format(Chemin.DemandeChemin("CheminPutty") + " -ssh root@126.40.230.16 -pw cpnonart -m " + "\"" + Chemin.DemandeChemin("CheminTinaMacro") + "tina.txt" + "\""));
			RetourLancement = true;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			MaLog.EcrireDansFichierLog("Erreur au lancement de Tina Cltec5: " + e);
			RetourLancement = false;

		}
		return RetourLancement;

	}

	public Boolean LanceTinaCltec6() {
		SL.EcrireSuperLog("Tina web cltec 6");

		GestionProfile ModifProfileTina = new GestionProfile();
		try {
			ModifProfileTina.ModifierIpTina("tina.txt");
			Runtime.getRuntime().exec(
					String.format(Chemin.DemandeChemin("CheminPutty") + " -ssh root@126.196.96.22 -pw bullbull -m " + "\"" + Chemin.DemandeChemin("CheminTinaMacro") + "tina.txt" + "\""));
			RetourLancement = true;
		}
		catch (IOException e) {

			e.printStackTrace();

			MaLog.EcrireDansFichierLog("Erreur au lancement de Tina Cltec6: " + e);
			RetourLancement = false;

		}
		return RetourLancement;
	}

	public Boolean LanceVtomIp1q() {
		SL.EcrireSuperLog("Vtom ip1 J");

		String UserWindows = "";
		String PassWindows = "";
		UserWindows = LaBase.ConsulterUserPilote(ConnectionBase, "Windows");
		PassWindows = LaBase.ConsulterPasswordPilote(ConnectionBase, "Windows");

		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminVtom") + " -u " + UserWindows + " -p " + PassWindows + " -s UP2TO002:30017 " + " -d Pilote"));
			RetourLancement = true;
		}
		catch (IOException e) {
			RetourLancement = false;
			e.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de VtomIp1q: " + e);
		}
		return RetourLancement;
	}

	public Boolean LanceVtomIp1d() {
		SL.EcrireSuperLog("Vtom Ip1 D");

		String UserWindows = "";
		String PassWindows = "";
		UserWindows = LaBase.ConsulterUserPilote(ConnectionBase, "Windows");
		PassWindows = LaBase.ConsulterPasswordPilote(ConnectionBase, "Windows");

		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminVtom") + " -u " + UserWindows + " -p " + PassWindows + " -s UP2TO003:30017 " + " -d Pilote"));
			RetourLancement = true;
		}
		catch (IOException e) {
			RetourLancement = false;
			e.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de VtomIp1d: " + e);
		}
		return RetourLancement;
	}

	public Boolean LanceVtomIp2q() {
		SL.EcrireSuperLog("Vtom IP2 J");

		String UserWindows = "";
		String PassWindows = "";
		UserWindows = LaBase.ConsulterUserPilote(ConnectionBase, "Windows");
		PassWindows = LaBase.ConsulterPasswordPilote(ConnectionBase, "Windows");

		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminVtom") + " -u " + UserWindows + " -p " + PassWindows + " -s UP1TO002:30117 " + " -d Pilote"));
			RetourLancement = true;
		}
		catch (IOException e) {
			e.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de VtomIp2q: " + e);
			RetourLancement = false;
		}
		return RetourLancement;
	}

	public Boolean LanceVtomIp2d() {
		SL.EcrireSuperLog("Vtom IP2 D");

		String UserWindows = "";
		String PassWindows = "";
		UserWindows = LaBase.ConsulterUserPilote(ConnectionBase, "Windows");
		PassWindows = LaBase.ConsulterPasswordPilote(ConnectionBase, "Windows");

		try {
			Runtime.getRuntime().exec(String.format(Chemin.DemandeChemin("CheminVtom") + " -u " + UserWindows + " -p " + PassWindows + " -s UP1TO003:30117 " + " -d Pilote"));
			RetourLancement = true;
		}
		catch (IOException e) {
			e.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de VtomIp2d: " + e);
			RetourLancement = false;
		}
		return RetourLancement;
	}

	public Boolean LanceZmvs() {
		SL.EcrireSuperLog("Zmvs");

		try {

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Zmvs").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileZmvs") });
				builder.start();
				RetourLancement = true;

			}

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Zmvs").equals("true") == false) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileZmvs_no_auto_login") });
				builder.start();
				RetourLancement = true;

			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour ZMVS : " + e1);
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceSysa() {
		SL.EcrireSuperLog("Sysa");

		try {

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Sysa").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileSysa") });
				builder.start();
				RetourLancement = true;
			}

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Sysa").equals("true") == false) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileSysa_no_auto_login") });
				builder.start();
				RetourLancement = true;
			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Quick3270 pour Sysa : " + e1);
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceKmvs() {
		SL.EcrireSuperLog("KMVS");

		try {

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Kmvs").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileKmvs") });
				builder.start();
				RetourLancement = true;
			}

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Kmvs").equals("true") == false) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileKmvs_no_auto_login") });
				builder.start();
				RetourLancement = true;
			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour KMVS : " + e1);
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceSysg()

	{
		SL.EcrireSuperLog("SysG");
		try {

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Sysa").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileSysg") });
				builder.start();
				RetourLancement = true;
			}

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Sysa").equals("true") == false) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileSysg_no_auto_login") });
				builder.start();
				RetourLancement = true;
			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour Sysg : " + e1);
			RetourLancement = false;
		}
		return RetourLancement;
	}

	public Boolean LanceGmvs() {
		SL.EcrireSuperLog("Gmvs");

		try {

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Gmvs").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileGmvs") });
				builder.start();
				RetourLancement = true;
			}

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Gmvs").equals("true") == false) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileGmvs_no_auto_login") });
				builder.start();
				RetourLancement = true;
			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour GMVS : " + e1);
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceBmvs() {
		SL.EcrireSuperLog("Bmvs");

		try {

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Bmvs").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileBmvs") });
				builder.start();
				RetourLancement = true;
			}

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Bmvs").equals("false") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileBmvs_no_auto_login") });
				builder.start();
				RetourLancement = true;
			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour Bmvs : " + e1);
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceIp1() {
		SL.EcrireSuperLog("MVS IP1");

		try {

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Ip1").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileIp1") });
				builder.start();
				RetourLancement = true;
			}

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Ip1").equals("false") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileIp1_no_auto_login") });
				builder.start();
				RetourLancement = true;
			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour Ip1 : " + e1);
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceIp3() {
		SL.EcrireSuperLog("MVS IP3");

		try {

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Ip3").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileIp3") });
				builder.start();
				RetourLancement = true;
			}

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Ip3").equals("false") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileIp3_no_auto_login") });
				builder.start();
				RetourLancement = true;
			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour Ip3 : " + e1);
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceIp2() {
		SL.EcrireSuperLog("MVS IP2");

		try {

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Ip2").equals("true") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileIp2") });
				builder.start();
				RetourLancement = true;
			}

			if (LaBase.ConsulterAutoconnectPilote(ConnectionBase, "Ip2").equals("false") == true) {

				ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileIp2_no_auto_login") });
				builder.start();
				RetourLancement = true;
			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour Ip2 : " + e1);
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceAs400Br() {
		SL.EcrireSuperLog("AS400 BR");

		try {
			ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileBr") });
			builder.start();
			RetourLancement = true;

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour BRCLY : " + e1);
			RetourLancement = false;

		}
		return RetourLancement;
	}

	public Boolean LanceAs400Bdi() {
		SL.EcrireSuperLog("AS400 BDI");

		try {
			ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileBdi") });
			builder.start();
			RetourLancement = true;

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour BDICLY : " + e1);
			RetourLancement = false;

		}
		return RetourLancement;
	}

	public Boolean LanceAs400Bdaf() {
		SL.EcrireSuperLog("AS400 BDAF");

		try {
			ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileBdaf") });
			builder.start();
			RetourLancement = true;

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour BDAFCLY : " + e1);
			RetourLancement = false;

		}
		return RetourLancement;
	}

	public Boolean LanceAs400Pfb() {
		SL.EcrireSuperLog("AS400 PFB");

		try {
			ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfilePfb") });
			builder.start();
			RetourLancement = true;

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour PFBCLY : " + e1);
			RetourLancement = false;

		}
		return RetourLancement;
	}

	public Boolean LanceAs400Socly() {
		SL.EcrireSuperLog("AS400 Socly");

		try {
			ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileSocly") });
			builder.start();
			RetourLancement = true;

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour SOCLY : " + e1);
			RetourLancement = false;

		}
		return RetourLancement;
	}

	public Boolean LanceAs400Socmcsd() {
		SL.EcrireSuperLog("AS400 Socmcsd");

		try {
			ProcessBuilder builder = new ProcessBuilder(new String[] { Chemin.DemandeChemin("CheminQuick3270"), Chemin.DemandeChemin("CheminQuick3270ProfileSocmcsd") });
			builder.start();
			RetourLancement = true;

		}
		catch (IOException e1) {
			e1.printStackTrace();
			MaLog.EcrireDansFichierLog("Erreur au lancement de quick3270 pour SOCMCSD : " + e1);
			RetourLancement = false;

		}
		return RetourLancement;
	}

	public Boolean LanceOdip() {
		SL.EcrireSuperLog("ODIP");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://pilotage-upfc.supragrp.caisse-epargne.fr/pilotage/showChecklistAction.action");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'ODIP : " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceBbr() {
		SL.EcrireSuperLog("BBR");
		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "",
					"http://hypervision-presentation.sigce.caisse-epargne.fr:8080/MeteoServices/faces/custom/pages/moduleWVA/sd_macroView.jsp?wall=false");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de BBR : " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;
	}

	public Boolean LanceIpLabel() {
		SL.EcrireSuperLog("IP-Label");
		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://gx.ip-label.net/client/Section3_1/");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'Ip-Label: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;
	}

	public Boolean LanceNewtest() {
		SL.EcrireSuperLog("Newtest");
		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://newtest_prod/NMC/Supervision/StatusMonitoring.aspx");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Newtest: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;
	}

	public Boolean LanceOseIp1() {
		SL.EcrireSuperLog("OSE IP1");
		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://oseserv.siris.caisse-epargne.fr:8080/cgi-bin/etatserv.exe?sit=MAIL&totm=oui&pag=MA_ALL11&rfh=oui");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'OSE ip1: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;
	}

	public Boolean LanceOseIp2() {
		SL.EcrireSuperLog("OSE IP2");
		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://oseserv.sigce.caisse-epargne.fr:8080/cgi-bin/etatserv.exe?sit=MAIL&totm=oui&pag=MA_ALL11&rfh=oui");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'OSE ip2: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;
	}

	public Boolean LanceXguard() {
		SL.EcrireSuperLog("Xguard");
		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://pilotage-xg.supragrp.caisse-epargne.fr/ihmxgd/web/app.php");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'Xguard: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;
	}

	public Boolean LanceHmc() {
		SL.EcrireSuperLog("HMC");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "https://126.199.169.23/preloginmonitor/index.jsp");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de la HMC : " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceKvm() {
		SL.EcrireSuperLog("KVM");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "https://dsview.gtm.caisse-epargne.fr/dsview/protected/login.do");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de la page KVM: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceTina5() {
		SL.EcrireSuperLog("Tina 5");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://126.40.230.16:25088/tina");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de la page TINA Cltec5: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceTina6() {
		SL.EcrireSuperLog("Tina 6");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://126.196.96.22:25088/tina");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de la page TINA Cltec6: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceVcenter() {
		SL.EcrireSuperLog("Vcenter");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "https://vcenterweb.sigce.caisse-epargne.fr:9443/vsphere-client/?locale=en_US");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Vcenter (VM): " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceSismoIp1() {
		SL.EcrireSuperLog("Sismo IP1");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://126.196.230.23/env1.etat.technique.php");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Sismo IP1: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceSismoIp2() {
		SL.EcrireSuperLog("Sismo IP2");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://126.196.224.12/env1.etat.technique.php");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Sismo IP2: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceSismoOceor() {
		SL.EcrireSuperLog("Sismo Oceor");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://126.196.230.61/env1.etat.technique.php");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Sismo Oceor: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceSismoPalatine() {
		SL.EcrireSuperLog("Sismo Palatine");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://up5bd010/sismocdFIL.php");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Sismo Palatine: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceArsV8() {
		SL.EcrireSuperLog("ARS v8 web");
		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "",
					"http://arsv8.sigce.caisse-epargne.fr/arsys/forms/arsv8-ppr/SHR%3ALandingConsole/Default+Administrator+View/?cacheid=28c87c35");
			pb.start();

			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement d'ARS v8: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceWebIas() {
		SL.EcrireSuperLog("Web IAS");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://ias3.supragrp.caisse-epargne.fr");
			pb.start();

			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de Web IAS: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceCfta() {
		SL.EcrireSuperLog("CFTA");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://sysa:3578/");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de CFTA: " + e);

			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceCftacore() {
		SL.EcrireSuperLog("CFTACORE");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://sysa:3579/");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de CFTACORE: " + e);
			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

	public Boolean LanceArsCff() {
		SL.EcrireSuperLog("ARS CFF");

		String Navigateur = SelectionneNavigateur();

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", " start", "/C", Navigateur, "", "http://126.238.65.2:8080/arsys/shared/login.jsp?/arsys/");
			pb.start();
			RetourLancement = true;

		}
		catch (IOException e) {
			GestionLog MaLog = new GestionLog();
			MaLog.EcrireDansFichierLog("Erreur au lancement de l'ARS CFF: " + e);
			e.printStackTrace();
			RetourLancement = false;
		}
		return RetourLancement;

	}

}

import java.io.IOException;

public class GestionProduits {
	GestionLog MaLog = new GestionLog();
	GestionChemin Chemin = new GestionChemin();
	GestionConfig GC = new GestionConfig();
	Boolean RetourLancement = null;

	public Boolean LanceCapture() {

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

		try {
			String UserWindows = GC.DemandeUser("Windows");
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

	public Boolean LanceTinaCltec5() {

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

}

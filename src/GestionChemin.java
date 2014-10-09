public class GestionChemin {

	public String DemandeChemin(String NomDemande) {

		GestionSessions Sessions = new GestionSessions();
		int Session = Sessions.LireSession();
		String UserNameStation = "Username non reconnu";
		UserNameStation = System.getProperty("user.name");

		String CheminQuick3270 = "C:\\Program Files (x86)\\Quick3270 Secure\\Quick3270.exe";
		String CheminPutty = "C:\\APPLI_OPT\\Putty\\Putty.exe";
		String CheminOutlook = "C:\\Program Files (x86)\\Microsoft Office\\Office14\\OUTLOOK.EXE";
		String CheminControlm = "C:\\Program Files (x86)\\BMC Software\\CONTROL-M EM 6.4.01\\Default\\bin\\emgui.exe";
		String CheminIprox = "C:\\Users\\" + UserNameStation + "\\Desktop\\Portail IPROX GCT.ica";
		String CheminArsRemedy = "C:\\Program Files (x86)\\AR System\\User\\aruser.exe";
		String CheminPuttyCm = "C:\\APPLI_OPT\\PuttyCM\\puttycm.exe";
		String CheminVtom = "C:\\Program Files (x86)\\VTOM5\\VISUAL\\VtomXvision.exe";
		String CheminExceed = "C:\\Program Files (x86)\\Hummingbird\\Connectivity\\9.00\\Exceed\\exceed.exe";
		String CheminMremote = "C:\\Program Files (x86)\\mRemote\\mRemote.exe";
		String CheminPartageIprox = "C:\\OUTILS\\PartageIprox.exe";
		String CheminGeneralProjet = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Profiles\\";

		String BaseDeDonnee = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Data\\BaseProfile.db";
		String CheminFichierLog = CheminGeneralProjet + UserNameStation + "\\log.txt";
		String CheminFichierSuperLog = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Data\\log\\" + "log.txt";
		String CheminTinaMacro = CheminGeneralProjet + UserNameStation + "\\";
		String CheminFichierFavoris = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Data\\favoris.txt";
		String CheminFichierTemp = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Data\\temp.txt";
		String CheminFichierTemp2 = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Data\\temp2.txt";
		String CheminFichierMachine = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Data\\machine.txt";

		String CheminQuick3270ProfileGmvs = CheminGeneralProjet + UserNameStation + "\\GMVS.ecf";
		String CheminQuick3270MacroGmvs = CheminGeneralProjet + UserNameStation + "\\GMVS.qmc";
		String CheminQuick3270ProfileGmvs_no_auto_login = CheminGeneralProjet + UserNameStation + "\\GMVS_no_auto_login.ecf";

		String CheminQuick3270ProfileKmvs = CheminGeneralProjet + UserNameStation + "\\KMVS.ecf";
		String CheminQuick3270MacroKmvs = CheminGeneralProjet + UserNameStation + "\\KMVS.qmc";
		String CheminQuick3270ProfileKmvs_no_auto_login = CheminGeneralProjet + UserNameStation + "\\KMVS_no_auto_login.ecf";

		String CheminQuick3270ProfileZmvs = CheminGeneralProjet + UserNameStation + "\\ZMVS.ecf";
		String CheminQuick3270MacroZmvs = CheminGeneralProjet + UserNameStation + "\\Zmvs.qmc";
		String CheminQuick3270ProfileZmvs_no_auto_login = CheminGeneralProjet + UserNameStation + "\\ZMVS_no_auto_login.ecf";

		String CheminQuick3270ProfileSysa = CheminGeneralProjet + UserNameStation + "\\Sysa.ecf";
		String CheminQuick3270MacroSysa = CheminGeneralProjet + UserNameStation + "\\Sysa.qmc";
		String CheminQuick3270ProfileSysa_no_auto_login = CheminGeneralProjet + UserNameStation + "\\Sysa_no_auto_login.ecf";

		String CheminQuick3270ProfileSysg = CheminGeneralProjet + UserNameStation + "\\Sysg.ecf";
		String CheminQuick3270MacroSysg = CheminGeneralProjet + UserNameStation + "\\Sysg.qmc";
		String CheminQuick3270ProfileSysg_no_auto_login = CheminGeneralProjet + UserNameStation + "\\Sysg_no_auto_login.ecf";

		String CheminQuick3270ProfileBmvs = CheminGeneralProjet + UserNameStation + "\\BMVS.ecf";
		String CheminQuick3270MacroBmvs = CheminGeneralProjet + UserNameStation + "\\BMVS.ecf";
		String CheminQuick3270ProfileBmvs_no_auto_login = CheminGeneralProjet + UserNameStation + "\\Bmvs_no_auto_login.ecf";

		String CheminQuick3270ProfileIp1 = CheminGeneralProjet + UserNameStation + "\\IP1.ecf";
		String CheminQuick3270MacroIp1 = CheminGeneralProjet + UserNameStation + "\\IP1.qmc";
		String CheminQuick3270ProfileIp1_no_auto_login = CheminGeneralProjet + UserNameStation + "\\Ip1_no_auto_login.ecf";

		String CheminQuick3270ProfileIp2 = CheminGeneralProjet + UserNameStation + "\\IP2.ecf";
		String CheminQuick3270MacroIp2 = CheminGeneralProjet + UserNameStation + "\\IP2.qmc";
		String CheminQuick3270ProfileIp2_no_auto_login = CheminGeneralProjet + UserNameStation + "\\Ip2_no_auto_login.ecf";

		String CheminQuick3270ProfileIp3 = CheminGeneralProjet + UserNameStation + "\\IP3.ecf";
		String CheminQuick3270MacroIp3 = CheminGeneralProjet + UserNameStation + "\\IP3.qmc";
		String CheminQuick3270ProfileIp3_no_auto_login = CheminGeneralProjet + UserNameStation + "\\Ip3_no_auto_login.ecf";

		// AS400

		String CheminQuick3270ProfileBr = CheminGeneralProjet + UserNameStation + "\\BRCLY.ecf";
		String CheminQuick3270MacroBr = CheminGeneralProjet + UserNameStation + "\\BRCLY.qmc";

		String CheminQuick3270ProfileBdi = CheminGeneralProjet + UserNameStation + "\\BDICLY.ecf";
		String CheminQuick3270MacroBdi = CheminGeneralProjet + UserNameStation + "\\BDICLY.qmc";

		String CheminQuick3270ProfileBdaf = CheminGeneralProjet + UserNameStation + "\\BDAFCLY.ecf";
		String CheminQuick3270MacroBdaf = CheminGeneralProjet + UserNameStation + "\\BDAFCLY.qmc";

		String CheminQuick3270ProfilePfb = CheminGeneralProjet + UserNameStation + "\\PFBCLY.ecf";
		String CheminQuick3270MacroPfb = CheminGeneralProjet + UserNameStation + "\\PFBCLY.qmc";

		String CheminQuick3270ProfileSocly = CheminGeneralProjet + UserNameStation + "\\SOCLY.ecf";
		String CheminQuick3270MacroSocly = CheminGeneralProjet + UserNameStation + "\\SOCLY.qmc";

		String CheminQuick3270ProfileSocmcsd = CheminGeneralProjet + UserNameStation + "\\SOCMCSD.ecf";
		String CheminQuick3270MacroSocmcsd = CheminGeneralProjet + UserNameStation + "\\SOCMCSD.qmc";

		// -- AS400 --

		// SESSIONS BLR

		String CheminQuick3270ProfileGmvs_2 = CheminGeneralProjet + UserNameStation + "\\GMVS_2.ecf";
		String CheminQuick3270ProfileKmvs_2 = CheminGeneralProjet + UserNameStation + "\\KMVS_2.ecf";
		String CheminQuick3270ProfileZmvs_2 = CheminGeneralProjet + UserNameStation + "\\ZMVS_2.ecf";
		String CheminQuick3270ProfileSysa_2 = CheminGeneralProjet + UserNameStation + "\\Sysa_2.ecf";
		String CheminQuick3270ProfileSysg_2 = CheminGeneralProjet + UserNameStation + "\\Sysg_2.ecf";
		String CheminQuick3270ProfileBmvs_2 = CheminGeneralProjet + UserNameStation + "\\BMVS_2.ecf";
		String CheminQuick3270ProfileIp1_2 = CheminGeneralProjet + UserNameStation + "\\IP1_2.ecf";
		String CheminQuick3270ProfileIp2_2 = CheminGeneralProjet + UserNameStation + "\\IP2_2.ecf";
		String CheminQuick3270ProfileIp3_2 = CheminGeneralProjet + UserNameStation + "\\IP3_2.ecf";

		String CheminQuick3270ProfileBr_2 = CheminGeneralProjet + UserNameStation + "\\BRCLY_2.ecf";
		String CheminQuick3270ProfileBdi_2 = CheminGeneralProjet + UserNameStation + "\\BDICLY_2.ecf";
		String CheminQuick3270ProfileBdaf_2 = CheminGeneralProjet + UserNameStation + "\\BDAFCLY_2.ecf";
		String CheminQuick3270ProfilePfb_2 = CheminGeneralProjet + UserNameStation + "\\PFBCLY_2.ecf";
		String CheminQuick3270ProfileSocly_2 = CheminGeneralProjet + UserNameStation + "\\SOCLY_2.ecf";
		String CheminQuick3270ProfileSocmcsd_2 = CheminGeneralProjet + UserNameStation + "\\SOCMCSD_2.ecf";

		// ----- BLR -----

		String CheminQuick3270ProfileGeneral = CheminGeneralProjet + UserNameStation + "\\";
		String CheminProfileStationGeneral = CheminGeneralProjet + UserNameStation + "\\";

		String CheminProfileStationVierge = "\\\\fsitceti\\entites\\ITC PPR-EDC-PIL-724 ETI\\Pilotage Mutualise\\Sauvegarde Olive&Pascal\\Outils de pilotage\\Alphapilote\\Profiles\\Config_New_Profile";
		// String CheminProfileIprox = CheminGeneralProjet+UserNameStation;
		String ResultatChemin = "Impossible de trouver le chemin";

		String Chemin = NomDemande;
		switch (Chemin) {
			case "CheminQuick3270":
				ResultatChemin = CheminQuick3270;
				break;
			case "CheminPutty":
				ResultatChemin = CheminPutty;
				break;

			case "BaseDeDonnee":
				ResultatChemin = BaseDeDonnee;
				break;
			case "CheminFichierLog":
				ResultatChemin = CheminFichierLog;
				break;
			case "CheminFichierSuperLog":
				ResultatChemin = CheminFichierSuperLog;
				break;
			case "CheminFichierMachine":
				ResultatChemin = CheminFichierMachine;
				break;
			case "CheminFichierFavoris":
				ResultatChemin = CheminFichierFavoris;
				break;
			case "CheminFichierTemp":
				ResultatChemin = CheminFichierTemp;
				break;
			case "CheminFichierTemp2":
				ResultatChemin = CheminFichierTemp2;
				break;

			case "CheminQuick3270ProfileGmvs":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileGmvs_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileGmvs;
				}

				break;
			case "CheminQuick3270MacroGmvs":
				ResultatChemin = CheminQuick3270MacroGmvs;
				break;
			case "CheminQuick3270ProfileGmvs_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileGmvs_no_auto_login;
				break;

			case "CheminQuick3270ProfileKmvs":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileKmvs_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileKmvs;
				}

				break;
			case "CheminQuick3270MacroKmvs":
				ResultatChemin = CheminQuick3270MacroKmvs;
				break;
			case "CheminQuick3270ProfileKmvs_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileKmvs_no_auto_login;
				break;

			case "CheminQuick3270ProfileZmvs":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileZmvs_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileZmvs;
				}
				break;
			case "CheminQuick3270MacroZmvs":
				ResultatChemin = CheminQuick3270MacroZmvs;
				break;
			case "CheminQuick3270ProfileZmvs_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileZmvs_no_auto_login;
				break;

			case "CheminQuick3270ProfileSysa":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileSysa_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileSysa;
				}

				break;
			case "CheminQuick3270MacroSysa":
				ResultatChemin = CheminQuick3270MacroSysa;
				break;
			case "CheminQuick3270ProfileSysa_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileSysa_no_auto_login;
				break;

			case "CheminQuick3270ProfileSysg":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileSysg_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileSysg;
				}

				break;
			case "CheminQuick3270MacroSysg":
				ResultatChemin = CheminQuick3270MacroSysg;
				break;
			case "CheminQuick3270ProfileSysg_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileSysg_no_auto_login;
				break;

			case "CheminQuick3270ProfileBmvs":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileBmvs_2;
				}

				else {
					ResultatChemin = CheminQuick3270ProfileBmvs;
				}
				break;
			case "CheminQuick3270MacroBmvs":
				ResultatChemin = CheminQuick3270MacroBmvs;
				break;
			case "CheminQuick3270ProfileBmvs_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileBmvs_no_auto_login;
				break;

			case "CheminQuick3270ProfileIp1":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileIp1_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileIp1;
				}

				break;
			case "CheminQuick3270MacroIp1":
				ResultatChemin = CheminQuick3270MacroIp1;
				break;
			case "CheminQuick3270ProfileIp1_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileIp1_no_auto_login;
				break;

			case "CheminQuick3270ProfileIp2":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileIp2_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileIp2;
				}

				break;
			case "CheminQuick3270MacroIp2":
				ResultatChemin = CheminQuick3270MacroIp2;
				break;
			case "CheminQuick3270ProfileIp2_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileIp2_no_auto_login;
				break;

			case "CheminQuick3270ProfileIp3":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileIp3_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileIp3;
				}

				break;
			case "CheminQuick3270MacroIp3":
				ResultatChemin = CheminQuick3270MacroIp3;
				break;
			case "CheminQuick3270ProfileIp3_no_auto_login":
				ResultatChemin = CheminQuick3270ProfileIp3_no_auto_login;
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
			case "CheminPartageIprox":
				ResultatChemin = CheminPartageIprox;
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
			case "CheminPuttyCm":
				ResultatChemin = CheminPuttyCm;
				break;
			case "CheminVtom":
				ResultatChemin = CheminVtom;
				break;

			case "CheminQuick3270ProfileBr":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileBr_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileBr;
				}

				break;
			case "CheminQuick3270MacroBr":
				ResultatChemin = CheminQuick3270MacroBr;
				break;

			case "CheminQuick3270ProfileBdi":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileBdi_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileBdi;
				}

				break;
			case "CheminQuick3270MacroBdi":
				ResultatChemin = CheminQuick3270MacroBdi;
				break;

			case "CheminQuick3270ProfileBdaf":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileBdaf_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileBdaf;
				}

				break;
			case "CheminQuick3270MacroBdaf":
				ResultatChemin = CheminQuick3270MacroBdaf;
				break;

			case "CheminQuick3270ProfilePfb":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfilePfb_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfilePfb;
				}

				break;
			case "CheminQuick3270MacroPfb":
				ResultatChemin = CheminQuick3270MacroPfb;
				break;

			case "CheminQuick3270ProfileSocly":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileSocly_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileSocly;
				}

				break;
			case "CheminQuick3270MacroSocly":
				ResultatChemin = CheminQuick3270MacroSocly;
				break;

			case "CheminQuick3270ProfileSocmcsd":
				if (Session == 2) {
					ResultatChemin = CheminQuick3270ProfileSocmcsd_2;
				}
				else {
					ResultatChemin = CheminQuick3270ProfileSocmcsd;
				}

				break;
			case "CheminQuick3270MacroSocmsd":
				ResultatChemin = CheminQuick3270MacroSocmcsd;
				break;

			case "CheminExceed":
				ResultatChemin = CheminExceed;
				break;
			case "CheminMremote":
				ResultatChemin = CheminMremote;
				break;
			case "CheminTinaMacro":
				ResultatChemin = CheminTinaMacro;
				break;

		}

		return ResultatChemin;

	}

}

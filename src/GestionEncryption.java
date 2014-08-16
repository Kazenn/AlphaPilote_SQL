import org.jasypt.util.text.StrongTextEncryptor;

public class GestionEncryption {

	public String DemandeEncryption(String StringDemande) {
		String UserName = System.getProperty("user.name");
		String StringApresEncryption = "#Erreur";
		String MotDePasse = UserName;

		StrongTextEncryptor Encrypteur = new StrongTextEncryptor();
		Encrypteur.setPassword(MotDePasse);
		StringApresEncryption = Encrypteur.encrypt(StringDemande);

		return StringApresEncryption;

	}

	public String DemandeDecryption(String StringDemande) {
		String UserName = System.getProperty("user.name");
		String StringApresDecryption = "#Erreur";
		String MotDePasse = UserName;

		StrongTextEncryptor Decrypteur = new StrongTextEncryptor();
		Decrypteur.setPassword(MotDePasse);
		StringApresDecryption = Decrypteur.decrypt(StringDemande);
		// System.out.println(StringApresDecryption);

		return StringApresDecryption;

	}

}

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
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

	public void DemandeEncryptionFichier() throws IOException {

		new GestionChemin();

		String UserName = System.getProperty("user.name");
		StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
		textEncryptor.setPassword(UserName);

		File temporaire = new File("d:/tempencrypt.txt");
		File FichierSortieFavoris = new File("d:/BRCLY.qmc");
		File Sortie = new File("d:/SORTIEEEE.txt");

		Scanner scanner = new Scanner(FichierSortieFavoris);
		BufferedWriter bw = new BufferedWriter(new FileWriter(temporaire));
		while (scanner.hasNextLine()) {
			String line = StringUtils.stripEnd(scanner.nextLine(), null);
			String myEncryptedText = textEncryptor.encrypt(line);
			System.out.println(myEncryptedText);
			bw.write(myEncryptedText);
			if (scanner.hasNextLine()) {

				bw.write(System.getProperty("line.separator"));
			}
			bw.flush();
		}

		// FichierSortieFavoris.delete();
		temporaire.renameTo(Sortie);
		bw.flush();

		scanner.close();
		bw.close();

	}

}

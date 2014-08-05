import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.Map;
import java.util.Map.Entry;


class AfficheurFlux implements Runnable {

    private final InputStream inputStream;
    private String RetourFluxAfficheur;
    private String ligne ="";
    private boolean find = false;

    AfficheurFlux(InputStream inputStream) {
        this.inputStream = inputStream;
        //RetourFluxAfficheur = "-";
    }

    private BufferedReader getBufferedReader(InputStream is) {
        return new BufferedReader(new InputStreamReader(is));
    }

    @Override
    public void run() {
        BufferedReader br = getBufferedReader(inputStream);
        
        
        try {
            while ((ligne = br.readLine()) != null) {
            	
            	PrintStream ps = null;
            	ps = new PrintStream(System.out, true, "ISO-8859-1");
            	
            	//String LigneSansAccent = removeAccent(ligne);
                //System.out.println("Contenu de ligne " + LigneSansAccent);
            	ps.println(ligne);
            	//boolean find = false;
                if (ligne.lastIndexOf("attente") != -1) {
                	find = false;
                	RetourFluxAfficheur = "Ping KO - Pas de réponse de la destination" + "\n\r";

                	//UserInterface.AlimenterAfficheur("test");
                }
                if (ligne.lastIndexOf("Impossible") != -1) {
                	find = false;
                	RetourFluxAfficheur = "Ping KO - Impossible de joindre l'hôte" + "\n\r";
                }
                
                if (ligne.lastIndexOf("trouver") != -1) {
                	find = false;
                	RetourFluxAfficheur = "Ping KO - Impossible de trouver l'hôte" + "\n\r";
                }
                
                if (ligne.lastIndexOf("octet") != -1) {
                	find = true;
                	String LigneFinale = ligne.substring(10);
                	RetourFluxAfficheur = "Ping OK -" + LigneFinale + "\n\r";
                	
                	
                	//ligne = Normalizer.normalize(ligne, Normalizer.Form.NFD);
                	//ligne = ligne.replaceAll("\\p{M}", "");
                	//RetourFluxAfficheur = "Ping OK - " + ligne + "\n\r";
                }
                
                //RetourFluxAfficheur = ligne;
                //System.out.println("Contenu de RETOUR " + RetourFluxAfficheur);
                
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String LecteurDeFlux() {
    	
		return RetourFluxAfficheur;
    	
    }
    
    public boolean LecteurFind() {
    	
		return find;
    }
    
    public static String removeAccent(String source) {
		return Normalizer.normalize(source, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
	}
    
       
    }

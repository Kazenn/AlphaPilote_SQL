import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.Normalizer;


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
            	ps = new PrintStream(System.out, true, "IBM850");

            	ps.println(ligne);
            	
                if (ligne.lastIndexOf("attente") != -1) {
                	find = false;
                	RetourFluxAfficheur = "Ping KO - Pas de réponse de la destination" + "\n\r";
                }
                if (ligne.lastIndexOf("Impossible") != -1) {
                	find = false;
                	RetourFluxAfficheur = "Ping KO - Impossible de joindre l'hôte" + "\n\r";
                }                
                if (ligne.lastIndexOf("trouver") != -1) {
                	find = false;
                	RetourFluxAfficheur = "Ping KO - Impossible de trouver l'hôte" + "\n\r";
                
                } 
                if (ligne.lastIndexOf("count") != -1) {
                	find = false;
                	RetourFluxAfficheur = "Ping KO - Commande incorrecte" + "\n\r";
            
                }
                if (ligne.lastIndexOf("incorrecte") != -1) {
                	find = false;
                	RetourFluxAfficheur = "Ping KO - Commande incorrecte" + "\n\r";
            
                }
                if (ligne.lastIndexOf("IPv6") != -1) {
                	find = false;
                	RetourFluxAfficheur = "Ping KO - Commande incorrecte" + "\n\r";
            
                }
                
                if (ligne.lastIndexOf("octet") != -1) {
                	find = true;
                	String LigneFinale = ligne.substring(10);
                	RetourFluxAfficheur = "Ping OK -" + LigneFinale + "\n\r";                
                }
                
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

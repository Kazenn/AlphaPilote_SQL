import java.io.*;
import java.text.SimpleDateFormat;

public class GestionLog {
	                   
	public void EcrireDansFichierLog(String ChaineDansFichier) 
	{
		
	                FileOutputStream FichierSortie; // declare a file output object
	                PrintStream FluxEcriture; // declare a print stream object
	                String LogPath="D:\\AlphaPilote\\log.txt";
	                
	                
	                
	                SimpleDateFormat SimpleDate = new SimpleDateFormat("dd/MM/yyyy à HH:mm:ss");
	                String LaDateHeure = SimpleDate.format(new java.util.Date());
	                              
	                          
	                try {
	                	FichierSortie = new FileOutputStream(LogPath, true);
						FluxEcriture = new PrintStream(FichierSortie, true);
	                	FluxEcriture.println ("["+LaDateHeure+"] " + ChaineDansFichier);
	                	FluxEcriture.close();
			
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    
	        }
	}


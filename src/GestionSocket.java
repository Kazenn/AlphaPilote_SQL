import java.io.*;
import java.net.*;
public class GestionSocket {
	
	public Boolean InitSocket(String Hostname, int NumeroPort )
	{

		Boolean ConnexionValide = false;

	    //NumeroPost = 44827;
	    //Hostname = "xx.xx.xx.xx";

	    //Attempt to connect
	    try {
	        Socket sock = new Socket(Hostname, NumeroPort);
	            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
	        //Output
	        out.println("Test");
	        out.flush();

	        out.close();
	        sock.close();
	        ConnexionValide = true;
	        
	    } catch(Exception e) {
	    	ConnexionValide = false;
	        e.printStackTrace();
	    }
		return ConnexionValide;
	    
	}
	
	
}

import java.io.PrintWriter;
import java.net.Socket;

public class GestionSocket {

	public Boolean InitSocket(String Hostname, int NumeroPort) {

		Boolean ConnexionValide = false;

		try {
			Socket sock = new Socket(Hostname, NumeroPort);
			PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
			// Output
			out.println("Test");
			out.flush();

			out.close();
			sock.close();
			ConnexionValide = true;

		}
		catch (Exception e) {
			ConnexionValide = false;

			e.printStackTrace();
		}
		return ConnexionValide;

	}
}

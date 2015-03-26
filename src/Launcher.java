import java.sql.SQLException;

public class Launcher {

	public static void main(String[] args) throws SQLException {

		UserInterface frame = new UserInterface();

		frame.setVisible(true);
		frame.setSize(800, 575);

	}

}

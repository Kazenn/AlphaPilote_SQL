import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;


public class UserInterfaceMachine extends JFrame{
	public UserInterfaceMachine() {
		getContentPane().setLayout(null);
		
		JLabel LabelEnCours = new JLabel("En cours ....");
		LabelEnCours.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LabelEnCours.setBounds(148, 92, 98, 36);
		getContentPane().add(LabelEnCours);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

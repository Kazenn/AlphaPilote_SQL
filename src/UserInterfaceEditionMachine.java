import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserInterfaceEditionMachine extends JFrame {
	private JTable MaTable;

	public UserInterfaceEditionMachine() {
		getContentPane().setLayout(null);
		InsertFileDataToJTable model = new InsertFileDataToJTable();
		MaTable = new JTable();

		MaTable.setColumnSelectionAllowed(true);

		MaTable.setModel(model);

		// TableColumnModel columnModel = MaTable.getColumnModel();

		MaTable.setCellSelectionEnabled(true);
		// MaTable.setCellEditor(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 405, 438);
		getContentPane().add(scrollPane);

		scrollPane.setViewportView(MaTable);

	}
}

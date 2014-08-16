import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class InsertFileDataToJTable extends AbstractTableModel {
	Vector data;
	Vector columns;
	String[] NomColonne = { "Machine", "Adresse IP" };

	public InsertFileDataToJTable() {
		String line;
		data = new Vector();
		columns = new Vector();

		try {
			FileInputStream fis = new FileInputStream("d:/machine.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			StringTokenizer st1 = new StringTokenizer(br.readLine(), "=");
			while (st1.hasMoreTokens()) {
				columns.addElement(st1.nextToken());
			}
			while ((line = br.readLine()) != null) {
				StringTokenizer st2 = new StringTokenizer(line, "=");
				while (st2.hasMoreTokens()) {
					data.addElement(st2.nextToken());
				}
			}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getRowCount() {
		return data.size() / getColumnCount();
	}

	@Override
	public int getColumnCount() {
		return columns.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.elementAt((rowIndex * getColumnCount()) + columnIndex);
	}

	@Override
	public String getColumnName(int index) {
		return NomColonne[index];
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return true;
	}

}
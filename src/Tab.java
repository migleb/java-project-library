import java.sql.Connection;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

class BooksTableModel extends DefaultTableModel{
	
	public BooksTableModel(String[] columnNames, int i){
		super(columnNames, i);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {                
		return false;
	};
}

public class Tab {
    Connection c = null;
    Statement stmt = null;
	Box lineBox = new Box(BoxLayout.LINE_AXIS);
	
	JButton add = new JButton("Add");
    JButton edit = new JButton("Edit");

}

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

public abstract class Tab implements PrintableTable, ActionListener {
    Connection c = null;
    Statement stmt = null;
	Box lineBox = new Box(BoxLayout.LINE_AXIS);
	
	JButton add = new JButton("Add");
    JButton edit = new JButton("Edit");
    
    DefaultTableModel table;
    
    Tab(JPanel tab){
    	lineBox.add(add);
    	lineBox.add(edit);
	    add.addActionListener(this);
	    
	    this.initTable(tab);
    }
    
    final void initTable(JPanel tab){
    	tab.add(lineBox, BorderLayout.NORTH);
    	
    	this.table = new BooksTableModel(columnNames(), 0);
		JTable dataTable = new JTable(this.table);
		
		dataTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if (e.getClickCount() == 2){
					JTable target = (JTable)e.getSource();
					int row = target.getSelectedRow();
				}
			}
		});

		printFiles();
		
		JScrollPane scrollPane = new JScrollPane(dataTable);
		tab.add(scrollPane);
    }
    
    abstract public String[] columnNames();
    
}

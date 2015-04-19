import java.sql.Connection;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;


public class Tab {
    Connection c = null;
    Statement stmt = null;
	Box lineBox = new Box(BoxLayout.LINE_AXIS);
	
	JButton add = new JButton("Add");
    JButton edit = new JButton("Edit");

}

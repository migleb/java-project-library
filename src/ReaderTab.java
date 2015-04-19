import java.awt.BorderLayout;

import javax.swing.*;


public class ReaderTab extends Tab {
	
	ReaderTab(JPanel tab){
		lineBox.add(add);
	    lineBox.add(edit);
	    tab.add(lineBox, BorderLayout.NORTH);
	    
	}

}

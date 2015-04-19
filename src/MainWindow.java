import java.awt.*;

import javax.swing.*; 
import javax.swing.table.DefaultTableModel;





public class MainWindow extends JFrame
{
  JPanel pane = new JPanel();

  
  MainWindow() // the frame constructor method
  {
    super("Library"); 
    setBounds(350,100,600,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //getContentPane().setLayout(new FlowLayout());
    
    JTabbedPane tabs = new JTabbedPane();
    getContentPane().add(tabs);
    JPanel tab1 = new JPanel(new BorderLayout());
    JPanel tab2 = new JPanel(new BorderLayout());
    JPanel tab3 = new JPanel(new BorderLayout());
 /*   
    tab1.setLayout(new FlowLayout(FlowLayout.LEFT));
    tab2.setLayout(new FlowLayout(FlowLayout.LEFT));
    tab3.setLayout(new FlowLayout(FlowLayout.LEFT));
  */
    
    tabs.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=20 marginheight=5>Book Catalog</body></html>", tab1);
    tabs.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=20 marginheight=5>Readers</body></html>", tab2);
    tabs.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=20 marginheight=5>Staff</body></html>", tab3);
    Tab booksTab = new BooksTab(tab1);
    Tab readerTab = new ReaderTab(tab2);

    setVisible(true); 
  }
  
  
}
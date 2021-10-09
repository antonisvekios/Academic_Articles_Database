import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectDatabase {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SelectDatabase window = new SelectDatabase();
          window.frame.setVisible(true);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public SelectDatabase() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(200, 200, 500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JLabel lblSelectADatabase = new JLabel("Select a database to access:");
    lblSelectADatabase.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblSelectADatabase.setBounds(116, 13, 227, 33);
    frame.getContentPane().add(lblSelectADatabase);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(26, 49, 416, -3);
    frame.getContentPane().add(separator);
    
    JButton btnNewButton = new JButton("hagevekiosproject");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        
        frame.dispose();
        SelectCRUD.main(null);
        
      }
    });
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnNewButton.setBounds(126, 74, 203, 24);
    frame.getContentPane().add(btnNewButton);
  }
}

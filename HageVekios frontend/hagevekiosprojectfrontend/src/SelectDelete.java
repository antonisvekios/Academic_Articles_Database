import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectDelete {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SelectDelete window = new SelectDelete();
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
  public SelectDelete() {
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
    
    JLabel lblSelectTheTable = new JLabel("Select the table to delete an entry from:");
    lblSelectTheTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblSelectTheTable.setBounds(63, 0, 316, 33);
    frame.getContentPane().add(lblSelectTheTable);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(26, 28, 416, 5);
    frame.getContentPane().add(separator);
    
    JButton btnAcademic = new JButton("Academic");
    btnAcademic.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        DeleteAcademic.main(null);
        
      }
    });
    btnAcademic.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnAcademic.setBounds(162, 40, 125, 31);
    frame.getContentPane().add(btnAcademic);
    
    JButton btnInstitution = new JButton("Institution");
    btnInstitution.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        DeleteInstitution.main(null);
        
      }
    });
    btnInstitution.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnInstitution.setBounds(162, 85, 125, 31);
    frame.getContentPane().add(btnInstitution);
    
    JButton btnArticle = new JButton("Article");
    btnArticle.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        DeleteInstitution.main(null);
        
      }
    });
    btnArticle.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnArticle.setBounds(162, 128, 125, 31);
    frame.getContentPane().add(btnArticle);
    
    JButton button = new JButton("Exit");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit",
            JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
          System.exit(0);
        }
        
      }
    });
    button.setFont(new Font("Tahoma", Font.PLAIN, 18));
    button.setBounds(345, 173, 97, 25);
    frame.getContentPane().add(button);
  }
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectCreate {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SelectCreate window = new SelectCreate();
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
  public SelectCreate() {
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
    
    JLabel lblSelectATable = new JLabel("Select the table to create a new entry in:");
    lblSelectATable.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblSelectATable.setBounds(78, -3, 331, 33);
    frame.getContentPane().add(lblSelectATable);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(26, 28, 416, 2);
    frame.getContentPane().add(separator);
    
    JButton btnAcademic = new JButton("Academic");
    btnAcademic.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        CreateAcademic.main(null);
        
      }
    });
    btnAcademic.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnAcademic.setBounds(164, 44, 133, 25);
    frame.getContentPane().add(btnAcademic);
    
    JButton btnInstitution = new JButton("Institution");
    btnInstitution.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        CreateInstitution.main(null);
        
      }
    });
    btnInstitution.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnInstitution.setBounds(164, 97, 133, 25);
    frame.getContentPane().add(btnInstitution);
    
    JButton btnArticle = new JButton("Article");
    btnArticle.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        CreateArticle.main(null);
        
      }
    });
    btnArticle.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnArticle.setBounds(164, 150, 133, 25);
    frame.getContentPane().add(btnArticle);
    
    JButton btnExit = new JButton("Exit");
    btnExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit",
            JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
          System.exit(0);
        }
        
      }
    });
    btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnExit.setBounds(345, 187, 97, 25);
    frame.getContentPane().add(btnExit);
  }

}

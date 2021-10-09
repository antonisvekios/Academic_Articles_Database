import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectRead {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SelectRead window = new SelectRead();
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
  public SelectRead() {
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
    
    JLabel lblSelectTheTable = new JLabel("Select the table you want to view:");
    lblSelectTheTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblSelectTheTable.setBounds(89, 0, 318, 33);
    frame.getContentPane().add(lblSelectTheTable);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(26, 28, 416, 2);
    frame.getContentPane().add(separator);
    
    JButton btnArticle = new JButton("Academic");
    btnArticle.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        ReadAcademic.main(null);
        
      }
    });
    btnArticle.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnArticle.setBounds(59, 46, 121, 23);
    frame.getContentPane().add(btnArticle);
    
    JButton btnInstitution = new JButton("Institution");
    btnInstitution.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ReadInstitution.main(null);
        
      }
    });
    btnInstitution.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnInstitution.setBounds(59, 97, 121, 23);
    frame.getContentPane().add(btnInstitution);
    
    JButton button_1 = new JButton("Article");
    button_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ReadArticle.main(null);
      }
    });
    button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
    button_1.setBounds(59, 148, 121, 23);
    frame.getContentPane().add(button_1);
    
    JButton btnAffiliation = new JButton("Affiliation");
    btnAffiliation.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ReadAffiliation.main(null);
      }
    });
    btnAffiliation.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnAffiliation.setBounds(279, 46, 128, 23);
    frame.getContentPane().add(btnAffiliation);
    
    JButton btnAuthoring = new JButton("Authoring");
    btnAuthoring.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ReadAuthoring.main(null);
      }
    });
    btnAuthoring.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnAuthoring.setBounds(279, 97, 128, 23);
    frame.getContentPane().add(btnAuthoring);
    
    JButton btnReview = new JButton("Review");
    btnReview.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        frame.dispose();
        ReadReview.main(null);
      }
    });
    btnReview.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnReview.setBounds(279, 148, 128, 23);
    frame.getContentPane().add(btnReview);
    
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
    button.setBounds(396, 189, 72, 23);
    frame.getContentPane().add(button);
  }
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectUpdate {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SelectUpdate window = new SelectUpdate();
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
  public SelectUpdate() {
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
    
    JLabel lblWhatWouldYou = new JLabel("What would you like to update?");
    lblWhatWouldYou.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblWhatWouldYou.setBounds(96, 0, 267, 33);
    frame.getContentPane().add(lblWhatWouldYou);
    
    JButton btnArticleReviewDate = new JButton("Article Review Date");
    btnArticleReviewDate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        UpdateReview.main(null);
        
      }
    });
    btnArticleReviewDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnArticleReviewDate.setBounds(132, 61, 194, 33);
    frame.getContentPane().add(btnArticleReviewDate);
    
    JButton button = new JButton("Exit");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit",
            JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
          System.exit(0);
        }
        
      }
    });
    button.setFont(new Font("Tahoma", Font.PLAIN, 18));
    button.setBounds(345, 159, 97, 25);
    frame.getContentPane().add(button);
  }

}

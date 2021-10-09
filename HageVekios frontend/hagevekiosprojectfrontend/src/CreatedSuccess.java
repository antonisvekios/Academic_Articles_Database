import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.sql.*;


public class CreatedSuccess {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          CreatedSuccess window = new CreatedSuccess();
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
  public CreatedSuccess() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  static Connection connect;
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(200, 200, 500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JLabel lblEntrySuccessfullyCreated = new JLabel("Operation successfully executed");
    lblEntrySuccessfullyCreated.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblEntrySuccessfullyCreated.setBounds(113, 17, 264, 33);
    frame.getContentPane().add(lblEntrySuccessfullyCreated);

    JButton btnReturnToOption = new JButton("Return to option menu");
    btnReturnToOption.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        SelectCRUD.main(null);
        
        
      }
    });
    btnReturnToOption.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnReturnToOption.setBounds(126, 77, 223, 25);
    frame.getContentPane().add(btnReturnToOption);

    JButton btnExit = new JButton("Exit");
    btnExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {

        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit",
            JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {

          System.exit(0);

        }

      }
    });
    btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnExit.setBounds(192, 130, 84, 25);
    frame.getContentPane().add(btnExit);
  }

}

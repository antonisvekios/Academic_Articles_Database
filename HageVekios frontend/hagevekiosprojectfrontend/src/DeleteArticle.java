import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteArticle {
  static Connection connect;

  private JFrame frame;
  private JTextField aname;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          DeleteArticle window = new DeleteArticle();
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
  public DeleteArticle() {
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
    
    JLabel lblInputTheArticle = new JLabel("Input the article you would like to delete:");
    lblInputTheArticle.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblInputTheArticle.setBounds(60, 0, 339, 33);
    frame.getContentPane().add(lblInputTheArticle);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(36, 28, 370, 2);
    frame.getContentPane().add(separator);
    
    JLabel lblArticleName = new JLabel("Article Name:");
    lblArticleName.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblArticleName.setBounds(15, 85, 115, 33);
    frame.getContentPane().add(lblArticleName);
    
    aname = new JTextField();
    aname.setFont(new Font("Tahoma", Font.PLAIN, 18));
    aname.setBounds(121, 85, 236, 39);
    frame.getContentPane().add(aname);
    aname.setColumns(10);
    
    JButton btnConfirm = new JButton("Confirm");
    btnConfirm.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

          connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hagevekiosproject", "root", "1412@2000Av#");


          Statement statement = connect.createStatement();
          PreparedStatement statement2 = connect.prepareStatement("delete from article where published_article=?");
          statement2.setString(1, aname.getText());

          statement2.executeUpdate();

          CreatedSuccess.main(null);

          connect.close();


        }
        catch (Exception exc) {
          System.exit(0);
        }
      }
    });
    btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnConfirm.setBounds(36, 157, 171, 41);
    frame.getContentPane().add(btnConfirm);
    
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
    btnExit.setBounds(245, 157, 171, 41);
    frame.getContentPane().add(btnExit);
  }

}

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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateReview {
  
  static Connection connect;

  private JFrame frame;
  private JTextField arid;
  private JTextField acid;
  private JTextField rdate;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          UpdateReview window = new UpdateReview();
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
  public UpdateReview() {
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
    
    JLabel lblSpecifyTheLatest = new JLabel("Input the review information to be updated:");
    lblSpecifyTheLatest.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblSpecifyTheLatest.setBounds(59, 0, 349, 33);
    frame.getContentPane().add(lblSpecifyTheLatest);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(26, 28, 416, 2);
    frame.getContentPane().add(separator);
    
    JLabel lblArticleTitle = new JLabel("Article ID:");
    lblArticleTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblArticleTitle.setBounds(57, 46, 89, 33);
    frame.getContentPane().add(lblArticleTitle);
    
    JLabel lblAcademicName = new JLabel("Academic ID:");
    lblAcademicName.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblAcademicName.setBounds(17, 79, 141, 33);
    frame.getContentPane().add(lblAcademicName);
    
    JLabel lblNewReviewDate = new JLabel("New review date:");
    lblNewReviewDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblNewReviewDate.setBounds(10, 107, 148, 33);
    frame.getContentPane().add(lblNewReviewDate);
    
    arid = new JTextField();
    arid.setFont(new Font("Tahoma", Font.PLAIN, 18));
    arid.setBounds(159, 46, 236, 33);
    frame.getContentPane().add(arid);
    arid.setColumns(10);
    
    acid = new JTextField();
    acid.setFont(new Font("Tahoma", Font.PLAIN, 18));
    acid.setColumns(10);
    acid.setBounds(159, 79, 236, 33);
    frame.getContentPane().add(acid);
    
    rdate = new JTextField();
    rdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
    rdate.setColumns(10);
    rdate.setBounds(159, 107, 236, 33);
    frame.getContentPane().add(rdate);
    
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
    button.setBounds(345, 168, 97, 25);
    frame.getContentPane().add(button);
    
    JButton Confirm = new JButton("Confirm");
    Confirm.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        try {

          connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hagevekiosproject", "root", "1412@2000Av#");


          Statement statement = connect.createStatement();
          PreparedStatement statement2 = connect.prepareStatement("update review set review_dates=? where academic_id=? and article_id=?");
          statement2.setString(1, rdate.getText());
          statement2.setString(2, acid.getText());
          statement2.setString(3, arid.getText());

          statement2.executeUpdate();

          CreatedSuccess.main(null);

          connect.close();


        }
        catch (Exception exc) {
          System.exit(0);
        }
        
      }
    });
    Confirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
    Confirm.setBounds(210, 168, 97, 25);
    frame.getContentPane().add(Confirm);
  }

}

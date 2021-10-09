import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class CreateArticle {

  private JFrame frame;
  private JTextField aid;
  private JTextField title;
  private JTextField numofpages;
  private JTextField numofreferences;
  private JTextField sdate;
  
  static Connection connect;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          CreateArticle window = new CreateArticle();
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
  public CreateArticle() {
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
    
    JLabel lblInputTheRequired = new JLabel("Input the required data for the new article");
    lblInputTheRequired.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblInputTheRequired.setBounds(60, 0, 371, 33);
    frame.getContentPane().add(lblInputTheRequired);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(26, 28, 416, 5);
    frame.getContentPane().add(separator);
    
    JLabel lblArticleId = new JLabel("Article ID:");
    lblArticleId.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblArticleId.setBounds(70, 28, 85, 33);
    frame.getContentPane().add(lblArticleId);
    
    JLabel lblText = new JLabel("Title:");
    lblText.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblText.setBounds(107, 61, 48, 33);
    frame.getContentPane().add(lblText);
    
    JLabel lblNumberOfPages = new JLabel("Number of pages:");
    lblNumberOfPages.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblNumberOfPages.setBounds(13, 89, 142, 33);
    frame.getContentPane().add(lblNumberOfPages);
    
    JLabel lblNumberReferences = new JLabel("Number References:");
    lblNumberReferences.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblNumberReferences.setBounds(13, 122, 159, 33);
    frame.getContentPane().add(lblNumberReferences);
    
    JLabel lblSubmissionDate = new JLabel("Submission date:");
    lblSubmissionDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblSubmissionDate.setBounds(13, 150, 142, 33);
    frame.getContentPane().add(lblSubmissionDate);
    
    aid = new JTextField();
    aid.setFont(new Font("Tahoma", Font.PLAIN, 18));
    aid.setColumns(10);
    aid.setBounds(181, 28, 236, 33);
    frame.getContentPane().add(aid);
    
    title = new JTextField();
    title.setFont(new Font("Tahoma", Font.PLAIN, 18));
    title.setColumns(10);
    title.setBounds(181, 61, 236, 33);
    frame.getContentPane().add(title);
    
    numofpages = new JTextField();
    numofpages.setFont(new Font("Tahoma", Font.PLAIN, 18));
    numofpages.setColumns(10);
    numofpages.setBounds(181, 89, 236, 33);
    frame.getContentPane().add(numofpages);
    
    numofreferences = new JTextField();
    numofreferences.setFont(new Font("Tahoma", Font.PLAIN, 18));
    numofreferences.setColumns(10);
    numofreferences.setBounds(181, 122, 236, 33);
    frame.getContentPane().add(numofreferences);
    
    sdate = new JTextField();
    sdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
    sdate.setColumns(10);
    sdate.setBounds(181, 151, 236, 33);
    frame.getContentPane().add(sdate);
    
    JButton button = new JButton("Confirm");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        try {
          int x = Integer.parseInt(aid.getText());
          
        } catch (NumberFormatException exc) {
          JOptionPane.showMessageDialog(null, "Invalid article id", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
          int x = Integer.parseInt(numofpages.getText());
          
        } catch (NumberFormatException exc) {
          JOptionPane.showMessageDialog(null, "Invalid number of pages", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
          int x = Integer.parseInt(numofreferences.getText());
          
        } catch (NumberFormatException exc) {
          JOptionPane.showMessageDialog(null, "Invalid number of references", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        try {
          
          connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hagevekiosproject", "root", "1412@2000Av#");
          
          
          Statement statement = connect.createStatement();
          PreparedStatement statement2 = connect.prepareStatement("insert into article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) values (?, ?, ?, ?, ?)");
          statement2.setString(1, aid.getText());
          statement2.setString(2, title.getText());
          statement2.setString(3, numofpages.getText());
          statement2.setString(4, numofreferences.getText());
          statement2.setString(5, sdate.getText());
          
          statement2.executeUpdate();
          
          CreatedSuccess.main(null);
          
          connect.close();
          

        }
        catch (Exception exc) {
          System.exit(0);
        }
        
      }
    });
    button.setFont(new Font("Tahoma", Font.PLAIN, 18));
    button.setBounds(246, 188, 104, 24);
    frame.getContentPane().add(button);
    
    JButton button_1 = new JButton("Exit");
    button_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit",
            JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
          System.exit(0);
        }
      
      }
    });
    button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
    button_1.setBounds(376, 188, 79, 24);
    frame.getContentPane().add(button_1);
    
    JLabel lblyearmonthday = new JLabel("(Year-Month-Day)");
    lblyearmonthday.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblyearmonthday.setBounds(23, 167, 129, 33);
    frame.getContentPane().add(lblyearmonthday);
  }

}

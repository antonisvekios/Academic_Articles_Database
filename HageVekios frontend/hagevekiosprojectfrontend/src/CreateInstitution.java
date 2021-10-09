import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;
public class CreateInstitution {

  private JFrame frame;
  private JTextField iid;
  private JTextField iname;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          CreateInstitution window = new CreateInstitution();
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
  public CreateInstitution() {
    initialize();
  }

  static Connection connect;
  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(200, 200, 500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Input the required data for the new institution");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblNewLabel.setBounds(55, 0, 371, 33);
    frame.getContentPane().add(lblNewLabel);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(26, 28, 416, 5);
    frame.getContentPane().add(separator);
    
    JLabel lblNewLabel_1 = new JLabel("Institution ID:");
    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblNewLabel_1.setBounds(55, 61, 119, 33);
    frame.getContentPane().add(lblNewLabel_1);
    
    JLabel lblInstitutionName = new JLabel("Institution Name:");
    lblInstitutionName.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblInstitutionName.setBounds(36, 122, 138, 33);
    frame.getContentPane().add(lblInstitutionName);
    
    iid = new JTextField();
    iid.setBounds(190, 61, 236, 33);
    frame.getContentPane().add(iid);
    iid.setColumns(10);
    
    iname = new JTextField();
    iname.setColumns(10);
    iname.setBounds(190, 118, 236, 33);
    frame.getContentPane().add(iname);
    
    
    
    JButton button = new JButton("Confirm");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        try {
          int x = Integer.parseInt(iid.getText());
          
        } catch (NumberFormatException exc) {
          JOptionPane.showMessageDialog(null, "Invalid institution id", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
          
          connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hagevekiosproject", "root", "1412@2000Av#");
          
          
          Statement statement = connect.createStatement();
          PreparedStatement statement2 = connect.prepareStatement("insert into institution (institution_ID, institution_name) values (?, ?)");
          statement2.setString(1, iid.getText());
          statement2.setString(2, iname.getText());
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
    button.setBounds(244, 179, 104, 24);
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
    button_1.setBounds(374, 179, 79, 24);
    frame.getContentPane().add(button_1);
  }

}

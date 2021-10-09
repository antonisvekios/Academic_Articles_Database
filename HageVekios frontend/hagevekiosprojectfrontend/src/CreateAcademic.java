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

import java.lang.Integer;
import java.sql.*;

public class CreateAcademic {

  private JFrame frame;
  private JTextField aname;
  private JTextField aid;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          CreateAcademic window = new CreateAcademic();
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
  public CreateAcademic() {
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
    
    JLabel lblInputTheRequired = new JLabel("Input the required data for the new academic");
    lblInputTheRequired.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblInputTheRequired.setBounds(50, 0, 370, 34);
    frame.getContentPane().add(lblInputTheRequired);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(26, 28, 416, 2);
    frame.getContentPane().add(separator);
    
    JLabel lblAcademicName = new JLabel("Academic name:");
    lblAcademicName.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblAcademicName.setBounds(26, 62, 139, 33);
    frame.getContentPane().add(lblAcademicName);
    
    JLabel lblAcademicId = new JLabel("Academic ID:");
    lblAcademicId.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblAcademicId.setBounds(52, 123, 139, 33);
    frame.getContentPane().add(lblAcademicId);
    
    aname = new JTextField();
    aname.setFont(new Font("Tahoma", Font.PLAIN, 18));
    aname.setBounds(166, 62, 236, 39);
    frame.getContentPane().add(aname);
    aname.setColumns(10);
    
    aid = new JTextField();
    aid.setFont(new Font("Tahoma", Font.PLAIN, 18));
    aid.setColumns(10);
    aid.setBounds(166, 123, 236, 39);
    frame.getContentPane().add(aid);
    
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
    btnExit.setBounds(378, 177, 79, 24);
    frame.getContentPane().add(btnExit);
    
    JButton btnConfirm = new JButton("Confirm");
    btnConfirm.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        try {
          int x = Integer.parseInt(aid.getText());
          
        } catch (NumberFormatException exc) {
          JOptionPane.showMessageDialog(null, "Invalid academic id", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
          
          connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hagevekiosproject", "root", "1412@2000Av#");
          
          
          Statement statement = connect.createStatement();
          //ResultSet rs = statement.executeQuery("insert into academic (academic_name, academic_id) values (?, ?)");
          PreparedStatement statement2 = connect.prepareStatement("insert into academic (academic_name, academic_id) values (?, ?)");
          statement2.setString(1, aname.getText());
          statement2.setString(2, aid.getText());
          statement2.executeUpdate();
          
          CreatedSuccess.main(null);
          
          connect.close();
          

        }
        catch (Exception exc) {
          System.exit(0);
        }}
    
    });
    btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnConfirm.setBounds(248, 177, 104, 24);
    frame.getContentPane().add(btnConfirm);
  }

}

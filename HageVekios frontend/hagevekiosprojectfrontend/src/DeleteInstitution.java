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

public class DeleteInstitution {
  static Connection connect;

  private JFrame frame;
  private JTextField iname;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          DeleteInstitution window = new DeleteInstitution();
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
  public DeleteInstitution() {
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
    
    JLabel lblInputTheInstitution = new JLabel("Input the institution you would like to delete:");
    lblInputTheInstitution.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblInputTheInstitution.setBounds(52, 0, 378, 33);
    frame.getContentPane().add(lblInputTheInstitution);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(25, 28, 405, 2);
    frame.getContentPane().add(separator);
    
    JLabel lblInstitutionName = new JLabel("Institution Name:");
    lblInstitutionName.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblInstitutionName.setBounds(26, 85, 156, 33);
    frame.getContentPane().add(lblInstitutionName);
    
    iname = new JTextField();
    iname.setBounds(166, 85, 236, 39);
    frame.getContentPane().add(iname);
    iname.setColumns(10);
    
    JButton btnConfirm = new JButton("Confirm");
    btnConfirm.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

          connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hagevekiosproject", "root", "1412@2000Av#");


          Statement statement = connect.createStatement();
          PreparedStatement statement2 = connect.prepareStatement("delete from institution where institution_name=?");
          statement2.setString(1, iname.getText());

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
    btnConfirm.setBounds(36, 152, 171, 41);
    frame.getContentPane().add(btnConfirm);
    
    JButton btnExit = new JButton("Exit");
    btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit",
            JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
          System.exit(0);
        }
      }
    });
    btnExit.setBounds(248, 152, 171, 41);
    frame.getContentPane().add(btnExit);
  }

}

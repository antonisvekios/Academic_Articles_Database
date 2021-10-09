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


public class DeleteAcademic {

  private JFrame frame;
  private JTextField aname;

  
  static Connection connect;
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          DeleteAcademic window = new DeleteAcademic();
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
  public DeleteAcademic() {
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

    JLabel lblInputTheCredentials = new JLabel("Input the academic you would like to delete:");
    lblInputTheCredentials.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblInputTheCredentials.setBounds(41, 0, 387, 33);
    frame.getContentPane().add(lblInputTheCredentials);

    JSeparator separator = new JSeparator();
    separator.setBounds(26, 28, 402, 2);
    frame.getContentPane().add(separator);

    JLabel lblAcademicName = new JLabel("Academic Name:");
    lblAcademicName.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblAcademicName.setBounds(14, 88, 154, 33);
    frame.getContentPane().add(lblAcademicName);

    aname = new JTextField();
    aname.setFont(new Font("Tahoma", Font.PLAIN, 18));
    aname.setBounds(151, 82, 236, 39);
    frame.getContentPane().add(aname);
    aname.setColumns(10);

    JButton button = new JButton("Confirm");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        try {

          connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hagevekiosproject", "root", "1412@2000Av#");


          Statement statement = connect.createStatement();
          PreparedStatement statement2 = connect.prepareStatement("delete from academic where academic_name=?");
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
    button.setFont(new Font("Tahoma", Font.PLAIN, 18));
    button.setBounds(212, 160, 104, 24);
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
    button_1.setBounds(356, 160, 97, 25);
    frame.getContentPane().add(button_1);
  }
}

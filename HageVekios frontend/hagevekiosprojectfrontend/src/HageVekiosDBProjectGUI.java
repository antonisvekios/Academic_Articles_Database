import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HageVekiosDBProjectGUI {

  private JFrame frame;
  private JTextField usernameField;
  private JPasswordField passwordField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          HageVekiosDBProjectGUI window = new HageVekiosDBProjectGUI();
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
  public HageVekiosDBProjectGUI() {
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
    
    JLabel lblEnterValidCredentials = new JLabel("Enter valid credentials to access the database");
    lblEnterValidCredentials.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblEnterValidCredentials.setBounds(50, 12, 365, 33);
    frame.getContentPane().add(lblEnterValidCredentials);
    
    JLabel lblUsername = new JLabel("Username:");
    lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblUsername.setBounds(26, 63, 90, 33);
    frame.getContentPane().add(lblUsername);
    
    JLabel lblPassword = new JLabel("Password:");
    lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblPassword.setBounds(26, 110, 90, 33);
    frame.getContentPane().add(lblPassword);
    
    usernameField = new JTextField();
    usernameField.setBounds(132, 61, 236, 29);
    frame.getContentPane().add(usernameField);
    usernameField.setColumns(10);
    
    passwordField = new JPasswordField();
    passwordField.setBounds(132, 108, 236, 29);
    frame.getContentPane().add(passwordField);
    
    JButton btnLogin = new JButton("Login");
    btnLogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        String password = passwordField.getText();
        String username = usernameField.getText();
        
        if (password.equals("root") && username.equals("root")) {
          
          frame.dispose();
          SelectDatabase.main(null);
          
          
        } else {
          JOptionPane.showMessageDialog(null, "Invalid login details", "Access Denied", JOptionPane.ERROR_MESSAGE);
          passwordField.setText(null);
          usernameField.setText(null);
        }
      }
    });
    btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnLogin.setBounds(16, 172, 122, 29);
    frame.getContentPane().add(btnLogin);
    
    JButton btnReset = new JButton("Reset");
    btnReset.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        usernameField.setText(null);
        passwordField.setText(null);
      }
    });
    btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnReset.setBounds(172, 172, 122, 29);
    frame.getContentPane().add(btnReset);
    
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
    btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnExit.setBounds(330, 172, 122, 29);
    frame.getContentPane().add(btnExit);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(16, 164, 436, 2);
    frame.getContentPane().add(separator);
    
    JSeparator separator_1 = new JSeparator();
    separator_1.setBounds(16, 43, 436, 2);
    frame.getContentPane().add(separator_1);
  }
}

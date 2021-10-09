import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Font;
public class ReadInstitution {
  
  static Connection connect;
  private JFrame frame;
  private JTable table;
  private JButton button;
  private JButton button_1;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ReadInstitution window = new ReadInstitution();
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
  public ReadInstitution() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 1016, 773);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JButton btnDisplay = new JButton("Display");
    btnDisplay.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

          connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hagevekiosproject", "root", "1412@2000Av#");


          Statement statement = connect.createStatement();
          PreparedStatement statement2 = connect.prepareStatement("select * from institution");
          ResultSet rs = statement2.executeQuery();
          table.setModel(DbUtils.resultSetToTableModel(rs));

          connect.close();


        }
        catch (Exception exc) {
          System.exit(0);
        }
        
      }
    });
    btnDisplay.setBounds(397, 11, 149, 32);
    frame.getContentPane().add(btnDisplay);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(26, 74, 914, 529);
    frame.getContentPane().add(scrollPane);
    
    table = new JTable();
    scrollPane.setViewportView(table);
    
    button = new JButton("Return to option menu");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        frame.dispose();
        SelectCRUD.main(null);
        
      }
    });
    button.setFont(new Font("Tahoma", Font.PLAIN, 18));
    button.setBounds(83, 626, 228, 31);
    frame.getContentPane().add(button);
    
    button_1 = new JButton("Exit");
    button_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit",
            JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {

          System.exit(0);
      }}
    });
    button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
    button_1.setBounds(745, 626, 128, 31);
    frame.getContentPane().add(button_1);
  }

}

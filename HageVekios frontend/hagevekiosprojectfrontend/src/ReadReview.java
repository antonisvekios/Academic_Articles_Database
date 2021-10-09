import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ReadReview {
  
  static Connection connect;
  private JFrame frame;
  private JTable table;
  private JButton button;
  private JButton btnExit;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ReadReview window = new ReadReview();
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
  public ReadReview() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 1026, 779);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JButton btnDisplay = new JButton("Display");
    btnDisplay.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

          connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hagevekiosproject", "root", "1412@2000Av#");


          Statement statement = connect.createStatement();
          PreparedStatement statement2 = connect.prepareStatement("select * from review");
          ResultSet rs = statement2.executeQuery();
          table.setModel(DbUtils.resultSetToTableModel(rs));

          connect.close();


        }
        catch (Exception exc) {
          System.exit(0);
        }
      }
    });
    btnDisplay.setBounds(392, 0, 151, 41);
    frame.getContentPane().add(btnDisplay);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(37, 67, 917, 556);
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
    button.setBounds(70, 632, 228, 31);
    frame.getContentPane().add(button);
    
    btnExit = new JButton("Exit");
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
    btnExit.setBounds(682, 632, 228, 31);
    frame.getContentPane().add(btnExit);
  }

}

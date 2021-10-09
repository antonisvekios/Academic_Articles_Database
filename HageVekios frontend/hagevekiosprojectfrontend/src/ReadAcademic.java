import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Font;

public class ReadAcademic {

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
          ReadAcademic window = new ReadAcademic();
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
  public ReadAcademic() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 908, 713);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JButton btnNewButton = new JButton("Display");
    btnNewButton.setBounds(350, 13, 129, 41);
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

          connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hagevekiosproject", "root", "1412@2000Av#");


          Statement statement = connect.createStatement();
          PreparedStatement statement2 = connect.prepareStatement("select * from academic");
          ResultSet rs = statement2.executeQuery();
          table.setModel(DbUtils.resultSetToTableModel(rs));

          connect.close();


        }
        catch (Exception exc) {
          System.exit(0);
        }
      }
    });
    frame.getContentPane().setLayout(null);
    frame.getContentPane().add(btnNewButton);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(26, 82, 824, 464);
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
    button.setBounds(36, 574, 228, 31);
    frame.getContentPane().add(button);
    
    button_1 = new JButton("Exit");
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
    button_1.setBounds(756, 574, 94, 31);
    frame.getContentPane().add(button_1);
  }
}

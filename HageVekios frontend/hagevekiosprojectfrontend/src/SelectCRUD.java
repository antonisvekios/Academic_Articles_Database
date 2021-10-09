import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectCRUD {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SelectCRUD window = new SelectCRUD();
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
  public SelectCRUD() {
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
    
    JLabel lblWhatOperationWould = new JLabel("Select the operation you would like to execute:");
    lblWhatOperationWould.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblWhatOperationWould.setBounds(36, 13, 377, 31);
    frame.getContentPane().add(lblWhatOperationWould);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(26, 47, 416, 2);
    frame.getContentPane().add(separator);
    
    JButton btnCreateAnEntry = new JButton("Create");
    btnCreateAnEntry.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        SelectCreate.main(null);
        
      }
    });
    btnCreateAnEntry.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnCreateAnEntry.setBounds(62, 72, 141, 31);
    frame.getContentPane().add(btnCreateAnEntry);
    
    JButton btnUpdate = new JButton("Update");
    btnUpdate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        SelectUpdate.main(null);
        
      }
    });
    btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnUpdate.setBounds(62, 124, 141, 31);
    frame.getContentPane().add(btnUpdate);
    
    JButton btnRead = new JButton("Read");
    btnRead.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        SelectRead.main(null);
        
      }
    });
    btnRead.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnRead.setBounds(272, 72, 141, 31);
    frame.getContentPane().add(btnRead);
    
    JButton btnDelete = new JButton("Delete");
    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        frame.dispose();
        SelectDelete.main(null);
        
      }
    });
    btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnDelete.setBounds(272, 124, 141, 31);
    frame.getContentPane().add(btnDelete);
    
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
    btnExit.setBounds(161, 174, 141, 31);
    frame.getContentPane().add(btnExit);
  }

}

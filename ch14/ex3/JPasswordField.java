/*
 * Create an applet/application using Console. In the JDK 
 * documentation from java.sun.com, find the JPasswordField and 
 * add this to the program. If the user types in the correct 
 * password, use Joptionpane to provide a success message to the  
 * user.
 */
 
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import com.bruceeckel.swing.*;
 import java.util.*;
 
 public class JPasswordField extends JApplet {
  private JTextField tf = new JTextField(12);
  private javax.swing.JPasswordField passField = new javax.swing.JPasswordField(12);
  @Override
  public void init() {
    passField.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        boolean isCorrect = true;
        char[] input = passField.getPassword();
        char[] correctPassword = 
        { 'y', 'o', 'u', 't', 'u', 'b', 'e'};
        if(input.length != correctPassword.length) {
          isCorrect = false;
        } else {
          isCorrect = Arrays.equals(input, correctPassword);
        }
        if (isCorrect) {
          JOptionPane.showMessageDialog(JPasswordField.this,
           "Success!");
        } else {
          JOptionPane.showMessageDialog(JPasswordField.this,
           "Invalid password", "Error Message",
            JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(passField);
  }
  public static void main(String[] args) {
    Console.run(new JPasswordField(), 200, 75);
  }
 }

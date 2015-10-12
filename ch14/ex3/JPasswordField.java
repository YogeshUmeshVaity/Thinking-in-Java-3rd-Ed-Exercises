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
 import com.bruceeckel.swing.Console;
 
 public class JPasswordField extends JApplet {
  private JPasswordField passField = new JPasswordField();
  @Override
  public void init() {
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(passField);
  }
  public static void main(String[] args) {
    Console.run(new JPasswordField(), 200, 75);
  }
 }

/* Create an applet/application using Console, with a JButton and 
 * a JTextField. Write and attach the appropriate listener so 
 * that if the button has the focus, characters typed into it 
 * will appear in the JTextField.
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.bruceeckel.swing.*;
 
public class Focus extends JApplet {
  
  private JButton button = new JButton("Type on me");
  private JTextField text = new JTextField(21);
  
  
  class FocusedKeyListener extends KeyAdapter {
    
    @Override
    public void keyTyped(KeyEvent e) {
      int id = e.getID(); // returns event ID
      if (id == KeyEvent.KEY_TYPED) {
        char c = e.getKeyChar();
        String keyString = "" + c;
        text.setText(text.getText() + keyString);
      }
    }
    
  }
  
  
  @Override
  public void init() {
    button.addKeyListener(new FocusedKeyListener());
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(button);
    cp.add(text);
  }
  
  public static void main(String[] args) {
    Console.run(new Focus(), 300, 300);
  }
  
}

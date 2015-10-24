/* Almost every Swing component is derived from Component, which 
 * has a setCursor( ) method. Look this up in the JDK 
 * documentation. Create an applet and change the cursor to one 
 * of the stock cursors in the Cursor class.
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.bruceeckel.swing.*;

public class CursorTest extends JApplet {
  private JButton button = new JButton("Click me");
  
  @Override
  public void init() {
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    button.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
    cp.add(button);
  }
  
  public static void main(String[] args) {
    Console.run(new CursorTest(), 300, 300);
  }
}

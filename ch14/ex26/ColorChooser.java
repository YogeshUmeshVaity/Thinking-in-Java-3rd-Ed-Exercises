/* In the JDK documentation for javax.swing, look up the 
 * JColorChooser. Write a program with a button that brings up 
 * the color chooser as a dialog.
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import com.bruceeckel.swing.*;

public class ColorChooser extends JApplet {
  private JButton colorButton = new JButton("Choose Color");
  
  @Override
  public void init() {
    Container cp = getContentPane();
    colorButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Color chosenColor = 
        JColorChooser.showDialog(ColorChooser.this, 
        "Choose Button Color", colorButton.getBackground());
        colorButton.setBackground(chosenColor);
      }
    });
    cp.add(colorButton);
  }
  
  public static void main(String[] args) {
    Console.run(new ColorChooser(), 300, 300);
  }
}

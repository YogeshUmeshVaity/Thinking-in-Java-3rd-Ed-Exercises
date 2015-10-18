/* Inherit a new type of button from JButton. Each time you press 
 * this button, it should change its color to a randomly selected 
 * value. See ColorBoxes.java for an example of how to generate a 
 * random color value.
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.bruceeckel.swing.*;

public class ColoredJButton extends JApplet {
  private MyButton button = new MyButton();
  private static final Color[] colors = {
    Color.BLACK, Color.BLUE, Color.CYAN,
    Color.DARK_GRAY, Color.GRAY, Color.GREEN,
    Color.LIGHT_GRAY, Color.MAGENTA,
    Color.ORANGE, Color.PINK, Color.RED,
    Color.WHITE, Color.YELLOW
  };
  class MyButton extends JButton {
    private Random rand = new Random();
    public MyButton() {
      addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          setBackground(colors[rand.nextInt(colors.length)]);
        }
      });
    } 
  }

  @Override
  public void init() {
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    JPanel panel = new JPanel();
    panel.add(button);
    c.add(panel);
  }

  public static void main(String[] args) {
    Console.run(new ColoredJButton(), 300, 300);
  }
} 

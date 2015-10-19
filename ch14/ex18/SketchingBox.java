/* Remember the “sketching box” toy with two knobs, one that 
 * controls the vertical movement of the drawing point, and one 
 * that controls the horizontal movement? Create one of those, 
 * using SineWave.java to get you started. Instead of knobs, use 
 * sliders. Add a button that will erase the entire sketch.
 */
 
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import com.bruceeckel.swing.*;

class SketchBox extends JPanel {
  private int x1 = 0, y1 = 0, x2 = 0, y2 = 0, extent = 0;
  
  public void sketch(int startX1, int startY1,
   int endX2, int endY2, int exnt) {
    x1 = startX1;
    y1 = startY1;
    x2 = endX2;
    y2 = endY2;
    repaint();
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.RED);
    g.drawLine(x1, y1, x2, y2);
  }
}

public class SketchingBox extends JApplet {
  private SketchBox box = new SketchBox();
  private JSlider horizontal = new JSlider(1, 600, 1);
  private JSlider vertical = new JSlider(JSlider.VERTICAL,
   1, 600, 1);
  
  @Override
  public void init() {
    Container cp = getContentPane();
    cp.add(box);
    horizontal.addChangeListener(new ChangeListener() {
    @Override
    public void stateChanged(ChangeEvent e) {
      int extent = horizontal.getExtent();
      int verticalPosition = vertical.getValue();
      int horizontalPosition = horizontal.getValue();
      int x1 = horizontalPosition - extent;
      int y1 = verticalPosition;
      int x2 = x1 + extent;
      int y2 = y1 + extent;
      box.sketch(x1, y1, x2, y2, extent);
    }
  });
    cp.add(BorderLayout.SOUTH, horizontal);
    vertical.setInverted(true);
    cp.add(BorderLayout.EAST, vertical);
  }
  
  public static void main(String[] args) {
    Console.run(new SketchingBox(), 600, 600);
  }
}

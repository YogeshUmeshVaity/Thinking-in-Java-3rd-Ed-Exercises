/* Remember the “sketching box” toy with two knobs, one that 
 * controls the vertical movement of the drawing point, and one 
 * that controls the horizontal movement? Create one of those, 
 * using SineWave.java to get you started. Instead of knobs, use 
 * sliders. Add a button that will erase the entire sketch.
 */
 
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import com.bruceeckel.swing.*;

class SketchBox extends JPanel {
  private int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
  private int horizontalPrevious = 1;
  private int horizontalMoved = 0;
  private int horizontalCurrent = 0;
  private int verticalPrevious = 1;
  private int verticalMoved = 0;
  private int verticalCurrent = 0;
  private boolean clear = false;
  
  public void setClear(boolean clr) {
    clear = clr;
  }
  
  public void clearDrawing() {
    repaint();
  }
  
  public void sketchVertical(int v) {
    verticalCurrent = v;
    verticalMoved = verticalCurrent - verticalPrevious;
    y1 = verticalPrevious;
    y2 = verticalPrevious + verticalMoved;
    repaint();
    verticalPrevious = y2;
  }
  
  public void sketchHorizontal(int h) {
    horizontalCurrent = h;
    horizontalMoved = horizontalCurrent - horizontalPrevious;
    x1 = horizontalPrevious;
    x2 = horizontalPrevious + horizontalMoved;
    repaint();
    horizontalPrevious = x2;
  }
  @Override
  public void paintComponent(Graphics g) {
    if(clear)
      super.paintComponent(g);
    //g.setColor(Color.RED);
    g.drawLine(x1, y1, x2, y2);
    System.out.println("x1=" + x1 + " y1=" + y1 + " x2=" + x2 + " y2=" + y2);
    clear = false;
  }
  
}

public class SketchingBox extends JApplet {
  private final int MAX_SLIDER = 600;
  private SketchBox box = new SketchBox();
  private JSlider horizontal = new JSlider(1, MAX_SLIDER, 1);
  private JSlider vertical = new JSlider(JSlider.VERTICAL,
   1, MAX_SLIDER, 1);
  private JButton clearButton = new JButton("Clear");
  
  @Override
  public void init() {
    Container cp = getContentPane();
    cp.add(box);
    
    horizontal.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
//        if(!source.getValueIsAdjusting()) {
          int hValue = horizontal.getValue();
          box.sketchHorizontal(hValue);
//        }
      }
    });
    
    vertical.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
//        if(!source.getValueIsAdjusting()) {
          int vValue = vertical.getValue();
          box.sketchVertical(vValue);
//        }
      }
    });
    
    clearButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        box.setClear(true);
        box.clearDrawing();
      }
    });
    
    JPanel southPanel = new JPanel();
    southPanel.setLayout(new BorderLayout());
    southPanel.add(BorderLayout.NORTH, horizontal);
    southPanel.add(BorderLayout.SOUTH, clearButton);
    //cp.add(BorderLayout.SOUTH, horizontal);
    vertical.setInverted(true);
    cp.add(BorderLayout.EAST, vertical);
    cp.add(BorderLayout.SOUTH, southPanel);
  }
  
  public static void main(String[] args) {
    Console.run(new SketchingBox(), 630, 690);
  }
  
}

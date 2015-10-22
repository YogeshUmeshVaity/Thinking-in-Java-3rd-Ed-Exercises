/* Starting with SineWave.java, create a program (an applet/
 * application using the Console class) that draws an animated 
 * sine wave that appears to scroll past the viewing window like 
 * an oscilloscope, driving the animation with a Thread. The 
 * speed of the animation should be controlled with a 
 * java.swing.JSlider control.
 * Modify Exercise 19 so that multiple sine wave panels are 
 * created within the application. The number of sine wave 
 * panels should be controlled by HTML tags or command-line 
 * parameters.
 */
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.*;
import com.bruceeckel.swing.*;

class SineDraw extends JPanel implements Runnable {
  private static final int SCALEFACTOR = 200;
  private int cycles;
  private int points;
  private double[] sines;
  private int[] pts;
  private double hstep;
  private int x1, x2, y1, y2;
  private int loopTest = 0;
  private int j;
  private int speed = 1;
  public SineDraw() { setCycles(18); }
  public void setSpeed(int spd) {
    speed = spd;
  }
  public void setCycles(int newCycles) {
    cycles = newCycles;
    points = SCALEFACTOR * cycles * 2;
    sines = new double[points];
    for(int i = 0; i < points; i++) {
      double radians = (Math.PI/SCALEFACTOR) * i;
      sines[i] = Math.sin(radians);
    }
    int maxWidth = getWidth();
    hstep = (double)maxWidth/(double)points;
    int maxHeight = getHeight();
    pts = new int[points];
    for(int i = 0; i < points; i++)
      pts[i] =
        (int)(sines[i] * maxHeight/2 * .95 + maxHeight/2);
  }
  
  @Override
  public void run() {
    while(true) {
      if(j < points) {
        j = j + speed;
        setCycles(3);
        repaint();
      } else {
        j = 0;
      }
      try {
          Thread.sleep(3);
        } catch(InterruptedException e) {
          e.printStackTrace();
        }
    }
  }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for(int i = j; i < points; i++) {
        x1 = (int)((i - 1) * hstep);
        x2 = (int)(i * hstep);
        y1 = pts[i-1];
        y2 = pts[i];
        g.drawLine(x1, y1, x2, y2);
      }
  }
}

public class SineWave extends JApplet {
  private static int sineDrawPanels = 3;
  private JSlider adjustCycles = new JSlider(1, 30, 5);
  private JSlider speed = new JSlider(1, 9, 1);
  private JPanel jp = new JPanel();
  public void init() {
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    for(int i = 0; i < sineDrawPanels; i++) {
      SineDraw sd = new SineDraw();
      sd.setPreferredSize(new Dimension(150, 150));
      sd.setBorder(new EtchedBorder());
      cp.add(sd);
      new Thread(sd).start();
    }
    
    
  }
  public static void main(String[] args) {
    if(args.length < 1) {
      System.out.println(
      "Usage : java SineWave Number_of_waves");
      System.exit(1);
    }
    sineDrawPanels = Integer.parseInt(args[0]);
    Console.run(new SineWave(), 700, 400);
//    SwingUtilities.invokeLater(new Runnable() {
//      @Override
//      public void run() { sines.setCycles(3); }
//    });
  }
} ///:~

//: c14:SineWave.java
// Drawing with Swing, using a JSlider.
// <applet code=SineWave width=700 height=400></applet>
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import javax.swing.*;
import javax.swing.event.*;
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
  public SineDraw() { setCycles(18); }
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
    //g.setColor(Color.RED);
    //repaint();
  }
  
  @Override
  public void run() {
    while(true) {
      if(j < points) {
        j = j + 1;
        repaint();
      } else {
        j = 0;
      }
      try {
          Thread.sleep(3);
        } catch(InterruptedException e) {
          e.printStackTrace();
        }
      System.out.println(loopTest++);
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
  private SineDraw sines = new SineDraw();
  private JSlider adjustCycles = new JSlider(1, 30, 5);
  public void init() {
    Container cp = getContentPane();
    cp.add(sines);
    adjustCycles.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        sines.setCycles(
          ((JSlider)e.getSource()).getValue());
      }
    });
    cp.add(BorderLayout.SOUTH, adjustCycles);
    new Thread(sines).start();
    
  }
  public static void main(String[] args) {
    Console.run(new SineWave(), 700, 400);
  }
} ///:~

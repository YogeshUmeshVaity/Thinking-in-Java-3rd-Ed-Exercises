/* Create an “asymptotic progress indicator” that gets slower and 
 * slower as it approaches the finish point. Add random erratic 
 * behavior so it will periodically look like it’s starting to 
 * speed up.
 */
 
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.bruceeckel.swing.*;

public class AsymptoticProgress extends JApplet {
  private JProgressBar progressBar = new JProgressBar();
  private JButton button = new JButton("Start Progress");
  private int progressValue;
  private Random rnd = new Random();
  private ActionListener progresser = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      if(progressValue > 60) {
        timer.setDelay(300);
      }
      if(progressValue > 70) {
        timer.setDelay(400);
      }
      if(progressValue > 80) {
        timer.setDelay(500);
      }
      if(progressValue > 90) {
        timer.setDelay(600);
      }
      if(progressValue <= progressBar.getMaximum() && 
          rnd.nextBoolean())
        progressBar.setValue(progressValue++);
      if(progressValue == progressBar.getMaximum() + 1) {
        timer.stop();
      }
    }
  };
  private Timer timer = new Timer(100, progresser);
  @Override
  public void init() {
    Container cp = getContentPane();
    cp.setLayout(new BorderLayout());
    int maxProgress = progressBar.getMaximum();
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int progressValue = 0;
        progressBar.setValue(0);
        timer.start();
      }
    });
    //cp.add(button);
    cp.add(BorderLayout.SOUTH, progressBar);
    //progressBar.setIndeterminate(true);
    timer.start();
    
  }
  
  public static void main(String[] args) {
    Console.run(new AsymptoticProgress(), 600, 100);
  }
}

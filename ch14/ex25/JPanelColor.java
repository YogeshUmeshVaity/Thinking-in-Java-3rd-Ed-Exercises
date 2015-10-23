/* Create an applet/application using Console. This should have 
 * three sliders, one each for the red, green, and blue values in 
 * java.awt.Color. The rest of the form should be a JPanel that 
 * displays the color determined by the three sliders. Also 
 * include non-editable text fields that show the current RGB 
 * values.
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import com.bruceeckel.swing.*;

public class JPanelColor extends JApplet {
  private JSlider redSlider = new JSlider(1, 100, 1);
  private JSlider blueSlider = new JSlider(1, 100, 1);
  private JSlider greenSlider = new JSlider(1, 100, 1);
  private JTextField redText = new JTextField(21);
  private JTextField blueText = new JTextField(21);
  private JTextField greenText = new JTextField(21);
  private JPanel redPanel = new JPanel();
  private JPanel bluePanel = new JPanel();
  private JPanel greenPanel = new JPanel();
  private JPanel mainPanel = new JPanel();
  
  @Override
  public void init() {
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    //mainPanel.setSize(600, 600);
    
    redSlider.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        mainPanel.setBackground(Color.red);
        redText.setText("" + mainPanel.getBackground().getRGB());
      }
    });
    blueSlider.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        mainPanel.setBackground(Color.blue);
        blueText.setText("" + mainPanel.getBackground().getRGB());
      }
    });
    greenSlider.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        mainPanel.setBackground(Color.green);
        greenText.setText("" + mainPanel.getBackground().getRGB());
      }
    });
    redText.setEditable(false);
    blueText.setEditable(false);
    greenText.setEditable(false);
    redPanel.add(redSlider);
    redPanel.add(redText);
    cp.add(redPanel);
    greenPanel.add(greenSlider);
    greenPanel.add(greenText);
    cp.add(greenPanel);
    bluePanel.add(blueSlider);
    bluePanel.add(blueText);
    cp.add(bluePanel);
    redSlider.setBackground(Color.red);
    blueSlider.setBackground(Color.blue);
    greenSlider.setBackground(Color.green);
    mainPanel.setPreferredSize(new Dimension(600, 600));
    cp.add(BorderLayout.SOUTH, mainPanel);
  }
  
  public static void main(String[] args) {
    Console.run(new JPanelColor(), 600, 600);
  }
}

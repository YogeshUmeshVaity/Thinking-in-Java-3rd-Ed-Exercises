/* Create an applet/application using Console. Add to the main 
 * frame all the components described in this chapter, including 
 * menus and a dialog box. 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.basic.*;
import javax.swing.border.*;
import com.bruceeckel.swing.*;

public class AllComponents extends JApplet {

  private ButtonGroup buttonGroup = new ButtonGroup();
  //private JButton button2 = new JButton("Button2");
  private JButton button = new JButton("Button");
  private BasicArrowButton
    up = new BasicArrowButton(BasicArrowButton.NORTH),
    down = new BasicArrowButton(BasicArrowButton.SOUTH),
    right = new BasicArrowButton(BasicArrowButton.EAST),
    left = new BasicArrowButton(BasicArrowButton.WEST);
  private JToggleButton toggle = 
    new JToggleButton("JToggleButton");
  private JCheckBox checkBox = new JCheckBox("JCheckBox");
  private JRadioButton radioButton1 = 
    new JRadioButton("JRadioButton1");
  private JRadioButton radioButton2 = 
    new JRadioButton("JRadioButton2");
  private JTextField text = new JTextField(21);
  private JTextArea textArea = new JTextArea(6, 21);
  private JScrollPane scrollPane = new JScrollPane(textArea,
    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
  
  @Override
  public void init() {
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    // Button group
    buttonGroup.add(radioButton1);
    buttonGroup.add(radioButton2);
    JPanel buttonGroupPanel = new JPanel();
    buttonGroupPanel.setBorder(new TitledBorder("ButtonGroup"));
    buttonGroupPanel.add(radioButton1);
    buttonGroupPanel.add(radioButton2);
    buttonGroupPanel.setToolTipText("Only one button can be" + 
    " selected at a time");
    cp.add(buttonGroupPanel);
    cp.add(button);
    cp.add(toggle);
    cp.add(checkBox);
    // Basic Arrow Buttons
    JPanel jp = new JPanel();
    jp.setBorder(new TitledBorder("Directions"));
    jp.add(up);
    jp.add(down);
    jp.add(right);
    jp.add(left);
    cp.add(jp);
    
    cp.add(text);
    cp.add(scrollPane);
  }
  
  public static void main(String[] args) {
    Console.run(new AllComponents(), 600, 600);
  } 
  
}

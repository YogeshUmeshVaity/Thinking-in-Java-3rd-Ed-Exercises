//: c14:MessageBoxes.java
// Demonstrates JoptionPane.
// <applet code=MessageBoxes width=200 height=150></applet>
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.bruceeckel.swing.*;

public class MessageBoxes extends JApplet {

  private JButton alert = new JButton("Alert");
  private JButton yesNo = new JButton("Yes/No");
  private JButton color = new JButton("Color");
  private JButton input = new JButton("Input");
  private JButton vals = new JButton("3 Vals");
  private JTextField txt = new JTextField(15);

  public void init() {
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    
    
    alert.addActionListener(new ActionListener() {
    
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
          "There's a bug on you!", "Hey!",
          JOptionPane.ERROR_MESSAGE);
      }
      
    });
    
    
    cp.add(alert);
    
    
    yesNo.addActionListener(new ActionListener() {
    
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(null,
          "or no", "choose yes",
          JOptionPane.YES_NO_OPTION);
      }
      
    });
    
    
    cp.add(yesNo);
    
    
    color.addActionListener(new ActionListener() {
    
      @Override
      public void actionPerformed(ActionEvent e) {
        Object[] options = { "Red", "Green" };
        int sel = JOptionPane.showOptionDialog(
          null, "Choose a Color!", "Warning",
          JOptionPane.DEFAULT_OPTION,
          JOptionPane.WARNING_MESSAGE, null,
          options, options[0]);
        if(sel != JOptionPane.CLOSED_OPTION)
          txt.setText("Color Selected: " + options[sel]);
      }
      
    });
    
    
    cp.add(color);
    
    
    input.addActionListener(new ActionListener() {
    
      @Override
      public void actionPerformed(ActionEvent e) {
        String val = JOptionPane.showInputDialog(
            "How many fingers do you see?");
        txt.setText(val);
      }
      
    });
    
    
    cp.add(input);
    
    
    vals.addActionListener(new ActionListener() {
    
      @Override
      public void actionPerformed(ActionEvent e) {
        Object[] selections = {"First", "Second", "Third"};
        Object val = JOptionPane.showInputDialog(
          null, "Choose one", "Input",
          JOptionPane.INFORMATION_MESSAGE,
          null, selections, selections[0]);
        if(val != null)
          txt.setText(val.toString());
      }
      
    });
    
    
    cp.add(vals);
    cp.add(txt);
  }
  public static void main(String[] args) {
    Console.run(new MessageBoxes(), 200, 200);
  }
} ///:~

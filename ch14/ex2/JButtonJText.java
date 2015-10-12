/*
 * Create an applet/application using the Console class as shown 
 * in this chapter. Include a text field and three buttons. When 
 * you press each button, make some different text appear in the 
 * text field.
 */
 
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import com.bruceeckel.swing.*;
 
 public class JButtonJText extends JApplet {
  private JButton button1 = new JButton("Button1");
  private JButton button2 = new JButton("Button2");
  private JButton button3 = new JButton("Button3");
  private JTextField textField = new JTextField(12);
  private JCheckBox checkBox = new JCheckBox("Fancy CheckBox");
  class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String buttonText = ((JButton)e.getSource()).getText();
      textField.setText(buttonText);
    }
  }
  class CheckBoxListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if(checkBox.isSelected()) {
        textField.setText("CheckBox is selected");
      } else {
        textField.setText("CheckBox is cleared");
      }
    }
  }
  private ButtonListener bl = new ButtonListener();
  private CheckBoxListener cl = new CheckBoxListener();
  @Override
  public void init() {
    button1.addActionListener(bl);
    button2.addActionListener(bl);
    button3.addActionListener(bl);
    checkBox.addActionListener(cl);
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(button1);
    cp.add(button2);
    cp.add(button3);
    cp.add(checkBox);
    cp.add(textField);
  }
  public static void main(String[] args) {
    Console.run(new JButtonJText(), 200, 75);
  }
 }

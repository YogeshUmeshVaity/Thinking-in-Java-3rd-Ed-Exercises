/* Create an applet/application using Console, and add all the 
 * Swing components that have an addActionListener( ) method. 
 * (Look these up in the JDK documentation from java.sun.com. 
 * Hint: use the index.) Capture their events and display an 
 * appropriate message for each inside a text field.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.bruceeckel.swing.*;
 
public class AllAction extends JApplet {
  private JComboBox comboBox = new JComboBox();
  private String[] comboList = {
    "Crow", "Parrot", "Sparrow"
  };
  private JButton button = new JButton("Button");
  private JMenu menu = new JMenu("Edit");
  private JMenuItem menuItem = new JMenuItem("Copy");
  private JToggleButton toggle = new JToggleButton("Toggle");
  private JTextField text = new JTextField(12);
  class Action implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      Object component = e.getSource();
      if(component instanceof JComboBox) {
        text.setText("" +
         ((JComboBox)e.getSource()).getSelectedItem());
        //text.setText("ComboBox");
      } else if(component instanceof JButton) {
        text.setText("Button");
      } else if(component instanceof JMenuItem) {
        text.setText("Menu Item");
      } else if(component instanceof JToggleButton) {
        text.setText("ToggleButton");
      } else if(component instanceof JTextField) {
        text.setText("TextField");
      }
    }
  }
  
  private Action act = new Action();
  
  @Override
  public void init() {
    menuItem.addActionListener(act);
    menu.add(menuItem);
    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
    setJMenuBar(menuBar);
    for(int i = 0; i < comboList.length; i++) {
      comboBox.addItem(comboList[i]);
    }
    comboBox.addActionListener(act);
    button.addActionListener(act);
    text.addActionListener(act);
    toggle.addActionListener(act);
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(button);
    cp.add(text);
    cp.add(comboBox);
    cp.add(toggle);
  }
  
  public static void main(String[] args) {
    Console.run(new AllAction(), 500, 500);
  }
}

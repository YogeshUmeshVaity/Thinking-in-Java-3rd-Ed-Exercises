/* Simplify List.java by passing the array to the constructor and 
 * eliminating the dynamic addition of elements to the list.
 */
 
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import com.bruceeckel.swing.*;

public class List extends JApplet {
  private String[] flavors = {
    "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
    "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
    "Praline Cream", "Mud Pie"
  };
  private JList lst = new JList(flavors);
  private JTextArea t =
    new JTextArea(flavors.length, 20);
  private ListSelectionListener ll =
    new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting()) return;
        t.setText("");
        Object[] items=lst.getSelectedValues();
        for(int i = 0; i < items.length; i++)
          t.append(items[i] + "\n");
      }
    };
  public void init() {
    Container cp = getContentPane();
    t.setEditable(false);
    cp.setLayout(new FlowLayout());
    // Create Borders for components:
    Border brd = BorderFactory.createMatteBorder(
      1, 1, 2, 2, Color.BLACK);
    lst.setBorder(brd);
    t.setBorder(brd);
    cp.add(t);
    cp.add(lst);
    // Register event listeners
    lst.addListSelectionListener(ll);
  }
  public static void main(String[] args) {
    Console.run(new List(), 250, 375);
  }
} ///:~

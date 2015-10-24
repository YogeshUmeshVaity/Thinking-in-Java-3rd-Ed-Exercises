/* Starting with ShowAddListeners.java, create a program with the 
 * full functionality of c10:ShowMethods.java.
 */
 
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.regex.*;
import com.bruceeckel.swing.*;

public class ShowMethods extends JApplet {
  private JTextField name = new JTextField(25);
  private JTextArea results = new JTextArea(40, 65);
  private JTextField methodName = new JTextField(27);
  private static Pattern qualifier =
    Pattern.compile("\\w+\\.");
  class NameL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String nm = name.getText().trim();
      if(nm.length() == 0) {
        results.setText("No match");
        return;
      }
      Class klass;
      String methodNameText = methodName.getText().trim();
      if(methodNameText.length() == 0) {
        try {
          klass = Class.forName(nm);
        } catch(ClassNotFoundException ex) {
          results.setText("No match");
          return;
        }
        Method[] methods = klass.getMethods();
        Constructor[] ctr = klass.getConstructors();
        results.setText("");
        for(int i = 0; i < methods.length; i++) {
          String stringToMatch = methods[i].toString();
          results.append(qualifier.matcher(
            stringToMatch).replaceAll("") + "\n");
        }
        for(int i = 0; i < ctr.length; i++) {
          String stringToMatch = ctr[i].toString();
          results.append(qualifier.matcher(
            stringToMatch).replaceAll("") + "\n");
        }
      } else {
          String word = methodName.getText();
          try {
            klass = Class.forName(nm);
          } catch(ClassNotFoundException ex) {
            results.setText("No match");
            return;
          }
          Method[] methods = klass.getMethods();
          Constructor[] ctr = klass.getConstructors();
          results.setText("");
          for(int i = 0; i < methods.length; i++) {
            if(methods[i].toString().indexOf(word) != -1) {
              String stringToMatch = methods[i].toString();
              results.append(qualifier.matcher(
                stringToMatch).replaceAll("") + "\n");
            }
          }
          for(int i = 0; i < ctr.length; i++) {
            if(ctr[i].toString().indexOf(word) != -1) {
              String stringToMatch = ctr[i].toString();
              results.append(qualifier.matcher(
                stringToMatch).replaceAll("") + "\n");
            }
          }
      }
    }
  }
  public void init() {
    NameL nameListener = new NameL();
    name.addActionListener(nameListener);
    methodName.addActionListener(nameListener);
    JPanel top = new JPanel();
    top.setLayout(new FlowLayout());
    top.add(new JLabel("Word in Method name:"));
    top.add(methodName);
    top.add(new JLabel("Class name (press ENTER):"));
    top.add(name);
    Container cp = getContentPane();
    cp.add(BorderLayout.NORTH, top);
    cp.add(new JScrollPane(results));
    // Initial data and test:
    name.setText("java.lang.String");
    nameListener.actionPerformed(
      new ActionEvent("", 0 ,""));
  }
  public static void main(String[] args) {
    Console.run(new ShowMethods(), 1200, 1200);
  }
}

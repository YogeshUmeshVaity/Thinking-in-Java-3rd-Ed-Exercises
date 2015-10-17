/* Create your own JavaBean called Valve that contains two 
 * properties: a boolean called “on” and an int called “level.” 
 * Create a manifest file, use jar to package your Bean, then 
 * load it into the Bean Builder or into a Beans-enabled program 
 * builder tool so that you can test it.
 */
 
package valve;
import java.awt.*;
import java.awt.event.*;
 
public class Valve {
  private boolean on;
  private int level;
  
  public boolean isOn() { return on; }
  
  public void setOn(boolean n) { on = n; }
  
  public void setLevel(int lvl) {
    level = lvl;
  } 
  
  public int getLevel() {
    return level;
  }
  
  public void addActionListener(ActionListener l) {
    //..
  }
  
  public void removeActionListener(ActionListener l) {
    //..
  }
}

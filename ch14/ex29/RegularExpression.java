/* Turn c12:TestRegularExpression.java into an interactive Swing 
 * program that allows you to put an input string in one TextArea 
 * and a regular expression in a TextField. The results should be 
 * displayed in a second TextArea.
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import com.bruceeckel.swing.*;

public class RegularExpression extends JApplet {
  private JLabel characterSequenceLabel = 
    new JLabel("Enter Character Sequence:");
  private JTextArea characterSequence = new JTextArea(6, 60);
  private JLabel regexTextLabel = 
    new JLabel("Enter Regular Expression:");
  private JTextField regexText = new JTextField(30);
  private JLabel resultsLabel = 
    new JLabel("Results:");
  private JTextArea results = new JTextArea(15, 65);
  
  @Override
  public void init() {
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    
    JPanel characterSequencePanel = new JPanel();
    characterSequencePanel.setLayout(new BorderLayout());
    characterSequencePanel.add(
      BorderLayout.NORTH, characterSequenceLabel);
    characterSequencePanel.add(
      BorderLayout.SOUTH, new JScrollPane(characterSequence));
    cp.add(characterSequencePanel);
    
    JPanel regexTextPanel = new JPanel();
    regexTextPanel.setLayout(new BorderLayout());
    regexTextPanel.add(BorderLayout.NORTH, regexTextLabel);
    regexText.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Pattern p = Pattern.compile(regexText.getText());
        Matcher m = p.matcher(characterSequence.getText());
        while(m.find()) {
          results.append("Match \"" + m.group() + 
          "\" at positions " + m.start() + "-" + 
          (m.end() - 1) + "\n");
        }
      }
    });
    regexTextPanel.add(BorderLayout.SOUTH, regexText);
    cp.add(regexTextPanel);
    
    JPanel resultsPanel = new JPanel();
    resultsPanel.setLayout(new BorderLayout());
    resultsPanel.add(BorderLayout.NORTH, resultsLabel);
    resultsPanel.add(BorderLayout.SOUTH, 
      new JScrollPane(results));
    cp.add(resultsPanel);
    
  }
  
  public static void main(String[] args) {
    Console.run(new RegularExpression(), 750, 450);
  }
}

/* Create an applet/application using Console. Add to the main 
 * frame all the components described in this chapter, including 
 * menus and a dialog box. 
 */

import javax.swing.*;
import javax.swing.event.*;
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
  private JScrollPane scrollPaneTextArea = new JScrollPane(textArea,
    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
  private JTextPane textPane = new JTextPane();
  private JScrollPane scrollPaneTextPane = new JScrollPane(
    textPane);
  private JComboBox comboBox = new JComboBox();
  private String[] comboList = {
    "JellyBean", "KitKat", "Lollipop"
  };
  private DefaultListModel itemList = new DefaultListModel();
  private JList list = new JList(itemList);
  private JTabbedPane tabs = new JTabbedPane();
  private String[] dialogs = {
    "Message Dialog", "Confirm Dialog"
  };
  private JMenuBar menuBar = new JMenuBar();
  private JMenu file = new JMenu("File");
  private JMenuItem save = new JMenuItem("Save");
  private JPopupMenu popup = new JPopupMenu();
  private JMenuItem popupMenuItem = new JMenuItem("Copy");
  
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
    // Text
    cp.add(text);
    cp.add(scrollPaneTextArea);
    textPane.setText("This is a JTextPane");
    cp.add(scrollPaneTextPane);
    // ComboBox
    for(int i = 0; i < comboList.length; i++) {
      comboBox.addItem(comboList[i]);
    }
    cp.add(comboBox);
    // JList
    for(int i = 0; i < comboList.length; i++) {
      itemList.add(0, comboList[i]);
    }
    cp.add(list);
    // JTabbedPane
    for(int i = 0; i < dialogs.length; i++) {
      tabs.addTab(dialogs[i], new JButton("Show " +
        dialogs[i]));
    }
    tabs.addChangeListener(new ChangeListener() {
    
      @Override
      public void stateChanged(ChangeEvent e) {
        if(checkBox.isSelected()) {
          JOptionPane.showMessageDialog(null, "Message Dialog " +
            "test", "AllComponents", JOptionPane.ERROR_MESSAGE);
        } else {
          JOptionPane.showConfirmDialog(null, "Confirm Dialog" +
            " test", "Warning", JOptionPane.DEFAULT_OPTION
            );
        }
        
      }
      
    });
    cp.add(tabs);
    // Menu
    file.add(save);
    menuBar.add(file);
    setJMenuBar(menuBar);
    // Popup Menu
    popup.add(popupMenuItem);
    cp.add(popup);
    addMouseListener(new MouseAdapter() {
    
      @Override
      public void mousePressed(MouseEvent e) {
        maybeShowPopup(e);
      }
      
      @Override
      public void mouseReleased(MouseEvent e) {
        maybeShowPopup(e);
      }
      
      private void maybeShowPopup(MouseEvent e) {
        if(e.isPopupTrigger()) {
          popup.show(((JApplet)e.getComponent())
          .getContentPane(), e.getX(), e.getY());
        }
      }
      
    });
  }
  
  public static void main(String[] args) {
    Console.run(new AllComponents(), 600, 600);
  } 
  
}

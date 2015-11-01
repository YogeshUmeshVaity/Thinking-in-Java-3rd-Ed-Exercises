/* Create a doclet that displays identifiers that might not 
 * follow the Java naming convention by checking how capital 
 * letters are used for those identifiers.
 */


import com.sun.javadoc.*;

public class CheckNameCon {
  // Test identifiers
  public int Name = 3;
  public void Method() {}
  public int name = 6;
  public void method() {}
  
  public static boolean start(RootDoc root) {
    ClassDoc[] classes = root.classes();
    processClasses(classes);
    return true;
  }
  private static void processClasses(ClassDoc[] classes) {
    for(int i = 0; i < classes.length; i++) {
      processOneClass(classes[i]);
    }
  }
  private static void processOneClass(ClassDoc cls) {
    FieldDoc[] fd = cls.fields();
    for(int i = 0; i < fd.length; i++)
      processDocElement(fd[i]);
    MethodDoc[] md = cls.methods();
    for(int i = 0; i < md.length; i++)
      processDocElement(md[i]);
  }
  private static void processDocElement(Doc dc) {
    MemberDoc md = (MemberDoc)dc;

    String idName = md.name();
    if(md.isField()) {
      if(Character.isUpperCase(idName.charAt(0))) {
        System.out.print(idName);
      }
    } else if(md.isMethod()) {
        if(Character.isUpperCase(idName.charAt(0))) {
          System.out.print(idName + "()");
        }
    }
    System.out.println("");
  }
} ///:~

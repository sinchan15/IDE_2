package javaapplication2;

import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
@SuppressWarnings("serial")
public class HelpFrame extends JFrame{

    private TextArea doc;
    private JMenuBar menub1;
   
    public HelpFrame(){
        super("Help_FAQS");
        setLayout(null );

        setSize(400, 400);
   
   initcomponents();
    }

    public static void main (String[] args){
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HelpFrame().setVisible(true);

            }
        });
    }

private void initcomponents(){
    menubar();
    textarea();
}
    public void menubar(){

    menub1= new JMenuBar();
    menub1.setBounds(0 , 0,2000, 30);
    add(menub1);
}
    public void textarea(){
        doc= new TextArea();
        doc.setBounds(0,30,1680,700);
        add(doc);
        String str=" ABOUT JAVA PROJECTS \n"
	                + " A project is a group of source files and the settings with which you build, run, and debug those source files. In the IDE, all Java development has to take place within a project.\n For applications that involve large code bases, it is often advantageous to split your application source code into several projects.\n"+" The IDE builds its project infrastructure directly on top of Apache Ant, the leading build tool for Java applications. The IDE stores all of the information about your project in \n an Ant script, a properties file, and a few XML configuration files. This means that you can build and run your projects outside of the IDE exactly the same as inside the IDE."+
	"\n The IDE includes several project templates designed to support different types of development including web applications, general Java applications, and so forth.\n The IDE's set of standard project templates automatically generate an Ant script and properties. The IDE also contains free-form project templates that you can use to base\n a project on an existing Ant script.\n"+
	" This collection of frequently asked questions (FAQ) provides brief answers to many common questions about the Sun Java Platform, programming language, and the Java 2 Platform.\n\n"+ " 1.)What releases of Java technology are currently available? What do they contain?\n " +
	" The Java programming language is currently shipping from Sun Microsystems, Inc. as the Java 2 SDK and Java 2 Runtime Environment. All Sun releases of the\n  Java 2 Platform software are available from the Java 2 Platform software home page (http://java.sun.com/j2se/).\n" + "  Each release of the Java 2 SDK, Standard Edition contains, Java Compiler, Java Virtual Machine*, Java Class Libraries, Java AppletViewer, Java Debugger and other tools\n  and Documentation (in a separate download bundle).\n "+" To run Java 1.0 applets, use Netscape Navigator 3.x or other browsers that support Java applets. To run Java 1.1.x applets, use HotJava 1.x or Netscape Navigator 4.x\n  or other browsers that support the newest version of the Java API.\n\n "+"2.)What are the security problems I've heard about JavaScript technology scripts?\n"+"  JavaScript technology is a scripting language used with Netscape Navigator. There have been reports of privacy problems with JavaScript technology,\n  and Netscape is committed to addressing those concerns. JavaScript technology cannot be used to invoke Java applets. The privacy problems reported with JavaScript technology\n  are not present in Java applets.\n\n"+" 3.)Will Java technology work with DOS file name limitations (8.3)?\n "+" Java technology relies on files with longer names than the old DOS limits, so if you are running older (pre-Microsoft Windows 95) versions of DOS, Java technology will not work.\n  If you are running a version of DOS (such as the one that comes with Windows 95) that allows long file names, you should not have any problems.\n  Note that older versions of WinZip do not support long file names, even if the installed version of DOS does. You can get a free upgrade of WinZip with support\n  for long file names from their web site.\n\n"+" 4.)What is the difference between an Interface and an Abstract class?\n"+"  An abstract class can have instance methods that implement a default behavior. An Interface can only declare constants and instance methods,\n  but cannot implement default behavior and all methods are implicitly abstract. An interface has all public members and no implementation. An abstract class is a class which\n  may have the usual flavors of class members (private, protected, etc.), but has some abstract methods.\n\n"+" 5.)Explain different way of using thread?\n "+" The thread could be implemented by using runnable interface or by inheriting from the Thread class. The former is more advantageous, 'cause when you are going for\n  multiple inheritance..the only interface can help.\n\n"+" 6.)Difference between HashMap and HashTable?\n "+" The HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls. (HashMap allows null values as key and\n  value whereas Hashtable doesnt allow). HashMap does not guarantee that the order of the map will remain constant over time.\n  HashMap is unsynchronized and Hashtable is synchronized.\n\n"+" 7.)Difference between Swing and Awt?\n "+" AWT are heavy-weight componenets. Swings are light-weight components. Hence swing works faster than AWT.\n\n"+" 8.)What is static in java?\n "+" Static means one per class, not one for each object no matter how many instance of a class might exist. This means that you can use them without creating\n  an instance of a class.Static methods are implicitly final, because overriding is done based on the type of the object, and static methods are attached to a class,\n  not an object. A static method in a superclass can be shadowed by another static method in a subclass, as long as the original method was not declared final.\n  However, you can't override a static method with a nonstatic method. In other words, you can't change a static method into an instance method in a subclass.\n\n"+" 9.) What is final?\n "+" A final class can't be extended ie., final class may not be subclassed. A final method can't be overridden when its class is inherited.\n  You can't change value of a final variable (is a constant).\n\n"+" 10.)What is difference between & and && in java?\n "+" When & is used it will evaluate both the expressions regardless of the fact that it finds first expression as FALSE and only then will it give an answer.\n  Whereas if && was used in place of & , after it had evaluated first expression and had found result of first expression as FALSE,\n  it would not have evaluated second expression. Thus saving time.";
     doc.append(str);
     doc.setEditable(false);
    }
}
package javaapplication2;

import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.BorderLayout;
import java.awt.Component;
import java.io.*;
import java.io.File;
import static javax.swing.KeyStroke.getKeyStroke;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.text.DefaultEditorKit;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.LayeredHighlighter;
import javax.swing.text.LayeredHighlighter.LayerPainter;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
public class myframe extends JFrame implements ActionListener {

    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenu jMenu4;
    private JMenu jMenu3;
    private JMenuItem open;
    private JMenuItem NEW1;
    private JMenuItem SAVE;
    private JTextArea txt;
    private JPanel panel1;
    private JFileChooser file;
    private JTabbedPane JTabbedPane;
    private int read;
    private JMenuItem copy = new JMenuItem();
    private JButton open1;
    String path;
    private JButton save1;
    private JButton compile1;
    private JMenuItem compile;
    private String apath;
    private TextArea output;
    private JMenuItem cut;
    private JMenuItem abs;
    private JMenuItem paste;
    private JMenuItem Exit1;
    private JMenuItem del;
    private JButton del1;
    private JButton paste1;
    private JButton cut1;
    private JButton copy1;
    private JSeparator j1;
    private boolean opened;
    private JMenuItem run;
    private JButton run1;
    private JButton new1;
    private String name1;
    private int j;
    private String s4;
    private JMenuItem help1;
    private String String;
    private int flag;
    private JMenuItem undo;
    private TextField tx;
    protected UndoManager undoManager = new UndoManager();
    private JMenuItem redo;
    private String skey;
    private int n=0;
    private JTextField nobar;
    private JButton undo1;
    private JButton redo1;
    private JProgressBar pb;
    private JLabel label;
    private  Timer timer;
    final static int interval=1000;
    private int status=0;
    private String wholeText;
    private String findString;
    private int ind;
    private JMenuItem FINDSEARCH;
    public myframe() {
        super("NUTSHELL_IDE");
        setLayout(null);

        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initcomponents();

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
               myframe f1= new myframe();

               f1.setVisible(true);
            }
        });


    }

    private void initcomponents() {
        toolbar();
         tabs();
        tabbed1 t1 = new tabbed1();
        j1 = new JSeparator();
        j1.setBounds(0, 60, 1000, 10);
        add(j1);
        menu();
        loc();
   SwingProgressBar();
    }

    public void toolbar() {
        JToolBar bar = new JToolBar();
        bar.setBounds(0, 30, 1800, 30);
        JToolBar bar1=new JToolBar();
        bar1.setBounds(0, 60, 1800, 30);
        new1 = new JButton();
        Icon imgicon = new ImageIcon("icon_new.gif");
        save1 = new JButton();
        new1.setIcon(imgicon);
        new1.addActionListener(this);
        bar.add(new1);

        Icon imgicon4 = new ImageIcon("icon6.gif");
        save1.setIcon(imgicon4);
        save1.addActionListener(this);
        bar.add(save1);
        open1 = new JButton();
        Icon imgicon1 = new ImageIcon("icon_open.gif");
        open1.setIcon(imgicon1);
        open1.addActionListener(this);
        bar.add(open1);
        run1 = new JButton();
        Icon imgicon2 = new ImageIcon("run-icon.png");
        run1.setIcon(imgicon2);
        run1.addActionListener(this);
        bar.add(run1);
        compile1 = new JButton();
        Icon imgicon3 = new ImageIcon("icon9.gif");
        compile1.setIcon(imgicon3);
        compile1.addActionListener(this);
        compile1.addActionListener(new ButtonListener());
        bar.add(compile1);

        cut1 = new JButton();
        Icon imgicon6 = new ImageIcon("icon_cut.gif");
        cut1.setIcon(imgicon6);
        cut1.addActionListener(this);
        bar1.add(cut1);
        copy1 = new JButton();
        Icon imgicon7 = new ImageIcon("icon_copy.gif");
        copy1.setIcon(imgicon7);
        copy1.addActionListener(this);
        bar1.add(copy1);
        paste1 = new JButton();
        Icon imgicon8 = new ImageIcon("icon_paste.gif");
        paste1.setIcon(imgicon8);
        paste1.addActionListener(this);
        bar1.add(paste1);
        del1 = new JButton();
        Icon imgicon9 = new ImageIcon("icon7.gif");

        del1.setIcon(imgicon9);
        del1.addActionListener(this);
        bar1.add(del1);
        undo1 = new JButton();
        Icon imgicon10 = new ImageIcon("icon3.gif");
        undo1.setIcon(imgicon10);
        undo1.addActionListener(this);
        undo1.setEnabled(false);
        bar1.add(undo1);
        redo1 = new JButton();
        Icon imgicon11 = new ImageIcon("icon8.gif");
        redo1.setIcon(imgicon11);
        redo1.addActionListener(this);
        redo1.setEnabled(false);
        bar1.add(redo1);
        add(bar);
        add(bar1);
    }

    public void tabs() {

        JTabbedPane tab1 = new JTabbedPane();
        output = new TextArea(40, 40);
        tab1.addTab("Output", output);
        tab1.setBounds(0, 560, 1270, 140);
        output.setEditable(false);
        add(tab1);



    }
    
public class tabbed1 {

    private final JTabbedPane tab;


    public tabbed1() {

        tab = new JTabbedPane();
        txt = new JTextArea(1300, 1005);
        JPanel p1 = new JPanel();
        p1.setBounds(30, 90, 1270, 470);
        p1.add(txt);
        JScrollPane b1 = new JScrollPane(p1);
        KeyListener keyListener = new KeyListener() {

            public void keyPressed(KeyEvent keyEvent) {
                printIt("Pressed", keyEvent);
            }

            public void keyReleased(KeyEvent keyEvent) {
            }

            public void keyTyped(KeyEvent keyEvent) {
            }

            private void printIt(String title, KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();
                String keyText = KeyEvent.getKeyText(keyCode);
                if (keyCode == KeyEvent.VK_ENTER) {
                    n++;
                    loc();
                }
            }
        };
       txt.addKeyListener(keyListener);
        tab.setBounds(0, 90, 1270, 470);
        tab.addTab("TEXT", b1);
        add(tab);
    }
}




    public void menu() {
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu("File");
        jMenu2 = new JMenu("Edit");
        jMenu3 = new JMenu("Run");
        jMenu4 = new JMenu("Help");
        jMenuBar1.setBounds(0, 0, 8000, 30);
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);
        jMenuBar1.add(jMenu4);
        open = new JMenuItem("open");
        open.setMnemonic(KeyEvent.VK_O);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        open.addActionListener(this);
        NEW1 = new JMenuItem("New");
        NEW1.setMnemonic(KeyEvent.VK_N);
        NEW1.addActionListener(this);
        NEW1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        SAVE = new JMenuItem("Save");
        SAVE.setMnemonic(KeyEvent.VK_S);
        SAVE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        SAVE.addActionListener(this);
        Exit1 = new JMenuItem("Exit");
        Exit1.addActionListener(this);
        Exit1.setAccelerator(getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        copy.setText("Copy");
        copy.setMnemonic(KeyEvent.VK_C);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copy.addActionListener(this);
        paste = new JMenuItem(new DefaultEditorKit.PasteAction());
        paste.setText("Paste");
        paste.setMnemonic(KeyEvent.VK_V);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        paste.addActionListener(this);
        del = new JMenuItem("Delete");
        del.setMnemonic(KeyEvent.VK_D);
        del.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        del.addActionListener(this);
        cut = new JMenuItem("cut");
        cut.addActionListener(this);
        cut.setMnemonic(KeyEvent.VK_X);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        help1 = new JMenuItem("About Us");
        help1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, ActionEvent.ALT_MASK));
        help1.addActionListener(this);
        undo =new JMenuItem("Undo");
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        undo.addActionListener(this);
        undo.setEnabled(false);
        redo =new JMenuItem("Redo");
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        redo.addActionListener(this);
        redo.setEnabled(false);
        txt.getDocument().addUndoableEditListener(
        new UndoableEditListener() {
          public void undoableEditHappened(UndoableEditEvent e) {
            undoManager.addEdit(e.getEdit());
            updateButtons();
          }
        });

        jMenu4.add(help1);
        jMenu1.add(open);
        jMenu1.add(NEW1);
        jMenu1.add(SAVE);
        jMenu1.add(Exit1);
        jMenu2.add(copy);
        jMenu2.add(cut);
        jMenu2.add(paste);
        jMenu2.add(del);
        jMenu2.add(undo);
        jMenu2.add(redo);
        compile = new JMenuItem("Compile");
        compile.setAccelerator(getKeyStroke(java.awt.event.KeyEvent.VK_9,ActionEvent.ALT_MASK ));
        compile.addActionListener(this);
        compile.addActionListener(new ButtonListener());
        run = new JMenuItem("Run");
        run.setAccelerator(getKeyStroke(java.awt.event.KeyEvent.VK_0,ActionEvent.ALT_MASK));
        
        run.addActionListener(this);
        JMenu jmenu4 = new JMenu("Search");
        FINDSEARCH = new JMenuItem("Find");
        
        FINDSEARCH.setMnemonic(KeyEvent.VK_F);
        FINDSEARCH.addActionListener(this);
        FINDSEARCH.setAccelerator(getKeyStroke(java.awt.event.KeyEvent.VK_F,ActionEvent.CTRL_MASK ));

        jmenu4.add(FINDSEARCH);
        jMenuBar1.add(jmenu4);
        jMenu3.add(compile);
        jMenu3.add(compile);
        jMenu3.add(run);
        add(jMenuBar1);


    }

    public void loc (){
       
    	JTextArea t1 =new JTextArea("Total No Of Lines Of Code :");
    	t1.setBounds(0, 710, 170, 20);
    	add(t1);
    	t1.setEditable(false);
    	nobar =new JTextField();

    	nobar.setToolTipText("Line of code");
    	nobar.setBounds(170, 710, 30, 20);
    	nobar.setVisible(true);
    	add(nobar);
    	nobar.setText(n+"");
    	nobar.setEditable(false);
    }

   public void SwingProgressBar() {
 		  pb = new JProgressBar();
		 
		  pb.setIndeterminate(false);
		  pb.setStringPainted(true);
		
		  label = new JLabel("Progress Bar");
		  JPanel panel = new JPanel();
		 
		  panel.add(pb);
		
		  JPanel panel1 = new JPanel();
		  panel1.setLayout(new BorderLayout());
		  panel1.add(panel, BorderLayout.SOUTH);
		  label.setBounds(1060, 710, 130, 20);
		  add(label);
		  panel1.setBounds(1150, 710, 100, 20);
		  add(panel1);
		// setLayeredPane(panel1);
		 
		 panel1.setVisible(true);
		  //Create a timer.
		  timer = new Timer(interval, new ActionListener() {
		  public void actionPerformed(ActionEvent evt) {
		
		 
		
		      if (status == 1){
		  label.setText("");
		      Toolkit.getDefaultToolkit().beep();
		  timer.stop();
		 compile.setEnabled(true);
		  pb.setIndeterminate(false);
		  //pb.setValue(0);
		  String str = "<html>" + "<font color=\"#FF0000\">" + "<b>" +
		  " completed." + "</b>" + "</font>" + "</html>";
		  label.setText(str);
		  
		  }
		 }
		  });
		  
    }
  class ButtonListener implements ActionListener {
       
  public void actionPerformed(ActionEvent ae) {
  compile.setEnabled(false);
  status=0;
  pb.setIndeterminate(true);
  
  label.setText("");
  String str = "<html>" + "<font color=\"#008000\">" + "<b>" +
  "compiling..." + "</b>" + "</font>" + "</html>";
  label.setText(str);
  timer.start();
  }
  }


    @SuppressWarnings({"deprecation", "deprecation"})
    public void actionPerformed(ActionEvent ae) {

        file = new JFileChooser();
        flag=0;
        if ((ae.getSource() == open) || (ae.getSource() == open1)) {


            String s1 = " ";
            if (file.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    File f = file.getSelectedFile();
                    FileReader fr = new FileReader(f);
                    path = f.getAbsolutePath();
                    apath = f.getParent();
                    name1=f.getName();
                    int read;
                    while ((read = fr.read()) != -1) {
                        s1 += (char) read;

                    }
                fr.close();
                } 
                catch (Exception e) {
                    System.out.print(e.getMessage());
                }
                txt.setText(s1);
                n=txt.getLineCount();
                loc();
            }
        }

        if ((ae.getSource() == SAVE) || (ae.getSource() == save1)) {

            save();

        }

        if((ae.getSource()==undo)||(ae.getSource()==undo1)){

        try {
          undoManager.undo();
        } catch (CannotRedoException cre) {
          cre.printStackTrace();
        }
        updateButtons();

        }
        if((ae.getSource()==redo)||(ae.getSource()==redo1)){
     try {
          undoManager.redo();
        } catch (CannotRedoException cre) {
          cre.printStackTrace();
        }
        updateButtons();
}
if (ae.getSource()==FINDSEARCH)
		{
			wholeText=txt.getText();
			findString =JOptionPane.showInputDialog(null, "Find What", "Find",
			JOptionPane.INFORMATION_MESSAGE);
			if(wholeText.contains(findString)){
			ind = wholeText.indexOf(findString,0);
			txt.setCaretPosition(ind);
			
            txt.setSelectionStart(ind);
			txt.setSelectionEnd(ind+findString.length());
		}else
			{
			JOptionPane.showMessageDialog(null," word not found");
             }
    }
        

        if ((ae.getSource() == NEW1)||(ae.getSource()==new1)) {
            
            if (!txt.getText().equals("")) {
                opened = false;
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Text in the Untitled file has changed. \n Do you want to save the changes?",
                        "New File",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

                if (confirm == JOptionPane.YES_OPTION) {
                    save();
                    txt.setText(null);
                    n=0;
                } else if (confirm == JOptionPane.NO_OPTION) {
                    txt.setText(null);
                    n=0;
                }
            }
            	loc();
        }
                textTransfer t1 = new textTransfer();

        if ((ae.getSource() == copy) || (ae.getSource() == copy1)) {
            t1.setClipboardContents(txt.getSelectedText());

        }

        if ((ae.getSource() == cut) || (ae.getSource() == cut1)) {

            t1.setClipboardContents(txt.getSelectedText());
            txt.replaceRange("", txt.getSelectionStart(), txt.getSelectionEnd());
        }

        if ((ae.getSource() == del) || (ae.getSource() == del1)) {
            txt.replaceRange("", txt.getSelectionStart(), txt.getSelectionEnd());
        }
        if ((ae.getSource() == paste) || (ae.getSource() == paste1)) {
            txt.append(t1.getClipboardContents());

        }

        if(ae.getSource()==Exit1){
                 if (!txt.getText().equals("")) {
                opened = false;
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Text in the Untitled file has changed. \n Do you want to save the changes?",
                        "New File",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

                if (confirm == JOptionPane.YES_OPTION) {
                    save();

                } else if (confirm == JOptionPane.NO_OPTION) {
                    txt.setText(null);
                }
            }
                 if(txt.getText().equals("")){
                     System.exit(0);
                 }
            
        }

                if ((ae.getSource() == compile) || (ae.getSource() == compile1)) {

                	String s = null;
                	label.setText("");
            
                	try {

	                // run the Unix "ps -ef" commandT
	                // using the Runtime exec method:
	                
	                Process p = Runtime.getRuntime().exec("javac " + path);
	                BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	                BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
	                // read the output from the command
	                output.setText("Here is the standard output of the command:\n");
	                while ((s = stdInput.readLine()) != null) {
	                    output.setText(s);
                }

                // read any errors from the attempted command
                output.append("Here is the standard error of the command (if any):\n");
                while ((s = stdError.readLine()) != null) {
                    output.append(s);
                }

            } catch (IOException e) {
                output.append("exception happened - here's what I know: ");
                e.printStackTrace();

            }
                	status=1;
            
        }

    if(ae.getSource()==help1){
        HelpFrame help12= new HelpFrame();
        help12.setVisible(true);

    }

                if ((ae.getSource()==run)||(ae.getSource()==run1)) {
				  boolean status1=true;
				  run.setEnabled(false);
				  status=0;
				  pb.setIndeterminate(status1);
				
				  label.setText("Progress ");
				  String str = "<html>" + "<font color=\"#008000\">" + "<b>" +
				  "running..." + "</b>" + "</font>" + "</html>";
				  label.setText(str);
				  timer.start();
				  String s3="";
				  try{
                    File f = new File(path);
                    FileReader fr = new FileReader(f);
                    int read;
                    while ((read = fr.read()) != -1) {
                        s3 += (char) read;

                    }
                    fr.close();
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
                String s5 = "";
            int n1=name1.length();
            s4="";
            String s1="";
                for(int i=0;i<n1;i++){
                  if(s1.endsWith(".")){
                   j=i;
  
                }
                        s1 += name1.charAt(i);

                }
 

              for (int k = 0; k<j-1; k++) {

                    s4+=s1.charAt(k);
                    output.setText(null);
                    }
            try {
                
                // run the Unix "ps -ef" commandT
                // using the Runtime exec method:
                Process p1 = Runtime.getRuntime().exec("java -classpath "+apath+" "+s4);
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(p1.getInputStream()));
                BufferedReader stdError = new BufferedReader(new InputStreamReader(p1.getErrorStream()));
                // read the output from the command
                //output.setText("Here is the standard output of the command:\n");
                while ((s5 = stdInput.readLine()) != null) {
                    output.setText(" "+s5);
             
                }

                // read any errors from the attempted command
                //output.setText("Here is the standard error of the command (if any):\n");
                while ((s5 = stdError.readLine()) != null) {
                    output.append(s5);
                }
                status=1;

            } catch (IOException e) {
             
            	try {


                // run the Unix "ps -ef" commandT
                // using the Runtime exec method:
                Process p1 = Runtime.getRuntime().exec("appletviewer "+apath+" "+s4);

                BufferedReader stdInput = new BufferedReader(new InputStreamReader(p1.getInputStream()));

                BufferedReader stdError = new BufferedReader(new InputStreamReader(p1.getErrorStream()));

                // read the output from the command
                //output.setText("Here is the standard output of the command:\n");
                while ((s5 = stdInput.readLine()) != null) {
                    output.setText(" "+s5);

                }
                // read any errors from the attempted command
                //output.setText("Here is the standard error of the command (if any):\n");
                while ((s5 = stdError.readLine()) != null) {
                    output.append(s5);
    }
                } catch (IOException e1) {
                output.append("exception happened - here's what I know: ");
                e1.printStackTrace();

            }
             status=1;
            }
    
        
        }
   
    }

public void updateButtons() {

    undo.setText(undoManager.getUndoPresentationName());
    redo.setText(undoManager.getRedoPresentationName());
    undo.setEnabled(undoManager.canUndo());
    redo.setEnabled(undoManager.canRedo());

    undo1.setEnabled(undoManager.canUndo());
    redo1.setEnabled(undoManager.canRedo());
  }
    public void save() {
        System.out.println("save");
        if (file.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                File f1 = file.getSelectedFile();
                path=f1.getAbsolutePath();
                apath=f1.getParent();
                name1=f1.getName();
                FileWriter fr1 = new FileWriter(f1);
                fr1.write(txt.getText());


              fr1.close();

            } catch (Exception e1) {
                System.out.print(e1.getMessage());
            }
        }



    }
}

import javax.swing.JButton;;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Ej_2_AppInteractua extends JFrame {
    public static void main(String[] args){
        Ej_2_AppInteractua applet = new Ej_2_AppInteractua();
        applet.init();
    }
    private JPanel panel = new JPanel();
    private JButton start = new JButton("Empezar");
    private JButton onoff = new JButton("On/Off");
    private JTextField t = new JTextField(10);
    private boolean runflag = true;
    private int count = 0;
    public void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.addActionListener((e)-> go());
        onoff.addActionListener((e)->runflag = !runflag);
        panel.add(t);
        panel.add(start);
        panel.add(onoff);
        this.getContentPane().add(panel);
        this.pack();
        this.setVisible(true);
    }
    public void go() {
        while (true) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException ex) {}
            if (runflag) {
                t.setText(Integer.toString(count++));
            }
        }
    }
}

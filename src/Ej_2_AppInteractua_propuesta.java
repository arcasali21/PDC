import javax.swing.*;

public class Ej_2_AppInteractua_propuesta extends JFrame {

    public static void main(String[] args){
        Ej_2_AppInteractua_propuesta applet = new Ej_2_AppInteractua_propuesta();
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

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException ex) {}
                    if (runflag) {
                        t.setText(Integer.toString(count++));
                    }
                }
            }
        });

        hilo.start();

    }
}

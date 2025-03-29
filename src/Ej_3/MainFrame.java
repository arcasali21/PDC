package Ej_3;

import javax.swing.*;

public class MainFrame extends JFrame{
    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame();
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        DosContadores dosContadores =
                new DosContadores(mainFrame.getContentPane());
        Observador observador = new Observador(dosContadores);
        mainFrame.pack();
        mainFrame.setVisible(true);
        dosContadores.start();
        observador.start();
    }
}

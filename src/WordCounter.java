import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class WordCounter extends Component {

    private JTextArea tekst;
    private JButton licz;
    private JButton txtcolor;
    private JButton bkgc;
    private JLabel zna;
    private JLabel slo;
    private JPanel panel;
    private JButton reset;
    private JLabel bs;
    private JLabel lin;
    private JScrollPane sp;


    WordCounter() {
        JFrame frame = new JFrame("Word counter");
        frame.add(panel);
        frame.setSize(800, 400);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        licz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tekst.getText();
                zna.setText("Znaki: " + text.length());
                int text_bezspacji = text.replace(" ", "").replace("\t", "").replace("\n", "").length();
                bs.setText("Znaki (bez spacji): " + text_bezspacji);
                String[] slowa = text.replace("\n", " ").split("\\s");
                slo.setText("Słowa: " + slowa.length);
                String[] lines = text.split("\r\n|\r|\n");
                lin.setText("Linie: " + lines.length);

            }
        });
        bkgc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(tekst, "Wybierz kolor który chcesz użyć", Color.black);
                tekst.setBackground(c);
            }
        });
        txtcolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(tekst, "Wybierz kolor który chcesz użyć", Color.black);
                tekst.setForeground(c);
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zna.setText("Znaki: ");
                bs.setText("Znaki (bez spacji): ");
                slo.setText("Słowa: ");
                lin.setText("Linie: ");
                tekst.setText("");
            }
        });
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int themeIndex;
        // Enter username and press Enter
        System.out.println("Wybierz motyw: (1-Light 2-Dark 3-LightIJ 4-Dracula)");
        themeIndex = myObj.nextInt();
        System.out.println("Aplikacja zostanie otwarta w nowym oknie:");
        try {
            if (themeIndex == 1) {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } else if (themeIndex == 2) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else if (themeIndex == 3) {
                UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
            } else if (themeIndex == 4) {
                UIManager.setLookAndFeel(new FlatDraculaIJTheme());
            }
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        new WordCounter();
    }
}
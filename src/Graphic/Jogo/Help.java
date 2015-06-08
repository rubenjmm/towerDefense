package Graphic.Jogo;

import com.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame de ajuda
 */
public class Help {

    private static JFrame frame2;
    private static JPanel help;
    //private WebViewSample webView;

    /**
     * Construtor
     */
    public Help() {

        frame2 = new JFrame("Help");
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        frame2.setSize(950, 550);
        help = new JPanel();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        help.setLayout(new BoxLayout(help, BoxLayout.Y_AXIS));

        JButton b_close = new JButton("Close");
        help.add(b_close);
        b_close.setPreferredSize(new Dimension(80, 0));


        b_close.addActionListener(new close());

        frame2.add(help);

        //webView = new WebViewSample();
    }

    /**
     * exit
     */
    class close implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            frame2.setVisible(false);
            frame2.dispose();
        }
    }
}

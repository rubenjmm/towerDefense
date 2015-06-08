package Graphic.Jogo;


import com.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Popup com o menu de configurações do jogo
 */
public class Config {

    private static JFrame frame2;
    private static JPanel Config_panel;

    /**
     * Construtor do menu
     */
    public Config() {

        frame2 = new JFrame("Configurations");
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        frame2.setSize(250, 250);
        Config_panel = new JPanel();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Config_panel.setLayout(new BoxLayout(Config_panel, BoxLayout.Y_AXIS));

        JButton easy = new JButton("easy_difficulty");
        JButton normal = new JButton("normal_difficulty");
        JButton hard = new JButton("hard_difficulty");
        JButton custom = new JButton("Custom");
        JButton b_close = new JButton("Close");

        Config_panel.add(easy);
        easy.setPreferredSize(new Dimension(80, 0));
        Config_panel.add(Box.createVerticalStrut(25));

        Config_panel.add(normal);
        normal.setPreferredSize(new Dimension(80, 0));
        Config_panel.add(Box.createVerticalStrut(25));

        Config_panel.add(hard);
        hard.setPreferredSize(new Dimension(80, 0));
        Config_panel.add(Box.createVerticalStrut(25));

        Config_panel.add(custom);
        custom.setPreferredSize(new Dimension(80, 0));
        Config_panel.add(Box.createVerticalStrut(25));

        Config_panel.add(b_close);
        b_close.setPreferredSize(new Dimension(80, 0));


        easy.addActionListener(new easy());
        normal.addActionListener(new normal());
        hard.addActionListener(new hard());
        custom.addActionListener(new custom());
        b_close.addActionListener(new close());

        frame2.add(Config_panel);
    }

        class easy implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                gui_easy();
            }
        }

        class normal implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                gui_normal();
            }
        }

        class hard implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                gui_hard();
            }
        }

        class custom implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                gui_custom();
            }
        }

        class close implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                frame2.setVisible(false);
                frame2.dispose();
            }
        }


    /**
     * define dificuldade easy
     */
    public void gui_easy() {

        int value = JOptionPane.showConfirmDialog(null,"Tem a certeza que pretende alterar a dificuldade?");
        if(value==0) {
            Main.getOptions().easy_difficulty();
        }
    }

    /**
     * define dificuldade normal
     */
    public void gui_normal() {
        int value = JOptionPane.showConfirmDialog(null,"Tem a certeza que pretende alterar a dificuldade?");
        if(value==0) {
            Main.getOptions().normal_difficulty();
        }
    }

    /**
     * define dificuldade hard
     */
    public void gui_hard() {
        int value = JOptionPane.showConfirmDialog(null,"Tem a certeza que pretende alterar a dificuldade?");
        if(value==0) {
            Main.getOptions().hard_difficulty();
        }
    }

    /**
     * define dificuldade custom
     * @see Graphic.Jogo.Config_custom
     */
    public void gui_custom() {

        Config_custom confg_custom = new Config_custom();
        frame2.setVisible(false);
        frame2.dispose();
    }

}

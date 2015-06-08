package Graphic.Jogo;


import com.Main;

import javax.swing.*;
import java.awt.*;


/**
 * Frame do jogo
 */
public class Frame extends JFrame  {

    private Draw_game jogo;
    private Loja loja;

    private int HEIGHT=Main.getMap().getcolunas()*25;
    private int WIDTH=Main.getMap().getlinhas()*24+100;

    /**
     * exit
     */
    public void close() {

        setVisible(false);
        dispose();
    }

    /**
     * construtor da frame do jogo
     */
    public Frame() {

        jogo = new Draw_game();
        loja = Main.getLoja();
        setTitle("Tower Defense");
        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());

        //setBounds(0,0,WIDTH,HEIGHT);
        //setPreferredSize(new Dimension(HEIGHT,WIDTH));
        //pack();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;//FIRST_LINE_START
        gbc.fill = GridBagConstraints.BOTH;//BOTH
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;


        content.add(jogo, gbc);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        content.add(loja, gbc);

        setContentPane(content);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

}

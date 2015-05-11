package com.company;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Ricardo on 26/04/2015.
 */
public class Mapa {

    private char mapa[][];
    private int linhas,colunas;
    private   Image grass1,ground4,Background;



    public Mapa() {

        ImageIcon img = new ImageIcon("Textures/Mapas/quadrados/grass1.png");
        grass1 = img.getImage();

        img = new ImageIcon("Textures/Mapas/DS - Rondo of Swords - Map 24.png");
        Background = img.getImage();

        img = new ImageIcon("Textures/Mapas/quadrados/ground4.png");
        ground4 = img.getImage();
    }

    public void draw_board(Graphics g) {

        if(Main.getLevel()==1) {
            draw_lvl1(g);
        }
    }

    public void draw_lvl1(Graphics g){
        g.drawImage(Background, 0, 0, null);

        for (int x = 0; x < colunas; x++) {
            for (int y = 0; y < linhas; y++) {
                if (mapa[y][x] == 'w') {
                    g.drawImage(ground4, x * 24, y * 25, null);
                }
            }
        }
    }

    public void draw_lvl2(Graphics g) {

    }

    public void print_map() {

        System.out.println("linhas-> "+linhas+"       colunas-> "+colunas+"\n");
        for(int i=0;    i<linhas;    i++){
            for(int j=0 ;j<colunas;    j++){
                System.out.print( mapa[i][j] );
            }
            System.out.println();
        }
    }

    //////////////////////////////////// GETTER & SETTER ////////////////////////////////////////////////

    public char[][] getMapa() {
        return mapa;
    }

    public void setMapa(char[][] mapa) {
        this.mapa = mapa;
    }

    public int getlinhas() {
        return linhas;
    }

    public void setlinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getcolunas() {
        return colunas;
    }

    public void setcolunas(int colunas) {
        this.colunas = colunas;
    }
}

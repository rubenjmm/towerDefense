package Graphic.Jogo;


import com.Main;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Classe que anima os varios objectos do jogo
 */
public class Animator {

    private ArrayList<BufferedImage> frames;
    private volatile boolean running = false;

    private boolean deu_reset=false;//variàvel usada para saber se o monstro fez uma animacao completa da lista
    public boolean isdeu_reset() {
        return deu_reset;
    }

    private BufferedImage sprite;

    private long prevTime, speed;
    private int frameatPause,currentFrame;

    /**
     * Construtor
     * @param frames lista de imagens para animar
     */
    public Animator( ArrayList<BufferedImage> frames ) {
        this.frames = frames;
    }

    /**
     * Define velocidade de animação
     * @param speed velocidade de animação
     */
    public void setSpeed(long speed){
        this.speed = speed;
    }

    /**
     * Actualiza animação com o passar do tempo
     * @param time tempo actual
     */
    public void update(long time){
        if(running && Main.getState()== Main.STATE.GAME){
            if(time - prevTime >= speed){
                currentFrame++;
                try{
                    if(currentFrame <= frames.size()){
                        sprite = frames.get(currentFrame);
                        deu_reset=false;
                    }else{
                        reset();
                    }
                }catch(IndexOutOfBoundsException e){
                    reset();
                    sprite = frames.get(currentFrame);
                }
                prevTime = time;
            }
        }
    }

    /**
     * Define o estado da animação para a correr
     */
    public void play(){
        running = true;
        prevTime = 0;
        frameatPause = 0;
        currentFrame = 0;
    }

    /**
     * Para a animação
     */
    public void stop(){
        running = false;
        prevTime = 0;
        frameatPause = 0;
        currentFrame = 0;
    }

    /**
     * Pausa a animação
     */
    public void pause(){
        frameatPause = currentFrame;
        running = false;
    }

    /**
     * Retoma a animação
     */
    public void resume(){
        currentFrame = frameatPause;
    }

    /**
     * Reinicia a animação
     */
    public void reset(){
        currentFrame = 0;
        deu_reset = true;
    }

    /**
     * Verifica se a animação já chegou ao fim
     * @return animação chegou ao fim
     */
    public boolean isDoneAnimating(){
        if(currentFrame == frames.size()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return Imagem actual na animação
     */
    public BufferedImage getSprite() {
        return sprite;
    }

    /**
     * @return index da frame actual
     */
    public int getCurrentFrame()
    {
        return currentFrame;
    }
}
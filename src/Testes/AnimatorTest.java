package Testes;

import Enemys.GoblinSprites;
import Graphic.Jogo.Animator;
import com.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class AnimatorTest
{
    private Animator animate1;
    private Animator animate2;

    @Before
    public void setUp() throws Exception
    {
        animate1 = new Animator(GoblinSprites.getSpriteWalking());
        animate1.setSpeed(1);
        animate1.play();
    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void testUpdate() throws Exception
    {
        int frame0 = animate1.getCurrentFrame();
        assertEquals(0, frame0);

        animate1.update(10);

        assertEquals(0, animate1.getCurrentFrame());

        Main.setState('G');

        animate1.update(11);

        assertEquals(1, animate1.getCurrentFrame());

        animate1.pause();

        animate1.update(12);

        assertEquals(1, animate1.getCurrentFrame());
    }

}
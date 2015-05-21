package Buildings;



/**
 * Created by Ricardo on 17/05/2015.
 */
public class Building1 extends Base_building {


    //ANIMACOES
    /*
       1 -> left
       2 -> left/up
       3 -> up
       4 -> right/up
       5 -> right
       6 -> right/down
       7 -> down
       8 -> left/down
     */

    public Building1 (int x,int y , int r) {

        atack_delay = 1500;//ms
        atack = 15; //Damage

        inic();

        this.posx_b=x;
        this.posy_b=y;
        this.raio = r;

        posx=posx_b*24;
        posy=posy_b*25;

        // Default image
        img1 = Building1_sprites.getA11();
        img2 = Building1_sprites.getA21();
    }

    @Override
    public void change_animation() {

        if(animation_actual_state==1){
            img1=Building1_sprites.getA15();
            img2=Building1_sprites.getA25();

        }
        else if(animation_actual_state==2) {

            img1=Building1_sprites.getA13();
            img2=Building1_sprites.getA23();

        }
        else if(animation_actual_state==3) {

            img1=Building1_sprites.getA12();
            img2=Building1_sprites.getA22();
        }
        else if(animation_actual_state==4) {

            img1=Building1_sprites.getA14();
            img2=Building1_sprites.getA24();
        }
        else if(animation_actual_state==5) {

            img1=Building1_sprites.getA16();
            img2=Building1_sprites.getA26();
        }
        else if(animation_actual_state==6) {

            img1=Building1_sprites.getA18();
            img2=Building1_sprites.getA28();

        }
        else if(animation_actual_state==7) {

            img1=Building1_sprites.getA11();
            img2=Building1_sprites.getA21();
        }
        else  {

            img1=Building1_sprites.getA17();
            img2=Building1_sprites.getA27();
        }

    }

}

package Buildings;

/**
 * Created by Ricardo on 17/05/2015.
 */
public class Type_building {


    public Base_building get_building(int id,int x,int y) {

        if(id == 1){
            return  new Building1( x, y ) ;
        }
        else
            return new Base_building(x,y,5);
    }

}

package Buildings;

/**
 * Created by Ricardo on 17/05/2015.
 */
public class TypeBuilding
{
    public BaseBuilding getBuilding(int id, int x, int y) {

        if(id == 1){
            return  new Building1(x, y);
        }
        if(id == 2){
            return new StormTrooper(x, y);
        }
        if(id == 3){
            return new Turret(x, y);
        }
        if(id == 4)
        {
            return new Cannon(x, y);
        }
        else
            return new BaseBuilding(x,y,5);
    }

}

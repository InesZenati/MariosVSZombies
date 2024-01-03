public class WallBrick extends Mario{
    WallBrick(){
        super("WallBrick",0,new Information(0,0,-1,-1,500));
    }
    public void takeDamage(int degat){
        this.getInfoActuelle().setvie(this.getInfoActuelle().getvie() - degat);
    }
}

public class WallBrick extends Mario{
    WallBrick(){
        super("WallBrick",0,new Information(0,0,-1,-1,500));
    }
    public void attaque(Plateau p){
    }
    public boolean peutAttaquer(Plateau p){
        return false;
    }
}

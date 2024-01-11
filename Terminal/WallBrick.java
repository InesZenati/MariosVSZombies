public class WallBrick extends Mario{
    WallBrick(){
        super("WallBrick",200,new Information(0,0,-1,-1,500));
    }
    public void attaque(Plateau p){
    }
    public boolean peutAttaquer(Plateau p){
        return false;
    }
    public String estDevant(Plateau p){
        return"Wallmario";
    }

    public String getImagePath(){
        return "BasicMario.png";
    }
}

public class WallBrick extends Mario{
    WallBrick(){
        super("WallBrick",30,new Information(0,0,100));
    }
    public void attaque(Plateau p){
        p.getJoueur().incrementerArgent(10);
    }
    public void attaque(PlateauGUI pGui){
        pGui.getJeuGUI().getJoueur().incrementerArgent(10);
    }
    public boolean peutAttaquer(Plateau p){
        return true;
    }
    public String estDevant(Plateau p){
        return"Wallmario";
    }

    public String getImagePath(){
        return "WallBrick.png";
    }
}

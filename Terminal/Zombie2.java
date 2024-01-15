public class Zombie2 extends Zombie {
    public Zombie2(int v){
        super("ZombieAmélioré",30,v,new Information(2,2,15));
    }

    public String getImagePath(){
        return "zombie2.png";
    }
}

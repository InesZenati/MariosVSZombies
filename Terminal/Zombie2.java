public class Zombie2 extends Zombie {
    public Zombie2(int v){
        super("ZombieAmélioré",30,v,new Information(6,4,-1,-1,10));
    }

    public String getImagePath(){
        return "BasicMario.png";
    }
}

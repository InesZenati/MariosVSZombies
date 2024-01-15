public class Zombie1 extends Zombie {
    public Zombie1( int v){
        super("ZombieSimple",10,v,new Information(1,0,10));
    }

    public String getImagePath(){
        return "zombie1.png";
    }
    

}
public class Zombie4 extends Zombie{
    public Zombie4(int x,int y,int v){
        super("SuperMegaUltraZombie",500,v,new Information(10,10,x,y,50));
    }

    public Zombie4(int v){
        super("SuperMegaUltraZombie",500,v,new Information(8,10,-1,-1,50));
    }
    public String getImagePath(){
        return "Zombie.png";
    }
    
}

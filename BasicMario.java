public class BasicMario extends Mario{

    BasicMario(int x, int y){
        super("BasicMario",10,new Information(2,0,x,y,10));
    }
    public void attaque(Zombie z){
       
    }

    public Information getInfo(){
        return super.getInfoInitale();
    }
    
}

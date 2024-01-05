public class BasicMario extends Mario{
    BasicMario(){
        super("BasicMario",10,new Information(2,0,-1,-1,10));
    }


    public void attaque (Plateau p){
        int[] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]+1).contientZombie()){
                Personnage m = p.getCase(pos[0],pos[1]+1).getPersonnage();
                if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                    m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                }
                else{
                    m.takeDamage(this.getInfoActuelle().getAttaque());
                }
        }
    }
    
public boolean aGagner(Plateau p){
    int [] pos = this.getPosition();
    if((p.getCase(pos[0],pos[1]+1).contientZombie())){
       if(p.getCase(pos[0],pos[1]+1).getPersonnage().getInfoActuelle().getvie()<=0){
        p.removeZombie(pos[0],pos[1]+1);
       }
        return true;
     }
    return false;
    }

}

public class BasicMario extends Mario{
    BasicMario(){
        super("BasicMario",10,new Information(2,1,-1,-1,10));
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

    public boolean peutAttaquer(Plateau p){
        // System.out.println(1);
       int [] pos = this.getPosition();
        int li = pos[0];
        int col = pos[1];
       //  System.out.println(2);
         if(p.getCase(li,col+1).contientZombie2()){
            System.out.println(3);
             return true;
         }else{
             System.out.println("non");
            // p.affiche();
         }
      //   System.out.println(5);
         return false;
     }

public boolean aGagner(Plateau p){
    int [] pos = this.getPosition();
    if((p.getCase(pos[0],pos[1]+1).contientZombie())&&this.estVivant()){
       if(!p.getCase(pos[0],pos[1]+1).getPersonnage().estVivant()){
        p.removeZombie(pos[0],pos[1]+1);
        return true;
       }
     }
    return false;
    }

}

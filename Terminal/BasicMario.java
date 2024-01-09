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
                    //m.attaque(p);
                }
                else{
                    m.takeDamage(this.getInfoActuelle().getAttaque());
                }
                m.aGagner(p, m);
        }
    }
    public String estDevant(Plateau p){
        int [] pos = this.getPosition();
        int li = pos[0];
        int col = pos[1]+1;
        if(pos[1]!=p.getNumCols()-1){
        return("Mario devant Zombie :"+p.getCase(li,col).contientZombie());
        }
        return ("Mario face à entrée");
    }

    public boolean peutAttaquer(Plateau p){
       int [] pos = this.getPosition();
        int li = pos[0];
        int col = pos[1];
         if(p.getCase(li,col+1).contientZombie()){
             return true;
         }
         return false;
     }

<<<<<<< HEAD
public boolean aGagner(Plateau p){
    int [] pos = this.getPosition();
    if((p.getCase(pos[0],pos[1]+1).contientZombie())&&this.estVivant()){
       if(!p.getCase(pos[0],pos[1]+1).getPersonnage().estVivant()){
        //System.out.println("Le Zombie est mort");
        p.removeZombie(pos[0],pos[1]+1);
        return true;
       }
     }
     /*if(!this.estVivant()){
        p.removeMario(pos[0], pos[1]);
        return false;
     }*/
     //System.out.println("Vie du Zombie :"+p.getCase(pos[0],pos[1]+1).getPersonnage().getInfoActuelle().getvie());
    return false;
    }

    public String getImagePath(){
        return "BasicMario.png";
    }

=======
>>>>>>> 6cba05872efadaa90ed348c776e6a2fafe3d1bf4
}

public class StarMario extends Mario{
    public StarMario(){
        super("StarMario",150, new Information(10,10,-1,-1,100));
    }
    public void takeDamage(int degat){
        this.getInfoActuelle().setvie(this.getInfoActuelle().getvie() - degat);
    }

    public void attaque (Plateau p){
        int[] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]+1)!=null){ 
        if(p.getCase(pos[0],pos[1]+1).contientZombie()){
            Personnage m =  p.getCase(pos[0],pos[1]+1).getPersonnage();
            if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){
                m.takeDamage(this.getInfoActuelle().getAttaque()/2);
                p.getJoueur().incrementerArgent(3);
            }else{
                m.takeDamage(this.getInfoActuelle().getAttaque());
                p.getJoueur().incrementerArgent(3);
            }
            this.aGagner(p,m);
        }
    }
    }
    

    public String estDevant(Plateau p){
        return"Starmario";
    }

    public boolean peutAttaquer(Plateau p){
       int [] pos = this.getPosition();
        int li = pos[0];
        int col = pos[1];
       if(p.getCase(li,col+1)!=null){ 
         if(p.getCase(li,col+1).contientZombie()){
             return true;
         }
     } 
     return false;
    }

     public String getImagePath(){
        return "SuperMario.png";
    }

}

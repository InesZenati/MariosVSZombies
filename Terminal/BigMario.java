public class BigMario extends Mario{
    public BigMario(){
        super("BigMario",70,new Information(6,10,20));
    }
    public void attaque(Plateau p){
        int [] pos = this.getPosition();
        for(int i=1;i<3;i++){
            if(p.getCase(pos[0], pos[1]+i)!=null){
            if(p.getCase(pos[0], pos[1]+i).contientZombie()){
                Personnage z1 = p.getCase(pos[0],pos[1]+i).getPersonnage();
                z1.takeDamage(z1.getInfoActuelle().getvie()/2);
                p.getJoueur().incrementerArgent(5);
                this.aGagner(p, z1);
            }
        }
        }
    }  
    public boolean peutAttaquer(Plateau p){
       int [] pos = this.getPosition();
        int li = pos[0];
        int col = pos[1];
       for(int i=1;i<3;i++){
            if(p.getCase(li,col+i)!=null){ 
                if(p.getCase(li,col+i).contientZombie()){
                    return true;
                }
            } 
        }   
        return false;
    }

    public String estDevant(Plateau p){
        return"Bigmario";
    }

    public String getImagePath(){
        return "BigMario.png";
    }
}


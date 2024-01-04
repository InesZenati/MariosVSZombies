public abstract class Zombie extends Personnage {
    private final int gain;
    private int vitesse;

    Zombie(String name,int g, int v, Information i){
        super(false,name);
        this.gain=g;
        this.vitesse=v;
        this.setInfoActuelle(i);
    }
    public int getVitesse(){
        return this.vitesse;
    }
    public void setVitesse(int v){
        this.vitesse=v;
    }
    @Override
    public String toString(){
        String v;
        switch (this.getVitesse()) {
            case 0:
                v = "lent";
                break;
            case 1 :
                v = "moyen";
                break;
            case 2 :
                v= "rapide";
                break;
            default: v= "non-defini";
                break;
        }
        return this.getName() + " \n Point de vie :" + this.getInfoActuelle().getvie() + " \n Attaque :" + this.getInfoActuelle().getAttaque() + " \n Defense :" +
         this.getInfoActuelle().getDefense()+" \n Vitesse :"+v+" \n Gain :"+this.gain;
    }


    public void takeDamage(int degat){
        this.getInfoActuelle().setvie(this.getInfoActuelle().getvie() - degat);
    }
    public boolean peutAttaquer(Plateau p){
        int [] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]-1).contientMario()){
            return true;
        }
        return false;
    }

    public void attaquer(Plateau p){
        int [] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]-1).contientMario()){
              if(p.getCase(pos[0], pos[1]-1).getPersonnage().getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){;
                    p.getCase(pos[0], pos[1]-1).getPersonnage().takeDamage(this.getInfoActuelle().getAttaque()/2);
                }
                else{
                    p.getCase(pos[0], pos[1]-1).getPersonnage().takeDamage(this.getInfoActuelle().getAttaque());
                }
    }
}

public boolean peutDeplacer(Plateau p){ 
    int [] pos = this.getPosition();
    int col = pos[1];
    int li = pos[0];
    if(col>0){
    if(!p.getCase(li,col-1).contientMario()&& !p.getCase(li,col-1).contientZombie()){
        return true;
    }
}
    return false;
}
    
} 
    


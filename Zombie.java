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
    public boolean peutAttaquer(Plateau p){
        int [] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]-1).contientMario()){
            return true;
        }
        return false;
    }

    public void attaque(Plateau p){
        int [] pos = this.getPosition();
        if(p.getCase(pos[0],pos[1]-1).contientMario()){
            Personnage m = p.getCase(pos[0],pos[1]-1).getPersonnage();
            if(m.getInfoActuelle().getDefense()>this.getInfoActuelle().getAttaque()){;
                m.takeDamage(this.getInfoActuelle().getAttaque()/2);
            }else{
                m.takeDamage(this.getInfoActuelle().getAttaque());
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
    


public class Zombie extends Personnage {
    private final int gain;
    private int vitesse;
   // private final Information InfoInitiale;
    private final Information InfoInitiale;


    Zombie(String name,int g, int v, Information i){
        super(false,name);
        this.gain=g;
        this.vitesse=v;
        this.InfoInitiale=i;
        this.setInfoActuelle(i);
    }
    public int getVitesse(){
        return this.vitesse;
    }
    public void setVitesse(int v){
        this.vitesse=v;
    }
    public Information getInfoInitiale(){
        return this.InfoInitiale;
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

    public void spawn(Plateau p){
         int i = p.getNumCols()-1;
        int j = 1+(int)(Math.random() * ((p.getNumLi()-1) ));
        while (p.getCase(i,j).getPerso() != null){
         i = p.getNumCols()-1;
         j = 1+(int)(Math.random() * ((p.getNumLi()-1) ));
        // p.getNumCols()-1;
        }
        this.InfoInitiale.setPosX(i);
        this.InfoInitiale.setPosY(j);
        p.getCase(i,j).setZombie(this);
        
    }
    public void takeDamage(int degat){
        this.getInfoActuelle().setvie(this.getInfoActuelle().getvie() - degat);
    }
    
} 
    

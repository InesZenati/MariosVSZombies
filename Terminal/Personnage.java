public abstract class Personnage {
    private boolean tour;
    private String name;
    private Information InfoActuelle;
    private int [] position = {-1,-1};
    
    public Personnage(boolean t,String n){
        this.tour=t;
        this.name=n;
    }
    
    public void takeDamage(int degat){
        this.getInfoActuelle().setvie(this.getInfoActuelle().getvie() - degat);
    }

   public abstract String toString();

    public boolean estVivant(){
        if(this.InfoActuelle.getvie() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int[] getPosition(){
        return position;
    }
    public void setPosition(int x, int y){
        int [] pos = {x,y};
        position = pos; 
    }

    public abstract void attaque (Plateau p);
    public abstract boolean peutAttaquer(Plateau p);
    public boolean aGagner(Plateau p, Personnage perso){
        int [] pos = perso.getPosition();
        if((!perso.estVivant())){
            System.out.println(perso.getName()+"est mort");
            p.removeZombie(pos[0],pos[1]);
            if(this instanceof Zombie){
                Zombie z = (Zombie) this;
                sleep(1000);
                z.moveZombie(p);

                for(int i = pos[1]+1;i<p.getNumCols();i++){
                    if(p.getCase(pos[0],i)==null){
                        break;
                    }
                    if(p.getCase(pos[0],i).contientZombie()){
                        Zombie l = (Zombie) p.getCase(pos[0],i).getPersonnage();
                        l.moveZombie(p);
                    }
                }
            }else{
                if(this instanceof Mario){
                    Zombie z = (Zombie) perso;
                    int prix = z.getGain();
                    p.getJoueur().incrementerArgent(prix);
                    p.getJoueur().incrementerScore(prix);
                }
            }
            return true;
           }
        return false;
        }
    
    public boolean getTour(){
        return this.tour;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String n){
        this.name=n;
    }
    public Information getInfoActuelle(){
        return this.InfoActuelle;
    }
    public void setInfoActuelle(Information i){
        this.InfoActuelle=i;
    }

    public abstract String estDevant(Plateau p);

    public abstract String getImagePath();

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
}

public abstract class Personnage {
    private boolean tour;
    private String name;
    private Information InfoActuelle;
    

    public Personnage(boolean t,String n){
        this.tour=t;
        this.name=n;
    }
    public Personnage(boolean t){
        this(t,null);
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
        int [] position = { this.InfoActuelle.getPosX() , this.InfoActuelle.getPosY()};
        return position;
    }

    public abstract void attaque (Plateau p);
    public abstract boolean peutAttaquer(Plateau p);
    public boolean aGagner(Plateau p, Personnage perso){
        int [] pos = perso.getPosition();
        System.out.println(perso.toString());
        if((!perso.estVivant())){
            
            System.out.println(perso.getName()+"est mort");
            p.removeZombie(pos[0],pos[1]);
            if(this instanceof Zombie){
                Zombie z = (Zombie) this;
                sleep(1000);
                z.moveZombie(p);
                //modif
            }
            return true;
           }
         /*if(!this.estVivant()){
            p.removeMario(pos[0], pos[1]);
            return false;
         }*/
         //System.out.println("Vie du Zombie :"+p.getCase(pos[0],pos[1]+1).getPersonnage().getInfoActuelle().getvie());
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
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

    public String attaque(Personnage p){
        int attaque = this.getInfoActuelle().getAttaque();
        int defense =p.getInfoActuelle().getDefense();
        if(attaque>defense){
            p.InfoActuelle.setvie(p.getInfoActuelle().getvie()-attaque);
        }else{
            attaque=attaque/2;
        }
        return(this.name+" inflige "+attaque+" de degat a "+ p.getName());
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

    
}
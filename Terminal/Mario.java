public abstract class Mario extends Personnage {
    private final int prix;

    Mario(String n, int x, Information i){
       super(true,n);
       this.prix=x; 
       this.setInfoActuelle(i);
    }

    public int getPrix(){
        return this.prix;
    }

    @Override
    public String toString(){
        int [] pos = this.getPosition();
        return this.getName() + " \n Point de vie :" + this.getInfoActuelle().getvie() + " \n Attaque :" + this.getInfoActuelle().getAttaque() + " \n Defense :" + this.getInfoActuelle().getDefense()+ " \n Prix :" + this.prix+" \n Position :"+pos[0]+", "+pos[1];
    }

    public boolean superAttaque(Plateau p){
        if(this.peutAttaquer(p)){
            this.attaque(p);
            return true;
        }
        return false;
    }

    /*public boolean aGagner(Plateau p){
        int [] pos = this.getPosition();
        if(pos[1]==p.getNumCols()-1){
            return true;
        }
        return false;
    }*/

    public abstract String getImagePath();

    
}





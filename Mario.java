public abstract class Mario extends Personnage {
    private final int prix;
    private final Information InfoInitiale ;

    Mario(String n, int x, Information i){
       super(true,n);
       this.prix=x; 
       this.InfoInitiale=i;
       this.setInfoActuelle(i);
    }

    public int getPrix(){
        return this.prix;
    }
    public Information getInfoInitale(){
        return this.InfoInitiale;
    }
    @Override
    public String toString(){
        return this.getName() + " \n Point de vie :" + this.getInfoActuelle().getvie() + " \n Attaque :" + this.getInfoActuelle().getAttaque() + " \n Defense :" + this.getInfoActuelle().getDefense()+ " \n Prix :" + this.prix;
    }

    public boolean peutAttaquer(Plateau p){
        int [] pos = this.getPosition();
        if(pos[0]!=0){
            for(int i=pos[1]; i<p.getNumCols()-1;i++){
                if(p.getCase(pos[0], i).contientZombie()){
                    return true;
                }
            }
        }
        return false;
    }

}

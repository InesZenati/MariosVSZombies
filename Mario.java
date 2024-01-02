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

}

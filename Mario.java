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
        return this.getName() + " \n Point de vie :" + this.getInfoActuelle().getvie() + " \n Attaque :" + this.getInfoActuelle().getAttaque() + " \n Defense :" + this.getInfoActuelle().getDefense()+ " \n Prix :" + this.prix;
    }
/* 
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
    */

    public boolean peutAttaquer(Plateau p){
       // System.out.println(1);
      int [] pos = this.getPosition();
       int li = pos[0];
       int col = pos[1];
      //  System.out.println(2);
        if(p.getCase(li,col+1).contientZombie2()){
           System.out.println(3);
            return true;
        }else{
            System.out.println("non");
        }
     //   System.out.println(5);
        return false;
    }



    public boolean aGagner(Plateau p){
        int [] pos = this.getPosition();
        if(pos[1]==p.getNumCols()-1){
            return true;
        }
        return false;
    }
}





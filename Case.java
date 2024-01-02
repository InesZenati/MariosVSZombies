public class Case {
    private int li;
    private int col;
    private Personnage p; 

    public Case(int li, int col) {
        this.li = li;
        this.col = col;
        this.p=null;
    }

    public boolean contientMario() {
            //return p.getTour();
            if(p !=null && p.getTour()==true){
                return true;
            }
            else{
                return false;
            }
    }

    public boolean contientZombie() {
            //return !p.getTour();
            if(p !=null && p.getTour()==false){
                return true;
            }
            else{
                return false;
            }
    }

    public Personnage getPersonnage() {
        return this.p;
    }
    public int getLi() {
        return li;
    }
    public int getCol() {
        return col;
    }
    public Personnage getPerso(){
        return this.p;
    }
    public void setMario (Mario newM) {
        p=newM;
    }
    public void setZombie (Zombie newZ) {
        p=newZ;
    }

}

public class Case {
    private int li;
    private int col;
    private Personnage p; 

    public Case(int li, int col) {
        this.li = li;
        this.col = col;
        this.p=null;
    }
    public Case(int li, int col, Personnage p) {
        this.li = li;
        this.col = col;
        this.p=p;
    }

    public boolean contientMario() {
        if(p!=null){
            return p.getTour();
        }
        return false;
    }

    public boolean contientZombie() {
        if (p!=null){
            return !p.getTour();
        }
        return false;
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
    public void setMario (Mario newM) {
        p=newM;
    }
    public void setZombie (Zombie newZ) {
        p=newZ;
    }

}

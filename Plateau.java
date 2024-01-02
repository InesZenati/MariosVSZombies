public class Plateau {
    private int numLi;
    private int numCols;
    private Case[][] plato;

    public Plateau(int numLi, int numCols) {
        this.numLi = numLi;
        this.numCols = numCols;
        this.plato = new Case[numLi][numCols];
        creePLato();
    }

    private void creePLato() {
        for (int li = 0; li < numLi; li++) {
            for (int col = 0; col < numCols; col++) {
                plato[li][col] = new Case(li, col);
            }
        }
    }

    public int getNumLi() {
        return numLi;
    }
    public int getNumCols() {
        return numCols;
    }                   

    public Case getCase(int li, int col) {
        return plato[li][col];
    }

    public void setCase(Case newCase, int li, int col) {
        plato[li][col] = newCase;
    }

    public void placeMario(Mario m, int li, int col) {
        plato[li][col].setMario(m);
    }
    public void placeZombie(Zombie z, int li, int col) {
        plato[li][col].setZombie(z);
    }
    public void removeMario(int li, int col) {
        plato[li][col].setMario(null);
    }
    public void removeZombie(int li, int col) {
        plato[li][col].setZombie(null);
    }

    public void spawnZombie(Zombie z) {
        int li = 1+ (int) (Math.random() * numLi-1);
        int col = numCols - 1;
        while (plato[li][col].contientZombie()) {
            li = (int) (Math.random() * numLi -1);
            col = numCols - 1;
        }
        placeZombie(z, li, col);
        z.getInfoActuelle().setPosX(li);
        z.getInfoActuelle().setPosY(col);
    }

    public void affiche() {
        System.out.print("  ");
        for (int col = 0; col < numCols; col++) {
            System.out.print("  "+col+" " ); 
        }
        System.out.println();   
    
        for (int li = 0; li < numLi; li++) {
            System.out.print(" "+li + " ");
            for (int col = 0; col < numCols; col++) {
                if (plato[li][col].contientMario()) {
                    if(plato[li][col].getPersonnage().getName()=="BasicMario"){
                    System.out.print("|B_|");
                    }
                    else if(plato[li][col].getPersonnage().getName()=="FireMario"){
                    System.out.print("|F_|");
                    }
                    else if(plato[li][col].getPersonnage().getName()=="WallBrick"){
                    System.out.print("|W_|");
                    }
                    else if(plato[li][col].getPersonnage().getName()=="BigtMario"){
                    System.out.print("|G_|");
                    }
                    else if(plato[li][col].getPersonnage().getName()=="SuperMario"){
                    System.out.print("|S_|");
                    }
                } else if (plato[li][col].contientZombie()) {
                    System.out.print("|_Z|");
                } else {
                    System.out.print("|__|");
                }
            }
            System.out.println();
        }
    }

    public void moveZombie(Zombie z) {
        int li = z.getInfoActuelle().getPosX();
        int col = z.getInfoActuelle().getPosY();
            if (plato[li][col-1].contientZombie()) {
            } else {
                removeZombie(li, col);
                placeZombie(z, li, col-1);
                z.getInfoActuelle().setPosY(col-1);
            }
    }

  
    public static void main(String[] args) {
        Plateau p = new Plateau(6, 12);
        Zombie z = new Zombie("zombie1", 10,5, new Information(2, 0, 0, 0, 10));
        p.affiche();
        p.spawnZombie(z);
        p.affiche();
      p.moveZombie(z);
      p.affiche();
      //p.placeZombie(z, 4, 10);
      //p.affiche();

    }
}

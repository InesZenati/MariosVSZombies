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
        int li = 1+ (int) (Math.random() * numLi);
        int col = numCols - 1;
        while (plato[li][col].contientZombie()) {
            li = (int) (Math.random() * numLi);
            col = numCols - 1;
        }
        placeZombie(z, li, col);
    }
/* 
    public void affiche() {
        System.out.print("  ");
        for (int col = 0; col < numCols; col++) {
            System.out.print(col + " ");
        }
        System.out.println();   
    
        for (int row = 0; row < numLi; row++) {
            System.out.print(row + " ");
    
            for (int col = 0; col < numCols; col++) {
                if (col >= plato.length || row >= plato[col].length) {
                    System.out.print(". "); // Affiche un point si en dehors des limites
                } else {
                    Case currentCase = plato[col][row];
                    if (currentCase.contientMario()) {
                        System.out.print("X ");
                    } else if (currentCase.contientZombie()) {
                        System.out.print("Z ");
                    } else {
                        System.out.print(". "); 
                    }
                }
            }
            System.out.println(); 
        }
    }
    
   */ 
    public void affiche(){
        System.out.print("  ");
       for (int row = 0; row < numLi; row++) {
            System.out.print(row + " ");
        }
        System.out.println();   
        for (int col = 0; col < numCols; col++) {
            System.out.print(col + " ");

            for (int row = 0; row < numLi; row++) {
                Case currentCase = plato[col][row];
                if (currentCase.contientMario()) {
                    System.out.print("X ");
                } else if (currentCase.contientZombie()) {
                    System.out.print("Z ");
                } else {
                    System.out.print(". "); 
                }
            }
            
            System.out.println(); 
        }
    }




        public boolean horsLimite(int li, int col) {
            return li < 0 || li >= numLi || col < 0 || col >= numCols;
        }

    public static void main(String[] args) {
        Plateau p = new Plateau(7, 10);
        p.affiche();
    }
}

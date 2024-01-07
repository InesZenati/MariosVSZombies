import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Plateau {
    private int numLi;
    private int numCols;
    private Case[][] plato;
    private List<Personnage> PersoDansPlato = new ArrayList<>();

    public Plateau(int numLi, int numCols) {
        this.numLi = numLi;
        this.numCols = numCols;
        this.plato = new Case[numLi][numCols];
        creePLato();
    }

    public List<Personnage> getListPerso(){
        return this.PersoDansPlato;
    }

    public void ajouter(Personnage p){
        this.PersoDansPlato.add(p);
    }
    public void retirer(Personnage p){
        this.PersoDansPlato.remove(p);
    } 
    public void afficheList(){
        for(int i =0;i<this.PersoDansPlato.size();i++){
            System.out.println(this.PersoDansPlato.get(i).toString());
        }
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

    //A AMELIORER
    public boolean placeMario(Mario m, int li, int col) {
        if(this.plato[li][col].contientZombie()){
            System.out.println("Impossible !Un Zombie se trouve dans la case ["+li+","+col+"]");
            return false;
        }
        //A voir si on garde ou pas
        if(this.plato[li][col].contientMario()){
            System.out.println("Il y a déjà un Mario placé dans la case ["+li+","+col+"]");
            return false;
        }
        if(!this.plato[li][col].contientZombie()&&!this.plato[li][col].contientMario()){
            m.getInfoActuelle().setPosX(li);
            m.getInfoActuelle().setPosY(col);
            this.ajouter(m);
            plato[li][col].setMario(m);
            return true;
        }
        return false;
        
    }
    public void placeZombie(Zombie z, int li, int col) {
        //(!plato[li][col].contientZombie() && !plato[li][col].contientMario()){    
        z.getInfoActuelle().setPosX(li);
        z.getInfoActuelle().setPosY(col);
        this.ajouter(z);
        plato[li][col].setZombie(z);
        //}
    }

    public void removeMario(int li, int col) {
        this.retirer(plato[li][col].getPersonnage());
        plato[li][col].supprimerPerso();;
    }
    public void removeZombie(int li, int col) {
        this.retirer(plato[li][col].getPersonnage());
        plato[li][col].supprimerPerso();
    }

    public void spawnZombie(Zombie z) {
        int li = 1+ (int) (Math.random() * numLi-1);
        int col = numCols - 1;
        while (plato[li][col].contientZombie()) {
            li = (int) (Math.random() * numLi -1);
            col = numCols - 1;
        }
        
        placeZombie(z, li, col);
        moveZombie(z);
    }

        public void moveZombie(Zombie z) {
        Plateau plato = this;                          
        int li = z.getInfoActuelle().getPosX();
        int col = z.getInfoActuelle().getPosY();
        while(z.peutDeplacer(plato)){ 
                removeZombie(li, col);
                col=col-1;
                sleep(100);
                placeZombie(z, li, col);
                sleep(1000);
                plato.affiche();
            }
        }

    public void moveRandomZombies(List<Zombie> listeZombies) {
        for (int i = 0; i < listeZombies.size(); i++) {
            sleep(1000);
            moveZombie(listeZombies.get(i));
            sleep(1000);
        }
        sleep(1000);
    }

    public void spawnRandomZombies(List<Zombie> listeZombies) {
        for (int i = 0; i < listeZombies.size()-1; i++) {
            spawnZombie(listeZombies.get(i));
        }
    }


    public void affiche() {
        /*for(int li = 0;li<numLi;li++){
            for(int col = 0; col<numCols; col++){
                if(plato[li][col].contientZombie()){
                    System.out.println(plato[li][col].getPersonnage().toString());
                }
            }
        }*/

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
                    else if(plato[li][col].getPersonnage().getName()=="BigMario"){
                    System.out.print("|G_|");
                    }
                    else if(plato[li][col].getPersonnage().getName()=="SuperMario"){
                    System.out.print("|S_|");
                    }
                } else if (plato[li][col].contientZombie()) {

                if(plato[li][col].getPersonnage().getName()=="ZombieSimple"){ 
                    System.out.print("|ZS|");
                } 
                else if( plato[li][col].getPersonnage().getName()=="ZombieAmélioré"){
                    System.out.print("|ZA|");
                }
                else if (plato[li][col].getPersonnage().getName()=="SuperZombie") {
                    System.out.print("|SZ|");
                }
                else if (plato[li][col].getPersonnage().getName()=="SuperMegaUltraZombie") {
                    System.out.print("|MZ|");
                }
            }else{
                System.out.print("|__|");
            }
        }
         System.out.println();
    }
}



       private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
/* 
    public boolean partieFinish(){
        return true;
    }
  */
  
    public static void main(String[] args) {
        Plateau p = new Plateau(6, 11);
        Zombie2 z = new Zombie2(1000);
        StarMario m = new StarMario();
       // p.affiche();
        //p.spawnZombie(z);
        //p.affiche();
        //System.out.println("mvmt");
        //p.moveZombie(z);
        //p.affiche();
        p.placeZombie(z, 0, 1);
        p.placeMario(m, 0, 0);
        p.affiche();
        System.out.println(z.toString());
        System.out.println(m.toString());
        System.out.println(m.peutAttaquer(p));
        m.attaque(p);
        System.out.println(z.toString());
        System.out.println(m.toString());

    }
}

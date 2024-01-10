import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Plateau {
    private int numLi;
    private int numCols;
    private Case[][] plato;
    private List<Personnage> PersoDansPlato = new ArrayList<>();
    private List<Zombie> VagueDeZombie = new ArrayList<>();

    public List<Zombie> getVague(){
        return VagueDeZombie;
    }

    public void setVague(List<Zombie> z){
        this.VagueDeZombie=z;
    }

    public Plateau(int numLi, int numCols, String niveauDeDifficulté) {
        this.numLi = numLi;
        this.numCols = numCols;
        this.plato = new Case[numLi][numCols];
        this.VagueDeZombie=generateZombies(niveauDeDifficulté);
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
        System.out.println(z.toString());
    } 
    
    public List<Zombie> generateZombies(String niveaudeDIfficulté){
        List<Zombie> ennemis = new ArrayList<>();
        switch (niveaudeDIfficulté) {
            case "Facile":
               ennemis= generateEnemies(70, 30, 0, 0, 10);
                break;
        
            case"Moyen":
               ennemis= generateEnemies(50, 30, 20, 0, 10);
                break;
            case "Difficile":
               ennemis=  generateEnemies(10, 30, 40, 20, 10);
                break;
            case "Marathon":
           // ennemis= generateEnemieMarathon();

        }
        return ennemis;
    }

    public List<Zombie> generateEnemies(int zombie1 , int zombie2 , int zombie3 , int zombie4 , int n) {
        List<Zombie> ennemis = new ArrayList<>();
        Random random = new Random();


       // int zombieType2Percentage = 30;

        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(100) + 1; // Générer un nombre entre 1 et 100 inclus
            Zombie1 a = new Zombie1(1000);
            Zombie2 b = new Zombie2(1000);
            Zombie3 c = new Zombie3(1000);
            Zombie4 d = new Zombie4(1000);
            // Sélectionner le type de zombie en fonction de la proportion définie
            if (randomNumber <= zombie1) {
               ennemis.add(a);
            } else if (randomNumber <= zombie1 + zombie2) {
                  ennemis.add(b);
            } else if (randomNumber <= zombie1 + zombie2 + zombie3) {
                 ennemis.add(c);
            } else {
                  ennemis.add(d);
            }
    
        }
        return ennemis;
        }

        public void generateEnemieMarathon(){

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
            System.out.println("Dans spawnRandomZombies");
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

    public Personnage getPersonnageAt(int li, int col) {
        return plato[li][col].getPersonnage();
    }
/* 
    public boolean partieFinish(){
        return true;
    }
  */
  
    public static void main(String[] args) {
        Plateau p = new Plateau(6, 11,"Facile");
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Plateau {
    private Joueur joueur;
    private Case[][] plato;
    private List<Personnage> PersoDansPlato = new ArrayList<>();
    private List<Zombie> VagueDeZombie = new ArrayList<>();
    private int partieStatus;
    private List<Zombie> marathonMode =new ArrayList<>();
    private boolean marathonorNot=false;


    //Guetteur et Setter
    public List<Zombie> getVague(){
        return VagueDeZombie;
    }
    public boolean getMarathonOrNot(){
        return marathonorNot;
    }
    public Joueur getJoueur(){
            return joueur;
        }
    public int getPartieStatus(){
        return partieStatus;
    }
    public void ZombieGagne(){
        partieStatus=1;
    }
    public void MarioGagne(){
        partieStatus=2;
    }
    public List<Personnage> getListPerso(){
        return this.PersoDansPlato;
    }
    public int getNumLi() {
        return plato.length;
    }
    public int getNumCols() {
        return plato[0].length;
    }
    public Case getCase(int li, int col) {
        return plato[li][col];
    }
    public Personnage getPersonnageAt(int li, int col) {
        return plato[li][col].getPersonnage();
    }

    //Constructeur
    public Plateau(int numLi, int numCols, String niveauDeDifficulté, Joueur j) {
        this.joueur=j;
        this.plato = new Case[numLi][numCols];
        if (niveauDeDifficulté.equals("Marathon")){
            this.marathonorNot=true;;
        }
            this.VagueDeZombie=generateZombies(niveauDeDifficulté);
        this.partieStatus=0;
        creePLato();

    }

    //Ajouter ou enlever de la liste Perso
    public void ajouter(Personnage p){
        this.PersoDansPlato.add(p);
    }
    public void retirer(Personnage p){
        this.PersoDansPlato.remove(p);
    }
    
    //Creer Plato
    private void creePLato() {
        for (int li = 0; li < getNumLi(); li++) {
            for (int col = 0; col < getNumCols(); col++) {
                    plato[li][col] = new Case(li, col);
                
            }
        }
    }
    //Placer Mario Zombie et retirer 
    public boolean placeMario(Mario m, int li, int col) {
        if(this.plato[li][col].contientZombie()){
            System.out.println("Impossible !Un Zombie se trouve dans la case ["+li+","+col+"]");
            return false;
        }
        if(this.plato[li][col].contientMario()){
            System.out.println("Il y a déjà un Mario placé dans la case ["+li+","+col+"]");
            return false;
        }
        if(!this.plato[li][col].contientZombie()&&!this.plato[li][col].contientMario()&& col!=getNumCols()-1){
            m.setPosition(li, col);
            this.ajouter(m);
            plato[li][col].setMario(m);
            return true;
        }
        System.out.println("Vous n'avez pas le droit de placer à la derniere colone");
        return false;
        
    }
    public void placeZombie(Zombie z, int li, int col) {   
        z.setPosition(li, col);
        this.ajouter(z);
        plato[li][col].setZombie(z);
    }
    public void removeMario(int li, int col) {
        this.retirer(plato[li][col].getPersonnage());
        plato[li][col].supprimerPerso();;
    }
    public void removeZombie(int li, int col) {
        this.retirer(plato[li][col].getPersonnage());
        plato[li][col].supprimerPerso();
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
            ennemis= generateEnemies(20,20,20,40,10);

        }
        return ennemis;
    }

    public List<Zombie> generateEnemies(int zombie1 , int zombie2 , int zombie3 , int zombie4 , int n) {
        List<Zombie> ennemis = new ArrayList<>();
        Random random = new Random();

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

    public void affiche() {
        System.out.print("  ");
        for (int col = 0; col < getNumCols(); col++) {
            System.out.print("  "+col+" " ); 
        }
        System.out.println();   
    
        for (int li = 0; li < getNumLi(); li++) {
            System.out.print(" "+li + " ");
            for (int col = 0; col < getNumCols(); col++) {
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
                    else if(plato[li][col].getPersonnage().getName()=="StarMario"){
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

    public List<Mario> listeMario(){
        List<Mario> MArioDisponibles =new ArrayList<>();
        MArioDisponibles.add(new BasicMario());
        MArioDisponibles.add(new WallBrick());
        MArioDisponibles.add(new FireMario());
        MArioDisponibles.add(new BigMario());
        MArioDisponibles.add(new StarMario());
        return MArioDisponibles;

    }

    public void afficherMArioDisponibles(List<Mario> MArioDisponibles) {
        Communication c = new Communication();
        c.afficherMessage("Mario disponibles :");
        for (int i = 0; i < MArioDisponibles.size(); i++) {
            Mario mario = MArioDisponibles.get(i);
            if(mario.getPrix()<=getJoueur().getArgent()){
                c.afficherMessage((i + 1) + ". " + mario.toString());
            }
        }
    }
}

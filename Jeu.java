import java.util.ArrayList;
import java.util.List;
public class Jeu {
    private Plateau plato;
    private String niveauDeDifficulté;
    private List<Zombie> ennemis;
    private List<Mario> listeMario;
    private Joueur joueur;

    public Jeu(Plateau plato, String niveauDeDifficulté, List<Zombie> ennemis, List<Mario> listeMario, Joueur joueur) {
        this.plato = plato;
        this.niveauDeDifficulté = niveauDeDifficulté;
        this.ennemis = ennemis;
        this.listeMario = listeMario;
        this.joueur = joueur;
    }

    public Plateau getPlato() {
        return plato;
    }
    public String getNiveauDeDifficulté() {
        return niveauDeDifficulté;
    }
    public List<Zombie> getEnnemis() {
        return ennemis;
    }
    public List<Mario> getlisteMario() {
        return listeMario;
    }

    public void placerMario(String tour){
            switch (tour.charAt(0)) {
                case 'B':
                    plato.placeMario(listeMario.get(0), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                    break;
                case'W':
                    plato.placeMario(listeMario.get(1), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                    break;
                case'F':
                    plato.placeMario(listeMario.get(2), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                    break;
                case'G':
                    plato.placeMario(listeMario.get(3), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                    break;
                case'S':
                    plato.placeMario(listeMario.get(4), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                    break;
            }
        }
/* 
    public void zombieSurPlato(){
        for (int i = 0; i < ennemis.size(); i++) {
            Zombie zombie = ennemis.get(i);
            plato.spawnZombie(zombie);
            plato.affiche();
            sleep(1000);
            plato.moveZombie(zombie);
            plato.affiche();
        }
    }

    public void jouerPartieSimple(){
        joueur.afficherMArioDisponibles(listeMario);  
        plato.affiche();
        placerMario(joueur.demanderPersoPosition());

    }

    */

    public void jouerPartieSimple() {
        joueur.afficherMArioDisponibles(listeMario);
        plato.affiche();
    
        while (true) {
            // Phase d'achat et placement des Marios
            for (int i = 0; i < listeMario.size(); i++) {
                 for (Zombie zombie : ennemis) {
                String choix = joueur.demanderPersoPosition();
                placerMario(choix);
                plato.affiche();
                      
                plato.spawnZombie(zombie);
                plato.affiche();
                sleep(1000);
                plato.moveZombie(zombie);
                plato.affiche();
            }
            }
    
            // Phase d'apparition et déplacement des Zombies
     
        }
    }
    
    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

    public void jouerPartieMoyen(){
        
    }

    public void jouerPartieDifficile(){
        
    }

    public static void main(String[] args) {
        Plateau p = new Plateau(6, 10);
        List<Mario> MArioDisponibles =new ArrayList<>();
        MArioDisponibles.add(new BasicMario());
        MArioDisponibles.add(new WallBrick());
        MArioDisponibles.add(new FireMario());
        MArioDisponibles.add(new BigMario());
        MArioDisponibles.add(new StarMario());
        Joueur joueur = new Joueur("joueur", 30, 0);
        List<Zombie> ennemis = new ArrayList<>();
        ennemis.add(new Zombie("Z1", 10, 0, new Information(40, 100,9,5,30)));
        ennemis.add(new Zombie("Z2", 10, 0, new Information(40, 100,9,5,30)));
        ennemis.add(new Zombie("Z3", 10, 0, new Information(40, 100,9,5,30)));
        ennemis.add(new Zombie("Z4", 10, 0, new Information(40, 100,9,5,30)));
        ennemis.add(new Zombie("Z5", 10, 0, new Information(40, 100,9,5,30)));
        Jeu a = new Jeu(p, "simple", ennemis, MArioDisponibles, joueur);
        a.jouerPartieSimple();
        }
}

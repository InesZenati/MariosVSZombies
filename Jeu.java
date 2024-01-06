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
/*  
    public void placerMario(String tour){
            switch (tour.charAt(0)) {
                case 'B':
                    plato.placeMario(listeMario.get(0), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                    if(listeMario.get(0).peutAttaquer(plato)){
                        BasicMario mario = (BasicMario) listeMario.get(0);
                        mario.attaque(plato);

                    }
                    break;
                case'W':
                    plato.placeMario(listeMario.get(1), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                    break;
                case'F':
                    plato.placeMario(listeMario.get(2), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                    if(listeMario.get(0).peutAttaquer(plato)){
                        FireMario mario = (FireMario) listeMario.get(0);
                        mario.attaque(plato);
                    }
                    break;
                case'G':
                    plato.placeMario(listeMario.get(3), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                    if(listeMario.get(0).peutAttaquer(plato)){
                        BigMario mario = (BigMario) listeMario.get(0);
                        mario.attaque(plato);
                    }
                    break;
                case'S':
                    plato.placeMario(listeMario.get(4), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                          if(listeMario.get(0).peutAttaquer(plato)){
                        StarMario mario = (StarMario) listeMario.get(0);
                        mario.attaque(plato);
                    }
                    break;
            }
        }

        */
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

   /*  public void jouerPartieSimple() {
       joueur.afficherMArioDisponibles(listeMario);
        plato.affiche();
    
        while (true) {
            for (int i = 0; i < listeMario.size(); i++) {

                String choix = joueur.demanderPersoPosition();
                placerMario(choix);
                plato.affiche();
                 }
    for (Zombie zombie : ennemis) {
                plato.spawnZombie(zombie);
                plato.affiche();
                sleep(10);
                plato.moveZombie(zombie);
                plato.affiche();
            
            }
        } */

         public void jouerPartieSimple() {
            joueur.afficherMArioDisponibles(listeMario);
            System.out.print("Argent : ");
            joueur.afficheArgent();
            plato.affiche();
            MarioThread marioThread = new MarioThread(plato, joueur, listeMario);
            ZombieThread zombieThread = new ZombieThread(plato, ennemis);
            AttaqueThread attaqueThread = new AttaqueThread(plato);
        
            marioThread.start();
            zombieThread.start();
            attaqueThread.start();
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
        Joueur joueur = new Joueur("joueur", 30000, 0);
        List<Zombie> ennemis = new ArrayList<>();
        ennemis.add(new Zombie1(1000));
        ennemis.add(new Zombie1(1000));
        ennemis.add(new Zombie1(1000));
        ennemis.add(new Zombie1(1000));
        ennemis.add(new Zombie1(1000));
        Jeu a = new Jeu(p, "simple", ennemis, MArioDisponibles, joueur);
        a.jouerPartieSimple();
        }

}

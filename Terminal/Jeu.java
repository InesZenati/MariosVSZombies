import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Jeu {
    private Plateau plato;
    private List<Zombie> ennemis;
    private List<Mario> listeMario = listeMario();
    private Joueur joueur;
    private volatile boolean partieTerminee = false;


    public Jeu(Plateau plato, Joueur joueur) {
        this.plato = plato;
        this.joueur = joueur;
    }

    public Plateau getPlato() {
        return plato;
    }
    public List<Zombie> getEnnemis() {
        return ennemis;
    }
    public List<Mario> getlisteMario() {
        return listeMario;
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

        public static String modeJeu(int i){
            String v;
            switch (i) {
                case 1:
                    v="Facile";
                    break;
                case 2:
                    v="Moyen";
                    break;
                case 3:
                    v="Difficile";
                    break;
                case 4:
                    v="Marathon";
                    break;
            
                default: v="Facile";
                    break;
            }
            return v;
        }

        public static void playJeu(int i){
            switch (i) {
                case 1:
                   
                    break;
                case 2:
                    
                    break;
            }
        }

        public void partieFinish() {
            Thread partieOver = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!partieTerminee) {
                        if (plato.getPartieStatus() != 0) {
                            jouer(2);
                            System.out.println("Partie terminée");
    
                            if (plato.getPartieStatus() == 2) {
                                System.out.println("Vous avez gagné !");
                            } else if (plato.getPartieStatus() == 1) {
                                System.out.println("Vous avez perdu");
                            }
                            
                            gameRejouer();
                              break;
                            //partieTerminee = true;
                        }
    
                        try {
                            // Pause le thread pendant une courte période
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
    
            partieOver.start();
        }
        public void gameRejouer() {
            Communication c = new Communication();
            int choix = c.demanderDeRejouer();
            if (choix == 1) {
            String mode = modeJeu(c.demanderNiveauDifficulte());
            joueur.setArgent(24);
                Plateau p = new Plateau(6,10,mode,joueur);
                Jeu a = new Jeu(p, joueur);
                a.jouer(1);
            } else if (choix == 2) {
                System.out.println("Merci d'avoir joué !");
                c.getScanner().close();
            }
            
        }
        
    
        public void jouer(int i) {
            partieFinish();
           // MarioThread marioThread = new MarioThread(plato);
            ZombieThread zombieThread = new ZombieThread(plato);
            AttaqueThread attaqueThread = new AttaqueThread(plato);
    
            if (i == 1) {
                joueur.afficherMArioDisponibles(listeMario);
                System.out.print("Argent : ");
                joueur.afficheArgent();
                plato.affiche();
             //   marioThread.start();
                zombieThread.start();
                attaqueThread.start();
            } else if (i == 2) {
                // Arrêter tous les threads
             //   marioThread.stopThread();
                zombieThread.stopThread();
                attaqueThread.stopThread();
                partieTerminee = true;
            }
        }
    

}

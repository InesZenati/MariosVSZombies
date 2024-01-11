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
            Scanner sc = new Scanner(System.in);
    
            Thread partieOver = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!partieTerminee) {
                        if (plato.getPartieStatus() != 0) {
                            jouer(2);
                            System.out.println("Partie terminée");
    
                            if (plato.getPartieStatus() == 1) {
                                System.out.println("Vous avez gagné !");
                            } else if (plato.getPartieStatus() == 2) {
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
            Scanner sc = new Scanner(System.in);
            System.out.println("Voulez-vous rejouer ? 1 OUI 2 NON");
            int choix = sc.nextInt();
            if (choix == 1) {
                Communication c = new Communication();
            Joueur j = new Joueur(c.demanderString("Comment souhaites-tu te nommer ?"));
            String mode = modeJeu(c.demanderNiveauDifficulte());
                Plateau p = new Plateau(6,10,mode);
                Jeu a = new Jeu(p, j);
                a.jouer(1);
            } else if (choix == 2) {
                System.out.println("Merci d'avoir joué !");
            }
        }
        
    
        public void jouer(int i) {
            partieFinish();
            MarioThread marioThread = new MarioThread(plato, joueur, listeMario);
            ZombieThread zombieThread = new ZombieThread(plato);
            AttaqueThread attaqueThread = new AttaqueThread(plato);
    
            if (i == 1) {
                joueur.afficherMArioDisponibles(listeMario);
                System.out.print("Argent : ");
                joueur.afficheArgent();
                plato.affiche();
                marioThread.start();
                zombieThread.start();
                attaqueThread.start();
            } else if (i == 2) {
                // Arrêter tous les threads
                marioThread.stopThread();
                zombieThread.stopThread();
                attaqueThread.stopThread();
                partieTerminee = true;
            }
        }
    

    public static void main(String[] args) {
        /*Plateau p = new Plateau(6, 10);
        List<Mario> MArioDisponibles =new ArrayList<>();
        MArioDisponibles.add(new BasicMario());
        MArioDisponibles.add(new WallBrick());
        MArioDisponibles.add(new FireMario());
        MArioDisponibles.add(new BigMario());
        MArioDisponibles.add(new StarMario());
        Joueur joueur = new Joueur("joueur");
        List<Zombie> ennemis = new ArrayList<>();
        ennemis.add(new Zombie1(1000));
        ennemis.add(new Zombie1(1000));
        ennemis.add(new Zombie1(1000));
        ennemis.add(new Zombie1(1000));
        ennemis.add(new Zombie1(1000));
        Jeu a = new Jeu(p, "simple", ennemis, MArioDisponibles, joueur);
        a.jouerPartieSimple();*/
        
        //int play = playJeu(demanderInterface());
        

        }

}

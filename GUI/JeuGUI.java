import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class JeuGUI extends JFrame {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Joueur joueur;
    private Plateau plateau;
    private Controller controller;
    private volatile boolean partieTerminee = true;

    public CardLayout getCardLayout(){
        return this.cardLayout;
    }
    public JPanel getCardPanel(){
        return this.cardPanel;
    }
    public Plateau getPlateau(){
        return plateau;
    }

    public Controller getController(){
        return controller;
    }

    public static void main(String[] args) {
        new JeuGUI();
       
    }

    public JeuGUI() {
        frame = new JFrame("MariosVSZombies");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        this.joueur=new Joueur("Anonyme");
       

        // Initialisation du CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        // Welcome Page
        WelcomePageGUI welcomePageGUI = new WelcomePageGUI(this);
        cardPanel.add(welcomePageGUI, "Welcome");
        // Menu Page
        MenuGUI menuPageGUI = new MenuGUI(this);
        cardPanel.add(menuPageGUI, "Menu");
        // Set Page
        setJeu config = new setJeu(this);
        cardPanel.add(config, "Config");
        // Game Page
        PlateauGUI jeu = new PlateauGUI(this);
        cardPanel.add(jeu, "PlateauGUI");

        frame.add(cardPanel);

        // Afficher la page "Welcome" au démarrage
        cardLayout.show(cardPanel, "Welcome");
        controller = new Controller(jeu, plateau, this);
        // Afficher la fenêtre principale
        frame.setVisible(true);
    }

     public void partieFinish() {
            Scanner sc = new Scanner(System.in);
    
            Thread partieOver = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!partieTerminee) {
                        if (getPlato().getPartieStatus() != 0) {
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
        

    

    public Plateau setPlateau(Plateau plato){
       this.plateau = plato;
        return this.plateau;
    }

    public Joueur getJoueur(){
        return this.joueur;
    }
    public void setJoueur(Joueur j){
        joueur = j;
    }
}

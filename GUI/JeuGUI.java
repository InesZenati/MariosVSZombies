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
    private int finPartie = 0;
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
        ReglesGUI reglesGUI = new ReglesGUI(this);
        cardPanel.add(reglesGUI, "Regles");
        PlateauGUI jeu = new PlateauGUI(this);
        cardPanel.add(jeu, "PlateauGUI");
        GameOverGUI gameOverPanel = new GameOverGUI(this);
        cardPanel.add(gameOverPanel, "GameOver");
        GameWinGUI gameWinPanel = new GameWinGUI(this);
        cardPanel.add(gameWinPanel, "GameWin");



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
                        if (plateau.getPartieStatus() != 0) {
                            controller.getPlateauGUI().spawnZombies(2);
                            System.out.println("Partie terminée");
                            if (plateau.getPartieStatus() == 1) {
                                finPartie =1;
                                tryToShowNewPage();

                            } else if (plateau.getPartieStatus() == 2) {
                                finPartie =2;
                                System.out.println("Vous avez gagné !");
                                 tryToShowNewPage();
                            }
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

    private void tryToShowNewPage() {
        // Vérifier si les deux sélections ont été faites
        if (finPartie==1 ) {
      // Afficher je pense on ajoute ds attributs pour avoir que une page afficher
            cardLayout.show(cardPanel, "GameOver");
        }
        else 
        if(finPartie==2){
            cardLayout.show(cardPanel, "GameWin");
        }
    }
}

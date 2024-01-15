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
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);        
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
        CatalogueGUI catalogue = new CatalogueGUI(this);
        cardPanel.add(catalogue, "Catalogue");
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

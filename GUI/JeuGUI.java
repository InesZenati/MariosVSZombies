import javax.swing.*;
import java.awt.*;

public class JeuGUI extends JFrame {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Joueur joueur;
    private Plateau plateau;

    public CardLayout getCardLayout(){
        return this.cardLayout;
    }
    public JPanel getCardPanel(){
        return this.cardPanel;
    }
    public Plateau getPlateau(){
        return plateau;
    }



    public static void main(String[] args) {
        Joueur j = new Joueur("test");
        new JeuGUI(j);
       
    }

    public JeuGUI(Joueur j) {
        plateau = new Plateau(6,10);
        frame = new JFrame("MariosVSZombies");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        j = new Joueur("test");

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

        // Afficher la fenêtre principale
        frame.setVisible(true);
    }

    public Joueur getJoueur(){
        return this.joueur;
    }
}

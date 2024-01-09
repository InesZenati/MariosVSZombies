import javax.swing.*;
import java.awt.*;

public class JeuGUI extends JFrame {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public static void main(String[] args) {
        new JeuGUI();
    }

    public JeuGUI() {
        frame = new JFrame("MariosVSZombies");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        // Initialisation du CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Welcome Page
        WelcomePageGUI welcomePageGUI = new WelcomePageGUI(cardLayout, cardPanel);
        cardPanel.add(welcomePageGUI, "Welcome");

        // Menu Page
        MenuGUI menuPageGUI = new MenuGUI(cardLayout, cardPanel);
        cardPanel.add(menuPageGUI, "Menu");

        // Set Page
        setJeu config = new setJeu(cardLayout, cardPanel);
        cardPanel.add(config, "Config");

        // Game Page
        Game jeu = new Game(cardLayout, cardPanel);
        cardPanel.add(jeu, "Game");

        frame.add(cardPanel);

        // Afficher la page "Welcome" au démarrage
        cardLayout.show(cardPanel, "Welcome");

        // Afficher la fenêtre principale
        frame.setVisible(true);
    }
}

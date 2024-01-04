import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class MenuGUI extends JFrame {
    private Menu menu;

    public MenuGUI() {
        this.menu = new Menu();
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JLabel titleLabel = new JLabel(" Menu Principal ");
        panel.add(titleLabel);

        JButton rulesButton = new JButton("Lire les règles du jeu");
        rulesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.afficherReglesDuJeu();
            }
        });
        panel.add(rulesButton);

        JButton charactersButton = new JButton("Catalogue des personnages");
        charactersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.afficherCatalogue();
            }
        });
        panel.add(charactersButton);

        JButton startGameButton = new JButton("Démarrer une nouvelle partie");
        startGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.afficherMessage("Démarrage d'une nouvelle partie...");
            }
        });
        panel.add(startGameButton);

        JButton quitButton = new JButton("Quitter le jeu");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.afficherMessage("Merci d'avoir joué ! Au revoir !");
                System.exit(0);
            }
        });
        panel.add(quitButton);

        getContentPane().add(panel);
        setSize(300, 250);

        // Centrer la fenêtre
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
            }
        });
    }
}

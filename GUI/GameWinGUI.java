import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

public class GameWinGUI extends JPanel {

    private Jeu jeu;
    private JFrame frame;
    private JPanel panel;
    private JLabel gameOverLabel;
    private JButton retourMenuButton;

       Font marioFont = loadMarioFont();

    public GameWinGUI(JeuGUI jeuGUI) {
        initializeComponents();
        createGUI();
        addListeners(jeuGUI);
    }

    private void initializeComponents() {
        frame = new JFrame("Game win");
        panel = new JPanel();
        gameOverLabel = new JLabel("Game win");
        retourMenuButton = new JButton("Retour au Menu");
    }

    private void createGUI() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());

        // Utilisation d'une police de caractères "Mario" (si elle est disponible)
        try {
            Font marioFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("mario.ttf"))).deriveFont(Font.PLAIN, 24);
            gameOverLabel.setFont(marioFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        panel.add(gameOverLabel, BorderLayout.CENTER);
        panel.add(retourMenuButton, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(null); // Centrez la fenêtre sur l'écran
        frame.setVisible(true);
    }

    private void addListeners(final JeuGUI jeuGUI) {
        retourMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Insérez ici le code pour retourner au menu principal
                // Vous pouvez fermer la fenêtre actuelle et afficher la nouvelle fenêtre du menu, etc.
                frame.dispose();
               // jeu.getCardLayout().show(jeu.getCardPanel(), "Menu");  // Exemple imaginaire, adaptez à votre logique
            }
        });
    }

    // Exemple d'utilisation
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameOverGUI(new JeuGUI());
            }
        });
    }

    private Font loadMarioFont() {
        try {
            File fontFile = new File("fonts/SuperMario256.ttf");
            return Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(14f);
        } catch (Exception e) {
            e.printStackTrace();
            // En cas d'erreur, utilisez la police par défaut
            return new Font("SansSerif", Font.PLAIN, 14);
        }
    }

    private class JButtonStyled extends JButton {
        public JButtonStyled(String text) {
            super(text);
            setFocusPainted(false);
            setContentAreaFilled(false);
            setOpaque(true);
            setForeground(Color.WHITE);
            setBackground(new Color(255, 138, 119)); // Couleur orange
            setFont(getFont().deriveFont(Font.BOLD, 16));
            setBorderPainted(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setPreferredSize(new Dimension(200, 50));
            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    setBackground(new Color(109 , 7 , 26));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    setBackground(new Color(255, 138, 119));
                }
            });
        }
    }
}

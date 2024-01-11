import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ReglesGUI extends JPanel {
    private JeuGUI jeuGUI;  // Ajoutez une référence à votre classe principale si nécessaire

    public ReglesGUI(JeuGUI jeuGUI) {
        this.jeuGUI = jeuGUI;
        initializeComponents();
        createGUI();
    }

    private void initializeComponents() {
        // Ajoutez ici les composants de votre page de règles
        JLabel titleLabel = new JLabel("Règles du jeu ");
        titleLabel.setFont(loadMarioFont().deriveFont(Font.PLAIN, 24));

        JTextArea rulesTextArea = new JTextArea();
        rulesTextArea.setEditable(false);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setWrapStyleWord(true);
        rulesTextArea.setFont(loadMarioFont().deriveFont(Font.PLAIN, 16));

        // Ajoutez les règles du jeu ici
        rulesTextArea.append("1. Placez les Marios pour défendre votre territoire vous n'avez pas le droit d'en placer a la derniere colone.\n");
        rulesTextArea.append("2. Vos disposez de plusieurs Mario que vous pouvez consulter dans le catalogue.\n");
        rulesTextArea.append("2. Éliminez les Koopa qui approchent avant qu'ils n'atteignent votre base.\n");
        rulesTextArea.append("3. Gagnez de l'argent en éliminant vos ennemis pour acheter de nouveaux Marios.\n");
        // Ajoutez d'autres règles...

        // Ajoutez un bouton de retour au menu
        JButton retourMenuButton = new JButton("Retour au Menu");
        retourMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajoutez ici la logique pour revenir au menu principal
                cardLayout.show(cardPanel, "Menu");
            }
        });

        // Ajoutez les composants à votre JPanel
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(new JScrollPane(rulesTextArea), BorderLayout.CENTER);
        add(retourMenuButton, BorderLayout.SOUTH);
    }

    private void createGUI() {
        // Ajoutez ici la logique de configuration de l'interface graphique
        // Exemple : setBackground(new Color(205, 55, 35, 255));
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

    // Exemple d'utilisation
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Règles du jeu");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 400);

                JeuGUI jeuGUI = new JeuGUI();  // Assurez-vous d'initialiser votre classe principale correctement
                ReglesGUI reglesGUI = new ReglesGUI(jeuGUI);

                frame.add(reglesGUI);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}



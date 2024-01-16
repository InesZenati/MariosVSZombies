import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GameWinGUI extends JPanel {
    private JeuGUI jeu;
    private static JLabel score;

    public GameWinGUI(JeuGUI j) {
        jeu = j;
        setLayout(new BorderLayout());

        // Autres trucs de la page
        JPanel centralPanel = new JPanel(new GridBagLayout());
        centralPanel.setBackground(new Color( 250, 159, 190));

        // Titre Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        JLabel titleLabel = new JLabel("GAME WIN");
        titleLabel.setFont(loadMarioFont().deriveFont(Font.BOLD, 50));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        JPanel scorePanel = new JPanel();
        scorePanel.setOpaque(false);
        score = new JLabel("TON SCORE : " + jeu.getJoueur().getScore());
        score.setFont(loadMarioFont().deriveFont(Font.BOLD, 30));
        score.setForeground(Color.WHITE);
        scorePanel.add(score);

        // Start
        JButtonStyled startButton = new JButtonStyled("Retour au menu");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jeu.getCardLayout().show(jeu.getCardPanel(), "Menu");
            }
        });

        // Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(startButton);

        // Centrer les composants
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        centralPanel.add(titlePanel, gbc);

        gbc.gridy = 1;
        centralPanel.add(scorePanel, gbc);

        gbc.gridy = 2;
        centralPanel.add(buttonsPanel, gbc);

        // Ajouter les composants au JPanel
        add(centralPanel, BorderLayout.CENTER);

        // Fond d'image Peach
        ImageIcon peachImage = new ImageIcon("fonts/Peach.png");
        Image peachOriginal = peachImage.getImage();
        int peachWidth = 350;
        int peachHeight = 400;

        // Redimensionner l'image Peach
        Image peachScaled = peachOriginal.getScaledInstance(peachWidth, peachHeight, Image.SCALE_SMOOTH);
        ImageIcon peachScaledIcon = new ImageIcon(peachScaled);
        JLabel peachLabel = new JLabel(peachScaledIcon);
        peachLabel.setBounds(0, 0, peachWidth, peachHeight);

        // Fond d'image à droite
        ImageIcon rightImage = new ImageIcon("fonts/fillCOrner.png");
        Image rightOriginal = rightImage.getImage();
        int rightWidth = 100;  // Ajustez la largeur selon vos besoins
        int rightHeight = 400; // Ajustez la hauteur selon vos besoins

        // Redimensionner l'image à droite
        Image rightScaled = rightOriginal.getScaledInstance(rightWidth, rightHeight, Image.SCALE_SMOOTH);
        ImageIcon rightScaledIcon = new ImageIcon(rightScaled);
        JLabel rightLabel = new JLabel(rightScaledIcon);

        // Fond d'image à gauche
        ImageIcon leftImage = new ImageIcon("fonts/fillCOrner.png");
        Image leftOriginal = leftImage.getImage();
        int leftWidth = 100;  // Ajustez la largeur selon vos besoins
        int leftHeight = 400; // Ajustez la hauteur selon vos besoins

        // Redimensionner l'image à gauche
        Image leftScaled = leftOriginal.getScaledInstance(leftWidth, leftHeight, Image.SCALE_SMOOTH);
        ImageIcon leftScaledIcon = new ImageIcon(leftScaled);
        JLabel leftLabel = new JLabel(leftScaledIcon);

        // Ajouter les images à droite et à gauche
        JPanel imagePanel = new JPanel(null);
        imagePanel.setOpaque(false);
        imagePanel.add(leftLabel);
        imagePanel.add(peachLabel);
        imagePanel.add(rightLabel);

        add(imagePanel, BorderLayout.SOUTH);
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

    public void updateScore() {
        int nouveauScore = jeu.getJoueur().getScore();
        score.setText("TON SCORE : " + nouveauScore);
    }

    public static JLabel getScore() {
        return score;
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
                    setBackground(new Color(109, 7, 26));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    setBackground(new Color(255, 138, 119));
                }
            });
        }
    }
}

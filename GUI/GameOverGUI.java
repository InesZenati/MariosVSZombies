import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GameOverGUI extends JPanel {
    private JeuGUI jeu;
    private JLabel score;
   

    public GameOverGUI(JeuGUI j) {
        jeu =j;
        setLayout(new BorderLayout());

        // police Mario
        Font marioFont = loadMarioFont();

        //  fond d'image 
        ImageIcon backgroundImage = new ImageIcon("fonts/mario.png");
        Image originalImage = backgroundImage.getImage();
        int newWidth = 1280;
        int newHeight = 400;

        // Redimensionner l'image
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);//nv image redimensionnée
        JLabel backgroundLabel = new JLabel(scaledImageIcon);//nv label avec l'image redimensionnée
        // padding
                backgroundLabel.setBorder(BorderFactory.createEmptyBorder(-5, 0, 82, 0));

        add(backgroundLabel, BorderLayout.SOUTH);
        backgroundLabel.setPreferredSize(new Dimension(backgroundImage.getIconWidth(), 200));

        // autres trucs de la page
        JPanel centralPanel = new JPanel(new GridBagLayout());
        centralPanel.setBackground(new Color(205, 55, 35, 255)); // Rend le fond transparent pour montrer l'image en bas

        // Titre Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        JLabel titleLabel = new JLabel("GAME OVER");
        titleLabel.setFont(marioFont.deriveFont(Font.BOLD, 50));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        JPanel scorePanel = new JPanel();
        scorePanel.setOpaque(false);
        score = new JLabel("TON SCORE : " + jeu.getJoueur().getScore());
        score.setFont(marioFont.deriveFont(Font.BOLD, 30));
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

     

        // centrer les composants
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;//inutil j'ai limpression pas tropcapter a quoi ça sert
        centralPanel.add(titlePanel, gbc);
        
        gbc.gridy = 1;
        centralPanel.add(scorePanel, gbc);
        
        gbc.gridy = 2;
        centralPanel.add(buttonsPanel, gbc);

        // Ajouter le panel central à la partie centrale de la fenêtre
        add(centralPanel, BorderLayout.CENTER);
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

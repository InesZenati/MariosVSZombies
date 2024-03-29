import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
public class setJeu extends JPanel {
    private JeuGUI jeu;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private static String selectedDecor="test";
    private String selectedDifficulty;

    public setJeu(JeuGUI j) {
        jeu = j;
        this.cardLayout = j.getCardLayout();
        this.cardPanel = j.getCardPanel();

        setLayout(new BorderLayout());

        // police Mario
        Font marioFont = loadMarioFont();

        // Panel central pour les autres composants
        JPanel centralPanel = new JPanel(new GridBagLayout()) {
            // Same que pour l'autre classe
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("fonts/menuBack.jpeg"); 
                Image image = background.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Titre Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        JLabel titleLabel = new JLabel("Configuration du Jeu");
        titleLabel.setFont(marioFont.deriveFont(Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        //Decors du jeu
        JPanel decorsPanel = new JPanel();
        decorsPanel.setOpaque(false);
        JLabel decors = new JLabel("Decors :");
        decors.setFont(marioFont.deriveFont(Font.PLAIN, 30));
        decors.setForeground(Color.WHITE);
        decorsPanel.add(decors);

        // Pour les boutons de décor
        JButtonStyled BasicButton = new JButtonStyled("Basic");
        BasicButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedDecor = "Basic";
    }
});

    JButtonStyled PlateauT = new JButtonStyled("Nouveau");
    PlateauT.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        selectedDecor = "Nouveau";

    }
});


        // Mode de difficulté Panel
        JPanel difficultyPanel = new JPanel();
        difficultyPanel.setOpaque(false);
        JLabel difficulty = new JLabel("Mode de difficulte :");
        difficulty.setFont(marioFont.deriveFont(Font.PLAIN, 30));
        difficulty.setForeground(Color.WHITE);
        difficultyPanel.add(difficulty);




// Pour les boutons de difficulté
JButtonStyled easyButton = new JButtonStyled("Facile");
easyButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        selectedDifficulty = "Facile";
        //couleur bordeau
    }
});

JButtonStyled mediumButton = new JButtonStyled("Moyen");
mediumButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        selectedDifficulty = "Moyen";
    }
});

JButtonStyled hardButton = new JButtonStyled("Difficile");
hardButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        selectedDifficulty = "Difficile";
    }
});

JButtonStyled marathonMode = new JButtonStyled("Marathon");
marathonMode.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        selectedDifficulty = "Marathon";
    }
});



   JButtonStyled BackButton = new JButtonStyled("Retour au menu");
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Menu");
            }
        });

        JButtonStyled CommencerButton = new JButtonStyled("Commencer");
        CommencerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tryToShowNewPage();
                j.getController().debut();
                
               // j.getController().start();
            }
        });

     
// centrer les trucs
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.weighty = 1.0;
centralPanel.add(titlePanel, gbc);

// Decors
gbc.gridy = 1;
gbc.gridwidth = 3;
centralPanel.add(decorsPanel, gbc);

// Boutons de décors
gbc.gridy = 2;
gbc.gridwidth = 1;
gbc.gridx = 0;
centralPanel.add(BasicButton, gbc);

gbc.gridx = 2;
centralPanel.add(PlateauT, gbc);

// Mode de difficulté
gbc.gridy = 3;
gbc.gridx = 0;
gbc.gridwidth = 3;
centralPanel.add(difficultyPanel, gbc);

// Boutons de difficulté
gbc.gridy = 4;
gbc.gridx = -1;
gbc.gridwidth = 1;
centralPanel.add(easyButton, gbc);

gbc.gridx = 1;
centralPanel.add(mediumButton, gbc);

gbc.gridx = 3;
gbc.gridwidth = 1;
centralPanel.add(hardButton, gbc);

// Bouton pour le mode marathon (ajouté pour illustration, ajustez selon vos besoins)
gbc.gridy = 5;
gbc.gridx = 1;
centralPanel.add(marathonMode, gbc);

// Boutons de navigation
gbc.gridy = 6;
gbc.gridx = 0;
centralPanel.add(BackButton, gbc);

gbc.gridx = 2;
centralPanel.add(CommencerButton, gbc);

add(centralPanel, BorderLayout.CENTER);


    }

    public static String getSelectedDecor() {
        return selectedDecor;
    }

    private void tryToShowNewPage() {
        // Vérifier si les deux sélections ont été faites
        if (selectedDecor != null && selectedDifficulty != null) {
            Joueur j =jeu.getJoueur();
            j.setArgent(24);
            j.setScore(0);
            Plateau plato = new Plateau(5, 9, selectedDifficulty,j);
            jeu.setPlateau(plato);

            cardLayout.show(cardPanel, "PlateauGUI"); 
        }
    }

    private Font loadMarioFont() {
        try {
            File fontFile = new File("fonts/SuperMario256.ttf");
            return Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(14f);
        } catch (Exception e) {
            e.printStackTrace();
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
            //change color when hover
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

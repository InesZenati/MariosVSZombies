import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuGUI extends JPanel {
    private JeuGUI jeu;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MenuGUI(JeuGUI j) {
        jeu = j;
        this.cardLayout = j.getCardLayout();
        this.cardPanel = j.getCardPanel();

        setLayout(new BorderLayout());

        // police Mario
        Font marioFont = loadMarioFont();

        // Panel central pour les autres composants
        JPanel centralPanel = new JPanel(new GridBagLayout()) {
            // définir l'image de fond
            @Override
            protected void paintComponent(Graphics g) {//obliger d'etre protected psq çca vient de la super class JPanel
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("fonts/menuBack.jpeg"); 
                Image image = background.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);//parametres drawImage pour metrrel'image
            }
        };

        // titre Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        JLabel titleLabel = new JLabel("MENU");
        titleLabel.setFont(marioFont.deriveFont(Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        // Bouton style
        JButtonStyled rulesButton = new JButtonStyled("Lire les règles");
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               cardLayout.show(cardPanel, "Regles");
            }
        });

        
        JButtonStyled catalogueButton = new JButtonStyled("Catalogue");
        catalogueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cardLayout.show(cardPanel, "Catalogue");
            }
        });
        
        JButtonStyled quitButton = new JButtonStyled("Quitter");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              /* je sais pas si on met vraiment psq travail en plus 
              int option = JOptionPane.showConfirmDialog(MenuGUI.this, "Merci d'avoir joué. Voulez-vous vraiment quitter?", "Quitter", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                */
            }
        });
        
        JButtonStyled playButton = new JButtonStyled("Jouer");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Config");
            }
        });
        
        //  GridBagConstraints pour centrer les trucs
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = -1; 
        gbc.insets = new Insets(10, 0, 10, 0); //   marges 
        centralPanel.add(titlePanel, gbc);
        
        gbc.gridy = 1;
        centralPanel.add(rulesButton, gbc);
        
        gbc.gridy = 2;
        centralPanel.add(catalogueButton, gbc);
        
        gbc.gridy = 3;
        centralPanel.add(quitButton, gbc);
        
        gbc.gridy = 4;
        centralPanel.add(playButton, gbc);
        
        
        // Ajouter le panel central à la partie centrale de la fenêtre
        add(centralPanel, BorderLayout.CENTER);
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

    //On fait une classe interne et pas une class seule psq on a besoin de la classe MenuGUI et c'est long de la mettre seules
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

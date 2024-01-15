import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ReglesGUI extends JPanel {
    private JeuGUI jeuGUI;
  
     // police Mario
     Font marioFont = loadMarioFont(); // Ajoutez une référence à votre classe principale si nécessaire

    public ReglesGUI(JeuGUI jeuGUI) {
        this.jeuGUI = jeuGUI;
        setLayout(new BorderLayout());

        JPanel centralPanel = new JPanel(new GridBagLayout());
        centralPanel.setBackground(new Color(205, 55, 35, 255));
    
            // Titre Panel
            JPanel titlePanel = new JPanel();
            titlePanel.setOpaque(false);
            JLabel titleLabel = new JLabel("Regles du jeu");
            titleLabel.setFont(marioFont.deriveFont(Font.BOLD, 30));
            titleLabel.setForeground(Color.WHITE);
            titlePanel.add(titleLabel);
            centralPanel.add(titlePanel);
            titlePanel.setBorder(new EmptyBorder(10, 480, 5, 20));

            //Texte des regles du jeu 
            JPanel rules = new JPanel();
            JTextArea regles = new JTextArea();
            regles.setEditable(false);
            regles.setFont(loadMarioFont().deriveFont(Font.PLAIN,20));
           
            regles.append("Bienvenue dans Mario VS Koopa ");
            regles.append("\n");
            regles.append("\n");
            regles.append("Dans ce jeu vous devez proteger votre chateau de vos ennemis le koopa redoutables");
            regles.append("\n");
            regles.append("\n");
            regles.append("Pour cela vous diposez de plusieur Mario que vous pouvez consulter dans le catalogue");
            regles.append("\n");
            regles.append("\n");
            regles.append("Pour jouer c'est trés simple clique sur le boutton jouer du menu puis selectionnez le niveau et la difficultée de votre partie");
            regles.append("\n");
            regles.append("\n");
            regles.append("Afin de placer vos Marios selctionnez un dans la barre de menu a droite puis cliquez sur la case ou vous sougaitez le placer");
            regles.append("\n");
            regles.append("\n");
            regles.append("Cependant vous ne pouvez pas placer de Marios a la derniere colone du jeu");
            regles.append("\n");
            regles.append("\n");
            regles.append("Chaque Mario a un prix tuez des Koopa afin de gagner plus de champignon et achetez des Marios puissants");
            rules.add(regles);
           // rules.setBackground(new Color(205, 55, 35, 255));
            JScrollPane scrollPane = new JScrollPane(regles);
            scrollPane.setBorder(null);
            regles.setLineWrap(true);
            regles.setForeground(Color.WHITE);
            regles.setBackground(new Color(205, 55, 35, 255));
            scrollPane.setPreferredSize(new Dimension(400, 200));
            regles.setBorder(new EmptyBorder(20, 20, 20, 20));
            rules.add(scrollPane);
            centralPanel.add(rules);
           

            JPanel boutonPanel = new JPanel();
            boutonPanel.setOpaque(false);

            JButtonStyled retour = new JButtonStyled("Retour au menu");
            retour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                 jeuGUI.getCardLayout().show(jeuGUI.getCardPanel(), "Menu");
                }
            });

            boutonPanel.add(retour);
            centralPanel.add(boutonPanel);
            add(centralPanel, BorderLayout.CENTER);
            boutonPanel.setBorder(new EmptyBorder(0, 480, 10, 10));

            //tout centrer
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.NORTH;
            centralPanel.add(titlePanel, gbc);

            gbc.gridy=1;
            gbc.anchor = GridBagConstraints.CENTER;
            centralPanel.add(rules,gbc);

            gbc.gridy = 3;  // Vous pouvez ajuster cette valeur selon vos besoins
            gbc.anchor = GridBagConstraints.SOUTH;  // Aligner en bas
            centralPanel.add(boutonPanel, gbc);


            gbc.gridy = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 2;  // Étendre sur deux colonnes
            gbc.gridheight = 1; // Sur une ligne
            gbc.fill = GridBagConstraints.BOTH; // Remplir l'espace disponible
            gbc.weightx = 1.0; // Poids en largeur
            gbc.weighty = 1.0; // Poids en hauteur
            centralPanel.add(scrollPane, gbc);
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

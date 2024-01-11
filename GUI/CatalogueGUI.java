import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CatalogueGUI extends JPanel {
    private JPanel menuPanel;
    private JButton backButton; // Ajout du bouton "Back"

    private static Mario selectedPersonnage;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JeuGUI jeuGUI;

    public JeuGUI getJeuGUI() {
        this.selectedPersonnage = null;
        return this.jeuGUI;
    }

    Font marioFont = loadMarioFont();

    public CatalogueGUI(JeuGUI jeuGUI) {
        this.jeuGUI = jeuGUI;

        setLayout(new BorderLayout()); // pour que le panel soit divisé en 5 parties

        cardLayout = jeuGUI.getCardLayout();

        cardPanel = jeuGUI.getCardPanel();

        // Création du menuPanel à gauche
        menuPanel = createSideMenu();
        add(menuPanel, BorderLayout.WEST);
        menuPanel.setBackground(new Color(205, 55, 35, 255));
        JButtonStyled retour = new JButtonStyled("Retour au menu");
        add(retour, BorderLayout.SOUTH);
        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                cardLayout.show(cardPanel, "Menu");
            }
        });
    }

    private JPanel createSideMenu() {
        JPanel sideMenu = new JPanel();

        sideMenu.setLayout(new BoxLayout(sideMenu, BoxLayout.Y_AXIS));

        sideMenu.add(createTowerButton("BasicMario", "BasicMario.png", 10, description("BasicMario")));
        sideMenu.add(createTowerButton("FireMario", "FireMario.png", 20, description("FireMario")));
        sideMenu.add(createTowerButton("WallBrick", "BasicMario.png", 25, description("WallBrick")));
        sideMenu.add(createTowerButton("BigMario", "BigMario.png", 50, description("BigMario")));
        sideMenu.add(createTowerButton("StarMario", "SuperMario.png", 100, description("StarMario")));


        return sideMenu;
    }

    public JButton createTowerButton(String name, String imagePath, int prix, String description) {
        JButton mario = new JButton();
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
            mario.setIcon(icon);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    
        JLabel titre = new JLabel(name);
        JLabel price = new JLabel("$" + prix);
        JTextArea desc = new JTextArea(description); 
        desc.setEditable(false); 
        JScrollPane scrollPane = new JScrollPane(desc); 
    
        mario.setLayout(new FlowLayout(FlowLayout.CENTER));
    
        mario.add(titre);
        mario.add(price);
        mario.add(scrollPane); 
    
        return mario;
    }
    
    public String description(String name) {
        String description = "";
        switch (name) {
            case "BasicMario":
                description = "C'est un Mario de base il attaque a courte porté seleument le koopa devant lui \n Caractéristique : \n -Portée : 1 \n -Dégats : 1 \n -Vitesse d'attaque : 1 \n -Prix : 10$ \n -Defense = 10";
                break;

            case "FireMario":
                description = "C'est un Mario qui peut tirer des boules de flammes il attaque a longue porté ,jusqu'a trois case ,le koopa devant lui \n Caractéristique : \n -Portée : 1 \n -Dégats : 1 \n -Vitesse d'attaque : 1 \n -Prix : 10$ \n -Defense = 10";
                break;
            case "WallBrick":
                description = "C'est un Mario de defense il n'attaque pas mais vous protege du koopa devant lui tel un mur\n Caractéristique : \n -Portée : 1 \n -Dégats : 1 \n -Vitesse d'attaque : 1 \n -Prix : 10$ \n -Defense = 10";
                break;
            case "BigMario":
                description = "C'est un Mario qui attaque les deux zombie devant lui en meme temps \n Caractéristique : \n -Portée : 1 \n -Dégats : 1 \n -Vitesse d'attaque : 1 \n -Prix : 10$ \n -Defense = 10";
                break;
            case "StarMario":
                description = "C'est le plus puissant des Mario bien qu'il dispose d'une attaque a courte porté il est trés puissant et posséde une grande defense \n Caractéristique : \n -Portée : 1 \n -Dégats : 1 \n -Vitesse d'attaque : 1 \n -Prix : 10$ \n -Defense = 10";
                break;
        }
        return description;
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

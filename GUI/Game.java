import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Game extends JPanel {
    private Plateau plateau;
    private JPanel plateauPanel;
    private JPanel menuPanel;
    private JPanel topPanel;
    private JLabel argentLabel;
    private Mario selectedPersonnage;
    private static int argent = 30;
    private Joueur joueur;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public Game(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        plateau = new Plateau(5, 9);

        setLayout(new BorderLayout());

        Font marioFont = loadMarioFont();

        // Création du menuPanel à gauche
        menuPanel = createSideMenu();
        add(menuPanel, BorderLayout.WEST);

        // Création du plateauPanel au centre
        plateauPanel = createPlateauPanel();
        add(plateauPanel, BorderLayout.CENTER);

        // Création du topPanel en haut
        topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        // Initialisation de la variable pour le personnage sélectionné
        selectedPersonnage = null;
    }

    private JPanel createSideMenu() {
        JPanel sideMenu = new JPanel();

        sideMenu.setLayout(new BoxLayout(sideMenu, BoxLayout.Y_AXIS));

        sideMenu.add(createTowerButton("BasicMario", "/fonts/BasicMario.png", 10)); 
        sideMenu.add(createTowerButton("FireMario", "/fonts/BasicMario.png", 20));
        sideMenu.add(createTowerButton("WallBrick", "/fonts/BasicMario.png", 25)); 
        sideMenu.add(createTowerButton("BigMario", "/fonts/BasicMario.png", 50));
        sideMenu.add(createTowerButton("StarMario", "/fonts/BasicMario.png", 100));

        return sideMenu;
    }

 
     
    private JPanel createPlateauPanel() {
        JPanel outerPanel = new JPanel(new BorderLayout());
    
        // Création du plateauPanel au centre
        JPanel panel = new JPanel(new GridLayout(5, 9));
    
        for (int li = 0; li < plateau.getNumLi(); li++) {
            for (int col = 0; col < plateau.getNumCols(); col++) {
                JButton button = new JButton();
                int finalLi = li;
                int finalCol = col;
    
                // Ajoutez une action pour placer le personnage sur la case lorsque le bouton est cliqué
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (selectedPersonnage != null) {
                            // Logique pour placer le personnage sur la case
                            placerPersonnage(selectedPersonnage, finalLi, finalCol);
                            // Mettez à jour l'affichage du plateau et l'argent du joueur
                            updatePlateau();
                            updateArgentLabel(argent);
                            selectedPersonnage = null;
                        }
                    }
                });
    
                panel.add(button);
            }
        }
    
        // Ajouter un espace autour du plateau
        panel.setBorder(BorderFactory.createEmptyBorder(50, 30, 50, 60));
    
        outerPanel.add(panel, BorderLayout.CENTER);
    
        return outerPanel;
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel();
        argentLabel = new JLabel("Argent restant : " + argent);
        argentLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(argentLabel);
        return panel;
    }

    private void placerPersonnage(Mario personnage, int li, int col) {
            // Vérifier si le joueur a assez d'argent pour acheter le personnage
            int prixPersonnage = personnage.getPrix();
            if (argent >= prixPersonnage) {
                // Placer le personnage sur le plateau
                plateau.placeMario(personnage, li, col);
                // Déduire le coût du personnage de l'argent du joueur
                this.argent -= prixPersonnage;
        
                // Mettre à jour l'argent du joueur
                updateArgentLabel(this.argent);
        
                // Mettre à jour l'affichage du plateau
                updatePlateau();
            } else {
                
            }
        }
        
        

        private void updatePlateau() {
            for (int li = 0; li < plateau.getNumLi(); li++) {
                for (int col = 0; col < plateau.getNumCols(); col++) {
                    JButton button = getButtonAt(li, col);
                    Mario contenuCase = (Mario)plateau.getCase(li, col).getPersonnage();
        
                    // Mettez à jour le texte ou l'icône du bouton en fonction du contenu de la case
                    if (contenuCase != null) {
                        // Si la case est occupée par un personnage, mettez à jour le bouton en conséquence
                        button.setText(contenuCase.getName()); // Par exemple, utilisez le nom du personnage
                        // Vous pouvez également mettre à jour l'icône du bouton si vous utilisez des images
                         //button.setIcon(new ImageIcon(contenuCase.getImagePath()));
                    } else {
                        // Si la case est vide, réinitialisez le bouton
                        button.setText("");
                        button.setIcon(null);
                    }
                }
            }
        }
        

        private JButton getButtonAt(int li, int col) {
            Component[] components = plateauPanel.getComponents();
            int index = li * plateau.getNumCols() + col;
            return (JButton) components[index];
        }
        

    private void updateArgentLabel(int n) {
        // Mettez à jour le texte de l'argentLabel en fonction de l'argent du joueur
        argentLabel.setText("Argent restant : " + n);
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
  
    private JButton createTowerButton(String towerTitle, String imagePath, int price) {
        JButton button = new JButton();
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set tower image
        try {
            ImageIcon originalIcon = new ImageIcon(getClass().getResource(imagePath));
            Image originalImage = originalIcon.getImage();

            // Calculate the new dimensions while maintaining the original aspect ratio
            int maxDimension = 50; // Set the maximum dimension for consistent sizing

            int width;
            int height;

            if (originalIcon.getIconWidth() > originalIcon.getIconHeight()) {
                // Landscape-oriented image
                width = maxDimension;
                height = (int) ((double) maxDimension / originalIcon.getIconWidth() * originalIcon.getIconHeight());
            } else {
                // Portrait-oriented image
                height = maxDimension;
                width = (int) ((double) maxDimension / originalIcon.getIconHeight() * originalIcon.getIconWidth());
            }

            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledImage));
        } catch (NullPointerException e) {
            // Handle the case where the image file is not found
            e.printStackTrace();
        }

        // Set tower title and price
        JLabel titleLabel = new JLabel(towerTitle);
        JLabel priceLabel = new JLabel("$" + price);

        // Set layout for the button
        button.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add components to the button with the desired order
        button.add(titleLabel);
        button.add(priceLabel);

        // Add action listener for tower selection (you can customize this)
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedPersonnage = etPersonnageByName(selectedPersonnageName);
            }
        });

        return button;
    }
    

    private Mario getPersonnageByName(String name) {
        switch (name) {
            case "BasicMario":
                return new BasicMario();
            case "FireMario":
                return new FireMario();
            case "WallBrick":
                return new WallBrick();
            case "BigMario":
                return new BigMario();
            case "StarMario":
                return new StarMario();
            default:
                return null;
        }
    }

}

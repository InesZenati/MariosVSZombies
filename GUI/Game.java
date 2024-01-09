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
    private List<JButton> buttons; 
    private Joueur joueur;
    private CardLayout cardLayout;
    private JPanel cardPanel;
   

    public Game(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        plateau = new Plateau(5, 9);

        setLayout(new BorderLayout());

     //   Font marioFont = loadMarioFont();

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

        sideMenu.add(createTowerButton("BasicMario", "BasicMario.png", 10)); 
        sideMenu.add(createTowerButton("FireMario", "BasicMario.png", 20));
        sideMenu.add(createTowerButton("WallBrick", "BasicMario.png", 25)); 
        sideMenu.add(createTowerButton("BigMario", "BasicMario.png", 50));
        sideMenu.add(createTowerButton("StarMario", "BasicMario.png", 100));

        return sideMenu;
    }

 
     
    private JPanel createPlateauPanel() {
        JPanel outerPanel = new JPanel(new BorderLayout());
    
        // Création du plateauPanel au centre
        JPanel panel = new JPanel(new GridLayout(5, 9));
    /* 
        List<JButton> buttons = new ArrayList<>(); // Nouvelle liste pour stocker les boutons
    
        for (int li = 0; li < plateau.getNumLi(); li++) {
            for (int col = 0; col < plateau.getNumCols(); col++) {
              //  JButton button = new JButton();
            //    buttons.add(button); // Ajouter le bouton à la liste
           //     int finalLi = li;
             //   int finalCol = col;
    
                // Ajoutez une action pour placer le personnage sur la case lorsque le bouton est cliqué
              
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (selectedPersonnage != null) {
                            // Logique pour placer le personnage sur la case
                            placerPersonnage(selectedPersonnage, finalLi, finalCol);
                            // Mettez à jour l'affichage du plateau et l'argent du joueur
                            updatePlateau(); // Passer la liste de boutons à la méthode updatePlateau
                            updateArgentLabel(argent);
                            selectedPersonnage = null;
                        }
                    }
                    
                });
    */
                panel.add();
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
            // Vérifier si la case est déjà occupée
            if (plateau.getCase(li, col).getPersonnage() == null) {
                // Placer le personnage sur le plateau
                System.out.println("Placement du personnage sur le plateau");
                plateau.placeMario(personnage, li, col);
                // Déduire le coût du personnage de l'argent du joueur
                this.argent -= prixPersonnage;
    
                // Mettre à jour l'argent du joueur
                System.out.println("Mise à jour de l'argent du joueur");
                updateArgentLabel(this.argent);
    
                // Mettre à jour l'affichage du plateau
                System.out.println("Mise à jour du plateau");
                updatePlateau();
                System.out.println("Placement du personnage terminé");
            } else {
                // La case est déjà occupée, vous pouvez gérer cela selon vos besoins
                // Par exemple, afficher un message d'erreur, ne rien faire, etc.
                System.out.println("La case est déjà occupée !");
            }
        } else {
            // Le joueur n'a pas assez d'argent, vous pouvez gérer cela selon vos besoins
            // Par exemple, afficher un message d'erreur, ne rien faire, etc.
            System.out.println("Pas assez d'argent pour acheter ce personnage !");
        }
    }
    
        
        

    private void updatePlateau() {
        System.out.println(1);
        for (int li = 0; li < plateau.getNumLi(); li++) {
            System.out.println(2);
            for (int col = 0; col < plateau.getNumCols(); col++) {
                System.out.println(3);
                JButton button = getButtonAt(li , plateau.getNumCols() );
                System.out.println(4);
                if (button != null) {
                    System.out.println(5);
                    System.out.println("Mise à jour de la case [" + li + ", " + col + "]");
                    Mario contenuCase = (Mario) plateau.getCase(li, col).getPersonnage();
                    System.out.println(6);
    
                    // Mettez à jour l'icône du bouton en fonction du contenu de la case
                    if (contenuCase != null) {
                        System.out.println(7);
                        // Si la case est occupée par un personnage, mettez à jour le bouton en conséquence
                        button.setText("hffkhg"); // Effacez le texte
                        System.out.println(8);
                        String imagePath = contenuCase.getImagePath();
                        System.out.println(9);
                        button.setIcon(new ImageIcon(contenuCase.getImagePath()));
                        System.out.println(10);
                        System.out.println("Chemin d'accès à l'image : " + imagePath);
                        System.out.println(11);
                    } else {
                        System.out.println(12);
                        // Si la case est vide, réinitialisez le bouton
                        button.setText("");
                        System.out.println(13);
                        System.out.println("Case [" + li + ", " + col + "] vide");
                        System.out.println(14);
                        button.setIcon(null);
                        System.out.println(15);
                    }
                }
            }
        }
    }
    
          

    private JButton getButtonAt(int li, int col) {
        Component[] components = plateauPanel.getComponents();
        int index = li * plateau.getNumCols() + col;
    
        if (index >= 0 && index < components.length && components[index] instanceof JButton) {
            System.out.println("Button found at [" + li + ", " + col + "]");
            return (JButton) components[index];
        } else {
            System.out.println("No button found at [" + li + ", " + col + "]");
            return null; // ou gérez l'erreur d'une autre manière
        }
    }
    
        
        

    private void updateArgentLabel(int n) {
        // Mettez à jour le texte de l'argentLabel en fonction de l'argent du joueur
        argentLabel.setText("Argent restant : " + n);
    }
/* 
      private Font loadMarioFont() {
        try {
            File fontFile = new File("SuperMario256.ttf");
            return Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(14f);
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("SansSerif", Font.PLAIN, 38);
        }
    }
  */
    private JButton createTowerButton(String towerTitle, String imagePath, int price) {
            JButton button = new JButton();
        
            // Set tower image
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
                button.setIcon(icon);
            } catch (NullPointerException e) {
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
                selectedPersonnage = getPersonnageByName(towerTitle);
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
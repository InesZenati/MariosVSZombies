import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class CatalogueGUI extends JPanel {
    private JeuGUI jeuGUI;

    public CatalogueGUI(JeuGUI jeuGUI) {
        this.jeuGUI = jeuGUI;
        setLayout(new BorderLayout());

        Font marioFont = loadMarioFont();

        JPanel centralPanel = new JPanel(new GridBagLayout()) {
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
        JLabel titleLabel = new JLabel("CATALOGUE");
        titleLabel.setFont(marioFont.deriveFont(Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        titlePanel.setBorder(new EmptyBorder(10, 90, 30, 20));
        
        // Catalogue Panel
        JPanel createCatalogueMario = createCatalogueMario();
        createCatalogueMario.setOpaque(false);
        JPanel createCatalogueZombie = catalogueZombie();
        createCatalogueZombie.setOpaque(false);
        
        // Bouton Panel
        JPanel boutonPanel = new JPanel();
        boutonPanel.setOpaque(false);
        JButtonStyled retour = new JButtonStyled("Retour au menu");
        retour.addActionListener(e -> jeuGUI.getCardLayout().show(jeuGUI.getCardPanel(), "Menu"));
        boutonPanel.add(retour);
        
        // Mettez à jour les contraintes pour placer les éléments correctement
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        centralPanel.add(titlePanel, gbc);

        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        centralPanel.add(createCatalogueMario, gbc);

        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        centralPanel.add(createCatalogueZombie, gbc);

        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.weighty = 1.0; // Cette ligne ajoute du poids à la cellule pour prendre l'espace disponible
        centralPanel.add(boutonPanel, gbc);
        add(centralPanel, BorderLayout.CENTER);
    }

    public JPanel createCatalogueMario() {
        JPanel cataloguePanelM = new JPanel();
        JPanel BasicMario = new JPanel();
        JPanel FireMario = new JPanel();
        JPanel BigMario = new JPanel();
        JPanel WallBrick = new JPanel();
        JPanel StarMario = new JPanel();
        BasicMario.setOpaque(false);
        BasicMario.setLayout(new BoxLayout(BasicMario, BoxLayout.X_AXIS));
        BasicMario.setBorder(new EmptyBorder(5, 5, 5, 5));

        FireMario.setOpaque(false);
        FireMario.setLayout(new BoxLayout(FireMario, BoxLayout.X_AXIS));
        FireMario.setBorder(new EmptyBorder(5, 5, 5, 5));

        BigMario.setOpaque(false);
        BigMario.setLayout(new BoxLayout(BigMario, BoxLayout.X_AXIS));
        BigMario.setBorder(new EmptyBorder(5, 5, 5, 5));

        WallBrick.setOpaque(false);
        WallBrick.setLayout(new BoxLayout(WallBrick, BoxLayout.X_AXIS));
        WallBrick.setBorder(new EmptyBorder(5, 5, 5, 5));

        StarMario.setOpaque(false);
        StarMario.setLayout(new BoxLayout(StarMario, BoxLayout.X_AXIS));
        StarMario.setBorder(new EmptyBorder(5, 5, 5, 5));


        // Ajoutez des MarioPanels pour chaque Mario
        BasicMario.add(new MarioPanel("BasicMario", "8$", "Type attaque", "Type defense", "Force attaque"));
        FireMario.add(new MarioPanel("FireMario", "100$", "Type attaque", "Type defense", "Force attaque"));
        BigMario.add(new MarioPanel("BigMario", "100$", "Type attaque", "Type defense", "Force attaque"));
        WallBrick.add(new MarioPanel("WallBrick", "100$", "Type attaque", "Type defense", "Force attaque"));
        StarMario.add(new MarioPanel("StarMario", "100$", "Type attaque", "Type defense", "Force attaque"));

        cataloguePanelM.add(BasicMario);
        cataloguePanelM.add(FireMario);
        cataloguePanelM.add(BigMario);
        cataloguePanelM.add(WallBrick);
        cataloguePanelM.add(StarMario);
        return cataloguePanelM;
    }

    public JPanel catalogueZombie(){
        JPanel cataloguePanelZ = new JPanel();
        JPanel zombie1 = new JPanel();
        JPanel zombie2 = new JPanel();
        JPanel zombie3 = new JPanel();
        JPanel Zombie = new JPanel();
        zombie1.setOpaque(false);
        zombie1.setLayout(new BoxLayout(zombie1, BoxLayout.X_AXIS));
        zombie1.setBorder(new EmptyBorder(5, 5, 5, 5));

        zombie2.setOpaque(false);
        zombie2.setLayout(new BoxLayout(zombie2, BoxLayout.X_AXIS));
        zombie2.setBorder(new EmptyBorder(5, 5, 5, 5));

        zombie3.setOpaque(false);
        zombie3.setLayout(new BoxLayout(zombie3, BoxLayout.X_AXIS));
        zombie3.setBorder(new EmptyBorder(5, 5, 5, 5));

        Zombie.setOpaque(false);
        Zombie.setLayout(new BoxLayout(Zombie, BoxLayout.X_AXIS));
        Zombie.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Ajoutez des ZombiePanels pour chaque Zombie
        zombie1.add(new ZombiePanel("ZombieSimple", "8$", "Type attaque", "Type defense", "Force attaque"));
        zombie2.add(new ZombiePanel("ZombieAmeliore", "100$", "Type attaque", "Type defense", "Force attaque"));
        zombie3.add(new ZombiePanel("SuperZombie", "100$", "Type attaque", "Type defense", "Force attaque"));
        Zombie.add(new ZombiePanel("SuperMegaUltraZombie", "100$", "Type attaque", "Type defense", "Force attaque"));

        cataloguePanelZ.add(zombie1);
        cataloguePanelZ.add(zombie2);
        cataloguePanelZ.add(zombie3);
        cataloguePanelZ.add(Zombie);

       return cataloguePanelZ;
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



private class MarioPanel extends JPanel {
    public MarioPanel(String name, String price, String attackType, String defenseType, String attackStrength) {
        setOpaque(true);
        setBackground(new Color(205, 55, 35, 255));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Appliquer la police Mario au nom du personnage
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(loadMarioFont().deriveFont(Font.BOLD, 20));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        add(nameLabel);

        ImageIcon icon = new ImageIcon(getClass().getResource(name + ".png"));
        Image image = icon.getImage();
        int panelSize = 100;
        Image scaledImage = image.getScaledInstance(panelSize, panelSize, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrer l'image
        add(imageLabel);

        // Appliquer la police Mario aux informations
        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(loadMarioFont().deriveFont(Font.BOLD, 18));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        priceLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        add(priceLabel);

        JLabel attackTypeLabel = new JLabel("Attack Type: "  );
        attackTypeLabel.setFont(loadMarioFont().deriveFont(Font.PLAIN, 18));
        attackTypeLabel.setForeground(Color.WHITE);
        attackTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(attackTypeLabel);

        JLabel defenseTypeLabel = new JLabel("Defense Type: "  );
        defenseTypeLabel.setFont(loadMarioFont().deriveFont(Font.PLAIN, 18));
        defenseTypeLabel.setForeground(Color.WHITE);
        defenseTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(defenseTypeLabel);

        JLabel attackStrengthLabel = new JLabel("Attack Strength: " );
        attackStrengthLabel.setFont(loadMarioFont().deriveFont(Font.PLAIN, 18));
        attackStrengthLabel.setForeground(Color.WHITE);
        attackStrengthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        attackStrengthLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
        add(attackStrengthLabel);
    }
}




    private class ZombiePanel extends JPanel {
        public ZombiePanel(String name, String price, String attackType, String defenseType, String attackStrength) {
            setOpaque(true);
            setBackground(new Color(205, 55, 35, 255));
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
            // Appliquer la police Mario au nom du personnage
            JLabel nameLabel = new JLabel(name);
            nameLabel.setFont(loadMarioFont().deriveFont(Font.BOLD, 20));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
            nameLabel.setForeground(Color.WHITE);
            nameLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
            add(nameLabel);
    
            ImageIcon icon = new ImageIcon(getClass().getResource(name + ".png"));
            Image image = icon.getImage();
            int panelSize = 100;
            Image scaledImage = image.getScaledInstance(panelSize, panelSize, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrer l'image
            add(imageLabel);
    
    
            JLabel attackTypeLabel = new JLabel("Attack Type: "  );
            attackTypeLabel.setFont(loadMarioFont().deriveFont(Font.PLAIN, 18));
            attackTypeLabel.setForeground(Color.WHITE);
            attackTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(attackTypeLabel);
    
            JLabel defenseTypeLabel = new JLabel("Defense Type: "  );
            defenseTypeLabel.setFont(loadMarioFont().deriveFont(Font.PLAIN, 18));
            defenseTypeLabel.setForeground(Color.WHITE);
            defenseTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(defenseTypeLabel);
    
            JLabel attackStrengthLabel = new JLabel("Attack Strength: " );
            attackStrengthLabel.setFont(loadMarioFont().deriveFont(Font.PLAIN, 18));
            attackStrengthLabel.setForeground(Color.WHITE);
            attackStrengthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            attackStrengthLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
            add(attackStrengthLabel);
        
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

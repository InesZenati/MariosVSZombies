import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.util.List;

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
        Plateau p = new Plateau();
        List<Mario> l = p.listeMario();
        JPanel cataloguePanelM = new JPanel();
        JPanel BasicMario = new JPanel();
        JPanel FireMario = new JPanel();
        JPanel BigMario = new JPanel();
        JPanel WallBrick = new JPanel();
        JPanel StarMario = new JPanel();
        BasicMario.setOpaque(false);
        BasicMario.setLayout(new BoxLayout(BasicMario, BoxLayout.X_AXIS));
        BasicMario.setBorder(new EmptyBorder(5, 10, 5, 10));

        FireMario.setOpaque(false);
        FireMario.setLayout(new BoxLayout(FireMario, BoxLayout.X_AXIS));
        FireMario.setBorder(new EmptyBorder(5, 10, 5, 10));

        BigMario.setOpaque(false);
        BigMario.setLayout(new BoxLayout(BigMario, BoxLayout.X_AXIS));
        BigMario.setBorder(new EmptyBorder(5, 10, 5, 10));

        WallBrick.setOpaque(false);
        WallBrick.setLayout(new BoxLayout(WallBrick, BoxLayout.X_AXIS));
        WallBrick.setBorder(new EmptyBorder(5, 10, 5, 10));

        StarMario.setOpaque(false);
        StarMario.setLayout(new BoxLayout(StarMario, BoxLayout.X_AXIS));
        StarMario.setBorder(new EmptyBorder(5, 10, 5, 10));


        // Ajoutez des MarioPanels pour chaque Mario
        BasicMario.add(new MarioPanel(l.get(0).getName(), l.get(0).getPrix()+"$", " Courte", " "+l.get(0).getInfoActuelle().getDefense(), " "+l.get(0).getInfoActuelle().getAttaque()));
        FireMario.add(new MarioPanel(l.get(2).getName(), l.get(2).getPrix()+"$", " Longue", " "+l.get(2).getInfoActuelle().getDefense(), " "+l.get(2).getInfoActuelle().getAttaque()));
        BigMario.add(new MarioPanel(l.get(3).getName(), l.get(3).getPrix()+"$", " Longue",  " "+l.get(3).getInfoActuelle().getDefense(), " "+l.get(3).getInfoActuelle().getAttaque()));
        WallBrick.add(new MarioPanel(l.get(1).getName(), l.get(1).getPrix()+"$", " Courte", " "+l.get(1).getInfoActuelle().getDefense(), " "+l.get(1).getInfoActuelle().getAttaque()));
        StarMario.add(new MarioPanel(l.get(4).getName(), l.get(4).getPrix()+"$", " Courte", " "+l.get(4).getInfoActuelle().getDefense(), " "+l.get(4).getInfoActuelle().getAttaque()));

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

        Zombie1 z1 = new Zombie1(1000);
        Zombie2 z2 = new Zombie2(1000);
        Zombie3 z3 = new Zombie3(1000);
        Zombie4 z4 = new Zombie4(1000);

        zombie1.add(new ZombiePanel(z1.getName(), " Courte", " "+ z1.getInfoActuelle().getDefense(), " "+z1.getInfoActuelle().getAttaque()));
        zombie2.add(new ZombiePanel(z2.getName(), " Courte", " "+ z2.getInfoActuelle().getDefense(), " "+z2.getInfoActuelle().getAttaque()));
        zombie3.add(new ZombiePanel(z3.getName(), " Courte", " "+ z3.getInfoActuelle().getDefense(), " "+z3.getInfoActuelle().getAttaque()));
        Zombie.add(new ZombiePanel(z4.getName(), " Courte", " "+ z4.getInfoActuelle().getDefense(), " "+z4.getInfoActuelle().getAttaque()));

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

        JLabel attackTypeLabel = new JLabel("Attack Type:"+attackType  );
        attackTypeLabel.setFont(loadMarioFont().deriveFont(Font.PLAIN, 18));
        attackTypeLabel.setForeground(Color.WHITE);
        attackTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(attackTypeLabel);

        JLabel defenseTypeLabel = new JLabel("Defense:"+defenseType  );
        defenseTypeLabel.setFont(loadMarioFont().deriveFont(Font.PLAIN, 18));
        defenseTypeLabel.setForeground(Color.WHITE);
        defenseTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(defenseTypeLabel);

        JLabel attackStrengthLabel = new JLabel("Attack:"+attackStrength );
        attackStrengthLabel.setFont(loadMarioFont().deriveFont(Font.PLAIN, 18));
        attackStrengthLabel.setForeground(Color.WHITE);
        attackStrengthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        attackStrengthLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
        add(attackStrengthLabel);
    }
}




    private class ZombiePanel extends JPanel {
        public ZombiePanel(String name, String attackType, String defenseType, String attackStrength) {
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
    
    
            JLabel attackTypeLabel = new JLabel("Attack Type: " + attackType );
            attackTypeLabel.setFont(loadMarioFont().deriveFont(Font.PLAIN, 18));
            attackTypeLabel.setForeground(Color.WHITE);
            attackTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(attackTypeLabel);
    
            JLabel defenseTypeLabel = new JLabel("Defense: "  + defenseType);
            defenseTypeLabel.setFont(loadMarioFont().deriveFont(Font.PLAIN, 18));
            defenseTypeLabel.setForeground(Color.WHITE);
            defenseTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(defenseTypeLabel);
    
            JLabel attackStrengthLabel = new JLabel("Attack: "+ attackStrength );
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

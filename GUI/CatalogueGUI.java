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
        titlePanel.setBorder(new EmptyBorder(10, 90, 5, 20));
        
        // Catalogue Panel
        JPanel createCatalogueMario = createCatalogueMario();
        
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
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.weighty = 1.0; // Cette ligne ajoute du poids à la cellule pour prendre l'espace disponible
        centralPanel.add(boutonPanel, gbc);
        add(centralPanel, BorderLayout.CENTER);
    }

    public JPanel createCatalogueMario() {
        JPanel cataloguePanel = new JPanel();
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

        cataloguePanel.add(BasicMario);
        cataloguePanel.add(FireMario);
        cataloguePanel.add(BigMario);
        cataloguePanel.add(WallBrick);
        cataloguePanel.add(StarMario);
        return cataloguePanel;
    }

    public void catalogueZombie(){}

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

            ImageIcon icon = new ImageIcon(getClass().getResource(name+".png"));
            Image image = icon.getImage();
            int panelSize = 150;
            Image scaledImage = image.getScaledInstance(panelSize, panelSize, Image.SCALE_SMOOTH);
            JLabel label = new JLabel();
            label.setIcon(icon);
            add(new JLabel(new ImageIcon(scaledImage)));
            add(new JLabel(name));
            add(new JLabel(price));
            add(new JLabel("Attack Type: "  ));
            add(new JLabel("Defense Type: "  ));
            add(new JLabel("Attack Strength: " ));
        }
    }

    private class ZombiePanel extends JPanel {
        public ZombiePanel(String name, String price, String attackType, String defenseType, String attackStrength) {
            setOpaque(true);
            setBackground(new Color(205, 55, 35, 255));
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            ImageIcon icon = new ImageIcon(getClass().getResource(name+".png"));
            Image image = icon.getImage();
            int panelSize = 150;
            Image scaledImage = image.getScaledInstance(panelSize, panelSize, Image.SCALE_SMOOTH);
            JLabel label = new JLabel();
            label.setIcon(icon);
            add(new JLabel(new ImageIcon(scaledImage)));
            add(new JLabel(name));
            add(new JLabel(price));
            add(new JLabel("Attack Type: "  ));
            add(new JLabel("Defense Type: "  ));
            add(new JLabel("Attack Strength: " ));
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
